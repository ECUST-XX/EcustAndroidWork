package com.example.xx;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatroomActivity extends Activity {

	private ListView listView;
	private Button button1;
	private EditText editText1;
	private List<Msg>msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chatroom);
        
        editText1 = (EditText)findViewById(R.id.input_text);
        button1 = (Button)findViewById(R.id.send);
        
        this.initMsg();
        
        this.initAdapter();
        
    }
    
    public void initAdapter(){
    	MsgAdapter adapter = new MsgAdapter(ChatroomActivity.this, R.layout.chat, msgList);
        ListView listview = (ListView)findViewById(R.id.msg_list_view);
        listview.setAdapter(adapter);
    	
    }
    
    
    private void initMsg(){  //初始化几条数据用于在ListView中显示。
        Msg msg1 = new Msg("你好，我是安卓机器人!", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("^_^!", Msg.TYPE_SENT);
        msgList.add(msg2);
    }

    public void onClickChatroomListener1(View v)
    {
    	 String  sendMsg = editText1.getText().toString();
    	 if (!sendMsg.equals("")) {
    		 Msg msg1 = new Msg(sendMsg, Msg.TYPE_SENT);
             msgList.add(msg1);
             
             Msg msg2 = new Msg(sendMsg+"======="+Math.random(), Msg.TYPE_RECEIVED);
             msgList.add(msg2);
    	 } else {
    		 Msg msg2 = new Msg("speak,please!", Msg.TYPE_RECEIVED);
             msgList.add(msg2);
    	 } 
        
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

