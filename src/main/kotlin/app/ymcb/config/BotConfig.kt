package app.ymcb.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
data class BotConfig(
    @Value("\${telegram.bot.token}") val botToken: String,
    @Value("\${telegram.bot.name}") val botName: String
)
