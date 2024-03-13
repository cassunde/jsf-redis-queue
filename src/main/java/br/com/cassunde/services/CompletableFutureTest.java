package br.com.cassunde.services;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {


	public static void main(String[] args) {
		
		System.out.println("Test");
		
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future = completableFuture.thenApply(s -> s + " World");
		
		
	}

}
