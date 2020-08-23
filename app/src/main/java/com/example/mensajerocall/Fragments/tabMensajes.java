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
public class tabMensajes extends Fragment {

    final List<String> messages = new ArrayList<String>();

    public tabMensajes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_mensajes, container, false);
        ListView lvMessages = (ListView) view.findViewById(R.id.lvMessages);

        messages.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book");
        messages.add("Okey");
        //ArrayAdapter<String> chatAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,messages);
        //lvMessages.setAdapter(chatAdapter);
        ArrayAdapter<String> messageAdapter = new messageAdapter();
        lvMessages.setAdapter(messageAdapter);

        return view;
    }

    public class messageAdapter extends ArrayAdapter{
        public messageAdapter(){
            super(getActivity(),R.layout.contactslayout,messages);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.contactslayout,parent,false);
            }
            String itemContact = messages.get(position);
            TextView conName = (TextView) convertView.findViewById(R.id.tvContactName);
            conName.setText(itemContact);
            return  convertView;
        }
    }
}
