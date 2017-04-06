package com.example.administrator.xmlouttest2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity{
    private Intent intent;
    private Bundle bundle2;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        Bundle bundle2=this.getIntent().getExtras();
        String Answer=bundle2.getString("Answer");
        String sexText="";
        if(Answer.equals("in")){
            sexText="正确";
        }else{
            sexText="错误";
        }
        TextView tv1=(TextView)findViewById(R.id.text1);
        tv1.setText("你选择的答案是："+sexText);
        Button btn3_back=(Button)findViewById(R.id.button_back);
        btn3_back.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                OtherActivity.this.setResult(RESULT_OK,intent);
                OtherActivity.this.finish();
            }
        });
    }
}
