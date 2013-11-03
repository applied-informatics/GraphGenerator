package generator.misc;

import java.util.Random;

public class ErdesRenyiGraph extends GraphMLGraph {
	
	public ErdesRenyiGraph(int n, double p) {
		this.N = n;
		this.matrix = new int[N][N];
		Random rand = new Random();
		for (int i=0;i<N;i++) {
			for (int j=i+1;j<N;j++) {
				if (p-rand.nextDouble()>0.000001) {
					matrix[i][j] = 1;
					matrix[j][i] = 1;
				}
			}
		}
		
	}

}
