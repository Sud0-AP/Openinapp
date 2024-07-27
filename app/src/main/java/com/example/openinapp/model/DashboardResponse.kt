package com.example.openinapp.model

data class DashboardResponse(
    val topLinks: List<Link>,
    val recentLinks: List<Link>
)

data class Link(
    val id: Int,
    val url: String,
    val clicks: Int
)
