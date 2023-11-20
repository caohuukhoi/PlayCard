package com.khoich.playcard.ui.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.khoich.playcard.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, M : BaseViewModel> : DaggerAppCompatActivity() {

    protected lateinit var binding: T
    protected lateinit var viewModel: M

    protected var dialog: AlertDialog? = null

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun viewModelClass(): Class<M>

    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes());
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this, viewModelFactory)[viewModelClass()]
        initView()
        createDialog()
    }

    private fun createDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_loading, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        dialog = dialogBuilder.create()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
    }

    fun showLoading() {
        dialog?.show()
    }

    fun hiddenLoading() {
        dialog?.dismiss()
    }
}