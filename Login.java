/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Login
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTextField textField;
/*     */   static boolean settingsDone = false;
/*     */   static boolean moreThanOneSavedSchedule = false;
/*     */   static String userEmail;
/*     */   static int userCount;
/*     */   String userPw;
/*     */   static String userName;
/*     */   static String userType;
/*     */   boolean wrong;
/*     */   static String currentTime;
/*  50 */   static ArrayList<Teacher> teacherList = new ArrayList<>();
/*  51 */   static ArrayList<Course> courseList = new ArrayList<>();
/*  52 */   static ArrayList<Student> studentList = new ArrayList<>();
/*  53 */   static ArrayList<Main_Schedule> scheduleList = new ArrayList<>();
/*     */   
/*  55 */   static int[] restrictionList = new int[2];
/*     */   
/*  57 */   DBConnection connection = new DBConnection();
/*     */ 
/*     */   
/*     */   private JPasswordField password;
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  65 */     EventQueue.invokeLater(new Runnable() {
/*     */           public void run() {
/*     */             try {
/*  68 */               Login frame = new Login();
/*  69 */               frame.setVisible(true);
/*  70 */             } catch (Exception e) {
/*  71 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Login() {
/*  82 */     restrictionList[0] = 0;
/*     */     
/*  84 */     setDefaultCloseOperation(3);
/*  85 */     setBounds(100, 100, 400, 220);
/*  86 */     this.contentPane = new JPanel();
/*  87 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  88 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  89 */     setContentPane(this.contentPane);
/*  90 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  92 */     makeTeacherList();
/*  93 */     readCourseListFromFile();
/*  94 */     readStudentListFromFile();
/*  95 */     readRestrictionListFromFile();
/*  96 */     readScheduleListFromFile();
/*     */     
/*  98 */     if (restrictionList[0] != 0 && studentList.size() != 0 && courseList.size() != 0) { settingsDone = true; }
/*  99 */     else { settingsDone = false; }
/*     */     
/* 101 */     this.textField = new JTextField();
/* 102 */     this.textField.setBounds(127, 60, 168, 26);
/* 103 */     this.contentPane.add(this.textField);
/* 104 */     this.textField.setColumns(10);
/*     */     
/* 106 */     JLabel lblId = new JLabel("ID:");
/* 107 */     lblId.setHorizontalAlignment(11);
/* 108 */     lblId.setBounds(88, 65, 29, 16);
/* 109 */     this.contentPane.add(lblId);
/*     */     
/* 111 */     JLabel lblPw = new JLabel("PW:");
/* 112 */     lblPw.setHorizontalAlignment(11);
/* 113 */     lblPw.setBounds(88, 93, 29, 16);
/* 114 */     this.contentPane.add(lblPw);
/*     */     
/* 116 */     JButton btnLogin = new JButton("Login");
/* 117 */     btnLogin.setBounds(156, 126, 88, 43);
/* 118 */     this.contentPane.add(btnLogin);
/* 119 */     btnLogin.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*     */             try {
/* 122 */               Login.this.login();
/* 123 */             } catch (SQLException e1) {
/*     */               
/* 125 */               e1.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/* 129 */     this.password = new JPasswordField();
/* 130 */     this.password.setBounds(127, 88, 168, 26);
/* 131 */     this.contentPane.add(this.password);
/*     */     
/* 133 */     JLabel lblNewLabel = new JLabel("Testing:\n");
/* 134 */     lblNewLabel.setBounds(6, 6, 100, 16);
/* 135 */     this.contentPane.add(lblNewLabel);
/*     */     
/* 137 */     JLabel lblIdXyxyxygooglecom = new JLabel("\nID: xyxyxy@google.com / PW: admin");
/* 138 */     lblIdXyxyxygooglecom.setBounds(16, 25, 251, 16);
/* 139 */     this.contentPane.add(lblIdXyxyxygooglecom);
/* 140 */     this.password.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*     */             try {
/* 143 */               Login.this.login();
/* 144 */             } catch (SQLException e1) {
/*     */               
/* 146 */               e1.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   public void login() throws SQLException {
/* 152 */     char[] tempPass = this.password.getPassword();
/* 153 */     String typedPassword = new String(tempPass);
/*     */     
/*     */     try {
/* 156 */       Statement stmt = DBConnection.con.createStatement();
/* 157 */       ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Users");
/* 158 */       if (rs.next()) {
/* 159 */         String userCountString = rs.getString("COUNT(*)");
/* 160 */         userCount = Integer.parseInt(userCountString);
/*     */       } 
/* 162 */       ResultSet rs2 = stmt.executeQuery("SELECT userName FROM Users WHERE userEmail = '" + this.textField.getText() + "' AND userPW = '" + typedPassword + "'");
/* 163 */       if (rs2.next()) {
/* 164 */         userName = rs2.getString("userName");
/*     */       }
/* 166 */       if (rs2.getRow() == 0) { this.wrong = true; }
/* 167 */       else { this.wrong = false; }
/*     */       
/* 169 */       ResultSet rs3 = stmt.executeQuery("SELECT userType FROM Users WHERE userEmail = '" + this.textField.getText() + "' AND userPW = '" + typedPassword + "'");
/* 170 */       if (rs3.next()) {
/* 171 */         userType = rs3.getString("userType");
/*     */       }
/*     */     }
/* 174 */     catch (Exception e2) {
/* 175 */       System.out.println("ERROR: " + e2.getMessage());
/* 176 */       System.out.println("Exception while accessing Database. Please contact the administrator.");
/*     */     } 
/*     */     
/* 179 */     if (this.wrong) { infoBox("Wrong ID or password. Please try again.", ""); }
/*     */     
/* 181 */     else if (!this.wrong)
/* 182 */     { infoBox("Welcome, " + userName + "!", "");
/*     */       
/* 184 */       Date dt = new Date();
/*     */       
/* 186 */       SimpleDateFormat sdf = 
/* 187 */         new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */       
/* 189 */       currentTime = sdf.format(dt);
/*     */       
/* 191 */       String myQuery = "UPDATE `Users` SET `lastAccessed` = ? WHERE `userEmail` = ?";
/* 192 */       PreparedStatement updateUser = DBConnection.con.prepareStatement(myQuery);
/* 193 */       updateUser.setString(1, currentTime);
/* 194 */       updateUser.setString(2, this.textField.getText());
/*     */       
/* 196 */       updateUser.executeUpdate();
/*     */       
/* 198 */       dispose();
/* 199 */       Main m = new Main();
/* 200 */       m.setVisible(true); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void makeTeacherList() {
/* 206 */     Teacher t1 = new Teacher("Argus Filch", 1, new ArrayList<>());
/* 207 */     Teacher t2 = new Teacher("Albus Dumbledore", 5, new ArrayList<>());
/* 208 */     Teacher t3 = new Teacher("Filius Flitwick", 4, new ArrayList<>());
/* 209 */     Teacher t4 = new Teacher("Rubeus Hagrid", 2, new ArrayList<>());
/* 210 */     Teacher t5 = new Teacher("Gilderoy Lockhart", 3, new ArrayList<>());
/* 211 */     Teacher t6 = new Teacher("Remus Lupin", 4, new ArrayList<>());
/* 212 */     Teacher t7 = new Teacher("Minerva McGonagall", 6, new ArrayList<>());
/* 213 */     Teacher t8 = new Teacher("Alastor Moody", 1, new ArrayList<>());
/* 214 */     Teacher t9 = new Teacher("Poppy Pomfrey", 2, new ArrayList<>());
/* 215 */     Teacher t10 = new Teacher("Severus Snape", 3, new ArrayList<>());
/* 216 */     Teacher t11 = new Teacher("Pomona Sprout", 4, new ArrayList<>());
/* 217 */     Teacher t12 = new Teacher("Sybill Trelawney", 5, new ArrayList<>());
/*     */     
/* 219 */     teacherList.add(t1);
/* 220 */     teacherList.add(t2);
/* 221 */     teacherList.add(t3);
/* 222 */     teacherList.add(t4);
/* 223 */     teacherList.add(t5);
/* 224 */     teacherList.add(t6);
/* 225 */     teacherList.add(t7);
/* 226 */     teacherList.add(t8);
/* 227 */     teacherList.add(t9);
/* 228 */     teacherList.add(t10);
/* 229 */     teacherList.add(t11);
/* 230 */     teacherList.add(t12);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ArrayList<Student> readStudentListFromFile() {
/*     */     
/* 237 */     try { ObjectInputStream in = new ObjectInputStream(new FileInputStream("studentList.dat"));
/* 238 */       studentList = (ArrayList<Student>)in.readObject();
/* 239 */       in.close(); }
/* 240 */     catch (IOException e) { e.printStackTrace(); }
/* 241 */     catch (ClassNotFoundException classNotFoundException) {}
/* 242 */     return studentList;
/*     */   }
/*     */   
/*     */   public static ArrayList<Course> readCourseListFromFile() {
/*     */     
/* 247 */     try { ObjectInputStream in = new ObjectInputStream(new FileInputStream("courseList.dat"));
/* 248 */       courseList = (ArrayList<Course>)in.readObject();
/* 249 */       in.close(); }
/* 250 */     catch (IOException e) { e.printStackTrace(); }
/* 251 */     catch (ClassNotFoundException classNotFoundException) {}
/* 252 */     return courseList;
/*     */   }
/*     */   public static int[] readRestrictionListFromFile() {
/*     */     
/* 256 */     try { ObjectInputStream in = new ObjectInputStream(new FileInputStream("restrictionList.dat"));
/* 257 */       restrictionList = (int[])in.readObject();
/* 258 */       in.close(); }
/* 259 */     catch (IOException e) { e.printStackTrace(); }
/* 260 */     catch (ClassNotFoundException classNotFoundException) {}
/* 261 */     return restrictionList;
/*     */   }
/*     */   
/*     */   public static ArrayList<Main_Schedule> readScheduleListFromFile() {
/*     */     
/* 266 */     try { ObjectInputStream in = new ObjectInputStream(new FileInputStream("scheduleList.dat"));
/* 267 */       scheduleList = (ArrayList<Main_Schedule>)in.readObject();
/* 268 */       if (scheduleList.size() != 0) moreThanOneSavedSchedule = true; 
/* 269 */       in.close(); }
/* 270 */     catch (IOException e) { e.printStackTrace(); }
/* 271 */     catch (ClassNotFoundException classNotFoundException) {}
/* 272 */     return scheduleList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void infoBox(String infoMessage, String titleBar) {
/* 278 */     JOptionPane.showMessageDialog(null, infoMessage, titleBar, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Login.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */