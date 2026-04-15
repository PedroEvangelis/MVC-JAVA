# Controle de Biblioteca Escolar

## Tabelas

### Livro
- id: int
- titulo: String
- autor: String
- quantidadeDisponivel: int

### Aluno
- id: int
- nome: String
- telefone: String

### Emprestimo
- id: int
- livro: Livro
- aluno: Aluno
- dataEmprestimo: LocalDate
- dataDevolucao: LocalDate
- devolvido: boolean

## Regras de Negócio

1. **Título do livro**: Não pode ser vazio
2. **Quantidade do livro**: Não pode ser negativa
3. **Nome do aluno**: Não pode ser vazio
4. **Empréstimo**: Não permitir se quantidade disponível for zero
5. **Devolução**: Ao devolver, incrementa quantidade disponível
6. **Consulta**: É possível consultar livros emprestados
7. **Consulta**: É possível consultar alunos com livros em aberto
