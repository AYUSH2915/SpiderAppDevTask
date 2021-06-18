package com.example.spiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LorentzSection extends AppCompatActivity {
    private EditText editText1;
    private Button button3;
    private Button button4;
    private TextView textView7;
    private int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorentz_section);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        button4=findViewById(R.id.button4);
        button3=findViewById(R.id.button3);
        textView7=findViewById(R.id.textView7);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LorentzSection.this, "Welcome To Practice Setion", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(LorentzSection.this,quiz.class);
                startActivity(intent2);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=0;
                editText1=findViewById(R.id.editTextNumberDecimal3);
                if(editText1.length()==0)
                {
                    editText1.setError("Field Empty");
                }
                if(editText1.length()!=0){
                String str=editText1.getText().toString();


                    double mm=Double.parseDouble(str);
                    if(mm>300000000.0)
                    {
                        Toast.makeText(LorentzSection.this, "Velocity Cannot Be Greater Than That Of Light", Toast.LENGTH_SHORT).show();
                        textView7.setText("Error");
                        a++;
                    }



                if(a==0)
                {
                    double k=Double.parseDouble(str);

                    double f=(1.0)-((k*k)/(90000000000000000.0));
                    double j=Math.pow(f,0.5);
                    double r=1/(j);
                    String str5=Double.toString(r);


                    textView7.setText("Lorentz Factor = "+str5);


                }
            }}

        });

    }
}