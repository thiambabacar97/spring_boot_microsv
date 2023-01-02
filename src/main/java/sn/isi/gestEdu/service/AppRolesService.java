package sn.isi.gestEdu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.gestEdu.doa.IAppRolesRepository;
import sn.isi.gestEdu.dto.AppRoles;
import sn.isi.gestEdu.exception.EntityNotFoundException;
import sn.isi.gestEdu.exception.RequestException;
import sn.isi.gestEdu.mapping.AppRolesMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppRolesService {
    @Autowired
    private IAppRolesRepository iAppRolesRepository;
    @Autowired
    private AppRolesMapper appRolesMapper;
    MessageSource messageSource;

    public AppRolesService(IAppRolesRepository iAppRolesRepository, AppRolesMapper appRolesMapper, MessageSource messageSource) {
        this.iAppRolesRepository = iAppRolesRepository;
        this.appRolesMapper = appRolesMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<AppRoles>  getAppRoles() {
        return StreamSupport.stream(iAppRolesRepository.findAll().spliterator(), false)
                .map(appRolesMapper::toAppRoles)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppRoles getAppRole(int id) {
        return appRolesMapper.toAppRoles(iAppRolesRepository.findById(id)
                .orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional
    public AppRoles createAppRoles(AppRoles appRoles) {
        return appRolesMapper.toAppRoles(iAppRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
    }

    @Transactional
    public AppRoles updateAppRoles(int id, AppRoles appRoles) {
        return iAppRolesRepository.findById(id)
                .map(entity -> {
                    appRoles.setId(id);
                    return appRolesMapper.toAppRoles(
                            iAppRolesRepository.save(appRolesMapper.fromAppRoles(appRoles)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
