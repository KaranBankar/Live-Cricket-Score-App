package com.example.cricklive.Model

data class CricketData(
    val apikey: String,
    val `data`: List<Data>,
    val info: Info,
    val status: String
)