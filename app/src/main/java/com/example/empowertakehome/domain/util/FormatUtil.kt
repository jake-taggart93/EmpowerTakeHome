package com.example.empowertakehome.domain.util

import com.example.empowertakehome.domain.model.Address

// Format date to MM/dd/YYYY
fun formatDate(dateStr: String): String {
    return dateStr.substring(0, 2) + "/" + dateStr.substring(2, 4) + "/" + dateStr.substring(
        4,
        dateStr.lastIndex
    )
}

// Address Format
fun formatAddress(address: Address): String {
    val builtAddress = StringBuilder(address.firstLineMailing).appendLine()
    if (!address.scndLineMailing.isNullOrEmpty() && address.scndLineMailing != "null") {
        builtAddress.append(address.scndLineMailing)
            .appendLine()
    }
    builtAddress
        .append(address.city)
        .append(", ")
        .append(address.stateCode)
        .append(" ")
        .append(address.zipCode)
        .appendLine()
        .append(address.country)
    return builtAddress.toString()
}