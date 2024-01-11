package com.garage.application.common.widget

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.github.ybq.android.spinkit.SpinKitView
import com.pokedeck.application.R
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CustomProgressBar @Inject constructor() {

    private var mProgressBarDialog: AlertDialog? = null

    private lateinit var ivProgress: SpinKitView

    private lateinit var mActivity: Activity

    var isVisible = false

    fun init(activity: Activity) {
        this.mActivity = activity
        val dialogBuilder = AlertDialog.Builder(mActivity, R.style.CustomDialog)
        val inflater = mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.layout_progressbar_with_background, null, true)
        ivProgress = dialogView.findViewById(R.id.spin_kit)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        mProgressBarDialog = dialogBuilder.create()
    }

    fun showProgressBar() {
        isVisible = true
        mProgressBarDialog?.let {
            if (!it.isShowing && !mActivity.isFinishing) {
                it.show()
            }
        }
    }

    fun hideProgressBar() {
        isVisible = false
        try {
            mProgressBarDialog?.let {
                if (it.isShowing && !mActivity.isFinishing) {
                    it.dismiss()
                }
            }
        } catch (_: IllegalArgumentException) {
        }
    }

}