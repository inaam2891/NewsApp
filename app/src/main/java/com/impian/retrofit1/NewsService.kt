package com.impian.retrofit1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=in&apiKey=5c942a53eab94150a2f08b416427e000


const val BASE_URL="https://newsapi.org/"
const val API_KEY ="5c942a53eab94150a2f08b416427e000"
interface NewsInterface {

	@GET("v2/top-headlines?apiKey=$API_KEY")
	fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>
}

//	https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1

	object NewsService {
		val newsInstance: NewsInterface

		init {
			val retrofit: Retrofit = Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl(BASE_URL)
				.build()
			newsInstance = retrofit.create(NewsInterface::class.java)

		}
	}
