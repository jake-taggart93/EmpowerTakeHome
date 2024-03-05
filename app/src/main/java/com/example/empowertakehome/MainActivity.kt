package com.example.empowertakehome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction().add(
            R.id.fr_container,
            BeneficiaryListFragment(),
            BeneficiaryListFragment::class.simpleName
        ).addToBackStack(BeneficiaryListFragment::class.simpleName).commit()
    }
}