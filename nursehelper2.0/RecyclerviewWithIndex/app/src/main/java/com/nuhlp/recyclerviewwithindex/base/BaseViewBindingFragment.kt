package com.nuhlp.recyclerviewwithindex.base

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.nuhlp.recyclerviewwithindex.components.TAG2


abstract class  BaseViewBindingFragment<T : ViewBinding> : Fragment() {
    private var _binding: T? = null
    protected val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = getFragmentBinding(layoutInflater,container)
        return binding.root
    }
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}