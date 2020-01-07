package bonch.dev.katemobile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.adapters.GroupsAdapter
import bonch.dev.katemobile.pojo.Group
import bonch.dev.katemobile.presenter.GroupsPresenter
import bonch.dev.katemobile.presenter.IGroupsPresenter

class GroupsView : Fragment(), IGroupsView {

    private lateinit var reviewsRecyclerView: RecyclerView
    private var iGroupsPresenter: IGroupsPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.groups_fragment, container, false)


        if(iGroupsPresenter == null){
            iGroupsPresenter = GroupsPresenter(context!!, this)
        }

        initViews(view)
        iGroupsPresenter!!.loadGroups()

        return view
    }


    override fun initRecyclerGroups(list: ArrayList<Group>) {
        reviewsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reviewsRecyclerView.adapter =
            GroupsAdapter(list, context!!)
    }


    override fun initViews(view: View){
        reviewsRecyclerView = view.findViewById(R.id.groupsRecycler)
    }
}