package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdSrTaskDto {
    @NotNull(message = "学校老师id不能为空")
    private Long srId;
    @NotNull(message = "任务书id不能为空")
    private Long taskId;
    @NotBlank(message = "学校审核意见不能为空")
    private String schoolExamine;

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getSchoolExamine() {
        return schoolExamine;
    }

    public void setSchoolExamine(String schoolExamine) {
        this.schoolExamine = schoolExamine;
    }
}
