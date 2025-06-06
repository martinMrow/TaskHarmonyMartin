/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject4.UI.tareas;

import com.mycompany.mavenproject4.ServicioAplicacion;
import com.mycompany.mavenproject4.SideMenuPanel;
import com.mycompany.mavenproject4.Tareas;
import com.mycompany.mavenproject4.TareasJpaController;
import com.mycompany.mavenproject4.UI.FrameListaFams;
import com.mycompany.mavenproject4.UI.FrameListaFams;
import com.mycompany.mavenproject4.UI.FrameLogin;
import com.mycompany.mavenproject4.UI.FrameLogin;
import com.mycompany.mavenproject4.UI.FrameNotificaciones;
import com.mycompany.mavenproject4.UI.FrameNotificaciones;
import com.mycompany.mavenproject4.UI.premios.FramePremiosActivos;
import com.mycompany.mavenproject4.UI.premios.FramePremiosActivos;
import com.mycompany.mavenproject4.UI.premios.FramePremiosPantalla;
import com.mycompany.mavenproject4.UI.premios.FramePremiosPantalla;
import com.mycompany.mavenproject4.Usuario;
import com.mycompany.mavenproject4.UsuarioHaceTareas;
import com.mycompany.mavenproject4.UsuarioPerteneceFamilia;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tetra
 */
public class FrameTareasHechas extends javax.swing.JFrame {

    private SideMenuPanel sp;
    private int menuInt = 1;
    private UsuarioPerteneceFamilia upf;
    private int idFamilia;
    private ServicioAplicacion servicio;
    private Usuario usuarioLogeado;
    JTable tabTareasHechas = new JTable();
    JScrollPane scrollPane = new JScrollPane(tabTareasHechas);

    /**
     * Creates new form FrameTareasHechas
     */
    public FrameTareasHechas(UsuarioPerteneceFamilia upf, Usuario usuarioLogeado) {
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
        cargarTareasHechas();
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icons8-familia-hombre-mujer-64.png")).getImage());

        } catch (Exception e) {
            System.out.println("Error al cargar el icono: " + e.getMessage());
        }
        this.setTitle("Task Harmony: Tareas realizadas");
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
        BtnTareas = new javax.swing.JButton();
        BtnCambiarFam = new javax.swing.JButton();
        BtnCerrarSesion = new javax.swing.JButton();
        BtnNotis = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabTareasHechas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        sidebar.setBackground(new java.awt.Color(0, 30, 54));
        sidebar.setToolTipText("");

