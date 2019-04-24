package net.util;

public class Constant {
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
        String Schedule = "user/[UUID]/schedule";
        String ScheduleWithId = "user/[UUID]/schedule/[ID]";
    }
}
