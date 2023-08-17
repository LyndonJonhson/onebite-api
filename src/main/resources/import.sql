insert into estado(nome, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado(nome, sigla) values ('Rio de Janeiro', 'RJ');

insert into cidade(nome, estado_id) values ('Natal', 1);
insert into cidade(nome, estado_id) values ('Rio de Janeiro', 2);

insert into bairro(nome, cidade_id) values ('Nossa Senhora da Apresentação', 1);
insert into bairro(nome, cidade_id) values ('Ipanema', 2);

insert into cozinha(nome) values ('Hamburgueria');
insert into cozinha(nome) values ('Pizzaria');

insert into papel(nome) values ('ADMINISTRADOR DO SISTEMA');
insert into papel(nome) values ('USUARIO');
insert into papel(nome) values ('DONO DE RESTAURANTE');
insert into papel(nome) values ('GERENTE');
insert into papel(nome) values ('FUNCIONARIO');

insert into permissao(nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas')
insert into permissao(nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas')
insert into permissao(nome, descricao) values ('CONSULTAR_RESTAURANTES', 'Permite consultar restaurantes')
insert into permissao(nome, descricao) values ('EDITAR_RESTAURANTES', 'Permite etidar restaurantes')
insert into permissao(nome, descricao) values ('CONSULTAR_FORMAS_PAGAMENTO', 'Permite consultar formas de pagamento')
insert into permissao(nome, descricao) values ('EDITAR_FORMAS_PAGAMENTO', 'Permite editar formas de pagamento')
insert into permissao(nome, descricao) values ('CONSULTAR_PEDIDOS', 'Permite consultar pedidos')
insert into permissao(nome, descricao) values ('EDITAR_PEDIDOS', 'Permite editar pedidos')

insert into usuario(nome, email, senha, data_cadastro) values ('Lyndon Jonhson', 'jonhson@gmail,com', 'jonhson123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Willian Barbosa', 'willian@gmail,com', 'willian123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Housemberg Donanvam', 'housemberg@gmail,com', 'housemberg123', Now());

insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, bairro_id) values ('Point do Acai', '1111-1111', 'Descricao do Point do Acai', false, true, Now(), 1, '59000000', 'Rua 1', '1', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, bairro_id) values ('O Gostosão', '2111-1111', 'Descrição do O Gostosão', false, true, Now(), 1, '59000000', 'Rua 2', '2', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, bairro_id) values ('Tentação Lanches', '3111-1111', 'Descrição do Tentação Lanches', false, true, Now(), 2, '59000000', 'Rua 3', '3', 1);

insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 2L', '', 5.99, true, 1);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 1L', '', 3.99, true, 2);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('cachorro-quente', '', 3.00, true, 3);