package com.dip.core.service;

import com.dip.core.dao.TeachersDao;
import com.dip.core.pojos.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юрий on 30.10.2016.
 */
public class TeachersService {

    public void setTeacherAgreed(String phone) {
        new TeachersDao().updateTeacherAgreedStatus(phone);
    }

    public List<Teacher> getListOfAgreedTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (ResultSet agreedTeachers = new TeachersDao().getAgreedTeachers();) {
            while (agreedTeachers.next()) {
                addTeacherInList(teachers, agreedTeachers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public List<Teacher> getListOfNotAgreedTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (ResultSet notAgreedTeachers = new TeachersDao().getNotAgreedTeachers();) {
            while (notAgreedTeachers.next()) {
                addTeacherInList(teachers, notAgreedTeachers);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    private void addTeacherInList(List<Teacher> teachers, ResultSet agreedTeachers) throws SQLException {
        String familyName = agreedTeachers.getString("F_NAME");
        String firstName = agreedTeachers.getString("I_NAME");
        String secondName = agreedTeachers.getString("O_NAME");
        String phone = agreedTeachers.getString("PHONE");
        teachers.add(new Teacher(familyName, firstName, secondName, phone));
    }
}
