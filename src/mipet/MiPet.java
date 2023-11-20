/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mipet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ethan Leiva
 */
public class MiPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Inicio formulario1;
                try {
                    formulario1 = new Inicio();
                    formulario1.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MiPet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
}
