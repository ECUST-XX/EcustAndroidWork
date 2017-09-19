package com.example.xx;

public class Letter {
    private String letter_name;
    private int image_id;

    public Letter(String letter_name, int image_id){
          this.letter_name = letter_name;
          this.image_id = image_id;
    }

    public String getLetterName(){
          return letter_name;
    }

    public int getImageId(){
    	
          return image_id ;
    }
}
