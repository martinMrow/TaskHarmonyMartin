/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject4.UI;

import com.mycompany.mavenproject4.UI.tareas.FramePantallaPrincipal;
import com.mycompany.mavenproject4.Familia;
import com.mycompany.mavenproject4.FamiliaJpaController;
import com.mycompany.mavenproject4.ServicioAplicacion;
import com.mycompany.mavenproject4.Usuario;
import com.mycompany.mavenproject4.UsuarioJpaController;
import com.mycompany.mavenproject4.UsuarioPerteneceFamilia;
import com.mycompany.mavenproject4.UsuarioPerteneceFamiliaJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author tetra
 */
public class FrameListaFams extends javax.swing.JFrame {

    private DefaultListModel modeloLista;
    private ServicioAplicacion servicio;
    private int IDfam;
    private Familia familia;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadJPA");

    private FamiliaJpaController famCont = new FamiliaJpaController(emf);
    private UsuarioJpaController usuCont = new UsuarioJpaController(emf);
    private UsuarioPerteneceFamiliaJpaController upfCont = new UsuarioPerteneceFamiliaJpaController(emf);
    private Usuario usuarioLogeado;

    /**
     * Creates new form FrameListaFams
     */
    public FrameListaFams(String dniUsuario) {
        initComponents();  // Asegúrate de que todos los componentes están inicializados primero
        servicio = new ServicioAplicacion();
        usuarioLogeado = usuCont.findUsuario(dniUsuario);
        cargarFamilias(dniUsuario);  // Llama a cargarFamilias después de que todos los componentes estén listos
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icons8-familia-hombre-mujer-64.png")).getImage());
        } catch (Exception e) {
            System.out.println("Error al cargar el icono: " + e.getMessage());
        }
        this.setTitle("Task Harmony: Familias");
    }

    private void cargarFamilias(String dni) {
        List<UsuarioPerteneceFamilia> familias = servicio.obtenerFamiliasActivasPorUsuario(dni);
        modeloLista = new DefaultListModel();
        for (UsuarioPerteneceFamilia upf : familias) {
            IDfam = upf.getIdFamilia();
            familia = famCont.findFamiliaById(IDfam);
            modeloLista.addElement("Nombre: " + familia.getNombre() + " - Puntos: " + upf.getPuntos());
        }
        listaFamilias.setModel(modeloLista);  // Actualizar el JList con el modelo actualizado
    }

    public void procesarSolicitudUnirseAFamilia(String dniAdmin, Usuario user) {
        // Verifica si el dniAdmin corresponde a alguna familia existente
        Familia familia = famCont.findFamiliaByDniAdmin(dniAdmin);
        if (familia != null) {
            servicio.procesarSolicitudUnirseAFamilia(dniAdmin, user);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna familia con el DNI del administrador proporcionado.", "Familia No Encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaFamilias = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        BtnIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BtnCrearFam = new javax.swing.JButton();
        BtnSolicFam = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        BtnRecargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 226, 226));

        jPanel2.setBackground(new java.awt.Color(0, 30, 54));

        jLabel1.setBackground(new java.awt.Color(55, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TASK HARMONY");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        listaFamilias.setBackground(new java.awt.Color(255, 255, 255));
        listaFamilias.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        listaFamilias.setForeground(new java.awt.Color(0, 30, 54));
        listaFamilias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaFamilias);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        BtnIngresar.setBackground(new java.awt.Color(0, 30, 54));
        BtnIngresar.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        BtnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        BtnIngresar.setText("Entrar");
        BtnIngresar.setToolTipText("Entrar con la familia seleccionada");
        BtnIngresar.setAlignmentY(0.0F);
        BtnIngresar.setAutoscrolls(true);
        BtnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIngresarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 30, 54));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("¿No está tu familia?");

        BtnCrearFam.setBackground(new java.awt.Color(0, 30, 54));
        BtnCrearFam.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        BtnCrearFam.setForeground(new java.awt.Color(255, 255, 255));
        BtnCrearFam.setText("Crear una Familia");
        BtnCrearFam.setToolTipText("Crear una familia nueva a tu cargo");
        BtnCrearFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearFamActionPerformed(evt);
            }
        });

        BtnSolicFam.setBackground(new java.awt.Color(0, 30, 54));
        BtnSolicFam.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        BtnSolicFam.setForeground(new java.awt.Color(255, 255, 255));
        BtnSolicFam.setText("Solicitar unirse a una");
        BtnSolicFam.setToolTipText("Solicitar unirte a una familia existente");
        BtnSolicFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSolicFamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnCrearFam, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSolicFam, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                    .addComponent(BtnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCrearFam, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(BtnSolicFam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        BtnRecargar.setBackground(new java.awt.Color(0, 30, 54));
        BtnRecargar.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        BtnRecargar.setForeground(new java.awt.Color(255, 255, 255));
        BtnRecargar.setText("Refrescar");
        BtnRecargar.setToolTipText("Refrescar el listado de familias");
        BtnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnRecargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void solicitarUnirseAFamilia() {
        String dniAdmin = JOptionPane.showInputDialog(this, "Ingrese el DNI del Administrador de la Familia a la que desea unirse:", "Solicitud de Unión a Familia", JOptionPane.QUESTION_MESSAGE);
        if (dniAdmin != null && !dniAdmin.trim().isEmpty()) {
            procesarSolicitudUnirseAFamilia(dniAdmin.trim(), this.usuarioLogeado);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void BtnCrearFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearFamActionPerformed
        String nombreFamilia = JOptionPane.showInputDialog(this, "Ingrese el nombre de la familia que desea crear:");
        if (nombreFamilia != null && !nombreFamilia.trim().isEmpty()) {
            procesarCreacionFamilia(nombreFamilia.trim());

            Familia familia = famCont.findFamiliaByDniAdmin(usuarioLogeado.getDni());
            if (familia != null) {
                UsuarioPerteneceFamilia upf = new UsuarioPerteneceFamilia();
                upf.setIsActive(true);  // Activar la relación
                upf.setPuntos(0);     // Establecer puntos iniciales
                upf.setIdFamilia(familia.getIdFamilia());
                upf.setDni(usuarioLogeado.getDni());
                try {
                    upfCont.create(upf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Relacion UPF fallida.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido para la familia.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnCrearFamActionPerformed

    private void BtnSolicFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSolicFamActionPerformed
        BtnSolicFam.addActionListener(e -> solicitarUnirseAFamilia());

    }//GEN-LAST:event_BtnSolicFamActionPerformed

    private void procesarCreacionFamilia(String nombreFamilia) {
        String dniUsuario = this.usuarioLogeado.getDni(); // Método para obtener el DNI del usuario actual

        // Verifica si el usuario ya administra alguna familia
        Familia familiaExistente = servicio.findFamiliaByDniAdmin(dniUsuario);
        if (familiaExistente != null) {
            JOptionPane.showMessageDialog(this, "Ya administra una familia y no puede crear otra.", "Operación no permitida", JOptionPane.WARNING_MESSAGE);
        } else {
            // Crear nueva familia
            Familia nuevaFamilia = new Familia(dniUsuario, nombreFamilia);
            servicio.createFamilia(nuevaFamilia);
            JOptionPane.showMessageDialog(this, "Familia creada exitosamente con el nombre: " + nombreFamilia, "Familia Creada", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void BtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIngresarActionPerformed
        int familiaSeleccionada = this.listaFamilias.getSelectedIndex();
        if (familiaSeleccionada != -1) { // Asegurarse de que haya una selección válida
            List<UsuarioPerteneceFamilia> familias = servicio.obtenerFamiliasActivasPorUsuario(usuarioLogeado.getDni());

            // Comprobar si el índice seleccionado es válido para la lista
            if (familiaSeleccionada < familias.size()) {
                UsuarioPerteneceFamilia upf = familias.get(familiaSeleccionada);

                FramePantallaPrincipal framePantallaPrincipal = new FramePantallaPrincipal(upf, usuarioLogeado);
                framePantallaPrincipal.setLocationRelativeTo(this); // Center relative to this window
                framePantallaPrincipal.setVisible(true); // Asumiendo que existe una clase MainFrame
                this.dispose(); // Cierra la ventana de login
            } else {
                JOptionPane.showMessageDialog(this, "Selección no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una familia de la lista.", "Ninguna Familia Seleccionada", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BtnIngresarActionPerformed

    private void BtnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRecargarActionPerformed
        cargarFamilias(usuarioLogeado.getDni());  // Llama a cargarFamilias después de que todos los componentes estén listos
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRecargarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrearFam;
    private javax.swing.JButton BtnIngresar;
    private javax.swing.JButton BtnRecargar;
    private javax.swing.JButton BtnSolicFam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaFamilias;
    // End of variables declaration//GEN-END:variables
}
