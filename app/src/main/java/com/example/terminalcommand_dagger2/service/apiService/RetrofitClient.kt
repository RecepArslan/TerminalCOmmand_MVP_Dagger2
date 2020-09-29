package com.example.terminalcommand_dagger2.service.apiService

import com.example.terminalcommand_dagger2.TimeOutConnect
import com.example.terminalcommand_dagger2.TimeOutRead
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitClient
@Inject
constructor() {
    private val Base_Url = "https://terminalcommands.herokuapp.com/"

    private val AUTH: String = "Basic" + android.util.Base64.encodeToString(
        "recep:123456".toByteArray(charset("UTF-8")),
        android.util.Base64.NO_WRAP
    )

    fun getClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(TimeOutRead, TimeUnit.SECONDS)
            .connectTimeout(TimeOutConnect, TimeUnit.SECONDS)
            .addInterceptor { chain ->

                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .method(original.method(), original.body())
                //burada header vardı fakat hata veriyordu
                val request = requestBuilder.build()
                chain.proceed(request)

            }.build()



        return Retrofit.Builder().baseUrl(Base_Url).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}