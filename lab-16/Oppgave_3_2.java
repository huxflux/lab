 import com.sun.opengl.util.GLUT;

 import java.awt.*; // klassene Color og Graphics
 import javax.swing.*; // klassene JFrame og JPanel
 import java.util.*;
 import javax.media.opengl.*; //JOGL klasser
 import javax.media.opengl.glu.*; //glu klasser
 import java.lang.Math.*;

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

 class Oppgave_3_2{
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
  		capabilities.setDoubleBuffered(false); //And double buffering
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
  		glu.gluPerspective(80.0, 1.0, 1.0, 15.0); // Spesifize the projection matrix (fov, w/h, near plane, far plane)
        glu.gluLookAt(0.0, 0.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
   		gl.glMatrixMode(GL.GL_MODELVIEW);
   		gl.glEnable(GL.GL_DEPTH_TEST);
   	}


   	public void reshape(GLAutoDrawable glDrawable, int i, int i1, int i2, int i3) {
   		// Has to be implementet due to the GLEventListener interface
   	}

float vinkel = 0.1f;
   	public void display(GLAutoDrawable glDrawable){

 		GL gl = glDrawable.getGL();
 		for (int i = 0; i < 10000; i++) {

 		drawGLScene(glDrawable);
 		glDrawable.swapBuffers();
 		gl.glFlush();
		}
 	}

 	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged){

 	}

 	static final float[][] hjornepunkter = {{-1.0f, -1.0f, 1.0f}, {1.0f, -1.0f, 1.0f}, {1.0f, 1.0f, 1.0f}, {-1.0f, 1.0f, 1.0f},
									   		{-1.0f, -1.0f, -1.0f}, {1.0f, -1.0f, -1.0f}, {1.0f, 1.0f, -1.0f}, {-1.0f, 1.0f, -1.0f}};
	static final float[][] farger = {{1.0f, 0.0f, 0.0f}, {0.0f, 1.0f, 0.0f}, {0.0f, 0.0f, 1.0f},
									 {1.0f, 1.0f, 0.0f}, {0.0f, 1.0f, 1.0f}, {1.0f, 0.0f, 1.0f}};


   	public void drawGLScene(GLAutoDrawable glDrawable) {
   		GL gl = glDrawable.getGL();
   		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		GLUT glut = new GLUT();
//		gl.glLoadIdentity();

		gl.glRotatef(vinkel, 0.0f, 1.0f, 0.0f);
//		vinkel += 0.1f;
		tegnKube(glDrawable);
	}

	public void tegnPolygon(GLAutoDrawable glDrawable, int a, int b, int c, int d){

		GL gl = glDrawable.getGL();
		gl.glColor3fv(farger[a],0);
		gl.glBegin(GL.GL_POLYGON);
	 	gl.glVertex3fv(hjornepunkter[a],0);
	 	gl.glVertex3fv(hjornepunkter[b],0);
	 	gl.glVertex3fv(hjornepunkter[c],0);
	 	gl.glVertex3fv(hjornepunkter[d],0);
	 	gl.glEnd();
	}

	public void tegnKube(GLAutoDrawable glDrawable) {
		tegnPolygon(glDrawable, 0, 1, 2, 3);
		tegnPolygon(glDrawable, 4, 5, 6, 7);
		tegnPolygon(glDrawable, 1, 5, 6, 2);
		tegnPolygon(glDrawable, 2, 6, 7, 3);
		tegnPolygon(glDrawable, 3, 0, 4, 7);
		tegnPolygon(glDrawable, 5, 4, 0, 1);
	}
}
