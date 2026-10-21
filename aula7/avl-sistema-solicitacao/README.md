# Árvore AVL com Spring Boot — versão com Toast

Projeto didático em Java 17 e Spring Boot, organizado em camadas. A própria árvore AVL funciona como armazenamento em memória.

## Melhorias desta versão

- Front-end HTML + Bootstrap + JavaScript.
- Toast Bootstrap no lugar de `alert()` e `confirm()`.
- Respostas de inclusão e remoção padronizadas em JSON (`ApiResponse`).
- Tratamento das respostas HTTP no JavaScript.
- Código-fonte Java formatado para facilitar a avaliação e o uso em aula.
- Visualização textual da AVL com fator de balanceamento.

## Executar

No terminal, na pasta do projeto:

```bash
mvn spring-boot:run
```

Depois acesse `http://localhost:8080/`.

## Estrutura
winget install Apache.Maven
- `controller`: endpoints REST.
- `service`: regras da aplicação e injeção de dependência.
- `repository`: contrato e implementação da AVL.
- `model`: solicitação e nó da árvore.
- `dto`: dados de entrada e resposta da API.
- `resources/static`: front-end.
