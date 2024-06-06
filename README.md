# Запуск
1. В любом сообществе ВК зайдите в настройки и заполните src/main/resources/application.properties:
    - access.token - из раздела Ключи доступа
    - confirmation.string и api.version - из раздела Callback API
2. Запустите этот сервис
```shell
./gradlew bootRun
```
3. Запустите ngrok для запущенного сервиса (Tomcat started on port 8080)
```shell
ngrok http 8080
```
3. Из панели ngrok скопируйте сгенерированный адрес вашего сервера, например https://9b71-88-201-206-85.ngrok-free.app. Вставьте в админку группы ВК и нажмите Подтвердить. ВК должно ответить положительно.
4. Отправьте что-нибудь боту (в сообщения группе), e g "abrakadabra"

бот должен ответить:
> You said: abrakadabra
