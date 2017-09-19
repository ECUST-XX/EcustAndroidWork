package com.example.xx;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout{

    public TitleLayout(Context context, AttributeSet attrs){
          super(context, attrs);
          LayoutInflater.from(context).inflate(R.layout.title, this);
          
          
          Button btn_back = (Button)findViewById(R.id.title_back);
          Button btn_edit = (Button)findViewById(R.id.title_edit);

          btn_back.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) getContext()).finish();
                }
          });

          btn_edit.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                      Toast.makeText(getContext(), "It is an Edit button", Toast.LENGTH_SHORT).show();
                }
          });

    }
    
    
}

