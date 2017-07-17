package com.smitha.lms;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;

import com.smitha.lms.data.User;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;
import static android.R.attr.subMenuArrow;

/**
 * Created by Smitha on 07-07-2017.
 */

public class CustomAdapter extends ArrayAdapter implements View.OnClickListener {
   // Context mcontext;
    private Activity activity;
    private ArrayList<User> userdataset;
    LayoutInflater inflater;
    private static class ViewHolder{
        TextView nametv,agetv,sextv,salarytv,ratingtv;

    }
    private static class colHolder{
        TextView colName,colAge,colSex,colSalary,colRating;
    }

    public CustomAdapter(Activity activity,int textViewResourceId, List objects) {
        super(activity,textViewResourceId,objects);
/*
super(context, resource,textViewResourceId, objects);
mcontext=context;*/
        this.activity=activity;
        userdataset= (ArrayList<User>) objects;

    }
    public int getCount(){
        if(userdataset.size()<=0)
            return 1;
        return userdataset.size();
    }
    @Override
    public void onClick(View view) {
        int mposition=(Integer)view.getTag();
       User userdata= (User)getItem(mposition);
        Log.e("position",String.valueOf(mposition));
        Log.e("userdata",userdata.toString());

    }
    private int lastPosition=-1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       User userdata;
//
        ViewHolder holder;
        colHolder colHolder;
        final View result;
//        if(userdata==null)
//            return convertView=null;

        if(convertView==null){
            inflater=LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.user_list_item,parent,false);
            holder=new ViewHolder();
            holder.nametv=(TextView)convertView.findViewById(R.id.name_col_textView);
            holder.agetv=(TextView)convertView.findViewById(R.id.age_col_textView);
            holder.sextv=(TextView)convertView.findViewById(R.id.sex_col_textView);
            holder.salarytv=(TextView)convertView.findViewById(R.id.salary_col_textView);
            holder.ratingtv=(TextView)convertView.findViewById(R.id.rating_col_textView);

            result=convertView;
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
            result=convertView;

        }
        if(userdataset.size()<=0){
            holder.nametv.setText("");
            holder.agetv.setText("");
            holder.sextv.setText("");
            holder.salarytv.setText("");
            holder.ratingtv.setText("");
            convertView.setTag(holder);

        }else {
    //        lastPosition = position;
            userdata=(User)getItem(position);
            holder.nametv.setText(userdata.getName());
            holder.agetv.setText(String.valueOf(userdata.getAge()));
            holder.sextv.setText(userdata.getSex());
            holder.salarytv.setText(String.valueOf(userdata.getSalary()));
            holder.ratingtv.setText(String.valueOf(userdata.getRating()));
        }
        return result;
                //super.getView(position, convertView, parent);
    }
}
