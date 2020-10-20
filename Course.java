/*    */ package smartSchool;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Stack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Course
/*    */   implements Serializable
/*    */ {
/*    */   private String courseName;
/*    */   private String courseType;
/*    */   private int workload;
/*    */   private Stack teacherList;
/*    */   private int minCapacity;
/*    */   private int maxCapacity;
/*    */   private int studentNum;
/*    */   private int courseNum;
/*    */   
/*    */   public Course(String courseName, String courseType) {
/* 23 */     this.courseName = courseName;
/* 24 */     this.courseType = courseType;
/*    */   }
/*    */ 
/*    */   
/*    */   public Course(String courseName, String courseType, int workload, Stack teacherList, int minCapacity, int maxCapacity) {
/* 29 */     this.courseName = courseName;
/* 30 */     this.courseType = courseType;
/* 31 */     this.workload = workload;
/* 32 */     this.teacherList = teacherList;
/* 33 */     this.minCapacity = minCapacity;
/* 34 */     this.maxCapacity = maxCapacity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCourseName() {
/* 39 */     return this.courseName;
/*    */   }
/*    */   public String getCourseType() {
/* 42 */     return this.courseType;
/*    */   }
/*    */   public int getWorkload() {
/* 45 */     return this.workload;
/*    */   }
/*    */   public Stack getTeacherList() {
/* 48 */     return this.teacherList;
/*    */   }
/*    */   public int getMinCapacity() {
/* 51 */     return this.minCapacity;
/*    */   }
/*    */   public int getMaxCapacity() {
/* 54 */     return this.maxCapacity;
/*    */   }
/*    */   public int getStudentNum() {
/* 57 */     return this.studentNum;
/*    */   }
/*    */   public int getCourseNum() {
/* 60 */     return this.courseNum;
/*    */   }
/*    */   
/*    */   public void setCourseName(String courseName) {
/* 64 */     this.courseName = courseName;
/*    */   }
/*    */   public void setCourseType(String courseType) {
/* 67 */     this.courseType = courseType;
/*    */   }
/*    */   public void setWorkload(int workload) {
/* 70 */     this.workload = workload;
/*    */   }
/*    */   public void setTeacherList(Stack teacherList) {
/* 73 */     this.teacherList = teacherList;
/*    */   }
/*    */   public void setMinCapacity(int minCapacity) {
/* 76 */     this.minCapacity = minCapacity;
/*    */   }
/*    */   public void setMaxCapacity(int maxCapacity) {
/* 79 */     this.maxCapacity = maxCapacity;
/*    */   }
/*    */   public void setStudentNum(int studentNum) {
/* 82 */     this.studentNum = studentNum;
/*    */   }
/*    */   public void setCourseNum(int courseNum) {
/* 85 */     this.courseNum = courseNum;
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Course.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */