    package com.smitha.lms;
    import android.content.ComponentName;
    import android.content.Intent;
    import android.support.v4.app.FragmentTransaction;
    import android.support.v4.content.IntentCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import com.smitha.lms.data.Book;
    import com.smitha.lms.data.User;

    public class UserListActivity extends AppCompatActivity implements StudentListFragment.OnStudentListFragmentInteractionListener,BookListFragment.OnBookListFragmentInteractionListener{


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
                Log.e("UserListActivity",books.toString());

            }


       }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent=new Intent(UserListActivity.this,AllUserActivity.class);
           // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

//            Intent intent = new Intent(UserListActivity.this,AllUserActivity.class);
//            ComponentName cn = intent.getComponent();
//            Intent mainIntent = IntentCompat.makeRestartActivityTask(cn);
//            startActivity(mainIntent);

        }

        @Override
        public void onStudentListFragmentInteraction(User selectedUser) {
//         FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//            StudentFragment studentFragment=StudentFragment.newInstance(selectedUser);
//            transaction.replace(R.id.fragment_container,studentFragment);
            Intent intent=new Intent(UserListActivity.this,AllUserActivity.class);
           // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("selectedUser",selectedUser);
            startActivity(intent);
        }

        @Override
        public void onBookListFragmentInteraction(Book selectedBook) {
//            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//            BookFragment bookFragment=BookFragment.newInstance(selectedBook);
//            transaction.replace(R.id.fragment_container,bookFragment);
            Intent intent=new Intent(UserListActivity.this,AllUserActivity.class);
            intent.putExtra("selectedBook",selectedBook);
            startActivity(intent);

        }
    }
