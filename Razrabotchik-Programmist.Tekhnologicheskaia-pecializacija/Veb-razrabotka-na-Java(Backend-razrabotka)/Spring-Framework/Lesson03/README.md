# JSON App

Приложение на Spring Boot для обработки HTTP-запросов и возвращения JSON-ответов.

## Запуск проекта

1. Убедитесь, что у вас установлена JDK 17+ и Maven.
2. Запустите приложение командой:
   ```bash
   mvn spring-boot:run
   ```
3. Откройте браузер и выполните запрос:
   ```bash
   http://localhost:8080/greet?name=John
   ```
   Результат:
   ```json
   {
     "id": 1,
     "message": "Hello, John!"
   }
   ```

## Используемые технологии
- Spring Boot
- Maven
