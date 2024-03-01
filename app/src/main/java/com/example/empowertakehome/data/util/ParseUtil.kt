package com.example.empowertakehome.data.util

import com.example.empowertakehome.domain.model.Address
import com.example.empowertakehome.domain.model.Beneficiary
import org.json.JSONObject

// Parse through Beneficiary JSON object and convert to domain obj
fun JSONObject.parseBeneficiaryJson(): Beneficiary {
    val beneficiaryAddressJsonObj = getJSONObject("beneficiaryAddress")
    return Beneficiary(
        lastName = getString("lastName"),
        firstName = getString("firstName"),
        designationCode = getString("designationCode"),
        beneType = getString("beneType"),
        socialSecurityNumber = getString("socialSecurityNumber"),
        dateOfBirth = getString("dateOfBirth"),
        middleName = getString("middleName"),
        phoneNumber = getString("phoneNumber"),
        address = beneficiaryAddressJsonObj.parseBeneficiaryAddressJson()
    )
}

// Parse through Address JSON object and convert to domain obj
private fun JSONObject.parseBeneficiaryAddressJson(): Address =
    Address(
        firstLineMailing = getString("firstLineMailing"),
        scndLineMailing = getString("scndLineMailing"),
        city = getString("city"),
        zipCode = getString("zipCode"),
        stateCode = getString("stateCode"),
        country = getString("country")
    )