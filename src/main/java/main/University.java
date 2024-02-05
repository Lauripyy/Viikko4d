package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class University implements Serializable {
    private transient Scanner sc;
    final private String FILENAME;
    ArrayList<Student> students = new ArrayList<>();
    Student newStudent = null;
    


    public University(Scanner sc){
        this.sc=sc;
        FILENAME = "students.data";
    }

    public void addStudent(){
        System.out.println("Anna opiskelijan nimi?");
        String studentName = sc.nextLine();
        System.out.println("Anna opiskelijan opiskelijanumero:");
        String studentNumberString = sc.nextLine();
        int studentNumber = Integer.parseInt(studentNumberString);

        newStudent = new Student(sc,studentName,studentNumber);
        students.add(newStudent);

    }

    public void listStudents(){
        
            
        for (Student student : students) {
            System.out.println(student.getNumber()+": "+student.getName());
        }
        

        
    }
    public void listStudentsId(){
        int i = 0;
            
        for (Student student : students) {
            System.out.println(i++ +": "+student.getName());
        }
    }  
    public Student findStudentById(int id){
        if (id >= 0 && id < students.size()) {
            return students.get(id);
        } else {
            return null;
        }
    }

    public void addGradeToStudent(int id){
        Student student = findStudentById(id);
        if (student != null){
            student.addGrade();
        } else {
            System.out.println("Ei löytynyt.");
        }
    }
    public void listGrades(int id){
        Student student = findStudentById(id);
        if (student != null){
        student.printGrades();
        } else {
        System.out.println("Ei löytynyt.");
    }
    }
    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
            
        } catch (IOException e) {
            System.out.println("Oppilaiden tallentaminen ei onnistunut");
            e.printStackTrace();
        }
    }
   
    public void loadStudents() {
        try {
            ObjectInputStream studentReader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentReader.readObject();
            studentReader.close();
        } catch (IOException e) {
            System.out.println("Ei onnistu.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Ei onnistu.");
            e.printStackTrace();
        }
    }
    public void getAverageGrade(int id){
        double average;
        Student student = findStudentById(id);
        if (student != null){
        average=student.calculateAverage();

        if (Double.isNaN(average)){
            System.out.println("Keskiarvo on 0.0");
        } else {
            System.out.println("Keskiarvo on "+ average);
        }
    } 

    }
}

