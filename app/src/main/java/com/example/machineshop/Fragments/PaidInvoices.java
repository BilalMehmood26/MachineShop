package com.example.machineshop.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.machineshop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaidInvoices extends Fragment {


    public PaidInvoices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_paid_invoices, container, false);
    }

}
