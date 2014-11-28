import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

import static javax.media.opengl.GL.GL_FRONT;
import static javax.media.opengl.GL.GL_TRIANGLE_FAN;
import static javax.media.opengl.GL2.*;
import static javax.media.opengl.GL2GL3.GL_QUADS;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_AMBIENT;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_DIFFUSE;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_SHININESS;
import static javax.media.opengl.fixedfunc.GLLightingFunc.GL_SPECULAR;

public class TestBed extends JFrame{

	final GLJPanel canvas = new GLJPanel(); //Define a canvas 
	final FPSAnimator animator=new FPSAnimator(canvas, 60, true);;
	final Renderer renderer = new Renderer();

	public TestBed(){		
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
		TestBed frame = new TestBed();

	}
	
	
	private void customObject(GL2 gl){
		
		spokes(gl);
		
		
		
		
		
	}
	
	private void spokes(GL2 gl){

			cylinder_thin(gl);
			gl.glRotated(45, 1, 0, 0);
			cylinder_thin(gl);
			gl.glRotated(45, 1, 0, 0);
			cylinder_thin(gl);
			gl.glRotated(45, 1, 0, 0);
			cylinder_thin(gl);
		
		
	
		
	}
	private void body(GL2 gl){
		   float diffuse[] = {0.0f, 0.0f, 0.5f, 1.0f};
		      float ambient[] = {0.0f, 0.0f, 0.5f, 1.0f};
		      float specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
		      float shine[] = {127.0f};
		
		
		
	      // Set material
	      gl.glMaterialfv(GL_FRONT, GL_AMBIENT, ambient, 0);
	      gl.glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuse, 0);
	      gl.glMaterialfv(GL_FRONT, GL_SPECULAR, specular, 0);
	      gl.glMaterialfv(GL_FRONT, GL_SHININESS, shine, 0);
		
		
	      	//torso
	      	
			gl.glBegin(GL_QUADS);
		        gl.glNormal3f(0.5f, 0.0f, 0.0f);
		        gl.glVertex3f(0.5f, 1.0f, 1.0f);
		        gl.glVertex3f(0.5f, -1.0f, 1.0f);
		        gl.glVertex3f(0.5f, -1.0f, -1.0f);
		        gl.glVertex3f(0.5f, 1.0f, -1.0f);
		
		        gl.glNormal3f(-0.5f, 0.0f, 0.0f);
		        gl.glVertex3f(-0.5f, 1.0f, 1.0f);
		        gl.glVertex3f(-0.5f, 1.0f, -1.0f);
		        gl.glVertex3f(-0.5f, -1.0f, -1.0f);
		        gl.glVertex3f(-0.5f, -1.0f, 1.0f);
		
		        gl.glNormal3f(0.0f, 1.0f, 0.0f);
		        gl.glVertex3f(1.0f, 1.0f, 1.0f);
		        gl.glVertex3f(1.0f, 1.0f, -1.0f);
		        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
		        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
		
		        gl.glNormal3f(0.0f, -1.0f, 0.0f);
		        gl.glVertex3f(1.0f, -1.0f, 1.0f);
		        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
		        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
		        gl.glVertex3f(1.0f, -1.0f, -1.0f);
		
		        gl.glNormal3f(0.0f, 0.0f, 1.0f);
		        gl.glVertex3f(1.0f, 1.0f, 1.0f);
		        gl.glVertex3f(-1.0f, 1.0f, 1.0f);
		        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
		        gl.glVertex3f(1.0f, -1.0f, 1.0f);
		
