package com.example.androidguide;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.Mydatabase.CRUD;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new InformationFragment().newInstance()).commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if(id == R.id.menu_info) {
            fragment = InformationFragment.newInstance();
        } else if (id == R.id.menu_diseases) {
            fragment = ListDiseasesActivity.newInstance();
        } else if (id == R.id.menu_medmodern) {
            fragment = PharmaceuticalActivity.newInstance();
        } else if (id == R.id.menu_medtraditional) {
            fragment = MedicineTraditionalActivity.newInstance();
        } else if (id == R.id.menu_firstaid) {
            fragment = AIDActivity.newInstance();
        } else if (id == R.id.menu_hospital) {
            fragment = HospitalActivity.newInstance();
        } else if (id == R.id.menu_developer) {
            fragment = AboutUsActivity.newInstance();
        }
        /*
        else if (id == R.id.menu_copydb) {
            fragment = null;
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            String DB_PATH = cw.getFilesDir().getAbsolutePath() + "/databases/"; //edited to databases
            copyDataBase(DB_PATH);
            CRUD crud = new CRUD(getApplicationContext());
            if(crud.testInsert() != -1)
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();

            drawer.closeDrawers();
        }
        */
        FragmentManager manager = getSupportFragmentManager();
        if (fragment != null) {
            FragmentTransaction transaction = manager.beginTransaction().replace(R.id.content, fragment);
            transaction.commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void copyDataBase(String path) {
        byte[] buffer = new byte[1024];
        OutputStream myOutput = null;
        int length;
        // Open your local db as the input stream
        InputStream myInput = null;
        try {
            String DB_NAME = "mydatabase.db";
            myInput = getAssets().open(DB_NAME);
            // transfer bytes from the inputfile to the
            // outputfile
            myOutput = new FileOutputStream(path);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.close();
            myOutput.flush();
            myInput.close();
            Log.d("test", "success");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("test", "failed");
        }
    }
}
