package com.example.xx;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class User {

	private String name;
	private String password;
	private String friend;
	private int model;
	private String image;
	private int id;
	
	private DatabaseHelper dbhelper;
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getFriend() {
		
		return friend;
	}

	public int getModel() {
		return model;
	}

	public String getImage() {
		
		return image;
	}

	public int getId() {
		return id;
	}

	public void setDbhelper(Context context) {
		this.dbhelper=new DatabaseHelper(context,"USER.db", null, 2); 
	}

	
	public User(Context context){  
        this.dbhelper=new DatabaseHelper(context,"USER.db", null, 2);  
    }  
	
	public User(Context context,String name,String password,String friend,String image,int model){
		this.setDbhelper(context);
		this.image = image;
		this.friend = friend;
		this.model = model;
		this.name = name;
		this.password = password;
	}
	
	public User(Context context,String name,String password,String friend,String image){
		this.setDbhelper(context);
		this.image = image;
		this.friend = friend;
		this.model =1;
		this.name = name;
		this.password = password;
	}
	
	public void createUser(){
		
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try{
			db.execSQL("insert into USER(NAME,PASSWORD,FRIEND,MODEL,IMAGE) values(\""+this.name.toString()+"\",\""+getMD5(this.password.toString())+"\",\""+this.friend.toString()+"\","+(int)this.model+",\""+this.image.toString()+"\");");
		}catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		
	}
	
	public void delUser(int id){
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try{
			db.execSQL("delete from USER where ID="+id+";");
		}catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		
	}
	
	public void updataUser(int id){
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try{
			db.execSQL("UPDATE USER SET NAME = \""+this.name.toString()+"\",PASSWORD = \""+getMD5(this.password.toString())+"\",FRIEND = \""+this.friend.toString()+"\",MODEL = "+(int)this.model+",IMAGE = \""+this.image.toString()+"\" where ID="+id+";");
		}catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		
	}
	
	public void setUser(String name,String password,String friend,String image,int model){
		this.image = image;
		this.friend = friend;
		this.model = model;
		this.name = name;
		this.password = password;
	}
	
	public User findByName(String name){
		
		SQLiteDatabase db = dbhelper.getWritableDatabase(); 
		Cursor cursor = db.rawQuery("select * from USER where NAME=?", new String[]{name});  
		if(cursor.moveToFirst()){  
            int id=cursor.getInt(cursor.getColumnIndex("ID"));  
            String username =cursor.getString(cursor.getColumnIndex("NAME"));  
            String password=cursor.getString(cursor.getColumnIndex("PASSWORD"));  
            String image=cursor.getString(cursor.getColumnIndex("IMAGE"));  
            String friend=cursor.getString(cursor.getColumnIndex("FRIEND"));  
            int model=cursor.getInt(cursor.getColumnIndex("MODEL")); 
            
            this.setId(id);
            this.setUser(username, password, friend, image, model);
            
            cursor.close(); 
            
            return this;
        }else {
        	return null;
        	}
	}
	
	public User  findById(int id){
		
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from USER where ID=?", new String[]{""+id});  
		if(cursor.moveToFirst()){  
            int userid=cursor.getInt(cursor.getColumnIndex("ID"));  
            String username =cursor.getString(cursor.getColumnIndex("NAME"));  
            String password=cursor.getString(cursor.getColumnIndex("PASSWORD"));  
            String image=cursor.getString(cursor.getColumnIndex("IMAGE"));  
            String friend=cursor.getString(cursor.getColumnIndex("FRIEND"));  
            int model=cursor.getInt(cursor.getColumnIndex("MODEL")); 
            
            this.setId(userid);
            this.setUser(username, password, friend, image, model);
            
            cursor.close(); 
            
            return this;
        }else {
        	return null;
        	}
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getAllId(){
		String ids = "";
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select ID from USER where MODEL=?",new String[]{""+1});  
		
		cursor.moveToFirst();
		
		int userid=cursor.getInt(cursor.getColumnIndex("ID")); 
		System.out.println(userid);
		
		ids += userid+",";
		int num = cursor.getCount();
		for(int i = 1;i < num;i++){
			if(cursor.moveToNext()){
				userid = cursor.getInt(cursor.getColumnIndex("ID"));
				ids += userid+",";
			}
		}
		
		ids = ids.substring(0,ids.length() - 1);
		System.out.println(ids);
		return ids;
	}

	public void addFriend(int id,String friends) {
		SQLiteDatabase db = dbhelper.getWritableDatabase();
		try{
			db.execSQL("UPDATE USER SET FRIEND = \""+friends+"\" WHERE ID = "+id+";");
		}catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		
	}
	
	public static String getMD5(String str) {
		 try {
		 // 生成一个MD5加密计算摘要
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 // 计算md5函数
		 md.update(str.getBytes());
		 // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
		 // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
		 return new BigInteger(1, md.digest()).toString(16);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		return str;
		}

}
