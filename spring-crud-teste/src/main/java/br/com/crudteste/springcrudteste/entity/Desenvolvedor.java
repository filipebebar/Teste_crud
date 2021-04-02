package br.com.crudteste.springcrudteste.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "DESENVOLVEDOR")
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DESENVOLVEDOR")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 120)
    private String nome;

    @Column(name = "SEXO", nullable = false, length = 10)
    private String sexo;

    @Column(name = "IDADE", nullable = false, length = 3)
    private Short idade;

    @Column(name = "HOBBY", nullable = false, length = 120)
    private String hobby;

    @Column(name = "DATA_NASCIMENTO", nullable = false, length = 10)
    private Date dataNascimento;

    @Column(name = "CREATE_DATA", nullable = false)
    @JsonFormat(pattern = "dd/mm/yyyy HH:MM")
    private LocalDateTime createDate;

    @PrePersist
    public void beforeSave() {
        setCreateDate(LocalDateTime.now());
    }

}
