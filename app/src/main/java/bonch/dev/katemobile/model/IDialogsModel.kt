package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Dialog

interface IDialogsModel {
    fun loadDialogs(): ArrayList<Dialog>
}