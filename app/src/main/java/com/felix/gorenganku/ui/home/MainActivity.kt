package com.felix.gorenganku.ui.home

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.felix.gorenganku.data.api.model.list.GetFeedsListResponse
import com.felix.gorenganku.databinding.ActivityMainBinding
import com.felix.gorenganku.resource.Status
import com.felix.gorenganku.ui.base.BaseActivity
import com.felix.gorenganku.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var progressDialog: ProgressDialog
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var detailAdapter: DetailAdapter

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteAdapter = FavoriteAdapter(object : FavoriteAdapter.OnClickListener{
            override fun onClickItem(data: GetFeedsListResponse.Feed) {
                val id = data.content.details?.id
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("id",id)
                startActivity(intent)
            }
        })

        detailAdapter = DetailAdapter(object : DetailAdapter.OnClickListener{
            override fun onClickItem(data: GetFeedsListResponse.Feed) {
                val id = data.content.details?.id
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("id",id)
                startActivity(intent)
            }
        })

        progressDialog = ProgressDialog(this)
        binding.rvFavorite.adapter = favoriteAdapter
        binding.rvShowDetail.adapter = detailAdapter
        setupObservers()
        viewModel.getAllFavorite()
        viewModel.getAllDetail()
    }

    private fun setupObservers() {
        viewModel.dataFavorite.observe(this){resource ->
            when(resource.status){
                Status.SUCCESS -> {
                    Log.d("Status","Success")
                    binding.apply {
                        tvFavorite.visibility = View.VISIBLE
                        tvShowDetail.visibility = View.VISIBLE
                    }
                    progressDialog.dismiss()
                    favoriteAdapter.submitData(resource.data?.body()?.feed)
                }
                Status.LOADING -> {
                    Log.d("Status","Loading")
                    progressDialog.show()
                }
                Status.ERROR -> {
                    Log.d("Status","Error ${resource.message}")
                    progressDialog.dismiss()
                }
            }
        }

        viewModel.dataDetail.observe(this){resource ->
            when(resource.status){
                Status.SUCCESS -> {
                    Log.d("Status","Success")
                    progressDialog.dismiss()
                    detailAdapter.submitData(resource.data?.body()?.feed)
                }
                Status.LOADING -> {
                    Log.d("Status","Loading")
                    progressDialog.show()
                }
                Status.ERROR -> {
                    Log.d("Status","Error ${resource.message}")
                    progressDialog.dismiss()
                }
            }
        }
    }
}