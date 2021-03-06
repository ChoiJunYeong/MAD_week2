package com.example.q.a2ndweek;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Main2Activity.Member> data;
    private int layout;
    public ListviewAdapter(Context context, int layout, ArrayList<Main2Activity.Member> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }
    @Override
    public int getCount(){return data.size();}
    @Override
    public String getItem(int position){return data.get(position).getID();}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }

        Main2Activity.Member listviewitem=data.get(position);
        ImageView iv = (ImageView) convertView.findViewById(R.id.imageview);
        iv.setBackground(new ShapeDrawable(new OvalShape()));
        if (Build.VERSION.SDK_INT >= 21) {
            iv.setClipToOutline(true);
        }

        ((Main2Activity)Main2Activity.mContext).isThereImage(listviewitem.getID(), iv);


        TextView name=(TextView)convertView.findViewById(R.id.nameView);
        name.setText(listviewitem.getID());


        TextView status = (TextView)convertView.findViewById(R.id.messageView);
        if(!listviewitem.getStatus().equals("null")) {
            status.setText(listviewitem.getStatus());
        }
        else{
            status.setText("");
        }

        return convertView;
    }
}

