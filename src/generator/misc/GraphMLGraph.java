package generator.misc;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GraphMLGraph {
	protected int N;
	protected int[][] matrix;
		
	public void write(String name) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("graphml");
			rootElement.setAttribute("xmlns","http://graphml.graphdrawing.org/xmlns");
			rootElement.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
			rootElement.setAttribute("xsi:schemaLocation","http://graphml.graphdrawing.org/xmlns http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd");
			doc.appendChild(rootElement);
			Element graphElement = doc.createElement("graph");
			graphElement.setAttribute("id", "G");
			graphElement.setAttribute("edgedefault", "undirected");
			rootElement.appendChild(graphElement);
			ArrayList<Element> nodes = new ArrayList<Element>();
			ArrayList<Element> edges = new ArrayList<Element>();
			int edgeCounter = 0;
			for (int i=0;i<N;i++) {
				Element node = doc.createElement("node");
				node.setAttribute("id", "nd" + i);
				nodes.add(node);
				for (int j=i+1;j<N;j++) {
					if (matrix[i][j] == 1) {
						Element edge = doc.createElement("edge");
						edge.setAttribute("id", "ed" + edgeCounter);
						edge.setAttribute("source", "nd" + i);
						edge.setAttribute("target", "nd" + j);
						edges.add(edge);
						edgeCounter += 1;
					}
				}
			}
			for (Element node: nodes) {
				graphElement.appendChild(node);
			}
			for (Element edge: edges) {
				graphElement.appendChild(edge);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("./graphs/"+name+".xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
	
}

//<?xml version="1.0" encoding="UTF-8"?>
//<graphml  >
//  <graph id="G" edgedefault="undirected">
//    <node id="n0"/>
//    <node id="n1"/>
//    <edge id="e1" source="n0" target="n1"/>
//  </graph>
//</graphml>