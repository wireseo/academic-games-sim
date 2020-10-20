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
/*     */ public class Students_Edit
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTextField textField_name;
/*     */   
/*     */   public Students_Edit() {
/*  39 */     setDefaultCloseOperation(3);
/*  40 */     setBounds(100, 100, 350, 540);
/*  41 */     this.contentPane = new JPanel();
/*  42 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  43 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  44 */     setContentPane(this.contentPane);
/*  45 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  47 */     JLabel label = new JLabel("Name:");
/*  48 */     label.setHorizontalAlignment(11);
/*  49 */     label.setFont(new Font("Lucida Grande", 1, 13));
/*  50 */     label.setBounds(25, 23, 42, 16);
/*  51 */     this.contentPane.add(label);
/*     */     
/*  53 */     JLabel label_3 = new JLabel("Alternative Electives:");
/*  54 */     label_3.setFont(new Font("Lucida Grande", 1, 13));
/*  55 */     label_3.setBounds(25, 329, 167, 16);
/*  56 */     this.contentPane.add(label_3);
/*     */     
/*  58 */     JLabel label_4 = new JLabel("1:");
/*  59 */     label_4.setBounds(35, 354, 61, 16);
/*  60 */     this.contentPane.add(label_4);
/*     */     
/*  62 */     JLabel label_5 = new JLabel("2:");
/*  63 */     label_5.setBounds(35, 386, 61, 16);
/*  64 */     this.contentPane.add(label_5);
/*     */     
/*  66 */     JLabel label_1 = new JLabel("Grade:");
/*  67 */     label_1.setFont(new Font("Lucida Grande", 1, 13));
/*  68 */     label_1.setBounds(25, 56, 52, 16);
/*  69 */     this.contentPane.add(label_1);
/*     */     
/*  71 */     JLabel label_2 = new JLabel("Courses:");
/*  72 */     label_2.setFont(new Font("Lucida Grande", 1, 13));
/*  73 */     label_2.setBounds(25, 90, 66, 16);
/*  74 */     this.contentPane.add(label_2);
/*  75 */     int row = Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row);
/*     */ 
/*     */     
/*  78 */     this.textField_name = new JTextField();
/*  79 */     this.textField_name.setColumns(10);
/*  80 */     this.textField_name.setBounds(70, 18, 253, 26);
/*  81 */     this.contentPane.add(this.textField_name);
/*  82 */     this.textField_name.setText(((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getStudentName());
/*  83 */     final String originalName = ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getStudentName();
/*     */ 
/*     */     
/*  86 */     String[] grade = { "9", "10", "11", "12" };
/*  87 */     final JComboBox<String> comboBox_grade = new JComboBox<>(grade);
/*  88 */     comboBox_grade.setBounds(73, 53, 70, 27);
/*  89 */     this.contentPane.add(comboBox_grade);
/*  90 */     if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getGrade() == 9) { comboBox_grade.setSelectedItem("9"); }
/*  91 */     else if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getGrade() == 10) { comboBox_grade.setSelectedItem("10"); }
/*  92 */     else if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getGrade() == 11) { comboBox_grade.setSelectedItem("11"); }
/*  93 */     else if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getGrade() == 12) { comboBox_grade.setSelectedItem("12"); }
/*  94 */      System.out.println("getGrade: " + ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getGrade());
/*     */ 
/*     */     
/*  97 */     final JCheckBox checkBox_Ib = new JCheckBox("IB Diploma Candidate?");
/*  98 */     checkBox_Ib.setVerticalAlignment(3);
/*  99 */     checkBox_Ib.setHorizontalAlignment(11);
/* 100 */     checkBox_Ib.setFont(new Font("Lucida Grande", 0, 13));
/* 101 */     checkBox_Ib.setBounds(149, 54, 172, 23);
/* 102 */     this.contentPane.add(checkBox_Ib);
/* 103 */     if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getStudentType().equalsIgnoreCase("IBDP")) checkBox_Ib.setSelected(true); 
/* 104 */     checkBox_Ib.setEnabled(false);
/*     */     
/* 106 */     final JComboBox<String> comboBox_courses = new JComboBox();
/* 107 */     comboBox_courses.setBounds(88, 86, 194, 27);
/* 108 */     this.contentPane.add(comboBox_courses);
/* 109 */     for (int i = 0; i < Login.courseList.size(); i++) {
/* 110 */       comboBox_courses.addItem(((Course)Login.courseList.get(i)).getCourseName());
/*     */     }
/*     */ 
/*     */     
/* 114 */     final JTextArea textArea_courses = new JTextArea();
/* 115 */     textArea_courses.setEditable(false);
/* 116 */     textArea_courses.setBounds(25, 146, 298, 171);
/* 117 */     this.contentPane.add(textArea_courses);
/* 118 */     for (int j = 0; j < ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().size(); j++) {
/* 119 */       Stack<Course> carray = ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList();
/* 120 */       textArea_courses.append(((Course)carray.get(j)).getCourseName());
/* 121 */       textArea_courses.append("\n");
/*     */     } 
/*     */     
/* 124 */     final JComboBox<String> comboBox_secondElective = new JComboBox();
/* 125 */     comboBox_secondElective.setBounds(69, 382, 236, 27);
/* 126 */     this.contentPane.add(comboBox_secondElective);
/* 127 */     if (!checkBox_Ib.isSelected()) {
/* 128 */       comboBox_secondElective.addItem(((Non_IBDP_Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getElectiveList()[0].getCourseName());
/*     */     }
/* 130 */     comboBox_secondElective.setEnabled(false);
/*     */     
/* 132 */     final JComboBox<String> comboBox_firstElective = new JComboBox();
/* 133 */     comboBox_firstElective.setBounds(69, 350, 236, 27);
/* 134 */     this.contentPane.add(comboBox_firstElective);
/* 135 */     if (!checkBox_Ib.isSelected()) {
/* 136 */       comboBox_firstElective.addItem(((Non_IBDP_Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getElectiveList()[1].getCourseName());
/*     */     }
/* 138 */     comboBox_firstElective.setEnabled(false);
/*     */     
/* 140 */     JButton btnUndo = new JButton("Undo");
/* 141 */     btnUndo.setBounds(86, 113, 117, 29);
/* 142 */     this.contentPane.add(btnUndo);
/* 143 */     btnUndo.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 145 */             if (!((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().isEmpty()) {
/*     */               
/* 147 */               Course removed = ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().pop();
/* 148 */               Students_Edit.updateArea(((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList(), textArea_courses);
/*     */             } 
/*     */           }
/*     */         });
/* 152 */     JButton btnClear = new JButton("Clear");
/* 153 */     btnClear.setBounds(206, 113, 117, 29);
/* 154 */     this.contentPane.add(btnClear);
/* 155 */     btnClear.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 157 */             if (!((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().isEmpty()) {
/*     */               
/* 159 */               while (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().size() > 0) {
/* 160 */                 ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().pop();
/*     */               }
/* 162 */               Students_Edit.updateArea(((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList(), textArea_courses);
/*     */             } 
/*     */           }
/*     */         });
/* 166 */     JButton btnAddCourse = new JButton("+");
/* 167 */     btnAddCourse.setBounds(281, 85, 42, 29);
/* 168 */     this.contentPane.add(btnAddCourse);
/* 169 */     btnAddCourse.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 171 */             int num = comboBox_courses.getSelectedIndex();
/* 172 */             if (!((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().contains(Login.courseList.get(num))) {
/*     */               
/* 174 */               ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().push(Login.courseList.get(num));
/* 175 */               Students_Edit.updateArea(((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList(), textArea_courses);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 180 */     JButton btnBack = new JButton("← Back");
/* 181 */     btnBack.setBounds(64, 428, 105, 40);
/* 182 */     this.contentPane.add(btnBack);
/* 183 */     btnBack.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 185 */             int a = JOptionPane.showConfirmDialog(Students_Edit.this.contentPane, "Your progress (excluding your course selection, which is automatically saved,) will not be reflected. Do you still wish to continue?", null, 0);
/* 186 */             if (a == 0)
/*     */             {
/* 188 */               if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().size() != 7) {
/* 189 */                 Login.infoBox("Please enter 7 desired courses.", "");
/*     */               } else {
/*     */                 
/* 192 */                 Students_Edit.this.dispose();
/* 193 */                 Students_Menu sm = new Students_Menu();
/* 194 */                 sm.setVisible(true);
/*     */               } 
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     JButton btnEditStudent = new JButton("Confirm Edit");
/* 206 */     btnEditStudent.setBounds(177, 428, 105, 40);
/* 207 */     this.contentPane.add(btnEditStudent);
/* 208 */     btnEditStudent.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 210 */             int temp = 0;
/* 211 */             boolean duplicate = false;
/* 212 */             boolean multiple = false;
/*     */             int i;
/* 214 */             for (i = 0; i < ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().size(); i++) {
/* 215 */               if (((Course)((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().get(i)).getCourseName() == comboBox_firstElective.getSelectedItem()) multiple = true; 
/* 216 */               if (((Course)((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().get(i)).getCourseName() == comboBox_secondElective.getSelectedItem()) multiple = true;
/*     */             
/*     */             } 
/* 219 */             for (i = 0; i < Login.studentList.size(); i++) {
/* 220 */               if (((Student)Login.studentList.get(i)).getStudentName().equalsIgnoreCase(Students_Edit.this.textField_name.getText())) temp++; 
/*     */             } 
/* 222 */             if (originalName.equalsIgnoreCase(Students_Edit.this.textField_name.getText()) && temp == 2) {
/* 223 */               duplicate = true;
/*     */             }
/* 225 */             else if (!originalName.equalsIgnoreCase(Students_Edit.this.textField_name.getText()) && temp == 1) {
/* 226 */               duplicate = true;
/*     */             } 
/*     */             
/* 229 */             if (Students_Edit.this.textField_name.getText() == "") {
/* 230 */               Login.infoBox("Please enter the name of the student.", "");
/*     */             }
/* 232 */             else if (duplicate) {
/* 233 */               Login.infoBox("There already exists a student with this name.", "");
/*     */             }
/* 235 */             else if (((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getDesiredList().size() != 7) {
/* 236 */               Login.infoBox("Please enter 7 desired courses.", "");
/*     */             }
/* 238 */             else if (!checkBox_Ib.isSelected()) {
/* 239 */               if (comboBox_firstElective.getSelectedItem() == comboBox_secondElective.getSelectedItem() || multiple) {
/* 240 */                 Login.infoBox("You cannot have multiple listings of one course.", "");
/*     */               } else {
/*     */                 
/* 243 */                 ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).setStudentName(Students_Edit.this.textField_name.getText());
/* 244 */                 ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).setGrade(Integer.valueOf(comboBox_grade.getSelectedItem().toString()).intValue());
/* 245 */                 Students_Edit.saveListToFile();
/*     */ 
/*     */                 
/* 248 */                 Login.infoBox("The student was successfully edited.", "");
/* 249 */                 Students_Edit.this.dispose();
/* 250 */                 Students_Menu sm = new Students_Menu();
/* 251 */                 sm.setVisible(true);
/*     */               } 
/*     */             } else {
/*     */               
/* 255 */               ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).setStudentName(Students_Edit.this.textField_name.getText());
/* 256 */               ((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).setGrade(Integer.valueOf(comboBox_grade.getSelectedItem().toString()).intValue());
/*     */               
/* 258 */               Students_Edit.saveListToFile();
/*     */               
/* 260 */               Login.infoBox("The student was successfully edited.", "");
/* 261 */               Students_Edit.this.dispose();
/* 262 */               Students_Menu sm = new Students_Menu();
/* 263 */               sm.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public static void updateArea(Stack<Course> tList, JTextArea a) {
/* 270 */     a.setText("");
/* 271 */     for (int i = 0; i < tList.size(); i++) {
/* 272 */       String s = ((Course)tList.get(i)).getCourseName();
/* 273 */       System.out.println(s);
/* 274 */       a.append(String.valueOf(s) + "\n");
/*     */     } 
/* 276 */     System.out.println("\n\n");
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 281 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studentList.dat"));
/* 282 */       out.writeObject(Login.studentList);
/* 283 */       out.close(); }
/* 284 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Students_Edit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */