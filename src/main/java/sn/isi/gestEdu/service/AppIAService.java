package sn.isi.gestEdu.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.gestEdu.doa.IAppIARespository;
import sn.isi.gestEdu.dto.AppIA;
import sn.isi.gestEdu.mapping.AppIAMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppIAService {
    private IAppIARespository iARespository;
    private AppIAMapper appIAMapper;
    MessageSource messageSource;

    public AppIAService(IAppIARespository iARespository, AppIAMapper appIAMapper, MessageSource messageSource) {
        this.iARespository = iARespository;
        this.appIAMapper = appIAMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<AppIA> fechAll() {
        return StreamSupport.stream(iARespository.findAll().spliterator(), false)
                .map(appIAMapper::toAppIA)
                .collect(Collectors.toList());
    }

    @Transactional
    public AppIA create(AppIA appIA) {
        return appIAMapper.toAppIA(iARespository.save(appIAMapper.fromAppIa(appIA)));
    }

}
