package di

import com.example.terminalcommand_dagger2.Categories.CategoriesFragment
import com.example.terminalcommand_dagger2.MainActivity
import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModules::class])
interface ViewComponents {
    fun injectMainActivity(CategoriesFragment: MainActivity) {

    }

    fun injectCategories(categoriesFragment2: CategoriesFragment) {

    }

}