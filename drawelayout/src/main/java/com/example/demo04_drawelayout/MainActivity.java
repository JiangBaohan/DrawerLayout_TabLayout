package com.example.demo04_drawelayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.完成布局
 * 2.初始化控件
 * 3.初始化ActionBar
 * 4.初始化viewpager
 * 5.使两两之间关联
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ActionBarDrawerToggle mToggle;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化控件对象
        initActionBar();//初始化ActionBar
        initViewPager();//初始化ViewPager
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initActionBar() {
        //获取一个ActionBar
        ActionBar actionBar = getSupportActionBar();
        //给左上角的左边加一个返回的图标
        actionBar.setDisplayHomeAsUpEnabled(true);
        //这个类提供了一种方便的方式来绑定的功能
        //参数上下文 2.drawerLayout 3.4R.string.资源(照顾盲人,点击时有声音)
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        //将抽屉指示器的状态与连接的drawerlayout同步其状态
        mToggle.syncState();
        drawerLayout.addDrawerListener(mToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {
        //创建一个集合,用来装fragment
        List<Fragment> fragments = new ArrayList<>();
        //把VR全景图和视频的fragment对象装入集合显示
        fragments.add(new VRPanoFrament());
        fragments.add(new VrVideoFrament());
        //创建viewpager适配器对象
        MyPagerAdpater adpater = new MyPagerAdpater(getSupportFragmentManager());
        //把集合传给适配器
        adpater.setFragment(fragments);
        //viewpager设置适配器
        viewPager.setAdapter(adpater);
//-----------------tabLayout知识---要再build.gradle依赖-android.support.design.widget.TabLayout------------------------
        //tablayout指示器有几个就创建几个
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        //使用tablayout与viewpager相关联
        tabLayout.setupWithViewPager(viewPager);
        //给tablayout指示器是这文本,万物从0开始,0就是给第一个指示器设置的文本
        tabLayout.getTabAt(0).setText("第一栏");
        tabLayout.getTabAt(1).setText("第2222栏");
    }


}
