package Train.FisaGroup.entities;

public class Edge {
	public City origin;
	public City destination;
	public int weight;
	public Edge next;

  public Edge (City origin, City destination){
    this(origin, destination, Integer.MAX_VALUE);
  }

	public Edge(City origin, City destination, int weight) {
		this.origin 		= origin;
		this.destination	= destination;
		this.weight 		= weight;
		this.next 		= null;
	}

	public Edge next(Edge edge) {
		this.next = edge;
		return this;
	}

  public double getWeight() {
    return weight;
  }

  public String toString() {
    return origin + "to" + destination;
  }
}