package bonch.dev.katemobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Groups : Fragment() {

    private lateinit var reviewsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.groups_fragment, container, false)

        initRecyclerGroups(view)
        return view
    }


    private fun initRecyclerGroups(view: View) {
        val list: ArrayList<String> = arrayListOf()
        for (i in 0..12) {
            list.add(
                "Hello, World!"
            )
        }

        reviewsRecyclerView = view.findViewById(R.id.groupsRecycler)
        reviewsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reviewsRecyclerView.adapter =
            GroupsAdapter(list, context!!)
    }
}