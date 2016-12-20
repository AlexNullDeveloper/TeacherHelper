package com.dip.core.pojos;

import java.util.List;

public class ResponseModel {
    private List<String> Groups;
    private String url;
    private String previousFaculty;

    public ResponseModel(List<String> groups, String url, String previousFaculty) {
        Groups = groups;
        this.url = url;
        this.previousFaculty = previousFaculty;
    }

    public List<String> getGroups() {
        return Groups;
    }

    public String getUrl() {
        return url;
    }

    public String getPreviousFaculty() {
        return previousFaculty;
    }
}
