//package com.ddu.utils;
//
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnLongClickListener;
//
//public class ItemClickSupport {
//    private final RecyclerView mRecyclerView;
//    private OnItemClickListener mOnItemClickListener;
//    private OnItemLongClickListener mOnItemLongClickListener;
//    private OnClickListener mOnClickListener = new OnClickListener() {
//        public void onClick(View v) {
//            if(ItemClickSupport.this.mOnItemClickListener != null) {
//                ViewHolder holder;
//                try {
//                    holder = ItemClickSupport.this.mRecyclerView.getChildViewHolder(v);
//                } catch (IllegalArgumentException var4) {
//                    holder = ItemClickSupport.this.mRecyclerView.getChildViewHolder((View)v.getParent());
//                }
//
////                if(ItemClickSupport.this.mRecyclerView instanceof XRecyclerView) {
////                    XRecyclerView xRecyclerView = (XRecyclerView)ItemClickSupport.this.mRecyclerView;
////                    ItemClickSupport.this.mOnItemClickListener.onItemClicked(ItemClickSupport.this.mRecyclerView, holder.getAdapterPosition() - xRecyclerView.getHeadersCount(), v);
////                } else {
//                    ItemClickSupport.this.mOnItemClickListener.onItemClicked(ItemClickSupport.this.mRecyclerView, holder.getAdapterPosition(), v);
////                }
//            }
//
//        }
//    };
//    private OnLongClickListener mOnLongClickListener = new OnLongClickListener() {
//        public boolean onLongClick(View v) {
//            if(ItemClickSupport.this.mOnItemLongClickListener != null) {
//                ViewHolder holder = ItemClickSupport.this.mRecyclerView.getChildViewHolder(v);
//                return ItemClickSupport.this.mOnItemLongClickListener.onItemLongClicked(ItemClickSupport.this.mRecyclerView, holder.getAdapterPosition(), v);
//            } else {
//                return false;
//            }
//        }
//    };
//    private OnChildAttachStateChangeListener mAttachListener = new OnChildAttachStateChangeListener() {
//        public void onChildViewAttachedToWindow(View view) {
//            if(ItemClickSupport.this.mOnItemClickListener != null) {
////                if(ItemClickSupport.this.mRecyclerView instanceof XRecyclerView) {
////                    XRecyclerView xRecyclerView = (XRecyclerView)ItemClickSupport.this.mRecyclerView;
////                    if(xRecyclerView.isHeader(ItemClickSupport.this.mRecyclerView.getChildViewHolder(view).getLayoutPosition()) || ((XRecyclerView)ItemClickSupport.this.mRecyclerView).isFooter(ItemClickSupport.this.mRecyclerView.getChildViewHolder(view).getLayoutPosition())) {
////                        return;
////                    }
////                }
//
//                view.setOnClickListener(ItemClickSupport.this.mOnClickListener);
//            }
//
//            if(ItemClickSupport.this.mOnItemLongClickListener != null) {
//                view.setOnLongClickListener(ItemClickSupport.this.mOnLongClickListener);
//            }
//
//        }
//
//        public void onChildViewDetachedFromWindow(View view) {
//        }
//    };
//
//    private ItemClickSupport(RecyclerView recyclerView) {
//        this.mRecyclerView = recyclerView;
//        this.mRecyclerView.setTag(id.item_click_support, this);
//        this.mRecyclerView.addOnChildAttachStateChangeListener(this.mAttachListener);
//    }
//
//    public static ItemClickSupport addTo(RecyclerView view) {
//        ItemClickSupport support = (ItemClickSupport)view.getTag(id.item_click_support);
//        if(support == null) {
//            support = new ItemClickSupport(view);
//        }
//
//        return support;
//    }
//
//    public static ItemClickSupport removeFrom(RecyclerView view) {
//        ItemClickSupport support = (ItemClickSupport)view.getTag(id.item_click_support);
//        if(support != null) {
//            support.detach(view);
//        }
//
//        return support;
//    }
//
//    public ItemClickSupport setOnItemClickListener(OnItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//        return this;
//    }
//
//    public ItemClickSupport setOnItemLongClickListener(OnItemLongClickListener listener) {
//        this.mOnItemLongClickListener = listener;
//        return this;
//    }
//
//    private void detach(RecyclerView view) {
//        view.removeOnChildAttachStateChangeListener(this.mAttachListener);
//        view.setTag(id.item_click_support, (Object)null);
//    }
//
//    public interface OnItemLongClickListener {
//        boolean onItemLongClicked(RecyclerView var1, int var2, View var3);
//    }
//
//    public interface OnItemClickListener {
//        void onItemClicked(RecyclerView var1, int var2, View var3);
//    }
//}
