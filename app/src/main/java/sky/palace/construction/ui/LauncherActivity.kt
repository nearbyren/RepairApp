package sky.palace.construction.ui

import android.os.Bundle
import sky.palace.construction.R
import sky.palace.construction.databinding.ActivityLauncherBinding
import sky.palace.construction.http.IndexViewModel
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
        intent?.let {
            println("MessagingService intent")
            println("MessagingService ${it.getStringExtra("key1")} - ${it.getStringExtra("key2")}")
        }
    }

}