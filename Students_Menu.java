/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Students_Menu
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   static JTable table_students;
/*     */   private JTextField textField_search;
/*  41 */   private DefaultTableModel dm = new DefaultTableModel();
/*     */ 
/*     */ 
/*     */   
/*     */   static int row;
/*     */ 
/*     */ 
/*     */   
/*     */   public Students_Menu() {
/*  50 */     setDefaultCloseOperation(3);
/*  51 */     setBounds(100, 100, 700, 500);
/*  52 */     this.contentPane = new JPanel();
/*  53 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  54 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  55 */     setContentPane(this.contentPane);
/*  56 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  58 */     table_students = new JTable();
/*  59 */     table_students.setBounds(34, 70, 573, 278);
/*  60 */     table_students.setAutoCreateRowSorter(true);
/*  61 */     table_students.setDefaultEditor(Object.class, (TableCellEditor)null);
/*  62 */     createColumns();
/*  63 */     table_students.getColumnModel().getColumn(0).setMaxWidth(65);
/*  64 */     this.contentPane.add(table_students);
/*     */     
/*  66 */     JScrollPane scrollPane = new JScrollPane(table_students);
/*  67 */     scrollPane.setBounds(34, 70, 573, 278);
/*  68 */     this.contentPane.add(scrollPane);
/*     */     
/*  70 */     JLabel lblSearchStudent = new JLabel("Search By Name (Case-sensitive):");
/*  71 */     lblSearchStudent.setBounds(44, 364, 292, 16);
/*  72 */     this.contentPane.add(lblSearchStudent);
/*     */     
/*  74 */     JLabel lblStudentCourseSelectionInformation = new JLabel("Student Course Selection Information");
/*  75 */     lblStudentCourseSelectionInformation.setHorizontalAlignment(0);
/*  76 */     lblStudentCourseSelectionInformation.setFont(new Font("Lucida Grande", 0, 20));
/*  77 */     lblStudentCourseSelectionInformation.setBounds(6, 30, 688, 16);
/*  78 */     this.contentPane.add(lblStudentCourseSelectionInformation);
/*     */     
/*  80 */     for (int i = 0; i < Login.studentList.size(); i++) {
/*  81 */       String[] rowData = { ((Student)Login.studentList.get(i)).getStudentType(), ((Student)Login.studentList.get(i)).getStudentName() };
/*  82 */       this.dm.addRow((Object[])rowData);
/*     */     } 
/*     */ 
/*     */     
/*  86 */     JButton btnAdd = new JButton("+");
/*  87 */     btnAdd.setForeground(UIManager.getColor("ToolBar.light"));
/*  88 */     btnAdd.setBounds(623, 83, 60, 60);
/*  89 */     this.contentPane.add(btnAdd);
/*  90 */     btnAdd.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  92 */             Students_Menu.this.dispose();
/*  93 */             Students_Add sa = new Students_Add();
/*  94 */             sa.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/*  98 */     JButton btnEdit = new JButton("Edit");
/*  99 */     btnEdit.setBounds(623, 214, 60, 60);
/* 100 */     this.contentPane.add(btnEdit);
/* 101 */     btnEdit.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 103 */             Students_Menu.row = Students_Menu.table_students.getSelectedRow();
/*     */             
/* 105 */             Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row));
/* 106 */             Students_Menu.this.dispose();
/* 107 */             Students_Edit se = new Students_Edit();
/* 108 */             se.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 112 */     JButton btnDelete = new JButton("Delete");
/* 113 */     btnDelete.setBounds(623, 274, 60, 60);
/* 114 */     this.contentPane.add(btnDelete);
/* 115 */     btnDelete.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 117 */             Students_Menu.row = Students_Menu.table_students.getSelectedRow();
/*     */             
/* 119 */             Login.infoBox(String.valueOf(((Student)Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row))).getStudentName()) + " removed.", "");
/* 120 */             Login.studentList.remove(Login.studentList.get(Students_Menu.table_students.convertRowIndexToModel(Students_Menu.row)));
/* 121 */             Students_Menu.saveListToFile();
/* 122 */             Students_Menu.this.dispose();
/* 123 */             Students_Menu sm = new Students_Menu();
/* 124 */             sm.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 128 */     JButton btnMainMenu = new JButton("← Main Menu");
/* 129 */     btnMainMenu.setBounds(20, 410, 190, 47);
/* 130 */     this.contentPane.add(btnMainMenu);
/* 131 */     btnMainMenu.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 133 */             Students_Menu.this.dispose();
/* 134 */             Main m = new Main();
/* 135 */             m.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 139 */     JButton btnRestrictions_Priorities = new JButton("Restrictions →");
/* 140 */     btnRestrictions_Priorities.setBounds(491, 410, 190, 47);
/* 141 */     this.contentPane.add(btnRestrictions_Priorities);
/* 142 */     btnRestrictions_Priorities.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 144 */             Students_Menu.this.dispose();
/* 145 */             Restrictions rap = new Restrictions();
/* 146 */             rap.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 150 */     this.textField_search = new JTextField();
/* 151 */     this.textField_search.setBounds(256, 359, 344, 26);
/* 152 */     this.contentPane.add(this.textField_search);
/* 153 */     this.textField_search.setColumns(10);
/* 154 */     this.textField_search.addKeyListener(new KeyAdapter()
/*     */         {
/*     */           public void keyReleased(KeyEvent e) {
/* 157 */             String query = Students_Menu.this.textField_search.getText();
/* 158 */             Students_Menu.this.filter(query);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void createColumns() {
/* 166 */     this.dm = (DefaultTableModel)table_students.getModel();
/* 167 */     this.dm.addColumn("Type");
/* 168 */     this.dm.addColumn("Name");
/*     */   }
/*     */   
/*     */   private void filter(String query) {
/* 172 */     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(this.dm);
/* 173 */     table_students.setRowSorter((RowSorter)tr);
/*     */     
/* 175 */     tr.setRowFilter(RowFilter.regexFilter(query, new int[0]));
/*     */   }
/*     */   
/*     */   public static void saveListToFile() {
/*     */     
/* 180 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studentList.dat"));
/* 181 */       out.writeObject(Login.studentList);
/* 182 */       out.close(); }
/* 183 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Students_Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */