package com.repair.apps.fragment

import com.repair.apps.R
import com.repair.apps.databinding.OrderStatusBinding
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


/**
 * @author:
 * @created on: 2022/7/13 19:00
 * @description:一级活动标签
 */
class IndexTagAdapter2 : BaseBindRecyclerAdapter<OrderStatusBinding, IndexItemAdDto2>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.order_status
    }

    override fun onBindingItem(binding: OrderStatusBinding, item: IndexItemAdDto2, position: Int) {
    }


}