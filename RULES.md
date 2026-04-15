# Regras dos Exercícios

## Exercício 1 - Controle de Aluguel de Quadra Esportiva

> "Eu tenho uma quadra de futebol society que é alugada por hora, mas hoje faço o controle tudo em um caderno e às vezes acontecem problemas como marcar dois horários para o mesmo cliente ou esqueço quem já pagou."

**Requisitos:**
- Cadastrar clientes (nome, telefone)
- Cadastrar horários disponíveis
- Registrar aluguel (cliente, horário, valor)
- Calcular valor total para múltiplos horários no mesmo dia
- Não permitir reserva em horário ocupado
- Consultar aluguéis por data
- Validar: nome não vazio, valor não negativo

---

## Exercício 2 - Controle de Biblioteca Escolar

> "Eu trabalho em uma escola e atualmente o controle de empréstimo de livros é feito manualmente em uma planilha."

**Requisitos:**
- Cadastrar livros (título, autor, quantidade)
- Cadastrar alunos
- Registrar empréstimo e devolução
- Não permitir empréstimo sem disponibilidade
- Consultar livros emprestados e alunos com livros
- Validar: título não vazio, quantidade não negativa

---

## Exercício 3 - Controle de Pedidos em uma Lanchonete

> "Eu tenho uma pequena lanchonete e hoje anoto os pedidos em um bloco de papel."

**Requisitos:**
- Cadastrar produtos (nome, descrição, preço)
- Registrar pedidos com múltiplos produtos
- Calcular valor total automaticamente
- Consultar pedidos por dia e faturamento
- Validar: nome não vazio, preço não negativo
- Pedido deve ter pelo menos um produto

---

## Entregas

Para cada exercício:
1. **Arquivo README.md** na raiz com tabelas identificadas e regras de negócio
2. **Projeto `classes/`** - Classes puras com simulação na Main
3. **Projeto `mvc/`** - Refatorado com padrão MVC e simulação na Main