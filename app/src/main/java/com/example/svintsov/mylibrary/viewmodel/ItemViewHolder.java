package com.example.svintsov.mylibrary.viewmodel;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.example.svintsov.mylibrary.databinding.ListItemBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;
import com.example.svintsov.mylibrary.viewmodel.MyListAdapter.Listener;

/**
 * Created by svintsov on 17.11.17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

  private final ListItemBinding itemBinding;
  ImageView imageView;

  public ItemViewHolder(ListItemBinding binding,Listener listener) {
    super(binding.getRoot());
    binding.setListener(listener);
    itemBinding = binding;
    this.imageView = itemBinding.bookCover;
  }

  public void bind(ExampleModel item) {
    itemBinding.setModel(item);
  }
}