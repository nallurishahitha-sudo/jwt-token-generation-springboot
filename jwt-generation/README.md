# JWT Generation - Spring Boot

## Requirements
- Java 21
- Maven (or Eclipse/STS with Maven integration)

## Import into Eclipse / STS
1. Extract `jwt-generation.zip`.
2. Open Eclipse/STS.
3. Select **File -> Import -> Maven -> Existing Maven Projects**.
4. Browse to the extracted `jwt-generation` folder.
5. Select the project and click **Finish**.
6. Wait for Maven dependencies to download.

## Run
Open `JwtGenerationApplication.java`, then select **Run As -> Spring Boot App**.

## Swagger UI
Open: http://localhost:8080/swagger-ui/index.html

Expand `POST /api/auth/generate-token`, click **Try it out**, and use:

```json
{
  "userId": 101,
  "username": "Shahitha",
  "email": "shahitha@gmail.com",
  "role": "STUDENT"
}
```

Click **Execute**. The response is a signed JWT string.

## Notes
- Token expiration is set to one hour.
- The token is signed using HS256 with the configured secret.
- The included secret is only for this classroom demonstration. Do not use it in production.
- This lab endpoint accepts the JSON payload directly. A production authentication system must build claims from a verified authenticated user.
