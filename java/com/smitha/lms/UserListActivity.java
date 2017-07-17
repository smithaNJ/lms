package com.smitha.lms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.smitha.lms.data.User;

import static com.smitha.lms.AllUserActivity.usersList;

public class UserListActivity extends AppCompatActivity {
    final String LOG_TAG = UserListActivity.class.getSimpleName();
    private TableLayout tableLayout;
    private TableRow tableRow;
    private TextView nametextView, agetextView, sextextView, salarytextView, ratingtextView,ntv,atv,stv,satv,rtv;
    private User users;
    private CustomAdapter adapter;
    private ListView listView;
    private Button del_button,update_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_user_list);
        setContentView(R.layout.user_list_view);
//        initableLayout();
//

        users = (User) getIntent().getSerializableExtra("userdetails");
        del_button=(Button)findViewById(R.id.del_button);
        update_button=(Button)findViewById(R.id.update_button);

//        if(usersList.contains(users)){
//            usersList.remove(users.getId());
//        }else {
//        Log.e(LOG_TAG,usersList.toString());
//        Log.e(LOG_TAG,users.toString());

            usersList.add(users);


        //       Log.e(LOG_TAG,usersList.toString());
        //  }
        listView = (ListView) findViewById(R.id.listView_id);
        // adapter=new CustomAdapter(this,R.id.linear_layout_row,R.id.name_col_textView,usersList);
        adapter = new CustomAdapter(this, R.layout.user_list_item, usersList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String t;
                final User u;
                u=(User)adapterView.getItemAtPosition(i);
                t=u.toString();
                del_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(usersList.contains(u)){
                            usersList.remove(u);
                            adapter.remove(u);
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
                update_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),AllUserActivity.class);
                        intent.putExtra("selectedUser",u);
                        startActivity(intent);
                    }
                });

            }
        });
    }

    //        inittableLayout();
