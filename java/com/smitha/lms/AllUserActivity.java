package com.smitha.lms;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import com.smitha.lms.data.User;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static android.R.attr.button;
import static android.R.attr.data;
import static android.R.attr.id;
import static android.R.attr.rating;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.smitha.lms.R.id.rbF;
import static com.smitha.lms.R.id.rbM;

public class AllUserActivity extends AppCompatActivity {
    public static ArrayList<User> usersList=new ArrayList<User>();
    private final String LOG_TAG=AllUserActivity.class.getSimpleName();
   private User user,updateUser=null;
   private EditText nameET,ageET,salaryET;
    private RadioButton radioButtonM,radioButtonF;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;
    private Button addUser_button;
    private String name_currUser;
    private int age_currUser,rating_currUser;
    private double salary_currUser;
    private String sex_currUser;
    private Intent intent;
    private int updateUserId=-1,index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);


        nameET=(EditText)findViewById(R.id.name_editText);
        ageET=(EditText)findViewById(R.id.age_editText);
        salaryET=(EditText) findViewById(R.id.salary_editText);

        ratingBar=(RatingBar)findViewById(R.id.r_bar);
        addUser_button=(Button)findViewById(R.id.addUser_Button);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


       // updateUser=(User)getIntent().getSerializableExtra("selectedUser");



        if(updateUser!=null){
            updateUserId=updateUser.getId();
            addUser_button.setText("Save");
            updateUser();
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButtonM=(RadioButton)group.findViewById(R.id.rbM);
                radioButtonF=(RadioButton)group. findViewById(R.id.rbF);

                checkedId=group.getCheckedRadioButtonId();
                switch(checkedId){
                    case R.id.rbM:
                        sex_currUser=radioButtonM.getText().toString();
                        break;
                    case R.id.rbF:
                        sex_currUser=radioButtonF.getText().toString();
                        break;

                }
            }
        });


        addUser_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name_currUser=nameET.getText().toString();
                age_currUser=Integer.valueOf(ageET.getText().toString());

                salary_currUser=Double.valueOf(salaryET.getText().toString());
                rating_currUser = (int)ratingBar.getRating();

                    if(usersList.contains(updateUser)) {
                        index = usersList.indexOf(updateUser);
                        usersList.remove(index);
                        user=new User(updateUserId,name_currUser,age_currUser,sex_currUser,salary_currUser,rating_currUser);
                        updateUserId=-1;
                    }

                else {

                    int new_id = usersList.size() + 1;
                        user = new User(new_id, name_currUser, age_currUser, sex_currUser, salary_currUser, rating_currUser);

               }
                intent=new Intent(AllUserActivity.this,UserListActivity.class);
                intent.putExtra("userdetails",user);
                startActivity(intent);


            }
        });

    }
    public void addUser(){

    }

//    public Boolean getUpdateFlag() {
//        return updateFlag;
//    }

    public void updateUser(){

        nameET.setText(updateUser.getName());
        ageET.setText(String.valueOf(updateUser.getAge()));
        sex_currUser=updateUser.getSex();
        radioButtonM=(RadioButton)findViewById(R.id.rbM);
        radioButtonF=(RadioButton)findViewById(R.id.rbF);
        if(sex_currUser=="M") {
            radioButtonM.setText("M");
            radioButtonM.setChecked(true);

        }
            else{
            radioButtonF.setText("F");
            radioButtonF.setChecked(true);
        }
        salaryET.setText(String.valueOf(updateUser.getSalary()));
        ratingBar.setNumStars(5);
        ratingBar.setRating(updateUser.getRating());
        addUser();
    }


}
