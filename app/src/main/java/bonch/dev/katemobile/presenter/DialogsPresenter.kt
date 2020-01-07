package bonch.dev.katemobile.presenter

import android.content.Context
import android.widget.Toast
import bonch.dev.katemobile.Constants.Companion.DIALOG
import bonch.dev.katemobile.MainActivity
import bonch.dev.katemobile.MainActivity.Companion.isInternet
import bonch.dev.katemobile.model.DialogsModel
import bonch.dev.katemobile.model.IDialogsModel
import bonch.dev.katemobile.pojo.Dialog
import bonch.dev.katemobile.view.DialogsView


class DialogsPresenter(val context: Context, val dialogsView: DialogsView, val mainActivity: MainActivity) : IDialogsPresenter {

    private var iDialogsModel: IDialogsModel? = null

    override fun loadDialogs() {
        if (isInternet(context)) {
            //get data and set recycler in DialogsView
            val list: ArrayList<Dialog> = iDialogsModel!!.loadDialogs()
            setDialogsRecyclerView(list)
        }else{
            Toast.makeText(context, "Check your Internet connection", Toast.LENGTH_LONG).show()
        }
    }

    override fun setDialogsRecyclerView(list: ArrayList<Dialog>) {
        dialogsView.initRecyclerDialogs(list)
    }

    override fun clickDialog(idDialog: Int) {
        mainActivity.replaceFragment(DIALOG)
    }

    init {
        if (iDialogsModel == null) {
            iDialogsModel = DialogsModel()
        }
    }
}