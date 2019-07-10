package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddTaskDto;
import com.practice.management.bean.dto.UpdErTaskDto;
import com.practice.management.bean.dto.UpdSrTaskDto;
import com.practice.management.bean.dto.UpdStuTaskDto;
import com.practice.management.bean.entity.*;
import com.practice.management.bean.model.TaskQueryModel;
import com.practice.management.constant.FileConstant;
import com.practice.management.mapper.TaskBookMapper;
import com.practice.management.service.*;
import com.practice.management.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TaskBookServiceImpl implements TaskBookService {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private TaskBookMapper taskBookMapper;

    @Autowired
    private SchoolResponsibilityService srService;

    @Autowired
    private EnterpriseResponsibilityService erSerVice;

    @Autowired
    private FileService fileService;

    @Override
    public Task add(AddTaskDto dto) {
        Student student = studentService.findById(dto.getStudentId());
        Major major = majorService.findById(student.getMajorId());
        dto.setSchoolId(major.getSchoolId());
        if (!dto.getEnterpriseId().equals(student.getEnterpriseId()))
            throw new RuntimeException("提交的任务书关联的企业不属于学生实习的企业");

        Date submitTime = new Date();
        dto.setSubmitTime(submitTime);
        dto.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

        dto.setSchoolId(major.getSchoolId());
        dto.setStudentId(student.getId());

        // 存储上传的任务书附件
        String identification = major.getSchoolId() + "_" + student.getEnterpriseId() + "_" + student.getAccount();
        String filename = fileService.saveFile(dto.getEnclosureFile(), identification);
        dto.setEnclosureUrl(filename);

        taskBookMapper.insert(dto);

        return taskBookMapper.findById(dto.getId());
    }

    @Override
    public Task findById(Long taskId) {
        Task task = taskBookMapper.findById(taskId);
        if (task == null)
            throw new RuntimeException("任务书id:" + taskId + "不存在！");

        return task;
    }

    @Override
    public Task updateByStu(UpdStuTaskDto dto) {
        Long stuId = dto.getStuId();
        Long taskId = dto.getTaskId();
        Task task = validateTaskAuthority(stuId, taskId);

        // 是否上传文件
        if (dto.getEnclosureFile() != null) {
            Student student = studentService.findById(stuId);
            Long schoolId = task.getSchoolId();
            String identification = schoolId + "_" + task.getEnterpriseId() + "_" + student.getAccount();
            String filename = fileService.saveFile(dto.getEnclosureFile(), identification);
            dto.setEnclosureUrl(filename);
        } else
            dto.setEnclosureUrl(task.getEnclosureUrl());

        taskBookMapper.updateByStu(dto);
        return taskBookMapper.findById(dto.getTaskId());
    }

    /**
     * 验证学生操作任务书的权限
     *
     * @param stuId  学生id
     * @param taskId 任务书id
     * @return 任务书对象
     */
    private Task validateTaskAuthority(Long stuId, Long taskId) {
        Task task = findById(taskId);
        if (!task.getStudentId().equals(stuId))
            throw new RuntimeException("学生没有任务书:" + task.getProjectName() + "的权限");
        return task;
    }

    @Override
    public Task updateBySr(UpdSrTaskDto dto) {
        SchoolResponsibility sr = srService.findById(dto.getSrId());
        Task task = findById(dto.getTaskId());
        if (!sr.getSchoolId().equals(task.getSchoolId()))
            throw new RuntimeException("学校负责人:" + sr.getName() + "没有权限审核任务书:" + task.getId());

        taskBookMapper.updateBySr(dto);
        return findById(dto.getTaskId());
    }

    @Override
    public Task updateByEr(UpdErTaskDto dto) {
        EnterpriseResponsibility er = erSerVice.findById(dto.getErId());
        Task task = findById(dto.getTaskId());
        if (!er.getEnterpriseId().equals(task.getEnterpriseId()))
            throw new RuntimeException("企业负责人:" + er.getName() + "对任务书:" + task.getId() + "没有操作权限");

        taskBookMapper.updateByEr(dto);
        return findById(dto.getTaskId());
    }

    @Override
    public Task deleteById(Long stuId, Long taskId) {
        Task task = validateTaskAuthority(stuId, taskId);

        taskBookMapper.deleteById(taskId);
        return task;
    }

    @Override
    public List<Task> queryByCondition(TaskQueryModel queryCondition) {
        List<Task> taskList = taskBookMapper.queryByCondition(queryCondition);
        taskList.forEach(task -> task.setEnclosureUrl(
                FileUtil.getFileDownloadUri(task.getEnclosureUrl(), FileConstant.FILE_DOWNLOAD_URI)));
        return taskList;
    }
}
