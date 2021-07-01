package com.example.machineshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.example.machineshop.Adapters.ViewPagerAdapter;
import com.example.machineshop.Fragments.AllInvoices;
import com.example.machineshop.Fragments.DuePayment;
import com.example.machineshop.Fragments.PaidInvoices;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout drawer;
    private FloatingActionButton fabInvoice;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_dashboard);
        setSupportActionBar(toolbar);

        //Drawer layout
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.Navigation_drawer_open,
                R.string.Navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Initialize TabLayout and ViewPager and its Resource Id
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        fabInvoice = (FloatingActionButton) findViewById(R.id.fab_invoice);
        fabInvoice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GenerateInvoice.class);
                startActivity(intent);
            }
        });
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    //method for View Pager
    private void setUpViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AllInvoices(), "All");
        viewPagerAdapter.addFragment(new DuePayment(), "Outstanding");
        viewPagerAdapter.addFragment(new PaidInvoices(), "Paid");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
