package com.ensg.graph;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLGraph implements GraphFactory {

	public void create(AbstractGraph graph, File file) {
		
		        
		try {
			System.out.println(graph.getClass());
			DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuild = docFac.newDocumentBuilder();
			Document doc=docBuild.newDocument() ;
			Element rootElement = doc.createElement("graph");
			doc.appendChild(rootElement);
			Attr type = doc.createAttribute("type");
			type.setValue(graph.getClass().getSimpleName());
			rootElement.setAttributeNode(type);  
			
			for(Edge edge : graph.edges ) {
				
				Element edgeXml = doc.createElement("edge");
				rootElement.appendChild(edgeXml);
				
				Attr idEdge= doc.createAttribute("id");
				idEdge.setValue(edge.getId()+"");
				edgeXml.setAttributeNode(idEdge);
				
				Element sourceXml = doc.createElement("source");
				edgeXml.appendChild(sourceXml);
				
				Element VerticeSourceXml = doc.createElement("vertice");
				sourceXml.appendChild(VerticeSourceXml);
				Attr idVerticeSource= doc.createAttribute("id");
				idVerticeSource.setValue(edge.getSource().getId()+"");
				VerticeSourceXml.setAttributeNode(idVerticeSource);
				
				Attr typeVerticeSource= doc.createAttribute("type");
				typeVerticeSource.setValue(edge.getSource().getType()+"");
				VerticeSourceXml.setAttributeNode(typeVerticeSource);
				
				Element destinationXml = doc.createElement("destination");
				edgeXml.appendChild(destinationXml);
				
				Element VerticeDestinationXml = doc.createElement("vertice");
				destinationXml.appendChild(VerticeDestinationXml);
				Attr idVerticeDestination= doc.createAttribute("id");
				idVerticeDestination.setValue(edge.getDestination().getId()+"");
				VerticeDestinationXml.setAttributeNode(idVerticeDestination);
				
				Attr typeVerticeDestination= doc.createAttribute("type");
				typeVerticeDestination.setValue(edge.getDestination().getType()+"");
				VerticeDestinationXml.setAttributeNode(typeVerticeDestination);	
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");
			
			
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	
	}

	public AbstractGraph load(File file) {
		
		AbstractGraph g = null ;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder  dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			
			NodeList edges = doc.getElementsByTagName("edge");
			g = this.createGraph(enumGraph.valueOf(doc.getDocumentElement().getAttribute("type")));
			for (int i = 0; i < edges.getLength(); i++) {  
		    	Element edge = (Element)edges.item(i);
		        
		    	Element source = (Element) edge.getElementsByTagName("source").item(0);  
		    	Element vsourcexml = (Element) source.getElementsByTagName("vertice").item(0);  
		    	Vertice vSource = new Vertice(vsourcexml.getAttribute("type"));
		    	vSource.setId(Integer.parseInt(vsourcexml.getAttribute("id").toString()));
  		    	
		    	Element destination = (Element) edge.getElementsByTagName("destination").item(0);
		    	Element vdestinationxml = (Element) source.getElementsByTagName("vertice").item(0);  

		    	Vertice vDestination = new Vertice(vdestinationxml.getAttribute("type"));
		    	vDestination.setId(Integer.parseInt(vdestinationxml.getAttribute("id")));
		    	g.addEdge(new Edge(vSource, vDestination));
		    	
		    }
			
			   
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
		
	
	   
	}

	public AbstractGraph createGraph(enumGraph type) {
		
		AbstractGraph graph=null ;
		switch(type)
		{
		case DirictedGraph:graph = new DirictedGraph();break;
		case UndirictedGraph:graph = new UnDirictedGraph();break;
		}
		
		
		return graph;
	}




}