//
//
//          Bundle bundle=this.getIntent().getExtras();
////        String usr=bundle.getString("UserDetails");
////
////       // textView.setText(usr+"\n");
////        Log.e(LOG_TAG,usr);
//        addUsers();
//        tableRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                final int index=tableLayout.indexOfChild(view);
//                Button delbutton=(Button)findViewById(R.id.del_button);
//                delbutton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        usersList.remove(index-1);
//                        inittableLayout();
//                        addUsers();
//                    }
//                });
//                Button updatebutton=(Button)findViewById(R.id.update_button);
//                updatebutton.setOnClickListener(new View.OnClickListener(){
//
//                    @Override
//                    public void onClick(View view) {
//                        User selecteduser=usersList.get(index-1);
//                        Log.e(LOG_TAG,"selecteduser"+selecteduser.toString());
//                        Intent intent =new Intent(getApplicationContext(),AllUserActivity.class);
//                        intent.putExtra("selectedUser",selecteduser);
//                        startActivity(intent);
//
//                    }
//                });
//            }
//        });
//
//
//    }
//    public void addUsers() {
//
//
//        Drawable shape = ContextCompat.getDrawable(this,R.drawable.shape);
//
//        for (int i = 0; i < usersList.size(); i++) {
//
//            User curruser = usersList.get(i);
//            tableRow = new TableRow(this);
//
//            nametextView = new TextView(this);
//            nametextView.setText(curruser.getName());
//            nametextView.setTextSize(16);
//            nametextView.setTypeface(null, Typeface.BOLD);
//            nametextView.setTextColor(Color.BLUE);
//            nametextView.setGravity(Gravity.CENTER);
//            nametextView.setBackground(shape);
////            nametextView.setBackgroundColor(Color.CYAN);
//            nametextView.setPaddingRelative(16, 0, 16, 0);
//            tableRow.addView(nametextView, 0);
//
//            agetextView = new TextView(this);
//            agetextView.setText(String.valueOf(curruser.getAge()));
//            agetextView.setTextSize(16);
//            agetextView.setTypeface(null,Typeface.BOLD);
//            agetextView.setTextColor(Color.BLUE);
//            agetextView.setGravity(Gravity.CENTER);
//            agetextView.setBackground(shape);
////            agetextView.setBackgroundColor(Color.CYAN);
//            agetextView.setPaddingRelative(16, 0, 16, 0);
//            tableRow.addView(agetextView, 1);
//
//            sextextView = new TextView(this);
//            sextextView.setText(String.valueOf(curruser.getSex()));
//            sextextView.setTextSize(16);
//            sextextView.setTypeface(null,Typeface.BOLD);
//            sextextView.setTextColor(Color.BLUE);
//            sextextView.setGravity(Gravity.CENTER);
//            sextextView.setBackground(shape);
//            sextextView.setPaddingRelative(16, 0, 16, 0);
////            sextextView.setBackgroundColor(Color.CYAN);
//            tableRow.addView(sextextView, 2);
//
//            salarytextView = new TextView(this);
//            salarytextView.setText(String.valueOf(curruser.getSalary()));
//            salarytextView.setTextSize(16);
//            salarytextView.setTypeface(null,Typeface.BOLD);
//            salarytextView.setTextColor(Color.BLUE);
//            salarytextView.setGravity(Gravity.CENTER);
//            salarytextView.setBackground(shape);
////            salarytextView.setBackgroundColor(Color.CYAN);
//           salarytextView.setPaddingRelative(16, 0, 16, 0);
//            tableRow.addView(salarytextView, 3);
//
//            ratingtextView = new TextView(this);
//            ratingtextView.setText(String.valueOf(curruser.getRating()));
//            ratingtextView.setTextSize(16);
//            ratingtextView.setTypeface(null,Typeface.BOLD);
//            ratingtextView.setTextColor(Color.BLUE);
//            ratingtextView.setGravity(Gravity.CENTER);
//            ratingtextView.setBackground(shape);
////            ratingtextView.setBackgroundColor(Color.CYAN);
//            ratingtextView.setPaddingRelative(16, 0, 16, 0);
//            tableRow.addView(ratingtextView, 4);
//
//            tableLayout.addView(tableRow);
//
//
//        }
//    }
//    public void initableLayout() {
//        Drawable shape = ContextCompat.getDrawable(this, R.drawable.shape);
//
//        if (tableLayout != null)
//            tableLayout.removeAllViews();
//        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
//
//        tableRow = new TableRow(this);
//        TableRow.LayoutParams params1 = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT, 10f);
//        tableRow.setLayoutParams(params1);
//
//        nametextView = new TextView(this);
//        TableRow.LayoutParams params2 = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 2f);
//        nametextView.setLayoutParams(params2);
//        nametextView.setText("NAME");
//        nametextView.setTextSize(18);
//        nametextView.setTypeface(null, Typeface.BOLD);
//        nametextView.setTextColor(Color.BLUE);
//        //  nametextView.setGravity(Gravity.CENTER);
//        nametextView.setBackground(shape);
//       nametextView.setPadding(5,5,5,5);
////        nametextView.setBackgroundColor(Color.CYAN);
////        nametextView.setPaddingRelative(16, 0, 16, 0);
//        tableRow.addView(nametextView, 0);
//
//        agetextView = new TextView(this);
//        TableRow.LayoutParams params3 = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 2f);
//        agetextView.setLayoutParams(params3);
//        agetextView.setText("AGE");
//        agetextView.setTextSize(18);
//        agetextView.setTypeface(null, Typeface.BOLD);
//        agetextView.setTextColor(Color.BLUE);
//        //       agetextView.setGravity(Gravity.CENTER);
//        agetextView.setBackground(shape);
////        agetextView.setBackgroundColor(Color.CYAN);
////        agetextView.setPaddingRelative(16, 0, 16, 0);
//        nametextView.setPadding(5,5,5,5);
//        tableRow.addView(agetextView, 1);
//
//        sextextView = new TextView(this);
//        agetextView.setLayoutParams(params2);
//        sextextView.setText("SEX");
//        sextextView.setTextSize(18);
//        sextextView.setTypeface(null, Typeface.BOLD);
//        sextextView.setTextColor(Color.BLUE);
//        //       sextextView.setGravity(Gravity.CENTER);
//        sextextView.setBackground(shape);
//        //      sextextView.setPaddingRelative(16, 0, 16, 0);
//        //      sextextView.setBackgroundColor(Color.CYAN);
//        nametextView.setPadding(5,5,5,5);
//        tableRow.addView(sextextView, 2);
//
//        salarytextView = new TextView(this);
//        TableRow.LayoutParams params4 = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 2f);
//        salarytextView.setLayoutParams(params4);
//        agetextView.setLayoutParams(params2);
//        salarytextView.setText("SALARY");
//        salarytextView.setTextSize(18);
//        salarytextView.setTypeface(null, Typeface.BOLD);
//        salarytextView.setTextColor(Color.BLUE);
//        //       salarytextView.setGravity(Gravity.CENTER);
//        salarytextView.setBackground(shape);
////        salarytextView.setBackgroundColor(Color.CYAN);
//        //       salarytextView.setPaddingRelative(16, 0, 16, 0);
//        nametextView.setPadding(5,5,5,5);
//        tableRow.addView(salarytextView, 3);
//
//        ratingtextView = new TextView(this);
//        TableRow.LayoutParams params5 = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 2f);
//        ratingtextView.setLayoutParams(params5);
//        agetextView.setLayoutParams(params2);
//        ratingtextView.setText("RATING");
//        ratingtextView.setTextSize(18);
//        ratingtextView.setTypeface(null, Typeface.BOLD);
//        ratingtextView.setTextColor(Color.BLUE);
//        //       ratingtextView.setGravity(Gravity.CENTER);
//        ratingtextView.setBackground(shape);
////        ratingtextView.setBackgroundColor(Color.CYAN);
//        //      ratingtextView.setPaddingRelative(16, 0, 16, 0);
//        nametextView.setPadding(5,5,5,5);
//        tableRow.addView(ratingtextView, 4);
//
//        tableLayout.addView(tableRow);
//    }


}
