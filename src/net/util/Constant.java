package net.util;

public class Constant {
    // TODO: 2019/5/7 CUSTOMER_KEY 和 ACCESS_TOKEN需要传进来，需要后续优化该问题
    public static final String API_HOST = "http://139.224.168.205/tsp-app";
    //    public static final String CUSTOMER_KEY = "10001000128955928056212695513590";
    public static final String CUSTOMER_KEY = "10001000148275218406519372601808";
    //    public static final String ACCESS_TOKEN = "649cad18d320f3f042d677bd1506d06c";
    public static final String ACCESS_TOKEN = "590c1e1126e7cca3f260725ede54b4e8";

    public interface API {
        String UserInfo = "tu/[TUID]/user/info";
        String ParkingLots = "tu/[TUID]/park_lots/list";
        String Rescue = "tu/[TUID]/rescue/info";
        String WeatherInfo = "tu/[TUID]/weather/info";
        String Delicacy = "tu/[TUID]/user/[UUID]/delicacy/poi";
        String DelicacyDetail = "tu/[TUID]/user/[UUID]/delicacy/poi/[OPENSHOPID]";
        String DelicacySetting = "tu/[TUID]/user/[UUID]/delicacy/setting";
        String Schedule = "user/[UUID]/schedule";
        String ScheduleWithId = "user/[UUID]/schedule/[ID]";
        String ChargingStation = "tu/[TUID]/user/[UUID]/station/poi";
        String ChargingStationDetail = "tu/[TUID]/user/[UUID]/station/poi/[STATIONID]";
        String ChargingStationSetting = "tu/[TUID]/user/[UUID]/station/setting";
        String ScenicInfo = "tu/[TUID]/user/[UUID]/scenic/poi";
        String ScenicDetail = "tu/[TUID]/user/[UUID]/scenic/poi/[SCENICID]";
        String ScenicInCity = "tu/[TUID]/user/[UUID]/scenic/list/info";
        String ScenicSetting = "tu/[TUID]/user/[UUID]/scenic/setting";
        String SmartNavi = "tu/[TUID]/user/[UUID]/wsidom/navigation";
        String MovieHotToday = "tu/[TUID]/user/[UUID]/movie/list";
        String MovieInfo = "tu/[TUID]/user/[UUID]/movie/info/[MOVIEID]";
        String MovieCinema = "tu/[TUID]/user/[UUID]/cinema/poi";
        String MovieScheduleInCinema = "tu/[TUID]/user/[UUID]/movie/poi/info";
        String MovieOnCinema = "tu/[TUID]/user/[UUID]/movie/cinema/list";
    }
}
