### Задание 1
**Цель:** Выполнить запросы на выборку документов в MongoDB.

**Запрос:**
```javascript
db.posts.find({
  topics: "as",
  author: { $regex: "example\\.ru$" },
  score: { $gt: 100 }
})
```

### Задание 2
**Цель:** Добавить несколько документов в коллекцию MongoDB.

**Запрос:**
```javascript
db.posts.insertMany([
  {
    creation_date: new Date(),
    author: "skbx@example.com",
    topics: ["mongodb"]
  },
  {
    creation_date: new Date("2021-12-31"),
    author: "skbx@example.ru"
  }
])
```

### Задание 3
**Цель:** Создать композитный индекс и проверить его использование.

**Создание индекса:**
```javascript
db.users.createIndex({ first_name: 1, last_name: 1 })
```

**Проверка использования индекса:**
```javascript
db.users.find({ first_name: "John", last_name: "Doe" }).explain("executionStats")
```

### Задание 4
**Цель:** Анализировать данные с использованием агрегирующих запросов.

**Запрос:**
```javascript
db.users.aggregate([
  { $match: { visits: { $gt: 300 } } },
  {
    $group: {
      _id: { $substr: ["$first_name", 0, 1] },
      total_karma: { $sum: "$karma" }
    }
  }
])
```

### Задание 5
**Цель:** Создать хранимую функцию в MongoDB.

**Запрос на создание функции:**
```javascript
db.system.js.save({
  _id: "shuffle",
  value: function(str) {
    return str.split('').sort(function() {
      return 0.5 - Math.random();
    }).join('');
  }
})
```

**Использование функции:**
```javascript
db.eval("shuffle('example')")
```
