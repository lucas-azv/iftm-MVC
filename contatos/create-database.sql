create database dbContatos;

use dbContatos;

create table tb_contato(

email varchar(255) primary key,

nome varchar(255)

);

insert into tb_contato values ('borabill@iftm.edu.br','Bill');
insert into tb_contato values ('fidobill@iftm.edu.br','Filho do Bill');
insert into tb_contato values ('mulhedobill@iftm.edu.br','Mulher do Bill');

select email,nome from tb_contato;