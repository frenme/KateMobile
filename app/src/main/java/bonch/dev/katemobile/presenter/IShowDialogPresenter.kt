package bonch.dev.katemobile.presenter

import bonch.dev.katemobile.pojo.Message

interface IShowDialogPresenter {
    fun loadMessages()
    fun setMessagesRecyclerView(list: ArrayList<Message>)
    fun addMessage(message: String, date: String, isMyMessage: Boolean)
}