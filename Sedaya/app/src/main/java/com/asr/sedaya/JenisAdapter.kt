package com.asr.sedaya

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JenisAdapter(val jenis: ArrayList<JenisModel.Data>
):RecyclerView.Adapter<JenisAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_jenis,parent,false)
    )

    override fun onBindViewHolder(holder: JenisAdapter.ViewHolder, position: Int) {
        val data = jenis[position]
        holder.textJenis.text=data.jenis
    }

    override fun getItemCount()=jenis.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textJenis = view.findViewById<TextView>(R.id.txt_data)
        val imageDelete = view.findViewById<ImageView>(R.id.img_delete)
    }
    public fun setData(data: List<JenisModel.Data>){
        jenis.clear()
        jenis.addAll(data)
        notifyDataSetChanged()
    }
}