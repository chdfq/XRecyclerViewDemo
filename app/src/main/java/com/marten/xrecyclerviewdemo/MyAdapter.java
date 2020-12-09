package com.marten.xrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class MyAdapter extends XRecyclerView.Adapter {

    private Context mContext;

    public MyAdapter(Context context) {
        mContext = context;
    }


    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.xrv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).textView.setText("Hello XRecyclerView");
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class MyViewHolder extends XRecyclerView.ViewHolder {

        private TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
