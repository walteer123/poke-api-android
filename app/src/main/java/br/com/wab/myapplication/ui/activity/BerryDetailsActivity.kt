package br.com.wab.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.wab.myapplication.R
import br.com.wab.myapplication.ui.viewmodel.BerryDetailsViewModel
import kotlinx.android.synthetic.main.activity_berry_details.*

class BerryDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: BerryDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berry_details)

        viewModel = ViewModelProviders.of(this).get(BerryDetailsViewModel::class.java)


    }

    override fun onResume() {
        super.onResume()
        val id = intent?.extras?.get("id") as String
        getBerryById(id)
    }

    private fun getBerryById(id: String) {
        viewModel.getBerry(
            id.toInt(),
            onStarted = {
                progress_berry_details.visibility = View.VISIBLE
            })
            .observe(this, Observer {
                progress_berry_details.visibility = View.GONE
                Log.d("Busca", "Carregou Berry! ${it.id}")
            })
    }
}
