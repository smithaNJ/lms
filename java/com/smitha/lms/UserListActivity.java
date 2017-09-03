    package com.smitha.lms;
    import android.net.Uri;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import com.smitha.lms.data.Book;
    import com.smitha.lms.data.User;

    public class UserListActivity extends AppCompatActivity implements StudentListFragment.OnStudentListFragmentInteractionListener,BookListFragment.OnBookListFragmentInteractionListener{
//        public static User updateUser;
//        public static Book updateBook;
        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.user_list_view);
            User users;
            Book books;
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            String display;
            display=getIntent().getStringExtra("fragmentDisplay");

            if("studentList".equals(display)){
                users = (User) getIntent().getSerializableExtra("NewUser");
                StudentListFragment studentListFragment=StudentListFragment.newInstance(users);
                transaction.replace(R.id.fragment_container2,studentListFragment).commit();

                Log.e("UserListActivity",users.toString());
            }else if("bookList".equals(display)){
                books = (Book) getIntent().getSerializableExtra("NewBook");
                BookListFragment bookListFragment=BookListFragment.newInstance(books);
                transaction.replace(R.id.fragment_container2,bookListFragment).commit();
            }

//        updateUser=(User)getIntent().getSerializableExtra("selectedUser");
//            updateBook=(Book)getIntent().getSerializableExtra("selectedBook");
       }

        @Override
        public void onStudentListFragmentInteraction(Uri uri) {

        }

        @Override
        public void onBookListFragmentInteraction(Uri uri) {

        }
    }
