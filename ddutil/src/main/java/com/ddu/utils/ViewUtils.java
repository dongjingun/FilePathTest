//package com.ddu.utils;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.helper.ItemTouchHelper;
//import android.view.View;
//
//import com.wooyee.xbition.adapter.RendererAdapter;
//import com.wooyee.xbition.interfaces.ItemTouchHelperAdapter;
//
//
//public class ViewUtils {
//    public ViewUtils() {
//    }
//
//    public static <T extends RendererAdapter> T configRecyclerView(RecyclerView recyclerView, T adapter) {
//        return configRecyclerView(recyclerView, adapter, (ItemClickSupport.OnItemClickListener)null, (ItemClickSupport.OnItemLongClickListener)null);
//    }
//
//    public static <T extends RendererAdapter> T configRecyclerView(RecyclerView recyclerView, T adapter, ItemClickSupport.OnItemClickListener itemClickListener) {
//        return configRecyclerView(recyclerView, adapter, itemClickListener, (ItemClickSupport.OnItemLongClickListener)null);
//    }
//
//    public static <T extends RendererAdapter> T configRecyclerView(RecyclerView recyclerView, T adapter, ItemClickSupport.OnItemClickListener clickListener, ItemClickSupport.OnItemLongClickListener longClickListener) {
//        recyclerView.setHasFixedSize(true);
//        Context context = recyclerView.getContext();
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, adapter.getSpanCount(), adapter.getOrientation(), adapter.isReverseLayout());
//        recyclerView.setLayoutManager(gridLayoutManager);
//        if(longClickListener != null) {
//            ItemClickSupport.addTo(recyclerView).setOnItemLongClickListener(longClickListener);
//        }
//
//        if(clickListener != null) {
//            ItemClickSupport.addTo(recyclerView).setOnItemClickListener(clickListener);
//        }
//
//        if(adapter instanceof ItemTouchHelperAdapter) {
//            SimpleItemTouchHelperCallback callback = new SimpleItemTouchHelperCallback((ItemTouchHelperAdapter)adapter);
//            ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
//            mItemTouchHelper.attachToRecyclerView(recyclerView);
//            adapter.setItemTouchCallback(callback);
//        }
//
//        recyclerView.setAdapter(adapter);
//        return adapter;
//    }
//
//    public static void setBackground(View v, Drawable drawable) {
//        if(VersionUtils.isAPI16()) {
//            v.setBackground(drawable);
//        } else {
//            v.setBackgroundDrawable(drawable);
//        }
//
//    }
//}
