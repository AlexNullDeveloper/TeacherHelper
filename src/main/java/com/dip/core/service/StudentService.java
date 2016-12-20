package com.dip.core.service;

import com.dip.core.dao.StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<String> getStudentListByName(String groupName) {
        List<String> students = new ArrayList<>();

        ResultSet resultSet = new StudentDao().getStudentsByGroup(groupName);
        try {
            while (resultSet.next()) {
                students.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
