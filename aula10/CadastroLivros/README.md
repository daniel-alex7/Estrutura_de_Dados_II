# Cadastro de Livros — Java multicamada + MySQL

Projeto didático com interface de caracteres, JDBC e injeção de dependências por construtor. Sem Maven e sem frameworks. Requer JDK 17 (inclui javac), servidor MySQL e MySQL Connector/J. O MySQL Workbench é opcional para executar o SQL.

## Funcionalidades

Cadastrar, listar, consultar por código, alterar e excluir com confirmação. Campos: nome do livro, autor e ano de lançamento. O código é gerado pelo MySQL. Nome e autor são obrigatórios; ano entre 1 e 9999 (permite lançamentos futuros). Dados inválidos e códigos inexistentes recebem mensagens.

## Camadas e responsabilidades

| Pasta/classe | Responsabilidade |
| --- | --- |
| App | Monta os objetos e chama o Controller |
| controller | Coordena as opções do menu e as operações |
| view | Exibe mensagens e lê os dados no terminal |
| service | Valida os dados e aplica regras de negócio |
| model | Representa o livro |
| repository | Interface de persistência e implementação JDBC/SQL |
| config | Abre a conexão com o MySQL |

Fluxo de uma operação: App inicia Controller; Controller usa View para ler dados e chama Service; Service chama Repository; Repository usa Conexao para acessar o MySQL. O retorno percorre o caminho inverso até a View.

## 1. Criar o banco

Com o servidor MySQL iniciado, abra `sql/criar_banco.sql` no Workbench e execute todo o script. Ele cria `livraria_db` e `livros`, sem apagar os registros existentes.

## 2. Configurar a conexão

Edite `src/br/com/livraria/config/Conexao.java`. Ajuste URL (host e porta), USUARIO e SENHA para sua instalação. Por padrão: localhost, porta 3306, banco livraria_db, usuário root. Substitua SUA_SENHA pela senha real. Essa configuração no código é destinada à atividade local; não publique credenciais reais.

## 3. Adicionar o driver JDBC

Baixe MySQL Connector/J na página oficial: https://dev.mysql.com/downloads/connector/j/
Escolha o pacote independente de plataforma (Platform Independent), extraia e copie apenas `mysql-connector-j-X.Y.Z.jar` para `lib`. X.Y.Z representa a versão baixada; não renomeie o arquivo para esse texto literal. O driver não acompanha este projeto.

## 4. Executar no Windows / VS Code

1. Extraia o ZIP.
2. No VS Code, use **Arquivo > Abrir Pasta** e selecione `CadastroLivros` (a pasta que contém src, lib e sql).
3. Use a extensão **Extension Pack for Java** e um JDK 17 configurado.
4. Faça as configurações dos passos 1 a 3.
5. Abra App.java e use **Run Java**, ou execute a configuração **Executar Cadastro de Livros** com F5. Digite as opções no **Terminal**.
6. Alternativamente, abra o terminal na pasta do projeto e execute `executar.bat` no Prompt de Comando ou `.\executar.bat` no PowerShell. Também pode abrir executar.bat com duplo clique.

O arquivo executar.bat compila os fontes e inicia o programa com o driver no classpath. Nenhum comando mvn é necessário.

## Compilação manual (Windows, Prompt de Comando)

Na raiz do projeto:

```bat
mkdir bin
dir /s /b src\*.java > fontes.txt
javac -encoding UTF-8 -d bin @fontes.txt
java -Dfile.encoding=UTF-8 -cp "bin;lib/*" br.com.livraria.App
```

Em Linux/macOS, compile os mesmos fontes e use `:` no classpath: `java -cp "bin:lib/*" br.com.livraria.App`.

## Conferência prática

Cadastre um livro; liste; consulte seu código; altere autor e ano; encerre e reabra para conferir persistência; exclua e consulte novamente. Teste também nome vazio, ano inválido e código inexistente.

## Problemas comuns

- `No suitable driver`: falta o JAR do Connector/J no classpath/lib.
- `Access denied`: usuário ou senha incorretos.
- `Communications link failure`: servidor parado, host ou porta incorretos.
- `Unknown database`: execute o script SQL.
- `ClassNotFoundException: App`: use o nome completo `br.com.livraria.App` e execute a partir da pasta do projeto.
- Entrada no console de depuração: use o Terminal; a configuração fornecida já seleciona integratedTerminal.

## Observação de validação

Os fontes foram revisados, mas este ambiente de geração não dispõe do compilador javac nem de um servidor MySQL para teste integrado. Execute a conferência prática acima no ambiente local.
