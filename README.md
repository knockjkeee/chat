# Chat
---------------------------------
Сокетный чат со swing интерфейсом.
---------------------------------

Идея чата взята из задачи с сайта JavaRush.ru


Что изменено/добавлено по сравнению с оригинальной задачей:

- Конфигурацию читает из файла properties при помощи класса ResourceManager
- Добалены чат румы и возможность клиенту создавать свои чаты
- Добавлены приватные сообщения
- Полностью новый swing интерфейс клиента
- Добавлены горячие клавиши для отправления сообщений и команд клиента
- Добавлено окно настроек
- Добавлены смайлики
- Сделаны вкладки для отображения сообщений из разных чат румов
    и приватных чатов
- Добавлен счетчик непрочитанных сообщений
- Сделано дерево пользователей для отображения пользователей в чатах
    и вызова приватных сообщений
- Бот научился отвечать смайликом на смайлик
- Добавил логгер log4j
- Добавил добавл тесты jUnit
- Завернул все это в мавен и разбил на модули