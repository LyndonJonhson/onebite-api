insert into estado(nome, sigla) values ('Acre', 'AC');
insert into estado(nome, sigla) values ('Alagoas', 'AL');
insert into estado(nome, sigla) values ('Amapá', 'ap');
insert into estado(nome, sigla) values ('Amazonas', 'AM');
insert into estado(nome, sigla) values ('Bahia', 'BA');
insert into estado(nome, sigla) values ('Ceará', 'CE');
insert into estado(nome, sigla) values ('Espírito Santo', 'ES');
insert into estado(nome, sigla) values ('Goiás', 'GO');
insert into estado(nome, sigla) values ('Maranhão', 'MA');
insert into estado(nome, sigla) values ('Mato Grosso', 'MT');
insert into estado(nome, sigla) values ('Mato Grosso do Sul', 'MS');
insert into estado(nome, sigla) values ('Minas Gerais', 'MG');
insert into estado(nome, sigla) values ('Pará', 'PA');
insert into estado(nome, sigla) values ('Paraíba', 'PB');
insert into estado(nome, sigla) values ('Paraná', 'PR');
insert into estado(nome, sigla) values ('Pernambuco', 'PE');
insert into estado(nome, sigla) values ('Piauí', 'PI');
insert into estado(nome, sigla) values ('Rio de Janeiro', 'RJ');
insert into estado(nome, sigla) values ('Rio Grande do Norte', 'RN');
insert into estado(nome, sigla) values ('Rio Grande do Sul', 'RS');
insert into estado(nome, sigla) values ('Rondônia', 'RO');
insert into estado(nome, sigla) values ('Roraima', 'RR');
insert into estado(nome, sigla) values ('Santa Catarina', 'SC');
insert into estado(nome, sigla) values ('São Paulo', 'SP');
insert into estado(nome, sigla) values ('Sergipe', 'SE');
insert into estado(nome, sigla) values ('Tocantins', 'TO');

insert into cidade(nome, estado_id) values ('Natal', 19);
insert into cidade(nome, estado_id) values ('Parnamirim', 19);
insert into cidade(nome, estado_id) values ('Macaíba', 19);
insert into cidade(nome, estado_id) values ('São Gonçalo do Amarante', 19);
insert into cidade(nome, estado_id) values ('Extremoz', 19);
insert into cidade(nome, estado_id) values ('Mossoró', 19);
insert into cidade(nome, estado_id) values ('Ceará-Mirim', 19);
insert into cidade(nome, estado_id) values ('Rio de Janeiro', 18);
insert into cidade(nome, estado_id) values ('São Gonçalo', 18);
insert into cidade(nome, estado_id) values ('Duque de Caxias', 18);
insert into cidade(nome, estado_id) values ('São Paulo', 24);
insert into cidade(nome, estado_id) values ('Guarulhos', 24);
insert into cidade(nome, estado_id) values ('Campinas', 24);

insert into bairro(nome, cidade_id) values ('Nossa Senhora da Apresentação', 1);
insert into bairro(nome, cidade_id) values ('Alecrim', 1);
insert into bairro(nome, cidade_id) values ('Igapó', 1);
insert into bairro(nome, cidade_id) values ('Lagoa Nova', 1);
insert into bairro(nome, cidade_id) values ('Petrópolis', 1);
insert into bairro(nome, cidade_id) values ('Pajuçara', 1);
insert into bairro(nome, cidade_id) values ('Ponta Negra', 1);
insert into bairro(nome, cidade_id) values ('Ipanema', 8);
insert into bairro(nome, cidade_id) values ('Botafogo', 8);
insert into bairro(nome, cidade_id) values ('Copacabana', 8);
insert into bairro(nome, cidade_id) values ('Bela Vista', 11);
insert into bairro(nome, cidade_id) values ('Pinheiros', 11);
insert into bairro(nome, cidade_id) values ('Moema', 11);

insert into cozinha(nome) values ('Hamburgueria');
insert into cozinha(nome) values ('Pizzaria');
insert into cozinha(nome) values ('Culinária Japonesa');
insert into cozinha(nome) values ('Sorveteria');
insert into cozinha(nome) values ('Marmitaria');
insert into cozinha(nome) values ('Cafeterias');
insert into cozinha(nome) values ('Salgados');
insert into cozinha(nome) values ('Pastelarias');
insert into cozinha(nome) values ('Padarias');

insert into usuario(nome, email, senha, data_cadastro) values ('Lyndon Jonhson', 'jonhson@gmail,com', 'jonhson123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Vivian Karen', 'vivian@gmail,com', 'vivian123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Willian Barbosa', 'willian@gmail,com', 'willian123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Joyce Barbosa', 'joyce@gmail,com', 'joyce123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Housemberg Donanvam', 'housemberg@gmail,com', 'housemberg123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Eduardo Soares', 'eduardo@gmail,com', 'eduardo123', Now());
insert into usuario(nome, email, senha, data_cadastro) values ('Jonas Peixoto', 'jonas@gmail,com', 'jonas123', Now());

insert into papel(nome) values ('Entregador');
insert into papel(nome) values ('Garçom');
insert into papel(nome) values ('Atendente');
insert into papel(nome) values ('Gerente');
insert into papel(nome) values ('Dono de Restaurante');

insert into usuario_papeis values (1,1), (2,2), (3,3), (4,4), (5,5), (6, 4), (6,3);

