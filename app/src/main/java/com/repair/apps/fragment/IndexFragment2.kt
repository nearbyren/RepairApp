package com.repair.apps.fragment

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import androidx.recyclerview.widget.LinearLayoutManager
import com.repair.apps.R
import com.repair.apps.adapter.itemServiceStatusAdapter
import com.repair.apps.databinding.FragmentIndex2Binding
import com.repair.apps.dialog.RequestDialogFragment
import com.repair.apps.dialog.RequestStatusDialogFragment
import com.repair.apps.http.IndexViewModel
import com.repair.apps.model.ServiceDto
import com.repair.apps.uitl.ConstantUtil
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
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "預備報價中",
                ConstantUtil.SERVICE_STATUS_QUOTE
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "已报价，等待確認",
                ConstantUtil.SERVICE_STATUS_QUOTED
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "已确认，正在安排师傅",
                ConstantUtil.SERVICE_STATUS_CONFIRM
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "已完成",
                ConstantUtil.SERVICE_STATUS_FINISH
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "預備報價中",
                ConstantUtil.SERVICE_STATUS_QUOTE
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "已报价，等待確認",
                ConstantUtil.SERVICE_STATUS_QUOTED
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "已确认，正在安排师傅",
                ConstantUtil.SERVICE_STATUS_CONFIRM
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "已完成",
                ConstantUtil.SERVICE_STATUS_FINISH
            )
        )
        activityItems.add(
            ServiceDto(
                "學校大門",
                "編號",
                "預備報價中",
                ConstantUtil.SERVICE_STATUS_QUOTE
            )
        )
        indexTagAdapter.setItems(activityItems)
        binding.recycle.adapter = indexTagAdapter
        binding.recycle.layoutManager = LinearLayoutManager(context)
        binding.recycle.addItemDecoration(SpaceItemDecoration(12.dpToPx, 0.dpToPx, 0.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        indexTagAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<ServiceDto> {
            override fun onItemClick(holder: Any, item: ServiceDto, position: Int) {
                val request = RequestStatusDialogFragment()
                val bundle = Bundle()
                bundle.putInt("status", item.status)
                bundle.putString("address", item.schoolName)
                bundle.putString("status_text", item.statusText)
                request.arguments = bundle
                request.setGravity(Gravity.BOTTOM)
                request.show(this@IndexFragment2)
            }
        })

        binding.srl.setColorSchemeColors(nearby.lib.base.R.color.dodgerblue)

        binding.srl.setOnRefreshListener {
            Handler().postDelayed({
                binding.srl.isRefreshing = false

            }, 2000)
        }
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue)
            .setTitle(title = "服務清單", titleColor = nearby.lib.base.R.color.white).build()
    }
}