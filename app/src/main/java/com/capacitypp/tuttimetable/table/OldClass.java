package com.capacitypp.tuttimetable.table;

public class OldClass {
    private String title;
    private String teacher;
    private String place;

    public OldClass() {
        title = "";
        teacher = "";
        place = "";
    }

    public OldClass(String title, String teacher, String place) {
        this.title = title;
        this.teacher = teacher;
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
