/*     */ package database;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.net.URL;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.border.EmptyBorder;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GS_Lobby
/*     */   extends JFrame
/*     */ {
/*     */   private JPanel contentPane;
/*  25 */   ImageIcon redTeamChair = new ImageIcon(getClass().getResource("/img/Red_Chair.png"));
/*  26 */   ImageIcon redTeamChairCaptain = new ImageIcon(getClass().getResource("/img/Red_Captain_Chair.png"));
/*  27 */   ImageIcon redTeamTable = new ImageIcon(getClass().getResource("/img/Red_Team_Table.png"));
/*  28 */   ImageIcon blueTeamChair = new ImageIcon(getClass().getResource("/img/Blue_Chair.png"));
/*  29 */   ImageIcon blueTeamChairCaptain = new ImageIcon(getClass().getResource("/img/Blue_Captain_Chair.png"));
/*  30 */   ImageIcon blueTeamTable = new ImageIcon(getClass().getResource("/img/Blue_Team_Table.png"));
/*  31 */   ImageIcon crown = new ImageIcon(getClass().getResource("/img/Crown.png"));
/*  32 */   ImageIcon bg = new ImageIcon(getClass().getResource("/img/bg.jpg"));
/*  33 */   ImageIcon greenCircle = new ImageIcon(getClass().getResource("/img/Green_Circle.png"));
/*     */   
/*     */   private JTextField redInput;
/*     */   private JTextField blueInput;
/*  37 */   String blueScore = "000";
/*  38 */   String redScore = "000";
/*     */ 
/*     */ 
/*     */   
/*     */   public GS_Lobby() {
/*  43 */     setDefaultCloseOperation(2);
/*  44 */     setBounds(0, 0, 1440, 900);
/*  45 */     this.contentPane = new JPanel();
/*  46 */     this.contentPane.setBackground(UIManager.getColor("ToggleButton.background"));
/*  47 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/*  48 */     setContentPane(this.contentPane);
/*  49 */     this.contentPane.setLayout((LayoutManager)null);
/*     */ 
/*     */     
/*  52 */     JButton btnClick = new JButton("CLICK!");
/*  53 */     btnClick.setBounds(155, 652, 70, 46);
/*  54 */     this.contentPane.add(btnClick);
/*     */     
/*  56 */     JLabel lblRedTeamTable = new JLabel(this.redTeamTable);
/*  57 */     lblRedTeamTable.setBounds(17, 569, 684, 204);
/*  58 */     this.contentPane.add(lblRedTeamTable);
/*     */ 
/*     */     
/*  61 */     JLabel lblRedTeamChair3 = new JLabel(this.redTeamChair);
/*  62 */     lblRedTeamChair3.setBounds(343, 462, 131, 239);
/*  63 */     this.contentPane.add(lblRedTeamChair3);
/*     */     
/*  65 */     JLabel lblRedTeamChair1 = new JLabel(this.redTeamChair);
/*  66 */     lblRedTeamChair1.setBounds(145, 517, 104, 128);
/*  67 */     this.contentPane.add(lblRedTeamChair1);
/*     */ 
/*     */     
/*  70 */     JLabel lblRedTeamChair2 = new JLabel(this.redTeamChair);
/*  71 */     lblRedTeamChair2.setBounds(254, 513, 101, 136);
/*  72 */     this.contentPane.add(lblRedTeamChair2);
/*     */ 
/*     */     
/*  75 */     JLabel lblRedTeamChairCaptain = new JLabel(this.redTeamChairCaptain);
/*  76 */     lblRedTeamChairCaptain.setBounds(425, 468, 170, 202);
/*  77 */     this.contentPane.add(lblRedTeamChairCaptain);
/*     */ 
/*     */     
/*  80 */     JLabel lblBlueTeamTable = new JLabel(this.blueTeamTable);
/*  81 */     lblBlueTeamTable.setBounds(794, 591, 570, 160);
/*  82 */     this.contentPane.add(lblBlueTeamTable);
/*     */     
/*  84 */     JLabel lblBlueCrown = new JLabel(this.crown);
/*  85 */     lblBlueCrown.setBounds(830, 310, 201, 339);
/*  86 */     this.contentPane.add(lblBlueCrown);
/*     */     
/*  88 */     JLabel lblRedCrown = new JLabel(this.crown);
/*  89 */     lblRedCrown.setBounds(404, 310, 201, 339);
/*  90 */     this.contentPane.add(lblRedCrown);
/*     */ 
/*     */     
/*  93 */     JLabel lblBlueTeamChairCaptain = new JLabel(this.blueTeamChairCaptain);
/*  94 */     lblBlueTeamChairCaptain.setBounds(830, 414, 201, 306);
/*  95 */     this.contentPane.add(lblBlueTeamChairCaptain);
/*     */ 
/*     */     
/*  98 */     JLabel lblBlueTeamChair1 = new JLabel(this.blueTeamChair);
/*  99 */     lblBlueTeamChair1.setBounds(911, 408, 227, 347);
/* 100 */     this.contentPane.add(lblBlueTeamChair1);
/*     */ 
/*     */     
/* 103 */     JLabel lblBlueTeamChair3 = new JLabel(this.blueTeamChair);
/* 104 */     lblBlueTeamChair3.setBounds(1133, 444, 201, 274);
/* 105 */     this.contentPane.add(lblBlueTeamChair3);
/*     */ 
/*     */     
/* 108 */     JLabel lblBlueTeamChair2 = new JLabel(this.blueTeamChair);
/* 109 */     lblBlueTeamChair2.setBounds(1029, 412, 201, 339);
/* 110 */     this.contentPane.add(lblBlueTeamChair2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 117 */       BufferedImage avatar_1 = ImageIO.read(new URL("https://s3.ap-south-1.amazonaws.com/academicgames/avatar_01.png"));
/* 118 */       ImageIcon avatar1imgicon = new ImageIcon(avatar_1);
/* 119 */       JLabel lblAvatar = new JLabel(avatar1imgicon);
/* 120 */       this.contentPane.add(lblAvatar);
/*     */     }
/* 122 */     catch (Exception e) {
/* 123 */       System.out.print("EXCEPTION OCCURED WHILE LOADING AVATAR.");
/*     */     } 
/*     */ 
/*     */     
/* 127 */     this.redInput = new JTextField();
/* 128 */     this.redInput.setBounds(119, 744, 460, 38);
/* 129 */     this.contentPane.add(this.redInput);
/* 130 */     this.redInput.setColumns(10);
/*     */ 
/*     */     
/* 133 */     this.blueInput = new JTextField();
/* 134 */     this.blueInput.setColumns(10);
/* 135 */     this.blueInput.setBounds(859, 744, 460, 38);
/* 136 */     this.contentPane.add(this.blueInput);
/*     */ 
/*     */     
/* 139 */     JLabel lblRedScore = new JLabel(this.redScore);
/* 140 */     lblRedScore.setForeground(new Color(191, 56, 46));
/* 141 */     lblRedScore.setHorizontalAlignment(4);
/* 142 */     lblRedScore.setFont(new Font("Digital-7 Mono", 0, 160));
/* 143 */     lblRedScore.setBounds(76, 121, 234, 160);
/* 144 */     this.contentPane.add(lblRedScore);
/*     */     
/* 146 */     JLabel lblBlueScore = new JLabel(this.blueScore);
/* 147 */     lblBlueScore.setForeground(new Color(46, 101, 188));
/* 148 */     lblBlueScore.setHorizontalAlignment(2);
/* 149 */     lblBlueScore.setFont(new Font("Digital-7 Mono", 0, 160));
/* 150 */     lblBlueScore.setBounds(1130, 121, 234, 160);
/* 151 */     this.contentPane.add(lblBlueScore);
/*     */ 
/*     */     
/* 154 */     JTextArea questionArea = new JTextArea();
/* 155 */     questionArea.setEditable(false);
/* 156 */     questionArea.setBounds(365, 67, 709, 351);
/* 157 */     this.contentPane.add(questionArea);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     JLabel lblBg = new JLabel(this.bg);
/* 163 */     lblBg.setBounds(0, 0, 1440, 900);
/* 164 */     this.contentPane.add(lblBg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String scoreRepresentation(int score) {
/* 172 */     if (score >= 100) return (new StringBuilder(String.valueOf(score))).toString(); 
/* 173 */     if (score < 100 && score > 9) {
/* 174 */       return "0" + score;
/*     */     }
/*     */     
/* 177 */     return "00" + score;
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\GS_Lobby.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */