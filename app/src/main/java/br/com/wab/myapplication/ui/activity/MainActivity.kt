package br.com.wab.myapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.wab.myapplication.R
import br.com.wab.myapplication.model.GenericResultsResponse
import br.com.wab.myapplication.ui.recyclerview.adapter.BerryAdapter
import br.com.wab.myapplication.ui.viewmodel.BerryViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: BerryViewModel

    private val berryAdapter by lazy {
        BerryAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(BerryViewModel::class.java)
        berries_recycler.adapter = berryAdapter
        berryAdapter.onClickItem = this::openBerryDetails

    }

    private fun openBerryDetails(item : GenericResultsResponse){
        val intent = Intent(this, BerryDetailsActivity::class.java)
        var id = item.url?.substringAfter("berry/")
        id = id?.substringBefore("/")
        intent.putExtra("id",id)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        getBerriesList()
    }

    private fun getBerriesList(){
        viewModel.berries().observe(this, Observer {
                berryAdapter.updateList(it)
            })
    }
}
