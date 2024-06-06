```shell
./gradlew run
ngrok http 8080
```
from ngrok panel copy address like https://9b71-88-201-206-85.ngrok-free.app to vk group admin ui and press Confirm (subs correct confirm string in proj first)

send any message to group (here "abrakadabra")

see in gradlew output:
```
{message={date=1717664675, from_id=258127947, id=7, out=0, version=10000015, attachments=[], conversation_message_id=1, fwd_messages=[], important=false, is_hidden=false, peer_id=258127947, random_id=0, text=abrakadabra}, client_info={button_actions=[text, vkpay, open_app, location, open_link, callback, intent_subscribe, intent_unsubscribe], keyboard=true, inline_keyboard=true, carousel=true, lang_id=0}}
```
