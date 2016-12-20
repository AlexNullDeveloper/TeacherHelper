package com.dip.core.service;

import com.dip.core.dao.FacultiesDao;
import com.dip.core.dao.TeachersDao;
import com.dip.core.pojos.Faculty;
import com.dip.core.pojos.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultiesService {

    public List<Faculty> getListOfFaculties() {
        List<Faculty> faculties = new ArrayList<>();

        ResultSet facultiesResultSet = new FacultiesDao().getFaculties();
        try {
            while (facultiesResultSet.next()) {
                addFacultyInList(faculties, facultiesResultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (facultiesResultSet != null) {
                    facultiesResultSet.close();
                }
            } catch (SQLException e) {
            }
            return faculties;
        }
    }

    private void addFacultyInList(List<Faculty> faculties, ResultSet agreedTeachers) throws SQLException {

        String vuz = agreedTeachers.getString("VUZ");
        String name = agreedTeachers.getString("NAME");
        faculties.add(new Faculty(vuz, name));
    }
}
