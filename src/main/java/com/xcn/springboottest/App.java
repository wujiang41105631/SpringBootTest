package com.xcn.springboottest;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		String tempString = "ABFGKWIGJWIOTIUQUEIOQIWEUQIW123123123123";
		for(int i = 0;i<10000000;i++){
			tempString.equalsIgnoreCase("ABFGKWIGJWIOTIUQUEIOQIWEUQIW123123123123");
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		for(int i = 0;i<10000000;i++){
			tempString.equals("ABFGKWIGJWIOTIUQUEIOQIWEUQIW123123123123");
		}
		System.out.println(System.currentTimeMillis()-t2);
	}
  
}
