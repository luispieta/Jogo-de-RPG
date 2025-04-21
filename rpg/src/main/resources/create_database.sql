create database if not exists banco_odestionodostres;
use banco_odestionodostres;

create table if not exists racas (
	id_raca int not null primary key auto_increment,
    nome varchar(150) not null,
    vida int not null,
    escudo int not null,
    poder_fisico int not null,
    poder_habilidade int not null
);

create table if not exists arquetipos(
	id_arquetipo int not null primary key auto_increment,
    nome varchar(150) not null,
    vida int not null,
    escudo int not null,
    poder_fisico int not null,
    poder_habilidade int not null
);

create table if not exists personagens (
	id_personagem int not null primary key auto_increment,
	nome varchar(150) not null,
    vida int not null,
    escudo int not null,
    poder_fisico int not null,
    poder_habilidade int not null,
    raca_id int not null,
    arquetipo_id int not null,
    foreign key(raca_id) references racas(id_raca),
    foreign key(arquetipo_id) references arquetipos(id_arquetipo)
);

create table if not exists batalhas(
	id_batalha int not null primary key auto_increment,
    lutador1_id int not null,
    lutador2_id int not null,
    vencedor_id int,
    foreign key(lutador1_id) references personagens(id_personagem),
    foreign key(lutador2_id) references personagens(id_personagem),
    foreign key(vencedor_id) references personagens(id_personagem)
);

create table if not exists criar_personagem(
    id_criar int not null primary key auto_increment,
    nome varchar(150) unique,
    escolha_personagem int not null,
    escolha_raca int not null,
    escolha_arquetipo int not null,
    foreign key(escolha_personagem) references personagens(id_personagem),
    foreign key(escolha_raca) references racas(id_raca),
    foreign key(escolha_arquetipo) references arquetipos(id_arquetipo)
);

create table if not exists usuario(
	id int not null auto_increment primary key,
    nome varchar(150),
    login varchar(150) not null unique,
    senha text not null,
    email varchar(150),
    telefone varchar(150)
);