package khushfproject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class NavForm extends javax.swing.JFrame 
{

    private BufferedImage img;
    public static JDesktopPane jdpDesktop;
    public NavForm(LoginForm log) 
    {
        log.setVisible(false);
        initComponents();
        this.setLocationRelativeTo(null);
        try
        {
            img = ImageIO.read(new File("C:\\Users\\Nikhil\\Desktop\\KhushFProject\\src\\cloud.jpg"));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        jdpDesktop = new JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                double scaleFactor = Math.min(1d, getScaleFactorToFit(new Dimension(img.getWidth(), img.getHeight()), getSize()));
                int scaleWidth = (int) Math.round(img.getWidth() * scaleFactor);
                int scaleHeight = (int) Math.round(img.getHeight() * scaleFactor);
                Image scaled = img.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
                int width = getWidth() - 1;
                int height = getHeight() - 1;
                int x = (width - scaled.getWidth(this)) / 2;
                int y = (height - scaled.getHeight(this)) / 2;
                g.drawImage(scaled, x, y, this);
            }
        @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        };
        this.setContentPane(jdpDesktop);
    }

    private NavForm() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public double getScaleFactor(int iMasterSize, int iTargetSize)
    {
        double dScale = 1;
        if (iMasterSize > iTargetSize)
        {
            dScale = (double) iTargetSize / (double) iMasterSize;
        } 
        else
        {
            dScale = (double) iTargetSize / (double) iMasterSize;
        }
        return dScale;
    }
 public double getScaleFactorToFit(Dimension original, Dimension toFit)
    {
        double dScale = 1d;
        if (original != null && toFit != null)
        {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);
            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        settingMenu = new javax.swing.JMenu();
        staffMenuItem = new javax.swing.JMenuItem();
        aircraftMenuItem = new javax.swing.JMenuItem();
        sectorAsMenuItem = new javax.swing.JMenuItem();
        flightMenuItem = new javax.swing.JMenuItem();
        operationMenu = new javax.swing.JMenu();
        searchMenuItem = new javax.swing.JMenuItem();
        bookMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        settingMenu.setMnemonic('s');
        settingMenu.setText("Setting");

        staffMenuItem.setMnemonic('t');
        staffMenuItem.setText("Staff");
        settingMenu.add(staffMenuItem);

        aircraftMenuItem.setMnemonic('a');
        aircraftMenuItem.setText("Aircraft");
        settingMenu.add(aircraftMenuItem);

        sectorAsMenuItem.setMnemonic('c');
        sectorAsMenuItem.setText("Sector");
        settingMenu.add(sectorAsMenuItem);

        flightMenuItem.setMnemonic('f');
        flightMenuItem.setText("Flight");
        flightMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightMenuItemActionPerformed(evt);
            }
        });
        settingMenu.add(flightMenuItem);

        menuBar.add(settingMenu);

        operationMenu.setMnemonic('o');
        operationMenu.setText("Operation");

        searchMenuItem.setMnemonic('r');
        searchMenuItem.setText("Search");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        operationMenu.add(searchMenuItem);

        bookMenuItem.setMnemonic('b');
        bookMenuItem.setLabel("Quick Book");
        bookMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookMenuItemActionPerformed(evt);
            }
        });
        operationMenu.add(bookMenuItem);

        pasteMenuItem.setMnemonic('u');
        pasteMenuItem.setText("Scheduling");
        operationMenu.add(pasteMenuItem);

        menuBar.add(operationMenu);

        exitMenu.setText("Exit");
        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuMouseClicked(evt);
            }
        });
        menuBar.add(exitMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void flightMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightMenuItemActionPerformed

    }//GEN-LAST:event_flightMenuItemActionPerformed

    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed

        jdpDesktop.add(LoginForm.sf);
        LoginForm.sf.setVisible(true);
        
    }//GEN-LAST:event_searchMenuItemActionPerformed

    private void bookMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookMenuItemActionPerformed
        jdpDesktop.add(LoginForm.ff);
        LoginForm.ff.setVisible(true);
    }//GEN-LAST:event_bookMenuItemActionPerformed

    private void exitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NavForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NavForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NavForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NavForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NavForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aircraftMenuItem;
    private javax.swing.JMenuItem bookMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu exitMenu;
    private javax.swing.JMenuItem flightMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu operationMenu;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem searchMenuItem;
    private javax.swing.JMenuItem sectorAsMenuItem;
    private javax.swing.JMenu settingMenu;
    private javax.swing.JMenuItem staffMenuItem;
    // End of variables declaration//GEN-END:variables

       
        }
