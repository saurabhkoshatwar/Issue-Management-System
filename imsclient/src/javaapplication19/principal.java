/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.CardLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Saurabh
 */
public class principal extends javax.swing.JPanel {

    /**
     * Creates new form admin
     * 
     *
     */
    
        JPanel base_panel;
        issue_desc desc;
        Main_list_panel lpn ;
        Socket soc;
        String uname;
        
          public principal() {  
        
        initComponents();
         }
            
    public principal(JPanel base1,issue_desc base2,Main_list_panel lp) {
        base_panel = base1;
        desc = base2;
         lpn = lp;
        initComponents();
        approved.setVisible(false);
        solved.setVisible(false);
    }
    void setsocket(Socket soc) throws IOException
    {
    this.soc = soc;
    }
    
    void setuname(String uname)
     {
     this.uname = uname;
     }
    


    
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        approved = new javax.swing.JButton();
        solved = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(221, 562));
        setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/15003918289975.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(40, 90, 150, 60);

        approved.setText("Mark as approved");
        approved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvedActionPerformed(evt);
            }
        });
        add(approved);
        approved.setBounds(30, 270, 160, 40);

        solved.setText("Mark as Solved");
        solved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solvedActionPerformed(evt);
            }
        });
        add(solved);
        solved.setBounds(30, 330, 160, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication19/panel.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 220, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void approvedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvedActionPerformed
        
        //solved.setVisible(true);   
        try {
                // TODO add your handling code here:
                String sel = lpn.selected.IID;
                DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
                dos.writeUTF("7");
                dos.flush();
                dos.writeUTF(sel);
                dos.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
           try {
                lpn.refresh_list();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
           
    
        
    }//GEN-LAST:event_approvedActionPerformed

    private void solvedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solvedActionPerformed
     
        try {
                // TODO add your handling code here:
                String sel = lpn.selected.IID;
                DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
                dos.writeUTF("8");
                dos.flush();
                dos.writeUTF(sel);
                dos.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        
           try {
                lpn.refresh_list();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
    }//GEN-LAST:event_solvedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton approved;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JButton solved;
    // End of variables declaration//GEN-END:variables
}
