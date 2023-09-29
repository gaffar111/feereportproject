
package com.mycompany.feereportproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;

public class printreceipt1 extends javax.swing.JFrame {

   
    public printreceipt1() {
        initComponents();
        getRecords();
        
    }
    public void getRecords()
    {
        try
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
              String sql="SELECT * FROM fees_details order by reciept_no desc LIMIT 1";

              PreparedStatement st= con.prepareStatement(sql);
              ResultSet rs=st.executeQuery();
         
            rs.next();
              txt_repno.setText(rs.getString("reciept_no"));
              txt_paymentmode.setText(rs.getString("payment_mode"));
              String paymentMode=rs.getString("payment_mode");
              if(paymentMode.equalsIgnoreCase("cash"))
              {
                  lbl_cheque_Dd.setText("Cheque No");
                  txt_cheque_Dd.setText("not applicable");
                  txt_bankname.setText("not applicable");
                  
              }
              if(paymentMode.equalsIgnoreCase("cheque"))
              {
                  lbl_cheque_Dd.setText("Cheque No");
                  txt_cheque_Dd.setText(rs.getString("cheque_no"));
                  txt_bankname.setText(rs.getString("bank_name"));
                  
         
              }
              if(paymentMode.equalsIgnoreCase("dd"))
              {
                  lbl_cheque_Dd.setText("DD No");
                  txt_cheque_Dd.setText(rs.getString("dd_no"));
                  txt_bankname.setText(rs.getString("bank_name"));
                  
              }
              if(paymentMode.equalsIgnoreCase("card"))
              {
                  lbl_cheque_Dd.setText("cheque No");
                 txt_cheque_Dd.setText("not applicable");
                  txt_bankname.setText(rs.getString("bank_name"));
                  
              }
               
              txt_recfrom.setText(rs.getString("student_name"));
              txt_date.setText(rs.getString("Date"));
              txt_gstin.setText(rs.getString("gstin"));
              txt_year1.setText(rs.getString("year1"));
               txt_year2.setText(rs.getString("year2"));
               txt_initialamount.setText(rs.getString("amount"));
              txt_cgst.setText(rs.getString("cgst"));
              txt_sgst.setText(rs.getString("sgst"));
              txt_totalinwords1.setText(rs.getString("total_in_words"));
              txt_total.setText(rs.getString("total_amount"));
              txt_remarkk.setText(rs.getString("remark"));
            txt_coursename1.setText(rs.getString("course_name"));
              
        }
        catch (Exception e)
        {
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
        jButton8 = new javax.swing.JButton();
        txt_printtt = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        panel_print = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_paymentmode = new javax.swing.JLabel();
        txt_repno = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JLabel();
        txt_cheque_Dd = new javax.swing.JLabel();
        paymentmode = new javax.swing.JLabel();
        txt_gstin = new javax.swing.JLabel();
        lbl_cheque_Dd = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JLabel();
        txt_recfrom = new javax.swing.JLabel();
        lnl_repno1 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JLabel();
        lnl_repno3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_bankname = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_remarkk = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_coursename1 = new javax.swing.JLabel();
        lbl_sgst = new javax.swing.JLabel();
        lbl_cgst = new javax.swing.JLabel();
        txt_initialamount = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JLabel();
        txt_total = new javax.swing.JLabel();
        txt_CGST3 = new javax.swing.JLabel();
        txt_totalinwords1 = new javax.swing.JLabel();
        txt_totalinwords2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_total1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lbl_total2 = new javax.swing.JLabel();

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 130, 50));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 50));

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
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 50));

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Edit Course");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
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
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 150, 50));

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
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, 70));

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton8.setText("Back");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton8MouseExited(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 130, 60));

        txt_printtt.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_printtt.setText("Print");
        txt_printtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_printttMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_printttMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_printttMouseExited(evt);
            }
        });
        txt_printtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_printttActionPerformed(evt);
            }
        });
        jPanel1.add(txt_printtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, 50));

        btn_edit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_editMouseExited(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 130, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 950));

        panel_print.setBackground(new java.awt.Color(204, 255, 255));
        panel_print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Near Rajankunte,Yelahanka,Bangalore");
        panel_print.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 230, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setText("School Of Engineering");
        panel_print.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 230, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_print.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1140, 20));

        txt_paymentmode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_paymentmode.setText("payment mode :");
        panel_print.add(txt_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 90, -1));

        txt_repno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_repno.setText("Receipt no :");
        panel_print.add(txt_repno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 70, 20));

        txt_year2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_year2.setText("2022");
        panel_print.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 70, 20));

        txt_cheque_Dd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_cheque_Dd.setText("cheque_dd :");
        panel_print.add(txt_cheque_Dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 90, -1));

        paymentmode.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        paymentmode.setText("payment mode :");
        panel_print.add(paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, -1));

        txt_gstin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_gstin.setText("GSTIN  :");
        panel_print.add(txt_gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 217, 150, 20));

        lbl_cheque_Dd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_cheque_Dd.setText("cheque_dd :");
        panel_print.add(lbl_cheque_Dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, -1));

        txt_bankname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_bankname.setText("Bank Name :");
        panel_print.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 90, -1));

        txt_recfrom.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_recfrom.setText("Receive From :");
        panel_print.add(txt_recfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 90, -1));

        lnl_repno1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lnl_repno1.setText("Receipt no :");
        panel_print.add(lnl_repno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 180, 70, 20));

        txt_year1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_year1.setText("2022");
        panel_print.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 40, 20));

        lnl_repno3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lnl_repno3.setText("-");
        panel_print.add(lnl_repno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 10, 20));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Amount(rs)");
        panel_print.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 90, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Receive From :");
        panel_print.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 90, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("The following payment in the college office for the year :");
        panel_print.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 320, -1));

        txt_date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_date.setText("Date  :");
        panel_print.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 100, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Date  :");
        panel_print.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 100, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("GSTIN  :");
        panel_print.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 80, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panel_print.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 330, 10));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        panel_print.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 420, 1140, -1));

        lbl_bankname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_bankname.setText("Bank Name :");
        panel_print.add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Sr No");
        panel_print.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 397, 90, 10));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Head");
        panel_print.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 90, -1));

        txt_remarkk.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_remarkk.setText("Remark :");
        panel_print.add(txt_remarkk, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 110, 20));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("1");
        panel_print.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 20, 20));

        txt_coursename1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_coursename1.setText("1");
        panel_print.add(txt_coursename1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 150, 20));

        lbl_sgst.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_sgst.setText("SGST (9%)");
        panel_print.add(lbl_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 150, 20));

        lbl_cgst.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_cgst.setText("CGST(9%)");
        panel_print.add(lbl_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 80, 20));

        txt_initialamount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_initialamount.setText("CGST");
        panel_print.add(txt_initialamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 140, 20));

        txt_cgst.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_cgst.setText("CGST");
        panel_print.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 140, 20));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        panel_print.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 1140, 40));

        txt_sgst.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_sgst.setText("SGST");
        panel_print.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, 150, 20));

        txt_total.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_total.setText("Total");
        panel_print.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 170, 20));

        txt_CGST3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_CGST3.setText("Total in words:");
        panel_print.add(txt_CGST3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 110, 20));

        txt_totalinwords1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_totalinwords1.setText("Total in words:");
        panel_print.add(txt_totalinwords1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 260, 20));

        txt_totalinwords2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_totalinwords2.setText("Remark :");
        panel_print.add(txt_totalinwords2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 110, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("SHRAVANI CHANDRA SHEKAR ");
        panel_print.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 30));

        lbl_total1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_total1.setText("receivers signature");
        panel_print.add(lbl_total1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, 110, 20));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        panel_print.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 330, 10));

        lbl_total2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_total2.setText("Total");
        panel_print.add(lbl_total2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 40, 20));

        getContentPane().add(panel_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -30, 1170, 990));

        setBounds(0, 0, 1282, 958);
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

    private void jButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseEntered
        
    }//GEN-LAST:event_jButton8MouseEntered

    private void jButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseExited
        
    }//GEN-LAST:event_jButton8MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_printttMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_printttMouseEntered
       
    }//GEN-LAST:event_txt_printttMouseEntered

    private void txt_printttMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_printttMouseExited
       
    }//GEN-LAST:event_txt_printttMouseExited

    private void txt_printttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_printttActionPerformed
        
    }//GEN-LAST:event_txt_printttActionPerformed

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
       
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
        
    }//GEN-LAST:event_btn_editMouseExited

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_printttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_printttMouseClicked
  
        PrinterJob job=PrinterJob.getPrinterJob();
    job.setJobName("print Data");
    job.setPrintable(new Printable(){
    
        public int print (Graphics pg,PageFormat pf, int pageNum)
        {
            pf.setOrientation(PageFormat.LANDSCAPE);
            if(pageNum>0)
                
            {
                return Printable.NO_SUCH_PAGE;
                
            }
            Graphics2D g2=(  Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.47,0.47);
            panel_print.print(g2);
            
           return Printable.PAGE_EXISTS; 
        }
    });
    boolean ok=job.printDialog();
    if(ok)
    {
        try
        {
            job.print();
        }
         catch (PrinterException ex) {
           ex.printStackTrace();
       }
    }
         
    }//GEN-LAST:event_txt_printttMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
           updatefeesdetails update= new  updatefeesdetails();
       update.setVisible(true);
       this.dispose();

    }//GEN-LAST:event_btn_editMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
  homepage home= new homepage();
     home.setVisible(true);
     this.dispose();        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        searchrecord search = new searchrecord();
