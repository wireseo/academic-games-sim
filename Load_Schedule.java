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
/*     */ 
/*     */ public class Load_Schedule
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*  43 */   private SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd_HH:mm");
/*     */   
/*     */   private JTable table;
/*     */   private JTextField textField_first;
/*     */   private JTextField textField_second;
/*     */   private int selectedRow1;
/*     */   private int selectedColumn1;
/*     */   private int selectedRow2;
/*     */   private int selectedColumn2;
/*  52 */   private String selected1 = "";
/*  53 */   private String selected2 = "";
/*     */   
/*  55 */   private int teacherListSize = ((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getTeacherList().size();
/*     */ 
/*     */   
/*  58 */   Course[][] scheduleTable = new Course[this.teacherListSize][8];
/*  59 */   String[][] cellTable = new String[this.teacherListSize][9];
/*     */   
/*  61 */   int count = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public Load_Schedule() {
/*  66 */     setDefaultCloseOperation(3);
/*  67 */     setBounds(50, 50, 1400, 720);
/*  68 */     this.contentPane = new JPanel();
/*  69 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  70 */     setContentPane(this.contentPane);
/*  71 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  72 */     this.contentPane.setVisible(true);
/*     */     
/*  74 */     JLabel label = new JLabel("__________________________________________");
/*  75 */     label.setHorizontalAlignment(0);
/*  76 */     label.setHorizontalTextPosition(0);
/*  77 */     label.setBounds(1042, 142, 358, 16);
/*  78 */     this.contentPane.add(label);
/*     */     
/*  80 */     this.contentPane.setLayout((LayoutManager)null);
/*  81 */     JLabel lblSerial = new JLabel("Serial: " + ((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getSerialNum());
/*  82 */     lblSerial.setBounds(10, 10, 163, 16);
/*  83 */     this.contentPane.add(lblSerial);
/*     */     
/*  85 */     JLabel lblNewLabel = new JLabel("SUMMARY");
/*  86 */     lblNewLabel.setFont(new Font("Lucida Grande", 0, 20));
/*  87 */     lblNewLabel.setHorizontalAlignment(0);
/*  88 */     lblNewLabel.setBounds(1002, 175, 438, 16);
/*  89 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  91 */     JLabel lblPercent = new JLabel("%");
/*  92 */     lblPercent.setFont(new Font("Lucida Grande", 0, 60));
/*  93 */     lblPercent.setBounds(1277, 251, 123, 67);
/*  94 */     this.contentPane.add(lblPercent);
/*     */     
/*  96 */     JLabel lblFulfilled = new JLabel("Fulfilled");
/*  97 */     lblFulfilled.setBounds(1068, 203, 61, 16);
/*  98 */     this.contentPane.add(lblFulfilled);
/*     */     
/* 100 */     JLabel lblStudentRequests = new JLabel("student requests");
/* 101 */     lblStudentRequests.setBounds(1277, 313, 106, 16);
/* 102 */     this.contentPane.add(lblStudentRequests);
/*     */     
/* 104 */     JLabel lblNewLabel_1 = new JLabel("First Selection:");
/* 105 */     lblNewLabel_1.setBounds(1074, 83, 93, 16);
/* 106 */     this.contentPane.add(lblNewLabel_1);
/*     */     
/* 108 */     JLabel lblSecondSelection = new JLabel("Second Selection:");
/* 109 */     lblSecondSelection.setBounds(1057, 116, 117, 16);
/* 110 */     this.contentPane.add(lblSecondSelection);
/* 111 */     Border border = BorderFactory.createLineBorder(Color.BLACK);
/*     */     
/* 113 */     final JTextPane textPane = new JTextPane();
/* 114 */     textPane.setBounds(1072, 34, 307, 33);
/* 115 */     this.contentPane.add(textPane);
/* 116 */     textPane.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(8, 8, 8, 8)));
/* 117 */     StyledDocument doc = textPane.getStyledDocument();
/* 118 */     SimpleAttributeSet center = new SimpleAttributeSet();
/* 119 */     StyleConstants.setAlignment(center, 1);
/* 120 */     doc.setParagraphAttributes(0, doc.getLength(), center, false);
/*     */     
/* 122 */     final JTable table_schedule = new JTable((Object[][])this.cellTable, (Object[])new String[] { "Teacher", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8" });
/* 123 */     table_schedule.setBounds(16, 34, 728, 572);
/* 124 */     this.contentPane.add(table_schedule);
/* 125 */     table_schedule.getColumnModel().getColumn(0).setMaxWidth(100);
/* 126 */     table_schedule.getColumnModel().getColumn(0).setMinWidth(100);
/* 127 */     table_schedule.setRowHeight(50);
/* 128 */     table_schedule.setDefaultEditor(Object.class, (TableCellEditor)null);
/* 129 */     DefaultTableCellRenderer rendar1 = new DefaultTableCellRenderer();
/* 130 */     rendar1.setBackground(Color.lightGray);
/* 131 */     table_schedule.getColumnModel().getColumn(0).setCellRenderer(rendar1);
/* 132 */     table_schedule.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseClicked(MouseEvent e)
/*     */           {
/* 136 */             int sRow = table_schedule.getSelectedRow();
/* 137 */             int sColumn = table_schedule.getSelectedColumn();
/* 138 */             String s = (String)table_schedule.getValueAt(sRow, sColumn);
/* 139 */             textPane.setText(s);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 145 */     Main_Schedule ms1 = Login.scheduleList.get(Load_Menu.loadedIndex);
/* 146 */     ms1.setSerialNum(((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getSerialNum());
/* 147 */     this.scheduleTable = ((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getScheduleTable();
/* 148 */     ArrayList<Course> courseList = ((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getCourseList();
/* 149 */     ArrayList<Student> studentList = ((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getStudentList();
/* 150 */     ArrayList<Teacher> teacherList = ((Main_Schedule)Login.scheduleList.get(Load_Menu.loadedIndex)).getTeacherList();
/* 151 */     ms1.setCourseList(courseList);
/* 152 */     ms1.setStudentList(studentList);
/* 153 */     ms1.setTeacherList(teacherList);
/* 154 */     ms1.setScheduleTable(this.scheduleTable);
/*     */ 
/*     */     
/* 157 */     final JTextField txtField_overallNum = new JTextField();
/* 158 */     txtField_overallNum.setEditable(false);
/* 159 */     txtField_overallNum.setFont(new Font("Lucida Grande", 0, 85));
/* 160 */     txtField_overallNum.setHorizontalAlignment(0);
/* 161 */     txtField_overallNum.setBounds(1068, 221, 204, 116);
/* 162 */     this.contentPane.add(txtField_overallNum);
/* 163 */     txtField_overallNum.setColumns(10);
/*     */     
/* 165 */     final JTextArea textArea_summary = new JTextArea();
/* 166 */     textArea_summary.setEditable(false);
/* 167 */     textArea_summary.setBounds(1068, 347, 315, 259);
/* 168 */     this.contentPane.add(textArea_summary);
/*     */     
/* 170 */     fillStringTable(this.scheduleTable, this.cellTable, teacherList);
/* 171 */     assignStudents(studentList, textArea_summary, txtField_overallNum);
/*     */     
/* 173 */     JScrollPane scrollPane = new JScrollPane(table_schedule);
/* 174 */     scrollPane.setBounds(16, 34, 1025, 574);
/* 175 */     this.contentPane.add(scrollPane);
/*     */     
/* 177 */     JScrollPane scrollPane_1 = new JScrollPane(textArea_summary);
/* 178 */     scrollPane_1.setBounds(1068, 347, 315, 259);
/* 179 */     this.contentPane.add(scrollPane_1);
/*     */     
/* 181 */     this.textField_first = new JTextField();
/* 182 */     this.textField_first.setEditable(false);
/* 183 */     this.textField_first.setBounds(1168, 78, 215, 26);
/* 184 */     this.contentPane.add(this.textField_first);
/* 185 */     this.textField_first.setColumns(10);
/*     */     
/* 187 */     this.textField_second = new JTextField();
/* 188 */     this.textField_second.setEditable(false);
/* 189 */     this.textField_second.setColumns(10);
/* 190 */     this.textField_second.setBounds(1168, 111, 215, 26);
/* 191 */     this.contentPane.add(this.textField_second);
/*     */     
/* 193 */     JButton btn1 = new JButton("1");
/* 194 */     btn1.setBounds(382, 620, 50, 44);
/* 195 */     this.contentPane.add(btn1);
/* 196 */     btn1.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 198 */             Load_Schedule.this.selectedRow1 = table_schedule.getSelectedRow();
/* 199 */             Load_Schedule.this.selectedColumn1 = table_schedule.getSelectedColumn();
/* 200 */             Load_Schedule.this.selected1 = (String)table_schedule.getValueAt(Load_Schedule.this.selectedRow1, Load_Schedule.this.selectedColumn1);
/* 201 */             Load_Schedule.this.textField_first.setText(String.valueOf(Load_Schedule.this.selected1) + " (" + ((Teacher)Login.teacherList.get(Load_Schedule.this.selectedRow1)).getTeacherName() + ", P" + Load_Schedule.this.selectedColumn1 + ")");
/*     */           }
/*     */         });
/*     */     
/* 205 */     JButton btn2 = new JButton("2");
/* 206 */     btn2.setBounds(439, 620, 50, 44);
/* 207 */     this.contentPane.add(btn2);
/* 208 */     btn2.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 210 */             Load_Schedule.this.selectedRow2 = table_schedule.getSelectedRow();
/* 211 */             Load_Schedule.this.selectedColumn2 = table_schedule.getSelectedColumn();
/* 212 */             Load_Schedule.this.selected2 = (String)table_schedule.getValueAt(Load_Schedule.this.selectedRow2, Load_Schedule.this.selectedColumn2);
/* 213 */             Load_Schedule.this.textField_second.setText(String.valueOf(Load_Schedule.this.selected2) + " (" + ((Teacher)Login.teacherList.get(Load_Schedule.this.selectedRow2)).getTeacherName() + ", P" + Load_Schedule.this.selectedColumn2 + ")");
/*     */           }
/*     */         });
/*     */     
/* 217 */     JButton btnSwap = new JButton("SWAP");
/* 218 */     btnSwap.setBounds(497, 620, 117, 44);
/* 219 */     this.contentPane.add(btnSwap);
/* 220 */     btnSwap.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 223 */             if (Load_Schedule.this.textField_first.getText().charAt(0) != 'X' || Load_Schedule.this.textField_second.getText().charAt(0) != 'X') {
/* 224 */               Course temp = Load_Schedule.this.scheduleTable[Load_Schedule.this.selectedRow2][Load_Schedule.this.selectedColumn2 - 1];
/* 225 */               Load_Schedule.this.scheduleTable[Load_Schedule.this.selectedRow2][Load_Schedule.this.selectedColumn2 - 1] = Load_Schedule.this.scheduleTable[Load_Schedule.this.selectedRow1][Load_Schedule.this.selectedColumn1 - 1];
/* 226 */               Load_Schedule.this.scheduleTable[Load_Schedule.this.selectedRow1][Load_Schedule.this.selectedColumn1 - 1] = temp;
/*     */               
/* 228 */               Load_Schedule.this.textField_first.setText("");
/* 229 */               Load_Schedule.this.textField_second.setText("");
/*     */               
/* 231 */               Load_Schedule.this.fillStringTable(Load_Schedule.this.scheduleTable, Load_Schedule.this.cellTable, Login.teacherList);
/*     */               
/* 233 */               table_schedule.repaint();
/* 234 */               Load_Schedule.this.count = 1;
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 239 */     JButton btnGenerate = new JButton("GENERATE");
/* 240 */     btnGenerate.setBounds(1174, 620, 117, 44);
/* 241 */     this.contentPane.add(btnGenerate);
/* 242 */     btnGenerate.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 244 */             if (Load_Schedule.this.count == 1) {
/* 245 */               textArea_summary.setText("");
/* 246 */               Load_Schedule.this.assignStudents(Login.studentList, textArea_summary, txtField_overallNum);
/* 247 */               Load_Schedule.this.count = 0;
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 252 */     JButton btn_Back = new JButton("← Main Menu");
/* 253 */     btn_Back.setBounds(6, 644, 123, 48);
/* 254 */     this.contentPane.add(btn_Back);
/* 255 */     btn_Back.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 257 */             int a = JOptionPane.showConfirmDialog(Load_Schedule.this.contentPane, "Your progress was automatically saved. Do you wish to continue?", null, 0);
/* 258 */             if (a == 0) {
/* 259 */               Load_Schedule.this.dispose();
/* 260 */               Main m = new Main();
/* 261 */               m.setVisible(true);
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
/*     */   public void assignStudents(ArrayList<Student> sList, JTextArea s, JTextField o) {
/* 273 */     double overallNum = 0.0D;
/* 274 */     double overallIBNum = 0.0D;
/*     */     
/* 276 */     for (int i = 0; i < sList.size(); i++) {
/* 277 */       ArrayList<Integer> studentPList = new ArrayList<>();
/* 278 */       ArrayList<Course> courseDoneList = new ArrayList<>();
/* 279 */       ArrayList<Course> electiveDoneList = new ArrayList<>();
/* 280 */       ((Student)sList.get(i)).setCourseList(new Course[8]);
/* 281 */       double leftover = 0.0D;
/* 282 */       double fulfillment = 0.0D;
/* 283 */       double IBFulfillment = 0.0D;
/*     */       
/* 285 */       for (int k = 0; k < ((Student)sList.get(i)).getDesiredList().size(); k++) {
/* 286 */         boolean left = true;
/* 287 */         if (studentPList.size() != 7) {
/* 288 */           for (int a = 0; a < 8; a++) {
/* 289 */             if (!isPeriodOccupied(a, studentPList)) {
/* 290 */               for (int b = 0; b < Login.teacherList.size(); b++) {
/* 291 */                 boolean skip = false;
/* 292 */                 for (int c = 0; c < courseDoneList.size(); c++) {
/* 293 */                   if (((Course)courseDoneList.get(c)).getCourseName().equals(((Course)((Student)sList.get(i)).getDesiredList().get(k)).getCourseName())) {
/* 294 */                     skip = true;
/*     */                   }
/*     */                 } 
/* 297 */                 if (!skip && ((Course)((Student)sList.get(i)).getDesiredList().get(k)).getCourseName().equalsIgnoreCase(this.cellTable[b][a + 1])) {
/* 298 */                   studentPList.add(Integer.valueOf(a));
/* 299 */                   ((Student)sList.get(i)).getCourseList()[a] = ((Student)sList.get(i)).getDesiredList().get(k);
/* 300 */                   courseDoneList.add(((Student)sList.get(i)).getDesiredList().get(k));
/* 301 */                   left = false;
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/* 307 */         if (left) leftover++;
/*     */       
/*     */       } 
/*     */ 
/*     */       
/* 312 */       if (((Student)sList.get(i)).getStudentType().equalsIgnoreCase("Non-IBDP")) {
/* 313 */         for (int x = 0; x < (((Non_IBDP_Student)sList.get(i)).getElectiveList()).length; x++) {
/* 314 */           if (studentPList.size() != 7) {
/* 315 */             for (int a = 0; a < 8; a++) {
/* 316 */               if (!isPeriodOccupied(a, studentPList)) {
/* 317 */                 for (int b = 0; b < Login.teacherList.size(); b++) {
/* 318 */                   boolean skip = false;
/* 319 */                   for (int c = 0; c < electiveDoneList.size(); c++) {
/* 320 */                     if (((Course)electiveDoneList.get(c)).getCourseName().equals(((Non_IBDP_Student)sList.get(i)).getElectiveList()[x].getCourseName()))
/*     */                     {
/* 322 */                       skip = true;
/*     */                     }
/*     */                   } 
/* 325 */                   if (!skip && ((Non_IBDP_Student)sList.get(i)).getElectiveList()[x].getCourseName().equalsIgnoreCase(this.cellTable[b][a + 1])) {
/* 326 */                     studentPList.add(Integer.valueOf(a));
/* 327 */                     ((Student)sList.get(i)).getCourseList()[a] = ((Non_IBDP_Student)sList.get(i)).getElectiveList()[x];
/* 328 */                     electiveDoneList.add(((Non_IBDP_Student)sList.get(i)).getElectiveList()[x]);
/* 329 */                     leftover--;
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 339 */       fulfillment = (7.0D - leftover) / 7.0D * 100.0D;
/* 340 */       s.append("  " + ((Student)sList.get(i)).getStudentName() + ": " + String.format("%.1f", new Object[] { Double.valueOf(fulfillment) }) + "% fulfillment\n");
/* 341 */       overallNum += fulfillment;
/*     */       
/* 343 */       if (((Student)sList.get(i)).getStudentType().equalsIgnoreCase("IBDP")) {
/* 344 */         IBFulfillment = (7.0D - leftover) / 7.0D * 100.0D;
/* 345 */         overallIBNum += IBFulfillment;
/*     */       } 
/*     */       
/* 348 */       for (int z = 0; z < 8; z++) {
/* 349 */         int m = z + 1;
/* 350 */         if (((Student)sList.get(i)).getCourseList()[z] != null) {
/* 351 */           s.append("      P" + m + ": " + ((Student)sList.get(i)).getCourseList()[z].getCourseName() + "\n");
/*     */         } else {
/*     */           
/* 354 */           s.append("      P" + m + ": X \n");
/*     */         } 
/*     */       } 
/* 357 */       for (int y = 0; y < ((Student)sList.get(i)).getDesiredList().size(); y++) {
/* 358 */         this.count = 0;
/* 359 */         for (int p = 0; p < 8; p++) {
/* 360 */           if (((Student)sList.get(i)).getCourseList()[p] != null) {
/* 361 */             if (!((Course)((Student)sList.get(i)).getDesiredList().get(y)).getCourseName().equalsIgnoreCase(((Student)sList.get(i)).getCourseList()[p].getCourseName()))
/*     */             {
/* 363 */               this.count++; } 
/*     */           } else {
/* 365 */             this.count++;
/*     */           } 
/* 367 */         }  if (this.count == 8) {
/* 368 */           s.append("          * core selection " + ((Course)((Student)sList.get(i)).getDesiredList().get(y)).getCourseName() + " missing\n");
/*     */         }
/*     */       } 
/* 371 */       s.append("\n");
/*     */     } 
/*     */     
/* 374 */     int ibStudentCount = 0;
/*     */     
/* 376 */     for (int j = 0; j < sList.size(); j++) {
/* 377 */       if (((Student)sList.get(j)).getStudentType().equalsIgnoreCase("IBDP")) ibStudentCount++;
/*     */     
/*     */     } 
/* 380 */     double IBdisplay = overallIBNum / ibStudentCount;
/* 381 */     double display = overallNum / sList.size();
/*     */     
/* 383 */     if ((sList.size() * 100) == overallNum) {
/* 384 */       o.setText("100");
/*     */     } else {
/* 386 */       o.setText(String.format("%.1f", new Object[] { Double.valueOf(display) }));
/*     */     } 
/* 388 */     s.append("\n  IBDP fulfillment rate: " + String.format("%.1f", new Object[] { Double.valueOf(IBdisplay) }) + "%");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPeriodOccupied(int target, ArrayList<Integer> studentPList) {
/* 393 */     for (int i = 0; i < studentPList.size(); i++) {
/* 394 */       if (((Integer)studentPList.get(i)).intValue() == target) return true; 
/*     */     } 
/* 396 */     return false;
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 401 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("scheduleList.dat"));
/* 402 */       out.writeObject(Login.scheduleList);
/* 403 */       out.close(); }
/* 404 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */   public void fillStringTable(Course[][] scheduleTable, String[][] cellTable, ArrayList<Teacher> tList) {
/* 408 */     for (int i = 0; i < this.teacherListSize; i++) {
/* 409 */       cellTable[i][0] = ((Teacher)Login.teacherList.get(i)).getTeacherName();
/* 410 */       for (int j = 0; j < 8; j++) {
/* 411 */         if (scheduleTable[i][j].getCourseName() != null) {
/* 412 */           cellTable[i][j + 1] = scheduleTable[i][j].getCourseName();
/*     */         } else {
/*     */           
/* 415 */           cellTable[i][j + 1] = "X";
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Load_Schedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */