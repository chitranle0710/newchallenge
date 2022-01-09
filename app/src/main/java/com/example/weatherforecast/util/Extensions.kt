package com.example.weatherforecast.util

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun View?.beVisible() {
    this?.visibility = View.VISIBLE
}

fun View?.beInVisible() {
    this?.visibility = View.INVISIBLE
}

fun View?.beGone() {
    this?.visibility = View.GONE
}

@SuppressLint("ClickableViewAccessibility")
fun View.onClick(unit: () -> Unit) {
    val gestureListener = GestureDetector(context, GestureListener())
    if (this is Button) {
        setOnTouchListener { view1: View?, e: MotionEvent ->
            if (gestureListener.onTouchEvent(e)) {
                unit.invoke()
            }
            return@setOnTouchListener false
        }
    } else {
        setOnTouchListener { view1: View?, e: MotionEvent ->
            if (gestureListener.onTouchEvent(e)) {
                unit.invoke()
            }
            when (e.action) {
                MotionEvent.ACTION_DOWN -> {
                    alpha = 0.5f
                    return@setOnTouchListener true
                }
                MotionEvent.ACTION_UP -> {
                    alpha = 1.0f
                    return@setOnTouchListener true
                }
                MotionEvent.ACTION_CANCEL -> {
                    alpha = 1.0f
                    return@setOnTouchListener true
                }
            }
            false
        }
    }
}

class GestureListener : GestureDetector.SimpleOnGestureListener() {
    override fun onSingleTapUp(event: MotionEvent): Boolean {
        return true
    }
}

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, {
        it?.let(observer)
    })
}

