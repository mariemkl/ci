package com.ensg.graph;

import java.util.Objects;
   /**
    * class pour representer les sommets 
    * 
    * @author Adel OUHABI
    *
    * 
    */
public class Vertice<T> {

	private static int nbr = 0;
	private int id;
	private T type;

	public Vertice(T type) {
		super();
		nbr++;
		this.id = nbr;  
		this.type = type;
	}
/**
 * 
 * @return retourn la valeur du sommet 
 */
	public T getType() {
		return type;
	}
/**
 * 
 * @return retourn l'id du sommet
 */
	public int getId() {
		return id;
	}
/**
 * 
 * @param id initialise l'id du sommet
 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Vertice))   
			return false;
		if (obj == this)
			return true;

		Vertice v = (Vertice) obj;
		return (this.getType().equals(v.getType()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getType());

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vertice N°:"+id+" type:"+type+"\t";
	}
}
