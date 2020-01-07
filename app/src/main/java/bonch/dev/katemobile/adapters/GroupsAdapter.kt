package bonch.dev.katemobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.pojo.Group


class GroupsAdapter(val list: ArrayList<Group>, val context: Context) :
    RecyclerView.Adapter<GroupsAdapter.ItemPostHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.group_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {
        val layoutManager: LinearLayoutManager
        val listData = arrayListOf<String>()


        //add 10 elements for show
        for (i in 0..10) {
            listData.add("")
        }

        //init Second adapter
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.layoutManager = layoutManager
        holder.groupsSecondAdapter =
            GroupsSecondAdapter(listData, context)
        holder.recyclerView.adapter = holder.groupsSecondAdapter
    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var groupsSecondAdapter: GroupsSecondAdapter
        var recyclerView: RecyclerView = itemView.findViewById(R.id.groupsRecyclerSecond)

    }
}