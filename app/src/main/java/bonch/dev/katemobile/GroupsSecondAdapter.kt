package bonch.dev.katemobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class GroupsSecondAdapter(val list: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<GroupsSecondAdapter.ItemPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.group_second_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {}


    class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}