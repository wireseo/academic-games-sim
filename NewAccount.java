/*     */ package database;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.Serializable;
/*     */ import java.sql.PreparedStatement;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NewAccount
/*     */   extends JFrame
/*     */   implements Serializable
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTextField txtFieldID;
/*     */   static boolean makeID = true;
/*     */   boolean idChecked = false;
/*     */   private JTextField txtFieldLastName;
/*     */   private JTextField txtFieldFirstName;
/*     */   private JPasswordField password;
/*     */   private JPasswordField confirm;
/*     */   private JTextField txtFieldNickname;
/*     */   
/*     */   public NewAccount() {
/*  36 */     setDefaultCloseOperation(2);
/*  37 */     setBounds(500, 300, 450, 450);
/*  38 */     this.contentPane = new JPanel();
/*  39 */     this.contentPane.setBackground(Color.ORANGE);
/*  40 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  41 */     setContentPane(this.contentPane);
/*  42 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  44 */     JLabel lblEmail = new JLabel("EMAIL:");
/*  45 */     lblEmail.setBounds(121, 49, 86, 16);
/*  46 */     this.contentPane.add(lblEmail);
/*     */     
/*  48 */     JLabel lblPassword = new JLabel("PASSWORD:");
/*  49 */     lblPassword.setBounds(91, 237, 93, 16);
/*  50 */     this.contentPane.add(lblPassword);
/*     */     
/*  52 */     JLabel lblConfirm = new JLabel("CONFIRM PW:");
/*  53 */     lblConfirm.setBounds(79, 300, 93, 16);
/*  54 */     this.contentPane.add(lblConfirm);
/*     */     
/*  56 */     JLabel lblNewLabel = new JLabel("* Needs to be an AES email address");
/*  57 */     lblNewLabel.setForeground(Color.RED);
/*  58 */     lblNewLabel.setFont(new Font("Lucida Grande", 0, 9));
/*  59 */     lblNewLabel.setBounds(178, 69, 204, 16);
/*  60 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  62 */     JLabel lblAtLeast = new JLabel("* At least 8 characters");
/*  63 */     lblAtLeast.setForeground(Color.RED);
/*  64 */     lblAtLeast.setFont(new Font("Lucida Grande", 0, 9));
/*  65 */     lblAtLeast.setBounds(180, 258, 99, 16);
/*  66 */     this.contentPane.add(lblAtLeast);
/*     */     
/*  68 */     JLabel lblCantBe = new JLabel("* Can’t be identical to email");
/*  69 */     lblCantBe.setForeground(Color.RED);
/*  70 */     lblCantBe.setFont(new Font("Lucida Grande", 0, 9));
/*  71 */     lblCantBe.setBounds(180, 272, 132, 16);
/*  72 */     this.contentPane.add(lblCantBe);
/*     */     
/*  74 */     this.txtFieldID = new JTextField();
/*  75 */     this.txtFieldID.setBounds(170, 44, 155, 26);
/*  76 */     this.contentPane.add(this.txtFieldID);
/*  77 */     this.txtFieldID.setColumns(10);
/*     */     
/*  79 */     this.password = new JPasswordField(30);
/*  80 */     this.password.setBounds(170, 232, 155, 26);
/*  81 */     this.password.setBackground(Color.WHITE);
/*  82 */     this.password.setEchoChar('*');
/*  83 */     this.contentPane.add(this.password);
/*     */     
/*  85 */     this.confirm = new JPasswordField(30);
/*  86 */     this.confirm.setBounds(170, 295, 155, 26);
/*  87 */     this.confirm.setBackground(Color.WHITE);
/*  88 */     this.confirm.setEchoChar('*');
/*  89 */     this.contentPane.add(this.confirm);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     JButton btnSignin = new JButton("Sign in");
/*  95 */     btnSignin.setBounds(192, 344, 79, 39);
/*  96 */     this.contentPane.add(btnSignin);
/*  97 */     btnSignin.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  99 */             NewAccount.makeID = true;
/* 100 */             char[] tempPass = NewAccount.this.password.getPassword();
/* 101 */             String typedPassword = new String(tempPass);
/*     */             
/* 103 */             char[] confirmPass = NewAccount.this.confirm.getPassword();
/* 104 */             String confirmPassword = new String(confirmPass);
/* 105 */             while (NewAccount.makeID) {
/*     */ 
/*     */               
/* 108 */               if (!NewAccount.this.idChecked) {
/* 109 */                 Main.infoBox("You must check your ID first!", "");
/* 110 */                 NewAccount.makeID = false;
/*     */               } 
/*     */ 
/*     */               
/* 114 */               if (NewAccount.this.txtFieldFirstName.getText() == "" || NewAccount.this.txtFieldLastName.getText() == "") {
/* 115 */                 Main.infoBox("Please fill out your name.", "");
/* 116 */                 NewAccount.makeID = false;
/*     */               } 
/*     */               
/* 119 */               if (NewAccount.this.txtFieldID.getText().equals(typedPassword)) {
/* 120 */                 Main.infoBox("Your password cannot be equal to your ID.", "");
/* 121 */                 NewAccount.makeID = false;
/*     */                 
/*     */                 continue;
/*     */               } 
/* 125 */               if (typedPassword.length() < 8) {
/* 126 */                 Main.infoBox("Your password has to have at least 8 characters.", "");
/* 127 */                 NewAccount.makeID = false;
/*     */                 
/*     */                 continue;
/*     */               } 
/* 131 */               if (!typedPassword.equals(confirmPassword)) {
/* 132 */                 Main.infoBox("Your confirmation is not valid.", "");
/* 133 */                 NewAccount.makeID = false;
/*     */                 
/*     */                 continue;
/*     */               } 
/* 137 */               if (NewAccount.makeID) {
/*     */                 try {
/* 139 */                   String myQuery = "INSERT INTO `users` (`email`, `password`, `first_name`, `last_name`, `nickname`) VALUES ('" + NewAccount.this.txtFieldID.getText() + "',  md5('" + typedPassword + "'), '" + NewAccount.this.txtFieldFirstName.getText() + "', " + 
/* 140 */                     "'" + NewAccount.this.txtFieldLastName.getText() + "', '" + NewAccount.this.txtFieldNickname.getText() + "')";
/* 141 */                   PreparedStatement updateUser = DBConnection.con.prepareStatement(myQuery);
/* 142 */                   int updateUser_done = updateUser.executeUpdate();
/* 143 */                   System.out.println("my query: " + myQuery);
/* 144 */                   Main.infoBox("Thank you for creating a new account. Please login!", "");
/* 145 */                   NewAccount.this.dispose();
/* 146 */                   NewAccount.makeID = false;
/* 147 */                 } catch (Exception e5) {
/* 148 */                   Main.infoBox("SQL ERROR: " + e5.getMessage(), ":(");
/* 149 */                   System.exit(0);
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 156 */     JButton btnCheck = new JButton("Check");
/* 157 */     btnCheck.setBounds(325, 44, 71, 29);
/* 158 */     this.contentPane.add(btnCheck);
/* 159 */     btnCheck.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 162 */             String string = NewAccount.this.txtFieldID.getText();
/* 163 */             if (string.length() > 12) {
/* 164 */               String substring = string.substring(string.length() - 10, string.length());
/* 165 */               System.out.println("substring: " + substring);
/* 166 */               if (!substring.equalsIgnoreCase("@aes.ac.in")) {
/*     */ 
/*     */ 
/*     */                 
/* 170 */                 Main.infoBox("ID is not a valid AES email address.", "");
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } else {
/* 175 */               Main.infoBox("ID is not a valid AES email address.", "");
/*     */               
/*     */               return;
/*     */             } 
/*     */             try {
/* 180 */               PreparedStatement insertUser = DBConnection.con.prepareStatement("INSERT INTO `users` (`email`, `password`, `first_name`, `last_name`, `avatar_url`, `admin`) VALUES ('" + NewAccount.this.txtFieldID.getText() + "', NULL, NULL, NULL, NULL, 'N')");
/* 181 */               int insertUser_done = insertUser.executeUpdate();
/* 182 */               Main.infoBox("ID is confirmed.", "");
/* 183 */               PreparedStatement deleteUser = DBConnection.con.prepareStatement("DELETE FROM users WHERE email = '" + NewAccount.this.txtFieldID.getText() + "'");
/* 184 */               int deleteUser_done = deleteUser.executeUpdate();
/* 185 */               NewAccount.this.idChecked = true;
/* 186 */               NewAccount.this.txtFieldID.setEditable(false);
/* 187 */               NewAccount.this.txtFieldID.setBackground(Color.GRAY);
/*     */             }
/* 189 */             catch (Exception e4) {
/* 190 */               System.out.println("ERROR: " + e4.getMessage());
/* 191 */               Main.infoBox("The email already exists in the database.", "");
/* 192 */               NewAccount.this.txtFieldID.setText("");
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 197 */     this.txtFieldFirstName = new JTextField();
/* 198 */     this.txtFieldFirstName.setColumns(10);
/* 199 */     this.txtFieldFirstName.setBounds(170, 97, 155, 26);
/* 200 */     this.contentPane.add(this.txtFieldFirstName);
/*     */     
/* 202 */     JLabel lblFirstName = new JLabel("FIRST NAME:");
/* 203 */     lblFirstName.setBounds(85, 102, 105, 16);
/* 204 */     this.contentPane.add(lblFirstName);
/*     */     
/* 206 */     this.txtFieldLastName = new JTextField();
/* 207 */     this.txtFieldLastName.setColumns(10);
/* 208 */     this.txtFieldLastName.setBounds(170, 141, 155, 26);
/* 209 */     this.contentPane.add(this.txtFieldLastName);
/*     */     
/* 211 */     JLabel lblLastName = new JLabel("LAST NAME:");
/* 212 */     lblLastName.setBounds(88, 146, 99, 16);
/* 213 */     this.contentPane.add(lblLastName);
/*     */     
/* 215 */     JButton btnBack = new JButton("← Back");
/* 216 */     btnBack.setBounds(6, 383, 79, 39);
/* 217 */     this.contentPane.add(btnBack);
/*     */     
/* 219 */     JLabel lblNickname = new JLabel("NICKNAME:");
/* 220 */     lblNickname.setBounds(91, 190, 96, 16);
/* 221 */     this.contentPane.add(lblNickname);
/*     */     
/* 223 */     this.txtFieldNickname = new JTextField();
/* 224 */     this.txtFieldNickname.setColumns(10);
/* 225 */     this.txtFieldNickname.setBounds(170, 185, 155, 26);
/* 226 */     this.contentPane.add(this.txtFieldNickname);
/*     */     
/* 228 */     JLabel lbloptional = new JLabel("(OPTIONAL)");
/* 229 */     lbloptional.setForeground(Color.GRAY);
/* 230 */     lbloptional.setFont(new Font("Lucida Grande", 0, 9));
/* 231 */     lbloptional.setBounds(101, 203, 52, 16);
/* 232 */     this.contentPane.add(lbloptional);
/* 233 */     btnBack.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 235 */             NewAccount.this.dispose();
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\NewAccount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */