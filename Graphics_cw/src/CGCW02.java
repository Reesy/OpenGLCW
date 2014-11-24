import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

import static javax.media.opengl.GL2.*;

public class CGCW02 extends JFrame{

	final GLJPanel canvas = new GLJPanel(); //Define a canvas 
	final FPSAnimator animator=new FPSAnimator(canvas, 60, true);;
	final Renderer renderer = new Renderer();

	public CGCW02(){
		add(canvas, java.awt.BorderLayout.CENTER); //Put the canvas in the centre of the frame
		canvas.addGLEventListener(renderer); //Set the canvas to listen GLEvents		
//		animator.add(canvas);

		setTitle("CGCW02");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		animator.start();
		canvas.requestFocus();
	}
	
	public static void main(String[] args) {
		CGCW02 frame = new CGCW02();

	}

	class Renderer implements GLEventListener {
		final GLU glu = new GLU(); //For invoking glu functions
		final GLUT glut = new GLUT(); //For invoking glut functions


		@Override
		public void display(GLAutoDrawable drawable) {
			GL2 gl = drawable.getGL().getGL2();

			gl.glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);

			gl.glMatrixMode(GL_MODELVIEW);
			gl.glLoadIdentity();

			scene(gl);
		}

		private void scene(GL2 gl) {
			// Put the cylinder into the scene and do appropriate transformation   
			// so that the sphere is on the top of the cylinder as shown in the 
			// description of the coursework
			sphere(gl);
		}

		private void cylinder(GL2 gl) {
			//Draw a cylinder with radius 1, and the axis length 2

			// The cylinder material properties should be different from the sphere.
			// You can define any material colours you like.
			// An example of cylinder material colours is similar to those of the sphere 
			// except that the values of the red and the green are swapped.
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
			
		      // Fill polygons for shading
		      gl.glPolygonMode (GL_FRONT, GL_FILL);

		      // Treat polygon front and back side equal (no two-sided polygons)
		      gl.glLightModeli (GL_LIGHT_MODEL_TWO_SIDE, GL_FALSE);

		      // Enable local viewer model for specular light
		      gl.glLightModeli (GL_LIGHT_MODEL_LOCAL_VIEWER, GL_TRUE);

		      // Enable smoooth shading (multi-coloured polygons)
		      gl.glShadeModel (GL_SMOOTH);

		      // Initialise lights
		      initLights (gl);			
		}

		private void initLights(GL2 gl) {
		      // Specify light emitted by light source 0
		      float diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
		      float ambient[] = {0.3f, 0.3f, 0.3f, 1.0f};
		      float specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
		      float attenuation[] = {1.0f};

		      // Light source 0 position
		      float light0Pos[] = {10f, 15f, 20f, 1.0f};

		      // Set light source 0 position
		      gl.glLightfv (GL_LIGHT0, GL_POSITION, light0Pos, 0);

		      // Enable lighting
		      gl.glEnable (GL_LIGHTING);

		      // Enable first light source
		      gl.glEnable (GL_LIGHT0);
		      // Set light emitted by light source 0
		      gl.glLightfv (GL_LIGHT0, GL_AMBIENT, ambient, 0);
		      gl.glLightfv (GL_LIGHT0, GL_DIFFUSE, diffuse, 0);
		      gl.glLightfv (GL_LIGHT0, GL_SPECULAR, specular, 0);
		      gl.glLightfv (GL_LIGHT0, GL_CONSTANT_ATTENUATION, attenuation, 0);
		 			
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
				gl.glOrtho(-4.0, 4.0, -4.0 * r, 4.0 * r, -4.0, 4.0);
			}
			else{
				r = (float) width / (float) height;
				gl.glOrtho(-4.0 * r, 4.0 * r, -4.0, 4.0,-4.0,4.0);
			}
		}
	}	
}