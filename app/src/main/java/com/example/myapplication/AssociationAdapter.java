package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AssociationAdapter extends BaseAdapter {

    private final List<Association> associations;
    private final Context mContext;

    public AssociationAdapter (List<Association> associations, Context mContext){
        this.associations = associations;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return associations.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Association association = associations.get(position);

        if (convertView == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater
                    .inflate(R.layout.layout_grid_item_association
                            ,null);
        }

        final ImageView image = (ImageView)convertView
                .findViewById(R.id.association_image);

        final TextView nom = (TextView) convertView
                .findViewById(R.id.association_nom);

        Picasso.with(mContext)
                .load("https://mysterious-ravine-26282.herokuapp.com/"+ association.getUrlImages()[0]).into(image);


        nom.setText(association.getNom());

        return convertView;
    }
}
