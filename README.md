# Desafio GuiaBolso

Essa projeto é um desafio técnico feito para o GuiaBolso

Desafio:
  Construir um mock de uma API HTTP de transações. Essa API deve rodar usando Docker e não pode usar recursos externos, como bando de dados e etc.
  
Regras de negócio:
  As regras de negócio podem ser encontradas em: https://github.com/GuiaBolso/seja-um-guia-back

Solução:
  Para esse desafio foram utilizados as seguintes tecnologias: Java, Gradle, Spring e Docker.
  A arquitetura basicamente utiliza comandos para executar as APIs. Ela foi projetada para ser facilmente escalável. Basicamente para criar novas APIs é preciso criar mais comandos e implementa as classes certas, o resto já está tudo configurado. Caso os comandos fiquem muito complexos eles podem ser quebrados em tarefas menores, os sub comandos. As tarefas menores vão ser executadas até conseguir completar a tarefa maior. Além disso foram criadas classes de validações que podem ser facilmente multiplicadas. A API está usando um mock que gera as transações, porém a arquitetura já está preparada para utilizar um banco.
  Além das regras de negócio apresentadas, foram incluídas algumas outras:
- O mês e ano não podem ser null ou 0.
- Os meses e anos não podem ser negativos;
- Mês não pode ser menor que 1 ou maior que 12
- A data deve estar no passado ou no mês atual (não dá para pegar transações que ainda não aconteceram!). Inclusive se você tentar pegar transações do mês atual ele só vai gerar transações até a data atual.
  
Instruções:

- O projeto precisa ser buildado. Utilize o comando: ./gradlew clean build na pasta raiz do projeto.
- Construa sua imagem docker utilizando o Dockerfile.
- Divirta-se :)

