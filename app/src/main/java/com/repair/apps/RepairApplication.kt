package com.repair.apps


import com.xsj.crasheye.Crasheye
import nearby.lib.base.app.ApplicationProvider
import nearby.lib.base.app.ModuleInit
import nearby.lib.base.app.ModuleInitDelegate
import nearby.lib.router.Router

class RepairApplication : ApplicationProvider() {

    init {
        ModuleInitDelegate.register(ModuleInit())
    }

    override fun onCreate() {
        super.onCreate()
        Crasheye.init(this, "ad9a3v6t")
        Router.init(this,false)
    }
}