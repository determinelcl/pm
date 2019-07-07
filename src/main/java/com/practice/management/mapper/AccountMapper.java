package com.practice.management.mapper;

import com.practice.management.bean.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Select("<script>" +
            "select * from " +
            "<if test=\"tableType == 0\"> " +
            "   admin where account=#{account} " +
            "</if> " +
            "<if test=\"tableType == 1\"> " +
            "   student where account=#{account} and major_id in (select id from major where school_id=#{id})" +
            "</if> " +
            "<if test=\"tableType == 2\"> " +
            "   schoolresponsibility where account=#{account} and school_id=#{id}" +
            "</if> " +
            "<if test=\"tableType == 3\"> " +
            "   enterpriseresponsibility where account=#{account} and enterprise_id=#{id}" +
            "</if> " +
            "</script>")
    Account findByAccount(@Param("id") Long foreignId, @Param("account") String account, @Param("tableType") int type);

    @Select("<script>" +
            "insert into " +
            "<if test=\"tableType == 1\"> " +
            "   student(name, age, gender, phone, email, account, password, classes, enterprise_id, " +
            "                           enterprise_programme_id, major_id, role_id, addtime, remarks) " +
            "   values(#{account.name}, #{account.age}, #{account.gender}, #{account.phone}, #{account.email}, " +
            "           #{account.account}, #{account.password}, #{account.classes}, #{account.enterpriseId}, " +
            "           #{account.enterpriseProgrammeId}, #{account.majorId}, #{account.roleId}, " +
            "           #{account.addTime}, #{account.remarks})" +
            "</if> " +
            "<if test=\"tableType == 2\"> " +
            "   schoolresponsibility(name, age, gender, rank, phone, email, account, password, major_id, " +
            "                                                       role_id, school_id, addtime, remarks) " +
            "   values(#{account.name}, #{account.age}, #{account.gender}, #{account.rank}, #{account.phone}, " +
            "                           #{account.email}, #{account.account}, #{account.password}, " +
            "#{account.majorId}, #{account.roleId}, #{account.schoolId}, #{account.addTime}, #{account.remarks})" +
            "</if> " +
            "<if test=\"tableType == 3\"> " +
            "   enterpriseresponsibility(name, age, gender, rank, phone, email, account, password, " +
            "                                                       enterprise_id, role_id, addtime, remarks) " +
            "   values(#{account.name}, #{account.age}, #{account.gender}, #{account.rank}, #{account.phone}, " +
            "       #{account.email}, #{account.account}, #{account.password}, #{account.enterpriseId}, " +
            "       #{account.roleId}, #{account.addTime}, #{account.remarks})" +
            "</if> " +
            "</script>")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    Long add(@Param("account") Account account, @Param("tableType") int type);
}
