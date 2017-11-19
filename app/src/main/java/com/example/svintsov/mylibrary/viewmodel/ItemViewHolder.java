package com.example.svintsov.mylibrary.viewmodel;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.example.svintsov.mylibrary.databinding.ListItemBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;

/**
 * Created by svintsov on 17.11.17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

  private final ListItemBinding itemBinding;
  ImageView imageView;

  public ItemViewHolder(ListItemBinding binding) {
    super(binding.getRoot());
    itemBinding = binding;
    this.imageView = itemBinding.bookCover;
  }

  public void bind(ExampleModel item) {
    itemBinding.setModel(item);
  }
}