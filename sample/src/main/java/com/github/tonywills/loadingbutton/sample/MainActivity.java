package com.github.tonywills.loadingbutton.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.tonywills.loadingbutton.HorizontalLoadingButton;
import com.github.tonywills.loadingbutton.LoadingButton;

public class MainActivity extends AppCompatActivity {

    private HorizontalLoadingButton horizontalLoadingButton;
    private LoadingButton loadingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();
        horizontalLoadingButton = (HorizontalLoadingButton) findViewById(R.id.horizontal_loading_button);
        loadingButton = (LoadingButton) findViewById(R.id.loading_button);
        loadingButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                loadingButton.setLoading(true);
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        loadingButton.setLoading(false);
                    }
                }, 3000);
            }
        });
        horizontalLoadingButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                horizontalLoadingButton.setLoading(true);
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        horizontalLoadingButton.setLoading(false);
                    }
                }, 3000);
            }
        });
    }

    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Loading Button Example");
    }
}
