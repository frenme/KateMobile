package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Message

interface IShowDialogModel{
    fun loadMessages() : ArrayList<Message>
}