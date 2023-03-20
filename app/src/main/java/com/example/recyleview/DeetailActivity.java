package com.example.recyleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyleview.databinding.ActivityDeetailBinding;
import com.example.recyleview.databinding.ActivityMainBinding;

public class DeetailActivity extends AppCompatActivity {

    private ActivityDeetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent =getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        int poster = intent.getIntExtra("poster", 0);

        binding.heroName.setText(title);
        binding.heroDescription.setText(description);
        binding.heroPoster.setImageResource(poster);




    }
}