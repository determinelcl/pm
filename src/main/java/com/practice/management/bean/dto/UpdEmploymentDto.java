package com.practice.management.bean.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdEmploymentDto {
    @NotNull(message = "学生id不能为空")
    private Long stuId;
    @NotNull(message = "结业统计id不能为空")
    private Long eId;

    @NotBlank(message = "工作企业不能为空")
    private String eName;
    @NotBlank(message = "城市不能为空")
    private String city;
    @NotBlank(message = "邮编不能为空")
    private String post;
    @NotNull(message = "薪资不能为空")
    private Integer salary;
    @NotBlank(message = "备注不能为空")
    private String remarks;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getEId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
