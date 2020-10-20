/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Stack;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JTextPane;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.Border;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import javax.swing.table.DefaultTableCellRenderer;
/*     */ import javax.swing.table.TableCellEditor;
/*     */ import javax.swing.text.SimpleAttributeSet;
/*     */ import javax.swing.text.StyleConstants;
/*     */ import javax.swing.text.StyledDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Generate_Schedule
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*  44 */   private SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd_HH:mm");
/*     */   
/*     */   private JTable table;
/*     */   private JTextField textField_first;
/*     */   private JTextField textField_second;
/*     */   private int selectedRow1;
/*     */   private int selectedColumn1;
/*     */   private int selectedRow2;
/*     */   private int selectedColumn2;
/*  53 */   private int teacherListSize = Login.teacherList.size();
/*     */   
/*  55 */   private String selected1 = "";
/*  56 */   private String selected2 = "";
/*     */   
/*  58 */   double IBdisplay = 0.0D;
/*  59 */   double display = 0.0D;
/*     */   
/*  61 */   Course[][] scheduleTable = new Course[this.teacherListSize][8];
/*  62 */   String[][] cellTable = new String[this.teacherListSize][9];
/*     */   
/*  64 */   int count = 0;
/*     */ 
/*     */   
/*     */   public Generate_Schedule() {
/*  68 */     setDefaultCloseOperation(3);
/*  69 */     setBounds(50, 50, 1400, 720);
/*  70 */     this.contentPane = new JPanel();
/*  71 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  72 */     setContentPane(this.contentPane);
/*  73 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  74 */     this.contentPane.setVisible(true);
/*     */     
/*  76 */     JLabel label = new JLabel("__________________________________________");
/*  77 */     label.setHorizontalAlignment(0);
/*  78 */     label.setHorizontalTextPosition(0);
/*  79 */     label.setBounds(1042, 142, 358, 16);
/*  80 */     this.contentPane.add(label);
/*     */     
/*  82 */     final String serial = serialGen(1);
/*  83 */     this.contentPane.setLayout((LayoutManager)null);
/*  84 */     JLabel lblSerial = new JLabel("Serial: " + serial);
/*  85 */     lblSerial.setBounds(10, 10, 163, 16);
/*  86 */     this.contentPane.add(lblSerial);
/*     */     
/*  88 */     JLabel lblNewLabel = new JLabel("SUMMARY");
/*  89 */     lblNewLabel.setFont(new Font("Lucida Grande", 0, 20));
/*  90 */     lblNewLabel.setHorizontalAlignment(0);
/*  91 */     lblNewLabel.setBounds(1002, 175, 438, 16);
/*  92 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  94 */     JLabel lblPercent = new JLabel("%");
/*  95 */     lblPercent.setFont(new Font("Lucida Grande", 0, 60));
/*  96 */     lblPercent.setBounds(1277, 251, 123, 67);
/*  97 */     this.contentPane.add(lblPercent);
/*     */     
/*  99 */     JLabel lblFulfilled = new JLabel("Fulfilled");
/* 100 */     lblFulfilled.setBounds(1068, 203, 61, 16);
/* 101 */     this.contentPane.add(lblFulfilled);
/*     */     
/* 103 */     JLabel lblStudentRequests = new JLabel("student requests");
/* 104 */     lblStudentRequests.setBounds(1277, 313, 106, 16);
/* 105 */     this.contentPane.add(lblStudentRequests);
/*     */     
/* 107 */     JLabel lblNewLabel_1 = new JLabel("First Selection:");
/* 108 */     lblNewLabel_1.setBounds(1074, 83, 93, 16);
/* 109 */     this.contentPane.add(lblNewLabel_1);
/*     */     
/* 111 */     JLabel lblSecondSelection = new JLabel("Second Selection:");
/* 112 */     lblSecondSelection.setBounds(1057, 116, 117, 16);
/* 113 */     this.contentPane.add(lblSecondSelection);
/* 114 */     Border border = BorderFactory.createLineBorder(Color.BLACK);
/*     */     
/* 116 */     final JTextPane textPane = new JTextPane();
/* 117 */     textPane.setBounds(1072, 34, 307, 33);
/* 118 */     this.contentPane.add(textPane);
/* 119 */     textPane.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(8, 8, 8, 8)));
/* 120 */     StyledDocument doc = textPane.getStyledDocument();
/* 121 */     SimpleAttributeSet center = new SimpleAttributeSet();
/* 122 */     StyleConstants.setAlignment(center, 1);
/* 123 */     doc.setParagraphAttributes(0, doc.getLength(), center, false);
/*     */     
/* 125 */     final JTable table_schedule = new JTable((Object[][])this.cellTable, (Object[])new String[] { "Teacher", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8" });
/* 126 */     table_schedule.setBounds(16, 34, 728, 572);
/* 127 */     this.contentPane.add(table_schedule);
/*     */     
/* 129 */     table_schedule.getColumnModel().getColumn(0).setMaxWidth(100);
/* 130 */     table_schedule.getColumnModel().getColumn(0).setMinWidth(100);
/* 131 */     table_schedule.setRowHeight(50);
/*     */     
/* 133 */     table_schedule.setDefaultEditor(Object.class, (TableCellEditor)null);
/*     */     
/* 135 */     DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
/* 136 */     rendar1.setBackground(Color.lightGray);
/* 137 */     table_schedule.getColumnModel().getColumn(0).setCellRenderer(rendar1);
/*     */     
/* 139 */     table_schedule.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseClicked(MouseEvent e) {
/* 142 */             int sRow = table_schedule.getSelectedRow();
/* 143 */             int sColumn = table_schedule.getSelectedColumn();
/* 144 */             String s = (String)table_schedule.getValueAt(sRow, sColumn);
/* 145 */             textPane.setText(s);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 150 */     final Main_Schedule ms1 = new Main_Schedule(Login.studentList, Login.teacherList, Login.courseList);
/* 151 */     ms1.setSerialNum(serial);
/*     */     
/* 153 */     final JTextField txtField_overallNum = new JTextField();
/* 154 */     txtField_overallNum.setEditable(false);
/* 155 */     txtField_overallNum.setFont(new Font("Lucida Grande", 0, 85));
/* 156 */     txtField_overallNum.setHorizontalAlignment(0);
/* 157 */     txtField_overallNum.setBounds(1068, 221, 204, 116);
/* 158 */     this.contentPane.add(txtField_overallNum);
/* 159 */     txtField_overallNum.setColumns(10);
/*     */     
/* 161 */     final JTextArea textArea_summary = new JTextArea();
/* 162 */     textArea_summary.setEditable(false);
/* 163 */     textArea_summary.setBounds(1068, 347, 315, 259);
/* 164 */     this.contentPane.add(textArea_summary);
/*     */     
/* 166 */     for (int i = 0; i < Login.teacherList.size(); i++) {
/* 167 */       ((Teacher)Login.teacherList.get(i)).setTempCourseList(new ArrayList<>());
/*     */     }
/* 169 */     fillTempCourseList(this.scheduleTable, Login.studentList, Login.teacherList, Login.courseList);
/* 170 */     fillCourseList(Login.teacherList);
/* 171 */     fillScheduleTable(Login.teacherList);
/* 172 */     fillStringTable(this.scheduleTable, this.cellTable, Login.teacherList);
/* 173 */     sortDesiredList(Login.studentList);
/* 174 */     assignStudents(Login.studentList, textArea_summary, txtField_overallNum);
/*     */     
/* 176 */     JScrollPane scrollPane = new JScrollPane(table_schedule);
/* 177 */     scrollPane.setBounds(16, 34, 1025, 574);
/* 178 */     this.contentPane.add(scrollPane);
/*     */     
/* 180 */     JScrollPane scrollPane_1 = new JScrollPane(textArea_summary);
/* 181 */     scrollPane_1.setBounds(1068, 347, 315, 259);
/* 182 */     this.contentPane.add(scrollPane_1);
/*     */     
/* 184 */     this.textField_first = new JTextField();
/* 185 */     this.textField_first.setEditable(false);
/* 186 */     this.textField_first.setBounds(1168, 78, 215, 26);
/* 187 */     this.contentPane.add(this.textField_first);
/* 188 */     this.textField_first.setColumns(10);
/*     */     
/* 190 */     this.textField_second = new JTextField();
/* 191 */     this.textField_second.setEditable(false);
/* 192 */     this.textField_second.setColumns(10);
/* 193 */     this.textField_second.setBounds(1168, 111, 215, 26);
/* 194 */     this.contentPane.add(this.textField_second);
/*     */     
/* 196 */     JButton btn1 = new JButton("1");
/* 197 */     btn1.setBounds(382, 620, 50, 44);
/* 198 */     this.contentPane.add(btn1);
/* 199 */     btn1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 201 */             Generate_Schedule.this.selectedRow1 = table_schedule.getSelectedRow();
/* 202 */             Generate_Schedule.this.selectedColumn1 = table_schedule.getSelectedColumn();
/* 203 */             Generate_Schedule.this.selected1 = (String)table_schedule.getValueAt(Generate_Schedule.this.selectedRow1, Generate_Schedule.this.selectedColumn1);
/* 204 */             Generate_Schedule.this.textField_first.setText(String.valueOf(Generate_Schedule.this.selected1) + " (" + ((Teacher)Login.teacherList.get(Generate_Schedule.this.selectedRow1)).getTeacherName() + ", P" + Generate_Schedule.this.selectedColumn1 + ")");
/*     */           }
/*     */         });
/*     */     
/* 208 */     JButton btn2 = new JButton("2");
/* 209 */     btn2.setBounds(439, 620, 50, 44);
/* 210 */     this.contentPane.add(btn2);
/* 211 */     btn2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 213 */             Generate_Schedule.this.selectedRow2 = table_schedule.getSelectedRow();
/* 214 */             Generate_Schedule.this.selectedColumn2 = table_schedule.getSelectedColumn();
/* 215 */             Generate_Schedule.this.selected2 = (String)table_schedule.getValueAt(Generate_Schedule.this.selectedRow2, Generate_Schedule.this.selectedColumn2);
/* 216 */             Generate_Schedule.this.textField_second.setText(String.valueOf(Generate_Schedule.this.selected2) + " (" + ((Teacher)Login.teacherList.get(Generate_Schedule.this.selectedRow2)).getTeacherName() + ", P" + Generate_Schedule.this.selectedColumn2 + ")");
/*     */           }
/*     */         });
/*     */     
/* 220 */     JButton btnSwap = new JButton("SWAP");
/* 221 */     btnSwap.setBounds(497, 620, 117, 44);
/* 222 */     this.contentPane.add(btnSwap);
/* 223 */     btnSwap.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 226 */             if (Generate_Schedule.this.textField_first.getText().charAt(0) != 'X' || Generate_Schedule.this.textField_second.getText().charAt(0) != 'X') {
/* 227 */               Course temp = Generate_Schedule.this.scheduleTable[Generate_Schedule.this.selectedRow2][Generate_Schedule.this.selectedColumn2 - 1];
/* 228 */               Generate_Schedule.this.scheduleTable[Generate_Schedule.this.selectedRow2][Generate_Schedule.this.selectedColumn2 - 1] = Generate_Schedule.this.scheduleTable[Generate_Schedule.this.selectedRow1][Generate_Schedule.this.selectedColumn1 - 1];
/* 229 */               Generate_Schedule.this.scheduleTable[Generate_Schedule.this.selectedRow1][Generate_Schedule.this.selectedColumn1 - 1] = temp;
/*     */               
/* 231 */               Generate_Schedule.this.textField_first.setText("");
/* 232 */               Generate_Schedule.this.textField_second.setText("");
/*     */               
/* 234 */               Generate_Schedule.this.fillStringTable(Generate_Schedule.this.scheduleTable, Generate_Schedule.this.cellTable, Login.teacherList);
/*     */               
/* 236 */               table_schedule.repaint();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 242 */     JButton btnGenerate = new JButton("GENERATE");
/* 243 */     btnGenerate.setBounds(1174, 620, 117, 44);
/* 244 */     this.contentPane.add(btnGenerate);
/* 245 */     btnGenerate.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 248 */             textArea_summary.setText("");
/* 249 */             Generate_Schedule.this.assignStudents(Login.studentList, textArea_summary, txtField_overallNum);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 254 */     JButton btnSave = new JButton("SAVE");
/* 255 */     btnSave.setBounds(1332, 644, 61, 48);
/* 256 */     this.contentPane.add(btnSave);
/* 257 */     btnSave.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 259 */             ms1.setScheduleTable(Generate_Schedule.this.scheduleTable);
/* 260 */             boolean check = false;
/* 261 */             for (int i = 0; i < Login.scheduleList.size(); i++) {
/* 262 */               if (((Main_Schedule)Login.scheduleList.get(i)).getSerialNum().equalsIgnoreCase(serial)) {
/* 263 */                 check = true;
/* 264 */                 Login.moreThanOneSavedSchedule = true;
/* 265 */                 Login.infoBox("You have already saved the schedule as a new file. Further changes will be automatically saved.", "");
/*     */               } 
/*     */             } 
/* 268 */             if (!check) {
/* 269 */               Login.scheduleList.add(ms1);
/* 270 */               Generate_Schedule.saveListToFile();
/* 271 */               Login.moreThanOneSavedSchedule = true;
/* 272 */               Login.infoBox("The schedule has been saved as a new file. Further changes will be automatically saved.", "Success!");
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 277 */     JButton btn_Back = new JButton("← Main Menu");
/* 278 */     btn_Back.setBounds(6, 644, 123, 48);
/* 279 */     this.contentPane.add(btn_Back);
/* 280 */     btn_Back.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 282 */             int a = JOptionPane.showConfirmDialog(Generate_Schedule.this.contentPane, "Your progress will not be saved if you have not pressed the save button. Do you wish to continue?", null, 0);
/* 283 */             if (a == 0) {
/* 284 */               Generate_Schedule.this.dispose();
/* 285 */               Main m = new Main();
/* 286 */               m.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String serialGen(int ver) {
/* 297 */     Date dt = new Date();
/* 298 */     String currentTime = this.sdf.format(dt);
/* 299 */     String serial = currentTime;
/* 300 */     return serial;
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillTempCourseList(Course[][] st, ArrayList<Student> sList, ArrayList<Teacher> tList, ArrayList<Course> cList) {
/* 305 */     int T_maxPds = Login.restrictionList[0] - 1;
/* 306 */     String warning = "";
/*     */     
/* 308 */     for (int i = 0; i < cList.size(); i++) {
/* 309 */       int tempCourseNum = ((Course)cList.get(i)).getCourseNum();
/* 310 */       for (int j = 0; j < ((Course)cList.get(i)).getTeacherList().size(); j++) {
/* 311 */         String currentTName = ((Teacher)((Course)cList.get(i)).getTeacherList().get(j)).getTeacherName();
/* 312 */         for (int k = 0; k < tList.size(); k++) {
/* 313 */           int count = 0;
/* 314 */           if (((Teacher)tList.get(k)).getTempCourseList().size() <= T_maxPds && 
/* 315 */             currentTName.equalsIgnoreCase(((Teacher)tList.get(k)).getTeacherName())) {
/* 316 */             for (int l = 0; l < tempCourseNum; l++) {
/* 317 */               if (((Teacher)tList.get(k)).getTempCourseList().size() <= T_maxPds) {
/* 318 */                 ((Teacher)tList.get(k)).getTempCourseList().add(cList.get(i));
/* 319 */                 count++;
/*     */               } else {
/*     */                 
/* 322 */                 if (j == ((Course)cList.get(i)).getTeacherList().size() - 1) warning = String.valueOf(warning) + ((Course)cList.get(i)).getCourseName() + " does not have enough teachers." + "\n";
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 327 */             tempCourseNum -= count;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 334 */     if (!warning.equalsIgnoreCase("")) Login.infoBox(warning, "");
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillScheduleTable(ArrayList<Teacher> tList) {
/* 340 */     for (int i = 0; i < this.teacherListSize; i++) {
/* 341 */       for (int j = 0; j < 8; j++) {
/* 342 */         this.scheduleTable[i][j] = ((Teacher)tList.get(i)).getCourseList()[j];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillCourseList(ArrayList<Teacher> tList) {
/* 349 */     for (int i = 0; i < tList.size(); i++) {
/* 350 */       ((Teacher)tList.get(i)).setCourseList(new Course[8]);
/* 351 */       for (int j = 0; j < 8; j++) {
/* 352 */         if (j < ((Teacher)tList.get(i)).getTempCourseList().size()) { ((Teacher)tList.get(i)).getCourseList()[j] = ((Teacher)tList.get(i)).getTempCourseList().get(j); }
/* 353 */         else { ((Teacher)tList.get(i)).getCourseList()[j] = new Course(null, null); }
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   static void sortStack(Stack<Course> s) {
/* 359 */     if (!s.isEmpty()) {
/* 360 */       Course x = s.pop();
/* 361 */       sortStack(s);
/* 362 */       sortedInsert(s, x);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void sortedInsert(Stack<Course> s, Course x) {
/* 368 */     if (s.isEmpty() || x.getCourseNum() > ((Course)s.peek()).getCourseNum()) {
/* 369 */       s.push(x);
/*     */       
/*     */       return;
/*     */     } 
/* 373 */     Course temp = s.pop();
/* 374 */     sortedInsert(s, x);
/* 375 */     s.push(temp);
/*     */   }
/*     */   public void sortDesiredList(ArrayList<Student> sList) {
/*     */     int i;
/* 379 */     for (i = 0; i < sList.size(); i++) {
/* 380 */       for (int j = 0; j < ((Student)sList.get(j)).getDesiredList().size(); j++) {
/* 381 */         for (int k = 0; k < Login.courseList.size(); k++) {
/* 382 */           if (((Course)Login.courseList.get(k)).getCourseName().equalsIgnoreCase(((Course)((Student)sList.get(i)).getDesiredList().get(j)).getCourseName())) {
/* 383 */             ((Course)((Student)sList.get(i)).getDesiredList().get(j)).setCourseNum(((Course)Login.courseList.get(k)).getCourseNum());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 388 */     for (i = 0; i < sList.size(); i++) {
/* 389 */       sortStack(((Student)sList.get(i)).getDesiredList());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void assignStudents(ArrayList<Student> sList, JTextArea s, JTextField o) {
/* 395 */     double overallNum = 0.0D;
/* 396 */     double overallIBNum = 0.0D;
/*     */     
/* 398 */     for (int i = 0; i < sList.size(); i++) {
/* 399 */       ArrayList<Integer> studentPList = new ArrayList<>();
/* 400 */       ArrayList<Course> courseDoneList = new ArrayList<>();
/* 401 */       ArrayList<Course> electiveDoneList = new ArrayList<>();
/* 402 */       ((Student)sList.get(i)).setCourseList(new Course[8]);
/* 403 */       double leftover = 0.0D;
/* 404 */       double fulfillment = 0.0D;
/* 405 */       double IBFulfillment = 0.0D;
/*     */       
/* 407 */       for (int k = 0; k < ((Student)sList.get(i)).getDesiredList().size(); k++) {
/* 408 */         boolean left = true;
/* 409 */         if (studentPList.size() != 7) {
/* 410 */           for (int a = 0; a < 8; a++) {
/* 411 */             if (!isPeriodOccupied(a, studentPList)) {
/* 412 */               for (int b = 0; b < Login.teacherList.size(); b++) {
/* 413 */                 boolean skip = false;
/* 414 */                 for (int c = 0; c < courseDoneList.size(); c++) {
/* 415 */                   if (((Course)courseDoneList.get(c)).getCourseName().equals(((Course)((Student)sList.get(i)).getDesiredList().get(k)).getCourseName())) {
/* 416 */                     skip = true;
/*     */                   }
/*     */                 } 
/* 419 */                 if (!skip && ((Course)((Student)sList.get(i)).getDesiredList().get(k)).getCourseName().equalsIgnoreCase(this.cellTable[b][a + 1])) {
/* 420 */                   studentPList.add(Integer.valueOf(a));
/* 421 */                   ((Student)sList.get(i)).getCourseList()[a] = ((Student)sList.get(i)).getDesiredList().get(k);
/* 422 */                   courseDoneList.add(((Student)sList.get(i)).getDesiredList().get(k));
/* 423 */                   left = false;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/* 429 */         if (left) leftover++;
/*     */       
/*     */       } 
/*     */ 
/*     */       
/* 434 */       if (((Student)sList.get(i)).getStudentType().equalsIgnoreCase("Non-IBDP")) {
/* 435 */         for (int x = 0; x < (((Non_IBDP_Student)sList.get(i)).getElectiveList()).length; x++) {
/* 436 */           if (studentPList.size() != 7) {
/* 437 */             for (int a = 0; a < 8; a++) {
/* 438 */               if (!isPeriodOccupied(a, studentPList)) {
/* 439 */                 for (int b = 0; b < Login.teacherList.size(); b++) {
/* 440 */                   boolean skip = false;
/* 441 */                   for (int c = 0; c < electiveDoneList.size(); c++) {
/* 442 */                     if (((Course)electiveDoneList.get(c)).getCourseName().equals(((Non_IBDP_Student)sList.get(i)).getElectiveList()[x].getCourseName()))
/*     */                     {
/* 444 */                       skip = true;
/*     */                     }
/*     */                   } 
/* 447 */                   if (!skip && ((Non_IBDP_Student)sList.get(i)).getElectiveList()[x].getCourseName().equalsIgnoreCase(this.cellTable[b][a + 1])) {
/* 448 */                     studentPList.add(Integer.valueOf(a));
/* 449 */                     ((Student)sList.get(i)).getCourseList()[a] = ((Non_IBDP_Student)sList.get(i)).getElectiveList()[x];
/* 450 */                     electiveDoneList.add(((Non_IBDP_Student)sList.get(i)).getElectiveList()[x]);
/* 451 */                     leftover--;
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/* 460 */       fulfillment = (7.0D - leftover) / 7.0D * 100.0D;
/* 461 */       s.append("  " + ((Student)sList.get(i)).getStudentName() + ": " + String.format("%.1f", new Object[] { Double.valueOf(fulfillment) }) + "% fulfillment\n");
/* 462 */       overallNum += fulfillment;
/*     */       
/* 464 */       if (((Student)sList.get(i)).getStudentType().equalsIgnoreCase("IBDP")) {
/* 465 */         IBFulfillment = (7.0D - leftover) / 7.0D * 100.0D;
/* 466 */         overallIBNum += IBFulfillment;
/*     */       } 
/*     */       
/* 469 */       for (int z = 0; z < 8; z++) {
/* 470 */         int display = z + 1;
/* 471 */         if (((Student)sList.get(i)).getCourseList()[z] != null) {
/* 472 */           s.append("      P" + display + ": " + ((Student)sList.get(i)).getCourseList()[z].getCourseName() + "\n");
/*     */         } else {
/*     */           
/* 475 */           s.append("      P" + display + ": X \n");
/*     */         } 
/*     */       } 
/* 478 */       for (int y = 0; y < ((Student)sList.get(i)).getDesiredList().size(); y++) {
/* 479 */         this.count = 0;
/* 480 */         for (int p = 0; p < 8; p++) {
/* 481 */           if (((Student)sList.get(i)).getCourseList()[p] != null) {
/* 482 */             if (!((Course)((Student)sList.get(i)).getDesiredList().get(y)).getCourseName().equalsIgnoreCase(((Student)sList.get(i)).getCourseList()[p].getCourseName()))
/*     */             {
/* 484 */               this.count++; } 
/*     */           } else {
/* 486 */             this.count++;
/*     */           } 
/* 488 */         }  if (this.count == 8) {
/* 489 */           s.append("          * core selection " + ((Course)((Student)sList.get(i)).getDesiredList().get(y)).getCourseName() + " missing\n");
/*     */         }
/*     */       } 
/* 492 */       s.append("\n");
/*     */     } 
/*     */     
/* 495 */     int ibStudentCount = 0;
/*     */     
/* 497 */     for (int j = 0; j < sList.size(); j++) {
/* 498 */       if (((Student)sList.get(j)).getStudentType().equalsIgnoreCase("IBDP")) ibStudentCount++;
/*     */     
/*     */     } 
/* 501 */     this.IBdisplay = overallIBNum / ibStudentCount;
/* 502 */     this.display = overallNum / sList.size();
/*     */     
/* 504 */     if ((sList.size() * 100) == overallNum) {
/* 505 */       o.setText("100");
/*     */     } else {
/* 507 */       o.setText(String.format("%.1f", new Object[] { Double.valueOf(this.display) }));
/*     */     } 
/* 509 */     s.append("\n  IBDP fulfillment rate: " + String.format("%.1f", new Object[] { Double.valueOf(this.IBdisplay) }) + "%");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPeriodOccupied(int target, ArrayList<Integer> studentPList) {
/* 514 */     for (int i = 0; i < studentPList.size(); i++) {
/* 515 */       if (((Integer)studentPList.get(i)).intValue() == target) return true; 
/*     */     } 
/* 517 */     return false;
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 522 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("scheduleList.dat"));
/* 523 */       out.writeObject(Login.scheduleList);
/* 524 */       out.close(); }
/* 525 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */   public void fillStringTable(Course[][] scheduleTable, String[][] cellTable, ArrayList<Teacher> tList) {
/* 529 */     for (int i = 0; i < this.teacherListSize; i++) {
/* 530 */       cellTable[i][0] = ((Teacher)Login.teacherList.get(i)).getTeacherName();
/* 531 */       for (int j = 0; j < 8; j++) {
/* 532 */         if (scheduleTable[i][j].getCourseName() != null) {
/* 533 */           cellTable[i][j + 1] = scheduleTable[i][j].getCourseName();
/*     */         } else {
/*     */           
/* 536 */           cellTable[i][j + 1] = "X";
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Generate_Schedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */