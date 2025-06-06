/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject4.UI;

import com.mycompany.mavenproject4.UI.premios.FramePremiosActivos;
import com.mycompany.mavenproject4.UI.premios.FramePremiosPantalla;
import com.mycompany.mavenproject4.UI.tareas.FramePantallaPrincipal;
import com.mycompany.mavenproject4.UI.tareas.FrameTareasHechas;
import com.mycompany.mavenproject4.Notificaciones;
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
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author tetra
 */
public class FrameNotificaciones extends javax.swing.JFrame {

    private SideMenuPanel sp;
    private int menuInt = 1;
    private UsuarioPerteneceFamilia upf;
    private int idFamilia;
    private ServicioAplicacion servicio;
    private Usuario usuarioLogeado;

    /**
     * Creates new form FrameNotificaciones
     */
    public FrameNotificaciones(UsuarioPerteneceFamilia upf, Usuario usuarioLogeado) {
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
        cargarNotificaciones();
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icons8-familia-hombre-mujer-64.png")).getImage());
        } catch (Exception e) {
            System.out.println("Error al cargar el icono: " + e.getMessage());
        }
        this.setTitle("Task Harmony: Notificaciones");
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
        BtnPremiosTotal = new javax.swing.JButton();
        BtnPremiosAct = new javax.swing.JButton();
        BtnTareasEntregadas = new javax.swing.JButton();
        BtnCambiarFam = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        BtnTareasTotales = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabNotificaciones = new javax.swing.JTable();
        BtnLeerYResponder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        sidebar.setBackground(new java.awt.Color(0, 30, 54));
        sidebar.setToolTipText("Menú de opciones");

