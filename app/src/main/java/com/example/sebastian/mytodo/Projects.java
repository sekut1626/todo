package com.example.sebastian.mytodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Projects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_tasks:
                startActivity(new Intent(Projects.this, MainActivity.class));
                break;

            case R.id.action_projects:
                break;

            case R.id.action_notes:
                startActivity(new Intent(Projects.this, Notes.class));
                break;

            case R.id.action_statistic:
                startActivity(new Intent(Projects.this, Statistic.class));
                break;
        }
        return true;
    }
}
