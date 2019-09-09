package com.rba.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rba.food.util.Constant
import com.rba.food.util.snackbar

import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.content_detail.tvTitle

class DetailActivity : AppCompatActivity() {

    var id: String? = null
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        detailViewModel = ViewModelProviders.of(this,
            DetailViewModelFactory()
        ).get(DetailViewModel::class.java)
        val extras = intent.extras
        if (extras != null) {
            id = extras.getString(Constant.ID)
        }
        detailViewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(model: DetailViewModel.UiViewModel) {

        when (model) {
            is DetailViewModel.UiViewModel.ShowData -> {
                val detailModel = model.detailModel
                tvTitle.text = detailModel.name
                tvAddress.text = detailModel.address
                tvPhone.text = detailModel.phoneNumbers
                tvSchedule.text = detailModel.timings
            }

            is DetailViewModel.UiViewModel.ShowError -> {
                if (model.errorModel.code == 400 && model.errorModel.message == Constant.RESTAURANT_NOT_FOUND)
                    clData.snackbar(Constant.RESTAURANT_NOT_FOUND_MESSAGE)
                else
                    clData.snackbar(model.errorModel.message!!)
            }

            is DetailViewModel.UiViewModel.Refresh -> {
                detailViewModel.getData(id!!)

            }
        }
    }

}
