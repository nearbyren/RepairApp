package sky.palace.construction.ui

import android.os.Bundle
import sky.palace.construction.R
import sky.palace.construction.databinding.ActivityPrivacyPolicyBinding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.activity.BaseAppBindActivity


class PrivacyPolicyActivity : BaseAppBindActivity<ActivityPrivacyPolicyBinding>() {

    override fun layoutRes(): Int {
        return R.layout.activity_privacy_policy
    }


    override fun initialize(savedInstanceState: Bundle?) {
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(true).setIconLeft(R.drawable.icon_white_left)
            .setBgColor(R.color.toolbar_bg_color).setTitle(title = "私隱政策", titleColor = nearby.lib.base.R.color.white).build()
    }

}