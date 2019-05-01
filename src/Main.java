
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.NetPresenter;
import net.bean.BaseBean;
import net.bean.WeatherInfoBean;
import net.bean.delicacy.SettingBean;
import net.util.Constant;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.LogUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Scanner;

public class Main {
    private static final String TAG = "Main";

    public static void main(String[] args) {
        Gson gson = new Gson();
        String tuid = Constant.CUSTOMER_KEY;
        String uuid = "595166";
        String lat = "39.872748";
        String lon = "116.429718";

        NetPresenter netPresenter = new NetPresenter();
//        String classId = "1";
//        netPresenter.getChargingStationSetting(tuid, uuid, classId, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                LogUtil.i(TAG, "getChargingStationSetting: failure: ");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                LogUtil.i(TAG, "getChargingStationSetting: response.body: " + response.body().string());
//            }
//        });

//        netPresenter.getScenicInfo(tuid, uuid, lat, lon, "", "1000", "2", "",
//                new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                        LogUtil.i(TAG, "getScenicInfo: failure: ");
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        LogUtil.i(TAG, "getScenicInfo: response.body: " + response.body().string());
//                    }
//                });
        netPresenter.getScenicInCity(tuid, uuid, "上海", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getScenicInCity: failure: ");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getScenicInCity: response.body: " + response.body().string());
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
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void runDemo(NetPresenter netPresenter, Gson gson) {
        String tuid = Constant.CUSTOMER_KEY;
        String uuid = "595166";
        String lat = "39.872748";
        String lon = "116.429718";

        netPresenter.getUserInfo(tuid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getUserInfo: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getUserInfo: response.body: " + response.body().string());
            }
        });

        netPresenter.getRescue(tuid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getRescue: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getRescue: response.body: " + response.body().string());
            }
        });

        netPresenter.getWeatherInfo(tuid, "银川", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getWeatherInfo: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                LogUtil.i(TAG, "getWeatherInfo: response.body: " + data);
                Type type = new TypeToken<BaseBean<WeatherInfoBean>>() {
                }.getType();
                BaseBean<WeatherInfoBean> bean = gson.fromJson(data, type);
                LogUtil.i(TAG, "getWeatherInfo: " + bean.getResp_data().getCity_name());
            }
        });

        netPresenter.getParkingLots(tuid, lat, lon, "5000",
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

        netPresenter.getDelicacy(tuid, uuid, lat, lon,
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

        netPresenter.getDelicacyDetail(tuid, uuid, "RKzw3cqM4npabtqF9r1b3A",
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

        netPresenter.getDelicacySetting(tuid, uuid, "1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getDelicacySetting: failure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Type type = new TypeToken<BaseBean<SettingBean>>() {
                }.getType();
                BaseBean<SettingBean> bean = gson.fromJson(data, type);
                SettingBean settingBean = bean.getResp_data();
                LogUtil.i(TAG, "getDelicacySetting: setting list size: " + settingBean.getSetting_list().size());
            }
        });

        String settingList = "[{\"class_id\":3,\"name\":\"特色菜\",\"id\":11,\"sort\":1,\"selected\":1},{\"class_id\":3,\"name\":\"自助餐\",\"id\":12,\"sort\":2,\"selected\":1},{\"class_id\":3,\"name\":\"海鲜\",\"id\":13,\"sort\":3,\"selected\":0},{\"class_id\":3,\"name\":\"火锅\",\"id\":14,\"sort\":4,\"selected\":0},{\"class_id\":3,\"name\":\"烧烤烤肉\",\"id\":15,\"sort\":5,\"selected\":0},{\"class_id\":3,\"name\":\"日本菜\",\"id\":16,\"sort\":6,\"selected\":0},{\"class_id\":3,\"name\":\"韩国料理\",\"id\":17,\"sort\":7,\"selected\":0}]";
        String sortList = "[{\"class_id\":1,\"name\":\"默认\",\"id\":1,\"sort\":1,\"selected\":1},{\"class_id\":1,\"name\":\"星级优先\",\"id\":2,\"sort\":2,\"selected\":0},{\"class_id\":1,\"name\":\"产品优先\",\"id\":3,\"sort\":3,\"selected\":0},{\"class_id\":1,\"name\":\"环境优先\",\"id\":4,\"sort\":4,\"selected\":0},{\"class_id\":1,\"name\":\"服务优先\",\"id\":5,\"sort\":5,\"selected\":0},{\"class_id\":1,\"name\":\"点评优先\",\"id\":6,\"sort\":6,\"selected\":0},{\"class_id\":1,\"name\":\"距离优先\",\"id\":7,\"sort\":7,\"selected\":0},{\"class_id\":1,\"name\":\"人均最低\",\"id\":8,\"sort\":8,\"selected\":0},{\"class_id\":1,\"name\":\"人均最高\",\"id\":9,\"sort\":9,\"selected\":0}]";
        String radiusList = "[{\"class_id\":2,\"name\":\"2000米\",\"id\":10,\"sort\":1,\"selected\":1}]";
        netPresenter.setDelicacySetting(tuid, uuid, sortList, radiusList, settingList, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "setDelicacySetting: failure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "setDelicacySetting: response.body: " + response.body().string());
            }
        });

        String[] strArrays = new String[]{"", "", ""};
        netPresenter.getChargingStation(tuid, uuid, lat, lon, "1", "10", strArrays, strArrays,
                strArrays, strArrays, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        LogUtil.i(TAG, "getChargingStation: failure");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtil.i(TAG, "getChargingStation: response.body: " + response.body().string());
                    }
                });

        String stationId = "6c616bf6-361e-4504-98aa-11ef8e691382";
        netPresenter.getChargingStationDetail(tuid, uuid, stationId, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "getChargingStationDetail: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "getChargingStationDetail: response.body: " + response.body().string());
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

        netPresenter.updateSchedule(tuid, "334", "吃火锅", "吃八合里牛肉火锅", "2019-02-02 12:10:00", "1",
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

        netPresenter.deleteSchedule(tuid, "334", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.i(TAG, "deleteSchedule: failure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.i(TAG, "deleteSchedule: response.body: " + response.body().string());
            }
        });

    }
}
