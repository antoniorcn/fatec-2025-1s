create table contato ( 
	id int AUTO_INCREMENT,
	nome varchar(100),
	telefone char(30),
	email varchar(100),
	PRIMARY KEY(id)
);

INSERT INTO contato (nome, telefone, email)
VALUES ('Joao Silva', '111111', 'joao@teste.com');