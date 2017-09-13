package com.game.util;

/**
 * Created by xiayifan on 2017/9/10.
 */
 public class SqlCreator {
    public static String CreateSearchSql(int type,int platform,int net,int time,int page){
            String sql = "Select * from gameinfo where 1 ";
            if(type!=0){ sql = sql + "and type_id=" + type+" ";}
            if(platform!=0){
                String s_platform = changePlatNum2String(platform);
                sql = sql + "and platform=" + s_platform+" ";
            }
            if(net!=0) sql = sql + "and g_connection=" + (net-1)+" ";
            if(time!=0) sql = sql + "and game_date>='" + (time+2010)+"-01-01' and game_date<='"+ (time+2010)+"-12-31' ";
            sql = sql+" limit " +page+",3";
            return sql;
    }

    public static String changePlatNum2String(int plat){
        switch (plat){
            case 1:
                return "'PS4'";

            case 2:
                return "'xbox'";
            case 3:
                return "'PC'";
            case 4:
                return "'Nintento Switch'";
            case 5:
                return "'Mobile'";
            default:
                return "";

        }
    }

 }
