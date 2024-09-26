# Используем образ OpenJDK 11 для Java
FROM openjdk:11

# Устанавливаем директорию, в которую будет копироваться код проекта
WORKDIR /app

# Копируем все файлы проекта в контейнер
COPY . /app

# Генерация Javadoc
RUN javadoc -d ./docs -sourcepath ./src/main/java ru.gb.jcore.sample ru.gb.jcore.regular

# Устанавливаем том для доступа к сгенерированной документации
VOLUME ["/app/docs"]

# Команда по умолчанию
CMD ["echo", "Documentation has been generated in the /app/docs directory"]
