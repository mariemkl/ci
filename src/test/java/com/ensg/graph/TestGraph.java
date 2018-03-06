package com.ensg.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestGraph {

	AbstractGraph g1;
	Vertice<String> v1;
	Vertice<String> v2;
	Edge e1;

	@Before
	public void setUp() throws Exception {
		v1 = new Vertice<String>("v1");
		v2 = new Vertice<String>("v2");
		e1 = new Edge(v1, v2);
		g1 = new DirictedGraph();
	}

	@Test
	public void testaddVertice() {

		Vertice v = new Vertice<String>("v1");
		g1.addVertice(v);
		
		assertTrue(false);
		
		assertEquals(1, g1.getVerticesSize());

	}

	@Test
	public void testaddVerticeWithTwoParametersSourceNotFound() {

		String ps = "";

		try {
			g1.addVertice(v1, v2);
		} catch (SourceNotFoundException e) {
			ps = e.toString();
		}
		assertEquals("com.ensg.graph.SourceNotFoundException", ps);

	}

	@Test
	public void testaddVerticeWithTwoParameters() throws SourceNotFoundException {

		g1.addVertice(v1);
		g1.addVertice(v1, v2);
		assertEquals(2, g1.getVerticesSize());

	}

	@Test
	public void testgetEdges() {

		List<Edge> list = new ArrayList<Edge>();
		list.add(e1);
		g1.setEdges(list);
		assertTrue(list.equals(g1.getEdges()));

	}

	@Test
	public void testgetVertices() {

		List<Vertice> list = new ArrayList<Vertice>();
		list.add(v1);
		g1.addVertice(v1);
		assertTrue(list.equals(g1.getVertices()));

	}

	@Test
	public void testgetVerticesSize() {

		assertEquals(0, g1.getVerticesSize());
		g1.addVertice(v1);
		assertEquals(1, g1.getVerticesSize());
	}

	@Test
	public void testgetEdgesSize() {

		assertEquals(0, g1.getEdgesSize());
		DirictedGraph d = (DirictedGraph) g1;
		d.addEdge(e1);
		assertEquals(1, g1.getEdgesSize());
	}

	@Test
	public void testNeighbour() {
		Vertice v3 = new Vertice<Integer>(1);

		assertEquals(0, g1.neighbour(v1).size());
		DirictedGraph d = (DirictedGraph) g1;
		d.addEdge(e1);
		assertEquals(1, g1.neighbour(v1).size());
		d.addEdge(new Edge(v2, v3));
		d.addEdge(new Edge(v3, v1));
		assertEquals(2, g1.neighbour(v1).size());

	}

	@Test
	public void testIsDestinationIsSource() {
		DirictedGraph d = (DirictedGraph) g1;
		Vertice v3 = new Vertice<Integer>(1);
		d.addVertice(v3);
		d.addVertice(v1);
		d.addVertice(v2);
		assertEquals(0, d.isDetinationOf(v1).size());
		assertEquals(0, d.isSourceOf(v2).size());
		d.addEdge(e1);
		assertEquals(1, d.isDetinationOf(v1).size());
		assertEquals(1, d.isSourceOf(v2).size());
	}

	@Test
	public void testSuccessors() {
		DirictedGraph d = (DirictedGraph) g1;
		Vertice v3 = new Vertice<Integer>(1);
		d.addVertice(v3);
		d.addVertice(v1);
		d.addVertice(v2);
		assertEquals(0, d.successors(v1).size());
		d.addEdge(e1);
		assertEquals(1, d.successors(v1).size());
		d.addEdge(new Edge(v2, v3));
		assertEquals(2, d.successors(v1).size());
		// d.addEdge(new Edge(v3,v1));
		d.addEdge(new Edge(v2, new Vertice<String>("dd")));

		assertEquals(3, d.successors(v1).size());
		assertEquals(0, d.successors(new Vertice<String>("dddd")).size());

	}

	@Test
	public void testPredecessor() {
		DirictedGraph d = (DirictedGraph) g1;
		Vertice v3 = new Vertice<Integer>(1);
		d.addVertice(v3);
		d.addVertice(v1);
		d.addVertice(v2);
		assertEquals(0, d.predecessor(v1).size());
		d.addEdge(e1);
		assertEquals(1, d.predecessor(v2).size());
		d.addEdge(new Edge(v2, v3));
		assertEquals(2, d.predecessor(v3).size());
		d.addEdge(new Edge(v1, v3));
		d.addEdge(new Edge(new Vertice<String>("dd"), v2));
		assertEquals(4, d.predecessor(v3).size());
		assertEquals(0, d.predecessor(new Vertice<String>("dddd")).size());

	}

	@Test
	public void testShortestPath() {
		DirictedGraph d = (DirictedGraph) g1;
		Vertice v3 = new Vertice<String>("v3");
		Vertice v4 = new Vertice<String>("v4");
		Vertice v5 = new Vertice<String>("v5");
		Vertice v6 = new Vertice<String>("v6");

		d.addEdge(new Edge(v1, v2));
		d.addEdge(new Edge(v1, v4));
		d.addEdge(new Edge(v2, v3));
		d.addEdge(new Edge(v3, v5));
		d.addEdge(new Edge(v4, v5));
		d.addVertice(v6);

		List<Vertice> result = d.shortestPath(v1, v5);
		assertEquals(result.get(0), v1);
		assertEquals(result.get(1), v4);
		assertEquals(result.get(2), v5);

		result = d.shortestPath(v1, v6);
		assertEquals(0, result.size());

		d.addEdge(new Edge(v1, v5));
		result = d.shortestPath(v1, v5);
		assertEquals(result.get(0), v1);
		assertEquals(result.get(1), v5);

	}

}
