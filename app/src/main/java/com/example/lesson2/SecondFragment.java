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

public class SecondFragment extends Fragment {
    private Button click2;
    private EditText editText2;
    public static final String  KEY_FOR_2BUNDLE = "key.2bundle";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        click2 = view.findViewById(R.id.click2);
        editText2 = view.findViewById(R.id.second_edit);
        if (getArguments() != null) {
            String value = getArguments().getString(firstFragment.KEY_FOR_1BUNNDLE);
            editText2.setText(value);
        }
        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText2.getText().toString().isEmpty()){
                    openThirdActivity();
                }else{
                    editText2.setError("write something");
                }
               
            }

        });
    }
    private void openThirdActivity(){
        Bundle bundle2= new Bundle();
        thirdFragment thirdFragment = new thirdFragment();
        thirdFragment.setArguments(bundle2);
        bundle2.putString(KEY_FOR_2BUNDLE,editText2.getText().toString());
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).disallowAddToBackStack().commit();

    }
}