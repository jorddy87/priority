package com.experta.entity;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() == s2.getCgpa()) {
            if (s1.getName().equals(s2.getName())) {
                return Integer.compare(s1.getId(), s2.getId());
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        } else {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
    }
}
