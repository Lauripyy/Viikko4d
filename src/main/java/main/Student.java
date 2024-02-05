package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Student implements Serializable {
    private transient Scanner sc;
    private String studentName;
    private int studentNumber;
    private ArrayList<Grade> grades = new ArrayList<>(); 
    Grade newGrade = null;

    public Student(Scanner sc,String studentName, int studentNumber) {
        this.sc=sc;
        this.studentName= studentName;
        this.studentNumber=studentNumber;
    }
    public String getName(){
        return studentName;
    }
    
    public int getNumber(){
        return studentNumber;
    }

    public void addGrade(){
        System.out.println("Mille kurssille suorite lisätään?");
        String courseName = sc.nextLine();
        System.out.println("Mikä arvosana kurssille lisätään?");
        String courseGradeString = sc.nextLine();
        int courseGrade = Integer.parseInt(courseGradeString);

        newGrade = new Grade(courseName,courseGrade);
        grades.add(newGrade);


    
    
    }
    
    public void printGrades() {
        for(Grade grade: grades){
            System.out.println(grade.getCourseName() + ": " + grade.getCourseGrade());

        }
    }
    
    public double calculateAverage(){
        double sum=0;
        int gradeValue;
        int i=0;
        double average=0;
        for (Grade grade: grades){
            gradeValue=grade.getCourseGrade();
            sum+=gradeValue;
            i++;

        }
        average=sum/i;
        return average;
    }
       
    
    
}
