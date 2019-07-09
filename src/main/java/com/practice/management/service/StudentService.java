package com.practice.management.service;

import com.practice.management.bean.dto.AddStudentDto;
import com.practice.management.bean.dto.UpdSrStudentDto;
import com.practice.management.bean.dto.UpdStudentDto;
import com.practice.management.bean.entity.Student;

public interface StudentService {
    /**
     * 学校负责人添加学生信息
     *
     * @param dto 学生信息对象
     * @return 学生对象
     */
    Student addStudent(AddStudentDto dto);

    /**
     * 根据id查询学生
     *
     * @param stuId 学生id
     * @return 学生对象
     */
    Student findById(Long stuId);

    /**
     * 学生更新个人信息
     * 角色：学生
     *
     * @param dto 学生更新的信息dto
     * @return 更新之后的学生信息对象
     */
    Student updStudent(UpdStudentDto dto);

    /**
     * 学校老师更新学生信息
     * 角色：学校负责人/学校老师
     *
     * @param dto 学生更新的信息dto
     * @return 更新之后的学生信息对象
     */
    Student updStudentBySr(UpdSrStudentDto dto);

    /**
     * 学校老师根据指定的学生id删除学生
     * 角色：学校负责人
     *
     * @param srId  学校负责人id
     * @param stuId 学生id
     * @return 删除的学校老师信息
     */
    Student deleteById(Long srId, Long stuId);

    /**
     * 根据学校id和学生账号查询学生信息
     *
     * @param scId  学校id
     * @param account 学生账号
     * @return 学生信息
     */
    Student findByScIdAndAccount(Long scId, String account);
}
