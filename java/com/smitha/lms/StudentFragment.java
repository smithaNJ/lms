package com.smitha.lms;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import com.smitha.lms.data.User;
import static com.smitha.lms.AllUserActivity.usersList;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnStudentFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
     String mParam1;
     User user=null;
     EditText nameET,ageET,salaryET;
    RatingBar ratingBar;
    Button addUser_button;

    OnStudentFragmentInteractionListener mListener;

    public StudentFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentFragment newInstance(String param1, String param2) {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;

        view=inflater.inflate(R.layout.fragment_student, container, false);


         nameET =(EditText) view.findViewById(R.id.name_editText);
         ageET=(EditText) view.findViewById(R.id.age_editText);
         salaryET=(EditText) view.findViewById(R.id.salary_editText);
         ratingBar=(RatingBar) view.findViewById(R.id.r_bar);
        addUser_button=(Button)view.findViewById(R.id.addUser_Button);

        final RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            RadioButton radioButtonF,radioButtonM;
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButtonM=(RadioButton)group.findViewById(R.id.rbM);
                radioButtonF=(RadioButton)group. findViewById(R.id.rbF);

                checkedId=group.getCheckedRadioButtonId();
                switch(checkedId){
                    case R.id.rbM:
                        mParam1 =radioButtonM.getText().toString();
                        break;
                    case R.id.rbF:
                        mParam1 =radioButtonF.getText().toString();
                        break;
                    case -1:radioButtonF.setError("select gender");
                        radioGroup.requestFocus();
                        break;

                }
            }
        });
        return view;


    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onResume() {
        super.onResume();
        addUser_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_currUser;
                int age_currUser, rating_currUser;
                double salary_currUser;
                if (mListener != null) {
                    if (nameET.getText().toString().isEmpty()) {
                        nameET.setError("Enter name");
                        nameET.requestFocus();
                    } else if (ageET.getText().toString().isEmpty()) {
                        ageET.setError("Enter Age");
                        ageET.requestFocus();
                    }
                    else if (salaryET.getText().toString().isEmpty()) {
                        salaryET.setError("Enter Salary");
                        salaryET.requestFocus();
                    } else if (ratingBar.getRating() == 0) {
                        ratingBar.requestFocus();
                    } else {
                        name_currUser = nameET.getText().toString();
                        age_currUser = Integer.parseInt(ageET.getText().toString());
                        salary_currUser = Double.parseDouble(salaryET.getText().toString());
                        rating_currUser = ratingBar.getNumStars();
                        int new_id = usersList.size() + 1;
                        user = new User(new_id, name_currUser, age_currUser, mParam1, salary_currUser, rating_currUser);
                        Log.e("studentFragment", user.toString());
                    }
                    if (user != null)
                        mListener.onStudentFragmentInteraction(user);
                }

            }
        });


    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStudentFragmentInteractionListener) {
            mListener = (OnStudentFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStudentFragmentInteractionListener");
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
    public interface OnStudentFragmentInteractionListener {
        // TODO: Update argument type and name
        void onStudentFragmentInteraction(User newuser);
    }
}

