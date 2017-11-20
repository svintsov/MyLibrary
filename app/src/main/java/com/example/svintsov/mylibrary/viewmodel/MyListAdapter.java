package com.example.svintsov.mylibrary.viewmodel;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.svintsov.mylibrary.R;
import com.example.svintsov.mylibrary.databinding.ListItemBinding;
import com.example.svintsov.mylibrary.model.ExampleModel;
import com.squareup.picasso.Picasso;
import java.util.Comparator;
import java.util.List;

/**
 * Created by svintsov on 17.11.17.
 */

public class MyListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

  private final SortedList<ExampleModel> mSortedList = new SortedList<>(ExampleModel.class,
      new SortedList.Callback<ExampleModel>() {
        @Override
        public int compare(ExampleModel a, ExampleModel b) {
          return mComparator.compare(a, b);
        }

        @Override
        public void onInserted(int position, int count) {
          notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
          notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
          notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
          notifyItemRangeChanged(position, count);
        }

        @Override
        public boolean areContentsTheSame(ExampleModel oldItem, ExampleModel newItem) {
          return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(ExampleModel item1, ExampleModel item2) {
          return item1.getId() == item2.getId();
        }
      });

  private final LayoutInflater mInflater;
  private final Comparator<ExampleModel> mComparator;
  private final Context context;
  private final Listener mListener;

  public interface Listener {
    void onExampleModelClicked(ExampleModel model);
  }

  public MyListAdapter(Context context, Comparator<ExampleModel> comparator, Listener listener) {
    mInflater = LayoutInflater.from(context);
    mComparator = comparator;
    mListener=listener;
    this.context = context;
  }

  @Override
  public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final ListItemBinding binding = ListItemBinding.inflate(mInflater, parent, false);
    return new ItemViewHolder(binding,mListener);
  }

  @Override
  public void onBindViewHolder(ItemViewHolder holder, int position) {
    final ExampleModel model = mSortedList.get(position);
    holder.bind(model);
    populateBookCoversFromURL(holder,model);
  }

  @Override
  public int getItemCount() {
    return mSortedList.size();
  }

  void populateBookCoversFromURL(final ItemViewHolder holder, final ExampleModel model){
    if (!model.getBookCoverUrl().equals("")) {
      Picasso.with(context)
          .load(model.getBookCoverUrl())
          .placeholder(R.drawable.default_cover)
          .error(R.drawable.default_cover)
          .into(holder.imageView);
    }
  }

  public void add(ExampleModel model) {
    mSortedList.add(model);
  }

  public void remove(ExampleModel model) {
    mSortedList.remove(model);
  }

  public void add(List<ExampleModel> models) {
    mSortedList.addAll(models);
  }

  public void remove(List<ExampleModel> models) {
    mSortedList.beginBatchedUpdates();
    for (ExampleModel model : models) {
      mSortedList.remove(model);
    }
    mSortedList.endBatchedUpdates();
  }

  public void replaceAll(List<ExampleModel> models) {
    mSortedList.beginBatchedUpdates();
    for (int i = mSortedList.size() - 1; i >= 0; i--) {
      final ExampleModel model = mSortedList.get(i);
      if (!models.contains(model)) {
        mSortedList.remove(model);
      }
    }
    mSortedList.addAll(models);
    mSortedList.endBatchedUpdates();
  }
}

