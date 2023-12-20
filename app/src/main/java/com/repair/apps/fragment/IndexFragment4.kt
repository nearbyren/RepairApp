package com.repair.apps.fragment

import android.os.Bundle
import com.repair.apps.R
import com.repair.apps.databinding.FragmentIndex2Binding
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.fragment.BaseAppBVMFragment

/**
 * @author: lr
 * @created on: 2023/12/18 9:13 PM
 * @description:
 */
class IndexFragment4: BaseAppBVMFragment<FragmentIndex2Binding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
         return IndexViewModel()
    }

    override fun layoutRes(): Int {
       return R.layout.fragment_index_4
    }

    override fun initialize(savedInstanceState: Bundle?) {

    }
    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue)
            .setTitle(title = "賬戶", titleColor = nearby.lib.base.R.color.white).build()
    }
}