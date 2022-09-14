package com.felix.gorenganku.ui.detail

import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.felix.gorenganku.R
import com.felix.gorenganku.databinding.ActivityDetailBinding
import com.felix.gorenganku.ui.base.BaseActivity
import com.felix.gorenganku.ui.home.MainActivity
import com.felix.gorenganku.ui.home.DetailDataParcelable
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.chip.Chip

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun getViewBinding() = ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getParcelableExtra<DetailDataParcelable>(MainActivity.OBJECT_PARCELABLE)

        binding.apply {
            appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                    binding.ivBack.setImageResource(R.drawable.ic_baseline_chevron_left_black_36)
                } else {
                    binding.ivBack.setImageResource(R.drawable.ic_baseline_chevron_left_white_36)
                }
            })

            if (data?.image!!.isNotEmpty()) {
                Glide.with(root).load(data.image[0])
                    .into(ivFood)
            } else {
                Glide.with(root).load("https://cdn2.iconfinder.com/data/icons/basic-ui-set-3-2/64/Basic_ui_3-26-512.png")
                    .into(ivFood)
            }

            if (data.rating != "null") {
                tvRating.text = data.rating
            } else {
                tvRating.text = "-"
            }

            if (data.title != "null") {
                tvTitle.text = data.title
            } else {
                tvTitle.text = "Title not found"
            }

            if (data.description != null) {
                tvSummary.text = data.description
            } else {
                tvSummary.text = "Description not found"
            }

            Log.d("TAG", "onCreate: ${data.ingredient}")



            ivBack.setOnClickListener {
                onBackPressed()
            }
        }

        if (data?.ingredient != null) {
            for (i in data?.ingredient?.indices!!) {
                val chip = Chip(this)
                chip.text = data.ingredient[i]
                chip.isClickable = false
                chip.isCheckable = false
                chip.isCloseIconVisible = false
                chip.isChipIconVisible = false
                chip.isFocusable = false
                chip.isFocusableInTouchMode = false
                chip.isLongClickable = false
                chip.chipBackgroundColor = resources.getColorStateList(R.color.secondary)
                chip.setTextAppearanceResource(R.style.ChipTextStyle_Selected)
                binding.cgIngridients.addView(chip)
            }
        }else{
            binding.tvIngridients.text = "Ingredients not found"
        }
    }
}