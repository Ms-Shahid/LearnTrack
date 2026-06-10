package com.airtribe.learntrack.util;
import java.util.UUID;

public class IdGenerator {

    protected static String uuid = UUID.randomUUID().toString();

    public static String getNextStudentId(){
        return UUID.randomUUID().toString();
    }

    public static String getNextCourseId(){
        return UUID.randomUUID().toString();
    }

}
