package sn.isi.gestEdu.mapping;

import org.mapstruct.Mapper;
import sn.isi.gestEdu.dto.AppIEF;
import sn.isi.gestEdu.entities.AppIEFEntity;

@Mapper
public interface AppIEFMapper {
    AppIEF toAppIef(AppIEFEntity appIEFEntity);
    AppIEFEntity fromAppIef(AppIEF appIEF);
}