package com.smitha.lms;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;

import com.smitha.lms.data.User;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter implements View.OnClickListener {
    private Activity activity;
    private ArrayList<User> userDataSet;
    private User userdata;
    private static class ViewHolder{
        TextView nameTv, ageTv, genderTv, salaryTv, ratingTv;

    }
//    private static class colHolder{
//        TextView colName,colAge,colSex,colSalary,colRating;
//    }

    public CustomAdapter(Activity activity,int textViewResourceId, List objects) {
        super(activity,textViewResourceId,objects);

        this.activity=activity;
        userDataSet = (ArrayList<User>) objects;

    }
    public int getCount(){
        if(userDataSet.size()<=0)
            return 1;
        return userDataSet.size();
    }
    @Override
    public void onClick(View view) {
        int mposition=(Integer)view.getTag();
       userdata= (User)getItem(mposition);
        Log.e("position",String.valueOf(mposition));
        Log.e("userdata",userdata.toString());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater;
        ViewHolder holder;
        //colHolder colHolder;
        final View result;
        if(convertView==null){
            inflater=LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.user_list_item,parent,false);
            holder=new ViewHolder();
            holder.nameTv =(TextView)convertView.findViewById(R.id.name_col_textView);
            holder.ageTv =(TextView)convertView.findViewById(R.id.age_col_textView);
            holder.genderTv =(TextView)convertView.findViewById(R.id.gender_col_textView);
            holder.salaryTv =(TextView)convertView.findViewById(R.id.salary_col_textView);
            holder.ratingTv =(TextView)convertView.findViewById(R.id.rating_col_textView);

            result=convertView;
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
            result=convertView;
        }
        if(userDataSet.size()<=0){
            holder.nameTv.setText("");
            holder.ageTv.setText("");
            holder.genderTv.setText("");
            holder.salaryTv.setText("");
            holder.ratingTv.setText("");
            convertView.setTag(holder);

        }else {
            userdata=(User)getItem(position);
            holder.nameTv.setText(userdata.getName());
            holder.ageTv.setText(String.valueOf(userdata.getAge()));
            holder.genderTv.setText(userdata.getSex());
            holder.salaryTv.setText(String.valueOf(userdata.getSalary()));
            holder.ratingTv.setText(String.valueOf(userdata.getRating()));
        }
        return result;
    }
}
