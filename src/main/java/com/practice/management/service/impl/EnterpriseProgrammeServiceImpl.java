package com.practice.management.service.impl;

import com.practice.management.bean.dto.AddEpDto;
import com.practice.management.bean.dto.UpdEpDto;
import com.practice.management.bean.entity.Enterprise;
import com.practice.management.bean.entity.EnterpriseProgramme;
import com.practice.management.bean.entity.EnterpriseResponsibility;
import com.practice.management.bean.model.EpQueryModel;
import com.practice.management.constrant.FileConstrant;
import com.practice.management.mapper.EnterpriseProgrammeMapper;
import com.practice.management.service.EnterpriseProgrammeService;
import com.practice.management.service.EnterpriseResponsibilityService;
import com.practice.management.service.EnterpriseService;
import com.practice.management.service.FileService;
import com.practice.management.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EnterpriseProgrammeServiceImpl implements EnterpriseProgrammeService {

    @Autowired
    private EnterpriseProgrammeMapper programmeMapper;

    @Autowired
    private EnterpriseResponsibilityService erService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private FileService fileService;

    @Override
    public EnterpriseProgramme findById(Long programmeId) {
        EnterpriseProgramme programme = programmeMapper.findById(programmeId);
        if (programme == null)
            throw new RuntimeException("企业培训方案id:" + programmeId + "不存在！");

        return programme;
    }

    @Transactional
    @Override
    public EnterpriseProgramme add(AddEpDto dto) {
        EnterpriseResponsibility er = erService.findById(dto.getErId());
        dto.setEnterpriseId(er.getEnterpriseId());

        validateEr(dto.getEnterpriseId(), er.getAccount(), er.getName());
        validateEpUnique(dto.getEnterpriseId(), dto.getName());

        dto.setAddTime(new Date());
        if (dto.getRemarks() == null)
            dto.setRemarks("");

        // 上传文件
        String identification = dto.getEnterpriseId() + "_" + dto.getAddTime() + "_" + dto.getName();
        String filename = fileService.saveFile(dto.getFile(), identification);
        dto.setEnclosure(filename);

        Long epId = programmeMapper.insert(dto);
        return programmeMapper.findById(epId);
    }

    private void validateEpUnique(Long enterpriseId, String epName) {
        List<EnterpriseProgramme> programmeList =
                programmeMapper.findByNameAndEnterpriseId(epName, enterpriseId);
        if (programmeList != null && programmeList.size() > 0)
            throw new RuntimeException("企业已存在企业课程:" + epName);
    }

    @Transactional
    @Override
    public EnterpriseProgramme update(UpdEpDto dto) {
        EnterpriseProgramme ep = validateErAuthority(dto.getErId(), dto.getEpId());

        validateEpUnique(ep.getEnterpriseId(), dto.getName());
        if (dto.getFile() == null)
            dto.setEnclosure(ep.getEnclosure());
        else {
            String identification = ep.getEnterpriseId() + "_" + ep.getAddTime() + "_" + dto.getName();
            String filename = fileService.saveFile(dto.getFile(), identification);
            dto.setEnclosure(filename);
        }


        programmeMapper.updateById(dto);
        return programmeMapper.findById(ep.getId());
    }

    private EnterpriseProgramme validateErAuthority(Long erId, Long epId) {
        EnterpriseResponsibility er = erService.findById(erId);
        EnterpriseProgramme ep = findById(epId);

        if (!er.getEnterpriseId().equals(ep.getEnterpriseId()))
            throw new RuntimeException("企业负责人:" + er.getName() + "所在的企业没有开设课程:" + ep.getName());

        validateEr(ep.getEnterpriseId(), er.getAccount(), er.getName());

        return ep;
    }

    private void validateEr(Long enterpriseId, String account, String erName) {
        Enterprise enterprise = enterpriseService.findById(enterpriseId);
        if (!enterprise.getAccount().equals(account))
            throw new RuntimeException("企业:" + enterprise.getName() + "老师:" + erName + "没有企业课程的操作权限");
    }

    @Transactional
    @Override
    public EnterpriseProgramme delete(Long erId, Long epId) {
        EnterpriseProgramme ep = validateErAuthority(erId, epId);

        programmeMapper.deleteById(epId);
        return ep;
    }

    @Override
    public List<EnterpriseProgramme> query(EpQueryModel queryCondition) {
        List<EnterpriseProgramme> enterpriseProgrammes = programmeMapper.queryByCondition(queryCondition);
        enterpriseProgrammes.forEach(programme ->
                programme.setEnclosure(FileUtil.getFileDownloadUri(
                        programme.getEnclosure(), FileConstrant.FILE_DOWNLOAD_URI)));

        return enterpriseProgrammes;
    }
}
