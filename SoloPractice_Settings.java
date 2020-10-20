/*     */ package database;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.Random;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoloPractice_Settings
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*  26 */   Random rand = new Random();
/*  27 */   static boolean[] categoryArray = new boolean[6];
/*     */ 
/*     */   
/*     */   static boolean timed;
/*     */   
/*     */   static int endT;
/*     */   
/*     */   static int endQ;
/*     */ 
/*     */   
/*     */   public SoloPractice_Settings() {
/*  38 */     setDefaultCloseOperation(2);
/*  39 */     setBounds(100, 100, 470, 450);
/*  40 */     this.contentPane = new JPanel();
/*  41 */     this.contentPane.setBackground(Color.ORANGE);
/*  42 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  43 */     setContentPane(this.contentPane);
/*  44 */     this.contentPane.setLayout((LayoutManager)null);
/*  45 */     setResizable(false);
/*     */     
/*  47 */     JLabel lblNewLabel = new JLabel("S E T T I N G S");
/*  48 */     lblNewLabel.setBounds(0, 24, 470, 72);
/*  49 */     lblNewLabel.setHorizontalAlignment(0);
/*  50 */     lblNewLabel.setFont(new Font("Lucida Grande", 0, 35));
/*  51 */     this.contentPane.add(lblNewLabel);
/*     */     
/*  53 */     JLabel lblCategory = new JLabel("CATEGORY:");
/*  54 */     lblCategory.setBounds(48, 127, 72, 16);
/*  55 */     this.contentPane.add(lblCategory);
/*     */     
/*  57 */     final JCheckBox chckbxScience = new JCheckBox("SCIENCE");
/*  58 */     chckbxScience.setBounds(125, 124, 85, 23);
/*  59 */     this.contentPane.add(chckbxScience);
/*  60 */     if (categoryArray[0]) chckbxScience.setSelected(true);
/*     */     
/*  62 */     final JCheckBox chckbxMath = new JCheckBox("MATH");
/*  63 */     chckbxMath.setBounds(215, 124, 70, 23);
/*  64 */     this.contentPane.add(chckbxMath);
/*  65 */     if (categoryArray[1]) chckbxMath.setSelected(true);
/*     */     
/*  67 */     final JCheckBox chckbxHistory = new JCheckBox("HISTORY");
/*  68 */     chckbxHistory.setBounds(315, 124, 87, 23);
/*  69 */     this.contentPane.add(chckbxHistory);
/*  70 */     if (categoryArray[2]) chckbxHistory.setSelected(true);
/*     */     
/*  72 */     final JCheckBox chckbxArts = new JCheckBox("ARTS");
/*  73 */     chckbxArts.setBounds(125, 159, 64, 23);
/*  74 */     this.contentPane.add(chckbxArts);
/*  75 */     if (categoryArray[3]) chckbxArts.setSelected(true);
/*     */     
/*  77 */     final JCheckBox chckbxLanguage = new JCheckBox("LANGUAGE");
/*  78 */     chckbxLanguage.setBounds(215, 159, 101, 23);
/*  79 */     this.contentPane.add(chckbxLanguage);
/*  80 */     if (categoryArray[4]) chckbxLanguage.setSelected(true);
/*     */     
/*  82 */     final JCheckBox chckbxCommon = new JCheckBox("COMMON");
/*  83 */     chckbxCommon.setBounds(315, 159, 93, 23);
/*  84 */     this.contentPane.add(chckbxCommon);
/*  85 */     if (categoryArray[5]) chckbxCommon.setSelected(true);
/*     */     
/*  87 */     final JCheckBox chckbxAll = new JCheckBox("ALL");
/*  88 */     chckbxAll.setForeground(Color.GRAY);
/*  89 */     chckbxAll.setFont(new Font("Lucida Grande", 0, 10));
/*  90 */     chckbxAll.setBounds(55, 144, 64, 23);
/*  91 */     this.contentPane.add(chckbxAll);
/*  92 */     chckbxAll.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  94 */             if (chckbxAll.isSelected()) {
/*  95 */               chckbxArts.setSelected(true);
/*  96 */               chckbxScience.setSelected(true);
/*  97 */               chckbxMath.setSelected(true);
/*  98 */               chckbxHistory.setSelected(true);
/*  99 */               chckbxLanguage.setSelected(true);
/* 100 */               chckbxCommon.setSelected(true);
/*     */             } else {
/*     */               
/* 103 */               chckbxArts.setSelected(false);
/* 104 */               chckbxScience.setSelected(false);
/* 105 */               chckbxMath.setSelected(false);
/* 106 */               chckbxHistory.setSelected(false);
/* 107 */               chckbxLanguage.setSelected(false);
/* 108 */               chckbxCommon.setSelected(false);
/*     */             } 
/*     */           }
/*     */         });
/* 112 */     JLabel lblDuration = new JLabel("DURATION:");
/* 113 */     lblDuration.setBounds(48, 219, 72, 16);
/* 114 */     this.contentPane.add(lblDuration);
/*     */     
/* 116 */     final JComboBox<String> tb_combo = new JComboBox();
/* 117 */     tb_combo.setBounds(257, 215, 76, 27);
/* 118 */     this.contentPane.add(tb_combo);
/* 119 */     tb_combo.addItem("...");
/* 120 */     tb_combo.addItem(Integer.valueOf(5));
/* 121 */     tb_combo.addItem(Integer.valueOf(10));
/* 122 */     tb_combo.addItem(Integer.valueOf(15));
/* 123 */     tb_combo.addItem(Integer.valueOf(20));
/* 124 */     tb_combo.addItem(Integer.valueOf(25));
/* 125 */     tb_combo.addItem(Integer.valueOf(30));
/* 126 */     tb_combo.addItem(Integer.valueOf(35));
/* 127 */     tb_combo.addItem(Integer.valueOf(40));
/* 128 */     tb_combo.addItem(Integer.valueOf(45));
/* 129 */     tb_combo.addItem(Integer.valueOf(50));
/* 130 */     tb_combo.addItem(Integer.valueOf(55));
/* 131 */     tb_combo.addItem(Integer.valueOf(60));
/*     */ 
/*     */     
/* 134 */     final JComboBox<String> qb_combo = new JComboBox();
/* 135 */     qb_combo.setBounds(257, 252, 76, 27);
/* 136 */     this.contentPane.add(qb_combo);
/*     */     
/* 138 */     qb_combo.addItem("...");
/* 139 */     qb_combo.addItem(Integer.valueOf(10));
/* 140 */     qb_combo.addItem(Integer.valueOf(20));
/* 141 */     qb_combo.addItem(Integer.valueOf(30));
/* 142 */     qb_combo.addItem(Integer.valueOf(40));
/* 143 */     qb_combo.addItem(Integer.valueOf(50));
/* 144 */     qb_combo.addItem(Integer.valueOf(60));
/* 145 */     qb_combo.addItem(Integer.valueOf(70));
/* 146 */     qb_combo.addItem(Integer.valueOf(80));
/* 147 */     qb_combo.addItem(Integer.valueOf(90));
/* 148 */     qb_combo.addItem(Integer.valueOf(100));
/*     */     
/* 150 */     qb_combo.setEnabled(false);
/* 151 */     tb_combo.setEnabled(false);
/*     */     
/* 153 */     JRadioButton tb_radio = new JRadioButton("Time-Based");
/* 154 */     tb_radio.setBounds(125, 216, 141, 23);
/* 155 */     this.contentPane.add(tb_radio);
/* 156 */     tb_radio.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 159 */             qb_combo.setSelectedItem("...");
/* 160 */             qb_combo.setEnabled(false);
/* 161 */             tb_combo.setEnabled(true);
/*     */           }
/*     */         });
/*     */     
/* 165 */     JRadioButton qb_radio = new JRadioButton("Quantity-Based");
/* 166 */     qb_radio.setBounds(125, 253, 141, 23);
/* 167 */     this.contentPane.add(qb_radio);
/* 168 */     qb_radio.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 171 */             tb_combo.setSelectedItem("...");
/* 172 */             qb_combo.setEnabled(true);
/* 173 */             tb_combo.setEnabled(false);
/*     */           }
/*     */         });
/*     */     
/* 177 */     ButtonGroup bgroup = new ButtonGroup();
/* 178 */     bgroup.add(tb_radio);
/* 179 */     bgroup.add(qb_radio);
/*     */     
/* 181 */     JLabel lblNewLabel_1 = new JLabel("minutes");
/* 182 */     lblNewLabel_1.setBounds(334, 220, 57, 15);
/* 183 */     this.contentPane.add(lblNewLabel_1);
/*     */     
/* 185 */     JLabel lblNewLabel_2 = new JLabel("questions");
/* 186 */     lblNewLabel_2.setBounds(334, 258, 74, 15);
/* 187 */     this.contentPane.add(lblNewLabel_2);
/*     */     
/* 189 */     JLabel lblTimed = new JLabel("REALISTIC:");
/* 190 */     lblTimed.setHorizontalAlignment(11);
/* 191 */     lblTimed.setBounds(48, 302, 72, 16);
/* 192 */     this.contentPane.add(lblTimed);
/*     */     
/* 194 */     final JRadioButton rdbtnY = new JRadioButton("Y (15 sec/question)");
/* 195 */     rdbtnY.setBounds(125, 298, 160, 23);
/* 196 */     this.contentPane.add(rdbtnY);
/*     */     
/* 198 */     final JRadioButton rdbtnN = new JRadioButton("N");
/* 199 */     rdbtnN.setBounds(296, 298, 64, 23);
/* 200 */     this.contentPane.add(rdbtnN);
/*     */     
/* 202 */     ButtonGroup bgroup2 = new ButtonGroup();
/* 203 */     bgroup2.add(rdbtnY);
/* 204 */     bgroup2.add(rdbtnN);
/*     */     
/* 206 */     rdbtnN.setSelected(true);
/*     */     
/* 208 */     JButton btnConfirm = new JButton("CONFIRM");
/* 209 */     btnConfirm.setBounds(182, 351, 103, 45);
/* 210 */     this.contentPane.add(btnConfirm);
/* 211 */     btnConfirm.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 213 */             SoloPractice_Settings.endT = 0;
/* 214 */             SoloPractice_Settings.endQ = 0;
/* 215 */             boolean contin = false;
/* 216 */             for (int i = 0; i < SoloPractice_Settings.categoryArray.length; i++) {
/* 217 */               SoloPractice_Settings.categoryArray[i] = false;
/*     */             }
/*     */ 
/*     */             
/* 221 */             if (tb_combo.getSelectedItem() != "...") { SoloPractice_Settings.endT = ((Integer)tb_combo.getSelectedItem()).intValue();
/*     */ 
/*     */               
/*     */                }
/*     */             
/* 226 */             else if (qb_combo.getSelectedItem() != "...") { SoloPractice_Settings.endQ = ((Integer)qb_combo.getSelectedItem()).intValue(); }
/*     */             
/* 228 */             if (chckbxScience.isSelected()) {
/* 229 */               SoloPractice_Settings.categoryArray[0] = true;
/* 230 */               contin = true;
/*     */             } 
/* 232 */             if (chckbxMath.isSelected()) {
/* 233 */               SoloPractice_Settings.categoryArray[1] = true;
/* 234 */               contin = true;
/*     */             } 
/* 236 */             if (chckbxHistory.isSelected()) {
/* 237 */               SoloPractice_Settings.categoryArray[2] = true;
/* 238 */               contin = true;
/*     */             } 
/* 240 */             if (chckbxArts.isSelected()) {
/* 241 */               SoloPractice_Settings.categoryArray[3] = true;
/* 242 */               contin = true;
/*     */             } 
/* 244 */             if (chckbxLanguage.isSelected()) {
/* 245 */               SoloPractice_Settings.categoryArray[4] = true;
/* 246 */               contin = true;
/*     */             } 
/* 248 */             if (chckbxCommon.isSelected()) {
/* 249 */               SoloPractice_Settings.categoryArray[5] = true;
/* 250 */               contin = true;
/*     */             } 
/*     */             
/* 253 */             if (rdbtnN.isSelected()) SoloPractice_Settings.timed = false; 
/* 254 */             if (rdbtnY.isSelected()) SoloPractice_Settings.timed = true;
/*     */ 
/*     */ 
/*     */             
/* 258 */             if ((tb_combo.getSelectedItem() != "..." || qb_combo.getSelectedItem() != "...") && contin) {
/* 259 */               System.out.println(String.valueOf(SoloPractice_Settings.endT) + " " + SoloPractice_Settings.endQ);
/* 260 */               SoloPractice_Settings.this.dispose();
/* 261 */               SoloPractice sp = new SoloPractice();
/* 262 */               sp.setVisible(true);
/*     */             
/*     */             }
/* 265 */             else if (!contin) {
/* 266 */               Main.infoBox("Please choose at least one category.", ":(");
/*     */             } else {
/* 268 */               Main.infoBox("Please specify the duration.", ":(");
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\SoloPractice_Settings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */