package generator.misc;

public class GraphGenerator {

	public static void main(String[] args) {
		try {
			GraphMLGraph graph = null;
			
			String type = args[0].toLowerCase();
			int n = Integer.parseInt(args[1]);
			double prob;
			
			switch (type) {
			case "random":
				prob = Double.parseDouble(args[2]);
				graph = new ErdesRenyiGraph(n, prob);
				break;
			case "erdesh":
				int m = Integer.parseInt(args[2]);
				graph = new ErdesRenyiForNEdgesGraph(n, m);
				break;
			case "geometrical":
				prob = Double.parseDouble(args[2]);
				graph = new GeometricalRandomGraph(n, prob);
				break;
			case "freescale":
				graph = new BarabashiAlbertGraph(n);
				break;
			default:
				break;
			}
			graph.write("graph");
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("You need specify at least 2 params: algorithm and number of points. For random and geometrical algorithm you should also add probability");
		}
		
	}

}
