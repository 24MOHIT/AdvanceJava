package com.rays.Networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class URLReader {

	public static void main(String[] args) {
		
		URL u=null;
		
		try {
			u=new URL("https://www.raystec.com/tutorials.html");
		
			System.out.println("Protocol :"+u.getProtocol());
			System.out.println("HostName :"+u.getHost());
			System.out.println("Port Number :"+u.getPort());
			System.out.println("File Name :"+u.getFile());
			
			InputStream istr = u.openStream();
			
			Scanner in = new Scanner(istr);
			
			System.out.println("URL Contents...");
			
			while (in.hasNext()) {
				String html = in.next();
				System.out.println(html);
				
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
