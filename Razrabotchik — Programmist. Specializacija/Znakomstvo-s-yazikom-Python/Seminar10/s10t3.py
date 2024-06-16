"""
Создать новый столбец в таблице с
пингвинами, который будет отвечать за
показатель длины клюва пингвина.
high - длинный(от 42)
middle - средний(от 35 до 42)
low - маленький(до 35)
"""

from pandas import read_csv
from seaborn import histplot
from matplotlib.pyplot import show

penguins = read_csv('penguins.csv')

penguins.loc[penguins['bill_length_mm'] < 35, 'height_group'] = 'low'

penguins.loc[(penguins['bill_length_mm'] > 35) & (penguins['bill_length_mm'] < 42), 'height_group'] = 'middle'

penguins.loc[penguins['bill_length_mm'] > 42, 'height_group'] = 'high'

penguins.to_csv('penguins.csv', index=False)

"""
Изобразить гистограмму по flipper_length_mm
с оттенком height_group. Сделать анализ
"""

histplot(penguins, x='flipper_length_mm', hue='height_group')
show()