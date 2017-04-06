package com.example.administrator.xmlouttest2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity{
    RadioButton rb1=null;
    RadioButton rb2=null;
    RadioButton rb3=null;
    RadioButton rb4=null;
    RadioGroup radioGroup=null;
    RadioButton CurrentRadioButton=null;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rb1=(RadioButton)findViewById(R.id.a);
        rb2=(RadioButton)findViewById(R.id.b);
        rb3=(RadioButton)findViewById(R.id.c);
        rb4=(RadioButton)findViewById(R.id.d);
        rb1.setClickable(true);
        //radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button Btn1_sure=(Button)findViewById(R.id.sure);
        Button Btn2_cancel=(Button)findViewById(R.id.cancel);
        Btn1_sure.setOnClickListener(new Btn1_sure());
        Btn2_cancel.setOnClickListener(new Btn2_cancel());
    }
    class Btn1_sure implements OnClickListener{
        public void onClick(View v){
            String Answer="";
            if(rb1.isChecked()){
                Answer="on";
            }
            else if(rb2.isChecked()){
                Answer="at";
            }
            else if(rb3.isChecked()){
                Answer="of";
            }
            else if(rb4.isChecked()) {
                Answer = "in";
            }
            Intent intent=new Intent();
            intent.setClass(MainActivity.this,OtherActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("Answer",Answer);
            intent.putExtras(bundle);
            MainActivity.this.startActivity(intent);
        }
    }
    class Btn2_cancel implements OnClickListener{
        public void onClick(View v){
            radioGroup.clearCheck();
            setTitle("");
        }
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case RESULT_OK:
                Bundle bundle2 = data.getExtras();
                String answer = bundle2.getString("ans");
                break;
            default:
                break;
        }
    }
}


