package com.who.tracker.gpstracker;

import android.util.Log;

import com.who.tracker.gpstracker.request.CellTower;
import com.who.tracker.gpstracker.request.RequestGApi;
import com.who.tracker.gpstracker.response.ResponseGApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

import static com.who.tracker.gpstracker.Constant.BASE_URL;

/**
 * Created by Raffi on 12/26/2016.
 */

public class MainPresenter implements MainContract.Presenter {

    private final String TAG = this.getClass().getSimpleName();
    private RestApi restApi;

    private Subscription subscription = Subscriptions.empty();
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        restApi = retrofit.create(RestApi.class);

        this.view = view;
    }

    @Override
    public void findLocation(String mcc, String mnc, String lac, String cid) {
        sendRequestToServer(
                createRequestGApi(mcc, mnc, lac, cid)
        );
    }

    private RequestGApi createRequestGApi(String mcc, String mnc, String lac, String cid) {
        CellTower cellTower = new CellTower(
                Integer.parseInt(mcc),
                Integer.parseInt(mnc),
                Integer.parseInt(lac),
                Integer.parseInt(cid));

        RequestGApi requestGApi = new RequestGApi();
        requestGApi.getCellTowers().add(cellTower);
        return requestGApi;
    }

    private void sendRequestToServer(RequestGApi requestGApi) {
        Log.d(TAG, "sendRequestToServer: " + requestGApi.getCellTowers().toString());
        subscription = restApi.getLocation(requestGApi)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new LocationSubscriber());
    }

    public void unsubscribe() {
        if(!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    private final class LocationSubscriber extends Subscriber<ResponseGApi> {
        @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted: ");
        }

        @Override
        public void onError(Throwable e) {
            view.errorOccur(e.getMessage());
        }

        @Override
        public void onNext(ResponseGApi responseGApi) {
            Log.d(TAG, "onNext: " + responseGApi.getLocationGApi().getLat() + " "
                    + responseGApi.getLocationGApi().getLng());
            view.retrieveLocation(responseGApi.getLocationGApi().getLat(),
                    responseGApi.getLocationGApi().getLng()
            );
        }
    }
}
