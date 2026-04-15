# Controle de Aluguel de Quadra Esportiva

## Tabelas

### Cliente
- id: int
- nome: String
- telefone: String

### Horario
- id: int
- hora: int (0-23)
- valor: double

### Aluguel
- id: int
- cliente: Cliente
- horarios: List<Horario>
- data: LocalDate
- pago: boolean

## Regras de Negócio

1. **Nome do cliente**: Não pode ser vazio
2. **Valor do horário**: Não pode ser negativo
3. **Horário**: Deve ser válido (0-23)
4. **Reserva**: Não permitir reservar horário já ocupado na mesma data
5. **Aluguel**: Deve ter pelo menos um horário
6. **Cálculo**: Valor total é a soma dos valores dos horários selecionados
7. **Consulta**: É possível consultar todos os aluguéis de uma determinada data