package Train.FisaGroup.entities;

import java.util.Hashtable;


public class Route {
	
  public Hashtable<City, Edge> directGraph;


  public Route() {
    this.directGraph = new Hashtable<City, Edge>();
  }

  public Hashtable<City, Edge> getDirectGraph() {
    return directGraph;
  }



}    