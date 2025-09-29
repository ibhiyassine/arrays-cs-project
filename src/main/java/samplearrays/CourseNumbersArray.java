package samplearrays;


// the class CourseNumbersArray manages a list of course numbers that a student is registered in.
// One of the tasks is to add a new course, it copies the elements from registeredCourses into a new, larger array updatedCourses,
// and adds the course to this new array.
// From my understanding the method add new course creates a new list and not recycle the registeredCourses variable
// but rather create a new one and work with it.
public class CourseNumbersArray {
    public static int[] addCourse(int[] registeredCourses, int newCourse) {
        int[] updatedCourses = new int[registeredCourses.length + 1];
        for(int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[registeredCourses.length] = newCourse;
        return updatedCourses;
    }  

    public static void printCourses(int[] enrolledCourses) {
        for(int i = 0; i < enrolledCourses.length; i++) {
            System.out.println(enrolledCourses[i]);
        }
        return;
    }

    public static boolean checkCourse(int[] enrolledCourses, int course) {
        for(int i = 0; i < enrolledCourses.length; i++) {
            if(course == enrolledCourses[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        int[] updatedCourses = addCourse(registeredCourses, 5345);
        printCourses(updatedCourses);

        System.out.println(checkCourse(updatedCourses, 2140)); // returns true;
        System.out.println(checkCourse(updatedCourses, 1111)); // return false;
        
    }
}
