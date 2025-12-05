# ISCTE - Tecnologias e Arquitetura
## Engenharia de Software
### [cite_start]Ficha laboratorial nº 5: Testes de caixa-preta/aceitação na validação de sistemas de software [cite: 1, 2, 3, 4]

[cite_start]**Curso:** LETI/LEI/LEI-PL [cite: 5]
[cite_start]**Ano Letivo:** 2025/2026 [cite: 7]

---

### [cite_start]Objetivos [cite: 6]
Esta ficha laboratorial aborda o tópico de testes de caixa-preta, no contexto de aceitação de sistemas de software. [cite_start]Em concreto, serão testadas aplicações web com base no padrão de desenho de software Page Object Model (Nota: Não confundir com configuração POM no contexto do Maven)[cite: 8, 9, 28].

> **Nota:** É aceitável que esta ficha laboratorial não seja concluída integralmente na aula alocada para o efeito. [cite_start]Nesse caso, o trabalho deve continuar após a aula e as dúvidas que possam surgir serão esclarecidas nos horários de atendimento anunciados, ou acordados[cite: 10, 11].

### [cite_start]Instrumento de aprendizagem [cite: 12]
* [cite_start]Ferramenta Selenium [cite: 13]

### [cite_start]Informação de apoio [cite: 14]
* [cite_start]Apontamentos das aulas teóricas [cite: 15]
* [cite_start]Documentação de Selenium [cite: 16]
* [cite_start]IntelliJ IDEA - Web UI Test Automation [cite: 17]
* [cite_start]IntelliJ IDEA - Plugin Test Automation [cite: 18]
* [cite_start]Documentação de Selenide [cite: 19]
* [cite_start]Documentação de Allure Report [cite: 20]

---

## [cite_start]Introdução [cite: 21]

[cite_start]Os testes de caixa-preta, também denominados "testes funcionais", são testes de software em que a pessoa que os desenvolve não tem conhecimento da estrutura interna do software a testar[cite: 22]. [cite_start]Por norma são utilizados na fase de aceitação do software, tendo em consideração os requisitos que estiveram na base da sua implementação[cite: 23].

[cite_start]Nesta ficha iremos utilizar o software em código-aberto Selenium WebDriver para testar aplicações web, o qual faz parte da plataforma de testes Selenium[cite: 24]. [cite_start]Através da sua utilização será possível automatizar o processo de testes num browser, com simulação de interações do utilizador, repetição de tarefas e validação do comportamento da aplicação em vários browsers[cite: 25].

[cite_start]Conforme se depreende pelo nome, o Selenium WebDriver recorre a drivers para os browsers[cite: 26]. [cite_start]Nesta ficha vamos considerar apenas o browser Chrome, apesar de ser importante testar em vários browsers[cite: 27].

### [cite_start]Funcionalidades do Selenium WebDriver [cite: 30]

Abaixo apresenta-se um resumo das funcionalidades ilustradas na "Selenium Cheat Sheet":

[cite_start]**Basic Browser Operations** [cite: 31]
* [cite_start]Initialize WebDriver [cite: 32]
* [cite_start]Load Web Page [cite: 33]
* [cite_start]Maximize Window [cite: 33]
* [cite_start]Close Window [cite: 34]
* [cite_start]Quit Session [cite: 34]

[cite_start]**Advanced Interactions** [cite: 35]
* [cite_start]Switch to Alert [cite: 36]
* [cite_start]Switch to Frame [cite: 37]
* [cite_start]Execute JavaScript [cite: 37]

[cite_start]**Selenium WebDriver Waits** [cite: 39]
* [cite_start]Implicit Wait [cite: 40]
* [cite_start]Explicit Wait [cite: 40]

[cite_start]**Web Element Interaction** [cite: 41]
* [cite_start]Locate Element by ID [cite: 42]
* [cite_start]Click Element [cite: 43]
* [cite_start]Input Text [cite: 44]
* [cite_start]Clear Content [cite: 45]
* [cite_start]Retrieve Text [cite: 46]

[cite_start]**Navigational Commands** [cite: 47]
* [cite_start]Refresh Page [cite: 48]
* [cite_start]Navigate Back [cite: 49]
* [cite_start]Navigate Forward [cite: 50]

