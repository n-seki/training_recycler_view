package com.example.seki.trainingRecyclerView


import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ListAdapter(dataSet: MutableList<Data>, clickListener: ItemClickListener) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val mDataSet: MutableList<Data> = dataSet
    private val mClickListener: ItemClickListener = clickListener

    interface ItemClickListener {
        fun onClickItem(data: Data)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: com.example.seki.trainingRecyclerView.databinding.ListItemBinding = DataBindingUtil.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mDataSet[position]
        holder.binding.setVariable(BR.data, data)

        holder.binding.root.setOnClickListener {mClickListener.onClickItem(data)}
    }

    override fun getItemCount() = mDataSet.size
}