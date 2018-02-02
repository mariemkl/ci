package com.ensg.graph;


public class SourceNotFoundException extends Exception {
	
	public  SourceNotFoundException(Vertice source) {
		System.out.println("le sommet "+source+" n'existe pas !");		
	}

}
