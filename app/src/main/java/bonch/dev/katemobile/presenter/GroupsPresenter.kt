package bonch.dev.katemobile.presenter

import android.content.Context
import android.widget.Toast
import bonch.dev.katemobile.MainActivity
import bonch.dev.katemobile.model.GroupsModel
import bonch.dev.katemobile.model.IGroupsModel
import bonch.dev.katemobile.pojo.Group
import bonch.dev.katemobile.view.IGroupsView

class GroupsPresenter(val context: Context, val iGroupsView: IGroupsView) : IGroupsPresenter {

    private var iGroupsModel: IGroupsModel? = null

    override fun loadGroups() {

        if (MainActivity.isInternet(context)) {
            val list: ArrayList<Group> = iGroupsModel!!.loadGroups()
            setGroupRecyclerView(list)
        } else {
            Toast.makeText(context, "Check your Internet connection", Toast.LENGTH_LONG).show()
        }

    }


    override fun setGroupRecyclerView(list: ArrayList<Group>) {
        iGroupsView.initRecyclerGroups(list)
    }


    init {
        if(iGroupsModel == null){
            iGroupsModel = GroupsModel()
        }
    }


}