/*    */ package smartSchool;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Main_Schedule
/*    */   implements Serializable
/*    */ {
/*    */   Course[][] scheduleTable;
/*    */   ArrayList<Student> studentList;
/*    */   ArrayList<Teacher> teacherList;
/*    */   ArrayList<Course> courseList;
/*    */   private String serialNum;
/*    */   
/*    */   public String getSerialNum() {
/* 19 */     return this.serialNum;
/*    */   }
/*    */   public void setSerialNum(String serialNum) {
/* 22 */     this.serialNum = serialNum;
/*    */   }
/*    */   
/*    */   public Course[][] getScheduleTable() {
/* 26 */     return this.scheduleTable;
/*    */   }
/*    */   public ArrayList<Student> getStudentList() {
/* 29 */     return this.studentList;
/*    */   }
/*    */   public ArrayList<Teacher> getTeacherList() {
/* 32 */     return this.teacherList;
/*    */   }
/*    */   public ArrayList<Course> getCourseList() {
/* 35 */     return this.courseList;
/*    */   }
/*    */   public void setScheduleTable(Course[][] scheduleTable) {
/* 38 */     this.scheduleTable = scheduleTable;
/*    */   }
/*    */   public void setStudentList(ArrayList<Student> studentList) {
/* 41 */     this.studentList = studentList;
/*    */   }
/*    */   public void setTeacherList(ArrayList<Teacher> teacherList) {
/* 44 */     this.teacherList = teacherList;
/*    */   }
/*    */   public void setCourseList(ArrayList<Course> courseList) {
/* 47 */     this.courseList = courseList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Main_Schedule(ArrayList<Student> studentList, ArrayList<Teacher> teacherList, ArrayList<Course> courseList) {
/* 58 */     this.studentList = studentList;
/* 59 */     this.teacherList = teacherList;
/* 60 */     this.courseList = courseList;
/*    */   }
/*    */ }


/* Location:              C:\Users\82109\Downloads\SmartScheduler.jar!\smartSchool\Main_Schedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */