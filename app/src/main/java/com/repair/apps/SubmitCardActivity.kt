package com.repair.apps

import android.os.Bundle
import android.view.Gravity
import com.repair.apps.databinding.ActivitySignInLoginBinding
import com.repair.apps.databinding.ActivitySubmitCardBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.base.uitl.ToastUtils
import nearby.lib.mvvm.activity.BaseAppBindActivity


class SubmitCardActivity : BaseAppBindActivity<ActivitySubmitCardBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_submit_card
    }


    override fun initialize(savedInstanceState: Bundle?) {
        binding.clUpload.setOnClickListener { ToastUtils.showToast("上傳圖片") }
        binding.upload.setOnClickListener {
            navigate(MainActivity::class.java)
        }
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_back_left)
            .setBgColor(nearby.lib.base.R.color.white).setTitle(title = "").build()
    }

}