# MVC Java - Exercícios Acadêmicos

Projeto desenvolvido para o terceiro período do curso de Ciência da Computação.

## Objetivo

Ensinar os conceitos fundamentais de **Model-View-Controller (MVC)** através de exercícios práticos progressing, onde cada sistema é implementado primeiro com classes puras e depois refatorado para o padrão MVC.

## O que é MVC?

MVC é um padrão de arquitetura de software que separa a aplicação em três camadas:

- **Model (Modelo)**: Representa os dados e a lógica de negócio
- **View (Visão)**: Interface com o usuário
- **Controller (Controlador)**: Coordena a comunicação entre Model e View

## Estrutura do Projeto

Cada exercício possui duas implementações:

### `classes/`
Implementação com classes puras (POO básica). Toda a lógica de negócio, interface e controle estão juntos nos métodos das classes. Mais simples para iniciantes, mas difícil de manter em sistemas maiores.

### `mvc/`
Implementação seguindo o padrão MVC. Cada responsabilidade está separada em pacotes (`model`, `view`, `controller`), demonstrando as vantagens de ter cada camada com sua função específica.

## Exercícios

| Exercício | Descrição |
|-----------|-----------|
| [controleAluguel](./controleAluguel) | Sistema para controle de aluguel de quadra esportiva |
| [controleBiblioteca](./controleBiblioteca) | Sistema para controle de biblioteca escolar |
| [controleLanchonete](./controleLanchonete) | Sistema para controle de pedidos em uma lanchonete |

## Diferença entre Classes e MVC

### Abordagem com Classes Puras
- Toda a lógica concentrada em poucas classes
- Método principal faz tudo: entrada, processamento, saída
- Difícil de modificar ou expandir
- Bom para aprendizado inicial de POO

### Abordagem MVC
- Responsabilidades separadas
- Changes em um lugar não afetam os outros
- Mais código, mas mais manutenível
- Preparação para desenvolvimento profissional

## Como Executar

Cada subprojeto possui sua própria compilação:

```bash
# Compilar e executar (classes)
javac -d out/classes exercicio/classes/src/*.java
java -cp out/classes Main

# Compilar e executar (mvc)
javac -d out/mvc exercicio/mvc/src/model/*.java exercicio/mvc/src/view/*.java exercicio/mvc/src/controller/*.java exercicio/mvc/src/main/Main.java
java -cp out/mvc main.Main
```

## Tecnologias

- Java 8+
- Sem frameworks (apenas Java puro)
- IDE: IntelliJ IDEA