package cool.android.nestedscrollrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_main_activity) RecyclerView mRecyclerView;
    @BindView(R.id.trl_main_activity) TwinklingRefreshLayout mTwinklingRefreshLayout;
    private List<MainDataBean> mData = new ArrayList<>();
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRefreshLayout();
        refreshData();
    }

    private void refreshData() {
        int count = mData.size();
        for (int i = count; i < 40 + count; i++) {
            mData.add(new MainDataBean("This is Item:" + i));
        }
        initRecyclerView(mData);
    }

    private void initRecyclerView(List<MainDataBean> dataBeans) {
        if (mMainAdapter == null) {
            LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            // 默认为true
            manager.setSmoothScrollbarEnabled(true);
            // 允许自动测量
            manager.setAutoMeasureEnabled(true);
            mRecyclerView.setLayoutManager(manager);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setNestedScrollingEnabled(false);
            mMainAdapter = new MainAdapter(mData);
            mRecyclerView.setAdapter(mMainAdapter);
        } else {
            mMainAdapter.setData(mData);
        }
    }

    public void initRefreshLayout() {
        mTwinklingRefreshLayout.setEnableOverScroll(false);
        mTwinklingRefreshLayout.setEnableRefresh(false);
        mTwinklingRefreshLayout.setEnableLoadmore(true);
        mTwinklingRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (mRecyclerView == null) { return; }
                refreshData();
                refreshLayout.finishLoadmore();
            }
        });
    }
}
