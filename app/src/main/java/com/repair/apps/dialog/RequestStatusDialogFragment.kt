package com.repair.apps.dialog

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.repair.apps.R
import com.repair.apps.adapter.ItemAlbumAdapter
import com.repair.apps.adapter.ItemIndexContentTagAdapter
import com.repair.apps.databinding.FragmentRequestStatusBinding
import com.repair.apps.model.AdBannerDto
import com.repair.apps.model.AlbumDto
import com.repair.apps.model.IndexItemTagDto
import com.repair.apps.uitl.ConstantUtil
import nearby.lib.base.dialog.BaseBindDialogFragment
import nearby.lib.uikit.recyclerview.BaseRecyclerAdapter
import nearby.lib.uikit.recyclerview.SpaceItemDecoration
import nearby.lib.uikit.widgets.dpToPx


class RequestStatusDialogFragment : BaseBindDialogFragment<FragmentRequestStatusBinding>() {

    private var albumDtos = mutableListOf<AlbumDto>()
    private val itemAlbumAdapter by lazy { ItemAlbumAdapter() }


    override fun getLayoutId(): Int {
        return R.layout.fragment_request_status
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {
        binding.iconBack.setOnClickListener { dismiss() }
        arguments?.let {
            val status = it.getInt("status")
            val statusText = it.getString("status_text")
            val address = it.getString("address")
            binding.top.address.text = address.toString()
            binding.top.addressStatus.text = statusText.toString()
            println("目前狀態 $status")
            when (status) {
                ConstantUtil.SERVICE_STATUS_QUOTE -> {
                    binding.top.addressStatus.setCompoundDrawables(
                        ContextCompat.getDrawable(
                            requireActivity(),
                            R.drawable.index_status_shape_1
                        ), null, null, null
                    )
                    binding.top.addressStatus.setTextColor(
                        ContextCompat.getColor(
                            requireActivity(),
                            R.color.item_status_1
                        )
                    )


                    //隱藏已報價按鈕
                    binding.status23.isVisible = false
                    binding.dowQuote.isVisible = false
                    binding.confirm.isVisible = false

                    //隱藏已完成
                    binding.filled.isVisible = false
                }

                ConstantUtil.SERVICE_STATUS_QUOTED -> {
                    binding.top.addressStatus.setCompoundDrawables(
                        ContextCompat.getDrawable(
                            requireActivity(),
                            R.drawable.index_status_shape_2
                        ), null, null, null
                    )
                    binding.top.addressStatus.setTextColor(
                        ContextCompat.getColor(
                            requireActivity(),
                            R.color.item_status_2
                        )
                    )

                    //隱藏已報價按鈕
                    binding.status23.isVisible = true
                    binding.dowQuote.isVisible = true
                    binding.confirm.isVisible = true
                    Glide.with(this).load(R.drawable.baojia).into(binding.baojiaimg)

                }

                ConstantUtil.SERVICE_STATUS_CONFIRM -> {
                    binding.top.addressStatus.setCompoundDrawables(
                        ContextCompat.getDrawable(
                            requireActivity(),
                            R.drawable.index_status_shape_3
                        ), null, null, null
                    )
                    binding.top.addressStatus.setTextColor(
                        ContextCompat.getColor(
                            requireActivity(),
                            R.color.item_status_3
                        )
                    )
                    Glide.with(this).load(R.drawable.baojia).into(binding.baojiaimg)
                    binding.status23.isVisible = true
                    //隱藏已報價按鈕
                    binding.dowQuote.isVisible = false
                    binding.confirm.isVisible = false
                    //隱藏已完成
                    binding.filled.isVisible = false
                }

                ConstantUtil.SERVICE_STATUS_FINISH -> {
                    binding.top.addressStatus.setCompoundDrawables(
                        ContextCompat.getDrawable(
                            requireActivity(),
                            R.drawable.index_status_shape_4
                        ), null, null, null
                    )
                    binding.top.addressStatus.setTextColor(
                        ContextCompat.getColor(
                            requireActivity(),
                            R.color.item_status_4
                        )
                    )

                    //隱藏已報價按鈕
                    binding.status23.isVisible = false
                    binding.dowQuote.isVisible = false
                    binding.confirm.isVisible = false


                    binding.filled.isVisible = true


                    Glide.with(this).load(R.drawable.fapiao).into(binding.fapiao)

                    albumDtos.add(AlbumDto("水喉渠務", R.drawable.item1))
                    albumDtos.add(AlbumDto("防漏防水", R.drawable.item2))
                    albumDtos.add(AlbumDto("門窗", R.drawable.item3))
                    albumDtos.add(AlbumDto("木工", R.drawable.item4))
                    albumDtos.add(AlbumDto("廢物處理", R.drawable.item1))
                    albumDtos.add(AlbumDto("冷氣", R.drawable.item2))
                    itemAlbumAdapter.setItems(albumDtos)
                    binding.recycle.adapter = itemAlbumAdapter
                    binding.recycle.layoutManager = GridLayoutManager(context, 3)
                    binding.recycle.addItemDecoration(SpaceItemDecoration(0, 10.dpToPx, 10.dpToPx))
                    binding.recycle.setHasFixedSize(true)
                    binding.recycle.itemAnimator = null
                    itemAlbumAdapter.setOnItemClickListener(listener = object :
                        BaseRecyclerAdapter.OnItemClickListener<AlbumDto> {
                        override fun onItemClick(holder: Any, item: AlbumDto, position: Int) {
                        }
                    })

                }

                else -> {}
            }
        }
    }

}