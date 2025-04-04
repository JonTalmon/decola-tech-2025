# Decola Tech 2025

## Diagrama de Classes

```mermaid
erDiagram
    STUDENT ||--o{ ATTENDANCE : "has attendance"
    CLASS ||--o{ ATTENDANCE : "includes attendance"

    STUDENT {
        Long id PK
        String name
        String email
        String registration
    }

    CLASS {
        Long id PK
        String name
        String description
        LocalDate startDate
        LocalDate endDate
    }

    ATTENDANCE {
        Long id PK
        LocalDate date
        Boolean present
        Long student_id FK "FK to STUDENT.id"
        Long class_id FK "FK to CLASS.id"
    }
```
