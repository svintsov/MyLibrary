package com.example.svintsov.mylibrary;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.svintsov.mylibrary.databinding.ActivityFullInfoModelBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;
import com.squareup.picasso.Picasso;

public class FullInfoModelActivity extends AppCompatActivity {

  ActivityFullInfoModelBinding binding;
  FloatingActionButton fab;
  ExampleModel model;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_full_info_model);

    model = getIntent().getParcelableExtra("MODEL");

    binding.setModel(model);
    populateCoverFromUrl(model);

    fab = findViewById(R.id.floatingActionButton);

    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, model.toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
      }
    });
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
