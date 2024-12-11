"""
Напишите скрипт, который логирует разные типы сообщений в разные файлы.
Логи уровня DEBUG и INFO должны сохраняться в debug_info.log, а логи уровня
WARNING и выше — в warnings_errors.log.
"""

import logging

# Настройка логгеров
logger = logging.getLogger("multi_logger")
logger.setLevel(logging.DEBUG)

# Форматы сообщений
formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')

# Хэндлер для DEBUG и INFO
debug_info_handler = logging.FileHandler("debug_info.log")
debug_info_handler.setLevel(logging.DEBUG)
debug_info_handler.setFormatter(formatter)

# Хэндлер для WARNING и выше
warnings_errors_handler = logging.FileHandler("warnings_errors.log")
warnings_errors_handler.setLevel(logging.WARNING)
warnings_errors_handler.setFormatter(formatter)

# Добавление хэндлеров к логгеру
logger.addHandler(debug_info_handler)
logger.addHandler(warnings_errors_handler)

# Примеры логов
logger.debug("This is a debug message")
logger.info("This is an info message")
logger.warning("This is a warning message")
logger.error("This is an error message")
logger.critical("This is a critical message")