### [cite_start]Padrão de Desenho [cite: 51]
Relativamente ao desenho e implementação da automação de testes, será seguido o padrão de desenho de software **Page Object Model**. [cite_start]Assim, cada página web corresponderá a uma **classe de teste** e as interações com os elementos dessa página são definidas através de **métodos**[cite: 51, 52].

Refira-se também que um browser dispõe de um Web inspector, que permite mostrar o código HTML da página web e consequentemente obter um localizador único - CSS ou XPath para cada elemento da mesma (Web Element). [cite_start]Esta funcionalidade é genericamente designada por **Inspect Element**[cite: 53, 54].

> (Nota de rodapé: A estrutura de uma página web é definida pelo Document Object Model (DOM)[cite_start], e o seu conteúdo pode ser alterado dinamicamente)[cite: 67].

---

## [cite_start]Parte 1: Testes de aceitação com Selenium [cite: 55]

[cite_start]Verifique se tem o plugin **Test Automation** instalado e ativo, o qual é útil para o desenvolvimento e manutenção de testes automáticos de interface com o utilizador[cite: 56].

### [cite_start]A. Projeto-piloto de testes com Selenium [cite: 57]

[cite_start]Vamos começar por realizar testes num projeto gerado pelo IntelliJ[cite: 58].

**1. [cite_start]O membro de grupo com o MENOR número executa as seguintes tarefas:** [cite: 59]
* (a) No IntelliJ, crie um projeto Selenium com repositório Git, incluindo as opções Java, Maven e JUnit. Opte também por incluir código de demonstração e utilize a versão 4 do Selenium, sem incluir outras ferramentas[cite: 60, 61].
* (b) [cite_start]Verifique o conteúdo do ficheiro `pom.xml`[cite: 62].
* (c) [cite_start]Crie uma diretoria na raíz do projeto com o nome `reports`, com o propósito de esta vir a conter relatórios[cite: 63].
* (d) Coloque a identificação dos membros do grupo num ficheiro `README.md`[cite: 64].
* (e) [cite_start]Sem preocupação sobre a execução de testes, partilhe o projeto com os restantes membros do grupo tal como foi feito nas outras fichas[cite: 65].

**2. [cite_start]Os restantes membros do grupo criam uma cópia local do projeto partilhado.** [cite: 66]

**3. [cite_start]Cada membro do grupo no seu ramo de trabalho:** [cite: 69]
* (a) [cite_start]Tendo presente a documentação do Selenium, analise detalhadamente o código de demonstração e o ficheiro `browsers.json`[cite: 70].
* (b) Execute a classe de teste `MainPageTeste` e valide os resultados de execução. Note que é conveniente recorrer a instruções de paragem da execução, para avaliar pausadamente a sequência de operações, ou até para esperar que determinado elemento numa página web fique acessível. Para isso, use estratégias de espera do Selenium e `Thread.sleep()`[cite: 71, 72, 73].
* (c) Se algum dos testes falhar, comece por analisar as causas. [cite_start]Pode ser que falte alguma dependência no ficheiro `pom.xml`; ou alguma biblioteca do WebDriver esteja em falta ou não seja compatível com a versão do browser que utiliza[cite: 74, 75].
    * **Sugestão:** Faça a execução teste a teste e, para cada um, comece por validar os elementos definidos na classe `MainPage`. Note que neste tipo de testes automáticos é usual proceder à inspeção de elementos da página web em teste, nomeadamente sobre os localizadores/identificadores (CSS ou XPath). [cite_start]Recorra ao browser incorporado no IntelliJ, isto é, a ferramenta Web Inspector, e siga as sugestões sobre o assunto existentes na documentação do IntelliJ[cite: 76, 77, 78].
    * No código Java, atualize os localizadores de elementos das páginas que possam não estar corretos. Faça as correções necessárias para que os testes executem sem falhas[cite: 79, 80].
* (d) Após a execução dos testes com sucesso, faça Push do ramo de trabalho para o repositório remoto. [cite_start]**Nota:** Não se pretende que o conteúdo do ramo seja incorporado no ramo main remoto[cite: 81, 82].

### [cite_start]B. Automação de testes de elementos de interação [cite: 83]

