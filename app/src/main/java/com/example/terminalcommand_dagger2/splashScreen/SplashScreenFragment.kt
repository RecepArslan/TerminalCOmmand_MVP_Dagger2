package com.example.terminalcommand_dagger2.splashScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.terminalcommand_dagger2.Categories.CategoriesFragment
import com.example.terminalcommand_dagger2.R
import com.example.terminalcommand_dagger2.base.BaseFragment
import com.example.terminalcommand_dagger2.goFragment
import javax.inject.Inject


class SplashScreenFragment
@Inject constructor(var presenter: SpashScreenPresenter<SplashScreenMvpView>) :
    BaseFragment(),
    SplashScreenMvpView {
    @Inject
    lateinit var fragment: CategoriesFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.onAttach(this)
        presenter.startWaiting()
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun openCategoriesFragment() {
        goFragment(R.id.activity_mainActivity_frameLayout, fragment, requireContext())
    }

}