/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miproyectoid3;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class SplashWindow extends JWindow {
    
    public SplashWindow(URL filename, final Frame f, int waitTime) {
        this(filename, f, waitTime, true);
    }

    public SplashWindow(URL filename, final Frame f, int waitTime, final boolean visible) {
             //---- Código igual al anterior
        super(f);
        JLabel l = new JLabel(new ImageIcon(filename));
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));
        addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e)
                {
                    setVisible(false);
                    dispose();
                }
            });

             //----- tiempo que estara visible la ventana, en milisegundos
        final int pause = waitTime;

             //----- Este es el objeto que cierra la ventana
        final Runnable closerRunner = new Runnable() {
                public void run()
                {
                    setVisible(false);
                    f.setVisible(visible);

                    if ( !visible ) System.exit(0);
                }
            };

            //----- Este es el objeto que pone a dormir a closerRunner
            //----- y captura las excepciones;
        Runnable waitRunner = new Runnable() {
                public void run()
                {
                    try
                        {
                            Thread.sleep(pause);
                            SwingUtilities.invokeAndWait(closerRunner);
                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                            // can catch InvocationTargetException
                            // can catch InterruptedException
                        }
                }
            };

        setVisible(true);
            //----- aqui creamos y lanzamos el hilo
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
    }

}
