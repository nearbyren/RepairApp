package com.repair.apps.adapter


import com.bumptech.glide.Glide
import com.repair.apps.R
import com.repair.apps.databinding.ItemAlbumBinding
import com.repair.apps.model.AlbumDto
import nearby.lib.uikit.recyclerview.BaseBindRecyclerAdapter


class ItemAlbumAdapter : BaseBindRecyclerAdapter<ItemAlbumBinding, AlbumDto>() {

    override fun getLayoutId(viewType: Int): Int {
        return R.layout.item_album
    }

    override fun onBindingItem(
        binding: ItemAlbumBinding, item: AlbumDto, position: Int
    ) {
        Glide.with(context).load(R.drawable.weizhi).into(binding.imgBg)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

}