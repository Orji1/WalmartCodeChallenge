package com.example.walmart_challenge_qv.utils

import com.example.walmart_challenge_qv.model.CountriesDetails

sealed interface ResponseState {
    object LOADING: ResponseState
    class SUCCESS(val countries: List<CountriesDetails>): ResponseState
    class ERROR(val error: Throwable): ResponseState
}