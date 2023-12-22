package com.repair.apps.ui

import android.os.Bundle
import com.repair.apps.R
import com.repair.apps.databinding.ActivityRermsDetailsBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class RermsDetailsActivity : BaseAppBindActivity<ActivityRermsDetailsBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_rerms_details
    }


    override fun initialize(savedInstanceState: Bundle?) {
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_white_left)
            .setBgColor(R.color.toolbar_bg_color).setTitle(title = "条款及细节", titleColor = nearby.lib.base.R.color.white).build()
    }

}