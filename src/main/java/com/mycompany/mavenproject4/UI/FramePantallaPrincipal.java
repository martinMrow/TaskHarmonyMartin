/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject4.UI;

import com.mycompany.mavenproject4.ServicioAplicacion;
import com.mycompany.mavenproject4.SideMenuPanel;
import com.mycompany.mavenproject4.Tareas;
import com.mycompany.mavenproject4.Usuario;
import com.mycompany.mavenproject4.UsuarioHaceTareas;
import com.mycompany.mavenproject4.UsuarioPerteneceFamilia;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tetra
 */
public class FramePantallaPrincipal extends javax.swing.JFrame {

    private SideMenuPanel sp;
    private int menuInt = 1;
    private UsuarioPerteneceFamilia upf;
    private int idFamilia;
    private ServicioAplicacion servicio;
    private Usuario usuarioLogeado;

    /**
     * Creates new form FramePantallaPrincipal
     *
     * @param upf
     * @param usuarioLogeado
     */
    public FramePantallaPrincipal(UsuarioPerteneceFamilia upf, Usuario usuarioLogeado) {
        initComponents();
        this.usuarioLogeado = usuarioLogeado;
        this.servicio = new ServicioAplicacion();
        this.upf = upf;
        idFamilia = upf.getIdFamilia();

        sp = new SideMenuPanel(this);
        sp.setMain(mainPanel);
        sp.setSide(sidebar);
        sp.setMinWidth(50);//borde restante al ocultar
        sp.setMaxWidth(160);//cuanto ocupa abierto
        sp.setMainAnimation(false);
        sp.setSpeed(0);
        sp.setResponsiveMinWidth(600);
        sp.openMenu();
        cargarTareasDeFamilia(idFamilia);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlMenuLat = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        BtnMenu = new javax.swing.JButton();
        BtnPremiosTotal = new javax.swing.JButton();
        BtnPremiosAct = new javax.swing.JButton();
        BtnTareasEntregadas = new javax.swing.JButton();
        BtnCambiarFam = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        BtnNotis = new javax.swing.JButton();
        BtnAñadirTarea = new javax.swing.JButton();
        BtnEditarTarea = new javax.swing.JButton();
        BtnTareasPorFamilia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabTareas = new javax.swing.JTable();
        BtnMarcarComoHecha = new javax.swing.JButton();

        PnlMenuLat.setBackground(new java.awt.Color(0, 30, 54));

        javax.swing.GroupLayout PnlMenuLatLayout = new javax.swing.GroupLayout(PnlMenuLat);
        PnlMenuLat.setLayout(PnlMenuLatLayout);
        PnlMenuLatLayout.setHorizontalGroup(
            PnlMenuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 137, Short.MAX_VALUE)
        );
        PnlMenuLatLayout.setVerticalGroup(
            PnlMenuLatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        sidebar.setBackground(new java.awt.Color(0, 30, 54));
        sidebar.setToolTipText("");

        BtnMenu.setBackground(new java.awt.Color(0, 30, 54));
        BtnMenu.setForeground(new java.awt.Color(0, 30, 54));
        BtnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\java\\com\\mycompany\\mavenproject4\\imgs\\menu_15.png")); // NOI18N
        BtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMenuActionPerformed(evt);
            }
        });

        BtnPremiosTotal.setBackground(new java.awt.Color(0, 30, 54));
        BtnPremiosTotal.setForeground(new java.awt.Color(255, 255, 255));
        BtnPremiosTotal.setText("Premios");
        BtnPremiosTotal.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnPremiosTotal.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnPremiosTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPremiosTotalActionPerformed(evt);
            }
        });

        BtnPremiosAct.setBackground(new java.awt.Color(0, 30, 54));
        BtnPremiosAct.setForeground(new java.awt.Color(255, 255, 255));
        BtnPremiosAct.setText("Premios Activos");
        BtnPremiosAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPremiosActActionPerformed(evt);
            }
        });

        BtnTareasEntregadas.setBackground(new java.awt.Color(0, 30, 54));
        BtnTareasEntregadas.setForeground(new java.awt.Color(255, 255, 255));
        BtnTareasEntregadas.setText("Tareas Hechas");
        BtnTareasEntregadas.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnTareasEntregadas.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnTareasEntregadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTareasEntregadasActionPerformed(evt);
            }
        });

        BtnCambiarFam.setBackground(new java.awt.Color(0, 30, 54));
        BtnCambiarFam.setForeground(new java.awt.Color(255, 255, 255));
        BtnCambiarFam.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\java\\com\\mycompany\\mavenproject4\\imgs\\home (Custom).png")); // NOI18N
        BtnCambiarFam.setText("Cambiar familia");
        BtnCambiarFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCambiarFamActionPerformed(evt);
            }
        });

        BtnCerrarSesion.setBackground(new java.awt.Color(0, 30, 54));
        BtnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        BtnCerrarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\java\\com\\mycompany\\mavenproject4\\imgs\\settings (Custom).png")); // NOI18N
        BtnCerrarSesion.setText("Cerrar sesión");
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        BtnNotis.setBackground(new java.awt.Color(0, 30, 54));
        BtnNotis.setForeground(new java.awt.Color(255, 255, 255));
        BtnNotis.setText("Notificaciones");
        BtnNotis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNotisActionPerformed(evt);
            }
        });

        BtnAñadirTarea.setBackground(new java.awt.Color(0, 30, 54));
        BtnAñadirTarea.setForeground(new java.awt.Color(255, 255, 255));
        BtnAñadirTarea.setText("Añadir Tarea");
        BtnAñadirTarea.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnAñadirTarea.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnAñadirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAñadirTareaActionPerformed(evt);
            }
        });

        BtnEditarTarea.setBackground(new java.awt.Color(0, 30, 54));
        BtnEditarTarea.setForeground(new java.awt.Color(255, 255, 255));
        BtnEditarTarea.setText("Edirar Tarea");
        BtnEditarTarea.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnEditarTarea.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnEditarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarTareaActionPerformed(evt);
            }
        });

        BtnTareasPorFamilia.setBackground(new java.awt.Color(0, 30, 54));
        BtnTareasPorFamilia.setForeground(new java.awt.Color(255, 255, 255));
        BtnTareasPorFamilia.setText("Tareas Entregadas");
        BtnTareasPorFamilia.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnTareasPorFamilia.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnTareasPorFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTareasPorFamiliaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCambiarFam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnTareasEntregadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPremiosAct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPremiosTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnNotis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAñadirTarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEditarTarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnTareasPorFamilia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnTareasEntregadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPremiosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPremiosAct)
                .addGap(12, 12, 12)
                .addComponent(BtnNotis)
                .addGap(31, 31, 31)
                .addComponent(BtnAñadirTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEditarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnTareasPorFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCambiarFam)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 30, 54));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAREAS");

        jScrollPane1.setBackground(new java.awt.Color(226, 226, 226));

        TabTareas.setBackground(new java.awt.Color(226, 226, 226));
        TabTareas.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        TabTareas.setForeground(new java.awt.Color(0, 30, 54));
        TabTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Puntos", "Descripción"
            }
        ));
        jScrollPane1.setViewportView(TabTareas);

        BtnMarcarComoHecha.setBackground(new java.awt.Color(0, 30, 54));
        BtnMarcarComoHecha.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        BtnMarcarComoHecha.setForeground(new java.awt.Color(255, 255, 255));
        BtnMarcarComoHecha.setText("Marcar como hecha");
        BtnMarcarComoHecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMarcarComoHechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnMarcarComoHecha, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnMarcarComoHecha, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuActionPerformed

        if (this.menuInt == 0) {
            sp.openMenu();

            this.BtnPremiosTotal.setVisible(true);
            this.BtnPremiosAct.setVisible(true);
            this.BtnNotis.setVisible(true);
            this.BtnTareasEntregadas.setVisible(true);
            this.BtnAñadirTarea.setVisible(true);
            this.BtnEditarTarea.setVisible(true);
            this.BtnCambiarFam.setVisible(true);
            this.BtnCerrarSesion.setVisible(true);
            this.BtnTareasPorFamilia.setVisible(true);

            this.menuInt = 1;
        } else {
            sp.closeMenu();
            this.BtnPremiosTotal.setVisible(false);
            this.BtnPremiosAct.setVisible(false);
            this.BtnNotis.setVisible(false);
            this.BtnTareasEntregadas.setVisible(false);
            this.BtnAñadirTarea.setVisible(false);
            this.BtnEditarTarea.setVisible(false);
            this.BtnCambiarFam.setVisible(false);
            this.BtnCerrarSesion.setVisible(false);
            this.BtnTareasPorFamilia.setVisible(false);

            this.menuInt = 0;

        }
    }//GEN-LAST:event_BtnMenuActionPerformed

    private void BtnMarcarComoHechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMarcarComoHechaActionPerformed
        int indiceTareaSeleccionada = TabTareas.getSelectedRow();
        if (indiceTareaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para marcar como hecha.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dniUsuario = usuarioLogeado.getDni();
        List<Tareas> tareas = servicio.obtenerTareasActivasPorFamilia(idFamilia);

        if (indiceTareaSeleccionada >= 0 && indiceTareaSeleccionada < tareas.size()) {
            Tareas tareaSeleccionada = tareas.get(indiceTareaSeleccionada);

            Date fechaActual = new Date();  // Crea una instancia de Date para la fecha y hora actuales

            UsuarioHaceTareas nuevaTareaHecha = new UsuarioHaceTareas();
            nuevaTareaHecha.setDni(dniUsuario);
            nuevaTareaHecha.setIdTarea(tareaSeleccionada.getIdTarea());
            nuevaTareaHecha.setFechaRealizada(fechaActual);  // Pasa directamente el objeto Date
            nuevaTareaHecha.setCheckTarea(false);
            nuevaTareaHecha.setPuntosObtenidos(0);

            servicio.crearUsuarioHaceTarea(nuevaTareaHecha);
            JOptionPane.showMessageDialog(this, "Tarea marcada como hecha exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Selección de tarea inválida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnMarcarComoHechaActionPerformed

    private void BtnTareasEntregadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasEntregadasActionPerformed
        new FrameTareasHechas(upf, usuarioLogeado).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnTareasEntregadasActionPerformed

    private void BtnPremiosTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosTotalActionPerformed
        new FramePremiosPantalla(upf, usuarioLogeado).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnPremiosTotalActionPerformed

    private void BtnPremiosActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosActActionPerformed
        try {
            new FramePremiosActivos(usuarioLogeado, upf).setVisible(true); // 
        } catch (Exception ex) {
            Logger.getLogger(FramePantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_BtnPremiosActActionPerformed

    private void BtnNotisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNotisActionPerformed
        new FrameNotificaciones(upf, usuarioLogeado).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnNotisActionPerformed

    private void BtnAñadirTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAñadirTareaActionPerformed
        new FrameAddTarea(upf, usuarioLogeado, this).setVisible(true); // 
    }//GEN-LAST:event_BtnAñadirTareaActionPerformed

    private void BtnEditarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarTareaActionPerformed
        int indiceTareaSeleccionada = TabTareas.getSelectedRow();
        Tareas tareaSeleccionada;
        if (indiceTareaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para editar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dniUsuario = usuarioLogeado.getDni();
        List<Tareas> tareas = servicio.obtenerTareasActivasPorFamilia(idFamilia);

        if (indiceTareaSeleccionada >= 0 && indiceTareaSeleccionada < tareas.size()) {
            tareaSeleccionada = tareas.get(indiceTareaSeleccionada);

            Date fechaActual = new Date();  // Crea una instancia de Date para la fecha y hora actuales

            UsuarioHaceTareas nuevaTareaHecha = new UsuarioHaceTareas();
            nuevaTareaHecha.setDni(dniUsuario);
            nuevaTareaHecha.setIdTarea(tareaSeleccionada.getIdTarea());
            nuevaTareaHecha.setFechaRealizada(fechaActual);  // Pasa directamente el objeto Date
            nuevaTareaHecha.setCheckTarea(false);
            nuevaTareaHecha.setPuntosObtenidos(0);
            new FrameAdmTareas(upf, usuarioLogeado, tareaSeleccionada, this).setVisible(true);

        }
    }//GEN-LAST:event_BtnEditarTareaActionPerformed

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        new FrameLogin().setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnCambiarFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCambiarFamActionPerformed

        new FrameListaFams(usuarioLogeado.getDni()).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnCambiarFamActionPerformed

    private void BtnTareasPorFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasPorFamiliaActionPerformed
        new FrameTareasHechasPorFam(upf, usuarioLogeado).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnTareasPorFamiliaActionPerformed

    protected void cargarTareasDeFamilia(int idFamilia) {
        List<Tareas> tareas = servicio.obtenerTareasActivasPorFamilia(idFamilia);
        DefaultTableModel model = (DefaultTableModel) TabTareas.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Tareas tarea : tareas) {
            model.addRow(new Object[]{tarea.getNombre(), tarea.getPuntos(), tarea.getDescripcion()});
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAñadirTarea;
    private javax.swing.JButton BtnCambiarFam;
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnEditarTarea;
    private javax.swing.JButton BtnMarcarComoHecha;
    private javax.swing.JButton BtnMenu;
    private javax.swing.JButton BtnNotis;
    private javax.swing.JButton BtnPremiosAct;
    private javax.swing.JButton BtnPremiosTotal;
    private javax.swing.JButton BtnTareasEntregadas;
    private javax.swing.JButton BtnTareasPorFamilia;
    private javax.swing.JPanel PnlMenuLat;
    private javax.swing.JTable TabTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