        BtnMenu.setBackground(new java.awt.Color(0, 30, 54));
        BtnMenu.setForeground(new java.awt.Color(0, 30, 54));
        BtnMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\tetra\\Desktop\\tfg\\Persistencia-BranchDeMartinMVAR\\Persistencia-BranchDeMartinMVAR\\mavenproject4\\src\\main\\resources\\imgs\\menu_15.png")); // NOI18N
        BtnMenu.setToolTipText("Menú de opciones");
        BtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMenuActionPerformed(evt);
            }
        });

        BtnPremiosTotal.setBackground(new java.awt.Color(0, 30, 54));
        BtnPremiosTotal.setForeground(new java.awt.Color(255, 255, 255));
        BtnPremiosTotal.setText("Premios");
        BtnPremiosTotal.setToolTipText("Premios para reclamar");
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
        BtnPremiosAct.setToolTipText("Premios reclamados y activos");
        BtnPremiosAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPremiosActActionPerformed(evt);
            }
        });

        BtnTareas.setBackground(new java.awt.Color(0, 30, 54));
        BtnTareas.setForeground(new java.awt.Color(255, 255, 255));
        BtnTareas.setText("Tareas");
        BtnTareas.setToolTipText("Tareas dispuestas para realizar");
        BtnTareas.setMaximumSize(new java.awt.Dimension(114, 23));
        BtnTareas.setMinimumSize(new java.awt.Dimension(114, 23));
        BtnTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTareasActionPerformed(evt);
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
        BtnCerrarSesion.setToolTipText("Cerrar la sesion actual");
        BtnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarSesionActionPerformed(evt);
            }
        });

        BtnNotis.setBackground(new java.awt.Color(0, 30, 54));
        BtnNotis.setForeground(new java.awt.Color(255, 255, 255));
        BtnNotis.setText("Notificaciones");
        BtnNotis.setToolTipText("Notificaciones de tu familia");
        BtnNotis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNotisActionPerformed(evt);
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
                    .addComponent(BtnTareas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPremiosAct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnPremiosTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnNotis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(BtnPremiosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPremiosAct)
                .addGap(12, 12, 12)
                .addComponent(BtnNotis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCambiarFam)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 30, 54));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TAREAS HECHAS");

        jScrollPane1.setBackground(new java.awt.Color(226, 226, 226));

        TabTareasHechas.setBackground(new java.awt.Color(226, 226, 226));
        TabTareasHechas.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        TabTareasHechas.setForeground(new java.awt.Color(0, 30, 54));
        TabTareasHechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Puntos", "Comentarios", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(TabTareasHechas);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
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
            this.BtnTareas.setVisible(true);
            this.BtnNotis.setVisible(true);

            this.menuInt = 1;
        } else {
            sp.closeMenu();
            this.BtnPremiosAct.setVisible(false);
            this.BtnCambiarFam.setVisible(false);
            this.BtnCerrarSesion.setVisible(false);
            this.BtnPremiosTotal.setVisible(false);
            this.BtnTareas.setVisible(false);
            this.BtnNotis.setVisible(false);

            this.menuInt = 0;

        }
    }//GEN-LAST:event_BtnMenuActionPerformed

    private void BtnTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTareasActionPerformed
        FramePantallaPrincipal nuevaVentana = new FramePantallaPrincipal(upf, usuarioLogeado);
        nuevaVentana.setLocationRelativeTo(this); // Centrada respecto a la ventana actual
        nuevaVentana.setVisible(true);
        this.dispose(); // C
    }//GEN-LAST:event_BtnTareasActionPerformed

    private void BtnNotisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNotisActionPerformed
    FrameNotificaciones nuevaVentana = new FrameNotificaciones(upf, usuarioLogeado);
    nuevaVentana.setLocationRelativeTo(this); // Centrada respecto a la ventana actual
    nuevaVentana.setVisible(true);
    this.dispose(); // Cerrar ventana actual
    }//GEN-LAST:event_BtnNotisActionPerformed

    private void BtnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarSesionActionPerformed
    FrameLogin nuevaVentana = new FrameLogin();
    nuevaVentana.setLocationRelativeTo(this); // Centrada respecto a la ventana actual
    nuevaVentana.setVisible(true);
    this.dispose(); // Cerrar ventana actual
    }//GEN-LAST:event_BtnCerrarSesionActionPerformed

    private void BtnCambiarFamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCambiarFamActionPerformed
    FrameListaFams nuevaVentana = new FrameListaFams(usuarioLogeado.getDni());
    nuevaVentana.setLocationRelativeTo(this); // Centrada respecto a la ventana actual
    nuevaVentana.setVisible(true);
    this.dispose(); // Cerrar ventana actual
    }//GEN-LAST:event_BtnCambiarFamActionPerformed

    private void BtnPremiosTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosTotalActionPerformed
        FramePremiosPantalla nuevaVentana = new FramePremiosPantalla(upf, usuarioLogeado);
        nuevaVentana.setLocationRelativeTo(this); // Centrada respecto a la ventana actual
        nuevaVentana.setVisible(true);
        this.dispose(); // Cerrar ventana actual
    }//GEN-LAST:event_BtnPremiosTotalActionPerformed

    private void BtnPremiosActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPremiosActActionPerformed
        FramePremiosActivos nuevaVentana;
        try {
            nuevaVentana = new FramePremiosActivos(usuarioLogeado, upf);
            nuevaVentana.setLocationRelativeTo(this); // Centrada respecto a la ventana actual
            nuevaVentana.setVisible(true);
            this.dispose(); // Cerrar ventana actual
        } catch (Exception ex) {
            Logger.getLogger(FrameTareasHechas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BtnPremiosActActionPerformed
    private void actualizarTablaTareasHechas() {
        String idTarea;
        String nombreTarea;
        String comentario;
        String puntosObtenidos;
        List<UsuarioHaceTareas> listaTareasHechas = servicio.obtenerTareasRealizadasPorUsuarioEnFamilia(usuarioLogeado.getDni(), idFamilia);
        DefaultTableModel model = (DefaultTableModel) TabTareasHechas.getModel();
        model.setRowCount(0); // Limpia la tabla antes de añadir nuevas filas

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (UsuarioHaceTareas tareaHecha : listaTareasHechas) {
            idTarea = tareaHecha.getIdTarea();
            Tareas tareaPorId = servicio.findTareaById(idTarea);
            nombreTarea = tareaPorId.getNombre();
            comentario = tareaHecha.getComentarios();
            if (comentario == null) {
                comentario = "Aún no se han hecho comentarios";
            }

            model.addRow(new Object[]{
                nombreTarea,
                tareaHecha.getPuntosObtenidos(),
                comentario,
                sdf.format(tareaHecha.getFechaRealizada())
            });
        }
    }

    public void cargarTareasHechas() {
        actualizarTablaTareasHechas();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCambiarFam;
    private javax.swing.JButton BtnCerrarSesion;
    private javax.swing.JButton BtnMenu;
    private javax.swing.JButton BtnNotis;
    private javax.swing.JButton BtnPremiosAct;
    private javax.swing.JButton BtnPremiosTotal;
    private javax.swing.JButton BtnTareas;
    private javax.swing.JTable TabTareasHechas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidebar;
    // End of variables declaration//GEN-END:variables
}
