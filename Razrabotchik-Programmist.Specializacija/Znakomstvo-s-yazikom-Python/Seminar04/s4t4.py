for i in 'hello world':
    if i == 'a':
        break
else:
    print('Буквы a в строке нет')


def func(my_str='hello world'):
    if len(my_str) != 0:
        if my_str[0] == 'a':
            return
        else:
            func(my_str[1:])
    else:
        print('Буквы a в строке нет')

func()

"""https://pythonist.ru/category/tests/"""