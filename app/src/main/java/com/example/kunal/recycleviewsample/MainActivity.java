package com.example.kunal.recycleviewsample;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TabLayout tabLayout=findViewById(R.id.tabs);
        ViewPager viewPager= findViewById(R.id.viewpager);

        Adapter adapter=new Adapter(getSupportFragmentManager());
        adapter.addFragment(new BlankFragment(),"Blank");
        adapter.addFragment(new ListFragment(),"RecyclerView");

        setSupportActionBar(toolbar);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }


    static class Adapter extends FragmentPagerAdapter{

        private List<String> titleList = new ArrayList<String>();
        private List<Fragment> fragmentList= new ArrayList<Fragment>() ;

        public Adapter(FragmentManager fm) {
            super(fm);
        }

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
            titleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
