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
/*     */ public class Students_Add
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTextField textField;
/*  34 */   private Stack desiredList = new Stack();
/*  35 */   private Course[] electiveList = new Course[2];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Students_Add() {
/*  42 */     setDefaultCloseOperation(3);
/*  43 */     setBounds(100, 100, 350, 530);
/*  44 */     this.contentPane = new JPanel();
/*  45 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  46 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  47 */     setContentPane(this.contentPane);
/*  48 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  50 */     JLabel lblName = new JLabel("Name:");
/*  51 */     lblName.setHorizontalAlignment(11);
/*  52 */     lblName.setFont(new Font("Lucida Grande", 1, 13));
/*  53 */     lblName.setBounds(27, 24, 42, 16);
/*  54 */     this.contentPane.add(lblName);
/*     */     
/*  56 */     this.textField = new JTextField();
/*  57 */     this.textField.setColumns(10);
/*  58 */     this.textField.setBounds(72, 19, 253, 26);
/*  59 */     this.contentPane.add(this.textField);
/*  60 */     String originalName = this.textField.getText();
/*     */     
/*  62 */     JLabel lblGrade = new JLabel("Grade:");
/*  63 */     lblGrade.setFont(new Font("Lucida Grande", 1, 13));
/*  64 */     lblGrade.setBounds(27, 57, 52, 16);
/*  65 */     this.contentPane.add(lblGrade);
/*     */     
/*  67 */     JLabel lblCourses = new JLabel("Courses:");
/*  68 */     lblCourses.setFont(new Font("Lucida Grande", 1, 13));
/*  69 */     lblCourses.setBounds(27, 91, 66, 16);
/*  70 */     this.contentPane.add(lblCourses);
/*     */ 
/*     */     
/*  73 */     String[] grade = { "9", "10", "11", "12" };
/*  74 */     final JComboBox<String> comboBox_grade = new JComboBox<>(grade);
/*  75 */     comboBox_grade.setBounds(75, 54, 70, 27);
/*  76 */     this.contentPane.add(comboBox_grade);
/*     */     
/*  78 */     final JComboBox<String> comboBox_courses = new JComboBox();
/*  79 */     comboBox_courses.setBounds(90, 87, 194, 27);
/*  80 */     this.contentPane.add(comboBox_courses);
/*  81 */     for (int i = 0; i < Login.courseList.size(); i++) {
/*  82 */       comboBox_courses.addItem(((Course)Login.courseList.get(i)).getCourseName());
/*     */     }
/*     */     
/*  85 */     final JTextArea textArea_course = new JTextArea();
/*  86 */     textArea_course.setEditable(false);
/*  87 */     textArea_course.setBounds(27, 147, 298, 171);
/*  88 */     this.contentPane.add(textArea_course);
/*     */     
/*  90 */     JButton btnAddCourse = new JButton("+");
/*  91 */     btnAddCourse.setBounds(283, 86, 42, 29);
/*  92 */     this.contentPane.add(btnAddCourse);
/*  93 */     btnAddCourse.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  95 */             int num = comboBox_courses.getSelectedIndex();
/*  96 */             if (!Students_Add.this.desiredList.contains(Login.courseList.get(num))) {
/*     */               
/*  98 */               Students_Add.this.desiredList.push(Login.courseList.get(num));
/*  99 */               Students_Add.updateArea(Students_Add.this.desiredList, textArea_course);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 105 */     JButton btnUndoCourse = new JButton("Undo");
/* 106 */     btnUndoCourse.setBounds(88, 114, 117, 29);
/* 107 */     this.contentPane.add(btnUndoCourse);
/* 108 */     btnUndoCourse.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 110 */             if (!Students_Add.this.desiredList.isEmpty()) {
/*     */               
/* 112 */               Course removed = Students_Add.this.desiredList.pop();
/* 113 */               Students_Add.updateArea(Students_Add.this.desiredList, textArea_course);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 118 */     JButton btnClearCourse = new JButton("Clear");
/* 119 */     btnClearCourse.setBounds(208, 114, 117, 29);
/* 120 */     this.contentPane.add(btnClearCourse);
/* 121 */     btnClearCourse.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 123 */             if (!Students_Add.this.desiredList.isEmpty()) {
/*     */               
/* 125 */               while (Students_Add.this.desiredList.size() > 0) {
/* 126 */                 Students_Add.this.desiredList.pop();
/*     */               }
/* 128 */               Students_Add.updateArea(Students_Add.this.desiredList, textArea_course);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 133 */     JLabel lblAlternativeElectives = new JLabel("Alternative Electives:");
/* 134 */     lblAlternativeElectives.setFont(new Font("Lucida Grande", 1, 13));
/* 135 */     lblAlternativeElectives.setBounds(27, 330, 167, 16);
/* 136 */     this.contentPane.add(lblAlternativeElectives);
/*     */     
/* 138 */     final JComboBox<String> comboBox_elective1 = new JComboBox();
/* 139 */     comboBox_elective1.setBounds(71, 351, 236, 27);
/* 140 */     this.contentPane.add(comboBox_elective1);
/* 141 */     for (int j = 0; j < Login.courseList.size(); j++) {
/* 142 */       comboBox_elective1.addItem(((Course)Login.courseList.get(j)).getCourseName());
/*     */     }
/*     */     
/* 145 */     JLabel lblFirst = new JLabel("1:");
/* 146 */     lblFirst.setBounds(37, 355, 61, 16);
/* 147 */     this.contentPane.add(lblFirst);
/*     */     
/* 149 */     JLabel lblSecond = new JLabel("2:");
/* 150 */     lblSecond.setBounds(37, 387, 61, 16);
/* 151 */     this.contentPane.add(lblSecond);
/*     */     
/* 153 */     final JComboBox<String> comboBox_elective2 = new JComboBox();
/* 154 */     comboBox_elective2.setBounds(71, 383, 236, 27);
/* 155 */     this.contentPane.add(comboBox_elective2);
/* 156 */     for (int k = 0; k < Login.courseList.size(); k++) {
/* 157 */       comboBox_elective2.addItem(((Course)Login.courseList.get(k)).getCourseName());
/*     */     }
/*     */ 
/*     */     
/* 161 */     final JCheckBox chckbxIbDiploma = new JCheckBox("IBDP candidate?");
/* 162 */     chckbxIbDiploma.setFont(new Font("Lucida Grande", 1, 13));
/* 163 */     chckbxIbDiploma.setBounds(160, 54, 173, 23);
/* 164 */     this.contentPane.add(chckbxIbDiploma);
/* 165 */     chckbxIbDiploma.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 167 */             if (chckbxIbDiploma.isSelected()) {
/* 168 */               comboBox_elective2.setEnabled(false);
/* 169 */               comboBox_elective1.setEnabled(false);
/*     */             } else {
/*     */               
/* 172 */               comboBox_elective2.setEnabled(true);
/* 173 */               comboBox_elective1.setEnabled(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 181 */     JButton btnBack = new JButton("← Back");
/* 182 */     btnBack.setBounds(66, 429, 105, 40);
/* 183 */     this.contentPane.add(btnBack);
/* 184 */     btnBack.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 186 */             int a = JOptionPane.showConfirmDialog(Students_Add.this.contentPane, "Your progress will not be saved. Do you still wish to continue?", null, 0);
/* 187 */             if (a == 0) {
/* 188 */               Students_Add.this.dispose();
/* 189 */               Students_Menu sm = new Students_Menu();
/* 190 */               sm.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     JButton btnAddStudent = new JButton("Add Student");
/* 200 */     btnAddStudent.setBounds(179, 429, 105, 40);
/* 201 */     this.contentPane.add(btnAddStudent);
/* 202 */     btnAddStudent.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 205 */             int temp = 0;
/* 206 */             boolean multiple = false;
/* 207 */             boolean duplicate = false;
/*     */             
/* 209 */             for (int i = 0; i < Students_Add.this.desiredList.size(); i++) {
/* 210 */               if (((Course)Students_Add.this.desiredList.get(i)).getCourseName() == comboBox_elective1.getSelectedItem()) multiple = true; 
/* 211 */               if (((Course)Students_Add.this.desiredList.get(i)).getCourseName() == comboBox_elective2.getSelectedItem()) multiple = true;
/*     */             
/*     */             } 
/* 214 */             if (Students_Add.this.textField.getText().equalsIgnoreCase("")) {
/* 215 */               Login.infoBox("Please enter the name of the student.", "");
/*     */             }
/* 217 */             else if (duplicate) {
/* 218 */               Login.infoBox("There already exists a student with this name.", "");
/*     */             }
/* 220 */             else if (Students_Add.this.desiredList.size() != 7) {
/* 221 */               Login.infoBox("Please enter 7 desired courses.", "");
/*     */             }
/* 223 */             else if (!chckbxIbDiploma.isSelected()) {
/* 224 */               if (comboBox_elective1.getSelectedItem() == comboBox_elective2.getSelectedItem() || multiple) {
/*     */                 
/* 226 */                 Login.infoBox("You cannot have multiple listings of one course.", "");
/*     */               } else {
/*     */                 
/* 229 */                 Students_Add.this.electiveList[0] = Login.courseList.get(comboBox_elective1.getSelectedIndex());
/* 230 */                 Students_Add.this.electiveList[1] = Login.courseList.get(comboBox_elective2.getSelectedIndex());
/* 231 */                 Non_IBDP_Student newStudent = new Non_IBDP_Student(Students_Add.this.textField.getText(), Integer.valueOf(comboBox_grade.getSelectedItem().toString()).intValue(), "Non-IBDP", Students_Add.this.desiredList, Students_Add.this.electiveList);
/* 232 */                 Login.studentList.add(newStudent);
/* 233 */                 Students_Add.saveListToFile();
/*     */                 
/* 235 */                 if (Login.studentList.contains(newStudent)) {
/* 236 */                   Login.infoBox("The student '" + Students_Add.this.textField.getText() + "' was successfully added.", "");
/* 237 */                   Students_Add.this.dispose();
/* 238 */                   Students_Menu sm = new Students_Menu();
/* 239 */                   sm.setVisible(true);
/*     */                 } else {
/* 241 */                   Login.infoBox("There was a problem with saving your student. Please contact the administrator.", "");
/*     */                 }
/*     */               
/*     */               } 
/* 245 */             } else if (chckbxIbDiploma.isSelected()) {
/* 246 */               Student newStudent = new Student(Students_Add.this.textField.getText(), Integer.valueOf(comboBox_grade.getSelectedItem().toString()).intValue(), "IBDP", Students_Add.this.desiredList);
/* 247 */               Login.studentList.add(newStudent);
/* 248 */               Students_Add.saveListToFile();
/*     */               
/* 250 */               if (Login.studentList.contains(newStudent)) {
/* 251 */                 Login.infoBox("The student '" + Students_Add.this.textField.getText() + "' was successfully added.", "");
/* 252 */                 Students_Add.this.dispose();
/* 253 */                 Students_Menu sm = new Students_Menu();
/* 254 */                 sm.setVisible(true);
/*     */               } else {
/* 256 */                 Login.infoBox("There was a problem with saving your student. Please contact the administrator.", "");
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateArea(Stack<Course> tList, JTextArea a) {
/* 265 */     a.setText("");
/* 266 */     for (int i = 0; i < tList.size(); i++) {
/* 267 */       String s = ((Course)tList.get(i)).getCourseName();
/* 268 */       a.append(String.valueOf(s) + "\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 274 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studentList.dat"));
/* 275 */       out.writeObject(Login.studentList);
/* 276 */       out.close(); }
/* 277 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Students_Add.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */