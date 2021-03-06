

 # java-notes-app
Aplicativo de notas.

 *Neste projeto foi usado Spring Boot 2, Maven, PostgreSQL, Bootstrap 4, JSF, PrimeFaces, JUnit, Hibernate e JPA.*

O **java-notes-app** consiste em um app web de notas, onde é possível criar uma nota com um Título, uma Descrição e uma Cor. Depois de criada, pode-se mudar a cor, título e o próprio corpo da nota. Podemos também marcar uma nota como concluída, fazendo-a sair da listagem de notas ativas e ir para a listagem de notas concluídas. (Existe um contador de notas para cada uma das listagens)

Foram feitos testes de unidade na classe *repository* de Notas.


## Como executar?
- Primeiro é necessário criar um banco no PostgreSQL chamado *db_javanotesapp*
- Depois você deverá alterar o usuário e senha de acesso ao banco de dados(src/main/resources/**application.properties**)
- Feito isso, você pode executar o projeto em uma IDE (IntelliJ, Eclipse...) ou pelo *terminal*.

## Executando pelo terminal
 Primeiro instale o Maven Plugin:
 
   `sudo apt install maven`
    
Após instalado, dentro do diretório do projeto execute o seguinte comando:

   `$ cd java-notes-app/`
e então
   `$ mvn spring-boot:run`
   
Link para acessar: http://localhost:8080/index.jsf
## Imagens do Sistema

### Página inicial (Listagem das notas ativas)
![Listagem Ativos](https://raw.githubusercontent.com/luca-gouveia/java-notes-app/master/images/web1.png%5D%28https://raw.githubusercontent.com/luca-gouveia/java-notes-app/master/images/web1.png)

### Listagem de notas concluídas
![Listagem Concluídos](https://raw.githubusercontent.com/luca-gouveia/java-notes-app/master/images/web2.png%5D%28https://raw.githubusercontent.com/luca-gouveia/java-notes-app/master/images/web2.png)
### Mobile 
![Mobile](https://raw.githubusercontent.com/luca-gouveia/java-notes-app/master/images/mobile.png)


____________Itens Cumpridos__________________<br>
A.<br>
B. <br>
C. <br>
D. <br>
F. <br>
G. <br>
H. <br>
J. 