        BtnMenu.setBackground(new java.awt.Color(0, 30, 54));
        BtnMenu.setForeground(new java.awt.Color(0, 30, 54));
        BtnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\resources\\imgs\\menu_15.png")); // NOI18N
        BtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMenuActionPerformed(evt);
            }
        });

        BtnPremiosTotal.setBackground(new java.awt.Color(0, 30, 54));
        BtnPremiosTotal.setForeground(new java.awt.Color(255, 255, 255));
        BtnPremiosTotal.setText("Premios");
        BtnPremiosTotal.setToolTipText("Premios disponibles para reclamar");
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
        BtnPremiosAct.setToolTipText("Premios activos reclamados por ti");
        BtnPremiosAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPremiosActActionPerformed(evt);
            }
        });

        BtnTareasEntregadas.setBackground(new java.awt.Color(0, 30, 54));
        BtnTareasEntregadas.setForeground(new java.awt.Color(255, 255, 255));
        BtnTareasEntregadas.setText("Tareas Hechas");
        BtnTareasEntregadas.setToolTipText("Tareas hechas por ti");
        BtnTareasEntregadas.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnTareasEntregadas.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnTareasEntregadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTareasEntregadasActionPerformed(evt);
            }
        });

        BtnCambiarFam.setBackground(new java.awt.Color(0, 30, 54));
        BtnCambiarFam.setForeground(new java.awt.Color(255, 255, 255));
        BtnCambiarFam.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\resources\\imgs\\home (Custom).png")); // NOI18N
        BtnCambiarFam.setText("Cambiar familia");
        BtnCambiarFam.setToolTipText("Seleccionar otra familia");
        BtnCambiarFam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCambiarFamActionPerformed(evt);
            }
        });

        BtnCerrarSesion.setBackground(new java.awt.Color(0, 30, 54));
        BtnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        BtnCerrarSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\resources\\imgs\\settings (Custom).png")); // NOI18N
        BtnCerrarSesion.setText("Cerrar sesión");
        BtnCerrarSesion.setToolTipText("Cerrar la sesión actual");
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        BtnTareasTotales.setBackground(new java.awt.Color(0, 30, 54));
        BtnTareasTotales.setForeground(new java.awt.Color(255, 255, 255));
        BtnTareasTotales.setText("Tareas");
        BtnTareasTotales.setToolTipText("Tareas disponibles para realizar");
        BtnTareasTotales.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnTareasTotales.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnTareasTotales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTareasTotalesActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnTareasTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPremiosTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnTareasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnTareasEntregadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPremiosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPremiosAct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCambiarFam)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 30, 54));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOTIFICACIONES");

        jScrollPane1.setBackground(new java.awt.Color(226, 226, 226));

        TabNotificaciones.setBackground(new java.awt.Color(226, 226, 226));
        TabNotificaciones.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        TabNotificaciones.setForeground(new java.awt.Color(0, 30, 54));
        TabNotificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Título", "Solicitante", "Fecha", "Leido"
            }
        ));
        jScrollPane1.setViewportView(TabNotificaciones);

        BtnLeerYResponder.setBackground(new java.awt.Color(0, 30, 54));
        BtnLeerYResponder.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        BtnLeerYResponder.setForeground(new java.awt.Color(255, 255, 255));
        BtnLeerYResponder.setText("Leer y responder");
        BtnLeerYResponder.setToolTipText("Leer la notificación seleccionada y responder");
        BtnLeerYResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLeerYResponderActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(0, 140, Short.MAX_VALUE)
                        .addComponent(BtnLeerYResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 144, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnLeerYResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

            this.BtnPremiosAct.setVisible(true);
            this.BtnCambiarFam.setVisible(true);
            this.BtnCerrarSesion.setVisible(true);
            this.BtnPremiosTotal.setVisible(true);
            this.BtnTareasEntregadas.setVisible(true);
            this.BtnTareasTotales.setVisible(true);

            this.menuInt = 1;
        } else {
            sp.closeMenu();
            this.BtnPremiosAct.setVisible(false);
            this.BtnCambiarFam.setVisible(false);
            this.BtnCerrarSesion.setVisible(false);
            this.BtnPremiosTotal.setVisible(false);
            this.BtnTareasEntregadas.setVisible(false);
            this.BtnTareasTotales.setVisible(false);

            this.menuInt = 0;

        }
    }//GEN-LAST:event_BtnMenuActionPerformed

    private void BtnPremiosTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosTotalActionPerformed
        FramePremiosPantalla frame = new FramePremiosPantalla(upf, usuarioLogeado);
        frame.setLocationRelativeTo(this);  // Posición relativa al padre
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnPremiosTotalActionPerformed

    private void BtnPremiosActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosActActionPerformed
        try {
            FramePremiosActivos frame = new FramePremiosActivos(usuarioLogeado, upf);
            frame.setLocationRelativeTo(this);  // Posición relativa al padre
            frame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FrameNotificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_BtnPremiosActActionPerformed

    private void BtnTareasEntregadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasEntregadasActionPerformed
        FrameTareasHechas frame = new FrameTareasHechas(upf, usuarioLogeado);
        frame.setLocationRelativeTo(this);  // Posición relativa al padre
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnTareasEntregadasActionPerformed

    private void BtnLeerYResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLeerYResponderActionPerformed
        int selectedRow = TabNotificaciones.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una notificación para leer.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) TabNotificaciones.getModel();
        Long idNotificacion = Long.valueOf(model.getValueAt(selectedRow, 0).toString()); // Asume que el ID está en la columna oculta

        Notificaciones notificacion = servicio.findNotificacion(idNotificacion);
        if (notificacion == null) {
            JOptionPane.showMessageDialog(this, "Notificación no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (notificacion.getLeido()) {
            // Mostrar sólo la notificación sin permitir la respuesta porque ya fue leída
            JOptionPane.showMessageDialog(this,
                    "Detalles de la notificación:\n\n"
                    + "Solicitante: " + notificacion.getDestinatario() + "\n"
                    + "Fecha: " + notificacion.getFechaHora() + "\n\n"
                    + "Esta notificación ya ha sido atendida.",
                    "Notificación Leída",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar el diálogo de respuesta
            int respuesta = JOptionPane.showOptionDialog(this,
                    "El usuario " + notificacion.getDestinatario() + " ha solicitado unirse a tu familia.\nFecha: " + notificacion.getFechaHora(),
                    "Responder Notificación",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Aceptar", "Denegar", "Salir"},
                    "Aceptar");

            switch (respuesta) {
                case JOptionPane.YES_OPTION: {
                    try {
                        servicio.aceptarSolicitud(notificacion.getDestinatario(), idFamilia);
                        notificacion.setLeido(true);
                        servicio.LeerNotificacion(notificacion);
                        cargarNotificaciones();

                    } catch (Exception ex) {
                        Logger.getLogger(FrameNotificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case JOptionPane.NO_OPTION:
                    servicio.denegarSolicitud(notificacion.getDestinatario(), idFamilia);
                    break;
                default:
                    // No hacer nada
                    break;
            }
        }
    }//GEN-LAST:event_BtnLeerYResponderActionPerformed

    private void BtnTareasTotalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasTotalesActionPerformed
        FramePantallaPrincipal frame = new FramePantallaPrincipal(upf, usuarioLogeado);
        frame.setLocationRelativeTo(this);  // Posición relativa al padre
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnTareasTotalesActionPerformed

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
        FrameLogin frame = new FrameLogin();
        frame.setLocationRelativeTo(this);  // Posición relativa al padre
        frame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnCambiarFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCambiarFamActionPerformed
        FrameListaFams frame = new FrameListaFams(usuarioLogeado.getDni());
        frame.setLocationRelativeTo(this);  // Posición relativa al padre
        frame.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_BtnCambiarFamActionPerformed

    /**
     * @param args the command line arguments
     */
    protected void cargarNotificaciones() {
        List<Notificaciones> notificaciones = servicio.obtenerNotificacionesPorAdmin(usuarioLogeado.getDni());
        DefaultTableModel model = (DefaultTableModel) TabNotificaciones.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Notificaciones notificacion : notificaciones) {
            model.addRow(new Object[]{
                notificacion.getId(), // Asumiendo que esto es el ID y quieres ocultarlo.
                notificacion.getTitulo(),
                notificacion.getDestinatario(),
                notificacion.getFechaHora(),
                notificacion.getLeido() ? "Leído" : "No Leído"
            });
        }

        // Ocultar la columna de ID gráficamente
        TableColumnModel columnModel = TabNotificaciones.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0); // Asumiendo que el ID está en la columna 0
        TabNotificaciones.removeColumn(idColumn); // Ocultar la columna de ID
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCambiarFam;
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnLeerYResponder;
    private javax.swing.JButton BtnMenu;
    private javax.swing.JButton BtnPremiosAct;
    private javax.swing.JButton BtnPremiosTotal;
    private javax.swing.JButton BtnTareasEntregadas;
    private javax.swing.JButton BtnTareasTotales;
    private javax.swing.JTable TabNotificaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
