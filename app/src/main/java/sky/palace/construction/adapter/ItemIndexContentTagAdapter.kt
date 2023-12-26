package sky.palace.construction.adapter


import androidx.core.content.ContextCompat
import sky.palace.construction.R
import sky.palace.construction.databinding.ItemContentTagBinding
import sky.palace.construction.model.IndexItemTagDto
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