package sky.palace.construction.ui

import android.os.Bundle
import sky.palace.construction.R
import sky.palace.construction.databinding.ActivityAboutUsBinding
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