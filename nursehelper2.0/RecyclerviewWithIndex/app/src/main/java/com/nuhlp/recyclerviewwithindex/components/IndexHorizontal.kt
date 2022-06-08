package com.nuhlp.recyclerviewwithindex.components

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import com.nuhlp.recyclerviewwithindex.R


class IndexHorizontal(context: Context, attrs: AttributeSet) :LinearLayout(context,attrs) {

    private lateinit var elements : List<TextView>
    private var indexString : String
    val v : View
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v= inflater.inflate(R.layout.index_horizontal, this)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.index_horizontal,
            0, 0).apply {
            try {
                indexString = getString(R.styleable.index_horizontal_indexString)?:"noting"
                setElements(indexString)
               //val typeArray = context.obtainStyledAttributes(attrs, R.styleable.index_horizontal)
            } finally {
                recycle()
            }
        }
    }

    private fun setElements(str: String) {
        // todo 커스텀 뷰에 글자넣기
    /*    val v = v as ViewGroup
            elements = v.children.toList() as List<TextView>
        for(e in v.children.toList())
            Log.d("indexComponent","$e")
        elements.forEachIndexed{i,e->
               if(str.get(i) !=null)
                 e.text= str[i].toString()
               else e.text = "*"
           }*/
        onRefresh()
    }

    private fun onRefresh(){
        invalidate()
        requestLayout()
    }

/*

    fun setTitleText(text: String?){
        mLayout_Setingitemview_Textview_Title.text = text
        onRefresh()
    }

    fun setContentText(text: String?){
        mLayout_Setingitemview_Textview_Content.text = text
        onRefresh()
    }

    fun setTitleTextColor(color: Int){
        mLayout_Setingitemview_Textview_Title.setTextColor(color)
        onRefresh()
    }

    fun setContentTextColor(color: Int){
        mLayout_Setingitemview_Textview_Content.setTextColor(color)
        onRefresh()
    }
*/


}