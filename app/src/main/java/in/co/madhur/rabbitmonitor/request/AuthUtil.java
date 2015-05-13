package in.co.madhur.rabbitmonitor.request;

import android.util.Base64;

import java.util.Collections;
import java.util.Map;

import in.co.madhur.rabbitmonitor.AppPreferences;

/**
 * Created by madhur on 13/05/15.
 */


public final class AuthUtil {
    private AuthUtil() {

    }

    public static Map<String, String> getBasicAuth() {


        Map<String, String> requestParams = Collections.emptyMap();
        String creds = String.format("%s:%s", "admin", "admin");
        String auth = "Basic "
                + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
        requestParams.put("Authorization", auth);
        return requestParams;
    }
}
