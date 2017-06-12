package com.example.kripashankarjha.yout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


/**
 * Created by kripa shankar jha on 30-04-2017.
 */

public class customAdapter extends BaseAdapter{

    public String urlRead[], detail[];
    public Context con;
    public LayoutInflater inflater = null;

    TextView DetailVideo;


    public customAdapter(Context c, String arr[], String Detail[]) {
        con = c;
        urlRead = arr;
        detail = Detail;
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return urlRead.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.customlay, null);
        DetailVideo = (TextView) v.findViewById(R.id.de1);
        DetailVideo.setText(detail[position]);


        return v;
    }


}
