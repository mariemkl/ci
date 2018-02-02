package com.ensg.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * class pour representer les graphes orientés 
 * @author Adel OUHABI
 *
 */
public class DirictedGraph extends AbstractGraph  {
	
	/**
	 * 
	 * @return retourn un graph non orienté
	 */
	public UnDirictedGraph toUnDirictedGraph() {
		UnDirictedGraph result = new UnDirictedGraph();
		List<Edge> listE = this.edges ;
		for(Edge e : listE) {
			Edge e1 = new Edge(e.getDestination(),e.getSource());
			
			if (this.isEdge(e.getDestination(), e.getSource()))
				listE.remove(e1);
		}
		result.setEdges(listE);
		return result ;
	}
	
	
	
	/**
	 * methode qui retourn le plus court chemin entre deux sommets
	 *
	 */
	public List<Vertice> shortestPath(Vertice source, Vertice destination) {
	
		List<Vertice> result = new ArrayList<Vertice>();
		List<Integer>position = new ArrayList<Integer>();
		List<Vertice> pred = this.predecessor(destination);
		int cpt =0 ;int pos =0;
		for (Vertice pre : pred) {
			if (pre.equals(source)) { 
				cpt++;
				position.add(pos);
			}
			pos++;   
		}
		int i = 0 , j=0 , min =0 ;
		if(position.size()>0) {
			j= position.get(0);
			min=j-i ;
			for (int k = 1 ; k<position.size() ; k++) {
			if((position.get(k)-position.get(k-1))<min ) {
				i=position.get(k-1);
				j=position.get(k);
				min=j-i;
			}
			}
			 result.add(destination);
			for(int k=i; k<=j;k++) {
				result.add(pred.get(k));
			}
			 
		}
		Collections.reverse(result);
		return result;  
		
		
	}
	/**
	 * methode pour retourner les successeurs d'un sommet
	 * 
	 */
	public List<Vertice> successors(Vertice vertice) {
		List<Vertice> list = new ArrayList<Vertice>();
		List<Vertice> vList= isDetinationOf(vertice);
   
		if ( vertice == null || !this.vertices.contains(vertice)) {
			return list ;
		}  
		for(Vertice v : vList ) {
			if(v !=vertice) {
			list.add(v);
			 list.addAll(successors(v));
			}
		}   
		return list ;  
	}

	/**
	 * methode pour retourner les predecesseurs d'un sommet
	 * 
	 */
	public List<Vertice> predecessor(Vertice vertice) {
		List<Vertice> list = new ArrayList<Vertice>();
		List<Vertice> vList= isSourceOf(vertice);
		if ( vertice == null || !this.vertices.contains(vertice)) {
			return list ;   
		}  
		for(Vertice v : vList ) { 
			if(v !=vertice) {
			list.add(v) ;
			 list.addAll(predecessor(v));
			}
		}
		return list;
	}
	
}