create database dbCadastro;
use dbCadastro;

create table tb_cadastro(
id int PRIMARY KEY,
nome varchar(255),
email varchar(255),
telefone char(12)
);

insert into tb_cadastro values (1,'Carlos Eduardo','carloseduardodantas@iftm.edu.br', '001234567890');
insert into tb_cadastro values (2,'Edson Angoti','angoti@iftm.edu.br', '001234567890');
insert into tb_cadastro values (3,'Satoru Gojo','satoru@iftm.edu.br', '011234567890');

select id, nome, email, telefone from tb_cadastro