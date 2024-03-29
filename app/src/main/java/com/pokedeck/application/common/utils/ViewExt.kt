package com.pokedeck.application.common.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import es.dmoral.toasty.Toasty

enum class ToastType {
    Normal, Success, Error
}

fun showCustomToast(
    context: Context,
    message: String,
    toastType: ToastType = ToastType.Normal,
) {
    when (toastType) {
        ToastType.Normal -> Toasty.info(context, message, Toast.LENGTH_SHORT).show()
        ToastType.Error -> Toasty.error(context, message, Toast.LENGTH_SHORT).show()
        ToastType.Success -> Toasty.success(context, message, Toast.LENGTH_SHORT).show()
    }

}