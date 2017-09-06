    package com.smitha.lms;

    import android.content.Intent;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.widget.RadioButton;
//    import android.widget.Button;
//    import android.widget.EditText;
//    import android.widget.RadioButton;
//    import android.widget.RadioGroup;
//    import android.widget.RatingBar;

    import com.smitha.lms.data.Book;
    import com.smitha.lms.data.User;
    import java.util.ArrayList;

    import static com.smitha.lms.R.id.radioGroup;


    public class AllUserActivity extends AppCompatActivity implements StudentFragment.OnStudentFragmentInteractionListener,BookFragment.OnBookFragmentInteractionListener {
        public static ArrayList<User> usersList=new ArrayList<>();
        public static ArrayList<Book> booksList=new ArrayList<>();
        public static User user;

       private User updateUser;
//        private EditText nameET,ageET,salaryET;
//
//        private RadioGroup radioGroup;
//        private RatingBar ratingBar;
//        private Button addUser_button;
//        private String name_currUser;
//        private int age_currUser,rating_currUser;
//        private double salary_currUser;
//        private String gender_currUser;
//        private Intent intent;
//        private int updateUserId=-1,index;



        @Override
        protected void onResume() {
            super.onResume();


        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_user);
            updateUser=(User)getIntent().getSerializableExtra("selectedUser");

            if(updateUser!=null){
                Log.e("updateuser",updateUser.toString());
                StudentFragment studentFragment;
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                studentFragment=StudentFragment.newInstance(updateUser);
                transaction.replace(R.id.fragment_container,studentFragment).commit();

           }
     //       else{

//                StudentFragment studentFragment;
//                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//                studentFragment=StudentFragment.newInstance(user);
//                transaction.replace(R.id.fragment_container,studentFragment).commit();
//            }


       }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.options_menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            StudentFragment studentFragment;
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
             studentFragment=StudentFragment.newInstance(user);
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

//        public void updateUser(){
//             RadioButton radioButtonM,radioButtonF;
//            nameET.setText(updateUser.getName());
//            ageET.setText(String.valueOf(updateUser.getAge()));
//            gender_currUser =updateUser.getGender();
//            radioButtonM=(RadioButton)findViewById(R.id.rbM);
//            radioButtonF=(RadioButton)findViewById(R.id.rbF);
//
//            if(gender_currUser.equals("M")) {
//
//                radioButtonM.setText("M");
//                radioButtonM.setChecked(true);
//
//            }
//            else if(gender_currUser.equals("F")){
//                radioButtonF.setText("F");
//                radioButtonF.setChecked(true);
//            }
//            salaryET.setText(String.valueOf(updateUser.getSalary()));
//            ratingBar.setNumStars(5);
//            ratingBar.setRating(updateUser.getRating());
//
//        }
//        public void refreshScreen(){
//            nameET.setText("");
//            ageET.setText("");
//            salaryET.setText("");
//            ratingBar.setRating(0);
//            radioGroup.clearCheck();
//
//        }

        @Override
        public void onStudentFragmentInteraction(User newuser) {
            Intent intent=new Intent(this,UserListActivity.class);
            intent.putExtra("fragmentDisplay","studentList");
            intent.putExtra("NewUser",newuser);
            startActivity(intent);
        }

        @Override
        public void onBookFragmentInteraction(Book newbook) {
            Intent intent=new Intent(this,UserListActivity.class);
            intent.putExtra("fragmentDisplay","bookList");
            intent.putExtra("NewBook",newbook);
            startActivity(intent);
        }
    }
