package com.example.empowertakehome

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.empowertakehome.ui.customview.BeneficiaryDetailView
import com.example.empowertakehome.ui.viewmodel.BeneficiariesViewModel

// Activity for showing detail view of each beneficiary when clicked from RecyclerView; please note TODO below
/*
TODO - Change to fragment implementation
    Note: Due to prior engagements I needed to keep and the resulting time constraint, I was unable to finish this portion as I would have liked to
*/
class BeneficiaryDetailActivity : AppCompatActivity() {
    private val viewModel: BeneficiariesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val view = BeneficiaryDetailView(this)
        view.setBeneficiary(viewModel.selectedBeneficiary)
        setContentView(view)
    }
}