package sn.isi.gestEdu.mapping;

import org.mapstruct.Mapper;
import sn.isi.gestEdu.dto.AppUser;
import sn.isi.gestEdu.entities.AppUserEntity;

@Mapper
public interface AppUserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser(AppUser appUser);
}
