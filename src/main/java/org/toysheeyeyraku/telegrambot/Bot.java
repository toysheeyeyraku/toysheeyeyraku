package org.toysheeyeyraku.telegrambot;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import org.toysheeyeyraku.models.TelegramSettings;
import org.toysheeyeyraku.repositories.TelegramSettingsRepository;

@Service
public class Bot extends TelegramLongPollingBot {
	@Autowired
	private TelegramSettingsRepository telegramSettingsRepository ;
	public void onUpdateReceived(Update update) {
		String message = update.getMessage().getText();
		TelegramSettings set=telegramSettingsRepository.findByRegisterString(message);
		if (set!=null) {
			set.setChatId(update.getMessage().getChatId().toString());
			telegramSettingsRepository.save(set);
		}
	}

	public synchronized void sendMsg(String chatId, String s) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(s);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {

		}
	}

	public String getBotUsername() {

		return "Trans";
	}

	@Override
	public String getBotToken() {

		return "924681343:AAHm3f_4sKhttcCHkKyP_C4eZrSUMern0ss";
	}

	static {
		ApiContextInitializer.init();
	}

	@PostConstruct
	public void init() {

		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(this);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}

}