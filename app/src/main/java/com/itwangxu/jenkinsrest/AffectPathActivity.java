package com.itwangxu.jenkinsrest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itwangxu.jenkinsrest.net.BaseActivity;

import java.util.List;

/**
 * 创建日期：2018/9/3 17:02
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class AffectPathActivity extends BaseActivity {

    private SwipeRefreshLayout swipeView;
    private List<String> mStringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_log);
        getIntentData();
        swipeView = (SwipeRefreshLayout) findViewById(R.id.swipeView);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AffectPathAdapter());
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeView.setRefreshing(false);
                    }
                },1500);
            }
        });
    }

    private void getIntentData() {
        mStringList = (List<String>) getIntent().getSerializableExtra("affectPath");
    }


    class AffectPathAdapter extends RecyclerView.Adapter<AffectPathAdapter.ViewHolder> {

        @NonNull
        @Override
        public AffectPathAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = View.inflate(AffectPathActivity.this, R.layout.cell_affect_path, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AffectPathAdapter.ViewHolder viewHolder, int i) {
           String changeSetBean = mStringList.get(i);
            viewHolder.author.setText("文件： \n" + changeSetBean);
        }

        @Override
        public int getItemCount() {
            return mStringList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView author;

            public ViewHolder(@NonNull View view) {
                super(view);
                author = (TextView) view.findViewById(R.id.author);

            }
        }
    }
}
