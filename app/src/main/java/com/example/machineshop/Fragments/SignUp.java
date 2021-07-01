package com.example.machineshop.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.machineshop.Dashboard;
import com.example.machineshop.R;
import com.example.machineshop.SignupModelClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {
    Button signInBtn;
    TextInputLayout mEmail, mPassword, mBusinessName, mBusinessAddress, mPhoneNo;

    private DatabaseReference mDataBaseReference;
    private FirebaseDatabase mRootNode;

    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        /*-----Hooks-------*/
        signInBtn = (Button) myView.findViewById(R.id.signUp_btn);
        mEmail = myView.findViewById(R.id.et_email);
        mPassword = myView.findViewById(R.id.et_password);
        mBusinessName = myView.findViewById(R.id.et_business_Name);
        mBusinessAddress = myView.findViewById(R.id.et_address);
        mPhoneNo = myView.findViewById(R.id.et_Contact);


        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toSignUp();

            }
        });
        return myView;
    }

    public boolean validateEmail() {
        String val = mEmail.getEditText().getText().toString().trim();
        String pattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";
     /*   String pattern = "[a-zA-Z0-9._]+@[a-z]+";*/

        if (val.isEmpty()) {
            mEmail.setError("Required");
            return false;
        } else if (!val.matches(pattern)) {

            mEmail.setError("Invalid Email Pattern");
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
            mPassword.setError("Required");
            return false;
        } else {
            mPassword.setError(null);
            mPassword.setErrorEnabled(false);
            return true;
        }

    }

    public Boolean validateBusinessName() {
        String val = mBusinessName.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            mBusinessName.setError("Required");
            return false;
        } else {
            mBusinessName.setError(null);
            mBusinessName.setErrorEnabled(false);
            return true;
        }

    }

    public Boolean validateBusinessAddress() {
        String val = mBusinessAddress.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            mBusinessAddress.setError("Required");
            return false;
        } else {
            mBusinessAddress.setError(null);
            mBusinessAddress.setErrorEnabled(false);
            return true;
        }

    }

    public Boolean validatePhoneNumber() {
        String val = mPhoneNo.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            mPhoneNo.setError("Required");
            return false;
        } else if (val.length() > 11) {
            mPhoneNo.setError("Invalid Phone No");
            return false;
        } else if (val.length() < 11) {
            mPhoneNo.setError("Invalid Phone No");
            return false;
        }else {
            mPhoneNo.setError(null);
            mPhoneNo.setErrorEnabled(false);
            return true;
        }

    }

    public void toSignUp() {

        if (!validateEmail() || !validatePassword() || !validateBusinessName()
                || !validateBusinessAddress() || !validatePhoneNumber()) {
            return;
        }

        String email = mEmail.getEditText().getText().toString().trim();
        String password = mPassword.getEditText().getText().toString().trim();
        String businessName = mBusinessName.getEditText().getText().toString().trim();
        String businessAddress = mBusinessAddress.getEditText().getText().toString().trim();
        String contact = mPhoneNo.getEditText().getText().toString().trim();


        mRootNode = FirebaseDatabase.getInstance();
        mDataBaseReference = mRootNode.getReference("user");


        SignupModelClass userSignUp = new SignupModelClass(email, password, businessName, businessAddress, contact);
        mDataBaseReference.child(contact).setValue(userSignUp);


        Toast.makeText(getActivity().getBaseContext(), "User Created", Toast.LENGTH_SHORT).show();


        mEmail.getEditText().getText().clear();
        mPassword.getEditText().getText().clear();
        mBusinessName.getEditText().getText().clear();
        mBusinessAddress.getEditText().getText().clear();
        mPhoneNo.getEditText().getText().clear();

    }

}
