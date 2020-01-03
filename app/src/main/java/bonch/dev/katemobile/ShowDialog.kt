package bonch.dev.katemobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ShowDialog : Fragment() {

    private lateinit var messageTextEdit: EditText
    private lateinit var sendBtn: ImageButton
    private lateinit var messagesRecycler: RecyclerView
    private lateinit var messagesList: MutableList<MessageModel>
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.show_dialog_fragment, container, false)!!

        initialize(view)
        setListeners()

        val dataMessages: MutableList<MessageModel> = getMessages()
        initRecyclerView(dataMessages)
        scrollBottom()

        return view
    }


    private fun initialize(view: View) {
        messagesList = mutableListOf()
        layoutManager = LinearLayoutManager(context)

        sendBtn = view.findViewById(R.id.sendBtn)
        messageTextEdit = view.findViewById(R.id.messageTextEdit)
        messagesRecycler = view.findViewById(R.id.messagesRecycler)
    }


    private fun setListeners() {
        sendBtn.setOnClickListener {
            if (messageTextEdit.text.toString().trim() != "") {
                addMessage(messageTextEdit.text.toString().trim(), "23:23", true)
                messageTextEdit.setText("")
                scrollBottom()
            }
        }
    }


    private fun initRecyclerView(dataMessages: MutableList<MessageModel>) {
        messagesList.addAll(dataMessages)
        messagesRecycler.layoutManager = layoutManager
        messagesRecycler.adapter = MessagesAdapter(messagesList)
    }

    private fun addMessage(message: String, date: String, isMyMessage: Boolean) {
        messagesList.add(MessageModel(message, date, isMyMessage))
    }


    private fun getMessages(): MutableList<MessageModel> {
        val dataMessages: MutableList<MessageModel> = mutableListOf()
        for (i in 1..25) {
            if (i % 2 == 0) {
                dataMessages.add(MessageModel("Привет, как дела?", "21:23", true))
            } else {
                dataMessages.add(MessageModel("Привет, как дела?", "21:23", false))
            }
        }
        return dataMessages

    }

    private fun scrollBottom() {
        messagesRecycler.scrollToPosition(messagesList.count() - 1)
    }
}
