package com.felix.gorenganku.ui.home

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.felix.gorenganku.data.api.service.list.GetFeedsListResponse
import com.felix.gorenganku.databinding.ActivityMainBinding
import com.felix.gorenganku.resource.Status
import com.felix.gorenganku.ui.base.BaseActivity
import com.felix.gorenganku.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var progressDialog: ProgressDialog
    private lateinit var adapter: FavoriteAdapter

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressDialog = ProgressDialog(this)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.dataFavorite.observe(this){resource ->
            when(resource.status){
                Status.SUCCESS -> {
                    Log.d("Status","Success")
                    progressDialog.dismiss()
                    val adapter = FavoriteAdapter(object : FavoriteAdapter.OnClickListener{
                        override fun onClickItem(data: GetFeedsListResponse.Feed.Content.Details) {
                            var id = data.id
                            val intent = Intent(this@MainActivity, DetailActivity::class.java)
                            intent.putExtra("id",id)
                            startActivity(intent)
                        }
                    })
                    adapter.submitData(resource.data?.)
                    binding.rvFavorite.adapter = adapter
                }
                Status.LOADING -> {
                    Log.d("Status","Loading")
                    progressDialog.show()
                }
                Status.ERROR -> {
                    Log.d("Status","Error")
                    progressDialog.dismiss()
                }
            }
        }
    }
}