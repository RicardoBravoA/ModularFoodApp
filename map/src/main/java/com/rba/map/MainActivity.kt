package com.rba.map

import android.os.Bundle

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.maps.SupportMapFragment
import com.rba.map.base.BaseMapActivity
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import android.widget.AbsListView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.rba.food.util.Constant
import com.rba.food.util.snackbar
import com.rba.model.model.RestaurantModel
import com.rba.navigation.Activity
import com.rba.navigation.intentTo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseMapActivity() {

    private lateinit var mainViewModel: MainViewModel
    private var mainAdapter: MainAdapter? = null
    private var list: List<RestaurantModel>? = null
    private var requestOnDemand = false
    private var notFound = false
    private var firstLocation = true

    override fun locationCallback(): LocationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult?) {
            super.onLocationResult(p0)
            location = p0!!.locations[p0.locations.size - 1]

            if (!requestOnDemand && !notFound) {
                getData(location?.latitude.toString(), location?.longitude.toString())
                requestOnDemand = true
            }
            //getData("40.6594835", "-74.023076")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        mainViewModel = ViewModelProviders.of(this, MainViewModelFactory()).get(MainViewModel::class.java)
        mainViewModel.model.observe(this, Observer(::updateUi))
        //mainViewModel.getData("40.6594835", "-74.023076")

        mainAdapter = MainAdapter(mainViewModel::onClickRestaurant)
        rvRestaurant.adapter = mainAdapter
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvRestaurant)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        rvRestaurant.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                val layoutManager = rvRestaurant.layoutManager
                val snapView = snapHelper.findSnapView(layoutManager)

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if (snapView != null && list != null) {
                        val restaurantModel = list!![layoutManager!!.getPosition(snapView)]
                        val latLng =
                            LatLng(restaurantModel.latitude!!.toDouble(), restaurantModel.longitude!!.toDouble())
                        moveCamera(latLng)
                    }

                }
            }
        })

        btnSearch.setOnClickListener {
            val latLng = map?.cameraPosition?.target
            getData(latLng?.latitude.toString(), latLng?.longitude.toString())
            it.visibility = View.GONE
            requestOnDemand = false
        }
    }

    private fun updateUi(model: MainViewModel.UiViewModel) {

        when (model) {
            is MainViewModel.UiViewModel.ShowData -> {
                this.list = model.list
                mainAdapter?.list = model.list
                addMarkers(model.list)
            }

            is MainViewModel.UiViewModel.ShowError -> {
                if (model.errorModel.code == 400 && model.errorModel.message == Constant.RESTAURANT_NOT_FOUND) {
                    clData.snackbar(Constant.RESTAURANT_NOT_FOUND_MESSAGE)
                    notFound = true
                } else {
                    clData.snackbar(model.errorModel.message!!)
                    notFound = false
                }
            }

            is MainViewModel.UiViewModel.Navigation -> {
                val intent = intentTo(Activity.Detail)
                intent?.putExtra(Constant.ID, model.restaurantModel.id)
                startActivity(intent)
            }

            is MainViewModel.UiViewModel.Refresh -> {
                //mainViewModel.getData("40.6594835", "-74.023076")
                if (isGPS) getData()

            }
        }
    }

    private fun getData(latitude: String? = null, longitude: String? = null) {
        if (location != null && latitude != null && longitude != null) {
            mainViewModel.getData(latitude, longitude)
            if (firstLocation) {
                moveCamera(LatLng(latitude.toDouble(), longitude.toDouble()))
                firstLocation = false
            }
        }
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        super.onMarkerClick(p0)
        rvRestaurant.scrollToPosition(p0?.tag as Int)
        return false
    }

    override fun onCameraIdle() {
        super.onCameraIdle()
        btnSearch.visibility = View.VISIBLE
    }

}