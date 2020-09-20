
public class Transform3 {
	
	public double[][] t;
	
	
	// constructors
	public Transform3() {
		 
		t = new double[4][4];
		 
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[0].length; j++)
				t[i][j] = i == j ? 1 : 0;
	}
	
	
	// angle conversions
	static double turnToRad(double turn) { return turn * (2 * Math.PI);     }
	
	static double turnToDeg(double turn) { return turn * 360.0;             }
	
	static double radToTurn(double rad)  { return rad / (2 * Math.PI);      }
	
	static double radToDeg (double rad)  { return rad * (180.0 * Math.PI);  }
	
	static double degToTurn(double deg)  { return deg / 360.0;              }

	static double degToRad (double deg)  { return (deg / 180.0) * Math.PI;  }
	
	
	// methods
	void nullify() {
		
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[0].length; j++)
				this.t[i][j] = i == j ? 1 : 0;
	}
	
	void translate(double x, double y, double z) {
		
		this.nullify();
		
		this.t[0][3] = x;	this.t[1][3] = y;	this.t[2][3] = z;
	}
	
	void rotate_x(double rx) {

		this.nullify();
		
		this.t[1][1] =  Math.cos(rx);		this.t[1][2] = -Math.sin(rx);
		this.t[2][1] =  Math.sin(rx);		this.t[2][2] =  Math.cos(rx);
	}
	
	void rotate_y(double ry) {

		this.nullify();
		
		this.t[0][0] =  Math.cos(ry);		this.t[0][2] =  Math.sin(ry);
		this.t[2][0] = -Math.sin(ry);		this.t[2][2] =  Math.cos(ry);
	}

	void rotate_z(double rz) {

		this.nullify();
		
		this.t[0][0] =  Math.cos(rz);		this.t[0][1] = -Math.sin(rz);
		this.t[1][0] =  Math.sin(rz);		this.t[1][1] =  Math.cos(rz);
	}
}
