package com.edu.ldu.cn.mynews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.edu.ldu.cn.mynews.fragment.CareFragment;
import com.edu.ldu.cn.mynews.fragment.HomeFragment;
import com.edu.ldu.cn.mynews.fragment.MineFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment f1;
    private Fragment f2;
    private Fragment f3;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        RadioGroup rg = (RadioGroup)findViewById(R.id.tabs);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.home:
                        ft.show(f1).hide(f2).hide(f3).commit();
                        break;
                    case R.id.care:
                        ft.show(f2).hide(f1).hide(f3).commit();
                        break;
                    case R.id.mine:
                        ft.show(f3).hide(f1).hide(f2).commit();
                        break;
                }
            }
        });
    }

    private void initFragment() {
        f1 = new HomeFragment();
        f2 = new CareFragment();
        f3 = new MineFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,f1,"home")
                .add(R.id.container,f2,"care")
                .add(R.id.container,f3,"mine")
                .commit();
        getSupportFragmentManager().beginTransaction()
                .hide(f2)
                .hide(f3)
                .commit();
    }
}
