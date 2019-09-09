package com.rba.model.model

class DetailModel {
    var id: String? = null
    var apikey: String? = null
    var name: String? = null
    var url: String? = null
    var address: String? = null
    var latitude: String? = null
    var longitude: String? = null
    var cuisines: String? = null
    var timings: String? = null
    var popularity: String? = null
    var thumb: String? = null
    var phoneNumbers: String? = null
    //var photos: List<PhotosModel>? = null

    class PhotosModel {
        var photo: List<PhotoModel>? = null

        class PhotoModel {
            var id: String? = null
            var url: String? = null
        }
    }
}