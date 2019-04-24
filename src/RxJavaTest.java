import io.reactivex.*;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import util.LogUtil;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    private static final String TAG = "RxJavaTest";
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void interval() {
        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .map(new Function<Long, String>() {
                    @Override
                    public String apply(Long aLong) throws Exception {
                        return String.valueOf(aLong);
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String aString) throws Exception {
                        LogUtil.i(TAG, "interval: " + aString);
                    }
                });
        mCompositeDisposable.add(disposable);
    }
    public void destory() {
        mCompositeDisposable.dispose();
    }
}
