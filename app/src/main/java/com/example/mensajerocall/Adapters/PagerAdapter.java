package com.example.mensajerocall.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mensajerocall.Fragments.tabContactos;
import com.example.mensajerocall.Fragments.tabLlamadas;
import com.example.mensajerocall.Fragments.tabMensajes;
import com.example.mensajerocall.Fragments.tabPerfil;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm, numberOfTabs);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tabContactos();
            case 1:
                return new tabLlamadas();
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
