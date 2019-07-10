package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddWtDto;
import com.practice.management.bean.dto.UpdWtDto;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.entity.Major;
import com.practice.management.bean.entity.WeekTrain;
import com.practice.management.bean.model.WtQueryModel;
import com.practice.management.mapper.WeekTrainMapper;
import com.practice.management.service.EnterpriseResponsibilityService;
import com.practice.management.service.MajorService;
import com.practice.management.service.SchoolEnterpriseService;
import com.practice.management.service.WeekTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class WeekTrainServiceImpl implements WeekTrainService {

    @Autowired
    private WeekTrainMapper wtMapper;

    @Autowired
    private EnterpriseResponsibilityService erService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private SchoolEnterpriseService seService;

    @Transactional
    @Override
    public WeekTrain add(AddWtDto dto) {
        erService.findById(dto.getErId());
        // 验证展业开设情况
        Major major = majorService.findById(dto.getMajorId());

        // 验证校企合作情况
        seService.findByScIdAndEnpId(major.getSchoolId(), dto.getEnterpriseId());

        validateUniqueWeekTrain(dto.getEnterpriseId(), dto.getMajorId(), dto.getStartTime(), dto.getEndTime());

        wtMapper.insert(dto);
        return wtMapper.findById(dto.getId());
    }

    private void validateUniqueWeekTrain(Long enterpriseId, Long majorId, Date startTime, Date endTime) {
        WeekTrain weekTrain = wtMapper.findByMajorIdAndSeTime(enterpriseId, majorId, startTime, endTime);

        if (weekTrain != null)
            throw new RuntimeException("每周实训情况已存在，不能重复添加");
    }

    @Override
    public WeekTrain findById(Long wtId) {
        WeekTrain weekTrain = wtMapper.findById(wtId);

        if (weekTrain == null)
            throw new RuntimeException("每周实训id:" + wtId + "不存在");

        return weekTrain;
    }

    @Transactional
    @Override
    public WeekTrain update(UpdWtDto dto) {
        validateErAuthority(dto.getErId(), dto.getWtId());

        wtMapper.updateById(dto);
        return wtMapper.findById(dto.getWtId());
    }

    private WeekTrain validateErAuthority(Long erId, Long wtId) {
        EnterpriseResponsibility er = erService.findById(erId);
        WeekTrain weekTrain = findById(wtId);

        if (!er.getEnterpriseId().equals(weekTrain.getEnterpriseId()))
            throw new RuntimeException("企业负责人:" + er.getName() + "对每周实训记录没有操作权限");

        return weekTrain;
    }

    @Transactional
    @Override
    public WeekTrain delete(Long erId, Long wtId) {
        WeekTrain weekTrain = validateErAuthority(erId, wtId);

        wtMapper.deleteById(wtId);
        return weekTrain;
    }

    @Override
    public List<WeekTrain> query(WtQueryModel queryCondition) {

        return wtMapper.queryByCondition(queryCondition);
    }
}
