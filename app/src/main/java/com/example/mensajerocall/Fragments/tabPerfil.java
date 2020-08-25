package com.example.mensajerocall.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mensajerocall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class tabPerfil extends Fragment {

    public tabPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_perfil, container, false);

        ImageButton ibProfCall = (ImageButton) view.findViewById(R.id.ibProfileCall);
        ibProfCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profCall = new Intent();
                profCall.setAction(Intent.ACTION_DIAL);
                v.getContext().startActivity(profCall);
            }
        });

        //b

        ImageButton ibProfCam = (ImageButton) view.findViewById(R.id.ibVideoCall);
        ibProfCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                v.getContext().startActivity(profCam);
            }
        });

        return view;
    }
}
