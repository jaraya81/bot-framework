# bot-framework
## Framework para implementar robots de software.

### IBot
Interfaz para implementar un bot.
* flow() se debe sobreescribir la lógica de negocio para el bot.
* init() y end() se deben sobreescribir las logicas de interacción de inicio y fin de un bot.
```
public class BotGoogle implements IBot {
}
```

### Bot y BotImpl
 Contiene las funcionalidades para implementar bots.
```
Bot botG = new BotImpl(TipoDriver.CHROME);
botG.openWeb("http://www.google.com/");
```
 