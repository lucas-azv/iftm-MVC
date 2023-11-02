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

insert into tb_anime(titulo,nota,episodios,dataInicio,dataFim)
values
('Jujutsu Kaisen', '8', '16', '2023-06-12','2023-07-12'),
('Fullmetal Alchemist', '10', '64', '2023-07-12','2023-08-12'),
('Kill la Kill', '10', '24', '2023-09-12','2023-10-12');