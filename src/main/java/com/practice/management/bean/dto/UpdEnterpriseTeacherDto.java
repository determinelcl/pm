package com.practice.management.bean.dto;

public class UpdEnterpriseTeacherDto {
    /**
     * 企业负责人id
     */
    private Long erId;
    /**
     * 企业老师id
     */
    private Long etId;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String rank;
    private String remarks;
    private String roleId;


    public Long getErId() {
        return erId;
    }

    public void setErId(Long erId) {
        this.erId = erId;
    }

    public Long getEtId() {
        return etId;
    }

    public void setEtId(Long etId) {
        this.etId = etId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
