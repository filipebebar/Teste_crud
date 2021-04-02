package br.com.crudteste.springcrudteste.dto;

import br.com.crudteste.springcrudteste.entity.Desenvolvedor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class DesenvolvedorDTO {

    private Long id;
    private String nome;
    private String sexo;
    private Short idade;
    private String hobby;
    private Date dataNascimento;
    private Date createData;

    public static DesenvolvedorDTO converter(Desenvolvedor d) {
        var dev = new DesenvolvedorDTO();
        dev.setId(d.getId());
        dev.setNome(d.getNome());
        dev.setSexo(d.getSexo());
        dev.setIdade(d.getIdade());
        dev.setHobby(d.getHobby());
        dev.setDataNascimento(d.getDataNascimento());
        dev.setCreateData(d.getCreateDate());
        return dev;

    }

    private void setCreateData(LocalDateTime createDate) {
    }


}
