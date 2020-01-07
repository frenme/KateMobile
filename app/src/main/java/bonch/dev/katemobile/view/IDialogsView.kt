package bonch.dev.katemobile.view

import android.view.View
import bonch.dev.katemobile.pojo.Dialog

interface IDialogsView {
    fun initRecyclerDialogs(list: ArrayList<Dialog>)
    fun initRecyclerDialogs(view: View)
}