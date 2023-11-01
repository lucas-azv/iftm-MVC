create database dbAnime;
use dbAnime;

create table tb_anime(
	id bigint auto_increment PRIMARY KEY,
    titulo varchar(255),
	nota char(2),
    episodios varchar(5),
    dataInicio date,
    dataFim date
);

SELECT * FROM tb_anime 