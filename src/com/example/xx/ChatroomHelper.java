package com.example.xx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;

public class ChatroomHelper extends SQLiteOpenHelper{

	public  String CREATE_USER1 = "CREATE TABLE ";
	public  String CREATE_USER2 = " (ID INTEGER PRIMARY KEY autoincrement, SEND INTEGER NOT NULL, RECIVE INTEGER NOT NULL, CONTEXT TEXT NOT NULL);";
	public String name;
	public  String CREATE_USER;
	private Context myContext;
	public ChatroomHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		myContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		if(name == null){
			CREATE_USER = CREATE_USER1 + "noname" + CREATE_USER2;
		}else{
			System.out.println("name:p------"+name);
		}
		System.out.println(CREATE_USER);
		db.execSQL("DROP TABLE IF EXISTS noname;");
		db.execSQL(CREATE_USER);
	//	Toast.makeText(myContext, "创建成功!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS noname;");
		onCreate(db);
	}

	public void setName(String name) {
		CREATE_USER = CREATE_USER1 + name + CREATE_USER2;
		System.out.println("name:ppppppsdsdsd"+name);
	}

}
