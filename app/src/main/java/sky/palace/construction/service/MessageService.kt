//package sky.palace.construction.service
//
//import android.app.ActivityManager
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.media.RingtoneManager
//import android.os.Build
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import androidx.lifecycle.LifecycleObserver
//import com.alibaba.fastjson.JSON
//import com.alibaba.fastjson.JSONObject
//import sky.palace.construction.R
//import sky.palace.construction.ui.SignInLoginActivity
//
//class MessagingService : FirebaseMessagingService(), LifecycleObserver {
//
//    private val requestCode = this.hashCode()
//    private val exampleNotificationChannel = "example_notification_channel"
//    private var notificationId = 0
//
//    private lateinit var notificationManager: NotificationManagerCompat
//
//    override fun onCreate() {
//        super.onCreate()
//        println("FCMExampleTag ExampleFCMService onCreate")
//        notificationManager = NotificationManagerCompat.from(this)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            // 创建通知渠道
//            val applicationInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                packageManager.getApplicationInfo(
//                    packageName,
//                    PackageManager.ApplicationInfoFlags.of(0)
//                )
//            } else {
//                packageManager.getApplicationInfo(packageName, 0)
//            }
//            val exampleChannel = NotificationChannel(
//                exampleNotificationChannel,
//                " Notification Channel",
//                NotificationManager.IMPORTANCE_DEFAULT
//            ).apply {
//                description = "The description of this notification channel"
//            }
//            notificationManager.createNotificationChannel(exampleChannel)
//        }
//    }
//
//    /**
//     * Called when message is received.
//     *
//     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
//     */
//    override fun onMessageReceived(remoteMessage: RemoteMessage) {
//
//        //切換後台不會接收 後台有通知欄 切換前台才會接收 前台沒有通知欄
//        println("MessagingService onMessageReceived $remoteMessage")
//        println("MessagingService onMessageReceived ${remoteMessage.notification}")
//        remoteMessage.notification?.let {
//            //自定義顯示通知欄
//            postNotification(it)
//        }
//        if (remoteMessage == null) {
//            return
//        }
//        val remoteMessageMap: Map<String, String> = remoteMessage.data;
//        if (remoteMessageMap == null || remoteMessageMap.isEmpty()) {
//            return
//        }
//        val json = JSON.toJSON(remoteMessageMap) as JSONObject
//        println("MessagingService onMessageReceived $json")
//
//    }
//
//    private fun postNotification(remoteNotification: RemoteMessage.Notification) {
//        println("MessagingService postNotification")
//        val intent: Intent
//        if (notificationManager.areNotificationsEnabled()) {
//
//            intent = Intent(this, SignInLoginActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//            val pendingIntent =
//                PendingIntent.getActivity(
//                    this@MessagingService,
//                    requestCode,
//                    intent,
//                    PendingIntent.FLAG_IMMUTABLE
//                )
//            val notification =
//                NotificationCompat.Builder(this@MessagingService, exampleNotificationChannel)
//                    //设置小图标
//                    .setSmallIcon(R.drawable.img_del)
//                    // 设置通知标题
//                    .setContentTitle("前台 ${remoteNotification.title}")
//                    // 设置通知内容
//                    .setContentText("前台 ${remoteNotification.body}")
//                    // 设置是否自动取消
//                    .setAutoCancel(true)
//                    // 设置通知声音
//                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                    // 设置点击的事件
//                    .setContentIntent(pendingIntent)
//                    .build()
//            // notificationId可以记录下来
//            // 可以通过notificationId对通知进行相应的操作
//            notificationManager.notify(notificationId, notification)
//            notificationId++
//        }
//    }
//
//    override fun handleIntent(intent: Intent?) {
//        super.handleIntent(intent)
//        //此處只要有消息就會回調
//        println("MessagingService handleIntent $intent")
//
//    }
//
//    override fun onNewToken(token: String) {
//        try {
//            println("MessagingService onNewToken $token")
////            MyApplication.instance?.let {
////                ApiClient.getApiService(it.sessionManager).postPushToken(PushTokenBody(token))
////            }
//            val param = HashMap<String, Any>()
//            param.put("fcm_registration_token", token)
////            AppLog.setHeaderInfo(param)
//        } catch (e: java.lang.Exception) {
//
//        }
//    }
//
//    /**
//     * 判断是在前台还是后台
//     */
//    private fun isRunBackground(context: Context): Boolean {
//        val activityManager = context.applicationContext
//            .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
//        val packageName = context.applicationContext.packageName
//
//        val appProcesses = activityManager
//            .runningAppProcesses ?: return true
//        for (appProcess in appProcesses) {
//            if (appProcess.processName == packageName && appProcess.importance ==
//                ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
//            ) {
//                return false
//            }
//        }
//        return true
//    }
//}