package com.example.mensajerocall.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mensajerocall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class tabMensajes extends Fragment {

    final List<String> messages = new ArrayList<String>();
    private ArrayAdapter<String> messageAdapter;

    public tabMensajes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_tab_mensajes, container, false);
        ListView lvMessages = (ListView) view.findViewById(R.id.lvMessages);

        messages.add("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book");
        messages.add("Okey");
        //ArrayAdapter<String> chatAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,messages);
        //lvMessages.setAdapter(chatAdapter);
        messageAdapter = new messageAdapter(view.getContext(),R.layout.contactslayout,messages);
        lvMessages.setAdapter(messageAdapter);

        ImageButton ibCam = (ImageButton) view.findViewById(R.id.ibCamera);
        ibCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                v.getContext().startActivity(actCam);
            }
        });

        ImageButton ibSend = (ImageButton) view.findViewById(R.id.ibSend);
        ibSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etChat = (EditText) view.findViewById(R.id.etMessage);
                String parse = etChat.getText().toString();
                if (!parse.equals("")) {
                    messages.add(parse);
                    messageAdapter.notifyDataSetChanged();
                }
                }
            }
        );
        return view;
    }

    public class messageAdapter extends ArrayAdapter<String>{
        public messageAdapter(@NonNull Context context, int resource, List<String> chat) {
            super(context, resource, chat);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null){
                //convertView = getActivity().getLayoutInflater().inflate(R.layout.contactslayout,parent,false);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.contactslayout,parent,false);
            }
            String itemChat = getItem(position);
            TextView conName = (TextView) convertView.findViewById(R.id.tvContactName);
            conName.setText(itemChat);
            return  convertView;
        }

    }
}
