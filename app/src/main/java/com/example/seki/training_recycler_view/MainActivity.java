package com.example.seki.training_recycler_view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RecyclerListFragment.FragmentListener {

    TextView mTitle;
    TextView mDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = (TextView)findViewById(R.id.selected_title);
        mDescription = (TextView)findViewById(R.id.selected_description);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragment recyclerListFragment = RecyclerListFragment.getInstance();
            transaction.replace(R.id.container, recyclerListFragment);
            transaction.commit();
        }
    }

    @Override
    public void onClickItem(Data data) {
        mTitle.setText(data.title.get());
        mDescription.setText(data.description.get());

        int clickCount = Integer.parseInt(data.clickCount.get(), 10);
        data.clickCount.set(String.valueOf(++clickCount));
    }
}
