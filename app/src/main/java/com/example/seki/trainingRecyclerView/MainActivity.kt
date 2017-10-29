package com.example.seki.trainingRecyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerListFragment.FragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            val recyclerListFragment = RecyclerListFragment.getInstance()
            transaction.replace(R.id.container, recyclerListFragment)
            transaction.commit()
        }
    }

    override fun onClickItem(data: Data) {
        label_title.text = data.title.get()
        label_description.text = data.description.get()

        var clickCount: Int = Integer . parseInt (data.clickCount.get(), 10)
        data.clickCount.set((++clickCount).toString())
    }
}
