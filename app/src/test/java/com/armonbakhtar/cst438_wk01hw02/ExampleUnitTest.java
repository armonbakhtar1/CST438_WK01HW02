package com.armonbakhtar.cst438_wk01hw02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class ExampleUnitTest {

    ArrayList<Users> userTest = new ArrayList<>();

    @Before
    public void test(){
        userTest.add(new Users("admin", "admin", 123));
    }

    @Test
    public void verifyUser(){
        assertNotNull(MainActivity.verifyUser("admin", userTest));
        assertNull(MainActivity.verifyUser("stewart", userTest));
    }

    @Test
    public void verifyPass(){
        assertTrue(MainActivity.verifyPass("admin", userTest.get(0)));
        assertFalse(MainActivity.verifyPass("yerr", userTest.get(0)));
    }
}