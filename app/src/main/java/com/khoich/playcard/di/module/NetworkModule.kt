package com.khoich.playcard.di.module

import com.intuit.sdp.BuildConfig
import com.khoich.playcard.util.AppConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class NetworkModule {

    // https ://fakestoreapi.com/products
    // BASE_URL_NEW: https ://fakestoreapi.com/    END_POINT: products

    companion object {
        private const val BASE_URL_NEW = "https://fakestoreapi.com/"
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_NEW)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            // thực ra JSON chỉ là 1 kiểu dữlieueju String, Retrofit cung cấp 1 cái GsonConverterFactory để chuyển String thành JSON
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        // Đây là interceptor có nhiệm vụ là in ra các apo và data trả về
        // in ra để biết là api đang được gọi là gì, đúng không dữ liệu trả về đúng hay sai
        val loggingInterceptor = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG) {
            // nếu là chạy debug thì mới in ra
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(AppConfig.Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(AppConfig.Constant.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}