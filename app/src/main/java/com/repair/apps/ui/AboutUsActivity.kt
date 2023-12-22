package com.repair.apps.ui

import android.content.Intent
import android.os.Bundle
import com.repair.apps.R
import com.repair.apps.databinding.ActivityAboutUsBinding
import com.repair.apps.databinding.ActivityActivateBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class AboutUsActivity : BaseAppBindActivity<ActivityAboutUsBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_about_us
    }


    override fun initialize(savedInstanceState: Bundle?) {

    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_white_left)
            .setBgColor(R.color.toolbar_bg_color).setTitle(title = "關於我們", titleColor = nearby.lib.base.R.color.white).build()
    }

}