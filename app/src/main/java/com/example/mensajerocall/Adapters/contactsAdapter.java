package com.example.mensajerocall.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mensajerocall.R;

import java.util.List;

public class contactsAdapter extends ArrayAdapter<String> {
    private  Context context;
    private int layout;
    private List<String> contacts;

    /*
    public contactsAdapter(@NonNull Context context, int layout, List<String> contacts) {
        this.context = context;
        this.layout = layout;
        this.contacts = contacts;
    }
    */

    public contactsAdapter(@NonNull Context context, int resource, List<String> contacts) {
        super(context, resource,contacts);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String getItem(int position) {
        //return this.contacts.get(position);
        return super.getItem(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            //View conView = layoutInflater.inflate(this.layout, parent, false);
            convertView = layoutInflater.inflate(R.layout.contactslayout,parent,false);

            String contact = contacts.get(position);

            final TextView conName = (TextView) convertView.findViewById(R.id.tvContactName);
            conName.setText(getItem(position));
        }
        return convertView;
    }

        static class ViewHolder {
            public TextView nametextView;
        }
    }
