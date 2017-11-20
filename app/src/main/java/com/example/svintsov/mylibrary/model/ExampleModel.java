package com.example.svintsov.mylibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by svintsov on 17.11.17.
 */

public class ExampleModel implements Parcelable {

  private int id;
  private String bookTitle;
  private String bookCoverUrl;

  public ExampleModel(int id, String bookTitle, String bookCoverUrl) {
    this.id=id;
    this.bookTitle = bookTitle;
    this.bookCoverUrl = bookCoverUrl;

  }

  protected ExampleModel(Parcel in) {
    id=in.readInt();
    bookTitle = in.readString();
    bookCoverUrl = in.readString();
  }

  public static final Creator<ExampleModel> CREATOR = new Creator<ExampleModel>() {
    @Override
    public ExampleModel createFromParcel(Parcel in) {
      return new ExampleModel(in);
    }

    @Override
    public ExampleModel[] newArray(int size) {
      return new ExampleModel[size];
    }
  };

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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(id);
    parcel.writeString(bookTitle);
    parcel.writeString(bookCoverUrl);
  }
}
