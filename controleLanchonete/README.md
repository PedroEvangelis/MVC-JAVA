# Controle de Pedidos em uma Lanchonete

## Tabelas

### Produto
- id: int
- nome: String
- descricao: String
- preco: double

### Pedido
- id: int
- produtos: List<Produto>
- data: LocalDate
- finalizado: boolean

## Regras de Negócio

1. **Nome do produto**: Não pode ser vazio
2. **Preço do produto**: Não pode ser negativo
3. **Pedido**: Deve ter pelo menos um produto para ser finalizado
4. **Cálculo**: Valor total é a soma dos preços dos produtos
5. **Consulta**: É possível consultar pedidos por data
6. **Faturamento**: É possível calcular o faturamento de um período
