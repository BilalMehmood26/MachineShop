package com.example.machineshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.machineshop.Adapters.ViewPagerAdapter;
import com.example.machineshop.Fragments.Invoice;
import com.example.machineshop.Fragments.Preview;
import com.google.android.material.tabs.TabLayout;

public class GenerateInvoice extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_invoice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.invoice_generator_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialize TabLayout and ViewPager and its Resource Id
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //method for View Pager
    private void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Invoice(), "Invoice");
        viewPagerAdapter.addFragment(new Preview(), "Preview");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
