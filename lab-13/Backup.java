/*
 * Jogl2.java
 *
 * Draw a triangle, quad and a circle in OpenGL using JOGL 2.1.1
 *
 * O
 */

import javax.media.opengl.*;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;

public class Test {
    public static void main(String[] args) {
//        GLProfile glp = GLProfile.getDefault();
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);

        GLWindow window = GLWindow.create(caps);
        window.setSize(800, 600);
        window.setVisible(true);
        window.setTitle("JOGL 2.1.1 NEWT");

        window.addWindowListener(new WindowAdapter() {
            public void windowDestroyNotify(WindowEvent arg0) {
				System.out.println("test");
				System.exit(0);
            };
        });

        while (true) {

		}
    }
}