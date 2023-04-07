package com.rumplestilzken.network_conf;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.rumplestilzken.network.ShellNetworkProcessor;
import com.rumplestilzken.network.UINetworkProcessor;
import com.rumplestilzken.network_conf.databinding.MainMenuBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("network-conf");
    }

    private AppBarConfiguration appBarConfiguration;

    private MainMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = MainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.shellTextView.setMovementMethod(new ScrollingMovementMethod());
        binding.uiTextView.setMovementMethod(new ScrollingMovementMethod());

        binding.shellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.shellTextView.setText(new ShellNetworkProcessor().getNetworkOutput());
            }
        });

        binding.uiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.uiTextView.setText(new UINetworkProcessor().getNetworkOutput());
            }
        });
    //
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}