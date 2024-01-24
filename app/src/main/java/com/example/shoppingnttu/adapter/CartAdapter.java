package com.example.shoppingnttu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.shoppingnttu.databinding.ViewholderCartBinding;
import com.example.shoppingnttu.domain.PopularDomain;
import com.example.shoppingnttu.helper.ChangeNumberItemsListener;
import com.example.shoppingnttu.helper.ManagmentCart;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    private ArrayList<PopularDomain> items;
    private Context context;
    private ViewholderCartBinding binding;
    private ChangeNumberItemsListener changeNumberItemsListener;
    private ManagmentCart managmentCart;

    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemsListener changeNumberItemsListener, Context context) {
        this.items = items;
        this.changeNumberItemsListener = changeNumberItemsListener;
        this.context = context;
        this.managmentCart = new ManagmentCart(context);
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        ViewholderCartBinding itemBinding = holder.binding;  // Sử dụng binding của ViewHolder
        itemBinding.titleTxt.setText(items.get(position).getTitle());
        itemBinding.feeEachitem.setText("$" + items.get(position).getPrice());
        itemBinding.totalEachitem.setText("$" + Math.round(items.get(position).getNumberInCart() * items.get(position).getPrice()));
        itemBinding.numberItem.setText(String.valueOf(items.get(position).getNumberInCart()));

        int drawableResource = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResource)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(itemBinding.pic);

        itemBinding.plusCartBtn.setOnClickListener(v -> {
            managmentCart.plusNumberItem(items, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });
        });

        itemBinding.minusCartBtn.setOnClickListener(v -> {
            managmentCart.minusNumberItem(items, position, () -> {
                notifyDataSetChanged();
                changeNumberItemsListener.change();
            });
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderCartBinding binding;
        public Viewholder(ViewholderCartBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
