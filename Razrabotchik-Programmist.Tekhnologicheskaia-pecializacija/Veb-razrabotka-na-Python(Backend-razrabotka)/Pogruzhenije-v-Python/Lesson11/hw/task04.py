"""
В программировании нередко необходимо создавать свои собственные
структуры данных на основе уже существующих. Одной из таких базовых
структур является стек.
Стек — это абстрактный тип данных, представляющий собой список элементов,
организованных по принципу LIFO (англ. last in — rst out, «последним пришёл —
первым вышел»).
Простой пример: стек из книг на столе. Единственной книгой, обложка которой
видна, является самая верхняя. Чтобы получить доступ, например, к третьей
снизу книге, нам нужно убрать все книги, лежащие сверху, одну за другой.
Напишите класс, который реализует стек и его возможности (достаточно будет
добавления и удаления элемента).
После этого напишите ещё один класс — «Менеджер задач». В менеджере задач
можно выполнить команду «новая задача», в которую передаётся сама задача
(str) и её приоритет (int). Сам менеджер работает на основе стека (не
наследование). При выводе менеджера в консоль все задачи должны быть
отсортированы по следующему приоритету: чем меньше число, тем выше задача.
Вот пример основной программы:
manager = TaskManager()
manager.new_task("сделать уборку", 4)
manager.new_task("помыть посуду", 4)
manager.new_task("отдохнуть", 1)
manager.new_task("поесть", 2)
manager.new_task("сдать ДЗ", 2)
print(manager)
Результат:
1 — отдохнуть
2 — поесть; сдать ДЗ
4 — сделать уборку; помыть посуду
Дополнительно: реализуйте также удаление задач и подумайте, что делать с
дубликатами.
"""

class Stack:
    def __init__(self):
        self.stack = []

    def push(self, item):
        """Добавить элемент в стек"""
        self.stack.append(item)

    def pop(self):
        """Удалить верхний элемент из стека"""
        if self.is_empty():
            return None
        return self.stack.pop()

    def peek(self):
        """Получить верхний элемент, не удаляя его"""
        if self.is_empty():
            return None
        return self.stack[-1]

    def is_empty(self):
        """Проверка на пустоту стека"""
        return len(self.stack) == 0

    def __str__(self):
        return str(self.stack)


class TaskManager:
    def __init__(self):
        self.tasks = Stack()

    def new_task(self, task, priority):
        """Добавить новую задачу в стек с приоритетом"""
        self.tasks.push((priority, task))

    def remove_task(self):
        """Удалить задачу с верхней позиции"""
        return self.tasks.pop()

    def __str__(self):
        """Вывести задачи, отсортированные по приоритету"""
        sorted_tasks = sorted(self.tasks.stack, key=lambda x: x[0])
        result = []
        current_priority = None
        current_tasks = []

        for priority, task in sorted_tasks:
            if priority != current_priority:
                if current_tasks:
                    result.append(f"{current_priority} — {'; '.join(current_tasks)}")
                current_priority = priority
                current_tasks = [task]
            else:
                current_tasks.append(task)

        if current_tasks:
            result.append(f"{current_priority} — {'; '.join(current_tasks)}")

        return "\n".join(result)


# Пример использования
manager = TaskManager()
manager.new_task("сделать уборку", 4)
manager.new_task("помыть посуду", 4)
manager.new_task("отдохнуть", 1)
manager.new_task("поесть", 2)
manager.new_task("сдать ДЗ", 2)

# Вывод задач, отсортированных по приоритету
print(manager)

# Удаляем верхнюю задачу
manager.remove_task()

# Вывод задач после удаления
print("\nПосле удаления задачи:")
print(manager)
