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
import com.example.netclanexplorerapp.models.BusinessModel

class BusinessFragment : Fragment() {

    lateinit var recyclerViewB: RecyclerView
    lateinit var myRvBAdapter: MyRvBAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_business, container, false)
        // Inflate the layout for this fragment

        recyclerViewB = view.findViewById(R.id.rvBPersonsList)
        recyclerViewB.layoutManager = LinearLayoutManager(context)

        var personsBList: ArrayList<BusinessModel> = ArrayList<BusinessModel>()

        personsBList.add(BusinessModel(R.drawable.character , "Karan Singh" , "Lucknow" , 2.1f , 8998877563 , false ,"Student" , 10 , "Hi community! I am open to new connections \"️☺️ \" "))
        personsBList.add(BusinessModel(R.drawable.character , "Yash Singh" , "Lucknow" , 3f , 451123112 , false, "SDE" , 1 , "Hi community! I am open to new connections \"️☺️ \" "))
        personsBList.add(BusinessModel(R.drawable.character , "Mayank Khare" , "Lucknow" , 4.1f , 122515541 , false, "Designer" , 2 , "Hi community! I am open to new connections \"️☺️ \" "))
        personsBList.add(BusinessModel(R.drawable.character , "Alisha Singh" , "Lucknow" , 1.5f , 9876321554 , false, "Project Manager" , 3 , "Hi community! I am open to new connections \"️☺️ \" "))
        personsBList.add(BusinessModel(R.drawable.character , "Megha Bali" , "Lucknow" , 7.1f , 346987454 , false, "Junior SDE" , 4 , "Hi community! I am open to new connections \"️☺️ \" "))
        personsBList.add(BusinessModel(R.drawable.character , "Karan Singh" , "Lucknow" , 2.3f , 3298977841 , false, "Student" , 5 , "Hi community! I am open to new connections \"️☺️ \" "))

        myRvBAdapter = MyRvBAdapter( context , personsBList)

        recyclerViewB.adapter = myRvBAdapter

        return view
    }

}