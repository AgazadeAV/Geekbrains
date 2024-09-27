#!/bin/bash

# Убедитесь, что скрипт выполняется с правами суперпользователя
if [[ $EUID -ne 0 ]]; then
   echo "Пожалуйста, запустите этот скрипт от имени суперпользователя (sudo)." 
   exit 1
fi

# Сборка Docker-образа
docker build -t java_doc_generator .

# Запуск контейнера
docker run --rm -it --name hw1 java_doc_generator

# Копирование сгенерированной документации на хост
docker cp hw1:/app/doc ./doc

# Завершение работы с контейнером
docker stop hw1

echo "Процесс завершен! Документация скопирована в ./doc."
