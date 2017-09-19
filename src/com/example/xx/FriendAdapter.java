package com.example.xx;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendAdapter extends ArrayAdapter<User>{
	 private int resourceId;
	    public FriendAdapter(Context context, int textViewResourceId, List<User> objects){
	          super(context, textViewResourceId, objects);
	          resourceId = textViewResourceId;
	    }
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent){
	          User user=getItem(position); //获取当前项的user实例；
	          View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
	          ImageView user_image = (ImageView)view.findViewById(R.id.letter_image);
	          TextView user_name = (TextView)view.findViewById(R.id.letter_name);
	          
	          try{
	        	  
	        	  String url = user.getImage();
	        	  if(!url.equals("")){
	        		  int image= R.drawable.class.getDeclaredField(url).getInt(R.drawable.class);
			          user_image.setImageResource(image);
	        	  } else {
	        		  user_image.setImageResource(R.drawable.noname);
	        	  }
		         
		          
		          
	          } catch(Exception e) {
	        	  e.printStackTrace();
	          }
	        
	          user_name.setText(user.getName());
	          return view;
	    }
}
