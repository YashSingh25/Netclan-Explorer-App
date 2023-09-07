package com.example.netclanexplorerapp.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanexplorerapp.R
import com.example.netclanexplorerapp.models.BusinessModel

class MyRvBAdapter(val context: Context?, val personsBList: ArrayList<BusinessModel>):RecyclerView.Adapter<MyRvBAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var bImg: ImageView
        lateinit var bName: TextView
        lateinit var bCity: TextView
        lateinit var bRange: TextView
        lateinit var bCallImg: ImageView
        lateinit var bContactImg: ImageView
        lateinit var bProfessionAndExp: TextView
        lateinit var bStatus: TextView

        init {
            bImg = itemView.findViewById(R.id.ivBPersonImage)
            bName = itemView.findViewById(R.id.tvBusername)
            bCity = itemView.findViewById(R.id.tvBCity)
            bRange = itemView.findViewById(R.id.tvBRangeofDistance)
            bCallImg = itemView.findViewById(R.id.ivBcall)
            bContactImg = itemView.findViewById(R.id.ivBaddcontact)
            bProfessionAndExp = itemView.findViewById(R.id.tvBProfessionAndExp)
            bStatus = itemView.findViewById(R.id.tvBStatus)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.business_frag_list_item , parent , false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var bPerson: BusinessModel = personsBList.get(position)

        holder.bImg.setImageResource(bPerson.bImage)
        holder.bName.text = bPerson.bName
        holder.bCity.text = bPerson.bCity+","
        holder.bRange.text = "within ${bPerson.bRange} KM"

        var profAndExp: String =  "${bPerson.bProfession} | ${bPerson.bExpYears} of Experience"
        holder.bProfessionAndExp.text = profAndExp
        holder.bStatus.text = bPerson.bStatus

        holder.bCallImg.setOnClickListener {
            makePhoneCall(bPerson.bContactNo)
        }

        holder.bContactImg.setOnClickListener {
            if(bPerson.isContactClicked == false){
                holder.bContactImg.setImageResource(R.drawable.contact_clicked)
                Toast.makeText(context , "Added To Contacts" , Toast.LENGTH_LONG).show()
                bPerson.isContactClicked = true
            }
        }

    }

    override fun getItemCount(): Int {
        return personsBList.size
    }

    private fun makePhoneCall(phoneNumber: Long) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        context?.startActivity(intent)
    }
}