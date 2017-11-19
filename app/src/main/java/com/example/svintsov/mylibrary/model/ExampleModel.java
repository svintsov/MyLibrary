package com.example.svintsov.mylibrary.model;

/**
 * Created by svintsov on 17.11.17.
 */

public class ExampleModel {

  private static int id = 0;
  private String bookTitle;
  private String bookCoverUrl;

  public ExampleModel(String bookTitle, String bookCoverUrl) {
    this.bookTitle = bookTitle;
    this.bookCoverUrl = bookCoverUrl;
    id++;
  }

  public int getId() {
    return id;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public String getBookCoverUrl() {
    return bookCoverUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ExampleModel that = (ExampleModel) o;

    if (id != that.id) {
      return false;
    }
    return bookTitle.equals(that.bookTitle);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + bookTitle.hashCode();
    return result;
  }
}
