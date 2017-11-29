package com.example.taruc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge=(Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender=(RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale=(RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale=(RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker=(CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium=(TextView)findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);

    }
    @Override
    public void onItemSelected(AdapterView<?>parent,View view,int position, long id) {
        Toast.makeText(this, "Position:" + position, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos;
        double premium = 0;
        pos = spinnerAge.getSelectedItemPosition();
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender==R.id.radioButtonMale)
        {
            if(pos < 2 || pos > 5){
                premium += 0;
            }
            else if ( pos == 2 || pos == 5){
                premium +=5;
            }
            else
            {
                premium += 100;
            }
        }
            else
        {

        }
        if(checkBoxSmoker.isChecked())
        {
            if(pos > 3)
            {
                premium +=0;
            }
            else if(pos == 3)
            {

            }
        }

        textViewPremium.setText(getString(R.string.premium)+premium);
    }



}
