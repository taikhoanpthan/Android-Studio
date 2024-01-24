package com.example.shoppingnttu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;

import com.bumptech.glide.Glide;
import com.example.shoppingnttu.R;
import com.example.shoppingnttu.databinding.ActivityDetailsBinding;
import com.example.shoppingnttu.domain.PopularDomain;
import com.example.shoppingnttu.helper.ManagmentCart;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private PopularDomain object;
    private int numberOrder = 1;
    private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundles();
        managmentCart = new ManagmentCart(this);
        statusBarColor();
    }

    private void statusBarColor() {
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
    }

    private void getBundles() {
        object = (PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = getResources().getIdentifier(object.getPicUrl(), "drawable", getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(binding.itemPic);

        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText(String.format("$%s", object.getPrice()));
        binding.descriptionTxt.setText(object.getDescription());
        binding.revewTxt.setText(String.valueOf(object.getReview()));
        binding.ratingTxt.setText(String.valueOf(object.getScore()));

        binding.buyBtn.setOnClickListener(v -> {
            addToCart();
        });

        binding.backbtn.setOnClickListener(v -> finish());
    }

    private void addToCart() {
        try {
            object.setNumberInCart(numberOrder);
            managmentCart.insertFood(object);
            // You may show a success message here if needed
        } catch (Exception e) {
            e.printStackTrace();
            // Log or show an error message if adding to cart fails
        }
    }
}
