package com.smitha.lms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.smitha.lms.data.Book;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnBookFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

     Book book;
    EditText bnameET,bauthorET,bidET;
    Spinner bcatagorysp,bstatussp;
    Button addBook_Button;
    private OnBookFragmentInteractionListener mListener;

    public BookFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance(String param1, String param2) {
        BookFragment fragment = new BookFragment();
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
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_book, container, false);
        bidET=(EditText)view.findViewById(R.id.bookId_editText);
        bnameET=(EditText)view.findViewById(R.id.bookName_editText);
        bauthorET=(EditText)view.findViewById(R.id.bookAuthor_editText);
        bcatagorysp=(Spinner)view.findViewById(R.id.category_spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.catagory_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bcatagorysp.setAdapter(adapter);
        bcatagorysp.setOnItemSelectedListener(this);
        bstatussp=(Spinner)view.findViewById(R.id.status_spinner);
        ArrayAdapter adapter_status=ArrayAdapter.createFromResource(getActivity(),R.array.status_name,android.R.layout.simple_spinner_item);
        adapter_status.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bstatussp.setAdapter(adapter_status );
        bstatussp.setOnItemSelectedListener(this);

        addBook_Button=(Button)view.findViewById(R.id.addBook_Button);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        addBook_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_currBook, author_currBook;
                int id_currBook;

                if (mListener != null) {
                    if (bidET.getText().toString().isEmpty()) {
                        bnameET.setError("Enter id");
                        bnameET.requestFocus();
                    }else if (bnameET.getText().toString().isEmpty()) {
                        bnameET.setError("Enter name");
                        bnameET.requestFocus();
                    } else if (bauthorET.getText().toString().isEmpty()) {
                        bauthorET.setError("Enter Age");
                        bauthorET.requestFocus();

                    } else {
                    id_currBook = Integer.parseInt(bidET.getText().toString());
                    name_currBook = bnameET.getText().toString();
                    author_currBook = bauthorET.getText().toString();
                    book = new Book(id_currBook, name_currBook, author_currBook, mParam1, mParam2);
                    Log.e("BookFragment", book.toString());
                      }
                    if (book != null)
                        mListener.onBookFragmentInteraction(book);
                }

            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBookFragmentInteractionListener) {
            mListener = (OnBookFragmentInteractionListener) context;
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch(adapterView.getId()){
            case R.id.category_spinner:mParam1=(String)adapterView.getItemAtPosition(i);
                break;
            case R.id.status_spinner:mParam2=(String)adapterView.getItemAtPosition(i);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
    public interface OnBookFragmentInteractionListener {
        // TODO: Update argument type and name
        void onBookFragmentInteraction(Book newbook);
    }
}

