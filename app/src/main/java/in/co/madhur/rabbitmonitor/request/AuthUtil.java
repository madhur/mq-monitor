package in.co.madhur.rabbitmonitor.request;

import android.util.Base64;

import java.util.Collections;
import java.util.Map;

/**
 * Created by madhur on 13/05/15.
 */


public final class AuthUtil {
    private AuthUtil() {

    }

    public static Map<String, String> getBasicAuth() {


        Map<String, String> requestParams = Collections.emptyMap();
        String creds = String.format("%s:%s", "guest", "guest");
        String auth = "Basic "
                + Base64.encodeToString(creds.getBytes(), Base64.NO_WRAP);
        requestParams.put("Authorization", auth);
        return requestParams;
    }
}