[cite_start]Esta tarefa tem como objetivo principal adquirir experiência na automação de testes sobre elementos de interação em páginas web (Substituição de ações manuais)[cite: 84, 92]. [cite_start]Para isso, vamos recorrer a um conjunto de exemplos disponíveis no sitio de demonstração online **The Internet Heroku App**[cite: 85]. [cite_start]A implementação dos testes será feita no projeto anteriormente partilhado[cite: 86].

[cite_start]A tabela seguinte apresenta o conjunto de exemplos de teste a escolher pelo grupo, cuja distribuição entre membros deve ser feita do seguinte modo (assumindo divisão por quatro membros)[cite: 87]:
* Dois exemplos do tipo de interação com elemento básico[cite: 88];
* [cite_start]Dois exemplos do tipo de interação com elemento básico, mas distintos dos anteriores[cite: 89];
* [cite_start]Um exemplo do tipo de conteúdo dinâmico[cite: 90];
* Um exemplo do tipo de interação com elemento complexo[cite: 91].

**Tabela de Exemplos** [cite: 94]

| Tipo/exemplo | Caso de uso | Exemplo de simulação real | Exemplos Específicos |
| :--- | :--- | :--- | :--- |
| **Interação com elemento básico** | Clicks, alertas e formulários | Painéis Admin, páginas de login | Checkboxes<br>Dropdown<br>Basic Auth<br>Form Authentication<br>Horizontal Slider<br>Inputs<br>Notification Messages |
| **Conteúdo dinâmico** | Atraso de elementos, estratégias de espera | Carregamento de dashboards | Dynamic Content<br>Dynamic Loading |
| **Interação com elemento complexo** | Carregamento de ficheiros, validação de dados | Retoma de carregamento, gestores de ficheiros | File Upload<br>Secure File Download |

Cada membro do grupo deve desenhar e implementar os respetivos testes seguindo o padrão de software **Page Object Model**. Pode começar por consultar os exemplos em Java disponíveis na documentação do Selenium[cite: 95, 96].

No final, deve fazer Push do respetivo ramo de trabalho para o repositório remoto e solicitar a fusão com o ramo main através de **Pull Request**[cite: 97].

---

## Parte 2: Automação com Selenide e relatórios com Allure Report [cite: 98]

Nesta parte vamos testar parcialmente exemplos de utilização de aplicações web, recorrendo sobretudo a **Selenide** (ferramenta de automação baseada no Selenium WebDriver para tornar a escrita de testes mais fácil)[cite: 99, 102]. Também iremos gerar relatórios sobre a execução de testes de aceitação com a ferramenta **Allure Report**[cite: 99].

Os exemplos a considerar são análogos ao exemplo utilizado na ficha laboratorial nº 1, construído com Vaadin, mas mais simples[cite: 100]. A tabela seguinte apresenta um conjunto de exemplos online e respetivos testes de aceitação que se pretende realizar[cite: 101].

**Tabela de Test Suites** [cite: 104]

