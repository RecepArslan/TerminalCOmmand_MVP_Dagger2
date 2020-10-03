package com.example.terminalcommand_dagger2

import android.app.Application
import com.example.terminalcommand_dagger2.di.DaggerViewComponents
import com.example.terminalcommand_dagger2.di.DataModules
import com.example.terminalcommand_dagger2.di.ViewComponents


class MvpApp : Application() {

    var viewComponents: ViewComponents? = null

    override fun onCreate() {
        super.onCreate()
        viewComponents = DaggerViewComponents
            .builder().dataModules(
                DataModules(
                    this
                )
            ).build()

    }
}