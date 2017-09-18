package com.example.seki.training_recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final List<Data> mDataSet;
    private final ItemClickListener mClickListener;

    interface ItemClickListener {
        void onClickItem(Data data);
    }

    public ListAdapter(List<Data> dataSet, ItemClickListener clickListener) {
        mDataSet = dataSet;
        mClickListener = clickListener;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView title;

        ViewHolder(View view) {
            super(view);
            this.title = (TextView)view.findViewById(R.id.title);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data data = mDataSet.get(position);
        holder.title.setText(data.title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onClickItem(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
