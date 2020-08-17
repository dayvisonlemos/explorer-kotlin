# Rover Project
### Executar Serviço
```sh
$ mvn test
$ mvn clean package
$ java -jar `target/explorer-0.0.1-SNAPSHOT.jar`
```
- A api é executada por padrão na porta 8080:
- Para acessar localmente, siga a url: http://127.0.0.1:8080/rest/mars
- É possível alterar a porta padrão adicionando a instrução: `-Dserver.port=<PORT> no comando de execução da API.
```sh
$ java -jar -Dserver.port=9090 target/explorer-0.0.1-SNAPSHOT.jar
```
### Executar commandos
- Uma missão é iniciada em uma área pré definida como uma matriz 5x5.
- O robô inicia a missão no canto esquerdo, inferior da area direcionado para o norte, definido em coordenadas como (0, 0, N).
- O comando para movimentação do Robo é: M. que deve ser adicionado na URL da API: http://127.0.0.1:8080/rest/mars/M
-- Este comando move o robô uma posição na área, movendo-o para  (0, 1, N).
- É possível rotacionar o robô para esquerda ou para direita utilizando os comandos L ou R respectivamente.
-- http://127.0.0.1:8080/rest/mars/R este comando direciona o robô para o leste, retornando a seguinte posição: (0, 0, E)
- É possível enviar uma sequencia de comandos para o robô:
-- http://127.0.0.1:8080/rest/mars/RMMLMMMLL retornando a seguinte posição: (2, 3, S)
- O Robô respeita a área definida para sua movimentação.

Os endpoints podem ser usados usando método GET
