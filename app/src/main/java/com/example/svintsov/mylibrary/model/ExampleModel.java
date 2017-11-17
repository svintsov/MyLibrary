package com.example.svintsov.mylibrary.model;

/**
 * Created by svintsov on 17.11.17.
 */

public class ExampleModel {

    private final int id;
    private String text;

    public ExampleModel(int id, String text) {
        this.text=text;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleModel that = (ExampleModel) o;

        if (id != that.id) return false;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + text.hashCode();
        return result;
    }
}
