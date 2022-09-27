package com.accepted.beforeceleb.Main;

public class ListItem {
    String title;
    String date;
    String explain;
    String phone;
    String address;
    int[] images;

    public ListItem(String title, String date, String explain, String phone, String address, int[] images) {
        this.title = title;
        this.date = date;
        this.explain = explain;
        this.phone = phone;
        this.address = address;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
