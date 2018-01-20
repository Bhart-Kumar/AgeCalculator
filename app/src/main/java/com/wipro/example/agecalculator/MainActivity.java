package com.wipro.example.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private Button selectBtn;
    private int startYear;
    private int startMonth;
    private int startDay;
    private int selectedDay;
    private AgeCalculation age = null;
    private TextView currentDate;
    private TextView birthDate;
    private TextView result;
    DatePicker simpleDatePicker;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        age=new AgeCalculation();
        currentDate=(TextView) findViewById(R.id.textView1);
        currentDate.setText("Current Date(DD/MM/YY) : "+age.getCurrentDate());
        birthDate=(TextView) findViewById(R.id.textView2);
        result=(TextView) findViewById(R.id.textView3);
        btnStart=(Button) findViewById(R.id.submit);
        selectBtn=(Button) findViewById(R.id.button1);
        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
        selectBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                simpleDatePicker.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startYear=simpleDatePicker.getYear();
                startMonth= (simpleDatePicker.getMonth() + 1);
                startDay=simpleDatePicker.getDayOfMonth();
                selectedDay = simpleDatePicker.getFirstDayOfWeek();
                age.setDateOfBirth(startYear, startMonth, startDay);
                birthDate.setText("Date of Birth(DD/MM/YY): "+selectedDay+":"+(startMonth)+":"+startYear);
                calculateAge();
            }
        });

    }
    private void calculateAge()
    {
        age.calcualteYear();
        age.calcualteMonth();
        age.calcualteDay();
        Toast.makeText(getBaseContext(), "Your Age Is "+age.getResult() , Toast.LENGTH_SHORT).show();
        result.setText("AGE (DD/MM/YY) :"+age.getResult());
    }
}
