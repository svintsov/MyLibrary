package com.example.svintsov.mylibrary.viewmodel;

import android.support.v7.widget.RecyclerView;

import com.example.svintsov.mylibrary.databinding.ListItemBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;

/**
 * Created by svintsov on 17.11.17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final ListItemBinding itemBinding;

    public ItemViewHolder(ListItemBinding binding) {
        super(binding.getRoot());
        itemBinding = binding;
    }

    public void bind(ExampleModel item) {
        itemBinding.setModel(item);
    }
}