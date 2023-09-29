
package com.mycompany.feereportproject;
import java.awt.Color;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class updatefeesdetails extends JFrame {

 
    public updatefeesdetails() {
        initComponents();
        displayCashFirst();
        fillCombobox();
       int r= getRNo();
       r++;
    txt_repno3.setText(Integer.toString(r));
     setRecord();
     
    }
public String UpdateData()
{
       String status="";
    int recieptno=Integer.parseInt(txt_repno3.getText());
    String sname=txt_rec.getText();
    String rollno=txt_roll.getText();
    String paymentmode=combo_payment.getSelectedItem().toString();
    String chequeno=txt_cheque.getText();
    String bankname=txt_bankname.getText();
    String ddno=txt_ddno.getText();
    String coursename=combo_course.getSelectedItem().toString();
String gst=jLabel5.getText();
    float total=Float.parseFloat(txt_total.getText());
   SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
   String date=dateFormat.format(datechooser.getDate());
    float amount=Float.parseFloat(txt_amount.getText());
    float cgst=Float.parseFloat(txt_cgst.getText());
    float sgst=Float.parseFloat(txt_sgst.getText());
   String totalinwords= txt_totalwords.getText();
   String remark=txt_remark.getText();
  int year1=Integer.parseInt(txt_year1.getText());
 int year2=Integer.parseInt(txt_year2.getText());

  

               
   try
   {
       Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
          String sql=("update fees_details set student_name= ?,roll_no= ?,payment_mode= ?,cheque_no= ?,bank_name= ?,dd_no= ?,course_name= ?,gstin= ?,total_amount= ?,date= ?,amount= ?,cgst= ?,sgst=?,total_in_words= ?,remark= ?,year1= ?,year2 =? where reciept_no = ? ");
              PreparedStatement st= con.prepareStatement(sql);
              
           st.setString(1,sname);
               st.setString(2,rollno);
               st.setString(3,paymentmode);
                st.setString(4,chequeno);
                 st.setString(5,bankname);
                  st.setString(6,ddno);
                   st.setString(7,coursename);
                    st.setString(8,gst);
                    st.setFloat(9,total);
                    st.setString(10,date);
                       st.setFloat(11,amount);
                          st.setFloat(12,cgst);
                             st.setFloat(13,sgst);
                    st.setString(14,totalinwords);       
                    st.setString(15,remark);
                    st.setInt(16,year1);
                    st.setInt(17,year2);        
                     st.setInt(18,recieptno);
                             
               int  rowCount=st.executeUpdate();
               
        if(rowCount==1)
               {
                   status="success";
                   
               }
               else
               {
                   status="failed";
               }
       
   }
   catch(Exception e)
   {
       
       e.printStackTrace();
   }
    return status;
   
}
    public void displayCashFirst()
    {
        lbl_ddno.setVisible(false);
        lbl_cheque.setVisible(false);
        lbl_bankname.setVisible(false);
        
        txt_ddno.setVisible(false);
        txt_cheque.setVisible(false);
        txt_bankname.setVisible(false);
        
    }
    public boolean validation()
    {
        if(txt_rec.getText().equals(""))
        {
            
            JOptionPane.showMessageDialog(this,"please enter user name");
            return false;
        }
          if(txt_year1.getText().equals(""))
        {
            
            JOptionPane.showMessageDialog(this,"please enter from  year");
            return false;
        }
            if(txt_year2.getText().equals(""))
        {
            
            JOptionPane.showMessageDialog(this,"please enter to  year");
            return false;
        }
            if(txt_roll.getText().equals(""))
        {
            
            JOptionPane.showMessageDialog(this,"please enter Roll number");
            return false;
        }
        if(datechooser.getDate()==null)
        {
             JOptionPane.showMessageDialog(this,"please enter date");
               return false;
        }
        if(txt_amount.getText().equals(""))
        {
             JOptionPane.showMessageDialog(this,"please enter amount[In Numbers]");
               return false;
        }
        if(combo_payment.getSelectedItem().toString().equalsIgnoreCase("cheque"))
        {
            if(txt_cheque.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(this,"please enter cheque number");
               return false;
                    }
              if(txt_bankname.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(this,"please enter bank name");
               return false;
                    }
            
        }
        if(combo_payment.getSelectedItem().toString().equalsIgnoreCase("dd"))
        {
            if(txt_ddno.getText().equals(""))
                    {
            JOptionPane.showMessageDialog(this,"please enter bank dd number");
               return false;
                    }
             if(txt_bankname.getText().equals(""))
                    {
            JOptionPane.showMessageDialog(this,"please enter bank name");
               return false;
                    }
        }
        if(combo_payment.getSelectedItem().toString().equalsIgnoreCase("card"))
        {
            if(txt_bankname.getText().equals(""))
                    {
            JOptionPane.showMessageDialog(this,"please enter bank name");
               return false;
                    }
          

        }
            
        
        return true;
    }
    
    
    public void fillCombobox()
    {
        try
        {
           
             {
                Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
              String sql="select cname from courseaddfees";
              PreparedStatement st= con.prepareStatement(sql);
              ResultSet rs= st.executeQuery(sql);
             while(rs.next())
                 
             {
                 combo_course.addItem(rs.getString("cname"));
             }
  
                
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
    
      public int getRNo()
    {
        int rno=0;
        try
        {
           
             
                Class.forName("com.mysql.cj.jdbc.Driver");
               String url=("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL");
              Connection con =DriverManager.getConnection(url,"root","gaffar2003");
           
              PreparedStatement st= con.prepareStatement("select max(reciept_no) from fees_details");
              ResultSet rs= st.executeQuery();
            if(rs.next()==true)
             {
                 rno=rs.getInt(1);
             }
                 
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return rno;
    }
      public void setRecord()
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
              txt_repno3.setText(rs.getString("reciept_no"));
             combo_payment.setSelectedItem(rs.getString("payment_mode"));
              txt_cheque.setText(rs.getString("cheque_no"));
              txt_ddno.setText(rs.getString("dd_no"));
              txt_bankname.setText(rs.getString("bank_name"));
              txt_rec.setText(rs.getString("student_name"));  
              datechooser.setDate(rs.getDate("date"));
              txt_year1.setText(rs.getString("year1"));  
               txt_year2.setText(rs.getString("year2"));  
               txt_roll.setText(rs.getString("roll_no"));
               combo_course.setSelectedItem(rs.getString("course_name"));
               txt_amount.setText(rs.getString("amount"));
               txt_cgst.setText(rs.getString("cgst"));
               txt_sgst.setText(rs.getString("sgst"));
               txt_total.setText(rs.getString("total_amount"));
                    txt_totalwords.setText(rs.getString("total_in_words"));
                    txt_remark.setText(rs.getString("remark"));
          }
          catch(Exception e)
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
        btn_edit = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        lbl_cheque = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_ddno = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbl_bankname = new javax.swing.JLabel();
        lbl_repno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        datechooser = new com.toedter.calendar.JDateChooser();
        txt_cheque = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_totalwords = new javax.swing.JTextField();
        txt_year2 = new javax.swing.JTextField();
        combo_course = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_head = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        txt_total = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JTextField();
        txt_roll = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        combo_payment = new javax.swing.JComboBox<>();
        txt_ddno = new javax.swing.JTextField();
        txt_repno3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_rec = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));
        setForeground(new java.awt.Color(0, 153, 204));
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 130, 60));

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
        jPanel1.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 130, 60));

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
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 130, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 1010));

        lbl_cheque.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_cheque.setText("Cheque  No :");
        getContentPane().add(lbl_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 90, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Mode Of Payment :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 110, -1));

        lbl_ddno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_ddno.setText("DD No:");
        getContentPane().add(lbl_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 90, 30));

        txt_bankname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_banknameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 160, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("22HD6W282D");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 100, -1));

        lbl_bankname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_bankname.setText("Bank Name :");
        getContentPane().add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 90, -1));

        lbl_repno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_repno.setText("Receipt No :");
        getContentPane().add(lbl_repno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 90, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Date :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 50, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("GSTIN :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 50, -1));
        getContentPane().add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 160, -1));
        getContentPane().add(txt_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 160, 30));

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Roll no:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 50, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("the following payments the college office of the year :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("to");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        txt_totalwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalwordsActionPerformed(evt);
            }
        });
        jPanel2.add(txt_totalwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 310, 40));

        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 160, 30));

        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        jPanel2.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 150, 30));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Head ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1480, 30));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 117, 1480, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Amount");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Sr.No :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Receivers signature");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, -1, 20));

        txt_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_headActionPerformed(evt);
            }
        });
        jPanel2.add(txt_head, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 160, 30));

        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel2.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 170, 30));

        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 170, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 210, 20));
        jPanel2.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 170, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Course :");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Total in words :");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        btn_print.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_print.setText("Print");
        btn_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_printMouseExited(evt);
            }
        });
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, -1, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 210, 20));
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 170, 30));

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Total");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 40, 30));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane2.setViewportView(txt_remark);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, 100));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Remark ");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 20));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("CGST 7%");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, 20));
        jPanel2.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 160, 30));
        jPanel2.add(txt_roll, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 160, 30));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("SGST 7%");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 1480, 860));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Course :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, -1));

        combo_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "CHEQUE", "CASH", "CARD" }));
        combo_payment.setSelectedIndex(2);
        combo_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentActionPerformed(evt);
            }
        });
        getContentPane().add(combo_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 150, -1));
        getContentPane().add(txt_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, 30));
        getContentPane().add(txt_repno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 160, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("Received  From :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 110, -1));

        txt_rec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recActionPerformed(evt);
            }
        });
        getContentPane().add(txt_rec, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 160, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
if(validation()==true)
    {
        String result=UpdateData();
        if(result.equals("success"))
        {
            JOptionPane.showMessageDialog(this,"record updated succesfully");
            printreceipt1 p=new printreceipt1();
            p.setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this,"record updation failed");
            
        }
    }

    }//GEN-LAST:event_btn_printActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
  Color c1=new Color(3);
      
       jButton2.setBackground(c1);        
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        Color c1=new Color(255,255,255);
      
        jButton2.setBackground(c1); 
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
       Color c1=new Color(3);
      
       jButton3.setBackground(c1);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
       Color c1=new Color(255,255,255);
      
        jButton3.setBackground(c1);  
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
       Color c1=new Color(4);
      
       jButton4.setBackground(c1);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
         Color c1=new Color(255,255,255);
      
        jButton4.setBackground(c1);  
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
       Color c1=new Color(3);
      
       jButton5.setBackground(c1);   
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
       Color c1=new Color(255,255,255);
      
        jButton5.setBackground(c1);  
    }//GEN-LAST:event_jButton5MouseExited

    private void btn_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseEntered
       Color c1=new Color(3);
      
       btn_print.setBackground(c1);  
    }//GEN-LAST:event_btn_printMouseEntered

    private void btn_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_printMouseExited
        Color c1=new Color(255,255,255);
      
        btn_print.setBackground(c1);
    }//GEN-LAST:event_btn_printMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        Color c1=new Color(3);
      
       jButton1.setBackground(c1);  
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
      Color c1=new Color(255,255,255);
      
        jButton1.setBackground(c1);  
    }//GEN-LAST:event_jButton1MouseExited

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
String s1=combo_course.getSelectedItem().toString();
         txt_head.setText(s1);    
        
    }//GEN-LAST:event_combo_courseActionPerformed

    private void txt_totalwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalwordsActionPerformed
      
    }//GEN-LAST:event_txt_totalwordsActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void combo_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paymentActionPerformed
     

      if(combo_payment.getSelectedIndex()==0)
      {
          lbl_ddno.setVisible(true);
          txt_ddno.setVisible(true);
          lbl_cheque.setVisible(false);
          txt_cheque.setVisible(false);
          lbl_bankname.setVisible(true);
          txt_bankname.setVisible(true);
          
          
      }
       if(combo_payment.getSelectedIndex()==1)
      {
          lbl_ddno.setVisible(false);
          txt_ddno.setVisible(false);
          lbl_cheque.setVisible(true);
          txt_cheque.setVisible(true);
          lbl_bankname.setVisible(true);
          txt_bankname.setVisible(true);
          
          
      }
       if(combo_payment.getSelectedIndex()==2)
      {
          lbl_ddno.setVisible(false);
          txt_ddno.setVisible(false);
          lbl_cheque.setVisible(false);
          txt_cheque.setVisible(false);
          lbl_bankname.setVisible(false);
          txt_bankname.setVisible(false);
          
          
      }
        if(combo_payment.getSelectedItem().equals("CARD"))
      {
          lbl_ddno.setVisible(false);
          txt_ddno.setVisible(false);
          lbl_cheque.setVisible(false);
          txt_cheque.setVisible(false);
          lbl_bankname.setVisible(true);
          txt_bankname.setVisible(true);
          
          
      }







        
    }//GEN-LAST:event_combo_paymentActionPerformed

    private void txt_recActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recActionPerformed
       
    }//GEN-LAST:event_txt_recActionPerformed

    private void btn_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseEntered
        
    }//GEN-LAST:event_btn_editMouseEntered

    private void btn_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseExited
        
    }//GEN-LAST:event_btn_editMouseExited

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
      Float amnt=Float.parseFloat(txt_amount.getText());
      Float cgst=(float) (amnt*0.09);
      Float sgst= (float) (amnt*0.09);
     txt_cgst.setText(cgst.toString());
     txt_sgst.setText(sgst.toString());
     
     float total= amnt+cgst+sgst;
     txt_total.setText(Float.toString(total));
     txt_totalwords.setText(NumberToWordsConverter.convert((int)total)+" only");
     
    
      
      
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_headActionPerformed
        
    }//GEN-LAST:event_txt_headActionPerformed

    private void txt_banknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_banknameActionPerformed
     
    }//GEN-LAST:event_txt_banknameActionPerformed

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
updatefeesdetails update= new  updatefeesdetails();
       update.setVisible(true);
       this.dispose();              
    }//GEN-LAST:event_btn_editMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
searchrecord search = new searchrecord();
search.setVisible(true);
this.dispose();       
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
     homepage home= new homepage();
     home.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

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
                new updatefeesdetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_payment;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_cheque;
    private javax.swing.JLabel lbl_ddno;
    private javax.swing.JLabel lbl_repno;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque;
    private javax.swing.JTextField txt_ddno;
    private javax.swing.JTextField txt_head;
    private javax.swing.JTextField txt_rec;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_repno3;
    private javax.swing.JTextField txt_roll;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalwords;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
