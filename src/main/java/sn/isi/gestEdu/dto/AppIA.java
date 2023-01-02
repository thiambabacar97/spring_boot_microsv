package sn.isi.gestEdu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppIA {
    private int id;
    @NotNull(message = "Le name ne doit pas etre null")
    private String name;
}
