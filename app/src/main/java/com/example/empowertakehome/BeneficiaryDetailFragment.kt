package com.example.empowertakehome

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.empowertakehome.ui.customview.BeneficiaryDetailView
import com.example.empowertakehome.ui.viewmodel.BeneficiariesViewModel

class BeneficiaryDetailFragment : Fragment() {

    private val viewModel: BeneficiariesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = BeneficiaryDetailView(requireContext())
        view.setBeneficiary(viewModel.selectedBeneficiary)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as BeneficiaryDetailView).setBeneficiary(viewModel.selectedBeneficiary)
    }
}