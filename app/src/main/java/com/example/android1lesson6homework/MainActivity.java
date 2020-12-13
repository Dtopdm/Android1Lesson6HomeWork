package com.example.android1lesson6homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IFragments{

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment fragment;
    private FragmentTwo fragmentTwo;
    private IFragments iFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragment = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.fragmentTwo);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.add(R.id.fragmentOne, );
        transaction.addToBackStack(null);
        transaction.commit();
        dynamicFragment();

    }

    private void dynamicFragment(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentDynamic, new FragmentThreeDynamic());
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }


    @Override
    public void hideFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void unhideFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void sendFragment(String text) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentTwo, FragmentTwo.newInstance(text, ""));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
