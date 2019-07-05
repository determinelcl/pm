package com.practice.management.bean.dto;

import com.practice.management.bean.entity.TrainSummary;
import org.springframework.web.multipart.MultipartFile;

public class AddTrainSummaryDto extends TrainSummary {
    private MultipartFile trainReport;
    private MultipartFile trainDesign;

    public MultipartFile getTrainReport() {
        return trainReport;
    }

    public void setTrainReport(MultipartFile trainReport) {
        this.trainReport = trainReport;
    }

    public MultipartFile getTrainDesign() {
        return trainDesign;
    }

    public void setTrainDesign(MultipartFile trainDesign) {
        this.trainDesign = trainDesign;
    }
}
