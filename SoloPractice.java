/*     */ package database;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.LayoutManager;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.Timer;
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
/*     */ public class SoloPractice
/*     */   extends JFrame
/*     */ {
/*     */   boolean roundTimerPaused = false;
/*     */   boolean timeTimerPaused = false;
/*     */   boolean mainTimerPaused = false;
/*     */   boolean buzzerTimerPaused = false;
/*     */   boolean displayTimerPaused = false;
/*     */   boolean buzzed = false;
/*  42 */   int i = 0;
/*  43 */   int stringLength = 0;
/*     */   
/*  45 */   String whatIsLeftString = "";
/*     */   
/*  47 */   double timeTook = 0.0D;
/*  48 */   double timeTookToBuzz = 0.0D;
/*     */   
/*  50 */   Random rand = new Random();
/*     */   
/*     */   private JPanel contentPane;
/*  53 */   int questionNum = 0;
/*  54 */   String questionContent = "";
/*  55 */   String questionCategory = "";
/*  56 */   String questionHeader = "";
/*  57 */   int questionID = 0;
/*     */ 
/*     */   
/*  60 */   ArrayList<String> answerArrayList = new ArrayList<>();
/*  61 */   ArrayList<Integer> questionHistoryArrayList = new ArrayList<>();
/*     */   
/*     */   private JTextField answerField;
/*  64 */   int score = 0;
/*     */   private JLabel lblScore;
/*     */   boolean end;
/*     */   int minutesLeft;
/*  68 */   int minutesPassed = 0;
/*     */   int secondsLeft;
/*  70 */   int secondsPassed = 0;
/*     */   int questionsLeft;
/*  72 */   int questionsSolved = 0;
/*  73 */   int correctCount = 0;
/*     */   public static int n;
/*  75 */   int checkDuplicateCount = 0;
/*     */   
/*     */   boolean[] checkDuplicateArray;
/*  78 */   JButton btnBuzzer = new JButton("Buzz!");
/*     */   
/*  80 */   JLabel lblQuestionTime = new JLabel();
/*     */   
/*  82 */   JTextArea textArea = new JTextArea();
/*  83 */   JLabel lblWhatIsLeft = new JLabel();
/*  84 */   public int miniTime = 7;
/*     */   
/*  86 */   Timer roundTimer = new Timer(1000, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/*  88 */           if (!SoloPractice.this.roundTimerPaused) {
/*  89 */             SoloPractice.this.lblQuestionTime.setText((new StringBuilder(String.valueOf(SoloPractice.this.miniTime))).toString());
/*  90 */             SoloPractice.this.miniTime--;
/*  91 */             System.out.println("Time: " + SoloPractice.this.miniTime);
/*     */           } 
/*     */         }
/*     */       });
/*     */   
/*  96 */   Timer roundTimerStopper = new Timer(1000, new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent evt) {
/*  99 */           if (SoloPractice.this.miniTime == -1) {
/* 100 */             System.out.println("roundTimerStopper activated");
/* 101 */             SoloPractice.this.roundTimerPaused = true;
/* 102 */             SoloPractice.this.mainTimerPaused = true;
/* 103 */             SoloPractice.this.buzzerTimerPaused = true;
/*     */ 
/*     */             
/* 106 */             String timeOutString = "TIME OUT, the acceptible answer(s) is(are): \n - " + (String)SoloPractice.this.answerArrayList.get(0);
/*     */             
/* 108 */             SoloPractice.this.questionsSolved++;
/*     */             
/* 110 */             if (SoloPractice.this.answerArrayList.size() > 1) {
/* 111 */               for (int j = 1; j < SoloPractice.this.answerArrayList.size(); j++) {
/* 112 */                 timeOutString = String.valueOf(timeOutString) + "\n - " + (String)SoloPractice.this.answerArrayList.get(j);
/*     */               }
/*     */             }
/*     */             
/* 116 */             Main.infoBox(timeOutString, "");
/* 117 */             if (SoloPractice_Settings.endQ != 0) {
/* 118 */               if (SoloPractice.this.questionsLeft == 1) {
/* 119 */                 SoloPractice.this.resetEverything();
/* 120 */                 SoloPractice.this.miniTime = 0;
/*     */               } else {
/*     */                 
/* 123 */                 SoloPractice.this.miniTime = 7;
/* 124 */                 SoloPractice.this.lblQuestionTime.setText((new StringBuilder(String.valueOf(SoloPractice.this.miniTime))).toString());
/* 125 */                 SoloPractice.this.prepare(SoloPractice.this.textArea, SoloPractice.this.answerArrayList);
/* 126 */                 SoloPractice.this.generateQuestion(SoloPractice.this.textArea);
/*     */               }
/*     */             
/* 129 */             } else if (SoloPractice_Settings.endT != 0) {
/* 130 */               SoloPractice.this.miniTime = 7;
/* 131 */               SoloPractice.this.lblQuestionTime.setText((new StringBuilder(String.valueOf(SoloPractice.this.miniTime))).toString());
/* 132 */               SoloPractice.this.prepare(SoloPractice.this.textArea, SoloPractice.this.answerArrayList);
/* 133 */               SoloPractice.this.generateQuestion(SoloPractice.this.textArea);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */   
/* 141 */   Timer mainTimer = new Timer(1000, new ActionListener()
/*     */       {
/*     */         public void actionPerformed(ActionEvent evt) {
/* 144 */           if (!SoloPractice.this.mainTimerPaused) {
/* 145 */             SoloPractice.this.secondsPassed++;
/* 146 */             SoloPractice.this.secondsLeft = SoloPractice_Settings.endT * 60 - SoloPractice.this.secondsPassed;
/* 147 */             if (SoloPractice.this.secondsPassed % 60 == 0) {
/* 148 */               SoloPractice.this.minutesPassed++;
/* 149 */               System.out.println("1 minute passed.");
/* 150 */               SoloPractice.this.minutesLeft = SoloPractice_Settings.endT - SoloPractice.this.minutesPassed;
/*     */             } 
/* 152 */             SoloPractice.this.whatIsLeftString = "Time Remaining: " + SoloPractice.this.minutesLeft + " minutes / " + SoloPractice.this.secondsLeft + " seconds";
/* 153 */             SoloPractice.this.lblWhatIsLeft.setText(SoloPractice.this.whatIsLeftString);
/*     */           } 
/*     */         }
/*     */       });
/*     */ 
/*     */   
/* 159 */   Timer mainTimerStopper = new Timer(60000, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/* 161 */           if (SoloPractice.this.minutesLeft == 0) {
/*     */             
/* 163 */             SoloPractice.this.mainTimer.stop();
/* 164 */             if (SoloPractice_Settings.timed) {
/* 165 */               SoloPractice.this.roundTimer.stop();
/* 166 */               SoloPractice.this.roundTimerStopper.stop();
/*     */             } 
/*     */             
/* 169 */             String timeOutString = "TIME OUT, the acceptible answer(s) is(are): \n - " + (String)SoloPractice.this.answerArrayList.get(0);
/*     */             
/* 171 */             if (SoloPractice.this.answerArrayList.size() > 1) {
/* 172 */               for (int j = 1; j < SoloPractice.this.answerArrayList.size(); j++) {
/* 173 */                 timeOutString = String.valueOf(timeOutString) + "\n - " + (String)SoloPractice.this.answerArrayList.get(j);
/*     */               }
/*     */             }
/*     */             
/* 177 */             Main.infoBox(timeOutString, "");
/* 178 */             SoloPractice.this.resetEverything();
/*     */           } 
/*     */         }
/*     */       });
/*     */   
/* 183 */   Timer timeTimer = new Timer(10, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/* 185 */           if (!SoloPractice.this.timeTimerPaused) {
/* 186 */             SoloPractice.this.timeTook += 0.01D;
/* 187 */             if (SoloPractice.this.questionsLeft == 0) {
/* 188 */               System.out.println("TIMETOOK STOPPED");
/* 189 */               if (SoloPractice_Settings.timed) {
/* 190 */                 SoloPractice.this.roundTimer.stop();
/* 191 */                 SoloPractice.this.roundTimerStopper.stop();
/*     */               } 
/* 193 */               SoloPractice.this.timeTimer.stop();
/*     */             } 
/*     */           } 
/*     */         }
/*     */       });
/*     */   
/* 199 */   Timer buzzerTimer = new Timer(10, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/* 201 */           if (!SoloPractice.this.buzzerTimerPaused && 
/* 202 */             !SoloPractice.this.buzzed) {
/* 203 */             SoloPractice.this.timeTookToBuzz += 0.01D;
/* 204 */             System.out.println("time took to buzz: " + SoloPractice.this.timeTookToBuzz);
/*     */           } 
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */   
/* 211 */   Timer displayTimer = new Timer(40, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent evt) {
/* 213 */           if (!SoloPractice.this.displayTimerPaused) {
/* 214 */             int stringLength = SoloPractice.this.questionContent.length();
/*     */             
/* 216 */             if (SoloPractice.this.i < stringLength) {
/* 217 */               SoloPractice.this.textArea.append(SoloPractice.this.questionContent.substring(SoloPractice.this.i, SoloPractice.this.i + 1));
/* 218 */               SoloPractice.this.i++;
/*     */             } else {
/*     */               
/* 221 */               System.out.println("displaytimer stopped");
/*     */               
/* 223 */               SoloPractice.this.i = 0;
/* 224 */               SoloPractice.this.miniTime = 7;
/* 225 */               SoloPractice.this.lblQuestionTime.setText((new StringBuilder(String.valueOf(SoloPractice.this.miniTime))).toString());
/*     */               
/* 227 */               SoloPractice.this.roundTimerPaused = false;
/* 228 */               SoloPractice.this.timeTimerPaused = false;
/* 229 */               SoloPractice.this.mainTimerPaused = false;
/* 230 */               SoloPractice.this.buzzerTimerPaused = false;
/* 231 */               SoloPractice.this.displayTimer.stop();
/*     */             } 
/*     */           } 
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SoloPractice() {
/* 244 */     setDefaultCloseOperation(0);
/* 245 */     setBounds(0, 0, 1440, 900);
/* 246 */     this.contentPane = new JPanel();
/* 247 */     this.contentPane.setBackground(Color.ORANGE);
/* 248 */     this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
/* 249 */     setContentPane(this.contentPane);
/* 250 */     this.contentPane.setLayout((LayoutManager)null);
/*     */     
/* 252 */     this.textArea.setFont(new Font("Lucida Grande", 0, 15));
/* 253 */     this.textArea.setEditable(false);
/* 254 */     this.textArea.setBounds(208, 112, 976, 395);
/* 255 */     this.contentPane.add(this.textArea);
/* 256 */     this.textArea.setLineWrap(true);
/* 257 */     this.textArea.setWrapStyleWord(true);
/* 258 */     this.textArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
/*     */     
/* 260 */     this.lblQuestionTime.setText("7");
/* 261 */     this.lblQuestionTime.setHorizontalAlignment(0);
/* 262 */     this.lblQuestionTime.setFont(new Font("Lucida Grande", 0, 25));
/* 263 */     this.lblQuestionTime.setBounds(1281, 18, 132, 59);
/* 264 */     this.contentPane.add(this.lblQuestionTime);
/*     */ 
/*     */     
/* 267 */     this.minutesLeft = SoloPractice_Settings.endT - this.minutesPassed;
/* 268 */     this.questionsLeft = SoloPractice_Settings.endQ - this.questionsSolved;
/*     */ 
/*     */     
/* 271 */     JButton btnQuit = new JButton("Quit");
/* 272 */     btnQuit.setBounds(1300, 745, 117, 79);
/* 273 */     this.contentPane.add(btnQuit);
/* 274 */     btnQuit.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 277 */             SoloPractice.this.timeTimerPaused = true;
/* 278 */             SoloPractice.this.buzzerTimerPaused = true;
/* 279 */             if (SoloPractice.this.buzzed || !SoloPractice.this.displayTimer.isRunning()) {
/* 280 */               SoloPractice.this.roundTimerPaused = true;
/*     */             }
/* 282 */             SoloPractice.this.mainTimerPaused = true;
/* 283 */             SoloPractice.this.displayTimerPaused = true;
/*     */             
/* 285 */             int option = JOptionPane.showConfirmDialog(null, "Do you really want to quit? All progress will be lost.", ":(", 0);
/* 286 */             if (option == 0) {
/* 287 */               SoloPractice.this.resetEverything();
/*     */             }
/* 289 */             else if (option == 1) {
/* 290 */               if (SoloPractice.this.buzzed || !SoloPractice.this.displayTimer.isRunning()) {
/* 291 */                 SoloPractice.this.roundTimerPaused = false;
/*     */               }
/* 293 */               SoloPractice.this.mainTimerPaused = false;
/* 294 */               SoloPractice.this.timeTimerPaused = false;
/* 295 */               SoloPractice.this.displayTimerPaused = false;
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 301 */     if (SoloPractice_Settings.endT != 0) {
/* 302 */       this.whatIsLeftString = "Time Remaining: " + this.minutesLeft + " minutes / " + (SoloPractice_Settings.endT * 60) + " seconds";
/*     */     
/*     */     }
/* 305 */     else if (SoloPractice_Settings.endQ != 0) {
/* 306 */       this.whatIsLeftString = "Questions Left: " + this.questionsLeft;
/*     */     } 
/*     */     
/* 309 */     this.lblWhatIsLeft.setFont(new Font("Lucida Grande", 0, 23));
/* 310 */     this.lblWhatIsLeft.setHorizontalAlignment(0);
/*     */     
/* 312 */     this.lblWhatIsLeft.setText(this.whatIsLeftString);
/* 313 */     this.lblWhatIsLeft.setBounds(208, 29, 976, 49);
/* 314 */     this.contentPane.add(this.lblWhatIsLeft);
/*     */     
/* 316 */     this.lblScore = new JLabel("Score: " + this.score);
/* 317 */     this.lblScore.setFont(new Font("Lucida Grande", 0, 25));
/* 318 */     this.lblScore.setBounds(27, 6, 243, 84);
/* 319 */     this.contentPane.add(this.lblScore);
/*     */ 
/*     */     
/* 322 */     this.answerField = new JTextField();
/* 323 */     this.answerField.setBounds(351, 576, 690, 46);
/* 324 */     this.contentPane.add(this.answerField);
/* 325 */     this.answerField.setColumns(10);
/* 326 */     this.answerField.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 329 */             SoloPractice.this.roundTimerPaused = true;
/* 330 */             SoloPractice.this.timeTimerPaused = true;
/* 331 */             SoloPractice.this.mainTimerPaused = true;
/* 332 */             SoloPractice.this.buzzerTimerPaused = true;
/* 333 */             SoloPractice.this.displayTimer.stop();
/* 334 */             SoloPractice.this.i = 0;
/*     */             
/* 336 */             System.out.println("Input: " + SoloPractice.this.answerField.getText());
/* 337 */             boolean right = false;
/* 338 */             SoloPractice.this.questionsSolved++;
/*     */             
/* 340 */             for (int i = 0; i < SoloPractice.this.answerArrayList.size(); i++) {
/* 341 */               System.out.println("Correct Answer" + (i + 1) + ": " + (String)SoloPractice.this.answerArrayList.get(i));
/* 342 */               if (SoloPractice.this.answerField.getText().equalsIgnoreCase(SoloPractice.this.answerArrayList.get(i))) {
/* 343 */                 SoloPractice.this.score += 5;
/* 344 */                 SoloPractice.this.lblScore.setText("Score: " + SoloPractice.this.score);
/* 345 */                 right = true;
/* 346 */                 Main.infoBox("Correct!", "");
/* 347 */                 SoloPractice.this.correctCount++;
/*     */               } 
/*     */             } 
/*     */             
/* 351 */             if (!right) {
/* 352 */               String wrongString = "Incorrect, the acceptible answer(s) is(are): \n - " + (String)SoloPractice.this.answerArrayList.get(0);
/*     */               
/* 354 */               if (SoloPractice.this.answerArrayList.size() > 1) {
/* 355 */                 for (int j = 1; j < SoloPractice.this.answerArrayList.size(); j++) {
/* 356 */                   wrongString = String.valueOf(wrongString) + "\n - " + (String)SoloPractice.this.answerArrayList.get(j);
/*     */                 }
/*     */               }
/* 359 */               Object[] options = { "Suggest Answer", "Report", "Override", "Continue" };
/*     */               
/* 361 */               int choice = JOptionPane.showOptionDialog(null, wrongString, "", 0, 3, null, options, options[3]);
/* 362 */               if (choice == 0) {
/*     */                 try {
/* 364 */                   String myQuery = "INSERT INTO requests VALUES(default, '" + SoloPractice.this.questionID + "', '" + SoloPractice.this.answerField.getText() + "')";
/* 365 */                   PreparedStatement updateRequest = DBConnection.con.prepareStatement(myQuery);
/* 366 */                   int updateUser_done = updateRequest.executeUpdate();
/* 367 */                   Main.infoBox("The admin has been informed! After a brief review, the database will be updated. Thank you for letting us know.", "");
/* 368 */                 } catch (Exception e6) {
/* 369 */                   System.out.println("ERROR: " + e6.getMessage());
/* 370 */                   Main.infoBox("Oops, there was an error. ERROR: " + e6.getMessage(), "");
/*     */                 }
/*     */               
/* 373 */               } else if (choice == 1) {
/*     */                 try {
/* 375 */                   String myQuery = "INSERT INTO requests VALUES(default, '" + SoloPractice.this.questionID + "', 'ANSWER REPORT')";
/* 376 */                   PreparedStatement updateRequest = DBConnection.con.prepareStatement(myQuery);
/* 377 */                   int updateUser_done = updateRequest.executeUpdate();
/* 378 */                   Main.infoBox("The admin has been informed! After a brief review, the database will be updated. Thank you for letting us know.", "");
/* 379 */                 } catch (Exception e6) {
/* 380 */                   System.out.println("ERROR: " + e6.getMessage());
/* 381 */                   Main.infoBox("Oops, there was an error. ERROR: " + e6.getMessage(), "");
/*     */                 }
/*     */               
/* 384 */               } else if (choice == 2) {
/* 385 */                 SoloPractice.this.score += 5;
/* 386 */                 SoloPractice.this.lblScore.setText("Score: " + SoloPractice.this.score);
/* 387 */                 SoloPractice.this.correctCount++;
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 392 */             if (SoloPractice_Settings.endQ > 0) {
/* 393 */               SoloPractice.this.questionsLeft = SoloPractice_Settings.endQ - SoloPractice.this.questionsSolved;
/* 394 */               SoloPractice.this.whatIsLeftString = "Questions Left: " + SoloPractice.this.questionsLeft;
/* 395 */               SoloPractice.this.lblWhatIsLeft.setText(SoloPractice.this.whatIsLeftString);
/* 396 */               if (SoloPractice.this.questionsLeft == 0) {
/* 397 */                 SoloPractice.this.resetEverything();
/*     */               }
/*     */             } 
/*     */ 
/*     */             
/* 402 */             if (SoloPractice_Settings.timed = true) {
/* 403 */               SoloPractice.this.miniTime = 7;
/* 404 */               SoloPractice.this.lblQuestionTime.setText((new StringBuilder(String.valueOf(SoloPractice.this.miniTime))).toString());
/*     */             } 
/*     */             
/* 407 */             SoloPractice.this.prepare(SoloPractice.this.textArea, SoloPractice.this.answerArrayList);
/* 408 */             SoloPractice.this.generateQuestion(SoloPractice.this.textArea);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 414 */     getQuestionNum();
/* 415 */     generateQuestion(this.textArea);
/*     */     
/* 417 */     if (SoloPractice_Settings.timed) {
/* 418 */       this.roundTimer.start();
/* 419 */       this.roundTimerStopper.start();
/*     */     } 
/*     */     
/* 422 */     if (SoloPractice_Settings.endT != 0) {
/* 423 */       this.mainTimer.start();
/* 424 */       this.mainTimerStopper.start();
/*     */     } 
/*     */     
/* 427 */     if (SoloPractice_Settings.endQ != 0) {
/* 428 */       this.timeTimer.start();
/*     */     }
/*     */     
/* 431 */     JLabel lblIfTheQuestion = new JLabel("If the question seems weird,");
/* 432 */     lblIfTheQuestion.setHorizontalAlignment(0);
/* 433 */     lblIfTheQuestion.setFont(new Font("Lucida Grande", 0, 10));
/* 434 */     lblIfTheQuestion.setForeground(Color.GRAY);
/* 435 */     lblIfTheQuestion.setBounds(1288, 602, 139, 18);
/* 436 */     this.contentPane.add(lblIfTheQuestion);
/*     */     
/* 438 */     JLabel lblWeirdPressThe = new JLabel("press the button below:");
/* 439 */     lblWeirdPressThe.setHorizontalAlignment(0);
/* 440 */     lblWeirdPressThe.setForeground(Color.GRAY);
/* 441 */     lblWeirdPressThe.setFont(new Font("Lucida Grande", 0, 10));
/* 442 */     lblWeirdPressThe.setBounds(1288, 618, 139, 18);
/* 443 */     this.contentPane.add(lblWeirdPressThe);
/*     */     
/* 445 */     JButton btnReportQuestion = new JButton("Report Question");
/* 446 */     btnReportQuestion.setBounds(1300, 643, 117, 79);
/* 447 */     this.contentPane.add(btnReportQuestion);
/* 448 */     btnReportQuestion.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/*     */             try {
/* 452 */               if (SoloPractice.this.displayTimer.isRunning()) SoloPractice.this.displayTimer.stop(); 
/* 453 */               SoloPractice.this.roundTimerPaused = true;
/* 454 */               SoloPractice.this.timeTimerPaused = true;
/* 455 */               SoloPractice.this.mainTimerPaused = true;
/* 456 */               SoloPractice.this.buzzerTimerPaused = true;
/*     */               
/* 458 */               String myQuery = "INSERT INTO requests VALUES(default, '" + SoloPractice.this.questionID + "', 'QUESTION FEEDBACK')";
/* 459 */               PreparedStatement updateRequest = DBConnection.con.prepareStatement(myQuery);
/* 460 */               int updateUser_done = updateRequest.executeUpdate();
/* 461 */               Main.infoBox("The admin has been informed! After a brief review, the database will be updated. Thank you for letting us know.", "");
/* 462 */               if (SoloPractice_Settings.timed = true) {
/* 463 */                 SoloPractice.this.miniTime = 7;
/* 464 */                 SoloPractice.this.lblQuestionTime.setText((new StringBuilder(String.valueOf(SoloPractice.this.miniTime))).toString());
/*     */               } 
/* 466 */               SoloPractice.this.i = 0;
/* 467 */               SoloPractice.this.prepare(SoloPractice.this.textArea, SoloPractice.this.answerArrayList);
/* 468 */               SoloPractice.this.generateQuestion(SoloPractice.this.textArea);
/* 469 */             } catch (Exception e6) {
/* 470 */               System.out.println("ERROR: " + e6.getMessage());
/* 471 */               Main.infoBox("Oops, there was an error. ERROR: " + e6.getMessage(), "");
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 476 */     this.btnBuzzer.setBackground(Color.PINK);
/* 477 */     this.btnBuzzer.setBounds(601, 678, 189, 97);
/* 478 */     this.contentPane.add(this.btnBuzzer);
/* 479 */     this.btnBuzzer.addActionListener(new ActionListener()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/* 482 */             SoloPractice.this.buzzed = true;
/* 483 */             SoloPractice.this.miniTime = 15;
/* 484 */             if (SoloPractice.this.displayTimer.isRunning()) SoloPractice.this.displayTimer.stop(); 
/* 485 */             SoloPractice.this.roundTimerPaused = false;
/* 486 */             SoloPractice.this.timeTimerPaused = false;
/* 487 */             SoloPractice.this.mainTimerPaused = false;
/* 488 */             SoloPractice.this.buzzerTimerPaused = false;
/*     */             
/* 490 */             SoloPractice.this.answerField.setEditable(true);
/* 491 */             SoloPractice.this.btnBuzzer.setEnabled(false);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getQuestionNum() {
/*     */     try {
/* 502 */       Statement stmt = DBConnection.con.createStatement();
/* 503 */       int countBooleanTrue = 0;
/*     */       
/* 505 */       String countString = "SELECT COUNT(*) FROM questions WHERE ";
/*     */ 
/*     */       
/* 508 */       if (SoloPractice_Settings.categoryArray[0]) {
/* 509 */         countString = String.valueOf(countString) + "category = 'SCIENCE' OR ";
/*     */       }
/* 511 */       if (SoloPractice_Settings.categoryArray[1]) {
/* 512 */         countString = String.valueOf(countString) + "category = 'MATH' OR ";
/*     */       }
/* 514 */       if (SoloPractice_Settings.categoryArray[2]) {
/* 515 */         countString = String.valueOf(countString) + "category = 'HISTORY' OR ";
/*     */       }
/* 517 */       if (SoloPractice_Settings.categoryArray[3]) {
/* 518 */         countString = String.valueOf(countString) + "category = 'ARTS' OR ";
/*     */       }
/* 520 */       if (SoloPractice_Settings.categoryArray[4]) {
/* 521 */         countString = String.valueOf(countString) + "category = 'LANGUAGE' OR ";
/*     */       }
/* 523 */       if (SoloPractice_Settings.categoryArray[5]) {
/* 524 */         countString = String.valueOf(countString) + "category = 'COMMON' OR ";
/*     */       }
/* 526 */       countString = countString.substring(0, countString.length() - 4);
/* 527 */       System.out.println("countString: " + countString);
/* 528 */       ResultSet rs = stmt.executeQuery(countString);
/*     */       
/* 530 */       while (rs.next()) {
/* 531 */         String questionNumString = rs.getString("COUNT(*)");
/* 532 */         this.questionNum = Integer.parseInt(questionNumString);
/* 533 */         System.out.println("number of questions in database that match requirements:" + this.questionNum);
/*     */       } 
/*     */       
/* 536 */       this.checkDuplicateArray = new boolean[this.questionNum];
/*     */     }
/* 538 */     catch (Exception e) {
/* 539 */       System.out.println("Error Message from getQuestionNum method: " + e.getMessage());
/*     */     } 
/*     */   }
/*     */   public void generateQuestion(JTextArea textArea) {
/* 543 */     this.btnBuzzer.setEnabled(true);
/*     */     
/* 545 */     n = generateNum();
/* 546 */     System.out.println("value of n: " + n);
/*     */     
/* 548 */     this.answerField.setEditable(false);
/* 549 */     this.buzzed = false;
/*     */     
/*     */     try {
/* 552 */       if (this.questionHistoryArrayList.size() == this.questionNum) {
/* 553 */         Main.infoBox("Sorry, there are no more questions left in the database.", "");
/* 554 */         resetEverything();
/*     */       }
/* 556 */       else if (this.questionHistoryArrayList.size() != 0) {
/* 557 */         eliminateDuplicates();
/*     */       } 
/*     */       
/* 560 */       Statement stmt = DBConnection.con.createStatement();
/* 561 */       String whereCommand = "";
/* 562 */       String whereCommand2 = "";
/*     */       
/* 564 */       if (SoloPractice_Settings.categoryArray[0]) {
/* 565 */         whereCommand = "q.category = 'SCIENCE' OR " + whereCommand;
/*     */       }
/* 567 */       if (SoloPractice_Settings.categoryArray[1]) {
/* 568 */         whereCommand = "q.category = 'MATH' OR " + whereCommand;
/*     */       }
/* 570 */       if (SoloPractice_Settings.categoryArray[2]) {
/* 571 */         whereCommand = "q.category = 'HISTORY' OR " + whereCommand;
/*     */       }
/* 573 */       if (SoloPractice_Settings.categoryArray[3]) {
/* 574 */         whereCommand = "q.category = 'ARTS' OR " + whereCommand;
/*     */       }
/* 576 */       if (SoloPractice_Settings.categoryArray[4]) {
/* 577 */         whereCommand = "q.category = 'LANGUAGE' OR " + whereCommand;
/*     */       }
/* 579 */       if (SoloPractice_Settings.categoryArray[5]) {
/* 580 */         whereCommand = "q.category = 'COMMON' OR " + whereCommand;
/*     */       }
/* 582 */       whereCommand = whereCommand.substring(0, whereCommand.length() - 4);
/* 583 */       whereCommand = "SELECT q.id, q.category, q.header, q.content FROM questions q WHERE (" + whereCommand + ") LIMIT " + (n - 1) + ", 1";
/* 584 */       System.out.println("Your where command: " + whereCommand);
/*     */ 
/*     */       
/* 587 */       ResultSet rs2 = stmt.executeQuery(whereCommand);
/* 588 */       while (rs2.next()) {
/*     */         
/* 590 */         this.questionHistoryArrayList.add(Integer.valueOf(n));
/* 591 */         this.checkDuplicateArray[n - 1] = true;
/*     */         
/* 593 */         this.questionID = rs2.getInt("q.id");
/* 594 */         this.questionContent = rs2.getString("q.content");
/* 595 */         this.questionCategory = rs2.getString("q.category");
/* 596 */         this.questionHeader = rs2.getString("q.header");
/*     */         
/* 598 */         textArea.append(String.valueOf(this.questionCategory) + "\n\n");
/* 599 */         textArea.append(String.valueOf(this.questionHeader) + "\n");
/*     */         
/* 601 */         this.questionContent = this.questionContent.replace("^", "\n\n");
/* 602 */         textArea.append("#" + this.questionID + ": ");
/*     */       } 
/*     */       
/* 605 */       this.roundTimerPaused = true;
/* 606 */       this.timeTimerPaused = true;
/* 607 */       this.mainTimerPaused = false;
/* 608 */       this.buzzerTimerPaused = true;
/*     */       
/* 610 */       this.buzzerTimer.start();
/* 611 */       this.displayTimer.start();
/*     */       
/* 613 */       whereCommand2 = "SELECT a.content FROM answers a WHERE a.q_id = '" + this.questionID + "'";
/* 614 */       ResultSet rs3 = stmt.executeQuery(whereCommand2);
/* 615 */       while (rs3.next()) {
/* 616 */         this.answerArrayList.add(rs3.getString("a.content"));
/*     */       }
/* 618 */       for (int i = 0; i < this.answerArrayList.size(); i++) {
/* 619 */         System.out.println("Answer" + (i + 1) + ": " + (String)this.answerArrayList.get(i));
/*     */       }
/* 621 */       this.checkDuplicateCount = 0;
/*     */     
/*     */     }
/* 624 */     catch (Exception e) {
/* 625 */       System.out.println("ERROR GETTING DATA");
/* 626 */       System.out.println(e.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int generateNum() {
/* 632 */     n = this.rand.nextInt(this.questionNum) + 1;
/* 633 */     System.out.println("n: " + n);
/* 634 */     return n;
/*     */   }
/*     */   
/*     */   public void prepare(JTextArea textArea, ArrayList answerArrayList) {
/* 638 */     textArea.setText("");
/* 639 */     answerArrayList.clear();
/* 640 */     this.answerField.setText("");
/* 641 */     this.questionContent = "";
/*     */   }
/*     */   
/*     */   public void eliminateDuplicates() {
/* 645 */     boolean randomize = false;
/*     */     
/* 647 */     if (this.checkDuplicateCount > 1) {
/* 648 */       for (int j = 0; j < this.checkDuplicateArray.length; j++) {
/* 649 */         if (!this.checkDuplicateArray[j]) {
/* 650 */           n = j + 1;
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/* 655 */     for (int i = 0; i < this.questionHistoryArrayList.size(); i++) {
/* 656 */       if (n == ((Integer)this.questionHistoryArrayList.get(i)).intValue()) {
/* 657 */         randomize = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 661 */     if (randomize) {
/* 662 */       this.checkDuplicateCount++;
/* 663 */       generateNum();
/* 664 */       eliminateDuplicates();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void resetEverything() {
/* 669 */     this.timeTookToBuzz /= this.questionsSolved;
/* 670 */     if (this.timeTookToBuzz > 0.0D) {
/* 671 */       System.out.println("timetooktobuzz is greater than 0, it's: " + this.timeTookToBuzz);
/* 672 */       this.timeTookToBuzz *= 100.0D;
/* 673 */       this.timeTookToBuzz = Math.round(this.timeTookToBuzz);
/* 674 */       this.timeTookToBuzz /= 100.0D;
/* 675 */       System.out.println("and now it's: " + this.timeTookToBuzz);
/*     */     } 
/*     */     
/* 678 */     System.out.println("FINAL time took to buzz: " + this.timeTookToBuzz);
/* 679 */     this.buzzerTimer.stop();
/*     */     
/* 681 */     if (SoloPractice_Settings.endT != 0) { JOptionPane.showMessageDialog(null, "# of questions completed: " + this.questionsSolved + "\n# Correct: " + this.correctCount + "\nAverage Time To Buzz: " + this.timeTookToBuzz, "SUMMARY", 1); }
/* 682 */     else if (SoloPractice_Settings.endQ != 0)
/* 683 */     { this.timeTook *= 100.0D;
/* 684 */       this.timeTook = Math.round(this.timeTook);
/* 685 */       this.timeTook /= 100.0D;
/* 686 */       JOptionPane.showMessageDialog(null, "Time took to complete all questions: " + this.timeTook + " seconds \n# Correct: " + this.correctCount + "\nAverage Time To Buzz: " + this.timeTookToBuzz, "SUMMARY", 1); }
/*     */     
/* 688 */     dispose();
/* 689 */     for (int i = 0; i < SoloPractice_Settings.categoryArray.length; i++) {
/* 690 */       SoloPractice_Settings.categoryArray[i] = false;
/*     */     }
/* 692 */     if (SoloPractice_Settings.endT != 0)
/* 693 */       this.mainTimer.stop(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\82109\Downloads\Academic Games Simulator 0.2.2.jar!\database\SoloPractice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */