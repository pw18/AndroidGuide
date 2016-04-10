package com.example.androidguide;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.example.utils.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
	
	Handler handler;
	Runnable runnable;
	long delay_time;
	long time = 3000l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        File file = new File(Environment.getExternalStorageDirectory(), Constant.FileNameDataBase);
        if(!file.exists()) {
            try {
                copyDatabase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        runnable = new Runnable() {
        
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        };
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	delay_time = time;
    	handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	handler.removeCallbacks(runnable);
    	time = delay_time - (System.currentTimeMillis() - time);
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void copyDatabase() throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(), Constant.FileNameDataBase);

        InputStream  in  = null;
        OutputStream out = null;
        try {
            in  = getAssets().open(Constant.FileNameDataBase); //.I'm in a service, so I don't need context
            out = new FileOutputStream(file);

            int count = 0;
            byte[] buffer = new byte[1024*2];
            while ((count = in.read(buffer)) != -1) {
                out.write(buffer, 0, count);
                out.flush();
            }
        } catch (IOException err) {

        } finally {
            if (in != null)
                try { in.close(); }
                catch (IOException ignore) {  }
            if (out != null)
                try { out.close(); }
                catch (IOException ignore) {  }
        }

    }
}
