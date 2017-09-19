package com.example.xx;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

	public static final String CREATE_USER = "CREATE TABLE USER (ID INTEGER PRIMARY KEY autoincrement, NAME TEXT NOT NULL, PASSWORD TEXT NOT NULL, FRIEND TEXT NOT NULL, MODEL INTEGER NOT NULL, IMAGE TEXT NOT NULL);";
	public static final String CHECK = "SELECT COUNT(*) as CNT FROM sqlite_master where type='table' and name='USER';";
	private Context myContext;
	
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		myContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_USER);
		Toast.makeText(myContext, "创建成功!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS USER;");
		onCreate(db);
	}

}
