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
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class BuildListActivity extends BaseActivity {

    private SwipeRefreshLayout swipeView;
    private RecyclerView recyclerView;
    private BuildDetailBean.ChangeSetBean mBuildDetailBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_log);
        getIntentData();
        swipeView = (SwipeRefreshLayout) findViewById(R.id.swipeView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
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
            View view = View.inflate(BuildListActivity.this, R.layout.cell_change_log, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ChangeLogAdapter.ViewHolder viewHolder, int i) {
            final BuildDetailBean.ChangeSetBean.ItemsBean changeSetBean = mBuildDetailBean.getItems().get(i);
            viewHolder.affectedPaths.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(BuildListActivity.this,AffectPathActivity.class);
                    Bundle bundle =new  Bundle();
                    bundle.putSerializable("affectPath", (Serializable) changeSetBean.getAffectedPaths());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            viewHolder.author.setText("修改人：" + changeSetBean.getAuthor().getFullName());
            viewHolder.authorEmail.setText("修改人邮箱：" + changeSetBean.getAuthorEmail());
            viewHolder.commitMsg.setText("commitMsg：" + changeSetBean.getMsg());
            viewHolder.date.setText("修改人：" + changeSetBean.getDate());
            viewHolder.commitId.setText("commitId：" + changeSetBean.getCommitId());
        }

        @Override
        public int getItemCount() {
            return mBuildDetailBean.getItems().size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView author;
            TextView authorEmail;
            TextView commitMsg;
            TextView date;
            TextView commitId;
            Button affectedPaths;

            public ViewHolder(@NonNull View view) {
                super(view);
                author = (TextView) view.findViewById(R.id.author);
                authorEmail = (TextView) view.findViewById(R.id.authorEmail);
                commitMsg = (TextView) view.findViewById(R.id.commitMsg);
                date = (TextView) view.findViewById(R.id.date);
                commitId = (TextView) view.findViewById(R.id.commitId);
                affectedPaths = view.findViewById(R.id.affectedPaths);
            }
        }
    }
}
