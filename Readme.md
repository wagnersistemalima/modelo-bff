# Projeto Modelo com Arquitetura Hexagonal e Princípios SOLID (DIP)

## Descrição do Projeto
Este projeto é um exemplo de aplicação utilizando **Java** e **Spring Boot**, estruturado com a **Arquitetura Hexagonal** e aplicando o princípio **DIP (Dependency Inversion Principle)** do SOLID. Ele demonstra como organizar o código para promover desacoplamento, flexibilidade e facilidade de manutenção.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Maven**
- **Lombok**

## Estrutura do Projeto
O projeto segue a **Arquitetura Hexagonal**, separando as responsabilidades em camadas bem definidas:

### 1. **Camada de Domínio**
- Contém as classes centrais do domínio, como `ModeloRequest` e `ModeloResponse`.
- Representa o núcleo da aplicação, independente de frameworks ou tecnologias externas.

### 2. **Camada de Casos de Uso**
- Define os contratos (interfaces) e implementações para os casos de uso, como `PostModeloUserCase` e `GetModeloUserCaseImpl`.
- Contém a lógica de negócio e orquestra as interações entre o domínio e as portas externas.

### 3. **Camada de Infraestrutura**
- Implementa as portas externas, como controladores REST (`ModeloController`) e mapeadores (`ModeloMapper`).
- Faz a integração com frameworks e tecnologias externas.

## Princípios SOLID Aplicados
### **DIP (Dependency Inversion Principle)**
- As classes dependem de abstrações (interfaces) em vez de implementações concretas.
- Exemplos:
    - `ModeloController` depende da interface `PostModeloUserCase`, e não de sua implementação concreta.
    - `PostModeloUserCaseImpl` utiliza a abstração `ModeloDomainMapper` para realizar o mapeamento de objetos.

## Exemplo de Fluxo
1. **Requisição HTTP**:
    - O cliente envia uma requisição POST para o endpoint `/modelos` com um `ModeloRequestDTO`.

2. **Controlador**:
    - `ModeloController` recebe a requisição, converte o DTO para o objeto de domínio usando `ModeloMapper` e delega a execução para o caso de uso `PostModeloUserCase`.

3. **Caso de Uso**:
    - `PostModeloUserCaseImpl` processa a lógica de negócio, valida os dados e retorna uma resposta.

4. **Resposta**:
    - O controlador converte o objeto de domínio para um DTO de resposta e retorna ao cliente.

## Estrutura de Pastas

````
src/
├── main/
│   ├── java/
│   │   ├── br/com/sistemalima/app/
│   │   │   ├── modelo/
│   │   │   │   ├── core/                # Camada de domínio e casos de uso
│   │   │   │   ├── infra/               # Camada de infraestrutura
│   │   │   │   │   ├── delivery/        # Controladores e mapeadores
│   │   │   │   │   ├── persistence/     # Contém as entidades mapeadas com JPA, que podem estender ou adaptar as entidades do domínio.
│   │   │   │   │   │   ├── repository/  # Interfaces e implementações de repositórios
│   │   │   │   ├── application/         # Configurações da aplicação        # Configurações da aplicação

````