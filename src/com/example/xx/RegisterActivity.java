package com.example.xx;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends Activity{

	private Button button;
	private EditText editText1;
	private EditText editText2;
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	private ImageButton imageButton3;
	private String image;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.register);
	        
	        editText1 = (EditText)findViewById(R.id.editText1);
	        button = (Button)findViewById(R.id.button);
	        editText2 = (EditText)findViewById(R.id.editText2);
	        imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
	        imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
	        imageButton3 = (ImageButton)findViewById(R.id.imageButton3);

	 }
	 
	 
	 public void onClickLoginListener(View v){
		 String  name = editText1.getText().toString();
		 String  password = editText2.getText().toString();
		 
		 User user = new User(this,name,password,"",image,1);
		 if (user.findByName(name) == null){
			 user.createUser();
			 
			 Chat chat = new Chat(this);
		     chat.createTable(name);
			 
		     Toast.makeText(RegisterActivity.this, name+"注册成功!", Toast.LENGTH_SHORT).show();
		 } else {
		     Toast.makeText(RegisterActivity.this, name+"注册失败!用户已存在", Toast.LENGTH_SHORT).show();
		 }
		
	 }
	 
	 
	 public void onClickImageListener3(View v){
		 this.image = "noname";
	     Toast.makeText(RegisterActivity.this, "使用 noname 作为头像", Toast.LENGTH_SHORT).show();
	 }
	 public void onClickImageListener2(View v){
		 this.image = "lyq";
	     Toast.makeText(RegisterActivity.this, "使用 lyq 作为头像", Toast.LENGTH_SHORT).show();

	 }
	 public void onClickImageListener1(View v){
		 this.image = "qq";
	     Toast.makeText(RegisterActivity.this, "使用 qq 作为头像", Toast.LENGTH_SHORT).show();

	 }
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
