package com.example.empowertakehome.ui.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.empowertakehome.domain.model.Beneficiary
import com.example.empowertakehome.ui.customview.BeneficiaryItemView

// RecyclerViewAdapter class which accepts an initial list of items and onCLickListener lambda
class BeneficiariesRecyclerViewAdapter(
    private var items: List<Beneficiary>,
    private val onClickListener: (Beneficiary) -> Unit
) : RecyclerView.Adapter<BeneficiariesRecyclerViewAdapter.BeneficiaryViewHolder>() {

    inner class BeneficiaryViewHolder(val customView: BeneficiaryItemView) :
        RecyclerView.ViewHolder(customView)

    // Returns the Custom BeneficiaryItemView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeneficiaryViewHolder {
        val view = BeneficiaryItemView(parent.context)
        return BeneficiaryViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    // Binds the beneficiary data to the custom view and assigns the onClick
    override fun onBindViewHolder(holder: BeneficiaryViewHolder, position: Int) {
        val item = items[position]
        holder.customView.setBeneficiary(item)
        holder.itemView.rootView.setOnClickListener {
            onClickListener(item)
        }
    }

    // Allows updating of RecyclerView items; while unnecessary in this challenge, it is used to show how to update the RV data in this approach
    // In a more time-allotted format of this challenge, I would avoid notifyDataSetChanged() and
    @SuppressLint("NotifyDataSetChanged")
    fun updateBeneficiaries(beneficiaries: List<Beneficiary>) {
        items = beneficiaries
        notifyDataSetChanged()
    }
}