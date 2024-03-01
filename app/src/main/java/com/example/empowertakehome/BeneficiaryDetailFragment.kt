package com.example.empowertakehome

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.empowertakehome.ui.customview.BeneficiaryDetailView
import com.example.empowertakehome.ui.viewmodel.BeneficiariesViewModel

// Activity for showing detail view of each beneficiary when clicked from RecyclerView; please note TODO below
// TODO: Due to prior engagements I needed to keep and the resulting time constraint, I was unable to finish this portion as I would have liked to
class BeneficiaryDetailFragment : Fragment() {

    private val viewModel: BeneficiariesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = BeneficiaryDetailView(requireContext())
        view.setBeneficiary(viewModel.selectedBeneficiary)
        return view
    }
}