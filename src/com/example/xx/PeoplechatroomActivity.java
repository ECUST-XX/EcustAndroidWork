package com.example.xx;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class PeoplechatroomActivity extends Activity {
	private ListView listView;
	private Button button1;
	private EditText editText1;
	private List<Msg>msgList = new ArrayList<Msg>();
	private String name;
	private String name2;
	private int uid1;
	private int uid2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chatroom);
        
        Intent intent = getIntent();        //获得Intent;
        name = intent.getStringExtra("name");
        name2 = intent.getStringExtra("name2");
        User user = new User(this);
        uid1 = user.findByName(name).getId(); 
        uid2 = user.findByName(name2).getId();
        
        editText1 = (EditText)findViewById(R.id.input_text);
        button1 = (Button)findViewById(R.id.send);
        
        this.initMsg();
        
        this.initAdapter();
        
    }
    
    public void initAdapter(){
    	MsgAdapter adapter = new MsgAdapter(PeoplechatroomActivity.this, R.layout.chat, msgList);
        ListView listview = (ListView)findViewById(R.id.msg_list_view);
        listview.setAdapter(adapter);
    	
    }
    
    private void initMsg(){  //初始化几条数据用于在ListView中显示。
    	Chat chat = new Chat(this);
    	Cursor cursor = chat.getAllMsg(name, uid1);
    	
    	int num = cursor.getCount();
    	
    	for(int i = 0;i < num;i++){
			if(cursor.moveToNext()){
				 int send=cursor.getInt(cursor.getColumnIndex("SEND"));
				 int recive=cursor.getInt(cursor.getColumnIndex("RECIVE"));
				 String msg =cursor.getString(cursor.getColumnIndex("CONTEXT"));  
				 if(send == uid1 && recive == uid2){
					 Msg msg0 = new Msg(msg, Msg.TYPE_SENT);
			         msgList.add(msg0);
				 }
				 if(send == uid2 && recive == uid1){
					 Msg msg0 = new Msg(msg, Msg.TYPE_RECEIVED);
			         msgList.add(msg0);
				 }

			}
		}
    	
    }

    public void onClickChatroomListener1(View v)
    {
    	 String  sendMsg = editText1.getText().toString();
    	 
		 Msg msg1 = new Msg(sendMsg, Msg.TYPE_SENT);
         msgList.add(msg1);
             
         Chat chat = new Chat(this);
     	 chat.addMsg(name,uid1,uid2,sendMsg);
     	 chat.addMsg(name2,uid1,uid2,sendMsg);
     	 
         this.initAdapter();
         
         editText1.setText("");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
