package generator.misc;

public class GraphGenerator {

	public static void main(String[] args) {
		ErdesRenyiGraph g = new ErdesRenyiGraph(10, 0.5);
		g.write("erdesh");
		GeometricalRandomGraph gg = new GeometricalRandomGraph(10, 0.5);
		gg.write("geom");
		
	}

}
