package com.nice.test;


import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Date;
import java.util.UUID;

public class Test {

    @org.junit.Test
    public void test(){
        System.out.println(new Md5Hash("nice","50e14341-9fe1-4448-9627-5ea27b0e2408"));
    }
}
