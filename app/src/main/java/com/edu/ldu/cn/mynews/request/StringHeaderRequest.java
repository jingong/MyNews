package com.edu.ldu.cn.mynews.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mic on 2017/1/20.
 */

public class StringHeaderRequest extends StringRequest {

    public StringHeaderRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public StringHeaderRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String,String> map = new HashMap<>();
        map.put("key","c379a9b75caa358dd3f1c43c644ba661");
        return map;
    }
}
