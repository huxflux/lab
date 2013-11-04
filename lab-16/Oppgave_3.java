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

 class Oppgave_3{
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
  		glu.gluPerspective(80.0, 1.0, 0.0, 15.0); // Spesifize the projection matrix (fov, w/h, near plane, far plane)
        glu.gluLookAt(0.0, 0.0, 30.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
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
		GLUT glut = new GLUT();

		float vinkel = 0;
		float vinkelStor = 0;
		float sirkelX = 0;
		float sirkelY = 0;
		float storSirkelX = 0;
		float storSirkelY = 0;
		float[] farger = {0.0f, 1.0f, 0.0f};

		gl.glLoadIdentity();
		for (int i = 0; i < 30; i++) {
			gl.glColor3f(farger[0], farger[1], farger[2]);
			farger[0] += 1.0f / 30.0f;
			farger[1] -= 1.0f / 30.0f;
			farger[2] += 1.0f / 30.0f;
			storSirkelX = 2.0f*(float)(Math.cos(Math.toRadians(vinkelStor)));
			storSirkelY = 2.0f*(float)(Math.sin(Math.toRadians(vinkelStor)));
			vinkelStor += 360.0f / 30.0f;
			gl.glTranslatef(storSirkelX, storSirkelY, 0.0f);
		gl.glBegin(GL.GL_LINE_LOOP);
			for (int j = 0; j < 100; j++) {
				sirkelX = (float)(Math.cos(Math.toRadians(vinkel)));
				sirkelY = (float)Math.sin(Math.toRadians(vinkel));
				gl.glVertex3f(sirkelX, sirkelY, 0.0f);
				vinkel += 360.0f / 100.0f;
			}

		gl.glEnd();
	}


/*		gl.glLoadIdentity();
		gl.glColor3f(0.0f,1.0f,0.0f);
		gl.glTranslatef(0.0f, 0.0f, -10.0f);
		gl.glRotatef(45.0f, 1.0f, 1.0f, 1.0f);
		glut.glutWireCube(2.0f);


		gl.glLoadIdentity();
		gl.glColor3f(0.0f,1.0f,0.0f);
		gl.glRotatef(45.0f, 1.0f, 1.0f, 1.0f);
		gl.glTranslatef(0.0f, 0.0f, -10.0f);
		glut.glutWireCube(2.0f);

		gl.glLoadIdentity();
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glScalef(5.0f, 5.0f, 5.0f);
		gl.glTranslatef(0.0f, 0.0f, -10.0f);
		glut.glutWireCube(2.0f);

		gl.glLoadIdentity();
		gl.glTranslatef(1.0f, 1.0f, -10.0f);
		gl.glScalef(5.0f, 5.0f, 5.0f);
		glut.glutWireCube(2.0f);

//		gl.glColor3f(0.0f,1.0f,1.0f);
//		gl.glTranslatef(0.0f, 0.0f, -1.0f);
//		glut.glutWireCube(2.0f); */
	}
}
