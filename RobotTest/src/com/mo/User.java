package com.mo;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
public class User extends Thread {

		 public static void main(String[] args) throws AWTException,   
		 InterruptedException, IOException
	        {			
	            Robot robot = new Robot();	            
	                          
	            Thread thread = new Thread();	            
	            for (int i = 0; i <1000000000000L; i++) {
	            	 thread.sleep(3000);
	            	 robot.mouseMove(500, 500);
	            	 thread.sleep(2000);
	            	 robot.mouseMove(200, 200);
				}
				
	            

	           

	        }
		
		
	}


