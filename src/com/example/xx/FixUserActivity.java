package com.example.xx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class FixUserActivity extends Activity{

	private Button button;
	private EditText editText1;
	private EditText editText2;
	private String image;
	private EditText editText3;

	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.fixuser);
	        
	        editText1 = (EditText)findViewById(R.id.editText1);
	        button = (Button)findViewById(R.id.button);
	        editText2 = (EditText)findViewById(R.id.editText2);
	        editText3 = (EditText)findViewById(R.id.editText3);
	        
	        Intent intent = getIntent();        //获得Intent;
	        String name = intent.getStringExtra("name");
	        User user = new User(this).findByName(name);
	        editText1.setText(name);
	        editText3.setText(user.getFriend());
	 }
	 
	 
	 public void onClickLoginListener(View v){
		 String  name = editText1.getText().toString();
		 String  password = editText2.getText().toString();
		 String  friend = editText3.getText().toString();
		 
		 User user = new User(this);
		
		 if (user.findByName(name) == null){
			
		     Toast.makeText(this, name+"修改失败!用户不存在!", Toast.LENGTH_SHORT).show();
		 } else {
			 int id = user.findByName(name).getId();
			 user = new User(this,name,password,friend,user.getImage(),1);
			 user.updataUser(id);
		     Toast.makeText(this, name+"修改成功!", Toast.LENGTH_SHORT).show();
		 }
		
	 }
	 
	 
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
