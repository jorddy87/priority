package com.experta.utils;

import com.experta.entity.Student;
import com.experta.entity.StudentComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

    private PriorityQueue<Student> studentPriorityQueue;
    private static final String ENTER_EVENT = "ENTER";
    private static final String SERVED_EVENT = "SERVED";
    private static final String SPACE_SEPARATOR = "\\s+";


    public List<Student> getStudents(final List<String> events) {
        String[] parts;
        Student student;

        this.studentPriorityQueue = new PriorityQueue<>(new StudentComparator());

        for(final String event :events) {
            parts = event.split(SPACE_SEPARATOR);
            if (ENTER_EVENT.equals(parts[0])) {
                student = parseStudent(parts);
                enqueueStudent(student);
            } else if (SERVED_EVENT.equals(parts[0])) {
                deQueueStudent();
            }
        }

        return queueToList(this.studentPriorityQueue);
    }

    private Student parseStudent(final String[] parts) {
        final String name = parts[1];
        final int id = Integer.valueOf(parts[3]);
        final double cgpa = Double.valueOf(parts[2]);

        return new Student(id, name, cgpa);
    }

    private void enqueueStudent(final Student student) { this.studentPriorityQueue.offer(student); }

    private void deQueueStudent() { this.studentPriorityQueue.poll(); }

    private List<Student> queueToList(final PriorityQueue<Student> studentPriorityQueue) {
        List<Student> studentsList = new ArrayList<>();

        while (!studentPriorityQueue.isEmpty()) {
            studentsList.add(studentPriorityQueue.poll());
        }
        return studentsList;
    }
}
