package com.babic.filip.movieshack.listener

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class LastItemReachedListener(private val onLastItemReached: () -> Unit) : RecyclerView.OnScrollListener() {

    private val threshold = 20

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val manager = recyclerView!!.layoutManager as LinearLayoutManager

        if (Math.abs(dy) > threshold && hasReachedEnd(manager, recyclerView)) {
            onLastItemReached()
        }
    }

    private fun hasReachedEnd(manager: LinearLayoutManager?, recyclerView: RecyclerView?): Boolean {
        if (manager != null && recyclerView != null && recyclerView.adapter != null) {
            val pos = manager.findLastVisibleItemPosition()
            val numItems = recyclerView.adapter.itemCount
            return pos >= numItems - 3
        }

        return false
    }
}
