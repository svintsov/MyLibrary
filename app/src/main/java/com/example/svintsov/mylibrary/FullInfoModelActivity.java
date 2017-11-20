package com.example.svintsov.mylibrary;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.svintsov.mylibrary.databinding.ActivityFullInfoModelBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;

public class FullInfoModelActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityFullInfoModelBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_full_info_model);
    binding.setModel((ExampleModel)getIntent().getParcelableExtra("MODEL"));
  }
}
