package com.viettel.asset.dto.search;

import com.viettel.asset.dto.BaseSearchDto;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetHandOverSearchDto extends BaseSearchDto {
    private Date fromHandoverDate;
    private Date toHandoverDate;
    private String handoverCode;

    public Date getFromHandoverDate() {
        return fromHandoverDate;
    }

    public void setFromHandoverDate(Date fromHandoverDate) {
        this.fromHandoverDate = fromHandoverDate;
    }

    public Date getToHandoverDate() {
        return toHandoverDate;
    }

    public void setToHandoverDate(Date toHandoverDate) {
        this.toHandoverDate = toHandoverDate;
    }

    public String getHandoverCode() {
        return handoverCode;
    }

    public void setHandoverCode(String handoverCode) {
        this.handoverCode = handoverCode;
    }
}
