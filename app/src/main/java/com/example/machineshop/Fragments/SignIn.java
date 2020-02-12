package com.example.machineshop.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
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
public class SignIn extends Fragment {

    Button signInBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_sign_in, container, false);
        signInBtn = (Button) myView.findViewById(R.id.loginButton);
        signInBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Dashboard.class);
                startActivity(intent);

            }
        }   );
        return  myView;
    }
}
