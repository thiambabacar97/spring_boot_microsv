package sn.isi.gestEdu.mapping;
import org.mapstruct.Mapper;
import sn.isi.gestEdu.dto.AppIA;
import sn.isi.gestEdu.entities.AppIAEntity;

@Mapper
public interface AppIAMapper {
    AppIA toAppIA(AppIAEntity appIAEntity);

    AppIAEntity fromAppIa(AppIA appIA);
}
