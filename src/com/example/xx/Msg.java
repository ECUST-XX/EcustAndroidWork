package com.example.xx;

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    public String content;
    public int type;

    public Msg(String content, int type){
    this.content = content;
    this.type = type;
    }

    public String getContent(){
          return content;  //表示消息的内容。
    }

    public int getType(){
          return type; //表示消息的类型，包括两个可选值：TYPE_RECEIVED, TYPE_SENT。 
    }

}
