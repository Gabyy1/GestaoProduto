Create DataBase GestaoProduto
Go
Use GestaoProduto
Go

Create  table  Produto (
codigo	int		identity	not null primary key,
nome	varchar(40)			not null,
data	date				not null
)
Go

Insert Into Produto values ('alface', '20230912')
Go
Insert Into Produto values ('abacaxi', '20230912')
Go
Insert Into Produto values ( null, '20231010')
Go

Select * From Produto
Order By nome
