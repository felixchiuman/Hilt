package com.felix.gorenganku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.felix.gorenganku.databinding.ActivityDetailBinding
import com.felix.gorenganku.ui.base.BaseActivity

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun getViewBinding() = ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}