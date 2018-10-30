package org.lxp.springboot.asm;

/**
 * Created by linxiaopeng on 2018-7-23.
 */
public class AsmTestBean {

    private int ratelimite;
    private int times;

    AsmTestBean(){
        ratelimite = 3000;
        times =1;
    }

    public void showlimit(){
        System.out.println("ratelimite = " + ratelimite);
    }
}
