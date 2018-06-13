package com.auribises.enc2018android;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment {


    Button btn;
    EditText eTxt;
    public UpperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_upper, container, false);

        btn = view.findViewById(R.id.buttonSubmit);
        eTxt = view.findViewById(R.id.editText9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = eTxt.getText().toString();
                Toast.makeText(getContext(),"You Entered: "+name,Toast.LENGTH_LONG).show();


            }
        });

        return view;
    }

}
