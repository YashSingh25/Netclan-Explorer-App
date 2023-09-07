package com.example.netclanexplorerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanexplorerapp.R
import com.example.netclanexplorerapp.adapters.MyRvBAdapter
import com.example.netclanexplorerapp.adapters.MyRvMAdapter
import com.example.netclanexplorerapp.models.MerchantModel

class MerchantFragment : Fragment() {

    lateinit var recyclerViewM: RecyclerView
    lateinit var myRvMAdapter: MyRvMAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_merchant, container, false)
        
        //
        recyclerViewM = view.findViewById(R.id.rvMPersonsList)
        recyclerViewM.layoutManager = LinearLayoutManager(context)

        var personsMList: ArrayList<MerchantModel> = ArrayList<MerchantModel>()

        personsMList.add(MerchantModel(R.drawable.character , "Karan Singh" , "Lucknow" , "100" , 8998877563 , false ,"Student" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsMList.add(MerchantModel(R.drawable.character , "Yash Singh" , "Lucknow" , "200-300" , 451123112  , false, "SDE" ,  "Hi community! I am open to new connections \"️☺️ \" "))
        personsMList.add(MerchantModel(R.drawable.character , "Mayank Khare" , "Lucknow" , "500" , 122515541  , false, "Designer" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsMList.add(MerchantModel(R.drawable.character , "Alisha Singh" , "Lucknow" , "600-700" , 9876321554  , false, "Project Manager" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsMList.add(MerchantModel(R.drawable.character , "Megha Bali" , "Lucknow" , "150" , 346987454  , false, "Junior SDE" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsMList.add(MerchantModel(R.drawable.character , "Karan Singh" , "Lucknow" , "800" , 3298977841  , false, "Student" , "Hi community! I am open to new connections \"️☺️ \" "))

        myRvMAdapter = MyRvMAdapter(context , personsMList)

        recyclerViewM.adapter = myRvMAdapter

        return view
    }

}