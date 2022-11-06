package com.clip.Clip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.clip.Clip.adapter.GroupListAdapter;
import com.clip.Clip.service.GlobalContext;

public class GroupList extends AppCompatActivity {

    RecyclerView groupListRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        groupListRecyclerView = findViewById(R.id.group_list);
        GroupListAdapter adapter = new GroupListAdapter(GlobalContext.getInstance().getGroups());
        groupListRecyclerView.setAdapter(adapter);
    }
}