package com.example.machineshop.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    //initailize two array list for (fragmentList, fragmentTitle)

    private final ArrayList<Fragment> fragmentList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    //Default Constructor @param FragmentManager
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {            //to get fragment page title
        return fragmentTitle.get(position);
    }
}
