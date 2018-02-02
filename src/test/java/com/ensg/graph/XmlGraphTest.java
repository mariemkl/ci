package com.ensg.graph;

import java.io.File;

import org.junit.Test;

public class XmlGraphTest {

	@Test
	public void testCreate() {

		GraphFactory g = new XMLGraph();
		AbstractGraph d =g.createGraph(enumGraph.DirictedGraph);

		Vertice v1 = new Vertice<String>("v1");
		Vertice v2 = new Vertice<String>("v2");
		Vertice v3 = new Vertice<String>("v3");
		Vertice v4 = new Vertice<String>("v4");
		Vertice v5 = new Vertice<String>("v5");
		Vertice v6 = new Vertice<String>("v6");

		d.addEdge(new Edge(v1, v2));
		d.addEdge(new Edge(v1, v4));
		d.addEdge(new Edge(v2, v3));
		d.addEdge(new Edge(v3, v5));
		d.addEdge(new Edge(v4, v5));

		g.create(d, new File("file.xml"));
		System.out.println(g.toString());

	}

	@Test
	public void testload() {
		GraphFactory g = new XMLGraph();
		AbstractGraph d = g.load(new File("file.xml"));
		System.out.println(d);
		d.addEdge(new Edge(new Vertice<String>("v8"), new Vertice<String>("v9")));
		System.out.println(d);
		g.create(d, new File("file2.xml"));

	}

}
