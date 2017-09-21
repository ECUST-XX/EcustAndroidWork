package com.example.xx;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;

public class SecondActivity extends Activity {

	 private List<Letter> letterlist = new ArrayList<Letter>();
	 private String name;
	 int model;
	    
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.second_main);
            Intent intent = getIntent();        //���Intent;
            name = intent.getStringExtra("name");
            String password = intent.getStringExtra("password");
            
            TextView view1 = (TextView)findViewById(R.id.title_text);
             view1.setText(name+"��½�ɹ�");
            
             if(!name.equals("admin")){
            	 User user = new User(this);
                 model = user.findByName(name).getModel();
             }
             
             
             initLetter();
             
             LetterAdapter adapter = new LetterAdapter(SecondActivity.this, R.layout.letter_item, letterlist);
             ListView listview = (ListView)findViewById(R.id.list_view);
             
             listview.setAdapter(adapter);
             listview.setOnItemClickListener(new OnItemClickListener(){

                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       Letter letter = letterlist.get(position);
                       Toast.makeText(SecondActivity.this, letter.getLetterName(), Toast.LENGTH_SHORT).show();
                       if (letter.getLetterName().equals("������")) {
                    	   Intent intent = new Intent(SecondActivity.this,CalculatorMain.class);
                           startActivity(intent);
                       }
                       if (letter.getLetterName().equals("���칤��")) {
                    	   Intent intent = new Intent(SecondActivity.this,ChatroomActivity.class);
                           startActivity(intent);
                       }
                       if (letter.getLetterName().equals("���ݿ�����")) {
                    	   Intent intent = new Intent(SecondActivity.this,DatabaseActivity.class);
                           startActivity(intent);
                       }
                       if (letter.getLetterName().equals("�����б�")) {
                    	   Intent intent = new Intent(SecondActivity.this,FriendActivity.class);
                    	   intent.putExtra("name", name);
                           startActivity(intent);
                       }
                       if (letter.getLetterName().equals("�޸��û�")) {
                    	   Intent intent = new Intent(SecondActivity.this,FixFriendActivity.class);
                    	   intent.putExtra("name", name);
                           startActivity(intent);
                       }
                       if (letter.getLetterName().equals("ɾ���û�")) {
                    	   Intent intent = new Intent(SecondActivity.this,DelFriendActivity.class);
                    	   intent.putExtra("name", name);
                           startActivity(intent);
                       }
                 }
           });
               
	 }

	 private void initLetter(){
	        Letter a = new Letter("������", R.drawable.calc);  
	        letterlist.add(a);
	        
	        Letter b = new Letter("���칤��", R.drawable.qq);  
	        letterlist.add(b);
	        
	        Letter d = new Letter("�����б�", R.drawable.friendlist);  
	        letterlist.add(d);
	        
	        if(model == 0){
	        	Letter c = new Letter("���ݿ�����", R.drawable.database);  
		        letterlist.add(c);
		        
		        Letter e = new Letter("�޸��û�", R.drawable.hyl);  
		        letterlist.add(e);
		        
		        Letter f = new Letter("ɾ���û�", R.drawable.qxx);  
		        letterlist.add(f);
            }
	        
	        
	        
	        
	        
	  }

		public int login(Context context,String name, String password ,int model){
			
			User user = new User(context);
			System.out.println(password);
			
			password = User.getMD5(password);
			
			System.out.println(password);
			
			if (user.findByName(name) == null) {
				return -1;
			}
			//��ͨ�û�1
			if (model == 1) {
				
				if(user.getName().equals(name) && user.getPassword().equals(password) && user.getModel() == 1) {
					return 1;
				} 
			} else {
				
				if(user.getName().equals(name) && user.getPassword().equals(password) && user.getModel() == 0) {
					return 0;
				}  
			}
			return -1;
			
		}
		
		public int join(String name, String password){
			
			return 1;
		}
	
        
		public String getMD5(String str) {
			 try {
			 // ����һ��MD5���ܼ���ժҪ
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 // ����md5����
			 md.update(str.getBytes());
			 // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
			 // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
			 return new BigInteger(1, md.digest()).toString(16);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			return str;
			}
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
