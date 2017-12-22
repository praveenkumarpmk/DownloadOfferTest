package app.newskaro.com.newskaro.shownews.presentation.ui;

import app.newskaro.com.newskaro.shownews.presentation.model.OfferDownload;


public interface OfferScreen {

    OfferDownload getNewsDownload();

    void setNewsDownload(OfferDownload newsDownload);

    void showNewsInDetailFragment();


}
