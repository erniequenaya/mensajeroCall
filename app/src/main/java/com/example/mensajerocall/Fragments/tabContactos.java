package com.example.mensajerocall.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mensajerocall.Adapters.PagerAdapter;
import com.example.mensajerocall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class tabContactos extends Fragment {

    public tabContactos() {
        // Required empty public constructor
    }

    final List<String> contacts = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_contactos, container, false);
        ListView contactsListView = (ListView) view.findViewById(R.id.lvContacts);
        contactsListView.setVerticalScrollBarEnabled(true);
        //contactsListView.setFastScrollAlwaysVisible(true);

        contacts.add("Adam Díaz");
        contacts.add("Jaime Varas");
        contacts.add("Marcela Gomez");
        contacts.add("Marcos Roberts");
        contacts.add("Claudia Vega");
        contacts.add("Diana Fork");
        contacts.add("Javiera Paz");
        contacts.add("Leonardo Kayser");

        //use contactsAdapter
        //ListView contactsListView = (ListView) view.findViewById(R.id.lvContacts);
        //ListAdapter contactsAdapter = new contactsAdapter(view.getContext(),R.layout.contactslayout,contacts);

        //use Adaptor
        ArrayAdapter<String> contactsAdapter = new adaptor();
        contactsListView.setAdapter(contactsAdapter);

        return view;
    }

    public class adaptor extends ArrayAdapter<String> {
        public adaptor(){
            super(getActivity(),R.layout.contactslayout,contacts);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.contactslayout,parent,false);
            }
            String itemContact = contacts.get(position);
            TextView conName = (TextView) convertView.findViewById(R.id.tvContactName);
            conName.setText(itemContact);

            ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivContactPhoto);
            ivPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Fragment fCall = getFragmentManager().findFragmentById("android:switcher:" + R.id.mainPager + ":" + PagerAdapter.);
                    //Fragment fCall = getFragmentManager().findFragmentByTag("tabLla");
                    //FragmentTransaction ts = getFragmentManager().beginTransaction();
                    //ts.replace(R.id.mainPager,fCall);
                    //ts.addToBackStack(null);
                    //ts.commit();
                }
            });

            return  convertView;
        }
    }
}
