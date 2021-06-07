
<h2>Informações úteis de entendimento para o desenvolvimento da api rest com Spring Boot</h2>

- Para realizar paginação com Spring Data JPA, devemos utilizar a interface Pageable;
- Nas classes Repository, os métodos que recebem um pageable como parâmetro retornam objetos do tipo Page<>, ao invés de List<>;
- Para o Spring incluir informações sobre a paginação no JSON de resposta enviado ao cliente da API, 
devemos alterar o retorno do método do controller de List<> para Page<>;
- Para fazer a ordenação na consulta ao banco de dados, devemos utilizar também a interface Pageable, 
passando como parâmetro a direção da ordenação, utilizando a classe Direction, e o nome do atributo para ordenar;
- Para receber os parâmetros de ordenação e paginação diretamente nos métodos do controller, devemos habilitar o
módulo SpringDataWebSupport, adicionando a anotação @EnableSpringDataWebSupport na classe ForumApplication.

<h2>Sobre Spring Cache </h2>

- Para utilizar o módulo de cache do Spring Boot, devemos adicioná-lo como dependência do projeto no arquivo pom.xml;
- Para habilitar o uso de caches na aplicação, devemos adicionar a anotação @EnableCaching na classe Application (Main);
- Para que o Spring guarde o retorno de um método no cache, devemos anotá-lo com @Cacheable;
- Para o Spring invalidar algum cache após um determinado método ser chamado, devemos anotá-lo com @CacheEvict;
- Devemos utilizar cache apenas para as informações que nunca ou raramente são atualizadas no banco de dados.

<h2> Sobre Spring Security </h2>

- Para utilizar o módulo do Spring Security, devemos adicioná-lo como dependência do projeto no arquivo pom.xml;
- Para habilitar e configurar o controle de autenticação e autorização do projeto, devemos criar uma classe e anotá-la com @Configuration e @EnableWebSecurity;
- Para liberar acesso a algum endpoint da nossa API, devemos chamar o método http.authorizeRequests().antMatchers().permitAll() dentro do método configure(HttpSecurity http), que está na classe SecurityConfigurations;
- O método anyRequest().authenticated() indica ao Spring Security para bloquear todos os endpoints que não foram liberados anteriormente com o método permitAll();
- Para implementar o controle de autenticação na API, devemos implementar a interface UserDetails na classe Usuario e também implementar a interface GrantedAuthority na classe Perfil;
- Para o Spring Security gerar automaticamente um formulário de login, devemos chamar o método and().formLogin(), dentro do método configure(HttpSecurity http), que está na classe SecurityConfigurations;
- A lógica de autenticação, que consulta o usuário no banco de dados, deve implementar a interface UserDetailsService;
- Devemos indicar ao Spring Security qual o algoritmo de hashing de senha que utilizaremos na API, chamando o método passwordEncoder(), dentro do método configure(AuthenticationManagerBuilder auth), que está na classe SecurityConfigurations.

<h2> Sobre JWT </h2>

- Em uma API Rest, não é uma boa prática utilizar autenticação com o uso de session;
- Uma das maneiras de fazer autenticação stateless é utilizando tokens JWT (Json Web Token);
- Para utilizar JWT na API, devemos adicionar a dependência da biblioteca jjwt no arquivo pom.xml do projeto;
- Para configurar a autenticação stateless no Spring Security, devemos utilizar o método sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
- Para disparar manualmente o processo de autenticação no Spring Security, devemos utilizar a classe AuthenticationManager;
- Para poder injetar o AuthenticationManager no controller, devemos criar um método anotado com @Bean, na classe SecurityConfigurations, que retorna uma chamada ao método super.authenticationManager();
- Para criar o token JWT, devemos utilizar a classe Jwts;
- O token tem um período de expiração, que pode ser definida no arquivo application.properties;
- Para injetar uma propriedade do arquivo application.properties, devemos utilizar a anotação @Value.

<h2> Autenticação via JWT </h2>

- Para enviar o token JWT na requisição, é necessário adicionar o cabeçalho Authorization, passando como valor Bearer token;
- Para criar um filtro no Spring, devemos criar uma classe que herda da classe OncePerRequestFilter;
- Para recuperar o token JWT da requisição no filter, devemos chamar o método request.getHeader("Authorization");
- Para habilitar o filtro no Spring Security, devemos chamar o método and().addFilterBefore(new AutenticacaoViaTokenFilter(), UsernamePasswordAuthenticationFilter.class);
- Para indicar ao Spring Security que o cliente está autenticado, devemos utilizar a classe SecurityContextHolder, chamando o método SecurityContextHolder.getContext().setAuthentication(authentication).

<h2> Monitoramento </h2>

- Para adicionar o Spring Boot Actuator no projeto, devemos adicioná-lo como uma dependência no arquivo pom.xml;
- Para acessar as informações disponibilizadas pelo Actuator, devemos entrar no endereço http://localhost:8080/actuator;
- Para liberar acesso ao Actuator no Spring Security, devemos chamar o método .antMatchers(HttpMethod.GET, "/actuator/**");
- Para que o Actuator exponha mais informações sobre a API, devemos adicionar as propriedades management.endpoint.health.show-details=always e management.endpoints.web.exposure.include=* no arquivo application.properties;
- Para utilizar o Spring Boot Admin, devemos criar um projeto Spring Boot e adicionar nele os módulos spring-boot-starter-web e spring-boot-admin-server;
- Para trocar a porta na qual o servidor do Spring Boot Admin rodará, devemos adicionar a propriedade server.port=8081 no arquivo application.properties;
- Para o Spring Boot Admin conseguir monitorar a nossa API, devemos adicionar no projeto da API o módulo spring-boot-admin-client e também adicionar a propriedade spring.boot.admin.client.url=http://localhost:8081 no arquivo application.properties;
- Para acessar a interface gráfica do Spring Boot Admin, devemos entrar no endereço http://localhost:8081.


