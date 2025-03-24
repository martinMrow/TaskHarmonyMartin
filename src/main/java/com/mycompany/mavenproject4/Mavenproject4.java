/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenproject4;

import com.mycompany.mavenproject4.UI.FrameLogin;

/**
 *
 * @author administrador
 */
public class Mavenproject4 {

    public static void main(String[] args) throws Exception {

        // Crea y muestra el frame de inicio de sesión.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLogin().setVisible(true);
            }
        });
    }
}
