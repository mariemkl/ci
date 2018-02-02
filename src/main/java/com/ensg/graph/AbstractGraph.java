package com.ensg.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class abstraite pour les graphes
 * 
 * @author Adel OUHABI
 *
 */
public abstract class AbstractGraph implements Graph {
	protected List<Edge> edges = new ArrayList<Edge>();
	protected List<Vertice> vertices = new ArrayList<Vertice>();

	/**
	 * methode pour ajouter un sommet au graphe
	 * 
	 * @param source
	 * @param newVertice
	 * @throws SourceNotFoundException
	 */
	public void addVertice(Vertice source, Vertice newVertice) throws SourceNotFoundException {
		if (this.vertices.contains(source)) {
			this.edges.add(new Edge(source, newVertice));
			this.vertices.add(newVertice);
		} else {
			throw new SourceNotFoundException(source);
		}

	}

	/**
	 * methode pour ajouter un arc au graphe
	 * 
	 * @param edge
	 */
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		this.addVertice(edge.getSource());
		this.addVertice(edge.getDestination());

	}
	

	/**
	 * methode pour ajouter un sommet au graphe
	 * 
	 * @param newVertice
	 */
	public void addVertice(Vertice newVertice) {
		if (vertices.size() == 0 || !vertices.contains(newVertice)) {
			this.vertices.add(newVertice);
		}
	}
/**
 * 
 * @return retourn la liste des arcs du graphe
 */
	public List<Edge> getEdges() {
		return edges;
	}
/**
 * methode pour initaliser la liste des arcs d'un graphe
 * @param edges
 */
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
/**
 * 
 * @return retourn la liste des sommets d'un graphe
 */
	public List<Vertice> getVertices() {
		return vertices;
	}
/**
 * 
 * @return retourn le nombre de sommets du graphe
 */
	public int getVerticesSize() {
		return vertices.size();
	}
/**
 * 
 * @return retourne le nombre d'arcs du graphe
 */
	public int getEdgesSize() {
		return edges.size();
	}
/**
 * 
 * @param source
 * @param destination
 * @return retourn les differents chemins entre deux sommets
 */
	private List<List<Vertice>> paths(Vertice source, Vertice destination) {
		List<List<Vertice>> result = new ArrayList<List<Vertice>>();
		List<Vertice> list = new ArrayList<Vertice>();

		List<Vertice> vList = isDetinationOf(source);
		if (source.equals(destination)) {
			result.add(list);
			return result;
		}
		for (Vertice v : vList) {
			// list = new ArrayList<Vertice>();
			list.add(v);
			result.addAll(paths(v, destination));
			// System.out.println(result.size());

		}

		return result;

	}
/**
 * 
 * @param vertice
 * @return retourn la liste des sommets voisin d'un sommet
 */
	public List<Vertice> neighbour(Vertice vertice) {
		// TODO Auto-generated method stub
		List<Vertice> voisin = new ArrayList<Vertice>();
		for (Vertice v : this.vertices) {
			if (isEdge(vertice, v)) {
				voisin.add(v);
			}

		}
		return voisin;
	}
/**
 * 
 * @param v1
 * @param v2
 * @return retourn vrai si il existe un arc (v1,v2) dans le graph
 */
	protected boolean isEdge(Vertice v1, Vertice v2) {
		if (this.getEdges().contains(new Edge(v1, v2)) || this.getEdges().contains(new Edge(v2, v1)))
			return true;
		else
			return false;
	}
/**
 * 
 * @param destination
 * @return la liste des sommet qui la source du sommet passé en paramettre 
 */
	protected List<Vertice> isSourceOf(Vertice destination) {
		List<Vertice> result = new ArrayList<Vertice>();
		for (Vertice v : this.vertices) {
			if (this.getEdges().contains(new Edge(v, destination))) {
				result.add(v);

			}
		}

		return result;
	}
/**
 * 
 * @param source
 * @return la liste des sommet qui la destination du sommet passé en paramettre 
 */
	protected List<Vertice> isDetinationOf(Vertice source) {
		List<Vertice> result = new ArrayList<Vertice>();
		for (Vertice v : this.vertices) {
			if (this.getEdges().contains(new Edge(source, v))) {
				result.add(v);

			}
		}

		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (Edge e : this.edges) {
			str += e.toString();
		}
		return str;
	}
	
	
}
