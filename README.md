# CoffeeCode

CoffeeCode: Exemplos práticos de Java, do básico ao avançado.

---

## Como gerar o Javadoc

### 1. Adicione comentários Javadoc ao seu código:

- Use o formato `/** ... */` antes de classes, métodos, atributos ou construtores.
- Inclua descrições e utilize as tags como `@param`, `@return`, `@author`.

### 2. Use o comando `javadoc`:

- O comando `javadoc` gera a documentação em formato HTML a partir dos comentários no código-fonte.
- Certifique-se de que o arquivo `.java` está salvo no diretório de trabalho.

### 3. Passos para gerar o Javadoc:

- Abra o terminal ou prompt de comando.
- Navegue até o diretório onde está o arquivo `.java`.
- Execute o comando:

```bash
javadoc -d pasta_destino NomeDoArquivo.java
```

- **`-d pasta_destino`:** Indica a pasta onde a documentação será salva.
- **`NomeDoArquivo.java`:** Arquivo de código-fonte que contém os comentários Javadoc.

### 4. Acesse a documentação:

- Após executar o comando, os arquivos HTML da documentação estarão na pasta especificada.
- Abra o arquivo **`index.html`** no navegador para visualizar.

### 5. Exemplo de comando:

Para gerar o Javadoc do arquivo `MeuPrograma.java` em uma pasta chamada `doc`, use:

```bash
javadoc -d doc MeuPrograma.java
```

---

