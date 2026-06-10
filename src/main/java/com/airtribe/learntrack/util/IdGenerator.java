package com.airtribe.learntrack.util;
import java.util.UUID;

public class IdGenerator {

    private static int studentCounter = 0;
    private static int courseCounter = 0;
    private static int enrolmentCounter = 0;

    public static String getNextStudentId(){
        return "STU-" + (++studentCounter);
    }

    public static String getNextCourseId(){
        return "CRS-" + (++courseCounter);
    }

    public static String getNextEnrollmentId(){
        return "ENR-" + (++enrolmentCounter);
    }

}
