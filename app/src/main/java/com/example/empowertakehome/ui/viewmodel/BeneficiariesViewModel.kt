package com.example.empowertakehome.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.empowertakehome.data.repository.BeneficiaryRepositoryImpl
import com.example.empowertakehome.domain.model.Beneficiary
import com.example.empowertakehome.domain.repository.BeneficiaryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BeneficiariesViewModel : ViewModel() {

    // Repository to pull data from
    private val repository: BeneficiaryRepository = BeneficiaryRepositoryImpl

    // Private state flow to collect from repo, which is then emitted as LiveData
    private val _beneficiaries = MutableStateFlow(emptyList<Beneficiary>())
    val beneficiaries = _beneficiaries.asLiveData()

    lateinit var selectedBeneficiary: Beneficiary

    init {
        // Invoke the repository collecting its data
        repository.fetchBeneficiaries()

        // Collect data from repository as it comes in and emit data as LiveData
        viewModelScope.launch {
            repository.beneficiaries.collect {
                _beneficiaries.value = it
            }
        }
    }

    // Function used for setting the selectedBeneficiary which is to be used in the DetailView of each beneficiary when clicked
    fun onBeneficiarySelected(beneficiary: Beneficiary) {
        selectedBeneficiary = beneficiary
    }
}