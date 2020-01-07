package bonch.dev.katemobile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import bonch.dev.katemobile.R
import bonch.dev.katemobile.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class ViewPagerView : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.view_pager_fragment, container, false)!!

        initViewPager(view)

        return view
    }


    private fun initViewPager(view: View) {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabs)

        viewPagerAdapter.addFragment(ProfileView(), "PROFILE")
        viewPagerAdapter.addFragment(NewsView(), "NEWS")
        viewPagerAdapter.addFragment(DialogsView(), "MESSAGES")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

}