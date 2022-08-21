package com.example.lesson2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class firstFragment extends Fragment {
private Button click;
private EditText editText1;
public static final String KEY_FOR_1BUNNDLE= "key.bundle1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        click= view.findViewById(R.id.click);
        editText1= view.findViewById(R.id.first_edit);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText1.getText().toString().isEmpty()){
                    openSecondFragment();
                }
                else{
                    editText1.setError("write something");
                }

            }
        });
    }
    private void openSecondFragment(){
        Bundle bundle1= new Bundle();
        bundle1.putString(KEY_FOR_1BUNNDLE,editText1.getText().toString());
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle1);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,secondFragment).addToBackStack(null).commit();
    }
}