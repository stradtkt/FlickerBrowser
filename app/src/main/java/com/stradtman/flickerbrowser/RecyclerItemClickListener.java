package com.stradtman.flickerbrowser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = "RecyclerItemClickListen";
    interface OnRecyclerClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
    private final OnRecyclerClickListener mListener;
    private final GestureDetectorCompat mGestureDetectorCompat;

    public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnRecyclerClickListener listener) {
        mListener = listener;
        mGestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return super.onSingleTapUp(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, @NonNull MotionEvent e) {
        Log.d(TAG, "onInterceptTouchEvent: starts");
        if(mGestureDetectorCompat != null) {
            boolean result = mGestureDetectorCompat.onTouchEvent(e);
            Log.d(TAG, "onInterceptTouchEvent: returned" + result);
            return result;
        } else {
            Log.d(TAG, "onInterceptTouchEvent: returned: false");
            return false;
        }
    }
}
