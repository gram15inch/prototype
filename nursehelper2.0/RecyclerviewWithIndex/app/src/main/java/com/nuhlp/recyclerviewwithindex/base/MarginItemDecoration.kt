package com.nuhlp.recyclerviewwithindex.base

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(val margin:Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
     //   super.getItemOffsets(outRect, view, parent, state)
    val position = parent.getChildLayoutPosition(view)
        outRect.left = margin
        outRect.top = margin
        outRect.bottom  = margin

    }
}