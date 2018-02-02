package com.ensg.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestVertice {
	private Vertice<String> v1 ;
	private Vertice<Integer> v2 ;

	@Before
	public void setUp() throws Exception {
		v1  =new Vertice<String>("v1");
		v1.setId(1);
		v2 =new Vertice<Integer>(5);
		v2.setId(2);
		
	}

	@Test
	public void testGetType() {
		
		assertEquals(v1.getType(),"v1");  
		assertEquals(v2.getType(),5,0.0);  
		
	}  

	
	@Test
	public void testGetId() {   
		
		assertEquals( 1,v1.getId());
		assertEquals( 2,v2.getId());
		
	}
	@Test
	public void testEquals() {
		Vertice<String> v3 = new Vertice<String>("v1");
		assertFalse(v1.equals(new Object()));
		assertTrue(v1.equals(v1));
		assertFalse(v1.equals(v2));
		assertTrue(v1.equals(v3));
		
	}

}