search.setVisible(true);
this.dispose(); 
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
          signupform signup= new signupform();
       signup.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
 homepage home=new homepage();
home.setVisible(true);
this.dispose();
          
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
  editcourse edit= new editcourse();
    edit.setVisible(true);
    this.dispose();        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
          viewallrecord view=new viewallrecord();
       view.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton5MouseClicked

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printreceipt1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_cgst;
    private javax.swing.JLabel lbl_cheque_Dd;
    private javax.swing.JLabel lbl_sgst;
    private javax.swing.JLabel lbl_total1;
    private javax.swing.JLabel lbl_total2;
    private javax.swing.JLabel lnl_repno1;
    private javax.swing.JLabel lnl_repno3;
    private javax.swing.JPanel panel_print;
    private javax.swing.JLabel paymentmode;
    private javax.swing.JLabel txt_CGST3;
    private javax.swing.JLabel txt_bankname;
    private javax.swing.JLabel txt_cgst;
    private javax.swing.JLabel txt_cheque_Dd;
    private javax.swing.JLabel txt_coursename1;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_gstin;
    private javax.swing.JLabel txt_initialamount;
    private javax.swing.JLabel txt_paymentmode;
    private javax.swing.JButton txt_printtt;
    private javax.swing.JLabel txt_recfrom;
    private javax.swing.JLabel txt_remarkk;
    private javax.swing.JLabel txt_repno;
    private javax.swing.JLabel txt_sgst;
    private javax.swing.JLabel txt_total;
    private javax.swing.JLabel txt_totalinwords1;
    private javax.swing.JLabel txt_totalinwords2;
    private javax.swing.JLabel txt_year1;
    private javax.swing.JLabel txt_year2;
    // End of variables declaration//GEN-END:variables
}
