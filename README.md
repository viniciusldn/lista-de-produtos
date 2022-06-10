### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio


# Desafio: Simular lista de Produtos

Neste desafio iremos simular uma API Rest que irá listar produtos e retornar um produto baseado em seu Id. 

**Atenção:** Aqui estamos "simulando", pois ainda não cobrimos o assunto de persistência de dados com Quarkus, vamos apenas validar o uso correto das anotações para Injeção de dependências, divisão em camadas e criar rotas HTTP do tipo GET._

Você terá que desenvolver uma aplicação que retorne uma lista de produtos para um estoque de um minimercado. Para isso você terá que expor duas rotas: uma para retornar todos os produtos, outra para obter o produto pelo seu id. Vamos ao passo a passo:

1. Execute o seguinte comando no terminal para a criação do seu projeto quarkus:

```
mvn io.quarkus.platform:quarkus-maven-plugin:2.6.3.Final:create \
    -DprojectGroupId=com.betrybe \
    -DprojectArtifactId=compras \
    -DprojectVersion=1.0.0 \
    -DclassName=com.betrybe.EstoqueController

```

2. Abra o projeto na IDE de sua preferência.

3. No arquivo `pom.xml` na seção `dependencies`, adicione a seguinte dependência para te auxiliar:

```
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-jsonb</artifactId>
    </dependency>
```

4. Agora crie três camadas dentro de "com.betrybe": Model, Service e Repository.

5. Dentro de Model, crie uma entidade chamada Produto, que deverá ter os seguintes requisitos:

    - Um atributo `id` do tipo `int`
    - Um atributo `nome` do tipo `String`
    - Um construtor vazio
    - Um construtor que recebe os dois parâmetros
    - Dois métodos `get()` para cada atributo criado

6. Dentro de Repository, use a classe abaixo, que está sem o uso de injeção de dependência, **que terá que ser feito por você.**

```java
package com.betrybe.repository;

import com.betrybe.model.Produto;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.stream.Collectors;


public class EstoqueRepository {

    public Map<Integer,Produto> produtos;

    public EstoqueRepository(){
        produtos = new HashMap<Integer,Produto>();
        produtos.put(1, new Produto(1, "Leite"));
        produtos.put(2, new Produto(2, "Ovo"));
        produtos.put(3, new Produto(3, "Suco"));
        produtos.put(4, new Produto(4, "Pão"));
    }

    public List<Produto> findAll(){
        return produtos.values().stream().collect(Collectors.toList());
    }

    public Produto findById(Integer id){
        return produtos.get(id);
    }
}

```

7. Dentro de Service, use a classe abaixo, que está sem o uso de injeção de dependência, **que terá que ser feito por você**:

```java
package com.betrybe.service;

import com.betrybe.model.Produto;
import com.betrybe.repository.EstoqueRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

public class EstoqueService {


    private EstoqueRepository repository;

    public List<Produto> listar(){
        return repository.findAll();
    }

    public Produto buscarPorId(Integer id){
        return repository.findById(id);
    }
}


```

8. Após isso, modifique a classe EstoqueController de tal modo que:

    - Ela possua o endpoint "/estoque" que liste todos os produtos;
    - Ela possua o endpoint "/estoque/id" que receba um id e retorne o produto relacionado a esse id;
    - Deve ser utilizada a classe EstoqueService através do uso de injeção de dependência.

Parabéns! Você construiu seu primeiro projeto com Quarkus e ainda criou uma API Rest. Continue assim que você continuará crescendo cada vez mais! #VQV

---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
