from csv import DictReader, DictWriter
from os.path import exists


class NameError(Exception):
    def __init__(self, txt):
        self.txt = txt


def get_info():
    flag = False
    while not flag:
        try:
            first_name = input("Введите имя: ")
            if len(first_name) < 2:
                raise NameError("Слишком короткое имя")
            second_name = input("Введите фамилию: ")
            if len(second_name) < 4:
                raise NameError("Слишком короткая фамилия")
            phone_number = input("Введите номер телефона: ")
            if len(phone_number) < 11:
                raise NameError("Слишком короткий номер телефона")
        except NameError as err:
            print(err)
        else:
            flag = True
    return [first_name, second_name, phone_number]


def create_file(file_name):
    with open(file_name, 'w', encoding='utf-8', newline='') as data:
        f_w = DictWriter(data, fieldnames=['№', 'first_name', 'second_name', 'phone_number'])
        f_w.writeheader()


def write_file(file_name):
    user_data = get_info()
    res = read_file(file_name)
    count = str(len(res) + 1)
    new_obj = {'№': count, 'first_name': user_data[0], 'second_name': user_data[1], 'phone_number': user_data[2]}
    res.append(new_obj)
    standard_write(file_name, res)


def read_file(file_name):
    with open(file_name, encoding='utf-8') as data:
        f_r = DictReader(data)
        return list(f_r)  # список словарей


def remove_row(file_name):
    if not exists(file_name):
        print("Файл отсутствует, пожалуйста создайте файл.")
        return
    search = int(input("Введите номер строки для удаления: "))
    res = read_file(file_name)
    if search <= len(res):
        res = [row for row in res if int(row['№']) != search]
        # Обновляем идентификаторы после удаления
        for i, row in enumerate(res):
            row['№'] = str(i + 1)
        standard_write(file_name, res)
        print(f"Строка номер {search} удалена.")
    else:
        print("Введён неправильный номер")


def standard_write(file_name, res):
    with open(file_name, 'w', encoding='utf-8', newline='') as data:
        f_w = DictWriter(data, fieldnames=['№', 'first_name', 'second_name', 'phone_number'])
        f_w.writeheader()
        f_w.writerows(res)


def copy_data(file_name, copied_file_name):
    if exists(file_name):
        data = read_file(file_name)
        standard_write(copied_file_name, data)
        print(f"Данные успешно скопированы из {file_name} в {copied_file_name}")
    else:
        print(f"Файл {file_name} не найден. Сначала создайте его.")


def find_record(file_name):
    if not exists(file_name):
        print("Файл отсутствует, пожалуйста создайте файл.")
        return

    criterion = input("Введите характеристику для поиска (№, first_name, second_name, phone_number): ")
    if criterion not in ['№', 'first_name', 'second_name', 'phone_number']:
        print("Некорректная характеристика для поиска.")
        return

    value = input(f"Введите значение для поиска по {criterion}: ")
    records = read_file(file_name)
    results = [record for record in records if record[criterion] == value]

    if results:
        for result in results:
            print(result)
    else:
        print("Запись не найдена.")


file_name = "phonebook.csv"
copied_file_name = "phonebook_copy.csv"


def main():
    while True:
        command = input("\n1. Для выхода из программы - 'q'\n2. Для записи данных - 'w'\n3. Для "
                        "чтения данных - 'r'\n4. Для удаления данных - 'd'\n5. Для копирования файла - 'c'\n6. Для "
                        "поиска данных - 'f'\nВведите команду: ")
        if command.lower() == "q":
            print("До свидания!")
            break
        elif command.lower() == "w":
            if not exists(file_name):
                create_file(file_name)
            write_file(file_name)
        elif command.lower() == "r":
            if not exists(file_name):
                print("Файл отсутствует, пожалуйста создайте файл.")
                continue
            for row in read_file(file_name):
                print(row)
        elif command.lower() == "d":
            remove_row(file_name)
        elif command.lower() == "c":
            copy_data(file_name, copied_file_name)
        elif command.lower() == "f":
            find_record(file_name)


main()
