package com.example.xx;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LetterAdapter extends ArrayAdapter<Letter>{
    private int resourceId;
    public LetterAdapter(Context context, int textViewResourceId, List<Letter> objects){
          super(context, textViewResourceId, objects);
          resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
          Letter letter=getItem(position); //获取当前项的letter实例；
          View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
          ImageView letter_image = (ImageView)view.findViewById(R.id.letter_image);
          TextView letter_name = (TextView)view.findViewById(R.id.letter_name);
          letter_image.setImageResource(letter.getImageId());
          letter_name.setText(letter.getLetterName());
          return view;
    }
}

