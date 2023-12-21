package com.repair.apps.dialog

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.view.isVisible
import com.repair.apps.R
import com.repair.apps.databinding.FragmentRequestBinding
import nearby.lib.base.dialog.BaseBindDialogFragment
import nearby.lib.base.uitl.ToastUtils

class RequestDialogFragment : BaseBindDialogFragment<FragmentRequestBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_request
    }

    override fun initialize(view: View, savedInstanceState: Bundle?) {
        binding.iconBack.setOnClickListener { dismiss() }
        binding.rgUrgent.setOnCheckedChangeListener { rg, p1 ->
            when (p1) {
                R.id.radio1 -> {
                    println("radio1")
                    binding.clUrgent.isVisible = true
                }

                R.id.radio2 -> {
                    println("radio2")
                    binding.clUrgent.isVisible = false
                }
            }

        }

        //維修地點
        binding.addressEt
        //維修詳情
        binding.detailEt

        //維修地點照片
        binding.ivRepLoc1
        binding.addressBtn.setOnClickListener {
            ToastUtils.showToast("上傳圖片 維修地點照片")
        }
        binding.addressText
        //維修位置照片
        binding.ivRepLoc2
        binding.placeBtn.setOnClickListener {
            ToastUtils.showToast("上傳圖片 維修位置照片")
        }
        binding.placeText


        //緊急選擇
        binding.clUrgent.setOnClickListener {
            ToastUtils.showToast("去相冊")
        }
        //提交上傳
        binding.confirm.setOnClickListener {
            ToastUtils.showToast("提交")
        }



    }
}