package com.who.tracker.gpstracker;

/**
 * Created by maunorafiq on 12/27/16.
 */

public interface MainContract {

    interface View {

        void retrieveLocation(double lat, double lon);

        void errorOccur(String message);
    }

    interface Presenter {

        void findLocation(String mcc, String mnc, String lac, String cid);

        void unsubscribe();
    }
}
