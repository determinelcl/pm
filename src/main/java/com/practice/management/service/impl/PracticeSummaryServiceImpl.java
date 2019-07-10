package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddTrainSummaryDto;
import com.practice.management.bean.dto.UpdStuTrainSummaryDto;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.entity.Student;
import com.practice.management.bean.entity.TrainSummary;
import com.practice.management.bean.model.TrainSummaryQueryModel;
import com.practice.management.constrant.FileConstrant;
import com.practice.management.mapper.PracticeSummaryMapper;
import com.practice.management.service.FileService;
import com.practice.management.service.MajorService;
import com.practice.management.service.PracticeSummaryService;
import com.practice.management.service.StudentService;
import com.practice.management.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PracticeSummaryServiceImpl implements PracticeSummaryService {

    @Autowired
    private PracticeSummaryMapper summaryMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private FileService fileService;

    @Override
    public TrainSummary add(AddTrainSummaryDto summary) {
        Student student = studentService.findById(summary.getStudentId());
        Major major = majorService.findById(student.getMajorId());

        summary.setSchoolId(major.getSchoolId());
        summary.setStudentId(student.getId());

        // 存储上传的实训报告附件
        String identification = major.getSchoolId() + "_" + student.getEnterpriseId() + "_" + student.getAccount();
        String reportFilename = fileService.saveFile(summary.getTrainReport(), identification);
        summary.setTrainReportUrl(reportFilename);

        // 存储上传的实训设计附件
        String designFilename = fileService.saveFile(summary.getTrainDesign(), identification);
        summary.setTrainDesignUrl(designFilename);

        summaryMapper.insert(summary);

        return summaryMapper.findById(summary.getId());
    }

    @Override
    public TrainSummary findById(Long summaryId) {
        TrainSummary summary = summaryMapper.findById(summaryId);
        if (summary == null)
            throw new RuntimeException("实训总结id:" + summaryId + "不存在！");

        return summary;
    }

    @Override
    public TrainSummary updateByStu(UpdStuTrainSummaryDto dto) {
        Long stuId = dto.getStuId();
        Long tsId = dto.getTsId();
        TrainSummary summary = validateTaskAuthority(stuId, tsId);

        Student student = studentService.findById(stuId);
        // 上传实训报告文件
        dto.setTrainReportUrl(getUploadFilename(summary, dto.getTrainReport(), student));
        // 上传实训设计文件
        dto.setTrainDesignUrl(getUploadFilename(summary, dto.getTrainDesign(), student));

        summaryMapper.updateByStu(dto);
        return findById(dto.getTsId());
    }

    /**
     * 验证学生操作实训总结的权限
     *
     * @param stuId     学生id
     * @param summaryId 实训总结id
     * @return 实训总结对象
     */
    private TrainSummary validateTaskAuthority(Long stuId, Long summaryId) {
        TrainSummary summary = findById(summaryId);
        if (!summary.getStudentId().equals(stuId))
            throw new RuntimeException("学生没有实训总结:" + summary.getId() + "的权限");
        return summary;
    }

    /**
     * 上传实训总结对象并获取上传的文件名称
     *
     * @param summary 原来的实训总结
     * @param file    上传的目标文件
     * @param student 上传文件的学生
     * @return 上传文件的文件名
     */
    private String getUploadFilename(TrainSummary summary, MultipartFile file, Student student) {
        Long schoolId = summary.getSchoolId();

        String filename;
        if (file != null) {
            String identification = schoolId + "_" + "_" + student.getAccount();
            filename = fileService.saveFile(file, identification);
        } else
            filename = summary.getTrainReportUrl();
        return filename;
    }

    @Override
    public TrainSummary deleteById(Long stuId, Long summaryId) {
        TrainSummary summary = validateTaskAuthority(stuId, summaryId);

        summaryMapper.deleteById(summaryId);
        return summary;
    }

    @Override
    public List<TrainSummary> queryByCondition(TrainSummaryQueryModel queryCondition) {
        List<TrainSummary> trainSummaryList = summaryMapper.queryByCondition(queryCondition);
        trainSummaryList.forEach(trainSummary -> {
            trainSummary.setTrainReportUrl(
                    FileUtil.getFileDownloadUri(trainSummary.getTrainReportUrl(), FileConstrant.FILE_DOWNLOAD_URI));
            trainSummary.setTrainDesignUrl(
                    FileUtil.getFileDownloadUri(trainSummary.getTrainDesignUrl(), FileConstrant.FILE_DOWNLOAD_URI));
        });
        return trainSummaryList;
    }
}
