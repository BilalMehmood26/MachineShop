package com.example.machineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.machineshop.Adapters.ViewPagerAdapter;
import com.example.machineshop.Fragments.SignIn;
import com.example.machineshop.Fragments.SignUp;
import com.google.android.material.tabs.TabLayout;

public class  MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize TabLayout and ViewPager and its Resource Id
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    //method for View Pager
    private void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new SignIn(), "SignIn");
        viewPagerAdapter.addFragment(new SignUp(), "SignUp");
        viewPager.setAdapter(viewPagerAdapter);
    }

}
