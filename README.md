# SecretSalty java backend

## Authenticating locally

In order to get an authentication token, simply use the firebase API.

* Create a new account using the UI (or simply have valid credentials)
* Use insomnia / postman / whatever to send a request:
    * POST https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword
    * JSON Body:
      ```
        {
              "email": "<email>",
              "password": "<password>",
              "returnSecureToken": true
        }
      ```
* this will return an idToken that can then be used in the other requests
    * simply use "Bearer Token" as auth method