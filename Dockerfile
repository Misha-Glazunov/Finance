# Используем официальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавлием рабочую директорию
WORKDIR /app

# Копируем исходный код
COPY src/ ./

# Компилируем Java классы
RUN javac *.java

# Очищаем от исходников после компиляции (опционально)
# RUN find . -name "*.java" -type f -delete

# Запускаем приложение
CMD ["java", "FinanceApp"]
