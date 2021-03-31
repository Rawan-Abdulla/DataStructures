package edu.bu.main;

import java.util.ArrayList;
import java.util.List;

public class Geometry {
	private String type;
	private List<List<Double>> coordinates;

	public Geometry() {
		type = "LineString";
		coordinates = new ArrayList<>();
	}

	public Geometry(String type, List<List<Double>> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public void AddCoordinates(double lon, double lat) {
		List<Double> coordinate = new ArrayList<>();
		coordinate.add(lon);
		coordinate.add(lat);
		coordinates.add(coordinate);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<List<Double>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<Double>> coordinates) {
		this.coordinates = coordinates;

	}

}
