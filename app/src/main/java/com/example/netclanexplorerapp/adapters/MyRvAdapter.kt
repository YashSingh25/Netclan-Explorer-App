package com.example.netclanexplorerapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanexplorerapp.R
import com.example.netclanexplorerapp.models.PersonModel

class MyRvAdapter(val personsList: ArrayList<PersonModel>):RecyclerView.Adapter<MyRvAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var pImg: ImageView
        lateinit var pName: TextView
        lateinit var pCity: TextView
        lateinit var pProfession: TextView
        lateinit var pRange: TextView
        lateinit var pPurpose: TextView
        lateinit var pStatus: TextView

        init {
            pImg = itemView.findViewById(R.id.ivMPersonImage)
            pName = itemView.findViewById(R.id.tvPersonName)
            pCity = itemView.findViewById(R.id.tvCity)
            pProfession = itemView.findViewById(R.id.tvProfession)
            pRange = itemView.findViewById(R.id.tvRangeofDistance)
            pPurpose = itemView.findViewById(R.id.tvPurpose)
            pStatus = itemView.findViewById(R.id.tvStatus)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.personal_frag_list_item , parent , false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var person: PersonModel = personsList.get(position)

        holder.pImg.setImageResource(person.pImg)
        holder.pName.text = person.pName
        holder.pCity.text = person.pCity
        holder.pProfession.text = person.pProfession
        holder.pRange.text = person.pRange
        holder.pPurpose.text = person.pPurpose
        holder.pStatus.text = person.pStatus


    }

    override fun getItemCount(): Int {
        return personsList.size
    }
}