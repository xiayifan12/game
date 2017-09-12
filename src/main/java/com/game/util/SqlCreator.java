package com.game.util;

/**
 * Created by xiayifan on 2017/9/10.
 */
 public class SqlCreator {
    public static String CreateSearchSql(int type,int platform,int net,int time,int page){
            String sql = "Select * from gameinfo where 1 ";
            if(type!=0) sql = sql + "and type=" + type+" ";
            if(platform!=0) sql = sql + "and platform=" + platform+" ";
            if(net!=0) sql = sql + "and net=" + net+" ";
            if(time!=0) sql = sql + "and time=" + time+" ";
            sql = sql+" limit " +page+",3";
            return sql;
    }

 }
