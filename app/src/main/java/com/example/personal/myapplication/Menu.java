package com.example.personal.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Sianna-chan on 28/10/2016.
 */
public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        WebView myWebView = (WebView)findViewById(R.id.webView_menu);

        //myWebView.getSettings().setJavaScriptEnabled(true);
        //myWebView.getSettings().setSupportZoom(true);
        //Scale
        //myWebView.setInitialScale(0);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebViewJavaScriptInterface(this), "app");

        myWebView.loadUrl("file:///android_asset/index.html");
        //myWebView.loadUrl("https://www.google.com/");
    }


    public class WebViewJavaScriptInterface{

        private Context context;


        // * Need a reference to the context in order to sent a post message

        public WebViewJavaScriptInterface(Context context){
            this.context = context;
        }


        // * This method can be called from Android. @JavascriptInterface
        // * required after SDK version 17.

        @JavascriptInterface
        public void makeToast(String message, boolean lengthLong){
            Toast.makeText(context, message, (lengthLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT)).show();
        }
        @JavascriptInterface
        public void sqlite(){
            Intent i = new Intent(Menu.this, MainActivity.class );
            startActivity(i);
        }
        @JavascriptInterface
        public void dragdrop(){
            Intent i = new Intent(Menu.this, DragDrop.class );
            startActivity(i);
        }

        @JavascriptInterface
        public void webview(){
            Intent i = new Intent(Menu.this, Versiones.class );
            startActivity(i);
        }
    }
}
