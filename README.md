# Sistema de Cursos para Java Spring Backend

## Descrição Geral
Uma API RESTful desenvolvida em Java com Spring Boot e JDBC para gerenciar cursos, turmas de treinamento e participantes. Implementa CRUD e segue as regras de negócio assim como foram descritas no escopo da tarefa. 

## Foram Utilizado
- Java 17
- Spring Boot
- PostgreSQL
- Maven
- JDBC

## Observações
- **A tabela Funcionario foi considerada como já existente. porem por conta da funcionalidade das outras partes do codigo, criei apenas uma copia no banco de dados.**
- Não foram implementados todos os testes automatizados por conta do tempo.
- Verificar nomes ao utilizar json, como escrever em letras minusculas e quando for adicionar um curso a uma turma, utilizar `codigoID` para a criação.

## Configuração do Ambiente
1. Configure o PostgreSQL e crie um banco de dados chamado `teste`.
2. Execute o script SQL fornecido no arquivo `schema.sql` para criar as tabelas.
3. Atualize o arquivo `application.properties` com user e password do banco.
4. Rode o projeto com `mvn spring-boot:run`.
5. Use o Postman para interagir com os endpoints.

## Endpoints Implementados
### Curso
- **POST /cursos**: Cria um curso
- **GET /cursos**: Lista todos os cursos
- **PUT /cursos/{codigo}**: Atualiza um curso
- **DELETE /cursos/{codigo}**: Deleta um curso

### Turma
- **POST /turmas**: Cria uma turma
- **GET /turmas**: Lista todas as turmas
- **PUT /turmas/{codigo}**: Atualiza uma turma
- **DELETE /turmas/{codigo}**: Deleta uma turma
- **GET /turmas/curso/{codigo}**: Lista turmas por curso

### TurmaParticipante
- **POST /turmas/{turmaId}/participantes?funcionarioId={idFuncionario}**: Adiciona um participante
- **GET /turmas/{turmaId}/participantes**: Lista participantes
- **DELETE /turmas/{turmaId}/participantes/{codigo}**: Remove um participante

## Estrutura do Banco de Dados
Descrição das tabelas usadas no projeto:
- **Curso**: Código, Nome, Descrição, Duração
- **Turma**: Código, Início, Fim, Local, Curso (Foreign Key para Curso)
- **TurmaParticipante**: Código, Turma (Foreign Key para Turma), Funcionário (Foreign Key para Funcionario)
