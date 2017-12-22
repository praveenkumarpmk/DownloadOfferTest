package app.newskaro.com.newskaro.shownews.presentation.ui;

import android.support.annotation.Keep;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.newskaro.com.newskaro.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class OfferShowHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.imgNews)
    public ImageView imgNews;

    @BindView(R.id.tvOfferDescription)
    public TextView tvNewsDescription;

    @BindView(R.id.tvMerchantName)
    public TextView tvMerchantName;


    @Keep
    public OfferShowHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }
}
