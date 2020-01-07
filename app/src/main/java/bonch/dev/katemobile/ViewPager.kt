package bonch.dev.katemobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import bonch.dev.katemobile.view.DialogsView
import bonch.dev.katemobile.view.ProfileView
import com.google.android.material.tabs.TabLayout

class ViewPager : Fragment() {


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
        viewPagerAdapter.addFragment(ProfileView(), "PROFILE")
        viewPagerAdapter.addFragment(News(), "NEWS")
        viewPagerAdapter.addFragment(DialogsView(), "MESSAGES")

        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabs)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

}