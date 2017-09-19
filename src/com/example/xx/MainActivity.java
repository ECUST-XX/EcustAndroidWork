package com.example.xx;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	private Button button;
	private EditText editText;
	private ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
       
        editText = (EditText)findViewById(R.id.editText1);
        progressbar = (ProgressBar)findViewById(R.id.seekBar1);
        button = (Button)findViewById(R.id.button1);
        
        
        button.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v){
        		
//        		Intent intent = new Intent(MainActivity.this,FirstActivity.class);
//        		startActivity(intent);

        		//Intent intent = new Intent(Intent.ACTION_VIEW);	
        		//startActivity(intent);
        		
                String data = "Hello SecondActivity";
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);


        		
        		/*
        		int progress = progressbar.getProgress();
                progressbar.setProgress(progress+10);
//        		Toast.makeText(MainActivity.this,"this is a button!", Toast.LENGTH_SHORT).show();
                
                String  inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                setContentView(R.layout.first_main);
                */
               // FirstActivity first = new FirstActivity();
                //setContentView(first.join("asd", "as"));

//                AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
//                alertdialog.setTitle("This is an AlertDialog!");
//                alertdialog.setMessage("Something Important!");
//                alertdialog.setCancelable(false);
//                alertdialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                      public void onClick(DialogInterface alertdialog, int which) {}
//                });
//                alertdialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                      public void onClick(DialogInterface alertdialog, int which) {}
//                });
//                alertdialog.show();
//                
//                
//                ProgressDialog progressdialog = new ProgressDialog(MainActivity.this);
//                progressdialog.setTitle("Loading...fuck");
//                progressdialog.setCancelable(true);
//                progressdialog.show();


        	}
        });
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
