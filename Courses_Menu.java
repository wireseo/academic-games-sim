/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.SystemColor;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.RowFilter;
/*     */ import javax.swing.RowSorter;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableCellEditor;
/*     */ import javax.swing.table.TableRowSorter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Courses_Menu
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   static JTable table_courses;
/*     */   private JTextField textField_search;
/*  40 */   private DefaultTableModel dm = new DefaultTableModel();
/*     */ 
/*     */   
/*     */   static int row;
/*     */ 
/*     */ 
/*     */   
/*     */   public Courses_Menu() {
/*  48 */     setDefaultCloseOperation(3);
/*  49 */     setBounds(100, 100, 700, 500);
/*  50 */     this.contentPane = new JPanel();
/*  51 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  52 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  53 */     setContentPane(this.contentPane);
/*  54 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  56 */     table_courses = new JTable();
/*  57 */     table_courses.setBounds(34, 70, 573, 278);
/*  58 */     this.contentPane.add(table_courses);
/*  59 */     createColumns();
/*  60 */     table_courses.getColumnModel().getColumn(0).setMaxWidth(55);
/*  61 */     table_courses.setAutoCreateRowSorter(true);
/*  62 */     table_courses.setDefaultEditor(Object.class, (TableCellEditor)null);
/*     */     
/*  64 */     JScrollPane scrollPane = new JScrollPane(table_courses);
/*  65 */     scrollPane.setBounds(34, 70, 573, 278);
/*  66 */     this.contentPane.add(scrollPane);
/*     */ 
/*     */     
/*  69 */     for (int i = 0; i < Login.courseList.size(); i++) {
/*  70 */       String[] rowData = { ((Course)Login.courseList.get(i)).getCourseType(), ((Course)Login.courseList.get(i)).getCourseName() };
/*  71 */       this.dm.addRow((Object[])rowData);
/*     */     } 
/*     */     
/*  74 */     JButton btnStudentSettings = new JButton("Student Settings →");
/*  75 */     btnStudentSettings.setBounds(521, 410, 160, 47);
/*  76 */     this.contentPane.add(btnStudentSettings);
/*  77 */     btnStudentSettings.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  79 */             int a = JOptionPane.showConfirmDialog(Courses_Menu.this.contentPane, "Once confirmed, you will not be able to edit course information until you reset your configuration. Is all course information correctly entered?", null, 0);
/*  80 */             if (a == 0) {
/*  81 */               Courses_Menu.this.dispose();
/*  82 */               Students_Menu sm = new Students_Menu();
/*  83 */               sm.setVisible(true);
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     JLabel lblCourseInformation = new JLabel("Course Information");
/*  93 */     lblCourseInformation.setHorizontalAlignment(0);
/*  94 */     lblCourseInformation.setFont(new Font("Lucida Grande", 0, 20));
/*  95 */     lblCourseInformation.setBounds(6, 30, 688, 16);
/*  96 */     this.contentPane.add(lblCourseInformation);
/*     */ 
/*     */     
/*  99 */     JButton btnAdd = new JButton("+");
/* 100 */     btnAdd.setForeground(SystemColor.controlHighlight);
/* 101 */     btnAdd.setBounds(623, 83, 60, 60);
/* 102 */     this.contentPane.add(btnAdd);
/* 103 */     btnAdd.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 105 */             Courses_Menu.this.dispose();
/* 106 */             Courses_Add ca = new Courses_Add();
/* 107 */             ca.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 111 */     JButton btnEdit = new JButton("Edit");
/* 112 */     btnEdit.setBounds(623, 214, 60, 60);
/* 113 */     this.contentPane.add(btnEdit);
/* 114 */     btnEdit.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 116 */             Courses_Menu.row = Courses_Menu.table_courses.getSelectedRow();
/* 117 */             Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row));
/* 118 */             Courses_Menu.this.dispose();
/* 119 */             Courses_Edit ce = new Courses_Edit();
/* 120 */             ce.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 124 */     JButton btnDelete = new JButton("Delete");
/* 125 */     btnDelete.setBounds(623, 274, 60, 60);
/* 126 */     this.contentPane.add(btnDelete);
/* 127 */     btnDelete.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 129 */             Courses_Menu.row = Courses_Menu.table_courses.getSelectedRow();
/* 130 */             Login.infoBox(String.valueOf(((Course)Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row))).getCourseName()) + " removed.", "");
/* 131 */             Login.courseList.remove(Login.courseList.get(Courses_Menu.table_courses.convertRowIndexToModel(Courses_Menu.row)));
/* 132 */             Courses_Menu.saveListToFile();
/*     */             
/* 134 */             Courses_Menu.this.dispose();
/* 135 */             Courses_Menu cm = new Courses_Menu();
/* 136 */             cm.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 140 */     this.textField_search = new JTextField();
/* 141 */     this.textField_search.setColumns(10);
/* 142 */     this.textField_search.setBounds(256, 359, 344, 26);
/* 143 */     this.contentPane.add(this.textField_search);
/* 144 */     this.textField_search.addKeyListener(new KeyAdapter()
/*     */         {
/*     */           public void keyReleased(KeyEvent e) {
/* 147 */             String query = Courses_Menu.this.textField_search.getText();
/* 148 */             Courses_Menu.this.filter(query);
/*     */           }
/*     */         });
/*     */     
/* 152 */     JLabel lblSearchCourse = new JLabel("Search By Name (Case-sensitive):");
/* 153 */     lblSearchCourse.setBounds(44, 364, 263, 16);
/* 154 */     this.contentPane.add(lblSearchCourse);
/*     */     
/* 156 */     JButton btnMainMenu = new JButton("← Main Menu");
/* 157 */     btnMainMenu.setBounds(20, 410, 190, 47);
/* 158 */     this.contentPane.add(btnMainMenu);
/* 159 */     btnMainMenu.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 161 */             Courses_Menu.this.dispose();
/* 162 */             Main m = new Main();
/* 163 */             m.setVisible(true);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private void createColumns() {
/* 170 */     this.dm = (DefaultTableModel)table_courses.getModel();
/* 171 */     this.dm.addColumn("Type");
/* 172 */     this.dm.addColumn("Name");
/*     */   }
/*     */   
/*     */   private void filter(String query) {
/* 176 */     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(this.dm);
/* 177 */     table_courses.setRowSorter((RowSorter)tr);
/*     */     
/* 179 */     tr.setRowFilter(RowFilter.regexFilter(query, new int[0]));
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 184 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("courseList.dat"));
/* 185 */       out.writeObject(Login.courseList);
/* 186 */       out.close(); }
/* 187 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Courses_Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */