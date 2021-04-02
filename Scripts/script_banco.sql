# Script para criar tabela
CREATE TABLE spring_crud_test.DESENVOLVEDOR
(
    ID_DESENVOLVEDOR BIGINT primary key auto_increment not null,
    NOME             varchar(120)                      NOT NULL,
    SEXO             varchar(10)                       NOT NULL,
    IDADE            integer(3)                        NOT NULL,
    HOBBY            varchar(120)                      NOT NULL,
    DATA_NASCIMENTO  DATE                              NOT NULL,
    CREATE_DATA      DATETIME                          NOT NULL

);


#Script para adicionar um registro no banco
INSERT INTO spring_crud_test.DESENVOLVEDOR
    (NOME, SEXO, IDADE, HOBBY, DATA_NASCIMENTO, CREATE_DATA)
VALUES ('rodrigo', 'masculino', 25 ,'correr', '1996-05-19', utc_date());
