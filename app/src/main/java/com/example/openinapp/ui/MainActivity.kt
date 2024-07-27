package com.example.openinapp.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.openinapp.R
import com.example.openinapp.viewmodel.DashboardViewModel
import com.google.android.material.tabs.TabLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        val greetingText = findViewById<TextView>(R.id.greetingText)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        // Set greeting based on time
        greetingText.text = getGreetingMessage()

        // Setup ViewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TopLinksFragment(), "Top Links")
        adapter.addFragment(RecentLinksFragment(), "Recent Links")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        // Fetch dashboard data
        dashboardViewModel.fetchDashboardData()
    }

    private fun getGreetingMessage(): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return when (hour) {
            in 0..11 -> "Good Morning"
            in 12..16 -> "Good Afternoon"
            else -> "Good Evening"
        }
    }
}
