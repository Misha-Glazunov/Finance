## 💰 Personal FinanceApp
Консольное приложение для управления личными финансами с системой бюджетов и статистикой. Позволяет отслеживать доходы, расходы и устанавливать лимиты по категориям.

## Видео - пример работы приложения

[https://www.dropbox.com/scl/fi/dvtcdv3ma5c9novllkafj/finance-app.mp4?rlkey=z7npw728rb75c0uzb2sg58gzz&st=2iltnhs2&dl=0](https://www.dropbox.com/scl/fi/dvtcdv3ma5c9novllkafj/finance-app.mp4?rlkey=z7npw728rb75c0uzb2sg58gzz&st=2iltnhs2&dl=0)

## 🚀 Быстрый старт
🐳 Запуск через Docker (рекомендуется)
```bash
# Сборка и запуск
docker compose up --build
# Или вручную
docker build -t finance-app .
docker run -it finance-app
```

⚙️ Ручная установка
```bash
# Клонирование репозитория
git clone https://github.com/Misha-Glazunov/Finance
cd java-finance-app

# Компиляция
javac src/*.java

# Запуск
java -cp src FinanceApp
```
## 📖 Использование
🔐 Регистрация и вход
```text
1. Register
2. Login
3. Add Income
4. Add Expense
5. Set Budget
6. View Statistics
7. Logout
8. Exit
```

💸 Добавление дохода
```text
Enter income amount: 50000
Enter category: Salary
Income added: 50000.0 to category Salary
```
🛒 Добавление расхода
```text
Enter expense amount: 1500
Enter category: Food
Expense added: 1500.0 to category Food
```
🎯 Установка бюджета
```text
Enter category: Food
Enter budget amount: 10000
Budget set: 10000.0 for category Food
```
## 🏗 Архитектура
📁 Структура проекта
```text
src/
├── FinanceApp.java           # Основной класс с меню и логикой
├── User.java                 # Модель пользователя
├── Wallet.java               # Кошелек с операциями
└── Transaction.java          # Модель транзакции
```
## 🎯 Ключевые компоненты
👤 Модель User
- Учетные данные (логин/пароль)
- Привязанный кошелек
- Методы аутентификации

```java
User user = new User("username", "password");
```
💼 Кошелек Wallet
- Баланс в реальном времени
- История транзакций
- Система бюджетов по категориям
- Предупреждения о превышении лимитов

💳 Транзакция Transaction
- Тип (Income/Expense)
- Сумма
- Категория
- Автоматическое отслеживание

## ⚙️Функциональность
✅ Управление финансами
- Доходы - добавление с указанием категории
- Расходы - контроль с предупреждениями о бюджете
- Баланс - автоматический расчет в реальном времени

## 📊 Статистика и аналитика
```text
--- Wallet Statistics ---
Total Balance: 48500.0
Total Income: 50000.0
Total Expenses: 1500.0
Budgets:
Category: Food, Budget: 10000.0, Remaining: 8500.0
--------------------------
```
## 🎯 Бюджетирование
- Установка лимитов по категориям
- Контроль остатка бюджета
- Предупреждения при превышении

## 🔐 Безопасность
1. Система регистрации и аутентификации
2. Изоляция данных между пользователями
3. Безопасное хранение паролей

## 🛠 Технологии
- Java 17 - основной язык
- Docker - контейнеризация
- Collections Framework - управление данными
- Stream API - расчет статистики

## 📊 Особенности
✅ Простота использования - интуитивное консольное меню

✅ Безопасность - изоляция данных пользователей

✅ Гибкое бюджетирование - настройка лимитов по категориям

✅ Детальная статистика - полный обзор финансов

✅ Предупреждения - уведомления о превышении бюджета

✅ Кроссплатформенность - работает везде, где есть JVM

✅ Контейнеризация - готовность к деплою
