package com.babic.filip.movieshack.listener;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public final class LastItemReachedListener extends RecyclerView.OnScrollListener {

    private final int threshold = 20;

    private final OnLastItemReachedListener listener;

    public LastItemReachedListener(final OnLastItemReachedListener lastItemReachedListener) {
        this.listener = lastItemReachedListener;
    }

    @Override
    public void onScrolled(final RecyclerView recyclerView, final int dx, final int dy) {
        super.onScrolled(recyclerView, dx, dy);

        final LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();

        if (Math.abs(dy) > threshold && hasReachedEnd(manager, recyclerView) && listener != null) {
            listener.onLastItemReached();
        }
    }

    private boolean hasReachedEnd(final LinearLayoutManager manager, final RecyclerView recyclerView) {
        if (manager != null && recyclerView != null && recyclerView.getAdapter() != null) {
            int pos = manager.findLastVisibleItemPosition();
            int numItems = recyclerView.getAdapter().getItemCount();
            return (pos >= numItems - 3);
        }

        return false;
    }

    public interface OnLastItemReachedListener {

        void onLastItemReached();
    }
}
