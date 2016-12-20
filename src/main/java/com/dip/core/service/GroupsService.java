package com.dip.core.service;

import com.dip.core.dao.GroupsDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юрий on 30.10.2016.
 */
public class GroupsService {

    public List<String> getListOfGroupsByFacName(String facultyName) {
        List<String> groups = new ArrayList<>();
        try (ResultSet resultSet = new GroupsDao().getGroupsByFacId(facultyName);){
            while (resultSet.next()) {
                groups.add(resultSet.getString("GROUP_NAME"));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }
}
