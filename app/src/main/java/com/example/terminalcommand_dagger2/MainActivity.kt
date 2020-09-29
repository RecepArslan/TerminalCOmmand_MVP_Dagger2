package com.example.terminalcommand_dagger2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction

import com.example.terminalcommand_dagger2.Categories.CategoriesFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    public lateinit var fragment: CategoriesFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MvpApp).viewComponents?.injectMainActivity(this)


        createFragment(R.id.activity_mainActivity_frameLayout, fragment,this)


    }

    fun createFragment(Location: Int, fragment: Fragment,context:Context) {
        (context as FragmentActivity).supportFragmentManager.beginTransaction()
            .replace(Location, fragment, null)
            .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null)
            .commit()


    }
}