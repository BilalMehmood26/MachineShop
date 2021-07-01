package com.example.machineshop.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.machineshop.Dashboard;
import com.example.machineshop.MainActivity;
import com.example.machineshop.R;
import com.example.machineshop.SignupModelClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignIn extends Fragment {

    TextInputLayout mEmail, mPassword;
    Button signInBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_sign_in, container, false);

        /*---hooks----*/
        signInBtn = (Button) myView.findViewById(R.id.loginButton);
        mEmail = myView.findViewById(R.id.et_email);
        mPassword = myView.findViewById(R.id.et_password);


        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
        return myView;
    }

    public Boolean validateEmail() {
        String val = mEmail.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            mEmail.setError("Field cannot be empty");
            return false;
        } else {
            mEmail.setError(null);
            mEmail.setErrorEnabled(false);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = mPassword.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            mPassword.setError("Field cannot be empty");
            return false;
        } else {
            mPassword.setError(null);
            mPassword.setErrorEnabled(false);
            return true;
        }

    }

    public void userLogin() {
        if (!validateEmail() || !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredEmail = mEmail.getEditText().getText().toString().trim();
        final String userEnteredPassword = mPassword.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user");

        Query checkUser = reference.orderByChild("mEmail").equalTo(userEnteredEmail);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    mEmail.setError(null);
                    mEmail.setErrorEnabled(false);


                    SignupModelClass signupModelClass = dataSnapshot.getChildren().iterator().next().getValue(SignupModelClass.class);



                    if (signupModelClass.getmPassword().equals(userEnteredPassword)) {

                        mPassword.setError(null);
                        mPassword.setErrorEnabled(false);

                        Intent intent = new Intent(getActivity(), Dashboard.class);

                        intent.putExtra("mEmail",signupModelClass.getmEmail() );
                        intent.putExtra("mPassword",signupModelClass.getmPassword() );
                        intent.putExtra("mBusinessName",signupModelClass.getmBusinessName() );
                        intent.putExtra("mBusinessAddress",signupModelClass.getMbusinessAddress());
                        intent.putExtra("mPhoneNo",signupModelClass.getmPhoneNo());

                        startActivity(intent);

                    }else{
                        mPassword.setError("Wrong Password");
                        mPassword.requestFocus();
                    }
                }else{
                    mEmail.setError("Wrong Email");
                    mEmail.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
