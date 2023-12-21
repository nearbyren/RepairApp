package com.repair.apps

import android.content.Intent
import android.os.Bundle
import com.repair.apps.R
import com.repair.apps.databinding.ActivityActivateBinding
import nearby.lib.mvvm.activity.BaseAppBindActivity


class ActivateActivity : BaseAppBindActivity<ActivityActivateBinding>() {


    companion object {
        const val type: String = "type"
    }

    override fun layoutRes(): Int {
        return R.layout.activity_activate
    }


    override fun initialize(savedInstanceState: Bundle?) {
        binding.login.setOnClickListener {
            val intent = Intent(this, SignInLoginActivity::class.java)
            intent.putExtra(type, "1")
            startActivity(intent)
        }
        binding.sign.setOnClickListener {
            val intent = Intent(this, SignInLoginActivity::class.java)
            intent.putExtra(type, "0")
            startActivity(intent)
        }
    }

}