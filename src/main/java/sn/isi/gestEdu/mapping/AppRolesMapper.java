package sn.isi.gestEdu.mapping;

import org.mapstruct.Mapper;
import sn.isi.gestEdu.dto.AppRoles;
import sn.isi.gestEdu.entities.AppRolesEntity;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(AppRoles appRoles);
}
