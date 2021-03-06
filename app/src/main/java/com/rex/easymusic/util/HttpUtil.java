package com.rex.easymusic.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Http工具类
 * Created by Bobby on 2018/7/10.
 */

public class HttpUtil {
    /**
     * http异步GET请求
     * @param address
     * @param callback
     */
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        Request request=new Request.Builder().url(address).build();
        OkHttpClient client=new OkHttpClient();
        client.newCall(request).enqueue(callback);
    }

    /**
     * http异步POST请求(带参数)
     * @param address
     * @param requestBody
     * @param callback
     */
    public static void sendOkHttpRequest(String address, RequestBody requestBody,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .post(requestBody)
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * http同步请求
     * @param address
     * @return
     * @throws IOException
     */
    public static String sendOkHttpRequest(String address) throws IOException {
        OkHttpClient client=new OkHttpClient.Builder()
                .connectTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .build();
        Request request=new Request.Builder().url(address).build();
        Call call=client.newCall(request);
        return call.execute().body().string();
    }
}
