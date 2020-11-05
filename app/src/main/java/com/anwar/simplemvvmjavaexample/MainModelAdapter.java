package com.anwar.simplemvvmjavaexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainModelAdapter extends RecyclerView.Adapter<MainModelAdapter.MainViewHolder> {

    Context mCtx;
    List<MainModel> mainModelList;

    public MainModelAdapter(Context mCtx, List<MainModel> mainModelList) {
        this.mCtx = mCtx;
        this.mainModelList = mainModelList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (mCtx).inflate (R.layout.recyclerview_layout, parent, false);
        return new MainViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainModel mainModel = mainModelList.get (position);

        Glide.with (mCtx)
                .load (mainModel.getImage_url ())
                .into (holder.imageView);

        holder.textView.setText (mainModel.getName ());
    }

    @Override
    public int getItemCount() {
        return mainModelList.size ();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MainViewHolder(View itemView) {
            super (itemView);

            imageView = itemView.findViewById (R.id.imageView);
            textView = itemView.findViewById (R.id.textView);
        }
    }
}
