package com.example.openinapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.openinapp.R
import com.example.openinapp.viewmodel.DashboardViewModel
import com.github.mikephil.charting.charts.LineChart
import kotlinx.android.synthetic.main.fragment_top_links.*

class TopLinksFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardViewModel = ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
        lineChart = view.findViewById(R.id.lineChart)

        dashboardViewModel.dashboardData.observe(viewLifecycleOwner, Observer { data ->
            // Update chart and listview with data
        })
    }
}
