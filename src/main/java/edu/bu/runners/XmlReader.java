package edu.bu.runners;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.geotools.referencing.GeodeticCalculator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.bu.main.AdjacencyListGraph;
import edu.bu.main.Graph;

public class XmlReader {

	public static Graph createGraph(File xmlFile) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);

		NodeList nList = doc.getElementsByTagName("node");

		Graph graph = new AdjacencyListGraph();

		int length = nList.getLength();

		for (int i = 0; i < length; i++) {
			Element elementNode = (Element) nList.item(i);

			graph.addNode(Integer.parseInt(elementNode.getAttribute("id")), null,
					Float.parseFloat(elementNode.getAttribute("lat")),
					Float.parseFloat(elementNode.getAttribute("lon")));

		}

		NodeList ways = doc.getElementsByTagName("way");
		for (int i = 0; i < ways.getLength(); i++) {
			Element elementWay = (Element) ways.item(i);
			double speedMS = getSpeedKMH(elementWay) * 1000 / 3600.0;
			NodeList wayNodes = elementWay.getElementsByTagName("nd");

			for (int j = 1; j < wayNodes.getLength(); j++) {
				Element prevWayNodeElement = (Element) wayNodes.item(j - 1);
				Element wayNodeElement = (Element) wayNodes.item(j);

				Integer source = Integer.parseInt(wayNodeElement.getAttribute("ref"));
				Integer destination = Integer.parseInt(prevWayNodeElement.getAttribute("ref"));
				int orthodromicDist = getOrthodromicDist(graph.getNodes().get(source).getLat(),
						graph.getNodes().get(source).getLon(), graph.getNodes().get(destination).getLat(),
						graph.getNodes().get(destination).getLon());
				int timeInSec = (int) (orthodromicDist / speedMS);
				graph.addEdge(source, destination, timeInSec, orthodromicDist, true);

			}

			NodeList tags = elementWay.getElementsByTagName("tag");
			for (int j = 0; j < tags.getLength(); j++) {
				Element wayTagItem = (Element) tags.item(j);
				if (wayTagItem.getAttribute("k").equals("highway")) {

				}
			}
		}
		return graph;
	}

	private static int getSpeedKMH(Element elementWay) {
		NodeList tags = elementWay.getElementsByTagName("tag");
		for (int j = 0; j < tags.getLength(); j++) {
			Element wayTagItem = (Element) tags.item(j);
			if (wayTagItem.getAttribute("k").equals("highway")) {
				switch (wayTagItem.getAttribute("v").toLowerCase().trim()) {
				case "motorway":
					return 120;
				case "primary":
					return 80;
				case "secondary":
					return 50;
				case "tertiary ":
					return 40;
				case "residential":
					return 20;
				default:
					return 30;
				}
			}
		}
		return 30;
	}

	private static int getOrthodromicDist(double srcLat, double srcLon, double dstLat, double dstLon) {
		GeodeticCalculator calculator = new GeodeticCalculator();
		calculator.setStartingGeographicPoint(srcLon, srcLat);
		calculator.setDestinationGeographicPoint(dstLon, dstLat);
		return (int) calculator.getOrthodromicDistance();
	}

}
