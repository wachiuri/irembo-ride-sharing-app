/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.irembo.ride.driver.websocket;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Timothy Wachiuri
 */
public class WebsocketMessageTest {
    
    public WebsocketMessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSource method, of class WebsocketMessage.
     */
    @Test
    public void testGetSource() {
        System.out.println("getSource");
        WebsocketMessage instance = new WebsocketMessage();
        String expResult = "";
        String result = instance.getSource();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getData method, of class WebsocketMessage.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        WebsocketMessage instance = new WebsocketMessage();
        Object expResult = null;
        Object result = instance.getData();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of setSource method, of class WebsocketMessage.
     */
    @Test
    public void testSetSource() {
        System.out.println("setSource");
        String source = "";
        WebsocketMessage instance = new WebsocketMessage();
        instance.setSource(source);
        
        
    }

    /**
     * Test of setData method, of class WebsocketMessage.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        Object data = null;
        WebsocketMessage instance = new WebsocketMessage();
        instance.setData(data);
        
        
    }

    /**
     * Test of equals method, of class WebsocketMessage.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        WebsocketMessage instance = new WebsocketMessage();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of canEqual method, of class WebsocketMessage.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        WebsocketMessage instance = new WebsocketMessage();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of hashCode method, of class WebsocketMessage.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        WebsocketMessage instance = new WebsocketMessage();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of toString method, of class WebsocketMessage.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WebsocketMessage instance = new WebsocketMessage();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        
    }
    
}
