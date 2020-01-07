package bonch.dev.katemobile.view

import android.view.View
import bonch.dev.katemobile.pojo.Message

interface IShowDialogView {
    fun initialize(view: View)
    fun setListeners()
    fun initRecyclerMessages(dataMessages: ArrayList<Message>)
    fun addMessage(message: Message)
}