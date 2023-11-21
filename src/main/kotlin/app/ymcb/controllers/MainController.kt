package app.ymcb.controllers

import app.ymcb.config.BotConfig
import app.ymcb.constants.CommandConstant.START
import app.ymcb.constants.CommandConstant.STOP
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class MainController(
    @Autowired private val commandController: CommandController,
    @Autowired private val botConfig: BotConfig):
    TelegramLongPollingBot(botConfig.botToken) {
    override fun getBotUsername() = botConfig.botName

    override fun onUpdateReceived(update: Update?) {
        if (update != null) {
            println(1)
            if (update.hasMessage()) {
                println(1)
                if (update.message.isCommand) {
                    // commands
                    when(update.message.text.lowercase()) {
                        START -> commandController.start(this, update)
                        STOP -> commandController.stop(this, update)
                        else -> commandController.error(this, update)
                    }
                } else {
                    // text commands

                }
                // query commands
            } else if (update.hasCallbackQuery()) {

            }
        }
    }

}
