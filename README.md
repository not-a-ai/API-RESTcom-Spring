# API Java Spring

## Diagrama de classes

``` mermaid
classDiagram
    class User {
        - Long id
        - String name
        - String email
        - String password
        - BigDecimal balance
        + deposit(BigDecimal amount, String date)
        + withdraw(BigDecimal amount, String date)
        + getTransactions(): List~Transaction~
    }

    class Transaction {
        - Long id
        - BigDecimal amount
        - String date
        - String type
        - User user
    }

    User "1" -- "0..*" Transaction : makes
    Transaction "1" -- "1" User : by


```
