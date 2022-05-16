package com.example.lukewhitworthassignment2.model

data class TrackResponse(
    val results: List<Track>
)

data class Track(
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val artworkUrl60: String,
    val trackPrice: String,
    val previewUrl: String
    )
