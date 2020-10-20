/*     */ package database;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ public class Login
/*     */   extends JFrame
/*     */ {
/*  23 */   String verNum = "0.0.1";
/*     */   
/*     */   private JPanel contentPane;
/*     */   
/*     */   private JTextField txtFieldID;
/*     */   
/*     */   private JTextField txtFieldPw;
/*     */   private JPasswordField password;
/*  31 */   DBConnection connection = new DBConnection();
/*     */   
/*     */   static String userEmail;
/*     */   
/*     */   static int userCount;
/*     */   
/*     */   String userPw;
/*     */   
/*     */   static String userFirstName;
/*     */   
/*     */   static String userLastName;
/*     */   boolean wrong;
/*     */   
/*     */   public static void main(String[] args) {
/*  45 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/*     */             try {
/*  48 */               Login frame = new Login();
/*  49 */               frame.setVisible(true);
/*  50 */             } catch (Exception e) {
/*  51 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Login() {
/*  63 */     setDefaultCloseOperation(3);
/*  64 */     setBounds(500, 300, 450, 300);
/*  65 */     this.contentPane = new JPanel();
/*  66 */     this.contentPane.setBackground(Color.ORANGE);
/*  67 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  68 */     setContentPane(this.contentPane);
/*  69 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  71 */     this.password = new JPasswordField(30);
/*  72 */     this.password.setBounds(157, 176, 199, 26);
/*  73 */     this.password.setBackground(Color.WHITE);
/*  74 */     this.password.setEchoChar('*');
/*  75 */     this.contentPane.add(this.password);
/*  76 */     this.password.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  78 */             Login.this.login();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     JLabel lblEmail = new JLabel("EMAIL:");
/*  88 */     lblEmail.setBounds(108, 148, 148, 16);
/*  89 */     this.contentPane.add(lblEmail);
/*     */     
/*  91 */     JLabel lblPassword = new JLabel("PASSWORD:");
/*  92 */     lblPassword.setBounds(79, 181, 217, 16);
/*  93 */     this.contentPane.add(lblPassword);
/*     */     
/*  95 */     JLabel lblNoAccount = new JLabel("OR");
/*  96 */     lblNoAccount.setFont(new Font("Lucida Grande", 2, 13));
/*  97 */     lblNoAccount.setBounds(208, 228, 30, 16);
/*  98 */     this.contentPane.add(lblNoAccount);
/*     */     
/* 100 */     this.txtFieldID = new JTextField();
/* 101 */     this.txtFieldID.setBounds(157, 143, 199, 26);
/* 102 */     this.contentPane.add(this.txtFieldID);
/* 103 */     this.txtFieldID.setColumns(10);
/* 104 */     this.txtFieldID.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 106 */             Login.this.login();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     JButton btnLogin = new JButton("Login");
/* 116 */     btnLogin.setBounds(103, 214, 93, 45);
/* 117 */     this.contentPane.add(btnLogin);
/* 118 */     btnLogin.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 120 */             Login.this.login();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 125 */     JButton btnCreateAccount = new JButton("Create Account");
/* 126 */     btnCreateAccount.setBounds(241, 214, 115, 45);
/* 127 */     this.contentPane.add(btnCreateAccount);
/* 128 */     btnCreateAccount.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*     */             try {
/* 131 */               Statement stmt2 = DBConnection.con.createStatement();
/* 132 */               ResultSet rs3 = stmt2.executeQuery("SELECT COUNT(*) FROM users");
/* 133 */               if (rs3.next()) {
/* 134 */                 String userCountString = rs3.getString("COUNT(*)");
/* 135 */                 Login.userCount = Integer.parseInt(userCountString);
/*     */               } 
/*     */               
/* 138 */               NewAccount na = new NewAccount();
/* 139 */               na.setVisible(true);
/*     */             }
/* 141 */             catch (Exception e3) {
/* 142 */               System.out.println("Exception while accessing Database. Please contact the administrator.");
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void login() {
/* 154 */     char[] tempPass = this.password.getPassword();
/* 155 */     String typedPassword = new String(tempPass);
/*     */     
/*     */     try {
/* 158 */       Statement stmt = DBConnection.con.createStatement();
/* 159 */       ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users");
/*     */       
/* 161 */       if (rs.next()) {
/* 162 */         String userCountString = rs.getString("COUNT(*)");
/* 163 */         userCount = Integer.parseInt(userCountString);
/*     */       } 
/*     */       
/* 166 */       ResultSet rs2 = stmt.executeQuery("SELECT first_name, last_name FROM users WHERE email = '" + this.txtFieldID.getText() + "' AND password = md5('" + typedPassword + "')");
/* 167 */       if (rs2.next()) {
/* 168 */         userFirstName = rs2.getString("first_name");
/* 169 */         userLastName = rs2.getString("last_name");
/*     */       } 
/* 171 */       if (rs2.getRow() == 0) { this.wrong = true; }
/* 172 */       else { this.wrong = false; }
/*     */     
/* 174 */     } catch (Exception e2) {
/* 175 */       System.out.println("ERROR: " + e2.getMessage());
/* 176 */       System.out.println("Exception while accessing Database. Please contact the administrator.");
/*     */     } 
/* 178 */     System.out.println("firstname in database: " + userFirstName);
/* 179 */     System.out.println("lastname in database: " + userLastName);
/*     */     
/* 181 */     if (this.wrong) { Main.infoBox("Wrong ID or password. Please try again.", ""); }
/*     */     
/* 183 */     else if (!this.wrong)
/* 184 */     { Main.infoBox("Welcome, " + userFirstName + "!", "");
/* 185 */       dispose();
/* 186 */       Main m = new Main();
/* 187 */       System.out.println("going to main menu");
/* 188 */       m.setVisible(true); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\Login.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */