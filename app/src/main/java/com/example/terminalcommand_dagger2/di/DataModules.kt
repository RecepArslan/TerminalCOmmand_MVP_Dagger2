package com.example.terminalcommand_dagger2.di

import android.app.Application
import android.content.Context
import com.example.terminalcommand_dagger2.Categories.CategoriesFragment
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentMvpPresenter
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentMvpView
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentPresenter
import com.example.terminalcommand_dagger2.base.BasePresenter
import com.example.terminalcommand_dagger2.base.MvpView
import com.example.terminalcommand_dagger2.command.CommandFragmentPresenter
import com.example.terminalcommand_dagger2.command.CommandListFragment
import com.example.terminalcommand_dagger2.command.CommandListFragmentMvpPresenter
import com.example.terminalcommand_dagger2.command.CommandListFragmentMvpView
import com.example.terminalcommand_dagger2.service.*
import com.example.terminalcommand_dagger2.service.apiService.ApiServices
import com.example.terminalcommand_dagger2.service.apiService.ApiServicesImp
import com.example.terminalcommand_dagger2.service.apiService.RestApi
import com.example.terminalcommand_dagger2.service.apiService.RetrofitClient
import com.example.terminalcommand_dagger2.splashScreen.SpashScreenPresenter
import com.example.terminalcommand_dagger2.splashScreen.SplashScreenMvpPresenter
import com.example.terminalcommand_dagger2.splashScreen.SplashScreenMvpView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModules(app: Application) {
    private val context: Context

    init {
        this.context = app
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideDataManager(apiServices: ApiServices): DataManager {
        return DataManagerImp(apiServices)

    }

    @Singleton
    @Provides
    fun provideBasePresenter(dataManager: DataManager): BasePresenter<MvpView> {
        return BasePresenter(dataManager)
    }

    @Singleton
    @Provides
    fun provideApiServices(categoryServices: CategoryServices): ApiServices {
        return ApiServicesImp(
            categoryServices
        )
    }

    @Singleton
    @Provides
    fun provideCategoryServices(retrofitClient: RetrofitClient): CategoryServices {
        return CategortServicesImp(retrofitClient)

    }

    @Singleton
    @Provides
    fun provideRetrofitClient(): RetrofitClient {
        return RetrofitClient()
    }

    @Singleton
    @Provides
    fun provideCategoryFragmentMvpPresenter(dataManager: DataManager): CategoryFragmentMvpPresenter<CategoryFragmentMvpView> {
        return CategoryFragmentPresenter(dataManager);
    }

    @Singleton
    @Provides
    fun provideCommandListFragmentMvpPresenter(dataManager: DataManager): CommandListFragmentMvpPresenter<CommandListFragmentMvpView> {
        return CommandFragmentPresenter(dataManager)
    }

    @Singleton
    @Provides
    fun provideSplashScreenMvpPresenter(dataManager: DataManager): SplashScreenMvpPresenter<SplashScreenMvpView> {
        return SpashScreenPresenter(dataManager)
    }


}