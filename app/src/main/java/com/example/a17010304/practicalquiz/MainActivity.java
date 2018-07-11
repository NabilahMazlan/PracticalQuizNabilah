package com.example.a17010304.practicalquiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etAge;
    Spinner spnClass;
    Button buttonSave;
    int setClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        spnClass = findViewById(R.id.spinnerClass);
        buttonSave = findViewById(R.id.buttonSave);
        etAge = findViewById(R.id.editTextAge);

        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT);
            }
        });

        spnClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        setClass = i;
                        break;

                    case 1:
                        setClass = i;

                        break;

                    case 2:
                        setClass = i;

                        break;

                    case 3:
                        setClass = i;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        etName.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(etName, InputMethodManager.SHOW_IMPLICIT);

    }


    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String strAge = etAge.getText().toString();
        int age = Integer.parseInt(strAge);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putInt("age", age);
        prefEdit.putInt("class", setClass);
        prefEdit.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        String strName = etName.getText().toString();
        String strAge = etAge.getText().toString();
        int age = Integer.parseInt(strAge);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String rName = prefs.getString("name", strName);
        int rAge = prefs.getInt("age",age);
        int cClass = prefs.getInt("class", setClass);
        spnClass.setSelection(cClass);
        etName.setText(rName);
        etAge.setText(rAge);

    }


}
