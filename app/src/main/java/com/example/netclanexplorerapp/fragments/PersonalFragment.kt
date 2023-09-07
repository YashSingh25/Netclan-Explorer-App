package com.example.netclanexplorerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netclanexplorerapp.R
import com.example.netclanexplorerapp.adapters.MyRvAdapter
import com.example.netclanexplorerapp.models.PersonModel

class PersonalFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var myRvAdapter: MyRvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_personal, container, false)

        recyclerView = view.findViewById(R.id.rvPersonsList)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val unicode: Int = 0x1F60A

        var personsList: ArrayList<PersonModel> = ArrayList<PersonModel>()
        personsList.add(PersonModel(R.drawable.character , "Shivendra Singh" , "Noida" , "Service" , "Within 300-400m" , "Coffee | Business | Friendship" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsList.add(PersonModel(R.drawable.character , "Shivam Kumar" , "Lucknow" , "Software Engineer" , "Within 400-500m" , "Coffee | Business | Friendship" , "Hi community! I am open to new connections \uD83D\uDE0A knweiucdbcvascjhcasuicbacbascakshbcasuicsabc  jkcwcwbcwicwcwinww"))
        personsList.add(PersonModel(R.drawable.character , "Mohd Aatif" , "Lucknow" , "Employ" , "Within 100-200m" , "Coffee | Business | Friendship" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsList.add(PersonModel(R.drawable.character , "Shivendra Singh" , "Noida" , "Service" , "Within 300-400m" , "Coffee | Business | Friendship" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsList.add(PersonModel(R.drawable.character , "Shivam Kumar" , "Lucknow" , "Software Engineer" , "Within 400-500m" , "Coffee | Business | Friendship" , "Hi community! I am open to new connections \"️☺️ \" "))
        personsList.add(PersonModel(R.drawable.character , "Mohd Aatif" , "Lucknow" , "Employ" , "Within 100-200m" , "Coffee | Business | Friendship" , "Hi community! I am open to new connections \"️☺️ \" "))

        val adapter = MyRvAdapter(personsList)

        recyclerView.adapter = adapter

        return view
    }

}