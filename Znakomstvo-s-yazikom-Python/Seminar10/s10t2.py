"""
Написать EDA для датасета про пингвинов
Необходимо:
● Использовать 2-3 точечных графика
● Применить доп измерение в точечных графиках, используя
аргументы hue, size, style
● Использовать PairGrid с типом графика на ваш выбор
● Изобразить Heatmap
● Использовать 2-3 гистограммы

"""

from seaborn import load_dataset, scatterplot, PairGrid, heatmap
from matplotlib.pyplot import show
from matplotlib import pyplot

penguins = load_dataset('penguins')


# Написать EDA для датасета про пингвинов (разведочный анализ данных по дата сету)
# Необходимо:
# ● Использовать 2-3 точечных графика

def f_1():
    scatterplot(data=penguins, x="flipper_length_mm", y="body_mass_g")
    show()


# f_1()

# Применить доп измерение в точечных графиках, используя
# аргументы hue, size, style

def f_2():
    scatterplot(data=penguins, x="flipper_length_mm", y="body_mass_g", hue='sex', size='island', style='island')
    show()


# f_2()

# Использовать PairGrid с типом графика на ваш выбор

def f_3():
    x_vars = ["body_mass_g", "bill_length_mm", "bill_depth_mm", "flipper_length_mm"]
    y_vars = ['sex']
    pg = PairGrid(data=penguins, x_vars=x_vars, y_vars=y_vars, hue='species')
    pg.map(scatterplot)
    show()


# f_3()

# Изобразить Heatmap

def f_4():
    data = penguins.pivot_table(index='species', columns='island', values='body_mass_g')
    heatmap(data)
    pyplot.xlabel('Остров', size=14)
    pyplot.ylabel('Вид пингвинов', size=14)
    show()


# f_4()


# Использовать 2-3 гистограммы

def f_5():
    penguins['bill_depth_mm'].hist(bins=8)  # можно вызывать гистограмму, используя метод hist()
    show()


f_5()
