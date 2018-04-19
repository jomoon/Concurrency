package com.hjj.future;

public class Main {
	public static void main(String[] args) {
		FutureClient fc = new FutureClient();
		Data data = fc.request("param");
		System.out.println("push param success");
		System.out.println("do something");
		
		String result = data.getRequest();
		System.out.println(result);
	}
}
