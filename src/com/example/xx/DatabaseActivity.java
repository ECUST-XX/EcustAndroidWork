package com.example.xx;

import java.math.BigInteger;
import java.security.MessageDigest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class DatabaseActivity extends Activity {
	
	private DatabaseHelper dbhelper;
	private ChatroomHelper chatdbhelper;
	private  Button create_db;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.database);
	        
	       create_db = (Button) findViewById(R.id.create_db);
		   dbhelper = new DatabaseHelper(this, "USER.db", null, 2);
		   chatdbhelper = new ChatroomHelper(this,"CHAT.db",null,2);
	      
	    }
	    
	public void onClickDatabaseListener(View v){
		try{
			
			SQLiteDatabase db = dbhelper.getWritableDatabase();
			dbhelper.onCreate(db);
			
		}catch(Exception e){
			Toast.makeText(DatabaseActivity.this, "error!"+e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		try{
			SQLiteDatabase db2 = chatdbhelper.getWritableDatabase();
			db2.execSQL("CREATE TABLE "+"xx"+" (ID INTEGER PRIMARY KEY autoincrement, SEND TEXT NOT NULL, RECIVE TEXT NOT NULL, CONTEXT TEXT NOT NULL);");
			db2.execSQL("CREATE TABLE "+"wxy"+" (ID INTEGER PRIMARY KEY autoincrement, SEND TEXT NOT NULL, RECIVE TEXT NOT NULL, CONTEXT TEXT NOT NULL);");
			db2.execSQL("CREATE TABLE "+"yhc"+" (ID INTEGER PRIMARY KEY autoincrement, SEND TEXT NOT NULL, RECIVE TEXT NOT NULL, CONTEXT TEXT NOT NULL);");
			db2.execSQL("CREATE TABLE "+"ylb"+" (ID INTEGER PRIMARY KEY autoincrement, SEND TEXT NOT NULL, RECIVE TEXT NOT NULL, CONTEXT TEXT NOT NULL);");

		}catch(Exception e){
			e.printStackTrace();
		}	
		
		User admin = new User(this,"admin","admin","0","admin",0);
		admin.createUser();

		User user = new User(this,"xx","xx","3,4,5","xx");
		user.createUser();
		user.setUser("yhc","yhc","2,4,5","yhc",1);
		user.createUser();
		user.setUser("wxy","wxy","2,3,5","wxy",1);
		user.createUser();
		user.setUser("ylb","ylb","2,3,4","ylb",1);
		user.createUser();
		
		Toast.makeText(DatabaseActivity.this, "创建成功", Toast.LENGTH_LONG).show();

	}
	
	public void onClickDatabaseListener2(View v){
		
		try{
			SQLiteDatabase db = dbhelper.getWritableDatabase();
			db.execSQL("DROP TABLE IF EXISTS USER;");
			}catch(Exception e){
			e.printStackTrace();
		}
		
		
		try{
			SQLiteDatabase db2 = chatdbhelper.getWritableDatabase();
			db2.execSQL("DROP TABLE IF EXISTS xx;");
			db2.execSQL("DROP TABLE IF EXISTS wxy;");
			db2.execSQL("DROP TABLE IF EXISTS yhc;");
			db2.execSQL("DROP TABLE IF EXISTS ylb;");
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		Toast.makeText(DatabaseActivity.this, "删除成功", Toast.LENGTH_LONG).show();

	}

	
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
}
