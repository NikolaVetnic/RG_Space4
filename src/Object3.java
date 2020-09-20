import javafx.scene.paint.Color;
import mars.drawingx.drawing.View;

public class Object3 {

	private Vector4[] 	verts;
	private int[][] 	edges;
	private double 		scale;
	

	// constructors
	public Object3(Vector4[] verts, int[][] edges, double scale) {
		
		this.verts = verts;
		this.edges = edges;
		
		this.scale = scale;
	}
	

	// getters 
	public Vector4 getVert(int i) { return this.verts[i].scale(scale); }

	public int vertCount() { return this.verts.length; }

	public int edgeCount() { return this.edges.length;	}
	

	// setters
	public void setVertex(int i, double x, double y, double z) {
		
		verts[i].x = x;
		verts[i].y = y;
		verts[i].z = z;
	}

	
	// static
	static double[][] mulMat(double[][] a, double[][] b) {
		
		double[][] res = new double[a.length][b[0].length];
		
		for (int j = 0; j < res.length; j++) {
			
			res[j][0] = 0.0;
			for (int k = 0; k < res[0].length; k++) {
				
				double sum = 0.0;
				for (int i = 0; i < b.length; i++)
					sum += b[i][k] * a[j][i];
				
				res[j][k] = sum;
			}
		}
		
		return res;
	}

	static public Object3 cube(double scale) {
		
		return new Object3(
				new Vector4[] { 
						new Vector4(-1, -1, -1, 0),
						new Vector4( 1, -1, -1, 0),
						new Vector4(-1,  1, -1, 0),
						new Vector4( 1,  1, -1, 0),
						new Vector4(-1, -1,  1, 0),
						new Vector4( 1, -1,  1, 0),
						new Vector4(-1,  1,  1, 0),
						new Vector4( 1,  1,  1, 0)
					},
					new int[][] {
						{ 0, 1 }, { 0, 2 }, { 2, 3 }, { 1, 3 },
						{ 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 },
						{ 4, 5 }, { 4, 6 }, { 6, 7 }, { 5, 7 }
					},
					scale
				);
	}

	
	// methods
	public Object3 apply(Transform3 t) {
		
		Object3 result = new Object3(this.verts, this.edges, this.scale);
		
		for (int i = 0; i < result.vertCount(); i++) {
			
			double[][] tmp = { 
					{ result.getVert(i).x / scale }, 
					{ result.getVert(i).y / scale },
					{ result.getVert(i).z / scale }, 
					{ 1 } 
				};
			
			tmp = mulMat(t.t, tmp);
			
			result.setVertex(i, tmp[0][0], tmp[1][0], tmp[2][0]);
		}
		
		return result;
	}

	public void stroke(View view, Color c, double zScale) {
		
		view.setStroke(c);
		view.setLineWidth(1.0);
		
		for (int i = 0; i < verts.length; i++)
			view.strokeCircleCentered(verts[i].p3(zScale), 2.5);
		
		for (int i = 0; i < edges.length; i++)
			view.strokeLine(verts[edges[i][0]].p3(zScale), verts[edges[i][1]].p3(zScale));
	}
}
