    package com.smitha.lms;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.ListView;
    import com.smitha.lms.data.User;

    import static com.smitha.lms.AllUserActivity.usersList;

    public class UserListActivity extends AppCompatActivity {
        //final String LOG_TAG = UserListActivity.class.getSimpleName();
        private CustomAdapter adapter;

        private Button del_button,update_button;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.user_list_view);
            User users;
            ListView listView;
            users = (User) getIntent().getSerializableExtra("userdetails");
            del_button=(Button)findViewById(R.id.del_button);
            update_button=(Button)findViewById(R.id.update_button);

                usersList.add(users);

            listView = (ListView) findViewById(R.id.listView_id);
            adapter = new CustomAdapter(this, R.layout.user_list_item, usersList);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    view.setSelected(true);
                    final User u;
                    u=(User)adapterView.getItemAtPosition(i);
                    del_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            view.setSelected(true);
                            if(usersList.contains(u)){
                                usersList.remove(u);
                                adapter.notifyDataSetChanged();

                            }
                        }
                    });
                    update_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            view.setSelected(true);
                            Intent intent=new Intent(getApplicationContext(),AllUserActivity.class);
                            intent.putExtra("selectedUser",u);
                            startActivity(intent);
                        }
                    });

                }
            });
        }
    }
