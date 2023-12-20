package com.repair.apps.fragment


import androidx.core.content.ContextCompat
import com.repair.apps.R
import com.repair.apps.databinding.IndexItemContentTagBinding
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


/**
 * @author:
 * @created on: 2022/7/13 19:00
 * @description:一级活动标签
 */
class IndexTagAdapter : BaseBindRecyclerAdapter<IndexItemContentTagBinding, IndexItemAdDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.index_item_content_tag
    }

    override fun onBindingItem(
        binding: IndexItemContentTagBinding,
        item: IndexItemAdDto,
        position: Int
    ) {
        binding.indexIndexItemTvAdText.text = item.s
        binding.image.background = ContextCompat.getDrawable(context, item.icon)
    }


}