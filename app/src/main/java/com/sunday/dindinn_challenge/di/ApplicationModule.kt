package com.sunday.dindinn_challenge.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sunday.dindinn_challenge.service.MockApi
import com.sunday.dindinn_challenge.service.MockApiClient
import com.sunday.dindinn_challenge.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.annotation.Nonnull
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    companion object {
        @Provides
        @Singleton
        fun provideGson(): Gson {
            return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        }

        @Singleton
        @Provides
        fun provideRetrofit(@Nonnull gson: Gson) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        fun provideMockApiService(retrofit: Retrofit) : MockApi = retrofit
            .create(MockApi::class.java)

        @Singleton
        @Provides
        fun provideMockApiClient(api: MockApi) : MockApiClient = MockApiClient(api = api)
    }

}