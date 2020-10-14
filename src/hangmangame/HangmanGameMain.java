/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

/**
 *
 * @author Maximiliano Herrera
 */
public class HangmanGameMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GameMediator mediator = new GameMediator();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame(mediator).setVisible(true);
            }
        });
    }
}
