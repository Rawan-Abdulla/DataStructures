package edu.bu.main;

import java.io.File;


import edu.bu.runners.XmlReader;

public class mainGraph {

	public static void main(String[] args) throws Exception, Exception, Exception {
		File xmlFile= new File("C:\\Users\\SAQERpc\\Desktop\\Bethlehem-verysmall.osm");
		Graph graph= XmlReader.createGraph(xmlFile);
		

	}

}
