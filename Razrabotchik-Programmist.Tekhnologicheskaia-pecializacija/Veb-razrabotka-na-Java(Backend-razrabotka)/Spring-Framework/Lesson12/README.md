# Design Patterns Project

Этот проект демонстрирует использование четырех популярных паттернов проектирования (**Singleton**, **Factory**, **Strategy**, **Decorator**) в приложениях на Java с использованием Spring Boot.

Каждый модуль иллюстрирует, как паттерны помогают решать определенные проблемы проектирования и упрощают поддержку, расширение и тестирование кода.

---

## Модули проекта

### 1. **Singleton Pattern**
- **Описание**:
  Этот паттерн гарантирует, что определенный класс будет иметь только один экземпляр в приложении. В данном модуле используется `LoggingService` как синглтон-компонент.

- **Проблема**:
  Необходимо централизовать ведение логов, чтобы избежать создания множества экземпляров и обеспечить консистентное поведение.

- **Решение**:
  Использование Spring Boot, который автоматически создает синглтон-компоненты для бинов. `LoggingService` является синглтоном и используется для регистрации сообщений в разных частях приложения.

---

### 2. **Factory Pattern**
- **Описание**:
  Этот паттерн используется для создания объектов без явного указания их конкретных классов. Модуль реализует фабрику `NotificationFactory`, которая создает различные типы уведомлений (`EmailNotificationService`, `SmsNotificationService`).

- **Проблема**:
  Необходимо предоставить гибкий способ создания различных типов уведомлений в зависимости от входных данных.

- **Решение**:
  Фабрика инкапсулирует логику создания объектов и позволяет легко добавлять новые типы уведомлений, изменяя только фабрику.

---

### 3. **Strategy Pattern**
- **Описание**:
  Этот паттерн позволяет определить семейство алгоритмов, инкапсулировать их и сделать их взаимозаменяемыми. В модуле реализованы два способа оплаты (`CreditCardPayment`, `PaypalPayment`), которые выбираются в зависимости от пользовательского ввода.

- **Проблема**:
  Необходимо обеспечить поддержку нескольких алгоритмов оплаты, сохраняя гибкость и модульность кода.

- **Решение**:
  Контекст `PaymentContext` определяет, какой алгоритм использовать, и делегирует выполнение стратегии соответствующему классу. Это упрощает добавление новых способов оплаты.

---

### 4. **Decorator Pattern**
- **Описание**:
  Этот паттерн используется для динамического добавления новой функциональности к объекту. Модуль включает `BasicDataProcessor` для обработки данных и `EncryptedDataProcessor`, который добавляет шифрование поверх основной обработки.

- **Проблема**:
  Необходимо добавить шифрование данных, не изменяя существующий класс обработки данных.

- **Решение**:
  `EncryptedDataProcessor` оборачивает `BasicDataProcessor` и добавляет шифрование. Это делает код более гибким и модульным, позволяя добавлять другие декораторы без изменения существующего кода.

---

## Почему выбраны эти паттерны?

1. **Singleton**: Используется, когда важно гарантировать наличие только одного экземпляра класса, например, для логирования или управления настройками приложения.

2. **Factory**: Подходит для создания объектов с множественными вариациями. Упрощает процесс добавления новых типов объектов.

3. **Strategy**: Позволяет выбирать алгоритм поведения в зависимости от контекста. Это снижает связанность и улучшает расширяемость.

4. **Decorator**: Полезен для динамического добавления функциональности без изменения существующего кода, что улучшает гибкость системы.

