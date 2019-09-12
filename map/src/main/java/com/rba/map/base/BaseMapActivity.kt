package com.rba.map.base

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import com.rba.food.util.Constant
import com.rba.map.util.GpsUtil
import com.google.android.gms.maps.model.LatLng
import com.rba.model.model.RestaurantModel

abstract class BaseMapActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,
    GoogleMap.OnCameraIdleListener {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    abstract fun locationCallback(): LocationCallback
    var location: Location? = null
    private val REQUEST_CODE = 1000
    var isGPS = false
    var map: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            requestPermission()
        } else {
            buildLocationRequest()
            locationCallback()
            validatePermission()
        }
    }

    override fun onResume() {
        super.onResume()
        buildLocationRequest()
        locationCallback()
        //validatePermission()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    activateGPS()
                }
            }
        }
    }

    private fun activateGPS() {
        GpsUtil(this).turnOnGPS(object : GpsUtil.GpsListener {
            override fun onGpsStatus(isGPSEnable: Boolean) {
                isGPS = isGPSEnable
            }
        })
        validateUbication()
    }

    private fun checkPermission(): Boolean {
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED)
    }

    @SuppressLint("RestrictedApi")
    private fun buildLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 5000
        locationRequest.fastestInterval = 3000
        locationRequest.smallestDisplacement = 10f
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map?.setOnMarkerClickListener(this)
        map?.setOnCameraIdleListener(this)

        validateUbication()

        if (checkPermission()) {
            map?.isMyLocationEnabled = true
        }
    }

    private fun validateUbication() {
        if (checkPermission() && map?.isMyLocationEnabled == false) {
            map?.isMyLocationEnabled = true
        }
        if (location != null) {
            moveCamera(LatLng(location!!.latitude, location!!.longitude))
        }
    }

    fun moveCamera(latLng: LatLng) {
        map?.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        map?.animateCamera(CameraUpdateFactory.zoomTo(15f))
    }

    fun addMarkers(list: List<RestaurantModel>) {
        list.forEachIndexed { index, restaurantModel ->
            addMarker(
                LatLng(restaurantModel.latitude!!.toDouble(), restaurantModel.longitude!!.toDouble()),
                restaurantModel.name, index
            )
        }
    }

    private fun validatePermission() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(
                    this, Manifest.permission
                        .ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermission()
        } else {
            activateGPS()
        }

        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback(), Looper.myLooper())
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION
            ), REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == Constant.GPS) {
            isGPS = true
            validatePermission()
        }
    }

    private fun addMarker(latLng: LatLng, title: String?, position: Int) {
        val marker = map?.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        )
        marker?.tag = position
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        return false
    }

    override fun onCameraIdle() {
        //Do nothing
    }

}