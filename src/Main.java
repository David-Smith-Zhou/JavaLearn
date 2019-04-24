
import net.NetPresenter;
import net.util.Constant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.LogUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String TAG = "Main";

    public static void main(String[] args) {
        String uuid = "595166";
        String lat = "39.872748";
        String lon = "116.429718";

        NetPresenter netPresenter = new NetPresenter();

        netPresenter.getUserInfo(Constant.CUSTOMER_KEY, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getUserInfo: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getUserInfo: response.body: " + response.body().string());
            }
        });

        netPresenter.getRescue(Constant.CUSTOMER_KEY, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getRescue: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getRescue: response.body: " + response.body().string());
            }
        });

        netPresenter.getWeatherInfo(Constant.CUSTOMER_KEY, "银川", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getWeatherInfo: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getWeatherInfo: response.body: " + response.body().string());
            }
        });

        netPresenter.getParkingLots(Constant.CUSTOMER_KEY, lat, lon, "5000",
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtil.i(TAG, "getParkingLots: failure: ");

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtil.i(TAG, "getParkingLots: response.body: " + response.body().string());

                    }
                });

        netPresenter.getDelicacy(Constant.CUSTOMER_KEY, uuid, lat, lon,
                null, null, null, null,
                new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getDelicacy: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getDelicacy: response.body: " + response.body().string());
            }
        });

        netPresenter.getDelicacyDetail(Constant.CUSTOMER_KEY, uuid, "RKzw3cqM4npabtqF9r1b3A",
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtil.i(TAG, "getDelicacyDetail: failure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtil.i(TAG, "getDelicacyDetail: response.body: " + response.body().string());
                    }
                });

        netPresenter.createSchedule(uuid, "看电影", "看阿凡达", "2019-01-01 00:00:11", "1",
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtil.i(TAG, "createSchedule: failure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtil.i(TAG, "createSchedule: response.body: " + response.body().string());
                    }
                });

        netPresenter.getScheduleList(uuid, null, null, "2019", null, null, null,
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtil.i(TAG, "getScheduleList: failure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtil.i(TAG, "getScheduleList: response.body: " + response.body().string());
                    }
                });

        netPresenter.updateSchedule(Constant.CUSTOMER_KEY, "334", "吃火锅", "吃八合里牛肉火锅", "2019-02-02 12:10:00", "1",
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtil.i(TAG, "updateSchedule: failure: ");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtil.i(TAG, "updateSchedule: response.body: " + response.body().string());
                    }
                });

        netPresenter.deleteSchedule(Constant.CUSTOMER_KEY, "334", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "deleteSchedule: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "deleteSchedule: response.body: " + response.body().string());
            }
        });

        String exitStr = "1";
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            String next = sc.next();
            LogUtil.i(TAG, "sc.next: " + next);
            if (exitStr.equals(next)) {
                flag = false;
            }
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
