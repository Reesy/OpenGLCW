import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

import static javax.media.opengl.GL2.*;

public class CGCW01 extends JFrame{

	final GLJPanel canvas = new GLJPanel(); //Define a canvas 
	final FPSAnimator animator=new FPSAnimator(canvas, 60, true);;
	final Renderer renderer = new Renderer();

	public CGCW01(){		
		add(canvas, java.awt.BorderLayout.CENTER); // Put the canvas in the frame
		canvas.addGLEventListener(renderer); //Set the canvas to listen GLEvents
		canvas.addKeyListener(renderer);
		
//		animator.add(canvas);

		setTitle("CGCW01");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		animator.start();
		canvas.requestFocus();
	}
	
	public static void main(String[] args) {
		CGCW01 frame = new CGCW01();

	}

	class Renderer implements GLEventListener, KeyListener {
		final GLUT glut = new GLUT(); //For invoking glut functions
		
		private double scale = 1;
		
		@Override
		public void display(GLAutoDrawable drawable) {
			GL2 gl = drawable.getGL().getGL2();
			
			gl.glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			
			gl.glMatrixMode(GL_MODELVIEW);
			gl.glLoadIdentity();
			
			/* Fill in transformation code here*/
	
			gl.glScaled(scale, scale, scale);
			glut.glutSolidTeapot(1.0);
		}
		
		@Override
		public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void init(GLAutoDrawable drawable) {
			GL2 gl = drawable.getGL().getGL2(); // Get the GL pipeline object this 
			// GLAutoDrawable uses
			
			gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Set clear color to black
			gl.glClearDepth(1.0f); // Set the depth value to 1.0 (the maximum value),
			// when the depth buffer is cleared
			
			gl.glEnable(GL_DEPTH_TEST); //Enable depth test
			
			gl.glEnable(GL_LIGHT0);		
			gl.glEnable(GL_LIGHTING);
		}
		
		@Override
		public void reshape(GLAutoDrawable drawable, int x, int y, int width,
		int height) {
			GL2 gl = drawable.getGL().getGL2();	// Get the GL pipeline object this 
								// GLAutoDrawable uses
			
			gl.glMatrixMode(GL_PROJECTION);
			gl.glLoadIdentity();
			
			gl.glViewport(x, y, width, height);
			float r;
			if (width <= height) {
				r = (float) height / (float) width;
				gl.glOrtho(-2.0, 2.0, -2.0 * r, 2.0 * r, -2.0, 2.0);
			}
			else{
				r = (float) width / (float) height;
				gl.glOrtho(-2.0 * r, 2.0 * r, -2.0, 2.0,-2.0,2.0);
			}
		}
		
		@Override
		public void keyPressed(KeyEvent ke) {
		
			int keyEvent = ke.getKeyCode(); 
			switch (keyEvent){
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			case KeyEvent.VK_M:
				scale *= 1.1;
				break;
				
			// Define some parameters at a suitable location in this program
			// and calculate the parameters here to respond to some key events
			// scale down the object when key 'n' is pressed
				//move the object left when the Left arrow key is pressed 
				//move the object right when the Right arrow key is pressed 
				//move the object up when the Up arrow key is pressed 
				//move the object down when the down arrow key is pressed 
				//rotate the object around X axis clockwise or anti-clockwise
				// when the Page Up or Page Down key is pressed 
				//rotate the object around Y axis clockwise or anti-clockwise
				// when the Home or End key is pressed 
			}					
		}
		
		@Override
		public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
		}
	}

}

