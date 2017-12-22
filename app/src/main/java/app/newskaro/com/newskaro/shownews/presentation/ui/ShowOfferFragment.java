package app.newskaro.com.newskaro.shownews.presentation.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.newskaro.com.newskaro.R;
import app.newskaro.com.newskaro.core.RecyclerAdapter;
import app.newskaro.com.newskaro.shownews.presentation.model.OfferDownload;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ShowOfferFragment extends Fragment {

    @BindView(R.id.rvOfferShow)
    RecyclerView rvOfferShow;


    List<OfferDownload> offerDownloadList = new ArrayList<>();
    private RecyclerAdapter<OfferDownload, OfferShowHolder> baseRecyclerAdapter;
    private Context context;
    private OfferScreen newsScreen;

    public static ShowOfferFragment newInstance() {

        ShowOfferFragment fragment = new ShowOfferFragment();
        return fragment;
    }

    //Listener
    private RecyclerAdapter.BindAdapterListener<OfferShowHolder> offerNotificationListener =
            new RecyclerAdapter.BindAdapterListener<OfferShowHolder>() {
                @Override
                public void onBind(OfferShowHolder holder, final int position) {
                    holder.tvNewsDescription.setText(getDescription(position));
                    holder.tvMerchantName.setText(getMerchantname(position));
                    holder.imgNews.setImageResource(getImage(position));
                    holder.itemView.setTag(position);
                    holder.itemView.setOnClickListener(itemSelectListener);
                }
            };

    private View.OnClickListener itemSelectListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (int) view.getTag();
            newsScreen.setNewsDownload(offerDownloadList.get(position));
            //  newsScreen.showNewsInDetailFragment();

        }
    };


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
        View view = inflater.inflate(R.layout.nkshowfragment, container, false);
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

        OfferDownload newsDownload = new OfferDownload(R.drawable.offer_one, " Get a complementary coffee latte free on Above Rs.250.", "Cafe Coffee day");
        OfferDownload newsDownload1 = new OfferDownload(R.drawable.offer_two, " Pasta with exotic vegetable at 20% off", "Pasta House");
        OfferDownload newsDownload2 = new OfferDownload(R.drawable.offer_three, "Delicious burgers as complementary on your next breakfast", "Truffles");
        OfferDownload newsDownload3 = new OfferDownload(R.drawable.offer_four, "  Get good chat with awesome taste", "Ameoba");

        offerDownloadList.add(newsDownload);
        offerDownloadList.add(newsDownload1);
        offerDownloadList.add(newsDownload2);
        offerDownloadList.add(newsDownload3);

        initRecyclerViews(offerDownloadList);
    }

    //Init Recyclerview
    private void initRecyclerViews(List<OfferDownload> newsDownloadList) {
        if (newsDownloadList != null && !newsDownloadList.isEmpty()) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(rvOfferShow);
            rvOfferShow.setLayoutManager(layoutManager);

            rvOfferShow.setHasFixedSize(true);
            baseRecyclerAdapter =
                    new RecyclerAdapter<>(context, newsDownloadList, offerNotificationListener, OfferShowHolder.class, R.layout.news_content_item);
            rvOfferShow.setAdapter(baseRecyclerAdapter);

        }
    }

    /*
    get Description
     */

    private String getDescription(int position) {
        String description = "";
        if (offerDownloadList != null) {
            description = offerDownloadList.get(position).getDescription();
        }
        return description;
    }

    /*
    get Merchant Name
     */
    private String getMerchantname(int position) {
        String merchantName = "";
        if (offerDownloadList != null) {
            merchantName = offerDownloadList.get(position).getMerchantName();
        }
        return merchantName;
    }

    /*
    get Food Item
     */
    private int getImage(int position) {
        int imgId = R.drawable.ic_launcher_background;
        if (offerDownloadList != null) {
            imgId = offerDownloadList.get(position).getImgId();
        }
        return imgId;
    }
}