package com.example.empowertakehome.data.repository

import com.example.empowertakehome.data.util.parseBeneficiaryJson
import com.example.empowertakehome.domain.model.Beneficiary
import com.example.empowertakehome.domain.repository.BeneficiaryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.json.JSONArray

// Singleton pattern as we only want the one repo instance (I would use DI, but am trying to avoid third party libraries and not spend too much time on this)
object BeneficiaryRepositoryImpl : BeneficiaryRepository {

    // Flows for emitting the list of beneficiaries; ViewModel will collect this and convert to livedata
    private val _beneficiaries = MutableStateFlow(emptyList<Beneficiary>())
    override val beneficiaries: Flow<List<Beneficiary>> = _beneficiaries

    // Parse through JSON elements and assign to list
    override fun fetchBeneficiaries() {
        val beneficiaryList = mutableListOf<Beneficiary>()
        val jsonList = JSONArray(beneficiaryJson)
        for (index in 0 until jsonList.length()) {
            val beneficiaryJsonObj = jsonList.getJSONObject(index)
            val beneficiary = beneficiaryJsonObj.parseBeneficiaryJson()
            beneficiaryList.add(beneficiary)
        }
        _beneficiaries.value = beneficiaryList
    }

    // JSON value of beneficiaries
    private val beneficiaryJson = """[
  {
    "lastName": "Smith",
    "firstName": "John",
    "designationCode": "P",
    "beneType": "Spouse",
    "socialSecurityNumber": "XXXXX3333",
    "dateOfBirth": "04201979",
    "middleName": "D",
    "phoneNumber": "3035555555",
    "beneficiaryAddress": {
      "firstLineMailing": "8515 E Orchard Rd",
      "scndLineMailing": null,
      "city": "Greenwood Village",
      "zipCode": "80111",
      "stateCode": "CO",
      "country": "US"
    }
  },
  {
    "lastName": "Smith",
    "firstName": "Jane",
    "designationCode": "C",
    "beneType": "Child",
    "socialSecurityNumber": "XXXXX4664",
    "dateOfBirth": "01112012",
    "middleName": "E",
    "phoneNumber": "3034455555",
    "beneficiaryAddress": {
      "firstLineMailing": "8515 E Orchard Rd",
      "scndLineMailing": null,
      "city": "Greenwood Village",
      "zipCode": "80111",
      "stateCode": "CO",
      "country": "US"
    }
  },
  {
    "lastName": "Smith",
    "firstName": "Mary",
    "designationCode": "C",
    "beneType": "Child",
    "socialSecurityNumber": "XXXXX3645",
    "dateOfBirth": "02122013",
    "middleName": "E",
    "phoneNumber": "2035557558",
    "beneficiaryAddress": {
      "firstLineMailing": "8515 E Orchard Rd",
      "scndLineMailing": null,
      "city": "Greenwood Village",
      "zipCode": "80111",
      "stateCode": "CO",
      "country": "US"
    }
  },
  {
    "lastName": "Smith",
    "firstName": "David",
    "designationCode": "C",
    "beneType": "Child",
    "socialSecurityNumber": "XXXXX7652",
    "dateOfBirth": "09022013",
    "middleName": "E",
    "phoneNumber": "8094567777",
    "beneficiaryAddress": {
      "firstLineMailing": "8515 E Orchard Rd",
      "scndLineMailing": null,
      "city": "Greenwood Village",
      "zipCode": "80111",
      "stateCode": "CO",
      "country": "US"
    }
  },
  {
    "lastName": "Smith",
    "firstName": "Peter",
    "designationCode": "C",
    "beneType": "Child",
    "socialSecurityNumber": "XXXXX8756",
    "dateOfBirth": "10052014",
    "middleName": "E",
    "phoneNumber": "8194587755",
    "beneficiaryAddress": {
      "firstLineMailing": "8515 E Orchard Rd",
      "scndLineMailing": null,
      "city": "Greenwood Village",
      "zipCode": "80111",
      "stateCode": "CO",
      "country": "US"
    }
  }
]"""
}