package com.example.xx;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Chat{
	
	private ChatroomHelper chatdbhelper;
	
	public Chat(Context context){  
        this.chatdbhelper=new ChatroomHelper(context,"CHAT.db", null, 2);  
    }  
	
	public void createTable(String name){
		 
		try{
			SQLiteDatabase db = chatdbhelper.getWritableDatabase();
			db.execSQL("CREATE TABLE "+name+" (ID INTEGER PRIMARY KEY autoincrement, SEND TEXT NOT NULL, RECIVE TEXT NOT NULL, CONTEXT TEXT NOT NULL);");

		}catch(Exception e){
			e.printStackTrace();
		}	  
	}
	
	public void isSetTable(String name){
			
			try{
				SQLiteDatabase db = chatdbhelper.getWritableDatabase();
				//db.rawQuery(sql);
				
			}catch(Exception e){		
				e.printStackTrace();
			}	  
		}
	public Cursor getAllMsg(String name,int uid1){
		SQLiteDatabase db = chatdbhelper.getWritableDatabase(); 
		Cursor cursor = db.rawQuery("select * from "+name+" where SEND=? OR RECIVE=?", new String[]{""+uid1,""+uid1});  
		
		return cursor;
		
	}
	
	public void addMsg(String name,int send,int recive,String msg) {
		SQLiteDatabase db = chatdbhelper.getWritableDatabase();
		try{
			db.execSQL("insert into "+name+"(SEND,RECIVE,CONTEXT) values("+send+","+recive+",\""+msg+"\");");
		}catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		
	}
	
}
