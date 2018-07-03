package com.jia.demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jia.demo.R;
import com.jia.demo.view.itemDecoration.SectionItemDecoration;

public class ItemDecorationActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_decoration);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_item_decoration);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ItemAdapter());
        mRecyclerView.addItemDecoration(new SectionItemDecoration(this, new SectionItemDecoration.DecorationCallback() {
            @Override
            public long getGroupId(int position) {
                return position / 3 ;
            }

            @Override
            public String getGroupFirstLine(int position) {
                return position / 3 + "";
            }
        }));
    }

    public class ItemAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(ItemDecorationActivity.this).inflate(R.layout.item_item_decoration, parent, false);
            return new ItemViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 30;
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
