package bonch.dev.katemobile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.adapters.MessagesAdapter
import bonch.dev.katemobile.pojo.Message
import bonch.dev.katemobile.presenter.IShowDialogPresenter
import bonch.dev.katemobile.presenter.ShowDialogPresenter


class ShowDialogView : Fragment(), IShowDialogView {

    private var iShowDialogPresenter: IShowDialogPresenter? = null
    private lateinit var messageTextEdit: EditText
    private lateinit var sendBtn: ImageButton
    private lateinit var messagesRecycler: RecyclerView
    private lateinit var messagesList: ArrayList<Message>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.show_dialog_fragment, container, false)

        if (iShowDialogPresenter == null) {
            iShowDialogPresenter = ShowDialogPresenter(context!!, this)
        }

        initialize(view)
        setListeners()
        iShowDialogPresenter!!.loadMessages()

        scrollBottom()

        return view
    }


    override fun initialize(view: View) {
        messagesList = arrayListOf()
        sendBtn = view.findViewById(R.id.sendBtn)
        messageTextEdit = view.findViewById(R.id.messageTextEdit)
        messagesRecycler = view.findViewById(R.id.messagesRecycler)
    }


    override fun setListeners() {
        sendBtn.setOnClickListener {
            if (messageTextEdit.text.toString().trim() != "") {
                iShowDialogPresenter!!.addMessage(messageTextEdit.text.toString().trim(), "23:23", true)
                messageTextEdit.setText("")
                scrollBottom()
            }
        }
    }


    override fun initRecyclerMessages(dataMessages: ArrayList<Message>) {
        messagesList.addAll(dataMessages)
        messagesRecycler.layoutManager = LinearLayoutManager(context)
        messagesRecycler.adapter = MessagesAdapter(messagesList)
    }


    override fun addMessage(message: Message) {
        messagesList.add(message)
    }


    private fun scrollBottom() {
        messagesRecycler.scrollToPosition(messagesList.count() - 1)
    }
}
