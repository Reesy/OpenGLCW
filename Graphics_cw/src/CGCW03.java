import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

import static javax.media.opengl.GL.GL_LINEAR;
import static javax.media.opengl.GL.GL_RGB;
import static javax.media.opengl.GL.GL_TEXTURE_2D;
import static javax.media.opengl.GL.GL_TEXTURE_MAG_FILTER;
import static javax.media.opengl.GL.GL_TEXTURE_MIN_FILTER;
import static javax.media.opengl.GL.GL_UNSIGNED_BYTE;
import static javax.media.opengl.GL2.*;
import static javax.media.opengl.GL2GL3.GL_BGR;
import static javax.media.opengl.GL2GL3.GL_QUADS;

public class CGCW03 extends JFrame{

	final GLJPanel canvas = new GLJPanel(); //Define a canvas 
	final FPSAnimator animator=new FPSAnimator(canvas, 60, true);;
	final Renderer renderer = new Renderer();

    public CGCW03() {
        add(canvas, java.awt.BorderLayout.CENTER); //Put the canvas in the centre of the frame
        canvas.addGLEventListener(renderer); // Listen for openGL events on the canvas

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit when click close
        setSize(500, 500);  //set the window size
        setTitle("CGCW03"); //window title

        setVisible(true); // Display the frame

        animator.start();
		canvas.requestFocus();
    }

    public static void main(String[] args) {
        CGCW03 frame = new CGCW03();		// TODO Auto-generated method stub

	}

    class Renderer implements GLEventListener {

        ByteBuffer texImg;
        private int texWidth, texHeight;
        private int texName[] = new int[1];
		@Override
		public void display(GLAutoDrawable drawable) {
			GL2 gl = drawable.getGL().getGL2();

			gl.glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);

			gl.glMatrixMode(GL_MODELVIEW);
			gl.glLoadIdentity();

			gl.glRotated(30, 1, 1, 1);

			//Step 4: Draw the scene suppling both texture and geometric coordinates
			//Add texture coordinates here
			gl.glBegin(GL_QUADS);
	            gl.glNormal3f(1.0f, 0.0f, 0.0f);
	            gl.glColor3d(0, 1, 0);
	            gl.glTexCoord2f(1.0f, 0.0f); gl.glVertex3f(1.0f, 1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 0.0f); gl.glVertex3f(1.0f, -1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 1.0f); gl.glVertex3f(1.0f, -1.0f, -1.0f);
	            gl.glTexCoord2f(1.0f, 1.0f); gl.glVertex3f(1.0f, 1.0f, -1.0f);
	
	            gl.glNormal3f(-1.0f, 0.0f, 0.0f);
	            gl.glTexCoord2f(1.0f, 0.0f);  gl.glVertex3f(-1.0f, 1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 0.0f);  gl.glVertex3f(-1.0f, 1.0f, -1.0f);
	            gl.glTexCoord2f(0.0f, 1.0f);  gl.glVertex3f(-1.0f, -1.0f, -1.0f);
	            gl.glTexCoord2f(1.0f, 1.0f);  gl.glVertex3f(-1.0f, -1.0f, 1.0f);
	
	            gl.glNormal3f(0.0f, 1.0f, 0.0f);
	            gl.glTexCoord2f(1.0f, 0.0f);   gl.glVertex3f(1.0f, 1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 0.0f);   gl.glVertex3f(1.0f, 1.0f, -1.0f);
	            gl.glTexCoord2f(0.0f, 1.0f);   gl.glVertex3f(-1.0f, 1.0f, -1.0f);
	            gl.glTexCoord2f(1.0f, 1.0f);   gl.glVertex3f(-1.0f, 1.0f, 1.0f);
	
	            gl.glNormal3f(0.0f, -1.0f, 0.0f);
	            gl.glTexCoord2f(1.0f, 0.0f);   gl.glVertex3f(1.0f, -1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 0.0f);   gl.glVertex3f(-1.0f, -1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 1.0f);   gl.glVertex3f(-1.0f, -1.0f, -1.0f);
	            gl.glTexCoord2f(1.0f, 1.0f);   gl.glVertex3f(1.0f, -1.0f, -1.0f);
	
	            gl.glNormal3f(0.0f, 0.0f, 1.0f);
	            gl.glTexCoord2f(1.0f, 0.0f);  gl.glVertex3f(1.0f, 1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 0.0f);  gl.glVertex3f(-1.0f, 1.0f, 1.0f);
	            gl.glTexCoord2f(0.0f, 1.0f);  gl.glVertex3f(-1.0f, -1.0f, 1.0f);
	            gl.glTexCoord2f(1.0f, 1.0f);  gl.glTexCoord2f(1.0f, 1.0f);  gl.glVertex3f(1.0f, -1.0f, 1.0f);
	
	            gl.glNormal3f(0.0f, 0.0f, -1.0f);
	            gl.glTexCoord2f(1.0f, 0.0f);   gl.glVertex3f(1.0f, 1.0f, -1.0f);
	            gl.glTexCoord2f(0.0f, 0.0f);   gl.glVertex3f(1.0f, -1.0f, -1.0f);
	            gl.glTexCoord2f(0.0f, 1.0f);   gl.glVertex3f(-1.0f, -1.0f, -1.0f);
	            gl.glTexCoord2f(1.0f, 1.0f);   gl.glVertex3f(-1.0f, 1.0f, -1.0f);
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
			
			gl.glEnable(GL_LIGHT0);		
			gl.glEnable(GL_LIGHTING);			

	        //Step 0: read in texture image
			//Please note the texture image "Welsh Dragon.jpg" should be in the current directory
	        try {
	            texImg = readImage("WelshDragon.jpg");
	        } catch (IOException ex) {
//	            Logger.getLogger(CG0T.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        // Step 1: Create a texture object and specify a texture for that object
	        // Step 2: Indicate how the texture is to be applied to each pixel
	        // Step 3: Enable texture mapping
	        
	        
	        
	        gl.glGenTextures(1, texName, 0);
	        gl.glBindTexture(GL_TEXTURE_2D, texName[0]);
	        gl.glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, texWidth, texHeight,   0, GL_BGR, GL_UNSIGNED_BYTE, texImg);  // specify texture image

	
	        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);  //must be specified
	        gl.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);  //must be specified

	        gl.glEnable(GL_TEXTURE_2D); 

		}

	   private ByteBuffer readImage(String filename) throws IOException {

	        ByteBuffer imgbuf;
	        BufferedImage img = ImageIO.read(new FileInputStream(filename));

	        texWidth = img.getWidth();
	        texHeight = img.getHeight();
	        DataBufferByte datbuf = (DataBufferByte) img.getData().getDataBuffer();
	        imgbuf = ByteBuffer.wrap(datbuf.getData());
	        return imgbuf;
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
    }
	
}