| Exemplo online | Test suite (#) | Exemplo de simulação real |
| :--- | :--- | :--- |
| **Bookstore** | 1 | Adicionar um produto |
| | 2 | Adicionar uma categoria |
| **Database** | 3 | Informação sobre filme |
| **Form** | 4 | Fazer parte da comunidade |
| **Sampler** | 5 | Aceder a um componente do tipo Interaction |
| **Sampler** | 6 | Aceder a um componente do tipo Data input |
| **Sampler** | 7 | Aceder a um componente do tipo Data presentation |
| **Sampler** | 8 | Aceder a um componente do tipo Basic features |

**1. [cite_start]De modo a utilizar a ferramenta Allure Report, atualize o ambiente de desenvolvimento da seguinte forma:** [cite: 105]
* (a) Instale o software Allure Report no computador - consulte a documentação Allure Report sobre a sua integração no IntelliJ[cite: 106].
* (b) Instale e ative o plugin **Allure TestOps Support** no IntelliJ. [cite_start]Embora o seu âmbito seja mais abrangente, de momento apenas estamos interessados na geração de relatórios[cite: 107, 108].

**2. [cite_start]O membro do grupo cuja conta GitHub aloja o projeto, deve atualizar o pom.xml de modo a acomodar a utilização de Selenide e Allure Framework.** [cite: 109]

Como sugestão, crie um projeto Selenium no IntelliJ numa janela distinta, só com o propósito de obter o `pom.xml` correto. [cite_start]Por exemplo, com as seguintes definições[cite: 110, 111]:

> [cite_start]**Definições de Novo Projeto (Sugestão):** [cite: 112-133]
> * Create Git repository: Unchecked
> * Language: Java
> * Build system: Maven
> * Test framework: JUnit
> * Group: isctelul.ista
> * Artifact: demo
> * JDK: openjdk-25
> * **Version:** Selenium 4
> * **Dependencies:**
    >     * Execution and Reporting
>     * Selenium (4.25.0)
>     * Allure Framework (2.29.0)
>     * Selenide (7.6.0)
> * Add sample code: Unchecked

[cite_start] Adicionalmente, coloque numa diretoria de recursos Maven, `src/test/resources`, um ficheiro com o nome `allure.properties` contendo o seguinte texto[cite: 134]:
properties
allure.results.directory=target/allure-results

[cite_start]No final destes ajustamentos, atualize o projeto no GitHub seguindo os procedimentos usuais[cite: 136].

**3. [cite_start]Cada membro do grupo, após atualização da cópia local do projeto partilhado, irá criar um ramo de trabalho próprio e implementar apenas UM test suite dos acima referidos, necessariamente distinto dos test suites implementados pelos outros membros do grupo[cite: 137].**

[cite_start]Assim, cada membro do grupo[cite: 138]:

* [cite_start]**(a)** Abre um **Issue** no projeto partilhado no GitHub indicando qual é o test suite que vai implementar[cite: 139].
    > [cite_start]**Nota:** Os test suites 1, 2 e 4 apresentam um grau de dificuldade superior[cite: 141].
* [cite_start]**(b)** Cria um pacote com nome sugestivo do test suite em `src -> test -> java`[cite: 140].
* [cite_start]**(c)** Nesse pacote, implementa os testes de aceitação recorrendo a **Selenide** e de acordo com os padrões de software **Page Object Model** e **Page Factory** referidos nas aulas teóricas[cite: 143]. [cite_start]As classes de caracterização distinta devem ser colocadas em pacotes distintos; por exemplo, as páginas-objeto devem ser colocadas no pacote respetivo[cite: 144, 145].

    [cite_start]Relembra-se que existe uma opção do IntelliJ para criar páginas-objeto, tal como se exemplifica abaixo[cite: 146]:
    > [cite_start]**New Selenium Page Object** [cite: 147]
    > [cite_start]* **File name:** VaadinDatabaseExampleDemoPage [cite: 148, 149]
    > [cite_start]* **URL (optional):** https://vaadin-database-example.demo.vaadin.com/ [cite: 150]
    > [cite_start]* **Language:** Java [cite: 151, 152]
    > [cite_start]* **Framework:** Selenide [cite: 153, 154]

* [cite_start]**(d)** Executa os testes[cite: 158].
* [cite_start]**(e)** Verifica o conteúdo da diretoria `target/allure-results` e, selecionando a mesma, executa **Allure Report: Generate On The Fly**[cite: 159]. [cite_start]O resultado fica patente no browser[cite: 160].
* [cite_start]**(f)** Repete a geração do relatório mas através da opção **Allure Report: Generate**, o que cria um novo relatório em `target/allure-results`[cite: 161].
* [cite_start]**(g)** Faz uma cópia do último relatório gerado para a diretoria `reports` do projeto, cujo nome final deve indiciar o test suite implementado (mantendo no entanto a referência ao momento de criação)[cite: 162].
* [cite_start]**(h)** Faz **Push** do respetivo ramo de trabalho para o repositório remoto e solicita a fusão com o ramo main através de **Pull Request**[cite: 163].
* [cite_start]**(i)** Encerra o **Issue** que criou inicialmente no projeto partilhado no GitHub, após o respetivo trabalho ter sido incorporado no ramo main remoto[cite: 164].

**4. [cite_start]O membro de grupo com o SEGUNDO MENOR número cria uma tag associada ao último commit realizado no projeto no GitHub[cite: 165].**

**5. [cite_start]No final, o grupo deve gravar um pequeno vídeo de demonstração com a execução dos test suites referidos nesta Parte 2 da ficha (máximo de 5 minutos) [cite: 166][cite_start].** O vídeo deve ser disponibilizado publicamente no YouTube, com indicação do link no topo do ficheiro `README` no GitHub[cite: 167].