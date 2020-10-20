/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Stack;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
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
/*     */ public class Courses_Add
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTextField textField_name;
/*     */   
/*     */   public Courses_Add() {
/*  39 */     setDefaultCloseOperation(3);
/*  40 */     setBounds(100, 100, 340, 470);
/*  41 */     this.contentPane = new JPanel();
/*  42 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  43 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  44 */     setContentPane(this.contentPane);
/*  45 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  47 */     final Stack<Teacher> teacherList = new Stack<>();
/*     */     
/*  49 */     this.textField_name = new JTextField();
/*  50 */     this.textField_name.setBounds(65, 20, 253, 26);
/*  51 */     this.contentPane.add(this.textField_name);
/*  52 */     this.textField_name.setColumns(10);
/*     */     
/*  54 */     JLabel lblName = new JLabel("Name:");
/*  55 */     lblName.setFont(new Font("Lucida Grande", 1, 13));
/*  56 */     lblName.setHorizontalAlignment(11);
/*  57 */     lblName.setBounds(20, 25, 42, 16);
/*  58 */     this.contentPane.add(lblName);
/*     */     
/*  60 */     JLabel lblWorkload = new JLabel("Workload:");
/*  61 */     lblWorkload.setFont(new Font("Lucida Grande", 1, 13));
/*  62 */     lblWorkload.setHorizontalAlignment(11);
/*  63 */     lblWorkload.setBounds(20, 58, 66, 16);
/*  64 */     this.contentPane.add(lblWorkload);
/*     */     
/*  66 */     String[] workload = { "minimal", "light", "average", "heavy" };
/*  67 */     final JComboBox<String> comboBox_workload = new JComboBox<>(workload);
/*  68 */     comboBox_workload.setBounds(89, 54, 113, 27);
/*  69 */     this.contentPane.add(comboBox_workload);
/*     */     
/*  71 */     JLabel lblStudentCapacity = new JLabel("Student Capacity:");
/*  72 */     lblStudentCapacity.setFont(new Font("Lucida Grande", 1, 13));
/*  73 */     lblStudentCapacity.setHorizontalAlignment(11);
/*  74 */     lblStudentCapacity.setBounds(20, 88, 117, 16);
/*  75 */     this.contentPane.add(lblStudentCapacity);
/*     */     
/*  77 */     String[] minCap = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" };
/*  78 */     final JComboBox<String> comboBox_minCap = new JComboBox<>(minCap);
/*  79 */     comboBox_minCap.setBounds(141, 84, 78, 27);
/*  80 */     this.contentPane.add(comboBox_minCap);
/*     */     
/*  82 */     JLabel lblNewLabel = new JLabel("~");
/*  83 */     lblNewLabel.setBounds(225, 88, 19, 16);
/*  84 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  86 */     String[] maxCap = { "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
/*  87 */     final JComboBox<String> comboBox_maxCap = new JComboBox<>(maxCap);
/*  88 */     comboBox_maxCap.setBounds(240, 84, 78, 27);
/*  89 */     this.contentPane.add(comboBox_maxCap);
/*     */     
/*  91 */     JLabel lblTeachers = new JLabel("Teachers:");
/*  92 */     lblTeachers.setFont(new Font("Lucida Grande", 1, 13));
/*  93 */     lblTeachers.setBounds(20, 118, 66, 16);
/*  94 */     this.contentPane.add(lblTeachers);
/*     */     
/*  96 */     final JComboBox<String> comboBox_teachers = new JComboBox();
/*  97 */     comboBox_teachers.setBounds(88, 114, 192, 27);
/*  98 */     this.contentPane.add(comboBox_teachers);
/*  99 */     for (int i = 0; i < Login.teacherList.size(); i++) {
/* 100 */       comboBox_teachers.addItem(((Teacher)Login.teacherList.get(i)).getTeacherName());
/*     */     }
/*     */     
/* 103 */     final JTextArea textArea_teachers = new JTextArea();
/* 104 */     textArea_teachers.setEditable(false);
/* 105 */     textArea_teachers.setBounds(20, 179, 298, 171);
/* 106 */     this.contentPane.add(textArea_teachers);
/*     */     
/* 108 */     JButton btnUndoTeacher = new JButton("Undo");
/* 109 */     btnUndoTeacher.setBounds(86, 142, 117, 29);
/* 110 */     this.contentPane.add(btnUndoTeacher);
/* 111 */     btnUndoTeacher.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 113 */             if (!teacherList.isEmpty()) {
/*     */               
/* 115 */               Teacher removed = teacherList.pop();
/* 116 */               Courses_Add.updateArea(teacherList, textArea_teachers);
/*     */             } 
/*     */           }
/*     */         });
/* 120 */     JButton btnClearTeacher = new JButton("Clear");
/* 121 */     btnClearTeacher.setBounds(205, 142, 117, 29);
/* 122 */     this.contentPane.add(btnClearTeacher);
/* 123 */     btnClearTeacher.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 125 */             if (!teacherList.isEmpty()) {
/*     */               
/* 127 */               while (teacherList.size() > 0) {
/* 128 */                 teacherList.pop();
/*     */               }
/* 130 */               Courses_Add.updateArea(teacherList, textArea_teachers);
/*     */             } 
/*     */           }
/*     */         });
/* 134 */     JButton btnAddTeacher = new JButton("+");
/* 135 */     btnAddTeacher.setBounds(279, 113, 42, 29);
/* 136 */     this.contentPane.add(btnAddTeacher);
/* 137 */     btnAddTeacher.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 139 */             int num = comboBox_teachers.getSelectedIndex();
/* 140 */             if (!teacherList.contains(Login.teacherList.get(num))) {
/*     */               
/* 142 */               teacherList.push(Login.teacherList.get(num));
/* 143 */               Courses_Add.updateArea(teacherList, textArea_teachers);
/*     */             } 
/*     */           }
/*     */         });
/* 147 */     final JCheckBox chckbxIb = new JCheckBox("IB course?");
/* 148 */     chckbxIb.setFont(new Font("Lucida Grande", 1, 13));
/* 149 */     chckbxIb.setBounds(205, 54, 128, 23);
/* 150 */     this.contentPane.add(chckbxIb);
/*     */     
/* 152 */     JButton btnAddCourse = new JButton("Add Course");
/* 153 */     btnAddCourse.setBounds(166, 377, 105, 40);
/* 154 */     this.contentPane.add(btnAddCourse);
/* 155 */     btnAddCourse.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 157 */             int workload = 0;
/*     */             
/* 159 */             if (comboBox_workload.getSelectedItem() == "minimal") { workload = 0; }
/* 160 */             else if (comboBox_workload.getSelectedItem() == "light") { workload = 1; }
/* 161 */             else if (comboBox_workload.getSelectedItem() == "average") { workload = 2; }
/* 162 */             else if (comboBox_workload.getSelectedItem() == "heavy") { workload = 3; }
/*     */             
/* 164 */             boolean duplicate = false;
/* 165 */             for (int i = 0; i < Login.courseList.size(); i++) {
/* 166 */               if (((Course)Login.courseList.get(i)).getCourseName().equalsIgnoreCase(Courses_Add.this.textField_name.getText())) duplicate = true;
/*     */             
/*     */             } 
/* 169 */             if (teacherList.isEmpty()) {
/* 170 */               Login.infoBox("Please enter at least one teacher.", "");
/*     */             }
/* 172 */             else if (Courses_Add.this.textField_name.getText() == "") {
/* 173 */               Login.infoBox("Please enter the name of the course.", "");
/*     */             }
/* 175 */             else if (duplicate) {
/* 176 */               Login.infoBox("There already exists a course with this name.", "");
/*     */             
/*     */             }
/* 179 */             else if (chckbxIb.isSelected()) {
/* 180 */               Course newCourse = new Course(Courses_Add.this.textField_name.getText(), "IB", workload, teacherList, Integer.parseInt((String)comboBox_minCap.getSelectedItem()), Integer.parseInt((String)comboBox_maxCap.getSelectedItem()));
/* 181 */               Login.courseList.add(newCourse);
/* 182 */               Courses_Add.saveListToFile();
/*     */               
/* 184 */               if (Login.courseList.contains(newCourse)) {
/* 185 */                 Login.infoBox("The course '" + Courses_Add.this.textField_name.getText() + "' was successfully added.", "");
/* 186 */                 Courses_Add.this.dispose();
/* 187 */                 Courses_Menu cm = new Courses_Menu();
/* 188 */                 cm.setVisible(true);
/*     */               } else {
/* 190 */                 Login.infoBox("There was a problem with saving your course. Please contact the administrator.", "");
/*     */               } 
/*     */             } else {
/*     */               
/* 194 */               Course newCourse = new Course(Courses_Add.this.textField_name.getText(), "non-IB", workload, teacherList, Integer.parseInt((String)comboBox_minCap.getSelectedItem()), Integer.parseInt((String)comboBox_maxCap.getSelectedItem()));
/* 195 */               Login.courseList.add(newCourse);
/* 196 */               Courses_Add.saveListToFile();
/*     */               
/* 198 */               if (Login.courseList.contains(newCourse)) {
/* 199 */                 Login.infoBox("The course '" + Courses_Add.this.textField_name.getText() + "' was successfully added.", "");
/* 200 */                 Courses_Add.this.dispose();
/* 201 */                 Courses_Menu cm = new Courses_Menu();
/* 202 */                 cm.setVisible(true);
/*     */               } else {
/* 204 */                 Login.infoBox("There was a problem with saving your course. Please contact the administrator.", "");
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 212 */     JButton btnBack = new JButton("← Back");
/* 213 */     btnBack.setBounds(54, 377, 105, 40);
/* 214 */     this.contentPane.add(btnBack);
/* 215 */     btnBack.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 218 */             int a = JOptionPane.showConfirmDialog(Courses_Add.this.contentPane, "Your progress will not be saved. Do you still wish to continue?", null, 0);
/* 219 */             if (a == 0) {
/* 220 */               Courses_Add.this.dispose();
/* 221 */               Courses_Menu cm = new Courses_Menu();
/* 222 */               cm.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void updateArea(Stack<Teacher> tList, JTextArea a) {
/* 233 */     a.setText("");
/* 234 */     for (int i = 0; i < tList.size(); i++) {
/* 235 */       String s = ((Teacher)tList.get(i)).getTeacherName();
/* 236 */       a.append(String.valueOf(s) + "\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 242 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("courseList.dat"));
/* 243 */       out.writeObject(Login.courseList);
/* 244 */       out.close(); }
/* 245 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Courses_Add.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */