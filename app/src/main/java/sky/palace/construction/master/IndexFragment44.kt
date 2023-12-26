package sky.palace.construction.master

import android.os.Bundle
import android.view.View
import sky.palace.construction.R
import sky.palace.construction.databinding.FragmentIndex44Binding
import sky.palace.construction.dialog.SignOutDialogFragment
import sky.palace.construction.http.IndexViewModel
import sky.palace.construction.ui.AboutUsActivity
import sky.palace.construction.ui.CommonProblemActivity
import sky.palace.construction.ui.EditPasswordActivity
import sky.palace.construction.ui.PrivacyPolicyActivity
import sky.palace.construction.ui.RermsDetailsActivity
import nearby.lib.base.bar.BarHelperConfig
import nearby.lib.mvvm.fragment.BaseAppBVMFragment
import nearby.lib.signal.livebus.LiveBus

/**
 * @author: lr
 * @created on: 2023/12/18 9:13 PM
 * @description:
 */
class IndexFragment44 : BaseAppBVMFragment<FragmentIndex44Binding, IndexViewModel>(),
    View.OnClickListener {
    override fun createViewModel(): IndexViewModel {
        return IndexViewModel()
    }

    override fun layoutRes(): Int {
        return R.layout.fragment_index_44
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
                    LiveBus.get("tab").post("tab")
//                    navigate(EditEmailActivity::class.java)
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