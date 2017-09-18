package com.example.seki.training_recycler_view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecyclerListFragment extends Fragment implements ListAdapter.ItemClickListener {

    List<Data> mDataSet;
    FragmentListener mListener;

    public static Fragment getInstance() {
        return new RecyclerListFragment();
    }

    interface FragmentListener {
        void onClickItem(Data data);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDateSet();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() instanceof FragmentListener) {
            mListener = (FragmentListener)getActivity();
        } else {
            throw new IllegalStateException("Activity is not implements FragmentListener.");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_list, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);

        ListAdapter adapter = new ListAdapter(mDataSet, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        return rootView;
    }


    void createDateSet() {
        mDataSet = new ArrayList<>();
        mDataSet.add(new Data("1", "first"));
        mDataSet.add(new Data("2", "second"));
        mDataSet.add(new Data("3", "third"));
        mDataSet.add(new Data("4", "fourth"));
        mDataSet.add(new Data("5", "fifth"));
        mDataSet.add(new Data("6", "sixth"));
        mDataSet.add(new Data("7", "seventh"));
        mDataSet.add(new Data("8", "eighth"));
        mDataSet.add(new Data("9", "ninth"));
        mDataSet.add(new Data("10", "tenth"));
    }


    @Override
    public void onClickItem(Data data) {
        mListener.onClickItem(data);
    }
}
