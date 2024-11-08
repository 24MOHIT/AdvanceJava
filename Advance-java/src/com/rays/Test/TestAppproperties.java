package com.rays.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestAppproperties {

	public static void main(String[] args) {
		
		ResourceBundle rb=ResourceBundle.getBundle("com.rays.bundle.app", new Locale("sp"));
		
		System.out.println("greeting="+rb.getString("greeting"));
	}
}
