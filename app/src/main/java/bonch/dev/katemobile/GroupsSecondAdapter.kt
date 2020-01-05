package bonch.dev.katemobile

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup





class GroupsSecondAdapter(val list: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<GroupsSecondAdapter.ItemPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.group2_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {


    }


    class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //        private val nameDialog = itemView.findViewById<TextView>(R.id.name_dialog)
//        private val textMessage = itemView.findViewById<TextView>(R.id.text_messages)
//        private val date = itemView.findViewById<TextView>(R.id.date)
//        fun bind(post: DialogsModel) {
//            nameDialog.text = post.nameDialog
//            textMessage.text = post.textMessage
//            date.text = post.date
//        }

    }
}