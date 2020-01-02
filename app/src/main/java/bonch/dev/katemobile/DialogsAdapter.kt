package bonch.dev.katemobile


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DialogsAdapter(private val list: ArrayList<DialogsModel>, val context: Context) :
    RecyclerView.Adapter<DialogsAdapter.ItemPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.dialog_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }

    class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameDialog = itemView.findViewById<TextView>(R.id.name_dialog)
        private val textMessage = itemView.findViewById<TextView>(R.id.text_messages)
        private val date = itemView.findViewById<TextView>(R.id.date)
        fun bind(post: DialogsModel) {
            nameDialog.text = post.nameDialog
            textMessage.text = post.textMessage
            date.text = post.date
        }
    }


}