insert into permissao(nome, descricao) values ('CONFIRMAR_ENTREGA_PEDIDO_DELIVERY', 'Permite confirmar a entrega do pedido delivery');
insert into permissao(nome, descricao) values ('VISUALIZAR_PEDIDOS_STATUS_EM_ENTREGA', 'Permite visualizar no dashboard apenas os pedidos para entregar');

insert into permissao(nome, descricao) values ('VISUALIZAR_PEDIDOS_PRESENCIAL', 'Permite visualizar no dashboard a tela de pedidos presenciais');
insert into permissao(nome, descricao) values ('CADASTRAR_PEDIDOS_PRESENCIAL', 'Permite criar os pedidos para os clientes do restaurante presentes no local');
insert into permissao(nome, descricao) values ('EDITAR_PEDIDOS_PRESENCIAL', 'Permite editar os pedidos para os clientes do restaurante presentes no local');
insert into permissao(nome, descricao) values ('CANCELAR_PEDIDOS_PRESENCIAL', 'Permite cancelar os pedidos para os clientes do restaurante presentes no local');

insert into permissao(nome, descricao) values ('VISUALIZAR_PEDIDOS_DELIVERY', 'Permite visualizar no dashboard a tela de pedidos delivery');
insert into permissao(nome, descricao) values ('CADASTRAR_PEDIDOS_DELIVERY', 'Permite criar os pedidos para os clientes do delivery');
insert into permissao(nome, descricao) values ('EDITAR_PEDIDOS_DELIVERY', 'Permite editar os pedidos para os clientes do delivery');
insert into permissao(nome, descricao) values ('CANCELAR_PEDIDOS_DELIVERY', 'Permite cancelar os pedidos para os clientes do delivery');
insert into permissao(nome, descricao) values ('EDITAR_STATUS_PEDIDO', 'Permite editar o status dos pedidos');
insert into permissao(nome, descricao) values ('IMPRIMIR_RESUMO_PEDIDO', 'Permite imprimir o resumo do pedido');

insert into permissao(nome, descricao) values ('GERENCIAR_DASHBOARD_RESUMO', 'Permite visualizar o menu resumo do dashboard');
insert into permissao(nome, descricao) values ('GERENCIAR_DASHBOARD_HISTORICO', 'Permite visualizar o menu historico do dashboard');
insert into permissao(nome, descricao) values ('GERENCIAR_DASHBOARD_CARDAPIO', 'Permite visualizar o menu cardápio do dashboard');
insert into permissao(nome, descricao) values ('GERENCIAR_DASHBOARD_FUNCIONARIOS', 'Permite visualizar o menu funcionários do dashboard');
insert into permissao(nome, descricao) values ('ABRIR_FECHAR_RESTAURANTE', 'Permite abrir/fechar o restaurante virtual manualmente');

insert into permissao(nome, descricao) values ('GERENCIAR_GERENTES', 'Permite cadastrar/demitir gerentes');
insert into permissao(nome, descricao) values ('EXCLUIR_RESTAURANTE', 'Permite excluir seus restaurantes');
insert into permissao(nome, descricao) values ('CRIAR_RESTAURANTE', 'Permite criar restaurantes');
insert into permissao(nome, descricao) values ('PAGAMENTO_RESTAURANTE', 'Permite gerenciar pagamentos do restaurante para manter no ar');

insert into papel_permissoes values (1, 1), (1,2);
insert into papel_permissoes values (2, 1), (2,2), (2,3), (2,4), (2,5), (2,6);
insert into papel_permissoes values (3, 1), (3,2), (3,3), (3,4), (3,5), (3,6), (3,7), (3,8), (3,9), (3,10), (3,11), (3, 12);
insert into papel_permissoes values (4, 1), (4,2), (4,3), (4,4), (4,5), (4,6), (4,7), (4,8), (4,9), (4,10), (4,11), (4, 12), (4,13), (4,14), (4,15), (4,16), (4,17);
insert into papel_permissoes values (5, 1), (5,2), (5,3), (5,4), (5,5), (5,6), (5,7), (5,8), (5,9), (5,10), (5,11), (5, 12), (5,13), (5,14), (5,15), (5,16), (5,17), (5,18), (5,19), (5,20), (5,21);

insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, bairro_id) values ('Point do Acai', '1111-1111', 'Descricao do Point do Acai', false, true, Now(), 1, '59000000', 'Rua 1', '1', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, bairro_id) values ('O Gostosão', '2111-1111', 'Descrição do O Gostosão', false, true, Now(), 1, '59000000', 'Rua 2', '2', 1);
insert into restaurante(nome, telefone, descricao, aberto, ativo, data_cadastro, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, bairro_id) values ('Tentação Lanches', '3111-1111', 'Descrição do Tentação Lanches', false, true, Now(), 2, '59000000', 'Rua 3', '3', 1);

insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 2L', '', 5.99, true, 1);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 2L', '', 5.99, true, 2);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 2L', '', 5.99, true, 3);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 1L', '', 3.99, true, 1);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 1L', '', 3.99, true, 2);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('coca-cola 1L', '', 3.99, true, 3);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('cachorro-quente', '', 3.00, true, 1);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('cachorro-quente', '', 3.00, true, 2);
insert into produto(nome, descricao, preco, ativo, restaurante_id) values ('Hamburguer', '', 10.00, true, 3);
