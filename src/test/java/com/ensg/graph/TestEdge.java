package com.ensg.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEdge {
    private Edge e1 ;
    private Edge e2 ;
   
    
    
	@Before
	public void setUp() throws Exception {
		e1 = new Edge( new Vertice<String>("v1"), new Vertice<Integer>(3));
		e2 = new Edge( new Vertice<String>("v2"), new Vertice<Integer>(0));
		
	}

	


	@Test
	public void testGetSource() {

	Vertice<String> v1 = new Vertice<String>("v1");
	assertTrue(v1.equals(e1.getSource()));  
	}

	@Test 
	public void testSetSource() {
		Vertice<Double> v1 = new Vertice<Double>(0.0) ;
		e1.setSource(v1);
		assertTrue(v1.equals(e1.getSource()));
	}

	@Test
	public void testGetDestination() {
		Vertice<Integer> v1 = new Vertice<Integer>(3);
		assertTrue(v1.equals(e1.getDestination()));  	
		
	}

	@Test
	public void testSetDestination() {
		Vertice<Double> v1 = new Vertice<Double>(0.0) ;
		e1.setDestination(v1);
		assertTrue(v1.equals(e1.getDestination()));	
		}

}
