package bonch.dev.katemobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class GroupsAdapter(val list: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<GroupsAdapter.ItemPostHolder>() {

    private lateinit var clickPosition: ClickPosition

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
        holder.groupsSecondAdapter = GroupsSecondAdapter(listData, context, clickPosition)
        holder.recyclerView.adapter = holder.groupsSecondAdapter
    }


    override fun getItemCount(): Int {
        return list.size
    }


    inner class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var groupsSecondAdapter: GroupsSecondAdapter
        var recyclerView: RecyclerView = itemView.findViewById(R.id.groupsRecyclerSecond)

        //for clickable
        init {
            clickPosition = object : ClickPosition {
                override fun getPosition(position: Int) {
                    Toast.makeText(context, "$position", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}