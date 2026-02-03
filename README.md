# 🏕️ SGA-DBV (Sistema de Gestão de Acervo - Desbravadores)

> **Status:** Concluído ✅

O **SGA-DBV** é uma API REST desenvolvida em Java com Spring Boot para modernizar a gestão de secretarias de Clubes de Desbravadores. O sistema substitui fichas manuais por um banco de dados relacional, permitindo o controle de unidades, membros (Desbravadores e Diretoria) e especialidades.

---

## 🧠 Conceitos Acadêmicos Aplicados (POO)

Este projeto foi desenvolvido com foco estrito nos pilares da **Orientação a Objetos** e lógica manual (sem uso de bibliotecas de automação como Lombok), para demonstrar domínio da linguagem Java:

* **Herança:** Uso de uma classe base `Pessoa` e uma classe abstrata `Membro`, estendidas por `Desbravador` e `Diretoria`.
* **Polimorfismo:** Implementação da interface `AtividadeClube`, onde cada classe responde de forma diferente ao método `getFuncaoNoClube()`.
* **Encapsulamento:** Atributos privados protegidos por Getters e Setters implementados manualmente.
* **Abstração:** Regras de negócio que impedem a criação de membros genéricos.
* **Lógica "Raiz":** Validações (`if/else`), laços (`for`) e transferência de dados (DTO -> Entity) feitos manualmente na camada de Serviço.

---

## 🛠️ Tecnologias Utilizadas

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) **Java 21**
* ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) **Spring Boot 3**
* ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white) **MySQL** (Banco de Dados Relacional)
* **Maven** (Gerenciamento de Dependências)
* **Postman** (Testes de API)

---

## ⚙️ Arquitetura e Banco de Dados

O projeto segue a arquitetura **MVC (Model-View-Controller)** em camadas.

### Estratégia de Herança no Banco
Foi utilizada a estratégia **Single Table** (`@Inheritance(strategy = InheritanceType.SINGLE_TABLE)`) do JPA.
* Todos os membros são salvos na tabela `membros`.
* Uma coluna discriminadora (`tipo_membro`) diferencia se o registro é `DESBRAVADOR` ou `DIRETORIA`.

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos
* Java JDK 21 instalado.
* MySQL Server rodando.
* Maven instalado.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/SEU-USUARIO/sga-dbv.git](https://github.com/SEU-USUARIO/sga-dbv.git)
    ```
2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no MySQL chamado `sga_dbv`.
    * Abra o arquivo `src/main/resources/application.properties` e verifique seu usuário e senha.
3.  **Execute a aplicação:**
    * Pela sua IDE (IntelliJ/Eclipse) ou via terminal:
    ```bash
    mvn spring-boot:run
    ```

---

## 🧪 Testando a API (Exemplos JSON)

Aqui estão exemplos de requisições para testar no **Postman**:

### 1. Cadastrar Unidade (POST)
**URL:** `/unidades`
```json
{
  "nome": "Unidade Escorpião",
  "gritoDeGuerra": "Com garra e força!",
  "corPadrao": "Vermelho"
}

2. Cadastrar Desbravador (POST)
URL: /membros Note o campo tipo e unidadeId.

JSON

{
    "nome": "Joãozinho Silva",
    "idade": 12,
    "tipo": "DESBRAVADOR",
    "unidadeId": 1,
    "ativo": true
}
3. Cadastrar Diretoria (POST)
URL: /membros Note o campo tipo e cargo.

JSON

{
    "nome": "Diretor Carlos",
    "idade": 35,
    "tipo": "DIRETORIA",
    "cargo": "Diretor Geral",
    "ativo": true
}
4. Cadastrar Especialidade (POST)
URL: /especialidades

JSON

{
    "nome": "Nós e Amarras",
    "area": "Habilidades Manuais",
    "nivel": "Básico"
}
📝 Autor
Desenvolvido por Felipe Tavares para a disciplina de Programação Orientada a Objetos.


---

### Como colocar esse arquivo no GitHub:

1.  No IntelliJ, clique com o botão direito na pasta principal do projeto (`Projeto DBV - JAVA`) -> **New** -> **File**.
2.  Nomeie como `README.md`.
3.  Cole o código acima.
4.  **Troque** onde diz `[Seu Nome]` e `https://github.com/SEU-USUARIO...` pelos seus dados reais.
5.  Faça o commit e o push:
    ```bash
    git add README.md
    git commit -m "Adicionado documentação README"
    git push
    ```

Vai ficar super profissional na sua apresentação! 🚀
