# Funções

Exemplo extraído do livro 'Código Limpo - Habilidades Práticas do Agile Software, da Série de Robert C. Martin'

## Classe HtmlUtil.java

```java
    /**
     * Código longo, repetido, há diversas Strings estranhas e muitos tipos de dados e APIs esquisitos e nada óbvios.
     * Quanto você consegue compreender?
     */
    public class HtmlUtil {
    
        public static String testableHtml(PageData pageData, boolean includeSuiteSteup) throws Exception {
            WikiPage wikiPage = pageData.getWikiPage();
            StringBuffer buffer = new StringBuffer();
            if (pageData.hasAttribute("Test")) {
                if (includeSuiteSteup) {
                    WikiPage suiteSetup = PageCrawlerImpl.getInheritedPage(
                            SuiteResponder.SUITE_SETUP_NAME, wikiPage
                    );
                    if (suiteSetup != null) {
                        WikiPagePath pagePath = suiteSetup.getPageCrawler().getFullPath(suiteSetup);
                        String pagePathName = PathParser.render(pagePath);
                        buffer
                                .append("!include -setup .")
                                .append(pagePathName)
                                .append("\n");
                    }
                }
                WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
                if (setup != null) {
                    WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
                    String setupPathName = PathParser.render(setupPath);
                    buffer
                            .append("!include -setup .")
                            .append(setupPathName)
                            .append("\n");
                }
            }
            buffer.append(pageData.getContent());
            if (pageData.hasAttribute("Test")) {
                WikiPage teardown = PageCralerImpl.getInheritedPage("TearDown", wikiPage);
                if (teardown != null) {
                    WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
                    String tearDwonPathName = PathParser.render(tearDownPath);
                    buffer
                            .append("!include -teardown .")
                            .append(tearDwonPathName)
                            .append("\n");
                }
                if (includeSuiteSteup) {
                    WikiPage suiteTeardown = PageCrawlerImpl.getInheritedPage(
                            SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage
                    );
                    if (suiteTeardown != null) {
                        WikiPagePath pagePath = suiteTeardown.getPageCrawler().getFullPath(suiteTeardown);
                        String pagePathName = PathParser.render(pagePath);
                        buffer
                                .append("!include -teardown .")
                                .append(pagePathName)
                                .append("\n");
                    }
                }
            }
            pageData.setContent(buffer.toString());
            return pageData.getHtml();
        }
    }
```

### O que é compreensível:

1. **Propósito geral**:
    - O método `testableHtml` parece gerar o conteúdo HTML para uma página `PageData`, considerando configurações de
      testes (`Setup`, `SuiteSetup`, `Teardown` e `SuiteTeardown`).
    - Ele manipula o conteúdo da página baseado em atributos e configurações específicas.

2. **Estrutura do código**:
    - Usa classes como `PageCrawlerImpl`, `PathParser`, `SuiteResponder` para buscar páginas relacionadas (`SetUp`,
      `TearDown`, etc.).
    - Monta o conteúdo usando `StringBuffer`.

3. **Atributos e decisões lógicas**:
    - Verifica se a página é um teste (`pageData.hasAttribute("Test")`).
    - Decide incluir ou não configurações específicas baseando-se no parâmetro `includeSuiteSteup`.

### Problemas que dificultam a compreensão:

#### 1. **Nomes ambíguos e inconsistentes**:

- `testableHtml`: O nome do método não é claro. Ele retorna um HTML "testável", mas o que isso significa?
- Variáveis como `buffer` poderiam ter nomes mais descritivos, como `htmlContent`.
- Erros de digitação em variáveis:
    - `includeSuiteSteup` deveria ser `includeSuiteSetup`.
    - `tearDwonPathName` deveria ser `tearDownPathName`.

#### 2. **Repetição de código**:

- A lógica para incluir `SetUp`, `SuiteSetup`, `TearDown` e `SuiteTeardown` é muito parecida e poderia ser extraída para
  um método auxiliar que recebe o tipo da página como parâmetro.

#### 3. **Uso de APIs pouco claras**:

- `PageCrawlerImpl`, `PathParser`, `SuiteResponder`, `WikiPage`, etc., não são APIs padrão do Java, então, sem contexto
  adicional, fica difícil entender suas funções e relações.

#### 4. **Excesso de dependências**:

- O método manipula diversas classes (ex.: `WikiPage`, `WikiPagePath`, `PageCrawlerImpl`), aumentando a complexidade e o
  acoplamento.

#### 5. **Falta de tratamento de erros e clareza**:

- O método lança `Exception` genérica, mas não há tratamento ou log de erros.
- Não está claro o que acontece se uma página (`setup`, `teardown`, etc.) não puder ser processada.

---

### Código refatorado

```java
public class HtmlUtil {

    // Código Refatorado
    public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) {
        boolean isTestPage = pageData.hasAttribute("Test");
        if (isTestPage) {
            WikiPage testPage = pageData.getWikiPage();
            StringBuffer newPageContent = new StringBuffer();
            includeSetupPages(testPage, newPageContent, isSuite);
            newPageContent.append(pageData.getContent());
            includeTeardwnPages(testPage, newPageContent, isSuite);
            pageData.setContent(newPageContent.toString());
        }
        return pageData.getHtml();
    }
}
```

---

### Código refatorado novamente

```java
public class HtmlUtil {

    // Código Refatorado Novamente
    public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) {
        boolean isTestPage = pageData.hasAttribute("Test");
        if (isTestPage(pageData)) 
            includeSetupAndTeardownPages(pageData, isSuite);
        return pageData.getHtml();
    }
}
```

