package com.example.hw_6_3_akylbek.data.module

import com.example.hw_6_3_akylbek.BuildConfig
import com.example.hw_6_3_akylbek.data.api.CharacterApiService
import com.example.hw_6_3_akylbek.data.api.EpisodeApiService
import com.example.hw_6_3_akylbek.data.api.LocationApiService
import com.example.hw_6_3_akylbek.data.repository.CharacterRepository
import com.example.hw_6_3_akylbek.data.repository.EpisodeRepository
import com.example.hw_6_3_akylbek.data.repository.LocationRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single { provideLoggingInterceptor() }
    single { provideOkHttpClient(loggingInterceptor = get()) }
    single { provideRetrofit(okHttpClient = get()) }

    single <CharacterApiService> {get<Retrofit>().create(CharacterApiService::class.java)}
    single { CharacterRepository(characterApiService = get()) }

    single<EpisodeApiService> { get<Retrofit>().create(EpisodeApiService::class.java) }
    single { EpisodeRepository(get()) }

    single<LocationApiService> { get<Retrofit>().create(LocationApiService::class.java) }
    single { LocationRepository(get()) }
}

private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}

private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}