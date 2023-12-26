package sky.palace.construction.master

import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationBarView
import sky.palace.construction.R
import sky.palace.construction.databinding.ActivityMain2Binding
import nearby.lib.base.uitl.AppManager
import nearby.lib.base.uitl.ToastUtils
import nearby.lib.mvvm.activity.BaseAppBindActivity
import nearby.lib.signal.livebus.LiveBus


class MainMasterActivity : BaseAppBindActivity<ActivityMain2Binding>() {

    private val index2 by lazy { IndexFragment22() }
    private val index4 by lazy { IndexFragment44() }


    override fun layoutRes(): Int {
        return R.layout.activity_main2
    }

    private val onNavigationItemSelectedListener =
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_item21 -> {
                    switchFragment(index2)
                    return@OnItemSelectedListener true
                }

                R.id.navigation_item22 -> {
                    switchFragment(index4)
                    return@OnItemSelectedListener true
                }
            }
            false
        }

    private fun switchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun initialize(savedInstanceState: Bundle?) {
        LiveBus.get("tab").observeForever {
            binding.bottomNavigation.menu.getItem(0).isChecked = true
            switchFragment(index2)
        }
        binding.bottomNavigation.background = ContextCompat.getDrawable(
            this,
            R.drawable.index_index_bg_white_main
        )
        binding.bottomNavigation.itemIconTintList = null

        binding.bottomNavigation.setOnItemSelectedListener(onNavigationItemSelectedListener)
        // 初始显示第一个 Fragment
        switchFragment(index2)
        initBadge()

    }

    private fun initBadge() {
        //获取底部菜单view
        val menuView = binding.bottomNavigation.getChildAt(0) as BottomNavigationMenuView
        //获取第2个itemView
        menuView?.forEach {
            if (it.id == R.id.navigation_item21) {
                val itemView = it as BottomNavigationItemView
                //引入badgeView
                val badgeView = layoutInflater.inflate(R.layout.menu_badge, menuView, false)
                val ivBadge = badgeView.findViewById<ImageView>(R.id.iv_badge)
                //把badgeView添加到itemView中
                itemView.addView(badgeView)
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                this.finish()
                AppManager.getInstance().finishAllActivity()
            } else {
                ToastUtils.showToast("再按一次退出！")
                isExit = true
                Handler().postDelayed({
                    isExit = false
                }, 2000)

            }
            return true;
        }
        return super.onKeyDown(keyCode, event)
    }

    var isExit: Boolean = false
}