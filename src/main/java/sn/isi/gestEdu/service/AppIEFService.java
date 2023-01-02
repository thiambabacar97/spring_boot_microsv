package sn.isi.gestEdu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.gestEdu.doa.IAppIEFRespository;
import sn.isi.gestEdu.dto.AppIEF;
import sn.isi.gestEdu.mapping.AppIEFMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppIEFService {
    @Autowired
    private IAppIEFRespository iAppIEFRespository;
    @Autowired
    private AppIEFMapper appIEFMapper;
    MessageSource messageSource;

    public AppIEFService(IAppIEFRespository iAppIEFRespository, AppIEFMapper appIEFMapper, MessageSource messageSource) {
        this.iAppIEFRespository = iAppIEFRespository;
        this.appIEFMapper = appIEFMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<AppIEF> fechAll() {
        return StreamSupport.stream(iAppIEFRespository.findAll().spliterator(), false)
                .map(appIEFMapper::toAppIef)
                .collect(Collectors.toList());
    }

    @Transactional
    public AppIEF create(AppIEF appIEF) {
        return appIEFMapper.toAppIef(iAppIEFRespository.save(appIEFMapper.fromAppIef(appIEF)));
    }
}
