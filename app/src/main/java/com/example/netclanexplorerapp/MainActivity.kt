package com.example.netclanexplorerapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.netclanexplorerapp.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    lateinit var viewPager2: ViewPager2
    lateinit var tabLayout: TabLayout
    lateinit var reqLocLayout:View
    lateinit var allowGPSBtn: Button
    val tabsArray:Array<String> = arrayOf("Personal" , "Business" , "Merchant")
    private val LOCATION_PERMISSION_REQUEST_CODE = 1001
    var isGPSEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        val refineBtn: LinearLayout = findViewById(R.id.refineLayout)
        reqLocLayout = findViewById(R.id.reqPermissionLayout)
        allowGPSBtn = findViewById(R.id.reqPerBtn)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val isEnabled = sharedPreferences.getBoolean("isLocationGranted", false) // Default value is false
        var isLocationGranted: Boolean = sharedPreferences.getBoolean("isLocationGranted" , false)

        refineBtn.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity , RefineActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        //
        if(isLocationGranted){

            isGPSEnabled = isLocationEnabled(applicationContext)

            if(isGPSEnabled){
                loadData()
            }else{
                displayLocReqLayout()
                allowGPSBtn.setOnClickListener {
                    onAllowGPSButtonClick()
                }
            }

        }else{
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
            ) {
                // Location permission has not been granted. Request it.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_PERMISSION_REQUEST_CODE
                )
            }
        }

    }

    // Handle the result of the permission request.
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Location permission has been granted. You can now access the location.
                sharedPreferences.edit().putBoolean("isLocationGranted" , true).apply()

                isGPSEnabled = isLocationEnabled(applicationContext)

                if(isGPSEnabled){
                    loadData()
                }else{
                    displayLocReqLayout()
                    allowGPSBtn.setOnClickListener {
                        onAllowGPSButtonClick()
                    }
                }
            } else {
                // Location permission was denied. Handle the situation, e.g., show a message to the user.
                Toast.makeText(applicationContext , "Please Grant Location Permission" , Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Check if location services (GPS) are enabled
    fun isLocationEnabled(context: Context): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun loadData(){
        reqLocLayout.visibility = View.GONE
        tabLayout.visibility = View.VISIBLE
        viewPager2.visibility = View.VISIBLE

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager , lifecycle)

        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout , viewPager2){
                tab , positon -> tab.text = tabsArray[positon]
        }.attach()
    }

    fun onAllowGPSButtonClick(){
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivityForResult(intent, LOCATION_PERMISSION_REQUEST_CODE)
        loadData()
    }

    fun displayLocReqLayout(){
        tabLayout.visibility = View.INVISIBLE
        viewPager2.visibility = View.INVISIBLE
        reqLocLayout.visibility = View.VISIBLE
    }

}