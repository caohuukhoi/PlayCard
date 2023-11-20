package com.khoich.playcard.ui.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, M : BaseViewModel> : DaggerFragment() {

    companion object{
        const val KEY_DETAIL = "KEY_DETAIL"
    }

    protected lateinit var binding: T
    protected lateinit var viewModel: M

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    @LayoutRes
    protected abstract fun layoutRes(): Int
    protected abstract fun viewModelClass(): Class<M>
    protected abstract fun initView()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this, viewModelFactory)[viewModelClass()]
        initView()
    }
//
//    fun Fragment.getNavController(): NavController =
//        NavHostFragment.findNavController(this)

}