/*     */ package database;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*     */   boolean beta = true;
/*     */   
/*     */   public Main() {
/*  38 */     setDefaultCloseOperation(3);
/*  39 */     setBounds(0, 0, 1440, 900);
/*  40 */     this.contentPane = new JPanel();
/*  41 */     this.contentPane.setBackground(Color.ORANGE);
/*  42 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  43 */     setContentPane(this.contentPane);
/*  44 */     this.contentPane.setLayout((LayoutManager)null);
/*  45 */     setExtendedState(6);
/*  46 */     setUndecorated(true);
/*     */     
/*  48 */     JLabel lblUserName = new JLabel("");
/*  49 */     lblUserName.setHorizontalAlignment(11);
/*  50 */     lblUserName.setFont(new Font("Lucida Grande", 0, 19));
/*  51 */     lblUserName.setBounds(1137, 24, 270, 70);
/*  52 */     this.contentPane.add(lblUserName);
/*     */     
/*  54 */     JButton btnSoloPractice = new JButton("Solo Practice");
/*  55 */     btnSoloPractice.setBounds(561, 536, 315, 53);
/*  56 */     this.contentPane.add(btnSoloPractice);
/*  57 */     btnSoloPractice.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  59 */             SoloPractice_Settings sps = new SoloPractice_Settings();
/*  60 */             sps.setVisible(true);
/*     */           }
/*     */         });
/*  63 */     JLabel lblAcademicGamesSimulator = new JLabel("Academic Games Simulator");
/*  64 */     lblAcademicGamesSimulator.setHorizontalAlignment(0);
/*  65 */     lblAcademicGamesSimulator.setFont(new Font("Lucida Grande", 0, 30));
/*  66 */     lblAcademicGamesSimulator.setBounds(497, 154, 444, 190);
/*  67 */     this.contentPane.add(lblAcademicGamesSimulator);
/*     */     
/*  69 */     JButton btnQuit = new JButton("Quit");
/*  70 */     btnQuit.setBounds(561, 610, 315, 53);
/*  71 */     this.contentPane.add(btnQuit);
/*  72 */     btnQuit.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  74 */             int option = JOptionPane.showConfirmDialog(null, "Do you really want to quit?", ":(", 0);
/*  75 */             if (option == 0) {
/*  76 */               System.exit(0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void infoBox(String infoMessage, String titleBar) {
/* 157 */     JOptionPane.showMessageDialog(null, infoMessage, titleBar, 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */