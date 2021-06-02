
<h2>Informações úteis de entendimento para o desenvolvimento da api rest com Spring Boot</h2>

- Para realizar paginação com Spring Data JPA, devemos utilizar a interface Pageable;
- Nas classes Repository, os métodos que recebem um pageable como parâmetro retornam objetos do tipo Page<>, ao invés de List<>;
- Para o Spring incluir informações sobre a paginação no JSON de resposta enviado ao cliente da API, 
devemos alterar o retorno do método do controller de List<> para Page<>;
- Para fazer a ordenação na consulta ao banco de dados, devemos utilizar também a interface Pageable, 
passando como parâmetro a direção da ordenação, utilizando a classe Direction, e o nome do atributo para ordenar;
- Para receber os parâmetros de ordenação e paginação diretamente nos métodos do controller, devemos habilitar o
módulo SpringDataWebSupport, adicionando a anotação @EnableSpringDataWebSupport na classe ForumApplication.
