package com.game.util;

import org.junit.Test;

/**
 * Created by xiayifan on 2017/9/10.
 */

public class sqlCreatorTest {
    @Test
    public void printSQL(){
        System.out.print(SqlCreator.CreateSearchSql(0,0,0,0,0));
    }
}
