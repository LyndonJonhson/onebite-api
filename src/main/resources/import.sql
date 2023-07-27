insert into estado(nome, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado(nome, sigla) values ('Rio de Janeiro', 'RJ');

insert into cidade(nome, estado_id) values ('Natal', 1);
insert into cidade(nome, estado_id) values ('Rio de Janeiro', 2);

insert into bairro(nome, cidade_id) values ('Nossa Senhora da Apresentação', 1);
insert into bairro(nome, cidade_id) values ('Ipanema', 2);

insert into cozinha(nome) values ('Hamburgueria');
insert into cozinha(nome) values ('Pizzaria');

insert into usuario(nome, email, senha, data_cadastro, ativo) values ('Lyndon Jonhson', 'jonhson@gmail,com', 'jonhson123', Now(), true);
insert into usuario(nome, email, senha, data_cadastro, ativo) values ('Willian Barbosa', 'willian@gmail,com', 'willian123', Now(), true);
insert into usuario(nome, email, senha, data_cadastro, ativo) values ('Housemberg Donanvam', 'housemberg@gmail,com', 'housemberg123', Now(), true);

insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, cep, logradouro, numero, bairro_id) values ('Point do Acai', '1111-1111', 'Descricao do Point do Acai', false, true, Now(), 1, '59000000', 'Rua 1', '1', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, cep, logradouro, numero, bairro_id) values ('O Gostosão', '2111-1111', 'Descrição do O Gostosão', false, true, Now(), 1, '59000000', 'Rua 2', '2', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, cep, logradouro, numero, bairro_id) values ('Tentação Lanches', '3111-1111', 'Descrição do Tentação Lanches', false, true, Now(), 2, '59000000', 'Rua 3', '3', 1);

insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 2L', '', 5.99, true, 1);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 1L', '', 3.99, true, 2);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('cachorro-quente', '', 3.00, true, 3);