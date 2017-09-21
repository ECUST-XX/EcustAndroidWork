package com.example.xx;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DelFriendActivity extends Activity{
	 private List<User> userlist = new ArrayList<User>();
	 private String name;
	 private Button button1;
	 private EditText editText1;
		
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
           setContentView(R.layout.friendlist);
           Intent intent = getIntent();        //获得Intent;
           name = intent.getStringExtra("name");
          
           TextView view1 = (TextView)findViewById(R.id.title_text);
           view1.setText(name+"的好友");
          
           editText1 = (EditText)findViewById(R.id.input_text);
           button1 = (Button)findViewById(R.id.send);
           
           initLetter();
           
           FriendAdapter adapter = new FriendAdapter(DelFriendActivity.this, R.layout.letter_item, userlist);
           ListView listview = (ListView)findViewById(R.id.list_view);
           listview.setAdapter(adapter);
           listview.setOnItemClickListener(new OnItemClickListener(){

               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     User user = userlist.get(position);
                     user.delUser(user.getId());
                     Toast.makeText(DelFriendActivity.this, user.getName()+"已经删除", Toast.LENGTH_SHORT).show();
                     
                     userlist.clear();
                     initLetter();
                     FriendAdapter adapter = new FriendAdapter(DelFriendActivity.this, R.layout.letter_item, userlist);
                     ListView listview = (ListView)findViewById(R.id.list_view);
                     listview.setAdapter(adapter);
               }
         });
           
           
  
	        
	 }

	 private void initLetter(){
			 User user = new User(this);
			 
			 String friends = user.findByName(name).getFriend();
			 if (friends.equals("")){
	             Toast.makeText(DelFriendActivity.this, "用户暂无好友！", Toast.LENGTH_SHORT).show();
			 }else{
				 String friendList[];
				 if(friends.equals("0")){
					 friends = user.getAllId(); 
				 }
				 
				 friendList = friends.split(",");
			 
			     for(String friend : friendList){
			    	 User u = new User(this);
			    	 u = u.findById(Integer.parseInt(friend));
			    	 userlist.add(u);
			     }
			 }
			 
	       
	  }

	
	public void onClickFriendListener(View v){
		 String  userName = editText1.getText().toString();
   	
		 User user = new User(this);
		 String oldFriends = user.findByName(name).getFriend();
		 User newFriend = new User(this);
		 newFriend = newFriend.findByName(userName);
		 
		 
			 
			 if(newFriend == null){
	             Toast.makeText(DelFriendActivity.this, "用户不存在！", Toast.LENGTH_SHORT).show();
			 }else{
				 
				 int newFriendId = newFriend.getId();
				
				 if(!oldFriends.equals("")){
					 
					 String[] friendList = oldFriends.split(",");
					 int flag = 0;
					 for(String friendId : friendList){
				    	if(friendId.equals(newFriendId+"")){
				             Toast.makeText(DelFriendActivity.this, "用户已经是好友！", Toast.LENGTH_SHORT).show();
				             flag = 1;
				    		 break;
				    	}
				     }
					 oldFriends = flag == 1 ? oldFriends : (oldFriends += ","+newFriendId);

				 }else{
					 oldFriends = ""+newFriendId;
				 }
				
			 System.out.println(oldFriends);
			 user.addFriend(user.getId(), oldFriends);
            Toast.makeText(DelFriendActivity.this, "好友添加成功！", Toast.LENGTH_SHORT).show();
            //刷新
            userlist = new ArrayList<User>();
            initLetter();
            FriendAdapter adapter = new FriendAdapter(DelFriendActivity.this, R.layout.letter_item, userlist);
            ListView listview = (ListView)findViewById(R.id.list_view);
            listview.setAdapter(adapter);
			 }
		
        
	}
      
 
  


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
  }
}
