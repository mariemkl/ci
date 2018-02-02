package com.ensg.graph;

import java.util.Objects;

/**
 * class pour representer les arcs 
 * @author Adel OUHABI
 *
 */
public class Edge {
	private static int nbr = 0;
	private int id = 0;
	private Vertice source;
	private Vertice destination;
	private int weigt=1 ;

	public Edge(Vertice source, Vertice destination) {
		nbr++;
		this.id = nbr;
		this.source = source;
		this.destination = destination;
	}
	public Edge(Vertice source, Vertice destination, int weight) {
		nbr++;
		this.id = nbr;
		this.weigt=weight ;
		this.source = source;
		this.destination = destination;
	}

	
	/**
	 * 
	 * @return le poids de l'arc
	 */
	public int getWeigt() {
		return weigt;
	}
	/**
	 * 
	 * @return retourn le sommet source de l'arc
	 */
	public Vertice getSource() {
		return source;
	}

	/**
	 * 
	 * @param source initialise le sommet source de l'arc
	 */
	public void setSource(Vertice source) {
		this.source = source;
	}
	/**
	 * 
	 * @return retourn le sommet destination de l'arc
	 */
	public Vertice getDestination() {
		return destination;
	}


	/**
	 * 
	 * @param destination initialise le sommet destination de l'arc
	 */
	public void setDestination(Vertice destination) {
		this.destination = destination;
	}
/**
 * 
 * @return retourne l'id de l'arc
 */
	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getSource().hashCode(), this.getDestination().hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Edge))
			return false;
		if (obj == this)
			return true;

		Edge e = (Edge) obj;
		return (this.source.equals(e.getSource()) && this.destination.equals(e.getDestination()));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		return "edge N°:" + id + " \n" + "source :" + this.source.toString() + "\n" + "destination :"
				+ this.destination.toString() + "\n";
	}

}
