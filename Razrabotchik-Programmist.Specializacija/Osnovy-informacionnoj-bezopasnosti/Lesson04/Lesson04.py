import pandas as pd

# Путь к CSV-файлу
file_path = 'Lesson04/protection_measures.csv'

# Загрузка данных
data = pd.read_csv(file_path)

# Подсчет уникальных упоминаний мер защиты
protection_counts = data['Меры защиты'].value_counts()

# Создание DataFrame с результатами
results = pd.DataFrame({
    'Код меры защиты': [row.split(' ')[0] for row in protection_counts.index],
    'Наименование меры защиты': protection_counts.index,
    'Количество баллов': protection_counts.values
})

# Сортировка по убыванию количества баллов
results = results.sort_values(by='Количество баллов', ascending=False)

# Сохранение в Excel файл
output_file = 'Lesson04/sorted_protection_measures_with_details.xlsx'
results.to_excel(output_file, index=False)

print(f'Результаты сохранены в файл: {output_file}')
