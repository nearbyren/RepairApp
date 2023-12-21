package com.repair.apps

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import com.repair.apps.databinding.ActivitySignInLoginBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.base.uitl.ToastUtils
import nearby.lib.mvvm.activity.BaseAppBindActivity


class SignInLoginActivity : BaseAppBindActivity<ActivitySignInLoginBinding>() {


    private var type: String? = ""
    private var isLogin = false
    override fun layoutRes(): Int {
        return R.layout.activity_sign_in_login
    }


    override fun initialize(savedInstanceState: Bundle?) {
        intent?.let {
            type = it.getStringExtra(ActivateActivity.type)
            type?.let { type ->
                when (type) {
                    "0" -> {
                        isLogin = false
                        binding.title.text = "註冊"
                        binding.button.text = "註冊"
                    }

                    "1" -> {
                        isLogin = true
                        binding.title.text = "歡迎登錄"
                        binding.button.text = "登錄"
                    }
                }

            }
        }


        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passwordEt.text.toString()
            if (TextUtils.isEmpty(email)) {
                ToastUtils.showToast("請輸入郵件賬號")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {
                ToastUtils.showToast("請輸入密碼")
                return@setOnClickListener
            }
            if (isLogin) {
//                val getEmail = SPreUtil[this@SignInLoginActivity, "email", ""]
//                val getPassword = SPreUtil[this@SignInLoginActivity, "password", ""]
//                if (email== getEmail && password == getPassword) {
                navigate(MainActivity::class.java)
//                } else {
//                    ToastUtils.showToast("賬號密碼不正確")
//                }
            } else {
//                SPreUtil.put(this@SignInLoginActivity, "email", email.toString())
//                SPreUtil.put(this@SignInLoginActivity, "password", password.toString())
                navigate(SubmitCardActivity::class.java)
            }
            finishPage(this)
        }
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_back_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = "").build()
    }

}