package com.nuhlp.recyclerviewwithindex.components

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.nuhlp.recyclerviewwithindex.R

class IndexRecyclerView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
) : RecyclerView(context, attrs) {
    val TAG  = "IndexRecycler"
    private val liveIndexH = LiveIndex(context,this)
    private val liveIndexV = LiveIndex(context,this)

    init{
        liveIndexV.isHorizontal = false
        liveIndexH.updateItem(createItem(1))
        liveIndexV.updateItem(createItem(121))
        background = context.resources.getDrawable(R.drawable.bg_rect_round_2)
    }

    // * state *

    override fun onTouchEvent(e: MotionEvent?): Boolean {
       if(liveIndexH.onTouchEvent(e)||liveIndexV.onTouchEvent(e)){
           invalidate()
           return true
       }
        else
            return super.onTouchEvent(e)
    }

    override fun draw(c: Canvas?) {
        super.draw(c)
        liveIndexH.onDraw(c)
        liveIndexV.onDraw(c)
    }

    fun getLiveData(isHorizontal:Boolean):LiveData<Int>{
        return if(isHorizontal)
            liveIndexH.unit
        else
            liveIndexV.unit
    }


    private fun updateAdapterPosition(pos :Int){

    }

    private fun printLog(str: Any) {
        Log.d(TAG, "$str")
    }

    fun createItem(i :Int):List<Int>{
        val list = mutableListOf<Int>()
        when(i){
            1->{
                for(i in 1..30)
                    if(i%2 == 0)
                        list.add(i)
            }
            2->{
                for(i in 1..30)
                    if(i%3 == 0)
                        list.add(i)
            }
            12->{
                for(i in 1..12)
                    list.add(i)
            }
            30->{
                for(i in 1..30)
                    list.add(i)
            }
            121->{
                for(i in 1..12)
                    if(i%2 == 0)
                        list.add(i)
            }
            else->{
                for(i in 1..1)
                    list.add(i)
            }

        }
        return list
    }
}