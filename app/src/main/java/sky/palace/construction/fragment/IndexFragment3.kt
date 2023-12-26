package sky.palace.construction.fragment

import android.os.Bundle
import sky.palace.construction.R
import sky.palace.construction.databinding.FragmentIndex3Binding
import sky.palace.construction.http.IndexViewModel
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.fragment.BaseAppBVMFragment

/**
 * @author: lr
 * @created on: 2023/12/18 9:13 PM
 * @description:
 */
class IndexFragment3: BaseAppBVMFragment<FragmentIndex3Binding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
         return IndexViewModel()
    }

    override fun layoutRes(): Int {
       return R.layout.fragment_index_3
    }

    override fun initialize(savedInstanceState: Bundle?) {

    }
    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue)
            .setTitle(title = "客服中心", titleColor = nearby.lib.base.R.color.white).build()
    }
}