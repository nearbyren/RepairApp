package com.repair.apps.ui

import android.os.Bundle
import com.repair.apps.R
import com.repair.apps.databinding.ActivityLauncherBinding
import com.repair.apps.http.IndexViewModel
import nearby.lib.mvvm.activity.BaseAppBVMActivity


class LauncherActivity : BaseAppBVMActivity<ActivityLauncherBinding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }


    override fun layoutRes(): Int {
        return R.layout.activity_launcher
    }


    override fun initialize(savedInstanceState: Bundle?) {
        viewModel.start()
        viewModel.start.observe(this) {
            if (it) {
                navigate(ActivateActivity::class.java)
                finishPage(LauncherActivity@ this)
            }
        }
    }

}