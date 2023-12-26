package sky.palace.construction.adapter


import com.bumptech.glide.Glide
import sky.palace.construction.R
import sky.palace.construction.databinding.ItemAlbumBinding
import sky.palace.construction.model.AlbumDto
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