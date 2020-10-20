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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Courses_Edit
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTextField textField_name;
/*     */   
/*     */   public Courses_Edit() {
/*  42 */     setDefaultCloseOperation(3);
/*  43 */     setBounds(100, 100, 340, 470);
/*  44 */     this.contentPane = new JPanel();
/*  45 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  46 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  47 */     setContentPane(this.contentPane);
/*  48 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  50 */     this.textField_name = new JTextField();
/*  51 */     this.textField_name.setBounds(68, 12, 253, 26);
/*  52 */     this.contentPane.add(this.textField_name);
/*  53 */     this.textField_name.setColumns(10);
/*  54 */     this.textField_name.setText(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getCourseName());
/*  55 */     final String originalName = ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getCourseName();
/*     */     
/*  57 */     JLabel lblName = new JLabel("Name:");
/*  58 */     lblName.setFont(new Font("Lucida Grande", 1, 13));
/*  59 */     lblName.setHorizontalAlignment(11);
/*  60 */     lblName.setBounds(23, 17, 42, 16);
/*  61 */     this.contentPane.add(lblName);
/*     */     
/*  63 */     JLabel lblStudentCapacity = new JLabel("Student Capacity:");
/*  64 */     lblStudentCapacity.setFont(new Font("Lucida Grande", 1, 13));
/*  65 */     lblStudentCapacity.setHorizontalAlignment(11);
/*  66 */     lblStudentCapacity.setBounds(23, 82, 117, 16);
/*  67 */     this.contentPane.add(lblStudentCapacity);
/*     */     
/*  69 */     JLabel lblTeachers = new JLabel("Teachers:");
/*  70 */     lblTeachers.setFont(new Font("Lucida Grande", 1, 13));
/*  71 */     lblTeachers.setBounds(23, 112, 66, 16);
/*  72 */     this.contentPane.add(lblTeachers);
/*     */     
/*  74 */     JLabel lblNewLabel = new JLabel("~");
/*  75 */     lblNewLabel.setBounds(228, 82, 19, 16);
/*  76 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  78 */     JLabel label = new JLabel("Workload:");
/*  79 */     label.setHorizontalAlignment(11);
/*  80 */     label.setFont(new Font("Lucida Grande", 1, 13));
/*  81 */     label.setBounds(22, 50, 66, 16);
/*  82 */     this.contentPane.add(label);
/*     */     
/*  84 */     String[] maxCap = { "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "X" };
/*  85 */     final JComboBox<String> comboBox_maxCap = new JComboBox<>(maxCap);
/*  86 */     comboBox_maxCap.setBounds(243, 78, 78, 27);
/*  87 */     this.contentPane.add(comboBox_maxCap);
/*  88 */     comboBox_maxCap.setSelectedItem((new StringBuilder(String.valueOf(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getMaxCapacity()))).toString());
/*     */     
/*  90 */     String[] minCap = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" };
/*  91 */     final JComboBox<String> comboBox_minCap = new JComboBox<>(minCap);
/*  92 */     comboBox_minCap.setBounds(144, 78, 78, 27);
/*  93 */     this.contentPane.add(comboBox_minCap);
/*  94 */     comboBox_minCap.setSelectedItem((new StringBuilder(String.valueOf(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getMinCapacity()))).toString());
/*     */     
/*  96 */     final JComboBox<String> comboBox_teachers = new JComboBox();
/*  97 */     comboBox_teachers.setBounds(91, 108, 192, 27);
/*  98 */     this.contentPane.add(comboBox_teachers);
/*  99 */     for (int i = 0; i < Login.teacherList.size(); i++) {
/* 100 */       comboBox_teachers.addItem(((Teacher)Login.teacherList.get(i)).getTeacherName());
/*     */     }
/*     */     
/* 103 */     final JTextArea textArea_teachers = new JTextArea();
/* 104 */     textArea_teachers.setEditable(false);
/* 105 */     textArea_teachers.setBounds(23, 173, 298, 171);
/* 106 */     this.contentPane.add(textArea_teachers);
/* 107 */     for (int j = 0; j < ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().size(); j++) {
/* 108 */       Stack<Teacher> tarray = ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList();
/* 109 */       textArea_teachers.append(((Teacher)tarray.get(j)).getTeacherName());
/* 110 */       textArea_teachers.append("\n");
/*     */     } 
/*     */     
/* 113 */     JButton btnUndoTeacher = new JButton("Undo");
/* 114 */     btnUndoTeacher.setBounds(89, 136, 117, 29);
/* 115 */     this.contentPane.add(btnUndoTeacher);
/* 116 */     btnUndoTeacher.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 118 */             if (!((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().isEmpty()) {
/*     */               
/* 120 */               Teacher removed = ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().pop();
/* 121 */               Courses_Edit.updateArea(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList(), textArea_teachers);
/*     */             } 
/*     */           }
/*     */         });
/* 125 */     JButton btnClearTeacher = new JButton("Clear");
/* 126 */     btnClearTeacher.setBounds(208, 136, 117, 29);
/* 127 */     this.contentPane.add(btnClearTeacher);
/* 128 */     btnClearTeacher.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 130 */             if (!((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().isEmpty()) {
/*     */               
/* 132 */               while (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().size() > 0) {
/* 133 */                 ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().pop();
/*     */               }
/* 135 */               Courses_Edit.updateArea(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList(), textArea_teachers);
/*     */             } 
/*     */           }
/*     */         });
/* 139 */     JButton btnAddTeacher = new JButton("+");
/* 140 */     btnAddTeacher.setBounds(282, 107, 42, 29);
/* 141 */     this.contentPane.add(btnAddTeacher);
/* 142 */     btnAddTeacher.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 144 */             int num = comboBox_teachers.getSelectedIndex();
/* 145 */             Teacher t = Login.teacherList.get(num);
/* 146 */             if (!((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().contains(t)) {
/*     */               
/* 148 */               ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().push(Login.teacherList.get(num));
/* 149 */               Courses_Edit.updateArea(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList(), textArea_teachers);
/*     */             } 
/*     */           }
/*     */         });
/* 153 */     String[] workload = { "minimal", "light", "average", "heavy" };
/* 154 */     final JComboBox<String> comboBox_workload = new JComboBox<>(workload);
/* 155 */     comboBox_workload.setBounds(90, 46, 113, 27);
/* 156 */     this.contentPane.add(comboBox_workload);
/* 157 */     if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getWorkload() == 0) { comboBox_workload.setSelectedItem("minimal"); }
/* 158 */     else if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getWorkload() == 1) { comboBox_workload.setSelectedItem("light"); }
/* 159 */     else if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getWorkload() == 2) { comboBox_workload.setSelectedItem("average"); }
/* 160 */     else if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getWorkload() == 3) { comboBox_workload.setSelectedItem("heavy"); }
/*     */     
/* 162 */     JCheckBox checkBox_Ib = new JCheckBox("IB course?");
/* 163 */     checkBox_Ib.setFont(new Font("Lucida Grande", 1, 13));
/* 164 */     checkBox_Ib.setBounds(206, 46, 128, 23);
/* 165 */     this.contentPane.add(checkBox_Ib);
/* 166 */     if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getCourseType().equalsIgnoreCase("IB")) checkBox_Ib.setSelected(true); 
/* 167 */     checkBox_Ib.setEnabled(false);
/*     */     
/* 169 */     JButton btnBack = new JButton("← Back");
/* 170 */     btnBack.setBounds(54, 377, 105, 40);
/* 171 */     this.contentPane.add(btnBack);
/* 172 */     btnBack.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 174 */             int a = JOptionPane.showConfirmDialog(Courses_Edit.this.contentPane, "Your progress (excluding your teacher list, which is automatically saved) will not be reflected. Do you still wish to continue?", null, 0);
/* 175 */             if (a == 0) {
/* 176 */               if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().isEmpty()) {
/* 177 */                 Login.infoBox("Please enter at least one teacher.", "");
/*     */               } else {
/*     */                 
/* 180 */                 Courses_Edit.this.dispose();
/* 181 */                 Courses_Menu cm = new Courses_Menu();
/* 182 */                 cm.setVisible(true);
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 192 */     JButton btnConfirmEdit = new JButton("Confirm Edit");
/* 193 */     btnConfirmEdit.setBounds(166, 377, 105, 40);
/* 194 */     this.contentPane.add(btnConfirmEdit);
/* 195 */     btnConfirmEdit.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 197 */             int temp = 0;
/* 198 */             boolean duplicate = false;
/*     */             
/* 200 */             for (int i = 0; i < Login.courseList.size(); i++) {
/* 201 */               if (((Course)Login.courseList.get(i)).getCourseName().equalsIgnoreCase(Courses_Edit.this.textField_name.getText())) temp++; 
/*     */             } 
/* 203 */             if (originalName.equalsIgnoreCase(Courses_Edit.this.textField_name.getText()) && temp == 2) {
/* 204 */               duplicate = true;
/*     */             }
/* 206 */             else if (!originalName.equalsIgnoreCase(Courses_Edit.this.textField_name.getText()) && temp == 1) {
/* 207 */               duplicate = true;
/*     */             } 
/*     */             
/* 210 */             if (Courses_Edit.this.textField_name.getText() == "") {
/* 211 */               Login.infoBox("Please enter the name of the course.", "");
/*     */             }
/* 213 */             else if (((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getTeacherList().isEmpty()) {
/* 214 */               Login.infoBox("Please enter at least one teacher.", "");
/*     */             }
/* 216 */             else if (duplicate) {
/* 217 */               Login.infoBox("There already exists a course with this name.", "");
/*     */             } else {
/*     */               
/* 220 */               if (comboBox_workload.getSelectedItem() == "minimal") { ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setWorkload(0); }
/* 221 */               else if (comboBox_workload.getSelectedItem() == "light") { ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setWorkload(1); }
/* 222 */               else if (comboBox_workload.getSelectedItem() == "average") { ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setWorkload(2); }
/* 223 */               else if (comboBox_workload.getSelectedItem() == "heavy") { ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setWorkload(3); }
/*     */               
/* 225 */               ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setCourseName(Courses_Edit.this.textField_name.getText());
/* 226 */               ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setMaxCapacity(Integer.parseInt((String)comboBox_maxCap.getSelectedItem()));
/* 227 */               ((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).setMinCapacity(Integer.parseInt((String)comboBox_minCap.getSelectedItem()));
/*     */               
/* 229 */               Courses_Edit.saveListToFile();
/*     */               
/* 231 */               Login.infoBox("The course was successfully edited.", "");
/* 232 */               Courses_Edit.this.dispose();
/* 233 */               Courses_Menu cm = new Courses_Menu();
/* 234 */               cm.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateArea(Stack<Teacher> tList, JTextArea a) {
/* 242 */     a.setText("");
/* 243 */     for (int i = 0; i < tList.size(); i++) {
/* 244 */       String s = ((Teacher)tList.get(i)).getTeacherName();
/* 245 */       a.append(String.valueOf(s) + "\n");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 251 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("courseList.dat"));
/* 252 */       out.writeObject(Login.courseList);
/* 253 */       out.close(); }
/* 254 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Courses_Edit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */