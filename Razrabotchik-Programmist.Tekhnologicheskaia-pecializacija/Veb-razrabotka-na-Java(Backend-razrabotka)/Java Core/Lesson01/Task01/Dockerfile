# Используем официальный образ JDK 11
FROM openjdk:11-jdk

# Установка необходимых пакетов (если потребуется)
RUN apt-get update && apt-get install -y \
    && apt-get clean

# Создание рабочей директории
WORKDIR /app

# Копирование исходного кода в контейнер
COPY src/ .

# Запуск Javadoc для генерации документации
RUN javadoc -d doc -sourcepath ru/gb/jcore/regular:ru/gb/jcore/sample -subpackages ru.gb.jcore

# Указание точки входа (можно изменить на команду для открытия документации)
CMD ["bash"]
