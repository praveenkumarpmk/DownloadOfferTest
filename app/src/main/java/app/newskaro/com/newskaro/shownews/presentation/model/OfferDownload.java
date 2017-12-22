package app.newskaro.com.newskaro.shownews.presentation.model;

import java.io.Serializable;

/**
 * Created by EE209278 on 10-12-2017.
 */

public class OfferDownload implements Serializable {

    private static final long serialVersionUID = -7992805788767616442L;
    private int imgId;
    private String description;
    private String merchantName;

    public OfferDownload(int imgId, String description, String merchantName) {
        this.imgId = imgId;
        this.description = description;
        this.merchantName = merchantName;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OfferDownload{");
        sb.append("imgId=").append(imgId);
        sb.append(", description='").append(description).append('\'');
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
