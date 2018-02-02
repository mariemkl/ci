package com.ensg.graph;

import java.io.File;
/**
 * interface pour fabriquer les graphes
 * @author Adel OUHABI
 *
 */
public interface GraphFactory {
	public AbstractGraph createGraph(enumGraph type);
	public void create(AbstractGraph graph , File file);
	public AbstractGraph load(File file) ;
	


}
