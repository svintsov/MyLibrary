package com.example.svintsov.mylibrary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.svintsov.mylibrary.databinding.ActivityFullInfoModelBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;
import com.squareup.picasso.Picasso;

public class FullInfoModelActivity extends AppCompatActivity {

  ActivityFullInfoModelBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_full_info_model);

    ExampleModel model = getIntent().getParcelableExtra("MODEL");

    binding.setModel(model);
    populateCoverFromUrl(model);
  }

  void populateCoverFromUrl(ExampleModel model) {
    if (!model.getBookCoverUrl().equals("")) {
      Picasso.with(this)
          .load(model.getBookCoverUrl())
          .placeholder(R.drawable.default_cover)
          .error(R.drawable.default_cover)
          .into(binding.coverView);
    }
  }

}
