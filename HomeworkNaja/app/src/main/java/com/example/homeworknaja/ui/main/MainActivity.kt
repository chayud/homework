package com.example.homeworknaja.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homeworknaja.adapter.SimpleItemAdapter
import com.example.homeworknaja.databinding.ActivityMainBinding
import com.example.homeworknaja.model.SimpleModel
import com.example.homeworknaja.ui.base.BaseActivity
import com.example.homeworknaja.ui.detail.DetailActivity


class MainActivity : BaseActivity<MainActivityViewModel>(),MainActivityNavigator{
    override fun tag(): String  = MainActivity::class.java.simpleName

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var viewModel: MainActivityViewModel? = null

    private var simpleAdapter: SimpleItemAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewModel = ViewModelProvider.NewInstanceFactory().create(MainActivityViewModel::class.java)
        viewModel?.setNavigator(this)
        if (savedInstanceState == null) {
            setUpView()
            initial()
        }

    }

    override fun setUpView() {
        simpleAdapter = SimpleItemAdapter(this@MainActivity)
        viewBinding.mainScreenRecyclerView.apply {
            adapter = simpleAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        simpleAdapter!!.itemonclick={
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("itemView",it)
           this.startActivity(intent)
        }

    }

    override fun initial() {

        getSimpleList()

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun getSimpleList() {
        viewModel?.getSimpleList()
    }

    override fun getSimpleListSuccess(simpleList2: MutableList<SimpleModel>) {
        simpleAdapter?.submitList(simpleList2)
    }

    override fun getSimpleListFailed(exception: Exception) {

    }


}