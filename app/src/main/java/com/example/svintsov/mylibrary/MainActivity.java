package com.example.svintsov.mylibrary;

import android.content.Intent;
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
import com.example.svintsov.mylibrary.viewmodel.MyListAdapter.Listener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

  private static final Comparator<ExampleModel> ALPHABETICAL_COMPARATOR = new Comparator<ExampleModel>() {
    @Override
    public int compare(ExampleModel a, ExampleModel b) {
      return a.getBookTitle().compareTo(b.getBookTitle());
    }
  };
  private MyListAdapter mAdapter;
  private List<ExampleModel> mModels;
  private ActivityMainBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    mAdapter = new MyListAdapter(this, ALPHABETICAL_COMPARATOR, new Listener() {
      @Override
      public void onExampleModelClicked(ExampleModel model) {
        //Toast.makeText(getApplicationContext(),model.getBookTitle(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), FullInfoModelActivity.class);
        intent.putExtra("MODEL", model);
        startActivity(intent);
      }
    });

    mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    mBinding.recyclerView.setAdapter(mAdapter);

    populateModelStorage();
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
      final String text = model.getBookTitle().toLowerCase();
      if (text.contains(lowerCaseQuery)) {
        filteredModelList.add(model);
      }
    }
    return filteredModelList;
  }

  public boolean onQueryTextSubmit(String query) {
    return false;
  }

  private void populateModelStorage() {
    ExampleModel[] BOOKS = new ExampleModel[]{
        ExampleModel.newBuilder()
            .setID(1)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 1")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl("http://s3.thingpic.com/images/UW/3ZiTHB6N1VYToynxJvG1N5uX.jpeg")
            .setYearOfPublishing("1999")
            .setAvailable(true).build(),
        ExampleModel.newBuilder()
            .setID(2)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 2")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl(
                "http://harrypotterfanzone.com/wp-content/2009/06/cos-us-jacket-art.jpg")
            .setYearOfPublishing("2001")
            .setAvailable(true)
            .build(),
        ExampleModel.newBuilder()
            .setID(3)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 3")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl("empty")
            .setYearOfPublishing("2002")
            .setAvailable(true)
            .build(),
        ExampleModel.newBuilder()
            .setID(4)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 4")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl("empty")
            .setYearOfPublishing("2003")
            .setAvailable(false)
            .build(),
        ExampleModel.newBuilder()
            .setID(5)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 5")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl("empty")
            .setYearOfPublishing("2004")
            .setAvailable(false)
            .build(),
        ExampleModel.newBuilder()
            .setID(6)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 6")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl("empty")
            .setYearOfPublishing("2005")
            .setAvailable(true)
            .build(),
        ExampleModel.newBuilder()
            .setID(7)
            .setBookAuthor("J.K.Rowling")
            .setBookTitle("Harry Potter 7")
            .setBookPublisher("GenesisBooks")
            .setBookCoverUrl("empty")
            .setYearOfPublishing("2006")
            .setAvailable(true)
            .build()
    };

    mModels = new ArrayList<>(Arrays.asList(BOOKS));
    mAdapter.add(mModels);
  }
}
