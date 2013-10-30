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
 		TegningOv1_1JOGL tegningen = new TegningOv1_1JOGL(800, 640);
 		add(tegningen);
 		pack();
	}
}

/*Klassen som inneholder main*/

class GrafikkEksempelOv1JOGL{
	public static void main(String[] args) {
 		Vindu etVindu = new Vindu("V2005 Oving 1: Enkel grafikk");
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
 		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Sets the background color to white

 		gl.glMatrixMode(GL.GL_PROJECTION); // Select The Projection Matrix
 		gl.glLoadIdentity(); // Reset the view matrix to the identity matrix
 		glu.gluPerspective(60.0,1.0 , 1.0 ,9.0); // Spesifize the projection matrix (fov, w/h, near plane, far plane)

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
  		GL gl = glDrawable.getGL();
  		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
  		// and The Depth Buffer
  		gl.glLoadIdentity();
  		gl.glTranslatef(-3.0f,0.0f,-8.0f);
  		gl.glColor3f(1.0f,0.0f,0.0f);

  		gl.glBegin(GL.GL_TRIANGLES);
  			gl.glVertex3f(0.0f, 1.0f, 0.0f);
  			gl.glVertex3f(-1.0f, -1.0f, 0.0f);
  			gl.glVertex3f(1.0f,-1.0f,0.0f);
  		gl.glEnd();

		gl.glTranslatef(3.0f, 0.0f, 0.0f);

		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_TRIANGLES);
			gl.glVertex3f(-1.0f, -1.0f, 0.0f);
			gl.glVertex3f(-1.0f, 1.0f, 0.0f);
			gl.glVertex3f(1.0f, -1.0f, 0.0f);
		gl.glEnd();

		gl.glBegin(GL.GL_TRIANGLES);
			gl.glVertex3f(-1.0f, 1.0f, 0.0f);
			gl.glVertex3f(1.0f, 1.0f, 0.0f);
			gl.glVertex3f(1.0f, -1.0f, 0.0f);
		gl.glEnd();

		gl.glColor3f(0.0f, 0.0f, 1.0f);
		gl.glTranslatef(3.0f, 0.0f, 0.0f);

		gl.glBegin(GL.GL_LINE_LOOP);
			for(int i = 0; i < 360; i++){
				double radianer = i*(Math.PI/180);
				gl.glVertex2f((float) Math.cos(radianer),(float) Math.sin(radianer));
			}
		gl.glEnd();

  	}
}