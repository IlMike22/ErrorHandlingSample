package com.example.errorhandlingsample.presentation

import com.example.errorhandlingsample.R
import com.example.errorhandlingsample.domain.DataError
import com.example.errorhandlingsample.domain.Result

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Local.DISK_FULL -> UiText.StringResource(R.string.disk_full)
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(R.string.request_time_out)
        else -> UiText.StringResource(R.string.unknown_error)
    }
}

fun Result.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}