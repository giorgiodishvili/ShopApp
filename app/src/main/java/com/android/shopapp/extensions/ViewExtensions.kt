package com.android.shopapp.extensions

import android.app.Dialog
import android.view.View


fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hideIf(show: Boolean) {
    if (show) {
        show()
    } else {
        hide()
    }
}

fun Dialog.setUp(dialogView: Int) {
//    setContentView(dialogView)
//    window!!.setBackgroundDrawableResource(android.R.color.transparent)
//    window!!.requestFeature(Window.FEATURE_NO_TITLE)
//    window!!.attributes.width = WindowManager.LayoutParams.MATCH_PARENT
//    window!!.attributes.height = WindowManager.LayoutParams.WRAP_CONTENT
}