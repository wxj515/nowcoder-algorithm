/**
 * 比较器
 */
package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ComparatorDemo {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static void printStudents(Student[] students){
        for (Student student : students){
            System.out.println("name:" + student.name + " id:" + student.id + " age:" + student.age);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("a", 1, 8);
        Student student1 = new Student("b", 2, 9);
        Student student2 = new Student("c", 3, 10);

        Student[] students = new Student[]{student2, student1, student};
        printStudents(students);

//        Arrays.sort(students); //对自己定义的对象一定要给个比较器，不然它不知道怎么排
//        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());

        heap.add(student);
        heap.add(student1);
        heap.add(student2);

        while (!heap.isEmpty()){
            Student s = heap.poll();
            System.out.println("name:" + s.name + " id:" + s.id + " age:" + s.age);
        }

        TreeSet<Student> treeSet = new TreeSet<>(new IdAscendingComparator());
    }
}
