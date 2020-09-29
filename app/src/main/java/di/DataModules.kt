package di

import android.app.Application
import android.content.Context
import com.example.terminalcommand_dagger2.Categories.CategoriesFragment
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentMvpPresenter
import com.example.terminalcommand_dagger2.Categories.CategoryFragmentPresenter
import com.example.terminalcommand_dagger2.command.CommandFragmentPresenter
import com.example.terminalcommand_dagger2.command.CommandListFragment
import com.example.terminalcommand_dagger2.command.CommandListFragmentMvpPresenter
import com.example.terminalcommand_dagger2.command.CommandListFragmentMvpView
import com.example.terminalcommand_dagger2.service.*
import com.example.terminalcommand_dagger2.service.apiService.ApiServices
import com.example.terminalcommand_dagger2.service.apiService.ApiServicesImp
import com.example.terminalcommand_dagger2.service.apiService.RestApi
import com.example.terminalcommand_dagger2.service.apiService.RetrofitClient
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

    @Provides
    fun provideDataManager(apiServices: ApiServices): DataManager {
        return DataManagerImp(apiServices)

    }

    @Provides
    fun provideApiServices(categoryServices: CategoryServices): ApiServices {
        return ApiServicesImp(
            categoryServices
        )
    }

    @Provides
    fun provideCategoryServices(retrofitClient: RetrofitClient): CategoryServices {
        return CategortServicesImp(retrofitClient)

    }

    @Provides
    fun provideRetrofitClient(): RetrofitClient {
        return RetrofitClient()
    }

    @Provides
    fun provideCategoryFragmentMvpPresenter(dataManager: DataManager): CategoryFragmentMvpPresenter {
        return CategoryFragmentPresenter(dataManager);
    }

    @Provides
    fun provideCategoriesFragment(presenter: CategoryFragmentPresenter): CategoriesFragment {

        return CategoriesFragment(presenter)
    }
  @Provides
  fun provideCommandListFragmentMvpPresenter(dataManager: DataManager):CommandListFragmentMvpPresenter{
      return CommandFragmentPresenter(dataManager)
  }

     @Provides
    fun provideCommandListFragment(presenter: CommandFragmentPresenter):CommandListFragment{
         return CommandListFragment(presenter)
     }


}