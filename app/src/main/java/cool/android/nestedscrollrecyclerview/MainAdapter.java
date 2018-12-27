package cool.android.nestedscrollrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainAdapterHolder> {

    private List<MainDataBean> mData;

    public MainAdapter(List<MainDataBean> data) {
        this.mData = data;
    }

    @Override
    public MainAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_adapter, parent, false);
        return new MainAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapterHolder holder, int position) {
        holder.mTextView.setText(mData.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<MainDataBean> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    class MainAdapterHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_main_adapter) TextView mTextView;

        public MainAdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
