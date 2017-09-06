    package com.smitha.lms;

    import android.content.Context;
    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.AdapterView;
    import android.widget.Button;
    import android.widget.ListView;

    import com.smitha.lms.data.User;

    import static com.smitha.lms.AllUserActivity.usersList;

    /**
    * A simple {@link Fragment} subclass.
    * Activities that contain this fragment must implement the
    * {@link StudentListFragment.OnStudentListFragmentInteractionListener} interface
    * to handle interaction events.
    * Use the {@link StudentListFragment#newInstance} factory method to
    * create an instance of this fragment.
    */
    public class StudentListFragment extends Fragment {

    private User newUserToList;
    ListView listView;
    private OnStudentListFragmentInteractionListener mListener;
    private CustomAdapter adapter;
    public StudentListFragment() {
    }
    public static StudentListFragment newInstance(User newUser) {
    StudentListFragment fragment = new StudentListFragment();
    Bundle args = new Bundle();
    args.putSerializable("ARG_newUserToList",newUser);
    fragment.setArguments(args);
    return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null)
        newUserToList = (User) getArguments().getSerializable("ARG_newUserToList");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view;
    view=inflater.inflate(R.layout.fragment_student_list, container, false);
    final Button delButton=(Button)view.findViewById(R.id.del_button);
    final Button updateButton=(Button)view.findViewById(R.id.update_button);
    usersList.add(newUserToList);
    listView = (ListView) view.findViewById(R.id.listView_id);
    adapter = new CustomAdapter(getActivity(), R.layout.user_list_item, usersList);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            view.setSelected(true);
            final User u;
            u=(User)adapterView.getItemAtPosition(i);
            delButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setSelected(true);
                    if(usersList.contains(u)){
                        usersList.remove(u);
                        adapter.notifyDataSetChanged();

                    }
                }
            });
            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setSelected(true);
                    Log.e("StudentListFragment",u.toString());
                    mListener.onStudentListFragmentInteraction(u);

                }
            });

        }
    });

    return view;
    }



    @Override
    public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnStudentListFragmentInteractionListener) {
        mListener = (OnStudentListFragmentInteractionListener) context;
    } else {
        throw new RuntimeException(context.toString()
                + " must implement OnBookListFragmentInteractionListener");
    }
    }

    @Override
    public void onDetach() {
    super.onDetach();
    mListener = null;
    }

    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnStudentListFragmentInteractionListener {
    // TODO: Update argument type and name
    void onStudentListFragmentInteraction(User selectedUser);

    }
    }
