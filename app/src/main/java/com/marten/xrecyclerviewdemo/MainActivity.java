package com.marten.xrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mXrv;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mXrv = findViewById(R.id.xrv_1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXrv.setLayoutManager(layoutManager);
        mXrv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mXrv.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        mXrv.setItemViewCacheSize(10);
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //mAdapter.notifyDataSetChanged();
                mXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                //mAdapter.notifyDataSetChanged();
                mXrv.loadMoreComplete();
            }
        });
        mXrv.setAdapter(new MyAdapter(MainActivity.this));
    }
}