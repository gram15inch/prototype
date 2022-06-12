package com.nuhlp.recyclerviewwithindex.ui.learning

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.nuhlp.recyclerviewwithindex.R
import com.nuhlp.recyclerviewwithindex.base.BaseViewBindingFragment
import com.nuhlp.recyclerviewwithindex.databinding.FragmentCustomViewPracBinding



class CustomViewPracFragment :BaseViewBindingFragment<FragmentCustomViewPracBinding>() {

    var x= 1f
    var y= 100f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()

    }

   private fun setListener()=binding.apply {
            rect1.setOnClickListener {
                x +=100
                myCustomView.setXY(x,y)
            }
   }
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCustomViewPracBinding {
       return FragmentCustomViewPracBinding.inflate(inflater,container,false)
    }

}