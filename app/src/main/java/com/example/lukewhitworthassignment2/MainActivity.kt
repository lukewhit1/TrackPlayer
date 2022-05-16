package com.example.lukewhitworthassignment2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup tabs
        val tab_toolbar = findViewById<Toolbar>(R.id.toolbar)
        val tab_viewpager = findViewById<ViewPager2>(R.id.tab_viewpager)
        val tab_tablayout = findViewById<TabLayout>(R.id.tab_tablayout)

        setSupportActionBar(tab_toolbar)
        setupViewPager(tab_viewpager)

        val titleList = arrayOf("Rock", "Classic", "Pop")
        TabLayoutMediator(tab_tablayout, tab_viewpager) { tab, position ->
            tab.text = titleList[position]
        }.attach()

        val imageResId = intArrayOf(
            R.drawable.ic_rock_and_roll_concert_svgrepo_com,
            R.drawable.ic_vinyl_svgrepo_com,
            R.drawable.ic_diamond_svgrepo_com
        )

        for (i in imageResId.indices) {
            tab_tablayout.getTabAt(i)?.setIcon(imageResId[i])
        }
    }

    private fun setupViewPager(viewpager: ViewPager2) {
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        adapter.addFragment(TrackFragment(0), "Rock")
        adapter.addFragment(TrackFragment(1), "Classic")
        adapter.addFragment(TrackFragment(2), "Pop")

        viewpager.adapter = adapter
    }

    class ViewPagerAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(supportFragmentManager, lifecycle) {

        var fragmentList1: ArrayList<Fragment> = ArrayList()
        var fragmentTitleList1: ArrayList<String> = ArrayList()

        override fun createFragment(position: Int): Fragment {
            return fragmentList1.get(position)
        }

        override fun getItemCount(): Int {
            return fragmentList1.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList1.add(fragment)
            fragmentTitleList1.add(title)
        }
    }

}