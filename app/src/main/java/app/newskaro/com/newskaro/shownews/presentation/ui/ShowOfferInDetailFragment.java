package app.newskaro.com.newskaro.shownews.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.newskaro.com.newskaro.R;
import app.newskaro.com.newskaro.shownews.presentation.model.OfferDownload;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ShowOfferInDetailFragment extends Fragment {

    @BindView(R.id.imgNews)
    public ImageView imgNews;

    @BindView(R.id.tvOfferDescription)
    public TextView tvNewsDescription;

    private Context context;
    private OfferScreen newsScreen;
    private OfferDownload newsDownload;

    public static ShowOfferInDetailFragment newInstance() {

        ShowOfferInDetailFragment fragment = new ShowOfferInDetailFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        newsScreen = (OfferScreen) context;
        setHasOptionsMenu(true);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_content_item, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initUI();

    }

    @Override
    public void onStart() {
        super.onStart();

    }


    private void initUI() {
        newsDownload = newsScreen.getNewsDownload();
        tvNewsDescription.setText(getDescription());
        imgNews.setImageResource(getImage());
        tvNewsDescription.setMaxLines(Integer.MAX_VALUE);
    }


    private String getDescription() {
        String description = "";
        if (newsDownload != null) {
            description = newsDownload.getDescription();
        }
        return description;
    }

    private int getImage() {
        int imgId = R.drawable.ic_launcher_background;
        if (newsDownload != null) {
            imgId = newsDownload.getImgId();
        }
        return imgId;
    }
}