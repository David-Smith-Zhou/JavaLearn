package net;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import net.util.Constant;
import okhttp3.*;
import util.LogUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class NetPresenter {
    private String mAccessToken, mCustomerKey;

    private static final String TAG = "NetPresenter";

    public NetPresenter() {
        this(Constant.ACCESS_TOKEN, Constant.CUSTOMER_KEY);
    }

    public NetPresenter(String accessToken, String customerKey) {
        this.mAccessToken = accessToken;
        this.mCustomerKey = customerKey;
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
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("title", title);
        treeMap.put("desc", desc);
        treeMap.put("reminder_date", reminderDate);
        treeMap.put("reminder_rules", reminderRules);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("uuid", uuid);
        executeFormPost(host, urlParams, treeMap, callback);
    }

    public void getScheduleList(@NotNull String uuid, @Nullable String start, @Nullable String rows, @NotNull String year, @Nullable String month,
                                @Nullable String day, @Nullable String todo, Callback callback) {
        String host = getUrl(Constant.API.Schedule);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
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
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void updateSchedule(@NotNull String uuid, @NotNull String id, @NotNull String title, @Nullable String desc,
                               @NotNull String reminderDate, @NotNull String reminderRules, Callback callback) {
        String host = getUrl(Constant.API.ScheduleWithId);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[ID]", id);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("title", title);
        treeMap.put("desc", desc);
        treeMap.put("reminder_date", reminderDate);
        treeMap.put("reminder_rules", reminderRules);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("uuid", uuid);
        urlParams.put("id", id);
        executeFormPut(host, urlParams, treeMap, callback);
    }

    public void deleteSchedule(@NotNull String uuid, @NotNull String id, Callback callback) {
        String host = getUrl(Constant.API.ScheduleWithId);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[ID]", id);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("uuid", uuid);
        urlParams.put("id", id);
        executeDelete(host, urlParams, null, callback);
    }

    public void getWeatherInfo(@NotNull String tuid, @NotNull String city, Callback callback) {
        String host = getUrl(Constant.API.WeatherInfo);
        host = host.replace("[TUID]", tuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("cityName", city);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void getUserInfo(@NotNull String tuid, Callback callback) {
        String host = getUrl(Constant.API.UserInfo);
        host = host.replace("[TUID]", tuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        executeGet(host, urlParams, null, callback);
    }

    public void getRescue(@NotNull String tuid, Callback callback) {
        String host = getUrl(Constant.API.Rescue);
        host = host.replace("[TUID]", tuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        executeGet(host, urlParams, null, callback);
    }

    public void getParkingLots(@NotNull String tuid, @NotNull String lat, @NotNull String lon, String radius, Callback callback) {
        String host = getUrl(Constant.API.ParkingLots);
        host = host.replace("[TUID]", tuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("lat", lat);
        treeMap.put("lon", lon);
        treeMap.put("radius", radius);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void getDelicacy(String tuid, String uuid, @NotNull String lat, @NotNull String lon, @Nullable String city,
                            @Nullable String sort, @Nullable String radius, String setting, @Nullable String keyword, Callback callback) {
        String host = getUrl(Constant.API.Delicacy);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
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
        if (notNullOrEmpty(setting)) {
            treeMap.put("setting", setting);
        }
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void getDelicacyDetail(@NotNull String tuid, @NotNull String uuid, @NotNull String openShopId, Callback callback) {
        String host = getUrl(Constant.API.DelicacyDetail);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[OPENSHOPID]", openShopId);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        urlParams.put("openShopId", openShopId);
        executeGet(host, urlParams, null, callback);
    }

    public void getDelicacySetting(@NotNull String tuid, @NotNull String uuid, @NotNull String classId, Callback callback) {
        String host = getUrl(Constant.API.DelicacySetting);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("classId", classId);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void setDelicacySetting(@NotNull String tuid, @NotNull String uuid, @NotNull String sortListJson, @NotNull String radiusListJson,
                                   @NotNull String settingListJson, Callback callback) {
        String host = getUrl(Constant.API.DelicacySetting);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("sort_list", sortListJson);
        treeMap.put("radius_list", radiusListJson);
        treeMap.put("setting_list", settingListJson);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeFormPost(host, urlParams, treeMap, callback);
    }

    public void getChargingStation(@NotNull String tuid, @NotNull String uuid, @NotNull String lat, @NotNull String lon,
                                   String pageNo, String pageSize, String operator,
                                   String mothod, String usb, String parking,
                                   Callback callback) {
        String host = getUrl(Constant.API.ChargingStation);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("lat", lat);
        treeMap.put("lon", lon);
        treeMap.put("PageNo", pageNo);
        treeMap.put("PageSize", pageSize);
        treeMap.put("operator", operator);
        treeMap.put("mothod", mothod);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }
    public void getChargingStationDetail(@NotNull String tuid, @NotNull String uuid, @NotNull String stationId,
                                   Callback callback) {
        String host = getUrl(Constant.API.ChargingStationDetail);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[STATIONID]", stationId);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        urlParams.put("stationId", stationId);
        executeGet(host, urlParams, null, callback);
    }
    public void getChargingStationSetting(@NotNull String tuid, @NotNull String uuid, String classId, Callback callback) {
        String host = getUrl(Constant.API.ChargingStationSetting);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("classId", classId);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void setChargingStationSetting(@NotNull String tuid, @NotNull String uuid, String sortList, String radiusList, String settingList, Callback callback) {
        String host = getUrl(Constant.API.ChargingStationSetting);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("sort_list", sortList);
        treeMap.put("radius_list", radiusList);
        treeMap.put("setting_list", settingList);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeFormPost(host, urlParams, treeMap, callback);
    }

    public void getScenicInfo(@NotNull String tuid, @NotNull String uuid, @NotNull String lat, @NotNull String lon, String cityName,
                              @NotNull String radius, String sort, String keyWord, Callback callback) {
        String host = getUrl(Constant.API.ScenicInfo);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("lat", lat);
        treeMap.put("lon", lon);
        if (notNullOrEmpty(cityName)) {
            treeMap.put("cityName", cityName);
        }
        treeMap.put("radius", radius);
        if (notNullOrEmpty(sort)) {
            treeMap.put("sort", sort);
        }
        if (notNullOrEmpty(keyWord)) {
            treeMap.put("keyword", keyWord);
        }
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void getScenicDetail(@NotNull String tuid, @NotNull String uuid, @NotNull String scenicId, Callback callback) {
        String host = getUrl(Constant.API.ScenicDetail);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[SCENICID]", scenicId);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        urlParams.put("scenicid", scenicId);
        executeGet(host, urlParams, null, callback);
    }

    public void getScenicInCity(@NotNull String tuid, @NotNull String uuid, @NotNull String cityName, Callback callback) {
        String host = getUrl(Constant.API.ScenicInCity);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> treeMap = getStrMap();
        treeMap.put("cityName", cityName);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, treeMap, callback);
    }

    public void getScenicSetting(@NotNull String tuid, @NotNull String uuid, Callback callback) {
        String host = getUrl(Constant.API.ScenicSetting);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, null, callback);
    }

    public void setScenicSetting(@NotNull String tuid, @NotNull String uuid, String sortList, String radiusList, Callback callback) {
        String host = getUrl(Constant.API.ScenicSetting);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        TreeMap<String, Object> params = getStrMap();
        params.put("sort_list", sortList);
        params.put("radius_list", radiusList);
        executeFormPost(host, urlParams, params, callback);
    }

    public void getSmartNavi(@NotNull String tuid, @NotNull String uuid, Callback callback) {
        String host = getUrl(Constant.API.SmartNavi);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        executeGet(host, urlParams, null, callback);
    }

    public void getMovieHotToday(@NotNull String tuid, @NotNull String uuid, String cityName, Callback callback) {
        String host = getUrl(Constant.API.MovieHotToday);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        TreeMap<String, Object> params = getStrMap();
        params.put("cityName", cityName);
        executeGet(host, urlParams, params, callback);
    }

    public void getMovieInfo(@NotNull String tuid, @NotNull String uuid, String movidId, Callback callback) {
        String host = getUrl(Constant.API.MovieInfo);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        host = host.replace("[MOVIEID]", movidId);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        urlParams.put("movie", movidId);
        executeGet(host, urlParams, null, callback);
    }

    public void getMovieCinema(@NotNull String tuid, @NotNull String uuid, String lat, String lon, String radius, Callback callback) {
        String host = getUrl(Constant.API.MovieCinema);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        TreeMap<String, Object> params = getStrMap();
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("radius", radius);
        executeGet(host, urlParams, params, callback);
    }

    public void getMovieScheduleInCinema(@NotNull String tuid, @NotNull String uuid, String cinemaId, String movieId, Callback callback) {
        String host = getUrl(Constant.API.MovieScheduleInCinema);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        TreeMap<String, Object> params = getStrMap();
        params.put("cinemaId", cinemaId);
        params.put("movieId", movieId);
        executeGet(host, urlParams, params, callback);
    }

    public void getMovieOnCinema(@NotNull String tuid, @NotNull String uuid, @NotNull String cityName, @NotNull String movieId, @NotNull String lat, @NotNull String lon, Callback callback) {
        String host = getUrl(Constant.API.MovieOnCinema);
        host = host.replace("[TUID]", tuid);
        host = host.replace("[UUID]", uuid);
        TreeMap<String, Object> urlParams = getStrMap();
        urlParams.put("tuid", tuid);
        urlParams.put("uuid", uuid);
        TreeMap<String, Object> params = getStrMap();
        params.put("cityName", cityName);
        params.put("movieId", movieId);
        params.put("lat", lat);
        params.put("lon", lon);
        executeGet(host, urlParams, params, callback);
    }

    /*****************************************************************************/

    private String getCheckCode(TreeMap<String, Object> treeMap, long requestTime) {
        Set<Map.Entry<String, Object>> entries = treeMap.entrySet();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mAccessToken);
        for (Map.Entry<String, Object> entry : entries) {
            String value = String.valueOf(entry.getValue());
            LogUtil.i(TAG, "value: " + value);
            stringBuffer.append(value);
        }
        stringBuffer.append(requestTime);
        LogUtil.i(TAG, "encrypt data: " + stringBuffer.toString());
        return md5(stringBuffer.toString());
    }

    private String md5(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean notNullOrEmpty(String data) {
        return !(data == null || data.isEmpty());
    }

    private void addCheckCode(TreeMap<String, Object> urlParam, TreeMap<String, Object> params) {
        long time = System.currentTimeMillis() / 1000;
        urlParam.putAll(params);
        String checkCode = getCheckCode(urlParam, time);
        params.put("checkCode", checkCode);
        // 放在后面，不要把requestTime重复放到MD5计算里面
        params.put("requestTime", String.valueOf(time));
    }
    private void executeGet(String url, TreeMap<String, Object> urlParam, TreeMap<String, Object> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = null;
        try {
            httpUrlBuilder = HttpUrl.get(new URL(url)).newBuilder();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (params == null) {
            params = getStrMap();
        }
        addCheckCode(urlParam, params);
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String key, value;
                key = entry.getKey();
                value = String.valueOf(entry.getValue());
                LogUtil.i(TAG, "get param key: " + key + ", value: " + value);
                httpUrlBuilder.addQueryParameter(key, URLEncoder.encode(value, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request request = new Request.Builder()
                .url(httpUrlBuilder.toString()).build();
        Call call = getOkHttpClient().newCall(request);
        call.enqueue(callback);
    }

    private void executeFormPost(String url, TreeMap<String, Object> urlParams, TreeMap<String, Object> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = null;
        try {
            httpUrlBuilder = HttpUrl.get(new URL(url)).newBuilder();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        FormBody.Builder builder = new FormBody.Builder();
        if (params == null) {
            params = getStrMap();
        }
        addCheckCode(urlParams, params);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
            builder.addEncoded(entry.getKey(), String.valueOf(entry.getValue()));
        }

        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request.Builder request = new Request.Builder()
                .url(httpUrlBuilder.toString())
                .post(builder.build());
        Call call = getOkHttpClient().newCall(request.build());
        call.enqueue(callback);
    }

    private void executeFormPut(String url, TreeMap<String, Object> urlParams, TreeMap<String, Object> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = null;
        try {
            httpUrlBuilder = HttpUrl.get(new URL(url)).newBuilder();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        FormBody.Builder builder = new FormBody.Builder();

        if (params == null) {
            params = getStrMap();
        }

        addCheckCode(urlParams, params);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
            builder.addEncoded(entry.getKey(), String.valueOf(entry.getValue()));
        }

        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request.Builder request = new Request.Builder()
                .url(httpUrlBuilder.toString())
                .put(builder.build());
        Call call = getOkHttpClient().newCall(request.build());
        call.enqueue(callback);
    }

    private void executeDelete(String url, TreeMap<String, Object> urlParams, TreeMap<String, Object> params, Callback callback) {
        HttpUrl.Builder httpUrlBuilder = null;
        try {
            httpUrlBuilder = HttpUrl.get(new URL(url)).newBuilder();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        FormBody.Builder builder = new FormBody.Builder();

        if (params == null) {
            params = getStrMap();
        }

        addCheckCode(urlParams, params);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            LogUtil.i(TAG, "get param key: " + entry.getKey() + ", value: " + entry.getValue());
            builder.addEncoded(entry.getKey(), String.valueOf(entry.getValue()));
        }
        LogUtil.i(TAG, "httpUrl: " + httpUrlBuilder.toString());
        Request.Builder request = new Request.Builder()
                .url(httpUrlBuilder.toString())
                .delete(builder.build());
        Call call = getOkHttpClient().newCall(request.build());
        call.enqueue(callback);
    }

    private TreeMap<String, Object> getStrMap() {
        return new TreeMap<String, Object>();
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

    public class AddHeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("Cookie",
                            "customer_key=" + mCustomerKey
                                    + ";access_token=" + mAccessToken)
                    .build();
            return chain.proceed(request);
        }
    }
}