		        gl.glNormal3f(0.0f, 0.0f, -1.0f);
		        gl.glVertex3f(1.0f, 1.0f, -1.0f);
		        gl.glVertex3f(1.0f, -1.0f, -1.0f);
		        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
		        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
		    gl.glEnd();
			
		
		
		
		
		
	}
	private void cylinder_thin(GL2 gl) {
		//Draw a cylinder with radius 1, and the axis length 2


		   float diffuse[] = {0.0f, 0.0f, 0.5f, 1.0f};
		      float ambient[] = {0.0f, 0.0f, 0.5f, 1.0f};
		      float specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
		      float shine[] = {127.0f};
		
		
		
	      // Set material
	      gl.glMaterialfv(GL_FRONT, GL_AMBIENT, ambient, 0);
	      gl.glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuse, 0);
	      gl.glMaterialfv(GL_FRONT, GL_SPECULAR, specular, 0);
	      gl.glMaterialfv(GL_FRONT, GL_SHININESS, shine, 0);

		  double deg_to_rad = Math.PI/180.0 ;
	      double x,y;
	      
	      //north face
	      gl.glBegin (GL_TRIANGLE_FAN);
	      gl.glNormal3d(0, 0, 1);
	      gl.glVertex3d (0.0, 0.0, 1.0);
	      for (double thet = -180.0; thet <= 180.0; thet += 1.0) {
	          x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * 80.0);
	          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * 80.0);
	    
	          gl.glNormal3d(x, y, 1);
	          gl.glVertex3d (x, y, 1);
	      }
	      gl.glEnd();
	      
	      
	      //south face
	      gl.glBegin (GL_TRIANGLE_FAN);
	      gl.glNormal3d(0, 0, -1);
	      gl.glVertex3d (0.0, 0.0, -1.0);
	      for (double thet = -180.0; thet <= 180.0; thet += 1.0) {
	          x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * 80.0);
	          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * 80.0);
	    
	          gl.glNormal3d(x, y, -1);
	          gl.glVertex3d (x, y, -1);
	      }
	      gl.glEnd();

	      
	      //center
	      gl.glBegin(GL_QUAD_STRIP);
	      
	     
		      for (double thet = -180.0; thet <= 180.0; thet += 1.0) {
		    	  x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * 80.0);
		          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * 80.0);
		    
		          gl.glNormal3d(x, y, 0);
		          gl.glVertex3d (x, y, 1);
		          gl.glNormal3d(x, y, 0);
		          gl.glVertex3d (x, y, -1);		          
		      }
		  gl.glEnd();
	      
	      

	
	}
      
	private void sphere(GL2 gl) {
		
	      // Sphere material
	      float diffuse[] = {0.7f, 0.0f, 0.0f, 1.0f};
	      float ambient[] = {0.5f, 0.0f, 0.0f, 1.0f};
	      float specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
	      float shine[] = {127.0f};

	      // Set material
	      gl.glMaterialfv(GL_FRONT, GL_AMBIENT, ambient, 0);
	      gl.glMaterialfv(GL_FRONT, GL_DIFFUSE, diffuse, 0);
	      gl.glMaterialfv(GL_FRONT, GL_SPECULAR, specular, 0);
	      gl.glMaterialfv(GL_FRONT, GL_SHININESS, shine, 0);
		
		  double deg_to_rad = Math.PI/180.0;
	      double x,y,z;
	      
		// Quadrilateral strips
	      for (double phi = -80.0; phi < 80.0; phi += 10.0) {
	        gl.glBegin (GL_QUAD_STRIP);
	        for (double thet = -180.0; thet <= 180.0; thet += 10.0) {
	          x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * phi);
	          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * phi);
	          z = Math.sin (deg_to_rad * phi);
	          gl.glNormal3d(x, y,z);	
	          gl.glVertex3d (x, y, z);
	          
	          x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * (phi + 10.0));
	          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * (phi + 10.0));
	          z = Math.sin (deg_to_rad * (phi + 10.0));
	          gl.glNormal3d(x, y,z);	
	          gl.glVertex3d (x, y, z);
	        }
	        gl.glEnd();
	      }

	      // North pole
	      gl.glBegin (GL_TRIANGLE_FAN);
	      gl.glNormal3d(0, 0, 1);
	      gl.glVertex3d (0.0, 0.0, 1.0);
	      for (double thet = -180.0; thet <= 180.0; thet += 10.0) {
	          x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * 80.0);
	          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * 80.0);
	          z = Math.sin (deg_to_rad * 80.0);
	          gl.glNormal3d(x, y,z);
	          gl.glVertex3d (x, y, z);
	      }
	      gl.glEnd();

	      // South pole
	      gl.glBegin (GL_TRIANGLE_FAN);
	      gl.glNormal3d(0, 0, -1);
	      gl.glVertex3d (0.0, 0.0, -1.0);
	      for (double thet = -180.0; thet <= 180.0; thet += 10.0) {
	          x = Math.sin (deg_to_rad  * thet) * Math.cos (deg_to_rad * -80.0);
	          y = Math.cos (deg_to_rad * thet) * Math.cos (deg_to_rad * -80.0);
	          z = Math.sin (deg_to_rad * -80.0);
	          gl.glNormal3d(x, y,z);	
	          gl.glVertex3d (x, y, z);
	      }
	      gl.glEnd();
		
	}

	class Renderer implements GLEventListener, KeyListener {
		final GLUT glut = new GLUT(); //For invoking glut functions
		
		private double scale = 1;
		private int tx, ty, rx, ry;
		@Override
		public void display(GLAutoDrawable drawable) {
			GL2 gl = drawable.getGL().getGL2();
			
			gl.glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			
			gl.glMatrixMode(GL_MODELVIEW);
			gl.glLoadIdentity();
			
			/* Fill in transformation code here*/
			gl.glTranslated(tx, ty, 0); 	//tx and ty are modified by input in keypressed.
			
			gl.glRotated(rx, 1, 0, 0);
			
			gl.glRotated(ry, 0, 1, 0);
			
			gl.glScaled(scale, scale, scale);
	//		glut.glutSolidTeapot(1.0);
			
			customObject(gl);
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
			case KeyEvent.VK_N:
				scale /= 1.1;
				break;
			case KeyEvent.VK_RIGHT:
				tx += 1;
				break;
			case KeyEvent.VK_LEFT:
				tx -= 1;
				break;
			case KeyEvent.VK_UP:
				ty += 1;
				break;
			case KeyEvent.VK_DOWN:
				ty -= 1;
				break;
			case KeyEvent.VK_PAGE_UP:
				rx += 1;
				break;
			case KeyEvent.VK_PAGE_DOWN:
				rx -= 1;
				break;
			case KeyEvent.VK_HOME:
				ry += 1;
				break;
			case KeyEvent.VK_END:
				ry -= 1;
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

