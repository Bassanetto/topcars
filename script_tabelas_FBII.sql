#create database bytesql;
use bytesql;

CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `endereco` varchar(150) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefone` varchar(40) DEFAULT NULL,
  `cnh` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `veiculo` (
  `id_veiculo` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(50) NOT NULL,
  `cor` varchar(50) NOT NULL,
  `ano` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `placa` varchar(50) NOT NULL,
  `carroceria` varchar(50) NOT NULL,
  `motor` varchar(45) NOT NULL,
  `combustivel` varchar(45) NOT NULL,
  `cambio` varchar(45) NOT NULL,
  PRIMARY KEY (`id_veiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE locacao(
id_locacao int not null auto_increment primary key,
nome_locacao varchar(60) not null,
cnh_locacao varchar(60) not null,
cpf_locacao varchar(60) not null,
data_locacao date not null,
carro_locacao varchar(45) not null,
placa_locacao varchar(45) not null);

create table logins(
id_usuario int not null auto_increment primary key,
usuario varchar(45) not null,
senha varchar(45) not null,
nome varchar(60) not null,
sobrenome varchar(60) not null,
email varchar(45) not null,
cpf varchar(45) not null)

