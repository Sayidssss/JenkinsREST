package com.itwangxu.jenkinsrest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itwangxu.jenkinsrest.bean.BuildDetailBean;
import com.itwangxu.jenkinsrest.net.BaseActivity;

import java.io.Serializable;

/**
 * 创建日期：2018/9/3 17:02
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class ChangeLogActivity extends BaseActivity {

    private SwipeRefreshLayout swipeView;
    private BuildDetailBean.ChangeSetBean mBuildDetailBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_log);
        getIntentData();
        swipeView =  findViewById(R.id.swipeView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ChangeLogAdapter());
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
        mBuildDetailBean = (BuildDetailBean.ChangeSetBean) getIntent().getSerializableExtra("detailBean");
    }


    class ChangeLogAdapter extends RecyclerView.Adapter<ChangeLogAdapter.ViewHolder> {

        @NonNull
        @Override
        public ChangeLogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = View.inflate(ChangeLogActivity.this, R.layout.cell_change_log, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ChangeLogAdapter.ViewHolder viewHolder, int i) {
            final BuildDetailBean.ChangeSetBean.ItemsBean changeSetBean = mBuildDetailBean.getItems().get(i);
            viewHolder.affectedPaths.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ChangeLogActivity.this,AffectPathActivity.class);
                    Bundle bundle =new  Bundle();
                    bundle.putSerializable("affectPath", (Serializable) changeSetBean.getAffectedPaths());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            viewHolder.author.setText(String.format("修改人：%s", changeSetBean.getAuthor().getFullName()));
            viewHolder.authorEmail.setText(String.format("修改人邮箱：%s", changeSetBean.getAuthorEmail()));
            viewHolder.commitMsg.setText(String.format("commitMsg：%s", changeSetBean.getMsg()));
            viewHolder.date.setText(String.format("修改人：%s", changeSetBean.getDate()));
            viewHolder.commitId.setText(String.format("commitId：%s", changeSetBean.getCommitId()));
        }

        @Override
        public int getItemCount() {
            return mBuildDetailBean.getItems().size();
        }

         class ViewHolder extends RecyclerView.ViewHolder {
            TextView author;
            TextView authorEmail;
            TextView commitMsg;
            TextView date;
            TextView commitId;
            Button affectedPaths;

             ViewHolder(@NonNull View view) {
                super(view);
                author = view.findViewById(R.id.author);
                authorEmail = view.findViewById(R.id.authorEmail);
                commitMsg = view.findViewById(R.id.commitMsg);
                date = view.findViewById(R.id.date);
                commitId = view.findViewById(R.id.commitId);
                affectedPaths = view.findViewById(R.id.affectedPaths);
            }
        }
    }
}
