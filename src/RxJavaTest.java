import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import util.LogUtil;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    private static final String TAG = "RxJavaTest";

    public void interval(){
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogUtil.i(TAG, "interval");
                    }
                });
    }
}
