package com.example.empowertakehome.domain.repository

import com.example.empowertakehome.domain.model.Beneficiary
import kotlinx.coroutines.flow.Flow

interface BeneficiaryRepository {
    val beneficiaries: Flow<List<Beneficiary>>
    fun fetchBeneficiaries()
}