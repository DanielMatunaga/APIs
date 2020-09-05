# API de transações

Proposta:
  Construir um mock de uma API HTTP de transações. Essa API deve rodar usando Docker e não pode usar recursos externos, como bando de dados e etc.
  
Regras de negócio:
  As regras de negócio são:
  - dado um conjunto de dados, formado por um id de usuário, um ano e um mês, deve-se retornar uma lista de transações
  - a lista de transações deve ter quantidade variável entre os meses
  - o id de usuário é um número inteiro de 1.000 a 100.000.000
  - cada transação deve ter uma descrição aleatória legível no formato string
  - essa descrição aleatória legível deve ser legível por humanos, isso significa que YhCekEr13RH não é válido, enquanto chaconapotalo pocanoçale é válido
  - cada descrição deve ter no mínimo 10 caracteres
  - cada descrição não pode superar 60 caracteres
  - caso o conjunto de transações tenha duas ou mais transações com a mesma descrição, data e valor, todas, menos uma, devem ter duplicated true
  - ao iterar 12 meses em um mesmo ano, no mínimo 3 meses devem ter uma transação ignorada
  - cada transação deve ter um valor aleatório
  - o valor da transação deve ser representado por um número inteiro
  - o valor da transação deverá ter seus 2 últimos dígitos representando os centavos
  - um valor de 8989 representa, portanto, R$ 89,89
  - o valor da transação deve estar entre -9.999.999 e 9.999.999, inclusive
  - cada transação deve ter o timestamp de uma data aleatória em formato long
  - a data aleatória deve estar dentro do range de ano e mês dados
  - dado dois conjuntos de dados iguais, as respostas devem ser as mesmas (pelo menos durante o dia que estivermos brincando)
  - utilize os status HTTP para representar os casos de excessão nas validações
  - além do status, deve ser respondido o motivo do erro
  - O mês e ano não podem ser null ou 0.
  - Os meses e anos não podem ser negativos;
  - Mês não pode ser menor que 1 ou maior que 12
  - A data deve estar no passado ou no mês atual (não dá para pegar transações que ainda não aconteceram!). Inclusive se você tentar pegar transações do mês atual ele só vai gerar transações até a data atual.

Solução:
  Para esse desafio foram utilizados as seguintes tecnologias: Java, Gradle, Spring e Docker.
  A arquitetura basicamente utiliza comandos para executar as APIs. Ela foi projetada para ser facilmente escalável. Basicamente para criar novas APIs é preciso criar mais comandos e implementa as classes certas, o resto já está tudo configurado. Caso os comandos fiquem muito complexos eles podem ser quebrados em tarefas menores, os sub comandos. As tarefas menores vão ser executadas até conseguir completar a tarefa maior. Além disso foram criadas classes de validações que podem ser facilmente multiplicadas. A API está usando um mock que gera as transações, porém a arquitetura já está preparada para utilizar um banco.

  
Instruções:

- O projeto precisa ser buildado. Utilize o seguinte comando: 
./gradlew clean build na pasta raiz do projeto.

- Construa sua imagem docker utilizando o Dockerfile.

- Inicie sua aplicação no docker mapeando a porta 8080. O seguinte comando pode ser utilizado: 
docker run -p 8080:8080 --name transacoes transacoes

- Divirta-se :)

