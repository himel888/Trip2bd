package com.cloud_aps.trip2bd;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity {

    WebView mWebview;
    public static ProgressBar progressBar;
    AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        mWebview =  (WebView) findViewById(R.id.webview);

        WebSettings myWebsettings = mWebview.getSettings();
        myWebsettings.setJavaScriptEnabled(true);
        myWebsettings.setSupportZoom(true);
        myWebsettings.setBuiltInZoomControls(true);
        myWebsettings.setDisplayZoomControls(true);
        myWebsettings.setUseWideViewPort(true);
        mWebview.loadUrl("http://cloud-aps.com/apex/f?p=666:1::::::");

        mWebview.setWebViewClient(new MyWebViewClient());

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(mWebview.canGoBack()){
            mWebview.goBack();
        }else {
            super.onBackPressed();
        }
    }
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        if (menu != null) {

            menu.findItem(R.id.action_settings).setVisible(false);
        }
    }

}
