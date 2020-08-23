package com.example.mensajerocall.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mensajerocall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class tabLlamadas extends Fragment {

    final List<String> calls = new ArrayList<String>();

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

        ArrayAdapter callsAdapter = new callAdapter();
        callsListView.setAdapter(callsAdapter);

        return view;
    }

    public class callAdapter extends ArrayAdapter{
        public callAdapter(){
            super(getActivity(),R.layout.callslayout,calls);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.callslayout,parent,false);
            }
            String itemCall = calls.get(position);
            TextView callName = (TextView) convertView.findViewById(R.id.tvCallName);
            callName.setText(itemCall);

            return convertView;
        }
    }
}
