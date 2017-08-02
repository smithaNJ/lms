    package com.smitha.lms;

    import android.content.Intent;
    import android.net.Uri;
    import android.support.v4.app.FragmentManager;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.RatingBar;
    import com.smitha.lms.data.User;
    import java.util.ArrayList;
    import android.support.v4.app.Fragment;


    public class AllUserActivity extends AppCompatActivity implements StudentFragment.OnFragmentInteractionListener,BookFragment.OnFragmentInteractionListener{
        public static ArrayList<User> usersList=new ArrayList<>();
       // private final String LOG_TAG=AllUserActivity.class.getSimpleName();
       private User user,updateUser=null;
       private EditText nameET,ageET,salaryET;
        private RadioButton radioButtonM,radioButtonF;
        private RadioGroup radioGroup;
        private RatingBar ratingBar;
        private Button addUser_button;
        private String name_currUser;
        private int age_currUser,rating_currUser;
        private double salary_currUser;
        private String gender_currUser;
        private Intent intent;
        private int updateUserId=-1,index;



//        @Override
//        protected void onResume() {
//            super.onResume();
//
//            if(updateUser!=null){
//                updateUser();
//            }else{
//                refreshScreen();
//                addUser_button.setText(R.string.new_user);
//            }
//        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_user);
//            nameET=(EditText)findViewById(R.id.name_editText);
//            ageET=(EditText)findViewById(R.id.age_editText);
//            salaryET=(EditText) findViewById(R.id.salary_editText);
//            ratingBar=(RatingBar)findViewById(R.id.r_bar);
//
//            addUser_button=(Button)findViewById(R.id.addUser_Button);
//            radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//
//            updateUser=(User)getIntent().getSerializableExtra("selectedUser");
//
//            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//            {
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    radioButtonM=(RadioButton)group.findViewById(R.id.rbM);
//                    radioButtonF=(RadioButton)group. findViewById(R.id.rbF);
//
//                    checkedId=group.getCheckedRadioButtonId();
//                    switch(checkedId){
//                        case R.id.rbM:
//                            gender_currUser =radioButtonM.getText().toString();
//                            break;
//                        case R.id.rbF:
//                            gender_currUser =radioButtonF.getText().toString();
//                            break;
//
//
//                    }
//                }
//            });
//
//
//            addUser_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(nameET.getText().toString().isEmpty()) {
//                        nameET.setError("Enter name");
//                        nameET.requestFocus();
//                    }
//                    else if(ageET.getText().toString().isEmpty()){
//                            ageET.setError("Enter Age");
//                            ageET.requestFocus();
//                    }
//                    else if(radioGroup.getCheckedRadioButtonId()==-1){
//                        radioButtonF.setError("select gender");
//                        radioGroup.requestFocus();
//                    }
//                    else if(salaryET.getText().toString().isEmpty()) {
//                        salaryET.setError("Enter Salary");
//                        salaryET.requestFocus();
//                    }
//                    else if(ratingBar.getRating()==0){
//                        ratingBar.requestFocus();
//                    }
//                    else{
//                        name_currUser=nameET.getText().toString();
//                        age_currUser=Integer.parseInt(ageET.getText().toString());
//                        salary_currUser=Double.parseDouble(salaryET.getText().toString());
//                        rating_currUser=ratingBar.getNumStars();
//                        if (usersList.contains(updateUser)) {
//                            index = usersList.indexOf(updateUser);
//                            usersList.remove(index);
//                            user = new User(updateUserId, name_currUser, age_currUser, gender_currUser, salary_currUser, rating_currUser);
//                            updateUser = null;
//                        } else {
//
//                            int new_id = usersList.size() + 1;
//                            user = new User(new_id, name_currUser, age_currUser, gender_currUser, salary_currUser, rating_currUser);
//
//                        }
//                        intent = new Intent(AllUserActivity.this, UserListActivity.class);
//                        intent.putExtra("userdetails", user);
//                        startActivity(intent);
//                    }
//
//                }
//            });

       }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.options_menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            StudentFragment studentFragment=StudentFragment.newInstance("hello","smitha");
            BookFragment bookFragment=BookFragment.newInstance("hello","smitha");
             switch (item.getItemId()){
                 case R.id.student_menu:


                     transaction.replace(R.id.fragment_container, studentFragment).commit();
                     break;

                 case R.id.book_menu:

                     transaction.replace(R.id.fragment_container, bookFragment).commit();
                     break;
             }
            return super.onOptionsItemSelected(item);
        }

        public void updateUser(){

            nameET.setText(updateUser.getName());
            ageET.setText(String.valueOf(updateUser.getAge()));
            gender_currUser =updateUser.getSex();
            radioButtonM=(RadioButton)findViewById(R.id.rbM);
            radioButtonF=(RadioButton)findViewById(R.id.rbF);

            if(gender_currUser.equals("M")) {

                radioButtonM.setText("M");
                radioButtonM.setChecked(true);

            }
            else if(gender_currUser.equals("F")){
                radioButtonF.setText("F");
                radioButtonF.setChecked(true);
            }
            salaryET.setText(String.valueOf(updateUser.getSalary()));
            ratingBar.setNumStars(5);
            ratingBar.setRating(updateUser.getRating());

        }
        public void refreshScreen(){
//            nameET.setText("");
//            ageET.setText("");
//            salaryET.setText("");
//            ratingBar.setRating(0);
//            radioGroup.clearCheck();

        }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }
    }
