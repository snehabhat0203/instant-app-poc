package com.example.instantapppoc.service

import retrofit2.http.GET

interface RemoteService {
    @GET("/list")
    suspend fun getFeed(): List<Photo>

    companion object {
        const val ENDPOINT = "https://unsplash.it"
    }
}