import javafx.scene.paint.Color;
import mars.drawingx.application.DrawingApplication;
import mars.drawingx.drawing.Drawing;
import mars.drawingx.drawing.DrawingUtils;
import mars.drawingx.drawing.View;
import mars.drawingx.gadgets.annotations.GadgetAnimation;

public class Main4 implements Drawing {
	
	public static final int IMG_W = 640;
	public static final int IMG_H = 480;
	
	
	@GadgetAnimation
	double time = 0.0;
	

	@Override
	public void draw(View view) {
		
		DrawingUtils.clear(view, Color.gray(0.125));
		
		Object3 cube = Object3.cube(150.0);
		
		Transform3 rotate_x = new Transform3();		rotate_x.rotate_x(time);
		Transform3 rotate_y = new Transform3();		rotate_y.rotate_y(time * 0.25);
		Transform3 rotate_z = new Transform3();		rotate_z.rotate_z(time * 0.125);
		
		cube = ((cube.apply(rotate_x)).apply(rotate_y)).apply(rotate_z);
		
		Transform3 trans = new Transform3();		trans.translate(0, 0, 5);
		
		cube = cube.apply(trans);
		
		cube.stroke(view, Color.INDIANRED, 400.0);
	}

	
	public static void main(String[] args) {
		
		DrawingApplication.launch(IMG_W, IMG_H);
	}
}
