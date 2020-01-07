package bonch.dev.katemobile.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.pojo.Message

class MessagesAdapter(val messageList: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val OTHER_MESSAGE = 0
    private val MY_MESSAGE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == MY_MESSAGE) {
            MyMessageViewHolder(
                (LayoutInflater.from(parent.context).inflate(
                    R.layout.my_message_item,
                    parent,
                    false
                ))
            )
        } else {
            OtherMessageViewHolder(
                (LayoutInflater.from(parent.context).inflate(
                    R.layout.other_message_item,
                    parent,
                    false
                ))
            )
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList[position].isMyMessage!!) {
            MY_MESSAGE
        } else OTHER_MESSAGE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if (getItemViewType(position) == MY_MESSAGE) {
            (holder as MyMessageViewHolder).bind(position)
        } else {
            (holder as OtherMessageViewHolder).bind(position)
        }
    }

    inner class MyMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val message: TextView = view.findViewById(R.id.message)
        private val date: TextView = view.findViewById(R.id.date)
        fun bind(position: Int) {
            message.text = messageList[position].message
            date.text = "21:12"
        }

    }

    inner class OtherMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val message: TextView = view.findViewById(R.id.message)
        private val date: TextView = view.findViewById(R.id.date)
        fun bind(position: Int) {
            message.text = messageList[position].message
            date.text = "12:12"
        }

    }

}
