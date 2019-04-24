package net;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import net.util.Constant;
import okhttp3.*;
import util.LogUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class NetPresenter {
    private static final String TAG = "NetPresenter";

    public NetPresenter() {
    }

//    public void getWeatherInfo(Callback callback) {
//        String host = "https://restapi.amap.com/v3/weather/weatherInfo";
////        HttpUrl.Builder httpUrlBuilder = HttpUrl.get("https://restapi.amap.com/v3/weather/weatherInfo").newBuilder();
////        httpUrlBuilder.addQueryParameter("key", "e6d5fcf3c2cbb53dba565021ee38ff52");
////        httpUrlBuilder.addQueryParameter("city", "640100");
////        httpUrlBuilder.addQueryParameter("extensions", "all");
////        httpUrlBuilder.addQueryParameter("output", "JSON");
//        HashMap<String, String> hashMap = getStrMap();
//        hashMap.put("key", "e6d5fcf3c2cbb53dba565021ee38ff52");
//        hashMap.put("city", "640100");
//        hashMap.put("extensions", "all");
//        hashMap.put("output", "JSON");
//        executeGet(host, hashMap, callback);
//    }

    public void createSchedule(@NotNull String uuid, @NotNull String title, @Nullable String desc,
                               @NotNull String reminderDate, @NotNull String reminderRules, Callback callback) {
        String host = getUrl(Constant.API.Schedule);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, String> treeMap = getStrMap();
        treeMap.put("title", title);
        treeMap.put("desc", desc);
        treeMap.put("reminder_date", reminderDate);
        treeMap.put("reminder_rules", reminderRules);
        executeFormPost(host, treeMap, callback);
    }

    public void getScheduleList(@NotNull String uuid, @Nullable String start, @Nullable String rows, @NotNull String year, @Nullable String month,
                                @Nullable String day, @Nullable String todo, Callback callback) {
        String host = getUrl(Constant.API.Schedule);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, String> treeMap = getStrMap();
        if (notNullOrEmpty(start)) {
            treeMap.put("start", start);
        }
        if (notNullOrEmpty(rows)) {
            treeMap.put("rows", rows);
        }
        if (notNullOrEmpty(year)) {
            treeMap.put("year", year);
        }
        if (notNullOrEmpty(month)) {
            treeMap.put("month", month);
        }
        if (notNullOrEmpty(day)) {
            treeMap.put("day", day);
        }
        if (notNullOrEmpty(todo)) {
            treeMap.put("todo", todo);
        }
        executeGet(host, treeMap, callback);
    }

    public void updateSchedule(@NotNull String uuid, @NotNull String id, @NotNull String title, @Nullable String desc,
                               @NotNull String reminderDate, @NotNull String reminderRules, Callback callback) {
        String host = getUrl(Constant.API.ScheduleWithId);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[ID]", id);
        TreeMap<String, String> treeMap = getStrMap();
        treeMap.put("title", title);
        treeMap.put("desc", desc);
        treeMap.put("reminder_date", reminderDate);
        treeMap.put("reminder_rules", reminderRules);
        executeFormPut(host, treeMap, callback);
    }

    public void deleteSchedule(@NotNull String uuid, @NotNull String id, Callback callback) {
        String host = getUrl(Constant.API.ScheduleWithId);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[ID]", id);
        executeDelete(host, null, callback);
    }

    public void getWeatherInfo(String tuid, String city, Callback callback) {
        String host = getUrl(Constant.API.WeatherInfo);
        host = host.replace("[TUID]", tuid);
        TreeMap<String, String> treeMap = getStrMap();
        treeMap.put("cityName", city);
        executeGet(host, treeMap, callback);
    }

    public void getUserInfo(String tuid, Callback callback) {
        String host = getUrl(Constant.API.UserInfo);
        host = host.replace("[TUID]", tuid);
        executeGet(host, null, callback);
    }

    public void getRescue(String tuid, Callback callback) {
        String host = getUrl(Constant.API.Rescue);
        host = host.replace("[TUID]", tuid);
        executeGet(host, null, callback);
    }

    public void getParkingLots(String tuid, String lat, String lon, String radius, Callback callback) {
        String host = getUrl(Constant.API.ParkingLots);
        host = host.replace("[TUID]", tuid);
        TreeMap<String, String> treeMap = getStrMap();
        treeMap.put("lat", lat);
        treeMap.put("lon", lon);
        treeMap.put("radius", radius);
        executeGet(host, treeMap, callback);
    }

    public void getDelicacy(String tuid, String uuid, @NotNull String lat, @NotNull String lon, @Nullable String city,
                            @Nullable String sort, @Nullable String radius, @Nullable String keyword, Callback callback) {
        String host = getUrl(Constant.API.Delicacy);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, String> treeMap = getStrMap();
        treeMap.put("lat", lat);
        treeMap.put("lon", lon);
        if (notNullOrEmpty(city)) {
            treeMap.put("city", city);
        }
        if (notNullOrEmpty(sort)) {
            treeMap.put("sort", sort);
        }
        if (notNullOrEmpty(radius)) {
            treeMap.put("radius", radius);
        }
        if (notNullOrEmpty(keyword)) {
            treeMap.put("keyword", keyword);
        }
        executeGet(host, treeMap, callback);
    }

    public void getDelicacyDetail(String tuid, String uuid, String openShopId, Callback callback) {
        String host = getUrl(Constant.API.DelicacyDetail);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[OPENSHOPID]", openShopId);
        executeGet(host, null, callback);
    }

    /*****************************************************************************/

    private boolean notNullOrEmpty(String data) {
        return !(data == null || data.isEmpty());
    }

    private void executeGet(String url, TreeMap<String, String> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.get(url).newBuilder();
        if (params != null) {
            try {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
                    httpUrlBuilder.addQueryParameter(entry.getKey(), URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            LogUtil.i(TAG, "null params");
        }
        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request request = new Request.Builder()
                .url(httpUrlBuilder.toString()).build();
        Call call = getOkHttpClient().newCall(request);
        call.enqueue(callback);
    }

    private void executeFormPost(String url, TreeMap<String, String> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.get(url).newBuilder();
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
                builder.addEncoded(entry.getKey(), entry.getValue());
            }
        } else {
            LogUtil.i(TAG, "null params");
        }
        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request.Builder request = new Request.Builder()
                .url(httpUrlBuilder.toString())
                .post(builder.build());
        Call call = getOkHttpClient().newCall(request.build());
        call.enqueue(callback);
    }

    private void executeFormPut(String url, TreeMap<String, String> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.get(url).newBuilder();
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
                builder.addEncoded(entry.getKey(), entry.getValue());
            }
        } else {
            LogUtil.i(TAG, "null params");
        }
        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request.Builder request = new Request.Builder()
                .url(httpUrlBuilder.toString())
                .put(builder.build());
        Call call = getOkHttpClient().newCall(request.build());
        call.enqueue(callback);
    }

    private void executeDelete(String url, TreeMap<String, String> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.get(url).newBuilder();
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
                builder.addEncoded(entry.getKey(), entry.getValue());
            }
        } else {
            LogUtil.i(TAG, "null params");
        }
        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request.Builder request = new Request.Builder()
                .url(httpUrlBuilder.toString())
                .delete(builder.build());
        Call call = getOkHttpClient().newCall(request.build());
        call.enqueue(callback);
    }

    private TreeMap<String, String> getStrMap() {
        return new TreeMap<String, String>();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new AddHeaderInterceptor())
                .build();
    }

    private String getUrl(String subUrl) {
        String urlFormat = "%1$s/api/1.0/%2$s";
        return String.format(urlFormat, Constant.API_HOST, subUrl) + "/";
    }

    public static class AddHeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("Cookie",
                            "customer_key=" + Constant.CUSTOMER_KEY
                                    + ";access_token=" + Constant.ACCESS_TOKEN)
                    .build();
            return chain.proceed(request);
        }
    }
}
