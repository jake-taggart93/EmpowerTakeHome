package com.example.empowertakehome

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.empowertakehome.domain.model.Beneficiary
import com.example.empowertakehome.ui.adapter.BeneficiariesRecyclerViewAdapter
import com.example.empowertakehome.ui.viewmodel.BeneficiariesViewModel

class MainActivity : AppCompatActivity() {

    // Obtain viewmodel
    private val viewModel: BeneficiariesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // find view for RV
        val rvBeneficiaries = findViewById<RecyclerView>(R.id.rv_beneficiaries)

        // set onClickListener for each item in RV
        val rvItemClickListener: (Beneficiary) -> Unit = {
            viewModel.onBeneficiarySelected(it)
            supportFragmentManager
                .beginTransaction()
                .add(BeneficiaryDetailFragment(), BeneficiaryDetailFragment::class.simpleName)
                .commit()
        }

        // Create adapter for RV and set
        val adapter = BeneficiariesRecyclerViewAdapter(
            viewModel.beneficiaries.value ?: emptyList(),
            rvItemClickListener
        )
        rvBeneficiaries.adapter = adapter

        // Observe LiveData and update RV data (this doesn't apply in this challenge, but is to demonstrate an approach for a dynamic data situation)
        viewModel.beneficiaries.observe(this) {
            adapter.updateBeneficiaries(it)
        }
    }
}