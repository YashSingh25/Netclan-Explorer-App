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
import com.example.netclanexplorerapp.models.MerchantModel
import com.example.netclanexplorerapp.models.PersonModel

class MyRvMAdapter(val context: Context? , val personsMList: ArrayList<MerchantModel>):RecyclerView.Adapter<MyRvMAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var mImg: ImageView
        lateinit var mName: TextView
        lateinit var mCity: TextView
        lateinit var mRange: TextView
        lateinit var mCallImg: ImageView
        lateinit var mContactImg: ImageView
        lateinit var mLocation: ImageView
        lateinit var mStatus: TextView

        init {
            mImg = itemView.findViewById(R.id.ivMPersonImage)
            mName = itemView.findViewById(R.id.tvMusername)
            mCity = itemView.findViewById(R.id.tvMCity)
            mRange = itemView.findViewById(R.id.tvMRangeofDistance)
            mCallImg = itemView.findViewById(R.id.ivMcall)
            mContactImg = itemView.findViewById(R.id.ivMaddcontact)
            mLocation = itemView.findViewById(R.id.ivMLoaction)
            mStatus = itemView.findViewById(R.id.tvMStatus)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.merchant_frag_list_item , parent , false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var personM: MerchantModel = personsMList.get(position)

        holder.mImg.setImageResource(personM.mImage)
        holder.mName.text = personM.mName
        holder.mCity.text = personM.mCity+ ","
        holder.mRange.text = "within ${personM.mRange} m"
        holder.mStatus.text = personM.mStatus

        holder.mCallImg.setOnClickListener {
            makePhoneCall(personM.mContactNo)
        }

        holder.mContactImg.setOnClickListener {
            if(personM.isContactClickedM == false){
                holder.mContactImg.setImageResource(R.drawable.contact_clicked)
                Toast.makeText(context , "Added To Contacts" , Toast.LENGTH_LONG).show()
                personM.isContactClickedM = true
            }
        }

    }

    override fun getItemCount(): Int {
        return personsMList.size
    }

    private fun makePhoneCall(phoneNumber: Long) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        context?.startActivity(intent)
    }
}