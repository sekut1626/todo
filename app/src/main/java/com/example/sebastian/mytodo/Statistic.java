package com.example.sebastian.mytodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Statistic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
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
                startActivity(new Intent(Statistic.this, MainActivity.class));
                break;

            case R.id.action_projects:
                startActivity(new Intent(Statistic.this, Projects.class));
                break;

            case R.id.action_notes:
                startActivity(new Intent(Statistic.this, Notes.class));
                break;

            case R.id.action_statistic:
                break;
        }
        return true;
    }
}
