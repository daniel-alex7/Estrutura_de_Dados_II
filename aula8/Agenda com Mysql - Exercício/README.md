# Agenda de contatos — Java, JDBC e MySQL

Projeto didático de console, sem framework. Usa Maven apenas para baixar o driver JDBC do MySQL.

## Camadas

`Main` cria os objetos e chama `ContatoController.iniciar()`. O controlador conduz o menu e as operações, solicita entradas à `AgendaView`, chama `ContatoService` e devolve resultados à `AgendaView` para exibição. O serviço valida os dados e usa `ContatoRepository` para SQL/JDBC no MySQL. `Contato` representa os dados; `Conexao` abre conexões. A view não conhece o controller nem acessa o banco.

## Pré-requisitos

- JDK 8 ou posterior, Maven e MySQL em execução.
- No VS Code, abra **a pasta agenda-java-mysql**. Recomenda-se a extensão **Extension Pack for Java**.

## Preparação

1. Execute `sql/agenda.sql` no MySQL Workbench ou no cliente de sua preferência. No terminal MySQL: `mysql -u root -p < sql/agenda.sql` (em Windows, pode abrir o arquivo pelo Workbench).
2. No terminal integrado do VS Code, configure o usuário e a senha de uma conta MySQL com acesso ao banco `agenda_db`:

PowerShell:

```powershell
$env:AGENDA_DB_USER="root"
$env:AGENDA_DB_PASSWORD="sua_senha"
```

Prompt de Comando (cmd):

```cmd
set AGENDA_DB_USER=root
set AGENDA_DB_PASSWORD=sua_senha
```

Bash:

```bash
export AGENDA_DB_USER=root
export AGENDA_DB_PASSWORD='sua_senha'
```

3. No mesmo terminal, na pasta do projeto, execute `mvn compile exec:java`.

A senha fica no ambiente do processo, fora do código-fonte. Se o MySQL usar outra porta ou máquina, edite a URL em `src/main/java/br/com/exemplo/agenda/config/Conexao.java`. O primeiro build pode precisar acessar o Maven Central. Para evitar problemas com o terminal de entrada, execute pelo terminal integrado, e não pelo botão **Run Code** da extensão Code Runner.

## Operações

Cadastrar, listar, buscar por ID, alterar e excluir. Telefone é `String` para preservar zeros à esquerda, espaços e símbolos. As consultas usam `PreparedStatement` e cada acesso fecha conexão e recursos automaticamente com try-with-resources.
