package com.omellete.githublist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.ArrayList;

public class ListCharAdapter extends RecyclerView.Adapter<ListCharAdapter.ListViewHolder> {

    private ArrayList<Charv> listChar;
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListCharAdapter(ArrayList<Charv> list) {
        this.listChar = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_char, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Charv charv = listChar.get(position);
        holder.avatarr.setImageResource(charv.getAvatar());
        holder.uname.setText(charv.getUsername());
        holder.namee.setText(charv.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listChar.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnItemClickCallback {
        void onItemClicked(Charv data);
    }

    @Override
    public int getItemCount() {
        return listChar.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarr;
        TextView uname,namee;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarr = itemView.findViewById(R.id.avatar);
            uname = itemView.findViewById(R.id.username);
            namee = itemView.findViewById(R.id.name);
        }
    }

}
