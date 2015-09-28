package com.qice.volleytest;

/**
 * Created by qice on 28/9/15.
 */
public interface SuccessCallbackListener {

    void onStartRequest();
    void onSuccess(String successResponse);
    void onFailure(String failureResponse);

}
