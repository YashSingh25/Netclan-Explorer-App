package com.example.netclanexplorerapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.netclanexplorerapp.fragments.BusinessFragment
import com.example.netclanexplorerapp.fragments.MerchantFragment
import com.example.netclanexplorerapp.fragments.PersonalFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return PersonalFragment()
            1 -> return BusinessFragment()
        }
        return MerchantFragment()
    }
}