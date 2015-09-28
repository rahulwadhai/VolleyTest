package com.qice.volleytest;


import org.apache.http.Header;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

//import com.snappit.MyApplication;
//import com.snappit.interfaces.SuccessCallbackListener;
//import com.snappit.utils.GlobalUtils;

import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.Throwable;
import java.util.HashMap;
import java.util.Map;

public class VolleyRequestCall {

    Context context;


    public VolleyRequestCall(Context context) {

        this.context=context;
    }


    public void postRequestCall(final String TAG, String strUrl, final SuccessCallbackListener callbackListener) {

        Log.v(TAG, "post strUrl:" + strUrl);
        callbackListener.onStartRequest();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, strUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Do something with the response
                Log.e(TAG, "response:" + response);
                // GsonBuilder gsonBuilder = new GsonBuilder();
                // gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                // Gson gson = gsonBuilder.create();
                try {
                    // JSONObject jsonResult = new JSONObject(response);
                    callbackListener.onSuccess(response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        Log.e(TAG, "error" + error.getMessage());
                        callbackListener.onFailure(error.getMessage());
                    }
                });

        stringRequest.setTag(TAG);
        // Add the request to the RequestQueue.
        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest);
    }


    public void getRequestCall(final String TAG, String strUrl, final SuccessCallbackListener callbackListener) {

        Log.v(TAG, "get strUrl:" + strUrl);
        callbackListener.onStartRequest();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, strUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Do something with the response
                Log.e(TAG, "get response:" + response);
                // GsonBuilder gsonBuilder = new GsonBuilder();
                // gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                // Gson gson = gsonBuilder.create();
                try {
                    // JSONObject jsonResult = new JSONObject(response);
                    // User user = gson.fromJson(response, User.class);
                    // Log.v(TAG,"address:"+user.getAddress());
                    // Log.v(TAG,"address:"+user.getEmail());
                    // Log.v(TAG,"address:"+user.getFirstName());
                    // callSignUpActivity(1);
                    callbackListener.onSuccess(response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                // List<Post> posts = new ArrayList<Post>();
                // posts = Arrays.asList(gson.fromJson(reader, Post[].class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Log.e(TAG, "error" + error.getMessage());
                callbackListener.onFailure(error.getMessage());
            }
        });
        stringRequest.setTag(TAG);
        // Add the request to the RequestQueue.
        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest);
    }

    public void putRequestCall(final String TAG, String strUrl, final SuccessCallbackListener callbackListener) {

        Log.v(TAG, "put strUrl:" + strUrl);
        callbackListener.onStartRequest();

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, strUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Do something with the response
                Log.e(TAG, "Put response:" + response);
                callbackListener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Log.e(TAG, "error" + error.getMessage());
                callbackListener.onFailure(error.getMessage());
            }
        });
        stringRequest.setTag(TAG);
        // Add the request to the RequestQueue.
        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest);
    }

    public void deleteRequestCall(final String TAG, String strUrl, final SuccessCallbackListener callbackListener) {

        Log.v(TAG, "delete strUrl:" + strUrl);
        callbackListener.onStartRequest();

        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, strUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Do something with the response
                Log.e(TAG, "delete response:" + response);
                callbackListener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Log.e(TAG, "error" + error.getMessage());
                callbackListener.onFailure(error.getMessage());
            }
        });
        stringRequest.setTag(TAG);
        // Add the request to the RequestQueue.
        VolleySingleton.getInstance(context).getRequestQueue().add(stringRequest);
    }

    public void jsonPostRequestCall(final String TAG, String strUrl, final SuccessCallbackListener callbackListener) {

        Log.v(TAG, "delete strUrl:" + strUrl);
        callbackListener.onStartRequest();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                strUrl, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with the response
                        Log.e(TAG, "delete response:" + response);
                        callbackListener.onSuccess(response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                Log.e(TAG, "error" + error.getMessage());
                callbackListener.onFailure(error.getMessage());
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("password", "password123");

                return params;
            }

        };
        jsonObjReq.addMarker(TAG);

        VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjReq);
    }
}
