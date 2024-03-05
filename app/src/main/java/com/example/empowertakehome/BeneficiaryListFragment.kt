package com.example.empowertakehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.empowertakehome.domain.model.Beneficiary
import com.example.empowertakehome.ui.adapter.BeneficiariesRecyclerViewAdapter
import com.example.empowertakehome.ui.viewmodel.BeneficiariesViewModel

class BeneficiaryListFragment : Fragment() {
    private val viewModel: BeneficiariesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beneficiary_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // find view for RV
        val rvBeneficiaries = view.findViewById<RecyclerView>(R.id.rv_beneficiaries)

        // set onClickListener for each item in RV
        val rvItemClickListener: (Beneficiary) -> Unit = {
            viewModel.onBeneficiarySelected(it)
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fr_container, BeneficiaryDetailFragment(), BeneficiaryDetailFragment::class.simpleName)
                .addToBackStack(BeneficiaryDetailFragment::class.simpleName)
                .commit()
        }

        // Create adapter for RV and set
        val adapter = BeneficiariesRecyclerViewAdapter(
            viewModel.beneficiaries.value ?: emptyList(),
            rvItemClickListener
        )
        rvBeneficiaries.adapter = adapter

        // Observe LiveData and update RV data (this doesn't apply in this challenge, but is to demonstrate an approach for a dynamic data situation)
        viewModel.beneficiaries.observe(requireActivity()) {
            adapter.updateBeneficiaries(it)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}