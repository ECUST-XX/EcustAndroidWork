package com.example.xx;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class FirstActivity extends Activity {

	private Button button1;
	private EditText editText1;
	private Button button2;
	private Button button3;
	private EditText editText2;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.first_main);
	        
	        editText1 = (EditText)findViewById(R.id.editText1);
	        button1 = (Button)findViewById(R.id.button1);
	        editText2 = (EditText)findViewById(R.id.editText2);
	        button2 = (Button)findViewById(R.id.button2);
	        button3 = (Button)findViewById(R.id.button3);
	      	        
	       
	        /*
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.first_main);
            Intent intent = getIntent();        //»ñµÃIntent;
            String data = intent.getStringExtra("extra_data");
            Log.d("FirstActivity", data);
            */

	 }
	 
	 
	 public void onClickLoginListener1(View v){
		 String  name = editText1.getText().toString();
		 String  password = editText2.getText().toString();
		 
		 SecondActivity secondActivity = new SecondActivity();
		 
		 if(secondActivity.login(this,name, password, 1)==1){
			 Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
             intent.putExtra("name", name);
             intent.putExtra("password", password);
             startActivity(intent);
	        }else{
	        	Toast.makeText(FirstActivity.this, name+"µÇÂ½Ê§°Ü!", Toast.LENGTH_SHORT).show();
	        }
	 }
	 
	 public void onClickLoginListener2(View v){
		 String  name = editText1.getText().toString();
		 String  password = editText2.getText().toString();
		 
		 if(name.equals("admin")&&password.equals("admin")){
			 Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
             intent.putExtra("name", name);
             intent.putExtra("password", password);
             startActivity(intent);
	        }else{
	        	Toast.makeText(FirstActivity.this, name+"¹ÜÀíÔ±µÇÂ½Ê§°Ü!", Toast.LENGTH_SHORT).show();
	        }
	 }
	 
	 public void onClickLoginListener3(View v){
		
			 Intent intent = new Intent(FirstActivity.this,RegisterActivity.class);
             startActivity(intent);
     }
	       
        

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
