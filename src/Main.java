
import util.LogUtil;

import java.util.Scanner;

public class Main {
    private static final String TAG = "Main";

    public static void main(String[] args) {
        RxJavaTest rxJavaTest = new RxJavaTest();
        rxJavaTest.interval();
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
