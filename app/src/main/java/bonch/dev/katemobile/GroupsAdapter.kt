package bonch.dev.katemobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GroupsAdapter(val list: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<GroupsAdapter.ItemPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.group_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {


        val list2 = arrayListOf<String>()

        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.layoutManager = mLayoutManager
        holder.recyclerView.itemAnimator = DefaultItemAnimator()

        for (i in 0..10) {
            list2.add("FOOOLEG222222")
        }


//        holder.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                val firstVisiblePosition = mLayoutManager.findFirstVisibleItemPosition()
//                if (firstVisiblePosition >= 0)
//                    holder.monthName.setText(listCal.get(firstVisiblePosition + 3).getMonth())
//            }
//        })

        holder.recyclerView.setOnClickListener(View.OnClickListener { })


        holder.groupsSecondAdapter = GroupsSecondAdapter(list2, context)
        holder.recyclerView.adapter = holder.groupsSecondAdapter
    }


    override fun getItemCount(): Int {
        return list.size
    }


    class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var groupsSecondAdapter: GroupsSecondAdapter
        var recyclerView: RecyclerView = itemView.findViewById(R.id.groupsRecycler2)

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