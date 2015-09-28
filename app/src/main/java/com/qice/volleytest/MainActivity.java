package com.qice.volleytest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.volley.toolbox.StringRequest;


public class MainActivity extends Activity implements SuccessCallbackListener {

    public static String TAG="MainActivity";
    Button button;
    VolleyRequestCall volleyRequestCall;
    SuccessCallbackListener successCallbackListener=this;
    ProgressDialog dialog;
    ConnectionDetector connectionDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     button = (Button) findViewById(R.id.button);

        volleyRequestCall=new VolleyRequestCall(getApplicationContext());
        connectionDetector =new ConnectionDetector(getApplicationContext());

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (connectionDetector.isConnectingToInternet()){
            dialog =new ProgressDialog(MainActivity.this);
            dialog.setMessage("Please wait...");
            dialog.show();
            String strUrl="http://jsonplaceholder.typicode.com/users";

            volleyRequestCall.postRequestCall(TAG, strUrl, successCallbackListener);

            }
        }
    });
    }


    @Override
    public void onStartRequest() {}
    @Override
    public void onSuccess(String successResponse) {

        if (dialog.isShowing()) {
            dialog.dismiss();
        }

        Log.e(TAG,"successResponse: "+successResponse);

    }
    @Override
    public void onFailure(String failureResponse) {

        if (dialog.isShowing()){
            dialog.dismiss();
        }
        Log.e(TAG,"failureResponse: "+failureResponse);

    }
}
