import re
import hashlib

def check_password_complexity(password):
    """ Проверяет сложность пароля. """
    if len(password) < 8:
        return False
    if not re.search(r'[a-z]', password):
        return False
    if not re.search(r'[A-Z]', password):
        return False
    if not re.search(r'\d', password):
        return False
    return True

def hash_password(password):
    """ Переводит пароль в хэш-значение. """
    # Используем алгоритм SHA-256 для хэширования
    sha256_hash = hashlib.sha256()
    sha256_hash.update(password.encode('utf-8'))
    return sha256_hash.hexdigest()

def main():
    password = input("Введите пароль: ")
    
    if check_password_complexity(password):
        hashed_password = hash_password(password)
        print(f"Пароль удовлетворяет требованиям сложности.")
        print(f"Хэш-значение пароля: {hashed_password}")
    else:
        print("Пароль не удовлетворяет требованиям сложности. Убедитесь, что он содержит не менее 8 символов, включая прописные и строчные буквы, а также цифры.")

if __name__ == "__main__":
    main()