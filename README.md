# ITIDIGITAL - Backend Challenge

## Objetivo
Esse serviço propõem em fazer uma análise de senha com o dado passado no serviço, com base a regra que deve ser seguida:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial (!@#$%^&*()-+)
- Não possuir caracteres repetidos dentro do conjunto



## Solução

A solução que eu tive era de utilizar a ideia de Expressões Regulares (RegEx), que faria uma análise mais fácil e certa tendo como um retorno um código mais límpo e com menos quantidade de linhas para desenvolver.

- Regex utilizado para validar as 4 primeiras regras listado acima.

```
^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()-+])[A-Za-z\d!@#$%^&*()-+]{9,}$
```

- Regex utilizado para validar a ultima regra

```
(.)(?=\\S*\\1)"
```


## Tecnologia Utilizada:
- Javan 11
- Spring Boot - 2.5.2   
- JUnit 5
- Swagger

## Como inicializar

Para você desenvolvedor(a), deve ter instalado em sua máquina o **Java 11** para que a aplicação funcione.

Siga os passos asseguir para efetuar corretamente que a aplicação rode em seu computador:
 
 - 1º Instalando as dependências
  
 ```
 mvn clean install
 ```
 - 2º Inicializa a aplicação

  A  aplicação, ao incializar, deve aparecer dessa forma. A porta do servidor está apontando para a 8081
  
  ![image](https://user-images.githubusercontent.com/30670185/127032644-c7093221-4868-44b4-832d-63c9dbe598fb.png)

- 3º Acessando as API'S
  
  Após inicializar vocè deve entrar na URL http://localhost:8081/swagger-ui/ ou http://localhost:8081/swagger-ui/index.html , que redirecionará para o Swagger da aplicação.
