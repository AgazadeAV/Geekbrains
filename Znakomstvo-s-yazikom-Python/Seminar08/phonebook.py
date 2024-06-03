"""
реализовать копирование данных из файла А в файл B.
написать отдельную функцию copy_data:
прочитать список словарей (read_file)
и записать его в новый файл используя функцию standart_write
дополнить функцию main
"""
from csv import DictReader, DictWriter
from os.path import exists


class NameError(Exception):
    def __init__(self, txt):
        self.txt = txt


def get_info():
    while True:
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
        return list(f_r)


def copy_row(file_name, copied_file_name):
    if not validate_files(file_name, copied_file_name):
        return

    res = read_file(file_name)
    copied_res = read_file(copied_file_name)
    row_number = (int(input(f"Введите номер строки, которую хотите скопировать из {file_name} в {copied_file_name}: "))
                  - 1)
    copied_row = res[row_number]
    copied_row['№'] = str(len(copied_res) + 1)
    copied_res.append(copied_row)
    standard_write(copied_file_name, copied_res)


def remove_row(file_name):
    if not exists(file_name):
        print("Файл отсутствует, пожалуйста создайте файл.")
        return

    search = int(input("Введите номер строки для удаления: "))
    res = read_file(file_name)
    if search <= len(res):
        res = [row for row in res if int(row['№']) != search]
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
    if not exists(file_name):
        print(f"Файл {file_name} не найден. Сначала создайте его.")
        return

    data = read_file(file_name)
    standard_write(copied_file_name, data)
    print(f"Данные успешно скопированы из {file_name} в {copied_file_name}")


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


def validate_files(*files):
    for file in files:
        if not exists(file):
            print(f"Файл {file} отсутствует, пожалуйста создайте файл.")
            return False
    return True


def main():
    file_name = "phonebook.csv"
    commands = {
        "q": lambda: print("До свидания!"),
        "w": lambda: write_file(file_name) if exists(file_name) else create_file(file_name) or write_file(file_name),
        "r": lambda: print("\n".join(map(str, read_file(file_name)))) if exists(file_name) else print("Файл "
                                                                                                      "отсутствует, "
                                                                                                      "пожалуйста "
                                                                                                      "создайте файл."),
        "d": lambda: remove_row(file_name),
        "c": lambda: copy_data(file_name, input("Введите название нового файла: ") + ".csv"),
        "f": lambda: find_record(file_name),
        "cr": lambda: copy_row(file_name, input("Введите название файла, в который хотите скопировать: ") + ".csv")
    }

    while True:
        command = input("\n1. Для выхода из программы - 'q'\n2. Для записи данных - 'w'\n3. Для "
                        "чтения данных - 'r'\n4. Для удаления данных - 'd'\n5. Для копирования файла - 'c'\n6. Для "
                        "поиска данных - 'f'\n7. Для копии определенной строки в другой файл - 'cr'. "
                        "\nВведите команду: ").lower()
        if command in commands:
            if command == "q":
                commands[command]()
                break
            else:
                commands[command]()
        else:
            print("Некорректная команда, попробуйте снова.")


main()
