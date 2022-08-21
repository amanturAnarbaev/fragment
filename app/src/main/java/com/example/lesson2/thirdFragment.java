package com.example.lesson2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class thirdFragment extends Fragment {

private TextView textView;
public static final String  KEY_FOR_2BUNDLE = "key.2bundle";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView=view.findViewById(R.id.textView);
        Bundle bundle2= new Bundle();
        if(getArguments()!= null){
            String value2 = getArguments().getString(SecondFragment.KEY_FOR_2BUNDLE);
            textView.setText(value2);
        }
    }
}