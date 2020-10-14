/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;

public class Keyboard  {

    private JFrame f = new JFrame("Keyboard");

    private JPanel keyboard = new JPanel();

    private static final String[][] key = {
        {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",},
        {"A", "S", "D", "F", "G", "H", "J", "K", "L",},
        {"Z", "X", "C", "V", "B", "N", "M"},};

    public Keyboard() {

        //Creation of keyboard is from stackoverflow
        //https://stackoverflow.com/questions/24622279/laying-out-a-keyboard-in-swing/24625704
        //I added the action listeners to each button
        keyboard.setLayout(new GridBagLayout());

        JPanel pRow;
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1d;

        for (int row = 0; row < key.length; ++row) {
            pRow = new JPanel(new GridBagLayout());

            c.gridy = row;

            for (int col = 0; col < key[row].length; ++col) {
                JButton buttom = new JButton(key[row][col]);

                buttom.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton1ActionPerformed(evt);
                    }
                });
                pRow.add(buttom);
            }
            keyboard.add(pRow, c);
        }

        f.add(keyboard);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        JButton button = (JButton) evt.getSource();

        if (button == null) {
            return;
        }

        String text = button.getText();

//TODO: Execure action
        button.setEnabled(false);
    }

    public JFrame getFrame() {
        return f;
    }
    
     public JPanel getPanel() {
        return keyboard;
    }

    public void launch() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
