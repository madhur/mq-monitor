package in.co.madhur.rabbitmonitor.request;


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
import java.lang.reflect.Type;
import java.util.Map;




public class GsonRequest<T> extends Request<T> {

    private Class<T> clazz;
    private Response.Listener<T> listener;
    private Type typeof;

    public GsonRequest(int method, String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.listener = listener;
        setShouldCache(Boolean.TRUE);
    }

    public GsonRequest(int method, String url, Type typeof, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.typeof = typeof;
        this.listener = listener;
        setShouldCache(Boolean.TRUE);
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

//    @Override
//    public Map<String, String> getHeaders() throws AuthFailureError {
//        return AuthUtil.getBasicAuth();
//    }

    @Override
    public Priority getPriority() {
        return Priority.HIGH;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return super.getParams();
    }
}