package org.vaibhav.project.demo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Demo {

	private String name;
	private int ID;
	private int points;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Demo [name=" + name + ", ID=" + ID + ", points=" + points + "]";
	}
	
	
}
