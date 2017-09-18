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
        public static Book book;

       private User updateUser;
        private Book updateBook;
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
            updateBook=(Book)getIntent().getSerializableExtra("selectedBook");

            if(updateUser!=null){
                user=updateUser;
                Log.e("updateuser",updateUser.toString());
                StudentFragment studentFragment;
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                studentFragment=StudentFragment.newInstance(user);
                transaction.replace(R.id.fragment_container,studentFragment).commit();

           }
            if(updateBook!=null){
                book=updateBook;
                Log.e("updatebook",updateBook.toString());
                BookFragment bookFragment;
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                bookFragment=BookFragment.newInstance(book);
                transaction.replace(R.id.fragment_container,bookFragment).commit();
            }



       }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.options_menu,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            user=null;
            book = null;
            StudentFragment studentFragment;
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
             studentFragment=StudentFragment.newInstance(user);
            BookFragment bookFragment=BookFragment.newInstance(book);

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
