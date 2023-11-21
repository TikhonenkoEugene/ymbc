package app.ymcb.controllers

import app.ymcb.utils.Keyboards
import app.ymcb.constants.MenuConstants.INCOMING
import app.ymcb.constants.MenuConstants.OPERATING
import app.ymcb.constants.MenuConstants.REPORTING
import app.ymcb.constants.MenuConstants.SPENDING
import app.ymcb.constants.MessageConstant.ERR_COMMAND_NOT_FOUND
import app.ymcb.constants.MessageConstant.MSG_GREETING
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class CommandController {
    fun start(mainController: MainController, update: Update) {
        mainController.execute(SendMessage.builder()
            .chatId(update.message.chatId)
            .text(MSG_GREETING)
            .replyMarkup(Keyboards.getSimpleKeyboard(SPENDING, INCOMING, OPERATING, REPORTING))
            .build())
    }

    fun stop(mainController: MainController, update: Update) {
        // TODO: Exit from bot
    }

    fun error(mainController: MainController, update: Update) {
        mainController.execute(SendMessage.builder()
            .chatId(update.message.chatId)
            .text(ERR_COMMAND_NOT_FOUND)
            .build())
    }
}