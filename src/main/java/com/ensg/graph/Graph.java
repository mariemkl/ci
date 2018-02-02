package com.ensg.graph;

import java.util.List;
import java.util.Map;
/**
 * interface pour les defferentes methode d'un graphe
 * @author Adel OUHABI
 *
 */
public interface Graph {
	public List<Vertice> shortestPath(Vertice source, Vertice destination);
	public List<Vertice> neighbour(Vertice vertice) ;


}
