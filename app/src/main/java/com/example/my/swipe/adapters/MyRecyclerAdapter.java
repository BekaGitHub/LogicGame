package com.example.my.swipe.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.my.swipe.R;
import com.example.my.swipe.model.LevelModel;
import com.example.my.swipe.utils.Preferences;
import java.util.List;

/**
 * Created by EmpaT on 30.12.2016.
 */

/**
 * imistavis rom gavaketot recycleview-s adapteri, sachiroa
 * es adapter extends aketebdes RecyclerView.Adapter.
 * RecyclerView.Adapter moitxovs rom mas argumentad gadaeces
 * ViewHolder. amitom jer gavaketot ViewHolder-innerclass(MyViewHolder), romelic
 * extends aketebs ReceyclerView.ViewHolder-is da
 * es clasi gadavcet RecyclerView.Adapter-s
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

  private List<LevelModel> list;
  private Context context;

  public MyRecyclerAdapter(Context context, List<LevelModel> list) {
    this.list = list;
    this.context = context;
  }

  /**
   * am metodshi iqmneba, layout, anu inflate(recycler_item_view),
   * da es sheqmnili objekti unda gadavcet viewholders
   */
  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recycler_item_view, parent, false);
    MyViewHolder myViewHolder = new MyViewHolder(view); //dagavecit itemView
    return myViewHolder; //dababruneb ViewHolder
  }

  /**
   * am metodshi vigeb onCreateViewHolder/dan dabrunebul
   * ViewHolders.  Da vaxden ViewHolderis memberebis initialisatias
   */
  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.levelNameTextView.setText(list.get(position).getLevelName());
    holder.imageView.setImageResource(list.get(position).getImage());

    int brais = list.get(position).getBrains();
    String text = context.getString(R.string.level_brains, "" + brais);
    holder.levelBrainsTextView.setText(text);

  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder implements
      View.OnClickListener {

    TextView levelNameTextView;
    ImageView imageView;
    TextView levelBrainsTextView;

    /**
     * ViewHolders aucilebelia rom hqondes Konstruktori,
     * Konstruktorshi xdeba view-ebis amogeba anu ViewHolders gadmoecema itemView
     * itemView aris layout titoeuli elementis da aq xdeba objeqtis anu
     * itemviews gadmocema
     */
    public MyViewHolder(View itemView) {
      super(itemView);

      levelNameTextView = (TextView) itemView.findViewById(R.id.level_name);
      imageView = (ImageView) itemView.findViewById(R.id.level_icon);
      levelBrainsTextView = (TextView) itemView.findViewById(R.id.level_brain_counter);
      itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
      int itemPosition = getAdapterPosition();
      Intent intent = new Intent(context,
          Preferences.INFO_ACTIVITIES[itemPosition]);
      Bundle defaultBundle = new Bundle();
      defaultBundle.putInt(Preferences.LEVEL,
          1 + itemPosition);
      defaultBundle.putInt(Preferences.EXERCISE,
          Preferences.EXERCISE_COUNTER);
      intent.putExtra(Preferences.BUNDLE, defaultBundle);
      context.startActivity(intent);
    }
  }
}
