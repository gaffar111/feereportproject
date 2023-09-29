
package com.mycompany.feereportproject;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class editcourse extends javax.swing.JFrame {

  
    
    DefaultTableModel  model;
    public editcourse() {
        initComponents();
        setRecordsToTable();
    }

    
    public void setRecordsToTable()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
          String sql=("select * from coursefees");
              PreparedStatement st= con.prepareStatement(sql);
              ResultSet rs=st.executeQuery();
              while(rs.next())
              {
                  String courseId=rs.getString("id");
                  String cname=rs.getString("cname");
                  String cost=rs.getString("cost");
                     
                     Object[] obj={courseId,cname,cost};
                  
              model=(DefaultTableModel)tbl_coursedata.getModel();
              model.addRow(obj);
              
              
              
                             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void addCourse(int id,String cname,double cost)
            
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
          String sql=("insert into coursefees values (?,?,?)");
              PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,cname);
            st.setDouble(3,cost);
           int rowCount= st.executeUpdate();
            
                    
        if(rowCount==1)
               {
                 JOptionPane.showMessageDialog(this,"course added succesfully");
                 clearTable();
                   setRecordsToTable();
               }
               else
               {
                   JOptionPane.showMessageDialog(this,"course insertion fail");
               }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"course insertion failed");
            e.printStackTrace();
        }
        
    }
    public void clearTable()
    {
        DefaultTableModel model=  (DefaultTableModel)tbl_coursedata.getModel();
        model.setRowCount(0);
    }
    public void update(int id,String cname,double cost)
    {
          try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
          String sql=("update coursefees set cname= ?,cost=? where id=?");
              PreparedStatement st= con.prepareStatement(sql);
           
            st.setString(1,cname);
            st.setDouble(2,cost);
             st.setInt(3,id);
           int rowCount= st.executeUpdate();
            
                    
        if(rowCount==1)
               {
                 JOptionPane.showMessageDialog(this,"course updated succesfully");
                 clearTable();
                   setRecordsToTable();
               }
               else
               {
                   JOptionPane.showMessageDialog(this,"course updation fail");
               }
             
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"course updation failed");
            e.printStackTrace();
        }
        
            
    }
     public void delete(int id)
    {
          try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
          String sql=("delete  from coursefees  where id=?");
              PreparedStatement st= con.prepareStatement(sql);
           
         
             st.setInt(1,id);
           int rowCount= st.executeUpdate();
            
                    
        if(rowCount==1)
               {
                 JOptionPane.showMessageDialog(this,"course deleted succesfully");
                 clearTable();
                   setRecordsToTable();
               }
               else
               {
                   JOptionPane.showMessageDialog(this,"course deletion fail");
               }
             
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"course updation failed");
            e.printStackTrace();
        }
        
            
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_coursedata = new javax.swing.JTable();
        txt_courseprice = new javax.swing.JTextField();
        txt_courseid = new javax.swing.JTextField();
        txt_coursename = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Log Out");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, 60));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Home");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 50));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Search Record");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, 50));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Edit Course");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, 50));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton5.setText("View All Record");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 150, 70));

        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton9.setText("Back");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, 180, 690));

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_coursedata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "course id", "course name", "course price"
            }
        ));
        tbl_coursedata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_coursedataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_coursedata);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 700, 690));

        txt_courseprice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_courseprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursepriceActionPerformed(evt);
            }
        });
        jPanel2.add(txt_courseprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, -1));

        txt_courseid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_courseid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseidActionPerformed(evt);
            }
        });
        jPanel2.add(txt_courseid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 150, -1));

        txt_coursename.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursenameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 150, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Course Price :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 110, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Course Id :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 80, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Course Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 110, 30));

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton7.setText("DELETE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setText("HOME");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton10.setText("UPDATE");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 70, 90));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Edit Course Details");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 210, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, 320, 10));

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton11.setText("ADD");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        Color c1=new Color(3);

        jButton1.setBackground(c1);  
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        Color c1=new Color(255,255,255);

        jButton1.setBackground(c1);  
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        Color c1=new Color(3);

        jButton2.setBackground(c1);        
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        Color c1=new Color(255,255,255);

        jButton2.setBackground(c1); 
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        searchrecord search = new searchrecord();
        search.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        Color c1=new Color(3);

        jButton3.setBackground(c1); 
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        Color c1=new Color(255,255,255);

        jButton3.setBackground(c1);  
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        Color c1=new Color(4);

        jButton4.setBackground(c1); 
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        Color c1=new Color(255,255,255);

        jButton4.setBackground(c1);  
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        Color c1=new Color(3);

        jButton5.setBackground(c1);   
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        Color c1=new Color(255,255,255);

        jButton5.setBackground(c1);  
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
       
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txt_coursepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursepriceActionPerformed
        
    }//GEN-LAST:event_txt_coursepriceActionPerformed

    private void txt_courseidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseidActionPerformed
        
    }//GEN-LAST:event_txt_courseidActionPerformed

    private void txt_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursenameActionPerformed
        
    }//GEN-LAST:event_txt_coursenameActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
  int id=Integer.parseInt(txt_courseid.getText());
      delete(id);
 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       

    }//GEN-LAST:event_jButton8ActionPerformed

    private void tbl_coursedataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_coursedataMouseClicked
      int rowNo=tbl_coursedata.getSelectedRow();
      TableModel model=tbl_coursedata.getModel();
      txt_courseid.setText(model.getValueAt(rowNo,0).toString());
      txt_coursename.setText((String)model.getValueAt(rowNo,1));
      txt_courseprice.setText(model.getValueAt(rowNo, 2).toString());
    }//GEN-LAST:event_tbl_coursedataMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
  int id=Integer.parseInt(txt_courseid.getText());
       String cname=txt_coursename.getText();
       double cost=Double.parseDouble(txt_courseprice.getText());
       update(id,cname,cost);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
 homepage home= new homepage();
     home.setVisible(true);
     this.dispose();       
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
int id=Integer.parseInt(txt_courseid.getText());
       String cname=txt_coursename.getText();
       double cost=Double.parseDouble(txt_courseprice.getText());
       addCourse(id,cname,cost);        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
homepage home=new homepage();
home.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
 viewallrecord view=new viewallrecord();
       view.setVisible(true);
       this.dispose();       
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
 homepage home=new homepage();
home.setVisible(true);
this.dispose();        
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
          signupform signup= new signupform();
       signup.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editcourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_coursedata;
    private javax.swing.JTextField txt_courseid;
    private javax.swing.JTextField txt_coursename;
    private javax.swing.JTextField txt_courseprice;
    // End of variables declaration//GEN-END:variables
}
