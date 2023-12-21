package com.repair.apps.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.repair.apps.AboutUsActivity
import com.repair.apps.CommonProblemActivity
import com.repair.apps.EditEmailActivity
import com.repair.apps.EditPasswordActivity
import com.repair.apps.PrivacyPolicyActivity
import com.repair.apps.R
import com.repair.apps.RermsDetailsActivity
import com.repair.apps.SPreUtil
import com.repair.apps.databinding.FragmentIndex4Binding
import com.repair.apps.dialog.SignOutDialogFragment
import com.repair.apps.http.IndexViewModel
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.fragment.BaseAppBVMFragment

/**
 * @author: lr
 * @created on: 2023/12/18 9:13 PM
 * @description:
 */
class IndexFragment4 : BaseAppBVMFragment<FragmentIndex4Binding, IndexViewModel>(),
    View.OnClickListener {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_4
    }

    override fun initialize(savedInstanceState: Bundle?) {
        binding.clEmailAddress.setOnClickListener(this)
        binding.clChangePassword.setOnClickListener(this)
        binding.clCommonProblem.setOnClickListener(this)
        binding.clContactUs.setOnClickListener(this)
        binding.clAboutUs.setOnClickListener(this)
        binding.clTermsDetails.setOnClickListener(this)
        binding.clPrivacyPolicy.setOnClickListener(this)
        binding.clSignOut.setOnClickListener(this)

        val emailHas = SPreUtil[requireActivity(), "email_has", false]
        val email = SPreUtil[requireActivity(), "email", "-"]

        println("emailHas $emailHas")
        //郵件賬號
        binding.emailAddressContent.text = email.toString()
        emailHas?.let {
            binding.emailVerified.isVisible = it as Boolean
        }


    }

    override fun initBarHelperConfig(): BarHelperConfig {
        return BarHelperConfig.builder().setBack(false)
            .setBgColor(nearby.lib.base.R.color.dodgerblue)
            .setTitle(title = "賬戶", titleColor = nearby.lib.base.R.color.white).build()
    }

    override fun onClick(view: View?) {
        view?.let {
            when (it.id) {
                R.id.cl_email_address -> {
                    navigate(EditEmailActivity::class.java)
                }

                R.id.cl_change_password -> {
                    navigate(EditPasswordActivity::class.java)
                }

                R.id.cl_common_problem -> {
                    navigate(CommonProblemActivity::class.java)
                }

                R.id.cl_contact_us -> {}
                R.id.cl_about_us -> {
                    navigate(AboutUsActivity::class.java)
                }

                R.id.cl_terms_details -> {
                    navigate(RermsDetailsActivity::class.java)
                }

                R.id.cl_privacy_policy -> {
                    navigate(PrivacyPolicyActivity::class.java)
                }

                R.id.cl_sign_out -> {
                    val signOut = SignOutDialogFragment()
                    signOut.show(this)

                }
            }
        }

    }
}