package com.smitha.lms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.smitha.lms.data.Book;
import static com.smitha.lms.AllUserActivity.booksList;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnBookListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Book newBookToList;
    private CustomBookAdapter badapter;
    ListView listView;

    private OnBookListFragmentInteractionListener mListener;

    public BookListFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment BookListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookListFragment newInstance(Book NewBook) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putSerializable("ARG_newBookToList", NewBook);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newBookToList= (Book)getArguments().getSerializable("ARG_newBookToList");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_book_list, container, false);
        final Button delButton1=(Button)view.findViewById(R.id.del_button1);
        final Button updateButton1=(Button)view.findViewById(R.id.update_button1);

        booksList.add(newBookToList);

        listView = (ListView) view.findViewById(R.id.listView_id1);
        badapter = new CustomBookAdapter(getActivity(), R.layout.book_list_item, booksList);
        listView.setAdapter(badapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                final Book b;
                b=(Book)adapterView.getItemAtPosition(i);
                delButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setSelected(true);
                        if(booksList.contains(b)){
                            booksList.remove(b);
                            badapter.notifyDataSetChanged();

                        }
                    }
                });
                updateButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setSelected(true);
                        mListener.onBookListFragmentInteraction(b);
                    }
                });

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBookListFragmentInteractionListener) {
            mListener = (OnBookListFragmentInteractionListener) context;
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
    public interface OnBookListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onBookListFragmentInteraction(Book selectedBook);
    }
}
