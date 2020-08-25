package com.example.mensajerocall.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mensajerocall.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class tabLlamadas extends Fragment {

    private final List<String> calls = new ArrayList<String>();

    public tabLlamadas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_llamadas, container, false);
        ListView callsListView = (ListView) view.findViewById(R.id.lvCalls);

        calls.add("+56 9 7357 6463");
        calls.add("Marcos Roberts");
        calls.add("Diana");
        calls.add("Leonardo");
        calls.add("+56 9 3445 9030");
        calls.add("+56 9 5951 7953");

        //ArrayAdapter callsAdapter = new callAdapter();
        ArrayAdapter callsAdapter = new callAdapter2(view.getContext(),R.layout.callslayout,calls);
        callsListView.setAdapter(callsAdapter);

        return view;
    }

    public static class callAdapter2 extends ArrayAdapter<String> {

        public callAdapter2(@NonNull Context context, int resource, List<String> calls) {
            super(context, resource, calls);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                //convertView = getActivity().getLayoutInflater().inflate(R.layout.callslayout,parent,false);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.callslayout,parent,false);
            }
            String itemCall = getItem(position);
            TextView callName = (TextView) convertView.findViewById(R.id.tvCallName);
            callName.setText(itemCall);

            ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivCallPhoto);
            ivPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toProfile = new Intent(v.getContext(),tabPerfil.class);
                    v.getContext().startActivity(toProfile);
                }
            });

            ImageButton ibCall = (ImageButton) convertView.findViewById(R.id.ibCallCall);
            ibCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent actCall = new Intent();
                    actCall.setAction(Intent.ACTION_DIAL);
                    v.getContext().startActivity(actCall);
                    Toast.makeText(v.getContext(),"testToast",Toast.LENGTH_LONG).show();
                }
            });
            return convertView;
        }

    }

}
