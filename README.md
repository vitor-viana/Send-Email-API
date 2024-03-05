# Send Email API

<p>O Send Email API é um micro serviço de envio de e-mails.</p>

## Código SQL para a criação da tabela "email"
```
CREATE TABLE email (
    email_id BIGSERIAL,
    owner_ref VARCHAR(100) NOT NULL,
    email_from VARCHAR(200) NOT NULL,
    email_to VARCHAR(200) NOT NULL,
    send_date_email TIMESTAMP NOT NULL,
    subject VARCHAR(100) NOT NULL,
    text TEXT NOT NULL,
    status_email SMALLINT NOT NULL,
    PRIMARY KEY(email_id)
);
```

## Requisitos do sistema
 - Java17
 - Maven
 - PostgreSQL
 - Servidor SMTP do Gmail
 - Spring Boot
    - Spring Data JPA
    - Java Mail Sender 
    - Spring Web
    - PostgreSQL Driver
    - Validation

## Endpoints da API

/email
### Enviar e-mail
```
[POST] http://localhost:8080/email/send
```

**JSON**
<p>O e-mail que vai no campo 'emailFrom' é o que está configurado no arquivo 'application.properties'. Neste mesmo arquivo, tem a seguinte configuração 'spring.mail.password'. Neste campo, não é para colocar a senha do seu e-mail, mas sim a senha de APP configurada.</p>

```
{
	"ownerRef":"Nome de quem está enviando o e-mail",
	"emailFrom":"******@gmail.com",
	"emailTo":"******@gmail.com",
	"subject":"Titulo",
	"text":"Texto"
}
```

### Histórico
<P>Este endpoint retorna um JSON com o histórico de todos os e-mails enviados.</P>

```
[GET] http://localhost:8080/email/historic
```
