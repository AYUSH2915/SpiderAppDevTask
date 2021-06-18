package com.example.spiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

import java.util.PrimitiveIterator;

public class quiz extends AppCompatActivity {
    private EditText editText6;
    private EditText editText7;
    private TextView textView;
    Vibrator vibrator;
    View view;
    private Button button;
    private int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        button=findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nand();
                a=0;
                editText6=findViewById(R.id.editTextNumberDecimal);
                editText7=findViewById(R.id.editTextNumberDecimal2);

                if((editText7.length()==0)||(editText6.length()==0))
                {
                    if(editText6.length()==0)
                    {
                        editText6.setError("Empty Field");
                    }
                    if(editText7.length()==0)
                    {
                        editText7.setError("Empty Field");
                    }
                    if((editText6.length()==0)&&(editText7.length()==0))
                    {
                        editText6.setError("Empty Field");
                        editText7.setError("Empty Field");
                    }
                }
                if((editText7.length()!=0)&&(editText6.length()!=0)){
                    String str=editText6.getText().toString();
                    String str1=editText7.getText().toString();


                    double nn=Double.parseDouble(str);
                    if(nn>300000000.0)
                    {
                        Toast.makeText(quiz.this, "Velocity cannot be greater than that of light", Toast.LENGTH_SHORT).show();
                        a++;
                    }


                if(a==0)
                {
                    double k=Double.parseDouble(str);

                    double f=(1.0)-((k*k)/(90000000000000000.0));
                    double j=Math.pow(f,0.5);
                    double r=1/(j);
                    double m=(double)(Math.round(r*100))/100;
                    String str5=Double.toString(m);
                    textView=findViewById(R.id.textView13);
                    if(str5.equalsIgnoreCase(str1))
                    {
                        textView.setText("CORRECT ANSWER");
                        green();
                    }
                    else
                    {
                        vibrator.vibrate(500);

                        textView.setText("INCORRECT ANSWER THE CORRECT ANSWER IS "+str5);
                        red();
                    }





                }
            }}
        });

    }
    public void green() {
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.green);
    }

    public void red() {
        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.red);
    }
    public void nand(){
        view=this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.blue);
    }
}