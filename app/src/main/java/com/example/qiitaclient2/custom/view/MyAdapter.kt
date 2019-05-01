package com.example.qiitaclient2.custom.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qiitaclient2.R

class MyAdapter(myDataset: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val mDataset: List<String> = myDataset

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val mTextView: TextView = v.findViewById(R.id.list_item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val vh = ViewHolder(view)
        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = mDataset[position]
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

}