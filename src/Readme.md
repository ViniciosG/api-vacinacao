Model - Tráfega os dados em todas as camadas do sistema até chegar no banco de dados e do banco de dados
para camadas do sistema.

Service - devera conter a lógica de negócio especifica e pode ser injetada como denpedencia de qualquer outro componente usando a Anotação @AUTOWIRED

Controller - Onde aceitará um path como parâmetro, tornando esse componente disponível para acesso
HTTP para o "path" adicioanado, também é possivel gerencar os verbos HTTP para acessos a API

DTO - Trafegar os dados das minhas requisiçoes HTTP de modo padronizado, 
Ex: Requisições exigem na maioria dos casos o envio de parametros, seja eles de configuração, formulários...
para que dados sejam facilmente manipulados e gerenciados, é recomendado a utilização desse tipo DTO. permitindo
que requisições sejam convertidos em objeto Java. Essa é  a vantagem a facil manipulação de dados.

Orientação a objeto  é um conceito que esta relacionado com a ideia de classificar , organizar e abstrair coisas

 -conceito do encapsulamento consiste em “esconder” os atributos da classe de quem for utilizá-la, é para que alguém que for usar a classe não a use de forma errada, sistema	 seja	 suscetível	 a	 mudanças:	 não	 precisaremos mudar	uma	 regra	de	negócio	em	vários	lugares,	mas	sim	em	apenas	um	único	lugar. exemplo 0x2

 -O	 construtor	 se	 resume	 a	 isso!	 Dar	 possibilidades	 ou	 obrigar	 o	 usuário	 de	 uma	 classe	 a	 passar
argumentos	para	o	objeto	durante	o	processo	de	criação	do	mesmo.

-herda tudo o que a outra classe tem, com o extends, exemplo gerente e funcionário. (superclasse de funcionario

-Um	atributo		protected		só	pode	ser	acessado	(visível)	pela	própria	classe


-Polimorfismo	 é	 a	 capacidade	 de	 um	 objeto	 poder	 ser	 referenciado	 de	 várias	 formas,  decidir	 qual
método	deve	ser	chamado,	sempre	 relacionando	com	sua	classe	de	verdade,	e	não	com	a	que	estamos
usando	 para	 referenciá-lo (classe mãe). diminuir	o	acoplamento	entre	as	classes,	para	evitar	que	novos
códigos	resultem	em	modificações	em	inúmeros	lugares


-O Hibernate abstrai o seu código SQL, toda a camada JDBC e o SQL será gerado em tempo de execução
ele vai gerar o SQL que serve para um determinado banco de dados, já que cada banco fala um "dialeto" diferente dessa linguagem
O Hibernate vai gerar o código SQL para qualquer
banco de dado, nesse projeto foi utilizado o Banco de Dados

Assim há também a possibilidade de trocar de banco de dados sem ter de alterar código Java, já que isso fica como responsabilidade da ferramenta.
Anotação é um recurso do Java que permite inserir metadados 
@Entity indica que objetos dessa classe se tornem "persistível" no banco de dados


ErrorValidationHandler - Da mesma forma, escrevi uma classe especial que será retornada em todos os casos de falha. Tendo uma estrutura de mensagem de erro consistente para todas as APIs, ajude os consumidores da API a escrever um código mais robusto.

ANTES - DBException, colocamos algumas informações na forma de mensagem e a lançamos
Erro de execução SQL
Não existem dados onde esperamos pelo menos uma linha
Existem várias linhas onde esperamos apenas uma única linha
Erro de parâmetros inválidos
e muitos mais casos

DEPOIS

ResponseEntityExceptionHandler é uma classe base conveniente para fornecer tratamento de exceção centralizado em todos os @RequestMappingmétodos por meio de @ExceptionHandlermétodos. @ControllerAdviceé mais para habilitar a verificação automática e configuração na inicialização do aplicativo.
enviar resposta de erro consistente e estruturada nas respostas da API. EVITAR MENSAGENS DESAGRADÁVEIS DO BANCO.
Isso permite um mecanismo que rompe com o modelo MVC mais antigo e faz uso de ResponseEntity junto com a segurança de tipo e flexibilidade de @ExceptionHandler :

Para validar regras de validação inserimos no DTO, onde o hibernate + jpa faz essa validação
JPA - Persistir objetos no banco é um ORM, todas aplicações de grande porte utilizam ele.
Entidade representa uma tabela no banco, caso possuir nome diferente use @Table
@ManyToOne - Uma vacina só pode estar ligada á um paciente apenas, Desta forma, o próprio JPA no Spring criará este relacionamento entre as entidades no banco de dados!











