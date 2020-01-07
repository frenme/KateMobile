package bonch.dev.katemobile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.adapters.VideosAdapter
import bonch.dev.katemobile.pojo.Video
import bonch.dev.katemobile.presenter.IVideosPresenter
import bonch.dev.katemobile.presenter.VideosPresenter
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter

/**
 * Using the library SectionedRecyclerViewAdapter to work with sectors of RecyclerView
 * */

class VideosView : Fragment(), IVideosView {

    //declare View here to use Snacks
    private lateinit var viewFragment: View
    private val SECTION1 = "Новые видео"
    private val SECTION2 = "Просмотреть позже"
    private var iVideosPresenter: IVideosPresenter? = null
    private lateinit var parentLayout: LinearLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var sectionedAdapter: SectionedRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.video_fragment, container, false)
        sectionedAdapter = SectionedRecyclerViewAdapter()

        if (iVideosPresenter == null) {
            iVideosPresenter = VideosPresenter(context!!, this)
        }

        initialize()
        iVideosPresenter!!.loadVideos()


        return viewFragment
    }


    override fun initRecyclerVideos(list: ArrayList<Video>) {
        //init TWO sector in RecyclerView
        sectionedAdapter.addSection(
            VideosAdapter(
                SECTION1,
                list, this, context!!
            )
        )

        sectionedAdapter.addSection(
            VideosAdapter(
                SECTION2,
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
    }


    override fun initialize() {
        parentLayout = viewFragment.findViewById(R.id.linearLayoutVideo)
        recyclerView = viewFragment.findViewById(R.id.videoRecycler)
        gridLayoutManager = GridLayoutManager(context, 2)
    }


    //with click on Header Section, sector will open/close
    override fun onHeaderRootViewClicked(section: VideosAdapter) {
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
        iVideosPresenter!!.onItemViewClick(
            parentLayout,
            sectionedAdapter.getPositionInSection(itemAdapterPosition),
            sectionTitle
        )
    }
}
