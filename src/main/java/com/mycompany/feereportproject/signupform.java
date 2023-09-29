
package com.mycompany.feereportproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getInt;


public class signupform extends javax.swing.JFrame {

  
    public signupform() {
        initComponents();
    }
    
int id=0;
int getId()
    
{ 
    ResultSet rs =null;
try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
              String sql="select max(id)from signup";
              Statement st= con.createStatement();
             rs= st.executeQuery(sql);
             while(rs.next())
                 
             {
                 id=rs.getInt(1);
                 id++;
             }
}
    catch(Exception e)

            
            {
                e.printStackTrace();
                
            }
 return id;   
}
  
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnsignup = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnlogin = new javax.swing.JButton();
        txt_cnumber = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_uname = new javax.swing.JTextField();
        txt_dob = new com.toedter.calendar.JDateChooser();
        txt_cpassword = new javax.swing.JPasswordField();
        txt_password = new javax.swing.JPasswordField();
        lbl_passworderror = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cnum = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(602, 602, 602)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(966, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(17, 17, 17))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Contact Number :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("First Name :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Last Name :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("User Name :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Password :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Confirm Password :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("D.O.B :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, -1, -1));

        btnsignup.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnsignup.setText("Sign Up");
        btnsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btnsignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, -1, -1));

        btnclear.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnclear.setText("Clear All");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, -1, -1));

        btnlogin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnlogin.setText("Log In");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, -1, -1));

        txt_cnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cnumberKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cnumberKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cnumberKeyTyped(evt);
            }
        });
        getContentPane().add(txt_cnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 400, 220, -1));
        getContentPane().add(txt_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 200, -1));
        getContentPane().add(txt_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 200, -1));
        getContentPane().add(txt_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 210, -1));
        getContentPane().add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 160, -1));
        getContentPane().add(txt_cpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 220, -1));

        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 210, -1));

        lbl_passworderror.setBackground(new java.awt.Color(255, 255, 255));
        lbl_passworderror.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(lbl_passworderror, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 270, 160, 20));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 100, 20));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 100, 20));

        cnum.setBackground(new java.awt.Color(255, 255, 255));
        cnum.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(cnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 390, 270, 20));

        setBounds(0, 0, 1664, 1015);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignupActionPerformed
validation();
if(validation())
{
    insertData();
}

    }//GEN-LAST:event_btnsignupActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
            txt_fname.setText("");
      txt_lname.setText("");
      txt_uname.setText("");
       txt_password.setText("");
   txt_cpassword.setText("");
      dob= txt_dob.getDate();
       txt_cnumber.setText("");      
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
      login l1= new login();
      l1.show();
      this.dispose();
    }//GEN-LAST:event_btnloginActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        
       
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
passwordCheck();        
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
    passwordCheck();    
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
passwordCheck();        
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_cnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cnumberKeyPressed
       mobileCheck(); 
    }//GEN-LAST:event_txt_cnumberKeyPressed

    private void txt_cnumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cnumberKeyReleased
mobileCheck();       
    }//GEN-LAST:event_txt_cnumberKeyReleased

    private void txt_cnumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cnumberKeyTyped
mobileCheck();        
    }//GEN-LAST:event_txt_cnumberKeyTyped

   
    String fname,lname,password,uname,cpassword,cnumber; 
        Date dob;
        
       void insertData()
        {
            SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd");
           String dob1= s1.format(dob);
   
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
              String sql="insert into signup values(?,?,?,?,?,?,?)";
             PreparedStatement st =con.prepareStatement(sql);
             st.setInt(1,getId());
             st.setString(2,fname);
              st.setString(3,lname);
               st.setString(4,uname);
                st.setString(5,password);
                 st.setString(6,dob1);
                  st.setString(7,cnumber);
                 int i= st.executeUpdate();
                 if(i>0)
                 {
                     JOptionPane.showMessageDialog(this,"Inserted Sucessfully");
                 }
                 else{
                     JOptionPane.showMessageDialog(this," Not Inserted");
                 }
                  
            }
            
            catch(Exception e)
            {
                 e.printStackTrace();
                
            }
            
        }
        
    boolean validation()
    {
       fname= txt_fname.getText();
       lname= txt_lname.getText();
       uname= txt_uname.getText();
       password= txt_password.getText();
       cpassword= txt_cpassword.getText();
       dob= txt_dob.getDate();
       cnumber=txt_cnumber.getText();
       if(fname.equals(""))
       {
           JOptionPane.showMessageDialog(this,"please enter first name !");
           return false;
       }
       if(lname.equals(""))
       {
           JOptionPane.showMessageDialog(this,"please enter last name !");
           return false;
       }
       if(uname.equals(""))
       {
           JOptionPane.showMessageDialog(this,"please enter user name !");
           return false;
       }
       if(password.equals(""))
       {
           JOptionPane.showMessageDialog(this,"please enter password !");
           return false;
       }
       if(cpassword.equals(""))
       {
           JOptionPane.showMessageDialog(this,"please enter comfirm password !");
           return false;
       }
       if(dob.equals(null))
       {
           JOptionPane.showMessageDialog(this,"please enter date of birth !");
           return false;
       }
       if(cnumber.equals(""))
       {
           JOptionPane.showMessageDialog(this,"please enter contact number !");
           return false;
       }
        if (!password.equals(cpassword)) {
            
            JOptionPane.showMessageDialog(this,"password does not match !");
           return false;
          
        }
  
       
      
    return true;
    }
    
   void passwordCheck()
    {
            password= txt_password.getText();
            if(password.length()>=8)
                
            {
                lbl_passworderror.setText("");
            }
            else
            {
                lbl_passworderror.setText("enter the 8 digit password");
            }
           
    }
   void mobileCheck()
   {
        cnumber=txt_cnumber.getText();
        if(cnumber.length()==10)
        {
              cnum.setText("");
            
        }
        else
        {
            cnum.setText("enter the 10 numbers");
        }
   }
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signupform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnsignup;
    private javax.swing.JLabel cnum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_passworderror;
    private javax.swing.JTextField txt_cnumber;
    private javax.swing.JPasswordField txt_cpassword;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_uname;
    // End of variables declaration//GEN-END:variables

   
    
}