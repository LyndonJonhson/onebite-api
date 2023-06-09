insert into estado(nome, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado(nome, sigla) values ('Rio de Janeiro', 'RJ');

insert into cidade(nome, estado_id) values ('Natal', 1);
insert into cidade(nome, estado_id) values ('Rio de Janeiro', 2);

insert into bairro(nome, cidade_id) values ('Nossa Senhora da Apresentação', 1);
insert into bairro(nome, cidade_id) values ('Ipanema', 2);

insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cep, logradouro, numero, bairro_id) values ('Point do Acai', '1111-1111', 'Descricao do Point do Acai', false, true, Now(), '59000000', 'Rua 1', '1', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cep, logradouro, numero, bairro_id) values ('O Gostosão', '2111-1111', 'Descrição do O Gostosão', false, true, Now(), '59000000', 'Rua 2', '2', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cep, logradouro, numero, bairro_id) values ('Tentação Lanches', '3111-1111', 'Descrição do Tentação Lanches', false, true, Now(), '59000000', 'Rua 3', '3', 1);
