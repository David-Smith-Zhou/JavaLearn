package util;

public class LogUtil {
    private static final boolean isShow = true;

    private static final int LEVEL_DEBUG = 0x21;
    private static final int LEVEL_INFO = 0x22;
    private static final int LEVEL_WARING = 0x23;
    private static final int LEVEL_ERROR = 0x24;

    public static void i(String tag, String msg) {
        log(LogUtil.LEVEL_INFO, tag, msg);
    }
    public static void d(String tag, String msg) {
        log(LogUtil.LEVEL_DEBUG, tag, msg);
    }
    public static void w(String tag, String msg) {
        log(LogUtil.LEVEL_WARING, tag, msg);
    }
    public static void e(String tag, String msg) {
        log(LogUtil.LEVEL_ERROR, tag, msg);
    }

    private static void log(int level, String tag, String msg) {
        if (isShow) {
            logToConsole(level, tag, msg);
        }
    }
    private static void logToConsole(int level, String tag, String msg) {
        switch (level) {
            case LEVEL_DEBUG:
                print("DEBUG", tag, msg);
                break;
            case LEVEL_ERROR:
                print("ERROR", tag, msg);
                break;
            case LEVEL_WARING:
                print("WARING", tag, msg);
                break;
            default:
                print("INFO", tag, msg);
                break;
        }
    }
    private static void print(String level, String tag, String msg) {
        String threadName = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        System.out.print("[Thread Name: " + threadName + ", "  + "Id: " + id + "][" + level + "][" + tag + "]: " + msg + '\n');
    }
}
