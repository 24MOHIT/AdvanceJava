package com.rays.Test;

import java.util.ResourceBundle;

public class TestBundle {

	public static void main(String[] args) {
		
		ResourceBundle rb=ResourceBundle.getBundle("com.rays.Bundle.system");
		
		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
	}
}
