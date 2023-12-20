package com.repair.apps.fragment

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import androidx.recyclerview.widget.GridLayoutManager
import com.repair.apps.R
import com.repair.apps.databinding.FragmentIndex1Binding
import com.youth.banner.indicator.RectangleIndicator
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
class IndexFragment1 : BaseAppBVMFragment<FragmentIndex1Binding, IndexViewModel>() {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_1
    }

    private var indexAdv: ArrayList<Advertise> = arrayListOf()
    private var activityItems = mutableListOf<IndexItemAdDto>()
    private val indexTagAdapter by lazy { IndexTagAdapter() }
    override fun initialize(savedInstanceState: Bundle?) {
        activityItems.add(IndexItemAdDto("水喉渠務", R.drawable.item1))
        activityItems.add(IndexItemAdDto("防漏防水", R.drawable.item2))
        activityItems.add(IndexItemAdDto("門窗", R.drawable.item3))
        activityItems.add(IndexItemAdDto("木工", R.drawable.item4))
        activityItems.add(IndexItemAdDto("廢物處理", R.drawable.item1))
        activityItems.add(IndexItemAdDto("冷氣", R.drawable.item2))
        activityItems.add(IndexItemAdDto("電燈", R.drawable.item3))
        activityItems.add(IndexItemAdDto("定期保養", R.drawable.item4))
        activityItems.add(IndexItemAdDto("其他", R.drawable.item1))
        indexTagAdapter.setItems(activityItems)
        binding.recycle.adapter = indexTagAdapter
        binding.recycle.layoutManager = GridLayoutManager(context, 3)
        binding.recycle.addItemDecoration(SpaceItemDecoration(0, 10.dpToPx, 10.dpToPx))
        binding.recycle.setHasFixedSize(true)
        binding.recycle.itemAnimator = null
        indexTagAdapter.setOnItemClickListener(listener = object :
            BaseRecyclerAdapter.OnItemClickListener<IndexItemAdDto> {
            override fun onItemClick(holder: Any, item: IndexItemAdDto, position: Int) {
            }
        })
        indexAdv.add(Advertise(pictureUrl = "", pictureUrlInt = R.drawable.ad_banner))
        indexAdv.add(Advertise(pictureUrl = "", pictureUrlInt = R.drawable.ad_banner))
        indexAdv.add(Advertise(pictureUrl = "", pictureUrlInt = R.drawable.ad_banner))
        binding.adBanner.addBannerLifecycleObserver(this)
        binding.adBanner.setBannerRound(20f)
        binding.adBanner.indicator = RectangleIndicator(requireActivity())
        binding.adBanner.setAdapter(ImageAdapter(requireActivity(), indexAdv))
        binding.adBanner.setOnBannerListener { data, _ ->
        }
        binding.adBanner.setDatas(indexAdv)
        binding.srl.setColorSchemeColors(nearby.lib.base.R.color.dodgerblue)

        binding.srl.setOnRefreshListener {
            Handler().postDelayed({
                binding.srl.isRefreshing = false

            }, 2000)
        }
    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue).setTitle(
                titleGravity = Gravity.LEFT,
                title = "选择所需服务",
                titleColor = nearby.lib.base.R.color.white
            ).build()
    }
}