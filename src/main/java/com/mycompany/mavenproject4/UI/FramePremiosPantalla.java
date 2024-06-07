/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject4.UI;

import com.mycompany.mavenproject4.Premios;
import com.mycompany.mavenproject4.ServicioAplicacion;
import com.mycompany.mavenproject4.SideMenuPanel;
import com.mycompany.mavenproject4.Usuario;
import com.mycompany.mavenproject4.UsuarioPerteneceFamilia;
import com.mycompany.mavenproject4.UsuarioPerteneceFamiliaPK;
import com.mycompany.mavenproject4.UsuarioReclamaPremios;
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
public class FramePremiosPantalla extends javax.swing.JFrame {

    private SideMenuPanel sp;
    private int menuInt = 1;
    private UsuarioPerteneceFamilia upf;
    private int idFamilia;
    private ServicioAplicacion servicio;
    private Usuario usuarioLogeado;

    /**
     * Creates new form FramePremiosPantalla
     */
    public FramePremiosPantalla(UsuarioPerteneceFamilia upf, Usuario usuarioLogeado) {
        initComponents();
        this.servicio = new ServicioAplicacion();
        this.idFamilia = upf.getIdFamilia();
        this.upf = upf;
        this.usuarioLogeado = usuarioLogeado;
        sp = new SideMenuPanel(this);
        sp.setMain(mainPanel);
        sp.setSide(sidebar);
        sp.setMinWidth(50);//borde restante al ocultar
        sp.setMaxWidth(160);//cuanto ocupa abierto
        sp.setMainAnimation(false);
        sp.setSpeed(0);
        sp.setResponsiveMinWidth(600);
        sp.openMenu();
        cargarPremios(idFamilia);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        BtnMenu = new javax.swing.JButton();
        BtnTareas = new javax.swing.JButton();
        BtnPremiosAct = new javax.swing.JButton();
        BtnTareasEntregadas = new javax.swing.JButton();
        BtnCambiarFam = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        BtnNotis = new javax.swing.JButton();
        BtnAñadirPremios = new javax.swing.JButton();
        BtnEditarPremio = new javax.swing.JButton();
        BtnActivosEnLaFamilia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabPremios = new javax.swing.JTable();
        BtnReclamarPremio = new javax.swing.JButton();

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

        BtnTareas.setBackground(new java.awt.Color(0, 30, 54));
        BtnTareas.setForeground(new java.awt.Color(255, 255, 255));
        BtnTareas.setText("Tareas");
        BtnTareas.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnTareas.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTareasActionPerformed(evt);
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

        BtnAñadirPremios.setBackground(new java.awt.Color(0, 30, 54));
        BtnAñadirPremios.setForeground(new java.awt.Color(255, 255, 255));
        BtnAñadirPremios.setText("Añadir Premios");
        BtnAñadirPremios.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnAñadirPremios.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnAñadirPremios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAñadirPremiosActionPerformed(evt);
            }
        });

        BtnEditarPremio.setBackground(new java.awt.Color(0, 30, 54));
        BtnEditarPremio.setForeground(new java.awt.Color(255, 255, 255));
        BtnEditarPremio.setText("Edirar Premios");
        BtnEditarPremio.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnEditarPremio.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnEditarPremio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarPremioActionPerformed(evt);
            }
        });

        BtnActivosEnLaFamilia.setBackground(new java.awt.Color(0, 30, 54));
        BtnActivosEnLaFamilia.setForeground(new java.awt.Color(255, 255, 255));
        BtnActivosEnLaFamilia.setText("Activos por la Familia");
        BtnActivosEnLaFamilia.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnActivosEnLaFamilia.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnActivosEnLaFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActivosEnLaFamiliaActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnTareasEntregadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPremiosAct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnTareas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnNotis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAñadirPremios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEditarPremio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnActivosEnLaFamilia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnTareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnTareasEntregadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPremiosAct)
                .addGap(12, 12, 12)
                .addComponent(BtnNotis)
                .addGap(41, 41, 41)
                .addComponent(BtnAñadirPremios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnEditarPremio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnActivosEnLaFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCambiarFam)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 30, 54));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PREMIOS");

        jScrollPane1.setBackground(new java.awt.Color(226, 226, 226));

        TabPremios.setBackground(new java.awt.Color(226, 226, 226));
        TabPremios.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        TabPremios.setForeground(new java.awt.Color(0, 30, 54));
        TabPremios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabPremios);

        BtnReclamarPremio.setBackground(new java.awt.Color(0, 30, 54));
        BtnReclamarPremio.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        BtnReclamarPremio.setForeground(new java.awt.Color(255, 255, 255));
        BtnReclamarPremio.setText("Reclamar premio");
        BtnReclamarPremio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReclamarPremioActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnReclamarPremio, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnReclamarPremio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            this.BtnTareas.setVisible(true);
            this.BtnPremiosAct.setVisible(true);
            this.BtnNotis.setVisible(true);
            this.BtnTareasEntregadas.setVisible(true);
            this.BtnAñadirPremios.setVisible(true);
            this.BtnEditarPremio.setVisible(true);
            this.BtnCambiarFam.setVisible(true);
            this.BtnCerrarSesion.setVisible(true);
            this.BtnActivosEnLaFamilia.setVisible(true);

            this.menuInt = 1;
        } else {
            sp.closeMenu();
            this.BtnTareas.setVisible(false);
            this.BtnPremiosAct.setVisible(false);
            this.BtnNotis.setVisible(false);
            this.BtnTareasEntregadas.setVisible(false);
            this.BtnAñadirPremios.setVisible(false);
            this.BtnEditarPremio.setVisible(false);
            this.BtnCambiarFam.setVisible(false);
            this.BtnCerrarSesion.setVisible(false);
            this.BtnActivosEnLaFamilia.setVisible(false);

            this.menuInt = 0;

        }
    }//GEN-LAST:event_BtnMenuActionPerformed

    private void BtnTareasEntregadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasEntregadasActionPerformed
        new FrameTareasHechas(upf, usuarioLogeado).setVisible(true); //
        this.dispose();
    }//GEN-LAST:event_BtnTareasEntregadasActionPerformed

    private void BtnReclamarPremioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReclamarPremioActionPerformed
        int indicePremioSelected = TabPremios.getSelectedRow();
        if (indicePremioSelected == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un premio para reclamar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dniUsuario = usuarioLogeado.getDni();
        List<Premios> premios = servicio.obtenerPremiosActivosPorFamilia(idFamilia);

        if (indicePremioSelected >= 0 && indicePremioSelected < premios.size()) {
            Premios premioSeleccionado = premios.get(indicePremioSelected);
            int puntosNecesarios = premioSeleccionado.getPuntosRequeridos();

            // Buscar los puntos actuales del usuario
            UsuarioPerteneceFamilia upf = servicio.findUsuarioPerteneceFamilia(new UsuarioPerteneceFamiliaPK(dniUsuario, idFamilia));
            if (upf != null && upf.getPuntos() >= puntosNecesarios) {
                Date fechaActual = new Date();

                UsuarioReclamaPremios premioReclamado = new UsuarioReclamaPremios();
                premioReclamado.setDni(dniUsuario);
                premioReclamado.setIdPremio(premioSeleccionado.getIdPremio());
                premioReclamado.setReclamado(fechaActual);
                premioReclamado.setActivo(true);

                // Actualizar puntos del usuario
                upf.setPuntos(upf.getPuntos() - puntosNecesarios);
                try {
                    servicio.editUsuarioPerteneceFamilia(upf);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al reclamar el premio.", "No se pudo actualizar la base de datos", JOptionPane.ERROR_MESSAGE);
                }

                // Registrar la reclamación del premio
                servicio.crearUsuarioReclamaPremio(premioReclamado);

                JOptionPane.showMessageDialog(this, "Premio reclamado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No tiene suficientes puntos para reclamar este premio.", "Puntos Insuficientes", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selección de premio inválida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnReclamarPremioActionPerformed

    private void BtnNotisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNotisActionPerformed
        new FrameNotificaciones(upf, usuarioLogeado).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnNotisActionPerformed

    private void BtnAñadirPremiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAñadirPremiosActionPerformed
        new FrameAddPremio(idFamilia, this).setVisible(true); //
    }//GEN-LAST:event_BtnAñadirPremiosActionPerformed

    private void BtnEditarPremioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarPremioActionPerformed
        int indicePremioSeleccionado = TabPremios.getSelectedRow();
        Premios premioSeleccionado;
        if (indicePremioSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un premio para editar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dniUsuario = usuarioLogeado.getDni();
        List<Premios> premios = servicio.obtenerPremiosActivosPorFamilia(idFamilia);

        if (indicePremioSeleccionado >= 0 && indicePremioSeleccionado < premios.size()) {
            premioSeleccionado = premios.get(indicePremioSeleccionado);

            Date fechaActual = new Date();

            Premios PremioSeleccionado = new Premios();

            new FrameAdmPremio(upf, usuarioLogeado, premioSeleccionado, this).setVisible(true);

        }
    }//GEN-LAST:event_BtnEditarPremioActionPerformed

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        new FrameLogin().setVisible(true); // 
        this.dispose();

    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnCambiarFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCambiarFamActionPerformed
        new FrameListaFams(usuarioLogeado.getDni()).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnCambiarFamActionPerformed

    private void BtnTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasActionPerformed
        new FramePantallaPrincipal(upf, usuarioLogeado).setVisible(true); // 
        this.dispose();
    }//GEN-LAST:event_BtnTareasActionPerformed

    private void BtnPremiosActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosActActionPerformed
        try {
            new FramePremiosActivos(usuarioLogeado, upf).setVisible(true); // 
        } catch (Exception ex) {
            Logger.getLogger(FramePremiosPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_BtnPremiosActActionPerformed

    private void BtnActivosEnLaFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActivosEnLaFamiliaActionPerformed
        try {
            new FramePremiosDeFamilia(usuarioLogeado, upf).setVisible(true); //
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FramePremiosPantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnActivosEnLaFamiliaActionPerformed

    /**
     * @param args the command line arguments
     */
    void cargarPremios(int idFamilia) {
        List<Premios> premios = servicio.obtenerPremiosActivosPorFamilia(idFamilia);
        DefaultTableModel model = (DefaultTableModel) TabPremios.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Premios premio : premios) {
            model.addRow(new Object[]{premio.getNombre(), premio.getPuntosRequeridos(), premio.getDescripcion()});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActivosEnLaFamilia;
    private javax.swing.JButton BtnAñadirPremios;
    private javax.swing.JButton BtnCambiarFam;
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnEditarPremio;
    private javax.swing.JButton BtnMenu;
    private javax.swing.JButton BtnNotis;
    private javax.swing.JButton BtnPremiosAct;
    private javax.swing.JButton BtnReclamarPremio;
    private javax.swing.JButton BtnTareas;
    private javax.swing.JButton BtnTareasEntregadas;
    private javax.swing.JTable TabPremios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
