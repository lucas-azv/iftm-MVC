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

INSERT INTO tb_anime (titulo, nota, episodios, dataInicio, dataFim)
VALUES ('Fullmetal Alchemist', '9', '64', '2023-10-02', '2023-11-02');

SELECT * FROM tb_anime;