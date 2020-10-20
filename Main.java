/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   static boolean loaded = false;
/*  26 */   JButton btnNewSchedule = new JButton("New Schedule");
/*  27 */   JButton btnConfiguration = new JButton("Configuration");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Main() {
/*  34 */     setDefaultCloseOperation(3);
/*  35 */     setBounds(10, 10, 700, 500);
/*  36 */     this.contentPane = new JPanel();
/*  37 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  38 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  39 */     setContentPane(this.contentPane);
/*  40 */     this.contentPane.setLayout((LayoutManager)null);
/*     */ 
/*     */     
/*  43 */     this.btnNewSchedule.setBounds(142, 240, 422, 57);
/*  44 */     this.contentPane.add(this.btnNewSchedule);
/*  45 */     this.btnNewSchedule.setEnabled(Login.settingsDone);
/*  46 */     this.btnNewSchedule.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  48 */             boolean contin = Main.this.checkValid();
/*  49 */             if (contin) {
/*  50 */               Main.this.dispose();
/*  51 */               Generate_Schedule gs = new Generate_Schedule();
/*  52 */               gs.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  58 */     JButton btnLoadSchedule = new JButton("Load Schedule");
/*  59 */     btnLoadSchedule.setBounds(142, 302, 422, 57);
/*  60 */     this.contentPane.add(btnLoadSchedule);
/*  61 */     btnLoadSchedule.setEnabled((Login.moreThanOneSavedSchedule && Login.settingsDone));
/*  62 */     btnLoadSchedule.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  64 */             Main.this.dispose();
/*  65 */             Load_Menu ls = new Load_Menu();
/*  66 */             ls.setVisible(true);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  71 */     JButton btnCourses = new JButton("Courses");
/*  72 */     btnCourses.setBounds(142, 365, 136, 57);
/*  73 */     this.contentPane.add(btnCourses);
/*  74 */     btnCourses.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  76 */             if (Login.studentList.size() != 0) {
/*  77 */               String inputValue = JOptionPane.showInputDialog("\nEditing course information will reset all student data and save files. \n\nIf you wish to continue, please enter 'reset'.");
/*  78 */               if (inputValue != null) {
/*  79 */                 if (inputValue.equalsIgnoreCase("reset")) {
/*  80 */                   Login.studentList.clear();
/*  81 */                   Login.scheduleList.clear();
/*  82 */                   JOptionPane.showMessageDialog(Main.this.contentPane, "Displaying course menu.");
/*  83 */                   Main.this.dispose();
/*  84 */                   Courses_Menu cm = new Courses_Menu();
/*  85 */                   cm.setVisible(true);
/*     */                 } else {
/*     */                   
/*  88 */                   JOptionPane.showMessageDialog(Main.this.contentPane, "Please re-enter phrase.");
/*     */                 } 
/*     */               }
/*     */             } else {
/*  92 */               JOptionPane.showMessageDialog(Main.this.contentPane, "Displaying course menu.");
/*  93 */               Main.this.dispose();
/*  94 */               Courses_Menu cm = new Courses_Menu();
/*  95 */               cm.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 100 */     JButton btnStudents = new JButton("Students");
/* 101 */     btnStudents.setBounds(285, 365, 136, 57);
/* 102 */     this.contentPane.add(btnStudents);
/* 103 */     if (Login.courseList.size() == 0) btnStudents.setEnabled(false); 
/* 104 */     btnStudents.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 106 */             String inputValue = JOptionPane.showInputDialog("\nYou will not be able to enter or edit course information until you reset all student data. \n\nIf you wish to continue, please enter 'lock'.");
/* 107 */             if (inputValue != null) {
/* 108 */               if (inputValue.equalsIgnoreCase("lock")) {
/* 109 */                 JOptionPane.showMessageDialog(Main.this.contentPane, "Displaying student menu.");
/* 110 */                 Main.this.dispose();
/* 111 */                 Students_Menu sm = new Students_Menu();
/* 112 */                 sm.setVisible(true);
/*     */               } else {
/*     */                 
/* 115 */                 JOptionPane.showMessageDialog(Main.this.contentPane, "Please re-enter phrase.");
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/* 120 */     this.btnConfiguration.setBounds(428, 365, 136, 57);
/* 121 */     this.contentPane.add(this.btnConfiguration);
/* 122 */     if (Login.restrictionList[0] == 0) this.btnConfiguration.setEnabled(false); 
/* 123 */     this.btnConfiguration.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 125 */             JOptionPane.showMessageDialog(Main.this.contentPane, "Displaying configuration menu.");
/* 126 */             Main.this.dispose();
/* 127 */             Restrictions rap = new Restrictions();
/* 128 */             rap.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 132 */     JLabel lblAesScheduler = new JLabel("S M A R T");
/* 133 */     lblAesScheduler.setForeground(Color.ORANGE);
/* 134 */     lblAesScheduler.setHorizontalAlignment(0);
/* 135 */     lblAesScheduler.setFont(new Font("Lucida Grande", 0, 50));
/* 136 */     lblAesScheduler.setBounds(195, 70, 321, 79);
/* 137 */     this.contentPane.add(lblAesScheduler);
/*     */     
/* 139 */     JLabel lblScheduler = new JLabel("SCHEDULER");
/* 140 */     lblScheduler.setHorizontalAlignment(0);
/* 141 */     lblScheduler.setFont(new Font("Lucida Grande", 0, 50));
/* 142 */     lblScheduler.setBounds(193, 138, 321, 79);
/* 143 */     this.contentPane.add(lblScheduler);
/*     */     
/* 145 */     JLabel lblUserName = new JLabel(Login.userName);
/* 146 */     lblUserName.setHorizontalAlignment(11);
/* 147 */     lblUserName.setBounds(583, 6, 97, 16);
/* 148 */     this.contentPane.add(lblUserName);
/*     */     
/* 150 */     JLabel lblAccessTime = new JLabel("access time: " + Login.currentTime);
/* 151 */     lblAccessTime.setHorizontalAlignment(11);
/* 152 */     lblAccessTime.setBounds(442, 26, 238, 16);
/* 153 */     this.contentPane.add(lblAccessTime);
/*     */     
/* 155 */     JLabel lblAdmin = new JLabel(Login.userType);
/* 156 */     lblAdmin.setHorizontalAlignment(11);
/* 157 */     lblAdmin.setBounds(583, 44, 97, 16);
/* 158 */     this.contentPane.add(lblAdmin);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkValid() {
/* 163 */     if (Login.studentList.size() == 0) {
/* 164 */       Login.infoBox("You don't have any students.", "");
/*     */     }
/* 166 */     else if (Login.courseList.size() == 0) {
/* 167 */       Login.infoBox("You don't have any courses.", "");
/*     */     }
/* 169 */     else if (Login.restrictionList[0] == 0) {
/* 170 */       Login.infoBox("You need to set the restrictions.", "");
/*     */     } 
/*     */ 
/*     */     
/* 174 */     String display = "";
/* 175 */     for (int i = 0; i < Login.courseList.size(); i++) {
/* 176 */       int includeCount = 0;
/* 177 */       for (int m = 0; m < Login.studentList.size(); m++) {
/* 178 */         for (int n = 0; n < ((Student)Login.studentList.get(m)).getDesiredList().size(); n++) {
/* 179 */           if (((Course)((Student)Login.studentList.get(m)).getDesiredList().get(n)).getCourseName().equalsIgnoreCase(((Course)Login.courseList.get(i)).getCourseName())) includeCount++; 
/*     */         } 
/*     */       } 
/* 182 */       double division = includeCount / ((Course)Login.courseList.get(i)).getMaxCapacity();
/*     */       
/* 184 */       int div = Double.valueOf(Math.ceil(division)).intValue();
/*     */       
/* 186 */       ((Course)Login.courseList.get(i)).setCourseNum(div);
/* 187 */       display = String.valueOf(display) + "\n" + ((Course)Login.courseList.get(i)).getCourseName() + ": " + ((Course)Login.courseList.get(i)).getCourseNum() + " classes needed";
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 192 */     String prob = "";
/* 193 */     for (int j = 0; j < Login.courseList.size(); j++) {
/* 194 */       ((Course)Login.courseList.get(j)).setStudentNum(0);
/* 195 */       for (int m = 0; m < Login.studentList.size(); m++) {
/* 196 */         for (int n = 0; n < ((Student)Login.studentList.get(m)).getDesiredList().size(); n++) {
/* 197 */           if (((Course)((Student)Login.studentList.get(m)).getDesiredList().get(n)).getCourseName().equalsIgnoreCase(((Course)Login.courseList.get(j)).getCourseName())) {
/* 198 */             ((Course)Login.courseList.get(j)).setStudentNum(((Course)Login.courseList.get(j)).getStudentNum() + 1);
/*     */           }
/*     */         } 
/*     */       } 
/* 202 */       if (((Course)Login.courseList.get(j)).getStudentNum() < ((Course)Login.courseList.get(j)).getMinCapacity()) {
/* 203 */         prob = String.valueOf(prob) + "\n *" + ((Course)Login.courseList.get(j)).getCourseName() + " w/ min capacity " + ((Course)Login.courseList.get(j)).getMinCapacity() + " only has " + ((Course)Login.courseList.get(j)).getStudentNum() + " students.";
/*     */       }
/*     */     } 
/*     */     
/* 207 */     Login.infoBox(String.valueOf(display) + "\n" + prob, "");
/* 208 */     if (!prob.equalsIgnoreCase("")) return false;
/*     */ 
/*     */     
/* 211 */     int cumCourseNum = 0;
/* 212 */     for (int k = 0; k < Login.courseList.size(); k++) {
/* 213 */       cumCourseNum += ((Course)Login.courseList.get(k)).getCourseNum();
/*     */     }
/*     */     
/* 216 */     if (Login.teacherList.size() * Login.restrictionList[0] < cumCourseNum) {
/* 217 */       Login.infoBox("You have more courses than teachers can teach according to your restrictions.", "");
/* 218 */       return false;
/*     */     } 
/*     */     
/* 221 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */