package com.rba.model.entity.response

class DetailResponse {
    var id: String? = null
    var apikey: String? = null
    var name: String? = null
    var url: String? = null
    var latitude: String? = null
    var longitude: String? = null
    var cuisines: String? = null
    var timings: String? = null
    var popularity: String? = null
    var thumb: String? = null
    var phoneNumbers: String? = null
    var photos: List<PhotosResponse>? = null

    class PhotosResponse {
        var photo: List<PhotoResponse>? = null

        class PhotoResponse {
            var id: String? = null
            var url: String? = null
        }
    }
}