package com.example.svintsov.mylibrary.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by svintsov on 17.11.17.
 */

public class ExampleModel implements Parcelable {

  private int id;
  private String bookTitle;
  private String bookAuthor;
  private String bookPublisher;
  private String yearOfPublishing;
  private String bookCoverUrl;
  private Boolean available;

  private ExampleModel() {
  }

  protected ExampleModel(Parcel in) {
    id = in.readInt();
    bookTitle = in.readString();
    bookCoverUrl = in.readString();
    bookAuthor = in.readString();
    bookPublisher = in.readString();
    yearOfPublishing = in.readString();
    available = Boolean.valueOf(in.readString());
  }

  public static Builder newBuilder() {
    return new ExampleModel().new Builder();
  }

  public class Builder {

    private Builder() {
    }

    public Builder setID(int id) {
      ExampleModel.this.id = id;
      return this;
    }

    public Builder setBookTitle(String bookTitle) {
      ExampleModel.this.bookTitle = bookTitle;
      return this;
    }

    public Builder setBookAuthor(String bookAuthor) {
      ExampleModel.this.bookAuthor = bookAuthor;
      return this;
    }

    public Builder setBookPublisher(String bookPublisher) {
      ExampleModel.this.bookPublisher = bookPublisher;
      return this;
    }

    public Builder setBookCoverUrl(String bookCoverUrl) {
      ExampleModel.this.bookCoverUrl = bookCoverUrl;
      return this;
    }

    public Builder setYearOfPublishing(String yearOfPublishing) {
      ExampleModel.this.yearOfPublishing = yearOfPublishing;
      return this;
    }

    public Builder setAvailable(Boolean available) {
      ExampleModel.this.available = available;
      return this;
    }

    public ExampleModel build() {
      return ExampleModel.this;
    }
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

  public String getBookAuthor() {
    return bookAuthor;
  }

  public String getBookPublisher() {
    return bookPublisher;
  }

  public String getYearOfPublishing() {
    return yearOfPublishing;
  }

  public Boolean isAvailable() {
    return available;
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
  public String toString() {
    return
        "id=" + id +
            "\n" + bookTitle +
            "\nby " + bookAuthor +
            "\nPublisher:\n" + bookPublisher +
            "\n(" + yearOfPublishing+")";
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
    parcel.writeString(bookAuthor);
    parcel.writeString(bookPublisher);
    parcel.writeString(yearOfPublishing);
    parcel.writeString(String.valueOf(available));
  }
}
