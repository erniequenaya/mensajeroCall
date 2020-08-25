package com.example.mensajerocall.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mensajerocall.Fragments.tabContactos;
import com.example.mensajerocall.Fragments.tabLlamadas;
import com.example.mensajerocall.Fragments.tabMensajes;
import com.example.mensajerocall.Fragments.tabPerfil;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;
    public FragmentTransaction tss;

    public PagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm, numberOfTabs);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        FragmentTransaction f = null;
        tss = new FragmentTransaction() {
            @Override
            public int commit() {
                return 0;
            }

            @Override
            public int commitAllowingStateLoss() {
                return 0;
            }

            @Override
            public void commitNow() {

            }

            @Override
            public void commitNowAllowingStateLoss() {

            }
        };
        switch (position){
            case 0:
                Fragment tab1 = new tabContactos();
                tss.add(tab1,"tabCon");
                return tab1;
            case 1:
                Fragment tab2 = new tabLlamadas();
                tss.add(tab2,"tabLla");
                return tab2;
            case 2:
                return new tabMensajes();
            case 3:
                return new tabPerfil();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
