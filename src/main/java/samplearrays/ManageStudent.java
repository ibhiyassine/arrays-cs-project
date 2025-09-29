package samplearrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {

        if(Student.getNumStudent() == 0) return null;
        Student oldest = students[0];
        for(int i = 1; i < Student.getNumStudent(); i++) {
            if(students[i].getAge() > oldest.getAge()) oldest = students[i];
        }

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(Student s : students) {
            if(s.getAge() >= 18) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if(Student.getNumStudent() == 0) return Double.NaN;
        double average = 0.0;
        int n = Student.getNumStudent();
        for(Student s : students) {
            average += (s.getGrade() / n);
        }
        return average;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        if(Student.getNumStudent() == 0) return null;
        for(Student s : students) {
            if(s.getName().equals(name)) return s;
        }
        return null;

    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparingInt(s -> -s.getGrade()));

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        if(Student.getNumStudent() == 0) return;
        for(Student s : students) {
            if(s.getGrade() >= 15) s.toString();
        }
        return;
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        if(Student.getNumStudent() == 0) return false;
        for(Student s : students) {
            if(s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            } 
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
       // For this it is better to use a set in java to store the already used names 
        if(Student.getNumStudent() == 0) return false;
        Set<String> used_names = new HashSet<String>();
        for(Student s : students) {
            if(used_names.contains(s.getName()) ) {
                System.out.println("Duplicates found");
                return true;
            }
            used_names.add(s.getName());
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        int n = students.length;
        Student[] newArr = new Student[n + 1];
        for(int i = 0; i < n; i++) {
            newArr[i] = students[i];
        }
        newArr[n] = newStudent;
        return newArr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "yassine", 20, 15);
        arr[1] = new Student(2, "yasser", 18, 15);
        arr[2] = new Student(3, "ilyas", 16, 17);
        arr[3] = new Student(4, "said", 63, 16);
        arr[4] = new Student(5, "saida", 55, 18);


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        ManageStudent.findOldest(arr).toString();

        // 3) Count adults
        System.out.println(ManageStudent.countAdults(arr));


        // 4) Average grade
        System.out.println(ManageStudent.averageGrade(arr));


        // 5) Find by name
        System.out.println("Searching for yassine: " + ManageStudent.findStudentByName(arr, "yassine")); // return true;
        System.out.println("Searching for yassine: " + ManageStudent.findStudentByName(arr, "aya")); // return false;


        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        boolean updated = ManageStudent.updateGrade(arr, 4, 19);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        ManageStudent.hasDuplicateNames(arr);


        // 10) Append new student
        System.out.println("Before appending a student: ");
        for(Student s : arr) s.toString();
        System.out.println("After appending a student: ");
        arr = ManageStudent.appendStudent(arr, new Student(7, "Dina", 12, 18));
        for(Student s : arr) s.toString();

    }
}

