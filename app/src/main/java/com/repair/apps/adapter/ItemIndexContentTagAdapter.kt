package com.repair.apps.adapter


import androidx.core.content.ContextCompat
import com.repair.apps.R
import com.repair.apps.databinding.ItemContentTagBinding
import com.repair.apps.model.IndexItemTagDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter



class ItemIndexContentTagAdapter : BaseBindRecyclerAdapter<ItemContentTagBinding, IndexItemTagDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_content_tag
    }

    override fun onBindingItem(
        binding: ItemContentTagBinding,
        item: IndexItemTagDto,
        position: Int
    ) {
        binding.indexIndexItemTvAdText.text = item.s
        binding.image.background = ContextCompat.getDrawable(context, item.icon)
    }


}