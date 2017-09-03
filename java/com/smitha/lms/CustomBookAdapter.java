package com.smitha.lms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.smitha.lms.data.Book;

import java.util.ArrayList;
import java.util.List;


 class CustomBookAdapter extends ArrayAdapter implements View.OnClickListener{
    private ArrayList<Book> bookDataSet;
    private Book bookData;

    @Override
    public void onClick(View view) {
        int mposition;
        mposition=(int)view.getTag();
        bookData=(Book)getItem(mposition);
    }

    private static class ViewHolder {
        TextView bidTv,bnameTv,bauthorTv,bcatagoryTv,bstatusTv;
    }
     CustomBookAdapter(Context context, int resourceId, List objects) {
        super(context,  resourceId, objects);
        bookDataSet=(ArrayList<Book>)objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater;

        ViewHolder holder=new ViewHolder();
        View result;

        if(convertView==null){
            inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.book_list_item,parent,false);
            holder.bidTv=(TextView)convertView.findViewById(R.id.bid_col_textView);
            holder.bnameTv=(TextView)convertView.findViewById(R.id.bname_col_textView);
            holder.bauthorTv=(TextView)convertView.findViewById(R.id.bauthor_col_textView);
            holder.bcatagoryTv=(TextView)convertView.findViewById(R.id.bcatagory_col_textView);
            holder.bstatusTv=(TextView)convertView.findViewById(R.id.bstatus_col_textView);

            result=convertView;
            convertView.setTag(holder);


        }else{
            holder=(ViewHolder)convertView.getTag();
            result=convertView;

        }
        if(bookDataSet.size()<=0){
            holder.bidTv.setText("");
            holder.bnameTv.setText("");
            holder.bauthorTv.setText("");
            holder.bcatagoryTv.setText("");
            holder.bstatusTv.setText("");
        }else{
            bookData=(Book)getItem(position);
            holder.bidTv.setText(String.valueOf( bookData.getId()));
            holder.bnameTv.setText(bookData.getName());
            holder.bauthorTv.setText(bookData.getAuthor());
            holder.bcatagoryTv.setText(bookData.getCatagory());
            holder.bstatusTv.setText(bookData.getStatus());
        }
        return result;
    }
}


