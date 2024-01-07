package com.andrachek.singleLine

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.andrachek.singleLine.databinding.MainActivityBinding

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val homeFragment = HomeFragment()
        val xmlFragment = XmlFragment()
        val composeFragment = ComposeFragment()

        setFragment(homeFragment)
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setFragment(homeFragment)
                R.id.xml -> setFragment(xmlFragment)
                R.id.compose -> setFragment(composeFragment)
            }
            true
        }
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment)
            commit()
        }
    }

}
