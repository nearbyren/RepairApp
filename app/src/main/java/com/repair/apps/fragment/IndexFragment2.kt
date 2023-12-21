package com.repair.apps.fragment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.repair.apps.R
import com.repair.apps.adapter.itemServiceStatusAdapter
import com.repair.apps.databinding.FragmentIndex2Binding
import com.repair.apps.http.IndexViewModel
import com.repair.apps.model.ServiceDto
import nearby.lib.base.bar.BarHelperConfig

import nearby.lib.mvvm.fragment.BaseAppBVMFragment
import nearby.lib.uikit.recyclerview.BaseRecyclerAdapter
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx

/**
 * @author: lr
 * @created on: 2023/12/18 9:13 PM
 * @description:
 */
class IndexFragment2 :
    BaseAppBVMFragment<FragmentIndex2Binding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_2
    }

    private var activityItems = mutableListOf<ServiceDto>()
    private val indexTagAdapter by lazy { itemServiceStatusAdapter() }
    override fun initialize(savedInstanceState: Bundle?) {
        activityItems.add(ServiceDto("水喉渠務"))
        activityItems.add(ServiceDto("防漏防水"))
        activityItems.add(ServiceDto("門窗"))
        activityItems.add(ServiceDto("木工"))
        activityItems.add(ServiceDto("廢物處理"))
        activityItems.add(ServiceDto("冷氣"))
        activityItems.add(ServiceDto("電燈"))
        activityItems.add(ServiceDto("定期保養"))
        activityItems.add(ServiceDto("其他"))
        indexTagAdapter.setItems(activityItems)
        binding.recycle.adapter = indexTagAdapter
        binding.recycle.layoutManager = LinearLayoutManager(context)
        binding.recycle.addItemDecoration(SpaceItemDecoration(12.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        indexTagAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<ServiceDto> {
            override fun onItemClick(holder: Any, item: ServiceDto, position: Int) {
            }
        })
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue)
            .setTitle(title = "服務清單", titleColor = nearby.lib.base.R.color.white).build()
    }
}