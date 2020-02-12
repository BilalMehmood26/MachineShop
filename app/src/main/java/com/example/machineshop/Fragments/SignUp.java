package com.example.machineshop.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.machineshop.Dashboard;
import com.example.machineshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {
    Button signInBtn;

    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        signInBtn = (Button) myView.findViewById(R.id.signUp_btn);
        signInBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Dashboard.class);
                startActivity(intent);

            }
        }   );
        return myView;
    }

}
