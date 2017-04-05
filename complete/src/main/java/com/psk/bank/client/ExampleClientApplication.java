package com.psk.bank.client;

public class ExampleClientApplication {

	public static void main(String[] args) {
		ExampleClient exampleClient = new ExampleClient("http://localhost:8080/");
		System.out.println(exampleClient.deleteMethodExample("1").getStatusCodeValue());
		System.out.println(exampleClient.postMethodExample("1","Adrian").getBody().getName());
		System.out.println(exampleClient.getMethodExample("2").getBody().getName());
	}
}
