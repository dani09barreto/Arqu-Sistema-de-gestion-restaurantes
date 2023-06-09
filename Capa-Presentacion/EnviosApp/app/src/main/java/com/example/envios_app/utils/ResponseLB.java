package com.example.envios_app.utils;

import android.os.AsyncTask;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ResponseLB {
    private static final String HEADER_NAME = "X-Upstream";

    public interface ResponseCallback {
        void onResponse(String headerValue);
        void onError(String errorMessage);
    }

    public void getResponse(String url, ResponseCallback callback) {
        new HttpRequestTask(callback).execute(url);
    }

    private static class HttpRequestTask extends AsyncTask<String, Void, String> {
        private final ResponseCallback callback;

        public HttpRequestTask(ResponseCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                Headers headers = response.headers();
                return headers.get(HEADER_NAME);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                callback.onResponse(result);
            } else {
                callback.onError("Error al obtener el encabezado");
            }
        }
    }
}


