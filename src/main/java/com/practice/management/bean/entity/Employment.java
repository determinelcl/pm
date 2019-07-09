package com.practice.management.bean.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 就业
 */
public class Employment {
    private Long id;

    @NotBlank(message = "工作企业不能为空")
    private String name;
    @NotBlank(message = "城市不能为空")
    private String city;
    @NotBlank(message = "邮编不能为空")
    private String post;
    @NotNull(message = "薪资不能为空")
    private Integer salary;
    private Date addTime;
    @NotBlank(message = "备注不能为空")
    private String remarks;
    @NotNull(message = "实习企业不能为空")
    private Long enterpriseId;
    @NotNull(message = "学生id不能为空")
    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
