/*
 * Jogl2.java
 *
 * Draw a triangle, quad and a circle in OpenGL using JOGL 2.1.1
 *
 * O
 */

//import javax.media.opengl.*;
//import com.jogamp.newt.event.WindowAdapter;
//import com.jogamp.newt.event.WindowEvent;
//import com.jogamp.newt.opengl.GLWindow;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;

public class Test implements GLEventListener {
    public static void main(String[] args) {
//        GLProfile glp = GLProfile.getDefault();
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);

        GLWindow window = GLWindow.create(caps);
        window.addGLEventListener(new Test());
        window.setSize(800, 600);
        window.setTitle("JOGL 2.1.1 NEWT");
        window.setVisible(true);
		animator.start();

final FPSAnimator animator = new FPSAnimator(window, 60, true);

        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
				System.out.println("test");
				System.exit(0);
            };
        });



	     /** Called back by the drawable to render OpenGL graphics */
	     @Override
	     public void display(GLAutoDrawable drawable) {
	         render(drawable);
	         update();
	     }

	     /** Render the shape (triangle) */
	     private void render(GLAutoDrawable drawable) {
	         GL2 gl = drawable.getGL().getGL2();

	         gl.glClear(GL.GL_COLOR_BUFFER_BIT);

	         // Draw a triangle
	         float sine = (float)Math.sin(theta);
	         float cosine = (float)Math.cos(theta);
	         gl.glBegin(GL.GL_TRIANGLES);
	         gl.glColor3f(1, 0, 0);
	         gl.glVertex2d(-cosine, -cosine);
	         gl.glColor3f(0, 1, 0);
	         gl.glVertex2d(0, cosine);
	         gl.glColor3f(0, 0, 1);
	         gl.glVertex2d(sine, -sine);
	         gl.glEnd();
	     }

	     /** Update the rotation angle after each frame refresh */
	     private void update() {
	         theta += 0.01;
	     }

	     /** Called back immediately after the OpenGL context is initialized */
	     @Override
	     public void init(GLAutoDrawable drawable) { }

	     /** Called back before the OpenGL context is destroyed. */
	     @Override
	     public void dispose(GLAutoDrawable drawable) { }

	     /** Called back by the drawable when it is first set to visible,
	     and during the first repaint after the it has been resized. */
	     @Override
	     public void reshape(GLAutoDrawable drawable, int x, int y, int weight, int height) { }
	 }
}
    }
}