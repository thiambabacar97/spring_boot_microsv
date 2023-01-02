package sn.isi.gestEdu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.gestEdu.doa.IAppUserRepository;
import sn.isi.gestEdu.dto.AppUser;
import sn.isi.gestEdu.exception.EntityNotFoundException;
import sn.isi.gestEdu.exception.RequestException;
import sn.isi.gestEdu.mapping.AppUserMapper;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class AppUserService {
    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Autowired
    private AppUserMapper appUserMapper;
    MessageSource messageSource;

    public AppUserService(IAppUserRepository iAppUserRepository, AppUserMapper appUserMapper, MessageSource messageSource) {
        this.iAppUserRepository = iAppUserRepository;
        this.appUserMapper = appUserMapper;
        this.messageSource = messageSource;
    }

    @Transactional
    public AppUser create(AppUser appUser) {
        return appUserMapper.toAppUser(iAppUserRepository.save(appUserMapper.fromAppUser(appUser)));
    }

    @Transactional(readOnly = true)
    public List<AppUser> fechAll() {
        return StreamSupport.stream(iAppUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUser)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppUser getAppUser(int id) {
        return appUserMapper.toAppUser(iAppUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public AppUser updateAppUser(int id, AppUser appUser) {
        return iAppUserRepository.findById(id)
                .map(entity -> {
                    appUser.setId(id);
                    return appUserMapper.toAppUser(
                            iAppUserRepository.save(appUserMapper.fromAppUser(appUser)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppUser(int id) {
        try {
            iAppUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
