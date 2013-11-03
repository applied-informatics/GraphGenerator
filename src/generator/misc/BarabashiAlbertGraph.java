package generator.misc;

import java.util.Random;

public class BarabashiAlbertGraph extends GraphMLGraph {
	
	public BarabashiAlbertGraph(int n) {
		N = n;
		matrix = new int[N][N];
		Random rand = new Random();
		// we begin from two connected points
		// all points are identical, so we can choose any
		
		matrix[0][1] = 1;
		matrix[1][0] = 1;
		int totalDegree = 2;
		
		for (int i=2;i<N;i++) {
			for (int j=0;j<i;j++) {
				double p = countDegree(j)*1.0/totalDegree;
				double rd = rand.nextDouble();
				if (p-rd > 0.000001) {
					matrix[i][j] = 1;
					matrix[j][i] = 1;
					totalDegree += 2;
				}
			}
		}
	}
	
	public int countDegree(int num) {
		int res=0;
		for (int i=0;i<N;i++) {
			if (this.matrix[num][i]==1) {
				res += 1;
			}
		}
		return res;
	}

}
