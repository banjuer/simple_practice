
package xyz.banjuer.tool;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Request.Builder;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtil {
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();

    public OkHttpUtil() {
    }

    private static String getUrlAppend(String url, Map<String, String> params) {
        if (EmptyUtils.isEmpty(url)) {
            throw new RuntimeException("url cant not be null");
        } else {
            if (EmptyUtils.isNotEmpty(params)) {
                StringBuilder wholeUrl = new StringBuilder();
                wholeUrl.append(url).append('?');
                params.forEach((k, v) -> {
                    wholeUrl.append(k).append('=').append(v).append('&');
                });
                url = wholeUrl.toString();
            }

            return url;
        }
    }

    public static String get(String url) {
        return get(url, (Map) null);
    }

    public static String get(String url, Map<String, String> params) {
        url = getUrlAppend(url, params);
        System.out.println(url);
        Request request = (new Builder()).url(url).get().build();

        try {
            Response response = HTTP_CLIENT.newCall(request).execute();
            return new String(response.body().bytes());
        } catch (IOException var4) {
            throw new OkHttpException(var4);
        }
    }

    public static String post(String url, Map<String, String> params) {
        if (EmptyUtils.isEmpty(url)) {
            throw new RuntimeException("url cant not be null");
        } else {
            FormEncodingBuilder builder = new FormEncodingBuilder();
            if (EmptyUtils.isNotEmpty(params)) {
                params.forEach((k, v) -> {
                    if (EmptyUtils.isNotEmpty(k) && EmptyUtils.isNotEmpty(v)) {
                        builder.add(k, v);
                    }

                });
            }

            RequestBody formBody = builder.build();
            Request request = (new Builder()).url(url).post(formBody).build();

            try {
                Response response = HTTP_CLIENT.newCall(request).execute();
                return new String(response.body().bytes());
            } catch (IOException var6) {
                throw new OkHttpException(var6);
            }
        }
    }

    static {
        HTTP_CLIENT.setConnectTimeout(HttpConst.CONNECT_SECONDS, TimeUnit.SECONDS);
        HTTP_CLIENT.setWriteTimeout(HttpConst.WRITE_SECONDS, TimeUnit.SECONDS);
        HTTP_CLIENT.setReadTimeout(HttpConst.READ_SECONDS, TimeUnit.SECONDS);
    }

    public static class OkHttpException extends RuntimeException {
        private static final long serialVersionUID = -5869941022225661118L;

        public OkHttpException(IOException cause) {
            super(cause);
        }

        @Override
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    interface HttpConst {
        int CONNECT_SECONDS = 2;
        int WRITE_SECONDS = 1;
        int READ_SECONDS = 1;
    }
}
