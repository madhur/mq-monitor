package in.co.madhur.rabbitmonitor.request;


import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;




public class GsonRequest<T> extends Request<T> {

    private Class<T> clazz;
    private Response.Listener<T> listener;
    private String userName;
    private String password;

    public GsonRequest(int method, String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener, String userName, String password) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.listener = listener;
        setShouldCache(Boolean.FALSE);
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(
                    new GsonBuilder().create().fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            Log.e(GsonRequest.class.getName(), e.getMessage(), e);
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> requestParams = new HashMap<>();

        String creds = String.format("%s:%s", userName, password);
        String auth = "Basic "
                + Base64.encodeToString(creds.getBytes(), Base64.NO_WRAP);
        requestParams.put("Authorization", auth);
        return requestParams;
    }

    @Override
    public Priority getPriority() {
        return Priority.HIGH;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return super.getParams();
    }
}