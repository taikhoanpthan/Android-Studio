package com.example.shoppingnttu.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.shoppingnttu.R;
import com.example.shoppingnttu.adapter.PopularAdapter;
import com.example.shoppingnttu.databinding.ActivityMainBinding;
import com.example.shoppingnttu.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();
        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(v -> startCartActivity());
    }

    private void startCartActivity() {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }


    private void statusBarColor(){
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_Dark));
    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-Shirt black","item_1",15,4,500,"Áo Thun Cổ Trụ Tối Giản M4\n" +
                "Chất liệu: Vải cá sấu tici\n" +
                "Thành phần: 61% Polyester 33% Cotton 6% Spandex\n" +
                "- Thoáng mát\n" +
                "- Co giãn tối ưu\n" +
                "- Thoải mái\n" +
                "- May đắp logo inox"));
        items.add(new PopularDomain("Smart Watch","item_2",10,4.5,450,"\n" +
                "The Unity Bloom Apple Watch band and face are inspired by the growth and resilience nurtured by generations working together to address injustice and dismantle systemic barriers. Each flower shape has a hand-crafted appearance as if cut from paper. Together they service as emblems of truth, power, and solidarity and symbolize commitment to cultivating a more equitable world. One where everyone blooms. Designed by Black creatives and allies at Apple, this band honors Black history for anyone committed to ending systemic racism and building a more equitable world"));
        items.add(new PopularDomain("Phone","item_3",3,4.9,800,"Thiết kế khung viền từ titan chuẩn hàng không vũ trụ - Cực nhẹ, bền cùng viền cạnh mỏng cầm nắm thoải mái\n" +
                "Hiệu năng Pro chiến game thả ga - Chip A17 Pro mang lại hiệu năng đồ họa vô cùng sống động và chân thực\n" +
                "Thoả sức sáng tạo và quay phim chuyên nghiệp - Cụm 3 camera sau đến 48MP và nhiều chế độ tiên tiến\n" +
                "Nút tác vụ mới giúp nhanh chóng kích hoạt tính năng yêu thích của bạn"));
        items.add(new PopularDomain("Nike AirForce 1","nike1",50,5,1000,"Ra mắt: Air Force 1 được giới thiệu lần đầu tiên vào năm 1982 và nhanh chóng trở thành một biểu tượng thời trang và văn hóa đối với cả giới thể thao và đường phố.\n" +
                "\n" +
                "Thiết kế: Air Force 1 có một thiết kế đơn giản nhưng mạnh mẽ, với đế giữa có túi khí Air cho sự thoải mái và độ đàn hồi. Mẫu giày thường có một đôi dây đan phía trước và logo \"Swoosh\" nổi tiếng của Nike.\n" +
                "\n" +
                "Colorways: Air Force 1 đã được phát hành với nhiều phiên bản màu sắc và chất liệu khác nhau, từ các phiên bản cổ điển như trắng, đen đến những biến thể đặc biệt và hợp tác với nhiều nghệ sĩ và thương hiệu khác nhau."));
        items.add(new PopularDomain("Nike Jordan Red","nike2",40,5,900,"Jordan 4 là một trong những mẫu giày thể thao nổi tiếng của dòng sản phẩm Air Jordan, do hãng thể thao Nike sản xuất và phát triển. Đây là một trong những mẫu giày mang tính biểu tượng và được đánh giá cao trong cộng đồng sneaker và cả cộng đồng yêu thể thao."));
        items.add(new PopularDomain("Head Phone ","phone",20,4,200,"Phát hiện chính xác đối thủ với 360 Spatial Sound dành cho Chơi game\n" +
                "Chơi game thoải mái trong nhiều giờ do có thiết kế trọng lượng nhẹ, chỉ 260 g và áp lực lên bên mặt ở mức tối thiểu\n" +
                "Giao tiếp mượt mà với đồng đội bằng micro boom hai hướng có công nghệ giảm tiếng ồn dựa trên AI"));

        binding.Popular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.Popular.setAdapter(new PopularAdapter(items));
    }
}