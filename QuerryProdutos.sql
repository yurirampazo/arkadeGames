SELECT * FROM db_arkade_store.tb_produto;

SELECT titulo, tb_categoria.nome,tb_desenvovedora.nome ,tb_produto.descricao, preco,quantidade from 
tb_categoria inner join tb_produto on tb_produto.categoria_id = tb_categoria.id
 inner join tb_desenvovedora on  tb_produto.desenvolvedora_id = tb_desenvovedora.id;
