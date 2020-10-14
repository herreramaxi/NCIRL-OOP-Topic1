/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author user
 */
public class KeyboardJComponent extends JComponent {

    public KeyboardJComponent() {
        super();
    }

    @Override
    public void paint(Graphics g) {
         super.paint(g);
         this.setLocation(50, 50);
        this.setSize(50, 50);
       
        g.setColor(Color.red);
        g.fillOval(50, 10, 150, 150);
    }
}
