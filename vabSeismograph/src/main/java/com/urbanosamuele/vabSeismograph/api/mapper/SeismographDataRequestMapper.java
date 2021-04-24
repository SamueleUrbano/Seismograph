package com.urbanosamuele.vabSeismograph.api.mapper;

import com.urbanosamuele.vabSeismograph.model.SeismographData;

import java.util.ArrayList;
import java.util.List;

public class SeismographDataRequestMapper {

    private String apiKey;
    private List<SeismographData> seismographData = new ArrayList<>();

    public SeismographDataRequestMapper() {

    }

    public SeismographDataRequestMapper(String apiKey, List<SeismographData> seismographData) {
        this.apiKey = apiKey;
        this.seismographData = seismographData;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<SeismographData> getSeismographData() {
        return seismographData;
    }

    public void setSeismographData(List<SeismographData> seismographData) {
        this.seismographData = seismographData;
    }

    @Override
    public String toString() {
        return "SeismographDataRequestMapper{" +
                "apiKey='" + apiKey + '\'' +
                ", seismographData=" + seismographData +
                '}';
    }
}
