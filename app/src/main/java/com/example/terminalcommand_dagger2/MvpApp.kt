package com.example.terminalcommand_dagger2

import android.app.Application
import di.DaggerViewComponents
import di.DataModules
import di.ViewComponents


class MvpApp : Application() {

    var viewComponents: ViewComponents? = null

    override fun onCreate() {
        super.onCreate()
        viewComponents = DaggerViewComponents
            .builder().dataModules(DataModules(this)).build()

    }
}