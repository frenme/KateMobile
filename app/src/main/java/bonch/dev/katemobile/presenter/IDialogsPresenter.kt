package bonch.dev.katemobile.presenter

import bonch.dev.katemobile.pojo.Dialog

interface IDialogsPresenter {
    fun loadDialogs()
    fun setDialogsRecyclerView(list: ArrayList<Dialog>)
    fun clickDialog(idDialog: Int)
}