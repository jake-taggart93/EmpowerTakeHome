package com.example.empowertakehome.ui.customview

import android.content.Context
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.empowertakehome.R
import com.example.empowertakehome.domain.model.Address
import com.example.empowertakehome.domain.model.Beneficiary
import com.example.empowertakehome.domain.util.formatAddress
import com.example.empowertakehome.domain.util.formatDate

// Custom View for the detail screen of an individual beneficiary
class BeneficiaryDetailView(context: Context) : LinearLayout(context) {

    // TextView variables
    private val tvName = TextView(context)
    private val tvDesignation = TextView(context)
    private val tvBenefactorType = TextView(context)
    private val tvDateOfBirth = TextView(context)
    private val tvSsn = TextView(context)
    private val tvPhoneNumber = TextView(context)
    private val tvAddress = TextView(context)

    // Initializing the custom view's layout params, orientation, and adding all textviews
    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        orientation = VERTICAL
        setPadding(4, 12, 4, 12)
        addView(tvName)
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        addView(tvDesignation)
        tvDesignation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        addView(tvBenefactorType)
        tvBenefactorType.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        addView(tvSsn)
        tvSsn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        addView(tvDateOfBirth)
        tvDateOfBirth.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        addView(tvPhoneNumber)
        tvPhoneNumber.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        addView(tvAddress)
        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
    }

    // Function for setting the beneficiary details
    fun setBeneficiary(selectedBeneficiary: Beneficiary?) {
        selectedBeneficiary?.let { beneficiary ->
            tvName.text = context.getString(
                R.string.name_placeholder,
                beneficiary.firstName,
                beneficiary.middleName,
                beneficiary.lastName
            )
            tvDesignation.text =
                if (beneficiary.designationCode == "P") context.getString(R.string.designation_primary)
                else context.getString(R.string.designation_contingent)
            tvBenefactorType.text = beneficiary.beneType
            tvSsn.text = beneficiary.socialSecurityNumber
            tvPhoneNumber.text = beneficiary.phoneNumber
            tvAddress.text = formatAddress(beneficiary.address)
            tvDateOfBirth.text = formatDate(beneficiary.dateOfBirth)
        }
    }
}