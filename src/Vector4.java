import mars.geometry.Vector;

public class Vector4 {	

	double x, y, z, w;
	

	// constants
	public static final Vector4 ZERO = new Vector4(0, 0, 0, 0);
	
	
	// constructors
	public Vector4(double x, double y, double z, double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
		
	public Vector4(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 0;
	}
	
	public Vector4 scale(double scale) {
		return new Vector4(
				this.x * scale, 
				this.y * scale, 
				this.z * scale, 
				this.w * scale
				);
	}
	
	
	// methods
	public Vector p3(double zScale) {
		
		return new Vector(
				this.x / this.z * zScale,
				this.y / this.z * zScale
				);
	}
	
	public String toString() {
		
		String output = "( ";
		
		output = x > 0 ? output + "+" + x + "\t" : output + x + "\t";
		output = y > 0 ? output + "+" + y + "\t" : output + y + "\t";
		output = z > 0 ? output + "+" + z + "\t" : output + z + "\t";
		output = w > 0 ? output + "+" + w + "\t" : output + w + " )";
		
		return output;
	}
}
