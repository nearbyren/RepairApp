package com.repair.apps.adapter

import com.repair.apps.R
import com.repair.apps.databinding.ItemServiceStatusBinding
import com.repair.apps.model.ServiceDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class itemServiceStatusAdapter : BaseBindRecyclerAdapter<ItemServiceStatusBinding, ServiceDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_service_status
    }

    override fun onBindingItem(binding: ItemServiceStatusBinding, item: ServiceDto, position: Int) {
    }


}