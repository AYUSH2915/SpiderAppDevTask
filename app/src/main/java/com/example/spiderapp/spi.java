package com.example.spiderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Math.*;

public class spi extends AppCompatActivity {
    private TextView textView10;
    private EditText editText;
    private Button button5;
    private TextView textview16;
    private TextView textview17;
    private int x=0;
    private int fac=1;
    private int a1;
    private int a2;
    private int a3;
    private int a7;
    private int a8;
    private int a9;
    private int fac1=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spi);
        content();

        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=0;
                fac=1;
                editText=findViewById(R.id.editTextTime2);
                if(editText.length()==0)
                {
                    editText.setError("Field Empty");
                }
                if(editText.length()!=0){
                String str2=editText.getText().toString();
                if(str2.length()!=8)
                {
                    Toast.makeText(spi.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    x++;
                }
                else
                {
                    String st1=str2.substring(0,2);
                    String st2=str2.substring(3,5);
                    String st3=str2.substring(6);
                    a1=Integer.parseInt(st1);
                    a2=Integer.parseInt(st2);
                    a3=Integer.parseInt(st3);
                }
                if((str2.charAt(2)!=':')||(str2.charAt(5) !=':')||(a1>12)||(a2>60)||(a3>60))
                {
                    x++;
                    Toast.makeText(spi.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                if(x==0)
                {
                    textView10=findViewById(R.id.textView10);
                    for(int i=1;i<=a1;i++)
                    {
                        fac=fac*i;
                    }
                    double a4=Math.pow(a2,3);
                    double a5=(fac)/(a4+a3);
                    DecimalFormat dc1=new DecimalFormat("#############.###############");
                    String str10=dc1.format(a5);
                    textView10.setText("Custom Spi Factor Value = "+str10);

                }

            }}
        });

    }
    public void content()
    {
        fac1=1;
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss a");
        String time=simpleDateFormat.format(calendar.getTime());
        String st7=time.substring(0,2);
        String st8=time.substring(3,5);
        String st9=time.substring(6,8);
        a7=Integer.parseInt(st7);
        a8=Integer.parseInt(st8);
        a9=Integer.parseInt(st9);


            textview16=findViewById(R.id.textView16);
            textview17=findViewById(R.id.textView17);
            for(int o=1;o<=a7;o++)
            {
                fac1=fac1*o;
            }
            double a10=Math.pow(a8,3);
            double a11=(fac1)/(a10+a9);
            DecimalFormat dc=new DecimalFormat("#############.###############");
            String str9=dc.format(a11);
            textview16.setText("Current Time = "+time);
            textview17.setText("Current Spi Factor Value = "+str9);
            refresh(1000);
    }
    public void refresh(int milliseconds)
    {
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
        handler.postDelayed(runnable,milliseconds);

    }

}