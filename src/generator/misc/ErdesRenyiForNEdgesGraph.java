package generator.misc;

import java.util.Random;

public class ErdesRenyiForNEdgesGraph extends GraphMLGraph {
	public ErdesRenyiForNEdgesGraph(int n, int M) {
		N = n;
		matrix = new int[N][N];
		int selected = 0;
		Random rand = new Random();
		
		if (M > N*(N-1)/2) M = N*(N-1)/2;
		
		while (selected < M) {
			int i = rand.nextInt(N);
			int j = rand.nextInt(N);
			if (i != j && matrix[i][j] != 1) {
				matrix[i][j] = 1;
				matrix[j][i] = 1;
				selected += 1;
			}
		}
		
	}
}