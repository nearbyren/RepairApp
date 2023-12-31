package nearby.lib.base.uitl

import android.view.Gravity
import android.view.View
import android.widget.Toast
import nearby.lib.base.app.ApplicationProvider

/**
 * @description: Toast相关工具类
 * @since: 1.0.0
 */
object ToastUtils {
    var toast: Toast? = null

    fun showToast(str: String, showLong: Boolean = false, gravity: Int = Gravity.CENTER) {
        val tempToast = Toast.makeText(
            ApplicationProvider.appContext, str,
            if (showLong) {
                Toast.LENGTH_LONG
            } else {
                Toast.LENGTH_SHORT
            }
        )
        tempToast?.setGravity(gravity, 0, 0)
        tempToast?.show()
    }

    fun showViewToast(view: View, showLong: Boolean, gravity: Int = Gravity.CENTER) {
        if (toast == null) {
            toast = Toast(ApplicationProvider.appContext)
        }
        toast?.setGravity(gravity, 0, 0)
        toast?.view = view
        toast?.duration = if (showLong) {
            Toast.LENGTH_LONG
        } else {
            Toast.LENGTH_SHORT
        }
        cancelToast(toast)
        toast?.show()
    }

    fun cancelToast(toast: Toast?) {
        /**
         * tips: repeated using the same toast object to show, must cancel it first,
         * if not, maybe throw [IllegalStateException] in&above Android P,
         * refer https://stackoverflow.com/questions/51956971/illegalstateexception-of-toast-view-on-android-p-preview
         */
        try {
            if (toast?.view!!.isShown) {
                toast.cancel()
            }
        } catch (e: Exception) {
        }
    }
}