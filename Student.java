/*    */ package smartSchool;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Stack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Student
/*    */   implements Serializable
/*    */ {
/*    */   private String studentName;
/*    */   private int grade;
/*    */   private String studentType;
/*    */   private Course[] courseList;
/*    */   private Stack desiredList;
/*    */   
/*    */   public String getStudentName() {
/* 20 */     return this.studentName;
/*    */   }
/*    */   
/*    */   public int getGrade() {
/* 24 */     return this.grade;
/*    */   }
/*    */   
/*    */   public String getStudentType() {
/* 28 */     return this.studentType;
/*    */   }
/*    */   
/*    */   public Course[] getCourseList() {
/* 32 */     return this.courseList;
/*    */   }
/*    */   
/*    */   public Stack getDesiredList() {
/* 36 */     return this.desiredList;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setStudentName(String firstName) {
/* 41 */     this.studentName = firstName;
/*    */   }
/*    */   
/*    */   public void setGrade(int grade) {
/* 45 */     this.grade = grade;
/*    */   }
/*    */   
/*    */   public void setStudentType(String studentType) {
/* 49 */     this.studentType = studentType;
/*    */   }
/*    */   
/*    */   public void setCourseList(Course[] courseList) {
/* 53 */     this.courseList = courseList;
/*    */   }
/*    */   
/*    */   public void setDesiredList(Stack desiredList) {
/* 57 */     this.desiredList = desiredList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Student(String studentName, int grade, String studentType, Stack desiredList) {
/* 69 */     this.studentName = studentName;
/* 70 */     this.grade = grade;
/* 71 */     this.studentType = studentType;
/* 72 */     this.desiredList = desiredList;
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Student.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */