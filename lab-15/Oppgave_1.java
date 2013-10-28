/*
 * GrafikkEksempelOv1JOGL.java
 */

import java.awt.*; // klassene Color og Graphics
import javax.swing.*; // klassene JFrame og JPanel
import java.util.*;
import javax.media.opengl.*; //JOGL klasser
import javax.media.opengl.glu.*; //glu klasser

class Vindu extends JFrame {
	public Vindu(String tittel) {
 		setTitle(tittel);
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		TegningOv1_1JOGL tegningen = new TegningOv1_1JOGL(1600, 1280);
 		add(tegningen);
 		pack();
	}
}

/*Klassen som inneholder main*/

class Oppgave_1{
	public static void main(String[] args) {
 		Vindu etVindu = new Vindu("Oving 2: Transformasjoner");
 		etVindu.setVisible(true);
 	}
 }

class TegningOv1_1JOGL extends JPanel implements GLEventListener{


	private GLCanvas canvas;
	private float angle;
	private GLU glu = new GLU();

 	public TegningOv1_1JOGL(int width, int hight) {
 		super();

 		GLCapabilities capabilities = new GLCapabilities();
 		capabilities.setHardwareAccelerated(true); //We want hardware acceleration
 		capabilities.setDoubleBuffered(true); //And double buffering
 		canvas = new GLCanvas(capabilities);
 		canvas.addGLEventListener(this);
 		this.add(canvas);
 		this.setSize(width,hight);
 		canvas.setSize(width,hight); //We want the JPanel and the GLCanvas to have the same size
 		canvas.setVisible(true); //This is somehow necessary
 	}

	public void init(GLAutoDrawable glDrawable) {
 		GL gl = glDrawable.getGL(); //Get the GL object from glDrawable
 		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Sets the background color to black

 		gl.glMatrixMode(GL.GL_PROJECTION); // Select The Projection Matrix
 		gl.glLoadIdentity(); // Reset the view matrix to the identity matrix
 		glu.gluPerspective(45.0,1.25,2.0,9.0); // Spesifize the projection matrix (fov, w/h, near plane, far plane)

  		gl.glMatrixMode(GL.GL_MODELVIEW);
  	}


  	public void reshape(GLAutoDrawable glDrawable, int i, int i1, int i2, int i3) {
  		// Has to be implementet due to the GLEventListener interface
  	}


  	public void display(GLAutoDrawable glDrawable){
		GL gl = glDrawable.getGL();
		drawGLScene(glDrawable);
		glDrawable.swapBuffers();
		gl.glFlush();
	}

	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged){

	}

  	public void drawGLScene(GLAutoDrawable glDrawable) {

		int	antallPunkt = 8;

		float[] p0 = {0.0f, 2.0f, 0.0f};
		float[] p1 = {1.5f, 1.5f, 0.0f};
		float[] p2 = {2.0f, 0.0f, 0.0f};
		float[] p3 = {1.5f, -1.5f, 0.0f};
		float[] p4 = {0.0f, -2.0f, 0.0f};
		float[] p5 = {-1.5f, -1.5f, 0.0f};
		float[] p6 = {-2.0f, 0.0f, 0.0f};
		float[] p7 = {-1.5f, 1.5f, 0.0f};

		float[][] pTab = {p0, p1, p2, p3, p4, p5, p6, p7};

		int[] tegneMetode = {GL.GL_POINTS, GL.GL_LINES, GL.GL_LINE_STRIP, GL.GL_LINE_LOOP, GL.GL_TRIANGLES, GL.GL_TRIANGLE_STRIP,
							GL.GL_TRIANGLE_FAN, GL.GL_QUADS, GL.GL_QUAD_STRIP, GL.GL_POLYGON};

  		GL gl = glDrawable.getGL();
  		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
  		gl.glLoadIdentity(); 					// Reset The View matrix
  		gl.glTranslatef(-4.0f, 3.0f, -9.0f); 		//
  		gl.glColor3f(0.0f,1.0f,0.0f); 			// setter fargen til gr0nn!
		gl.glScalef(0.15f, 0.15f, 1.0f);
		gl.glPointSize(3);

		for (int i = 0; i < tegneMetode.length; i++) {
			gl.glBegin(tegneMetode[i]);
			for (int j = 0; j < antallPunkt; j++) {
				gl.glVertex3f(pTab[j][0], pTab[j][1], pTab[j][2]);
			}
			gl.glEnd();
			gl.glTranslatef(5.0f, 0.0f, 0.0f);
		}
	}
}