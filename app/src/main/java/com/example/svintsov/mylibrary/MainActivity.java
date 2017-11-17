package com.example.svintsov.mylibrary;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.svintsov.mylibrary.databinding.ActivityMainBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;
import com.example.svintsov.mylibrary.viewmodel.MyListAdapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private static final String[] BOOKS = new String[]{
            "HP1","HP2","HP3","HP4","HP5","HP6","HP7"
    };
    private static final Comparator<ExampleModel> ALPHABETICAL_COMPARATOR = new Comparator<ExampleModel>() {
        @Override
        public int compare(ExampleModel a, ExampleModel b) {
            return a.getText().compareTo(b.getText());
        }
    };
    private MyListAdapter mAdapter;
    private List<ExampleModel> mModels;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new MyListAdapter(this, ALPHABETICAL_COMPARATOR);

        //setSupportActionBar(mBinding.toolBar);

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(mAdapter);

        mModels = new ArrayList<>();
        for (String movie : BOOKS) {
            mModels.add(new ExampleModel(55,movie));
        }
        mAdapter.add(mModels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }


    public boolean onQueryTextChange(String query) {
        final List<ExampleModel> filteredModelList = filter(mModels, query);
        mAdapter.replaceAll(filteredModelList);
        mBinding.recyclerView.scrollToPosition(0);
        return true;
    }

    private static List<ExampleModel> filter(List<ExampleModel> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<ExampleModel> filteredModelList = new ArrayList<>();
        for (ExampleModel model : models) {
            final String text = model.getText().toLowerCase();
            if (text.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
}
