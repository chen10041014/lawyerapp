package com.yuanjin.attorney.attorney.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cyj on 2017/08/03.
 * 自定义侧滑删除view
 */

public class SwipeDelete extends ViewGroup {

    private static final String TAG = "SwipeDelete";
    private View mLeftView;
    private View mRightView;
    private int mLeftHeight;
    private int mLeftWidth;
    private int mRightHeight;
    private int mRightWidth;
    private ViewDragHelper mViewDragHelper;

    public SwipeDelete(Context context) {
        this(context,null);
    }

    public SwipeDelete(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mViewDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                //只要是第一个手指头，都允许拖动，与要拖动的View无关
                return pointerId==0;
            }

            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                if (child==mLeftView){
                    if (left<-mRightWidth){
                        left = -mRightWidth;
                    }else if (left>0){
                        left = 0;
                    }
                }else if (child==mRightView){
                    if (left<mLeftWidth-mRightWidth){
                        left = mLeftWidth - mRightWidth;
                    }else if (left>mLeftWidth){
                        left = mLeftWidth;
                    }
                }
                return left;
            }


            @Override
            public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
                super.onViewPositionChanged(changedView, left, top, dx, dy);
                if (changedView==mLeftView){
                    int newLeft = mRightView.getLeft()+dx;
                    mRightView.layout(newLeft,0,newLeft+mRightWidth,mRightHeight);
                }else if (changedView==mRightView){
                    int newLeft = mLeftView.getLeft()+dx;
                    mLeftView.layout(newLeft,0,newLeft+mLeftWidth,mLeftHeight);
                }
            }

            @Override
            public void onViewReleased(View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
                if (mLeftView.getLeft()<-mRightWidth/2){
                    open();
                }else{
                    close();
                }
            }

            @Override
            public int getViewHorizontalDragRange(View child) {
                return mRightWidth;
            }

        });
    }

    private void close() {
        mViewDragHelper.smoothSlideViewTo(mLeftView,0,0);
        postInvalidateOnAnimation();

        SwipeDeleteManager.getInstance().setCurrentOpendItem(null);
    }

    private void open() {
        mViewDragHelper.smoothSlideViewTo(mLeftView,-mRightWidth,0);
        postInvalidateOnAnimation();
        SwipeDeleteManager.getInstance().setCurrentOpendItem(this);

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mViewDragHelper.continueSettling(true)){
            postInvalidateOnAnimation();
        }
    }

    public SwipeDelete(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public SwipeDelete(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mLeftView = getChildAt(0);
        mRightView = getChildAt(1);
        //测量子控件
        measureChild(mLeftView,widthMeasureSpec,heightMeasureSpec);
        measureChild(mRightView,widthMeasureSpec,heightMeasureSpec);

        mLeftWidth = mLeftView.getMeasuredWidth();
        mLeftHeight = mLeftView.getMeasuredHeight();

        mRightWidth = mRightView.getMeasuredWidth();
        mRightHeight = mRightView.getMeasuredHeight();

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mLeftView.layout(0,0,mLeftWidth,mLeftHeight);
        mRightView.layout(mLeftWidth,0,mLeftWidth+mRightWidth,mRightHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        SwipeDelete swipeDelete = SwipeDeleteManager.getInstance().getSwipeDelete();
        if (swipeDelete!=null&&swipeDelete!=this){
            swipeDelete.close();
        }
        boolean shouldInterceptTouchEvent = mViewDragHelper.shouldInterceptTouchEvent(ev);
        return shouldInterceptTouchEvent;
    }

    static class SwipeDeleteManager{
        private SwipeDeleteManager(){}
        private SwipeDelete mSwipeDelete;
        private static SwipeDeleteManager sSwipeDeleteManager ;
        public static SwipeDeleteManager getInstance(){
            if (sSwipeDeleteManager==null){
                sSwipeDeleteManager = new SwipeDeleteManager();
            }
            return sSwipeDeleteManager;
        }

        public void setCurrentOpendItem(SwipeDelete swipeDelete) {
            this.mSwipeDelete = swipeDelete;
        }

        public SwipeDelete getSwipeDelete() {
            return mSwipeDelete;
        }
    }
}
