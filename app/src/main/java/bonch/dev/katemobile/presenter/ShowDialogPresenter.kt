package bonch.dev.katemobile.presenter

import android.content.Context
import android.widget.Toast
import bonch.dev.katemobile.MainActivity
import bonch.dev.katemobile.model.IShowDialogModel
import bonch.dev.katemobile.model.ShowDialogModel
import bonch.dev.katemobile.pojo.Message
import bonch.dev.katemobile.view.ShowDialogView


class ShowDialogPresenter(val context: Context, val showDialogView: ShowDialogView) :
    IShowDialogPresenter {

    private var iShowDialogModel: IShowDialogModel? = null

    override fun loadMessages() {
        if (MainActivity.isInternet(context)) {
            //get data and set recycler in DialogsView
            val list: ArrayList<Message> = iShowDialogModel!!.loadMessages()
            setMessagesRecyclerView(list)
        } else {
            Toast.makeText(context, "Check your Internet connection", Toast.LENGTH_LONG).show()
        }
    }


    override fun setMessagesRecyclerView(list: ArrayList<Message>) {
        showDialogView.initRecyclerMessages(list)
    }


    override fun addMessage(message: String, date: String, isMyMessage: Boolean) {
        val messageObj = Message(message, date, isMyMessage)
        showDialogView.addMessage(messageObj)
    }


    init {
        if (iShowDialogModel == null) {
            iShowDialogModel = ShowDialogModel()
        }
    }

}