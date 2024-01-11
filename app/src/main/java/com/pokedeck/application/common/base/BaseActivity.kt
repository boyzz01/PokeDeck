package com.pokedeck.application.common.base

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.garage.application.common.widget.CustomProgressBar
import javax.inject.Inject

abstract class BaseActivity<T : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    private var _binding: T? = null
    val binding: T
        get() = _binding!!

    abstract val viewModel: VM

    abstract fun getViewBinding(): T

    @Inject
    lateinit var mCustomProgressBar: CustomProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)

        @SuppressLint("SourceLockedOrientationActivity")
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        mCustomProgressBar.init(this)
        setupViews()
        observeViewModel()
    }

    abstract fun setupViews()

    abstract fun observeViewModel()

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}