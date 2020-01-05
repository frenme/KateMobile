package bonch.dev.katemobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter

/**
 * Using the library SectionedRecyclerViewAdapter to work with sectors of RecyclerView
 * */

class Video : Fragment(), ClickListenerSections {

    //declare View here to use Snacks
    private lateinit var viewFragment: View
    private lateinit var sectionedAdapter: SectionedRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.video_fragment, container, false)
        sectionedAdapter = SectionedRecyclerViewAdapter()

        val list: ArrayList<String> = arrayListOf()
        val recyclerView = viewFragment.findViewById<RecyclerView>(R.id.videoRecycler)
        val gridLayoutManager = GridLayoutManager(context, 2)


        for (i in 0..10) {
            list.add("Some video")
        }

        sectionedAdapter.addSection(
            VideoAdapter(
                "Новые видео",
                list, this, context!!
            )
        )

        sectionedAdapter.addSection(
            VideoAdapter(
                "Просмотреть позже",
                list, this, context!!
            )
        )

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (sectionedAdapter.getSectionItemViewType(position) == SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER) {
                    2
                } else 1
            }
        }
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = sectionedAdapter

        return viewFragment
    }


    //with click on Header Section, sector will open/close
    override fun onHeaderRootViewClicked(sectionTitle: String, section: VideoAdapter) {
        val wasExpanded = section.isExpanded
        val sectionAdapter = sectionedAdapter.getAdapterForSection(section)
        val previousItemsTotal = section.contentItemsTotal

        section.isExpanded = (!wasExpanded)
        sectionAdapter.notifyHeaderChanged()

        if (wasExpanded) {
            sectionAdapter.notifyItemRangeRemoved(0, previousItemsTotal)
        } else {
            sectionAdapter.notifyAllItemsInserted()
        }
    }


    //with click on Item Section, show Snack
    override fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int) {
        val parentLayout = viewFragment.findViewById<LinearLayout>(R.id.linearLayoutVideo)

        Snackbar.make(
            parentLayout, String.format(
                "Clicked on position #%s of Section %s",
                sectionedAdapter.getPositionInSection(itemAdapterPosition),
                sectionTitle
            ), Snackbar.LENGTH_LONG
        ).show()

    }
}
