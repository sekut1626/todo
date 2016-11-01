package com.example.sebastian.mytodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_tasks:
                startActivity(new Intent(Notes.this, MainActivity.class));
                break;

            case R.id.action_projects:
                startActivity(new Intent(Notes.this, Projects.class));
                break;

            case R.id.action_notes:
                break;

            case R.id.action_statistic:
                startActivity(new Intent(Notes.this, Statistic.class));
                break;
        }
        return true;
    }
}
