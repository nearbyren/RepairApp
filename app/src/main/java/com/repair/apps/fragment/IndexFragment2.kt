package com.repair.apps.fragment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.repair.apps.R
import com.repair.apps.databinding.FragmentIndex2Binding
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

    private var activityItems = mutableListOf<IndexItemAdDto2>()
    private val indexTagAdapter by lazy { IndexTagAdapter2() }
    override fun initialize(savedInstanceState: Bundle?) {
        activityItems.add(IndexItemAdDto2("水喉渠務"))
        activityItems.add(IndexItemAdDto2("防漏防水"))
        activityItems.add(IndexItemAdDto2("門窗"))
        activityItems.add(IndexItemAdDto2("木工"))
        activityItems.add(IndexItemAdDto2("廢物處理"))
        activityItems.add(IndexItemAdDto2("冷氣"))
        activityItems.add(IndexItemAdDto2("電燈"))
        activityItems.add(IndexItemAdDto2("定期保養"))
        activityItems.add(IndexItemAdDto2("其他"))
        indexTagAdapter.setItems(activityItems)
        binding.recycle.adapter = indexTagAdapter
        binding.recycle.layoutManager = LinearLayoutManager(context)
        binding.recycle.addItemDecoration(SpaceItemDecoration(12.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        indexTagAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<IndexItemAdDto2> {
            override fun onItemClick(holder: Any, item: IndexItemAdDto2, position: Int) {
            }
        })
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue)
            .setTitle(title = "服務清單", titleColor = nearby.lib.base.R.color.white).build()
    }
}