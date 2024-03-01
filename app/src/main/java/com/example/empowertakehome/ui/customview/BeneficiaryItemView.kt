package com.example.empowertakehome.ui.customview

import android.content.Context
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.empowertakehome.R
import com.example.empowertakehome.domain.model.Beneficiary

class BeneficiaryItemView(context: Context) : LinearLayout(context) {

    private val tvName = TextView(context)
    private val tvDesignation = TextView(context)
    private val tvBenefactorType = TextView(context)

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        orientation = VERTICAL
        setPadding(4, 12, 4, 12)
        addView(tvName)
        addView(tvDesignation)
        addView(tvBenefactorType)
        tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        tvName.setPadding(0, 4, 0, 4)
        tvDesignation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        tvDesignation.setPadding(0, 4, 0, 4)
        tvBenefactorType.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        tvBenefactorType.setPadding(0, 4, 0, 4)
    }

    fun setBeneficiary(newBeneficiary: Beneficiary) {
        tvName.text = context.getString(
            R.string.name_placeholder,
            newBeneficiary.firstName,
            newBeneficiary.middleName,
            newBeneficiary.lastName
        )
        tvDesignation.text =
            if (newBeneficiary.designationCode == "P") context.getString(R.string.designation_primary)
            else context.getString(R.string.designation_contingent)
        tvBenefactorType.text = newBeneficiary.beneType
    }
}