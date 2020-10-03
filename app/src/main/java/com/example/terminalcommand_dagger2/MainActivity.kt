package com.example.terminalcommand_dagger2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

import com.example.terminalcommand_dagger2.Categories.CategoriesFragment
import com.example.terminalcommand_dagger2.splashScreen.SplashScreenFragment

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragment:SplashScreenFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MvpApp).viewComponents?.injectMainActivity(this)


        goFragment(R.id.activity_mainActivity_frameLayout, fragment,this)


    }


}