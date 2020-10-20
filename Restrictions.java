/*     */ package smartSchool;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
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
/*     */ 
/*     */ public class Restrictions
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   private JTable table;
/*     */   private JButton btnEditStudents;
/*     */   private JScrollPane scrollPane;
/*  39 */   private DefaultTableModel dm = new DefaultTableModel();
/*     */   
/*     */   static int row;
/*     */   
/*     */   private JButton btnUpdate;
/*     */   
/*     */   private JTextField textField_restriction;
/*     */   private JLabel lblRestriction;
/*     */   
/*     */   public Restrictions() {
/*  49 */     setDefaultCloseOperation(3);
/*  50 */     setBounds(100, 100, 700, 500);
/*  51 */     this.contentPane = new JPanel();
/*  52 */     this.contentPane.setBackground(UIManager.getColor("ToolTip.background"));
/*  53 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  54 */     setContentPane(this.contentPane);
/*  55 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/*  57 */     JLabel lblNewLabel = new JLabel("Restrictions");
/*  58 */     lblNewLabel.setFont(new Font("Lucida Grande", 0, 20));
/*  59 */     lblNewLabel.setHorizontalAlignment(0);
/*  60 */     lblNewLabel.setBounds(6, 30, 688, 16);
/*  61 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  63 */     this.table = new JTable();
/*  64 */     this.table.setBounds(32, 67, 635, 309);
/*  65 */     this.contentPane.add(this.table);
/*  66 */     createColumns();
/*  67 */     this.table.setDefaultEditor(Object.class, (TableCellEditor)null);
/*  68 */     this.table.getColumnModel().getColumn(0).setMinWidth(105);
/*  69 */     this.table.getColumnModel().getColumn(1).setMinWidth(385);
/*  70 */     this.table.getColumnModel().getColumn(2).setMinWidth(95);
/*     */     
/*  72 */     this.lblRestriction = new JLabel("Restriction #:");
/*  73 */     this.lblRestriction.setHorizontalAlignment(11);
/*  74 */     this.lblRestriction.setBounds(214, 366, 107, 16);
/*  75 */     this.contentPane.add(this.lblRestriction);
/*     */     
/*  77 */     this.scrollPane = new JScrollPane(this.table);
/*  78 */     this.scrollPane.setBounds(32, 67, 635, 265);
/*  79 */     this.contentPane.add(this.scrollPane);
/*     */ 
/*     */     
/*  82 */     String[] row_T_maxPds = { "T_maxPds", "Max # of periods that a teacher can teach", Login.restrictionList[0] };
/*  83 */     this.dm.addRow((Object[])row_T_maxPds);
/*     */     
/*  85 */     JButton btnGenerateSchedules = new JButton("Generate Schedules →");
/*  86 */     btnGenerateSchedules.setBounds(491, 410, 190, 47);
/*  87 */     this.contentPane.add(btnGenerateSchedules);
/*  88 */     btnGenerateSchedules.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/*  91 */             if (Login.studentList.size() != 0 && Login.courseList.size() != 0) {
/*  92 */               Login.settingsDone = true;
/*  93 */               JOptionPane.showMessageDialog(Restrictions.this.contentPane, "Please proceed to the main menu.");
/*     */             } else {
/*     */               
/*  96 */               JOptionPane.showMessageDialog(Restrictions.this.contentPane, "You don't have courses and/or students. You need to enter related data before you can proceed.");
/*     */             } 
/*  98 */             Restrictions.this.dispose();
/*  99 */             Main m = new Main();
/* 100 */             m.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 104 */     this.btnEditStudents = new JButton("← Edit Students");
/* 105 */     this.btnEditStudents.setBounds(20, 410, 190, 47);
/* 106 */     this.contentPane.add(this.btnEditStudents);
/* 107 */     this.btnEditStudents.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 109 */             Restrictions.this.dispose();
/* 110 */             Students_Menu sm = new Students_Menu();
/* 111 */             sm.setVisible(true);
/*     */           }
/*     */         });
/*     */     
/* 115 */     this.textField_restriction = new JTextField();
/* 116 */     this.textField_restriction.setColumns(10);
/* 117 */     this.textField_restriction.setBounds(330, 361, 55, 26);
/* 118 */     this.contentPane.add(this.textField_restriction);
/*     */     
/* 120 */     this.btnUpdate = new JButton("Update");
/* 121 */     this.btnUpdate.setBounds(395, 357, 65, 34);
/* 122 */     this.contentPane.add(this.btnUpdate);
/* 123 */     this.btnUpdate.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 125 */             Restrictions.row = Restrictions.this.table.getSelectedRow();
/* 126 */             if (Restrictions.row != -1) {
/*     */               try {
/* 128 */                 Integer.parseInt(Restrictions.this.textField_restriction.getText());
/*     */                 
/* 130 */                 if (Integer.parseInt(Restrictions.this.textField_restriction.getText()) < 1) {
/* 131 */                   Login.infoBox("Your input needs to be greater than 0.", "");
/*     */                 }
/* 133 */                 else if (Integer.parseInt(Restrictions.this.textField_restriction.getText()) > 8) {
/* 134 */                   Login.infoBox("Your input is over 8 (the number of periods provided).", "");
/*     */                 } else {
/*     */                   
/* 137 */                   Login.restrictionList[0] = Integer.parseInt(Restrictions.this.textField_restriction.getText());
/* 138 */                   Restrictions.saveRestrictionListToFile();
/* 139 */                   Login.infoBox("Values have been updated.", "");
/* 140 */                   Login.settingsDone = true;
/* 141 */                   Restrictions.this.dispose();
/* 142 */                   Restrictions rap = new Restrictions();
/* 143 */                   rap.setVisible(true);
/*     */                 }
/*     */               
/* 146 */               } catch (NumberFormatException nfe) {
/* 147 */                 Login.infoBox("Your input is invalid.", "");
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } else {
/* 152 */               Login.infoBox("No rows have been selected.", "");
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   private void createColumns() {
/* 158 */     this.dm = (DefaultTableModel)this.table.getModel();
/* 159 */     this.dm.addColumn("Name");
/* 160 */     this.dm.addColumn("Description");
/* 161 */     this.dm.addColumn("Restriction by #");
/*     */   }
/*     */   
/*     */   private void filter(String query) {
/* 165 */     TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(this.dm);
/* 166 */     this.table.setRowSorter((RowSorter)tr);
/*     */     
/* 168 */     tr.setRowFilter(RowFilter.regexFilter(query, new int[0]));
/*     */   }
/*     */   
/*     */   public static void saveRestrictionListToFile() {
/*     */     
/* 173 */     try { ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("restrictionList.dat"));
/* 174 */       out.writeObject(Login.restrictionList);
/* 175 */       out.close(); }
/* 176 */     catch (IOException e) { e.printStackTrace(); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCellEditable(int row, int col) {
/* 182 */     if (col == 1) {
/* 183 */       return false;
/*     */     }
/* 185 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Restrictions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */