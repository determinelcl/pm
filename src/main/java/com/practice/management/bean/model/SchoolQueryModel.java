package com.practice.management.bean.model;

/**
 * 学校查询条件模型
 * <p>
 * 专业name、老师id/name
 */
public class SchoolQueryModel {

    /**
     * 学校id
     */
    private Long schoolId;

    /**
     * 学校负责人id
     */
    private Long srId;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 学校老师工号
     */
    private String teacherId;

    /**
     * 学校老师姓名
     */
    private String teacherName;


    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getSrId() {
        return srId;
    }

    public void setSrId(Long srId) {
        this.srId = srId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
