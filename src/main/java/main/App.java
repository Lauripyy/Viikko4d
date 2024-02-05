package main;

import java.io.Serializable;
import java.util.Scanner;

public class App implements Serializable{
    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
    
        boolean exit = false;
        University university = new University(sc);

        while(!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        university.addStudent();
                        break;
                    case 2:
                        System.out.println("Opiskelijat:");
                        university.listStudents();
                        break;
                    case 3:
                        university.listStudentsId();
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        String idString = sc.nextLine();
                        int id = Integer.parseInt(idString);
                        university.addGradeToStudent(id);
                        
                        break;
                    case 4:
                        university.listStudentsId();
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        String idString2 = sc.nextLine();
                        int id2 = Integer.parseInt(idString2);
                        university.listGrades(id2);
                        break;


                    case 5:
                        Calculator calculator = new Calculator(sc);
                        university.listStudentsId();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        String idString3 = sc.nextLine();
                        int id3 = Integer.parseInt(idString3);
                        university.getAverageGrade(id3);
                        break;
                    case 6:
                        
                        break;
                    case 7:
                        university.saveStudents();
                        break;
                    case 8:
                        university.loadStudents();
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;

                }
            }

        }
    sc.close();

    }
}
