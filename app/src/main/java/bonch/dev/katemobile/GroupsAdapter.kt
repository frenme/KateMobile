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
        val listData = arrayListOf<String>()

        //init Second adapter
        val mLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.layoutManager = mLayoutManager
        holder.recyclerView.itemAnimator = DefaultItemAnimator()

        for (i in 0..10) {
            listData.add("Hello, World!")
        }


        holder.groupsSecondAdapter = GroupsSecondAdapter(listData, context)
        holder.recyclerView.adapter = holder.groupsSecondAdapter
    }


    override fun getItemCount(): Int {
        return list.size
    }


    class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var groupsSecondAdapter: GroupsSecondAdapter
        var recyclerView: RecyclerView = itemView.findViewById(R.id.groupsRecyclerSecond)
    }
}