package app.ymcb.utils

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow

object Keyboards {

    fun getSimpleKeyboard(vararg rows: String): ReplyKeyboardMarkup {
        var keyboard = arrayListOf<KeyboardRow>()
        rows.forEach {
            var tmp = KeyboardRow()
            tmp.add(it)
            keyboard.add(tmp)
        }
        return ReplyKeyboardMarkup.builder()
            .resizeKeyboard(true)
            .keyboard(keyboard)
            .build()
    }
}