package com.example.mct_faha.network.interfaces

data class ItunesData(val wrapperType: String, val artistName: String, val trackName: String, val trackViewUrl: String) {
//    var wrapperType: String? = ""
    var kind: String? = ""
    var artistId: String? = ""
    var collectionId: String? = ""
    var trackId: String? = ""
//    var artistName: String? = ""
    var collectionName: String? = ""
//    var trackName: String? = ""
    var collectionCensoredName: String? = ""
    var trackCensoredName: String? = ""
    var artistViewUrl: String? = ""
    var collectionViewUrl: String? = ""
//    var trackViewUrl: String? = ""
    var previewUrl: String? = ""
    var artworkUrl30: String? = ""
    var artworkUrl60: String? = ""
    var artworkUrl100: String? = ""
    var collectionPrice: String? = ""
    var trackPrice: String? = ""
    var releaseDate: String? = ""
    var collectionExplicitness: String? = ""
    var trackExplicitness: String? = ""
    var discCount: Int? = 0
    var discNumber: Int? = 0
    var trackCount: Int? = 0
    var trackNumber: Int? = 0
    var trackTimeMillis: Int? = 0
    var country: String? = ""
    var currency: String? = ""
    var primaryGenreName: String? = ""
    var isStreamable: Boolean = false
}