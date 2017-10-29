package com.example.seki.trainingRecyclerView

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecyclerListFragment : Fragment(), ListAdapter.ItemClickListener {

    private val mDataSet: MutableList<Data> = mutableListOf()
    private var mListener: FragmentListener? = null

    companion object {
        fun getInstance() = RecyclerListFragment()
    }

    interface FragmentListener {
        fun onClickItem(data: Data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDataSet()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (activity is FragmentListener) {
            mListener = activity as FragmentListener
        } else {
            throw IllegalStateException("Activity is not implements FragmentListener.");
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:  Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        val recyclerList = rootView.findViewById<RecyclerView>(R.id.list)

        val layoutManager = LinearLayoutManager(activity)

        recyclerList.layoutManager = layoutManager

        val adapter = ListAdapter(mDataSet, this)

        recyclerList.adapter = adapter
        recyclerList.setHasFixedSize(true)

        val dividerItemDecoration = DividerItemDecoration(recyclerList.context, layoutManager.orientation)
        recyclerList.addItemDecoration(dividerItemDecoration)

        return rootView
    }


    private fun createDataSet() {
        mDataSet.add(Data("1", "first"))
        mDataSet.add(Data("2", "second"))
        mDataSet.add(Data("3", "third"))
        mDataSet.add(Data("4", "fourth"))
        mDataSet.add(Data("5", "fifth"))
        mDataSet.add(Data("6", "sixth"))
        mDataSet.add(Data("7", "seventh"))
        mDataSet.add(Data("8", "eighth"))
        mDataSet.add(Data("9", "ninth"))
        mDataSet.add(Data("10", "tenth"))
    }

    override fun onClickItem(data: Data) {
        mListener!!.onClickItem(data)
    }
}
