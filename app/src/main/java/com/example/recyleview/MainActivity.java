package com.example.recyleview;

import androidx.recyclerview.widget.GridLayoutManager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.recyleview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);

        ArrayList<Tech> Tech = getListTech();
        TechAdapter TechAdapter=new TechAdapter(Tech);
        binding.rvTechName.setLayoutManager(new GridLayoutManager(this, 1));
        binding.rvTechName.setAdapter(TechAdapter);

    }

    private ArrayList<Tech> getListTech()
    {
        String[] name = getResources().getStringArray(R.array.tech_name);
        String[] description = getResources().getStringArray(R.array.tech_desc);
        TypedArray image = getResources().obtainTypedArray(R.array.tech_image);

        ArrayList<Tech> Techno = new ArrayList<>();

        for(int i = 0; i < name.length; i++){
            Tech tech = new Tech();
            tech.setName(name[i]);
            tech.setDescription(description[i]);
            tech.setPoster(image.getResourceId(i, -1));
            Techno.add(tech);

        }
        return Techno;
    }
}
