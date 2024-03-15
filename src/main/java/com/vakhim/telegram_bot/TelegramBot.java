package com.vakhim.telegram_bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

@Component
public class TelegramBot extends TelegramLongPollingBot {
//
    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
//
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);


        String command = update.getMessage().getText();

        if (command.equals("/run")){
            String mes = "Kom Plex Leb Tnam ";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);

            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
//        InputFile file = new InputFile();
//        file.setMedia(new File("D:\\telegrambot\\FB_IMG_1710386820722.jpg"));
//
//
//        SendPhoto sendPhoto = new SendPhoto();
//        sendPhoto.setChatId(chatId);
//        sendPhoto.setPhoto(file);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            new RuntimeException(e);
        }
        System.out.println(text);
    }

    @Override
    public String getBotUsername() {
        return "Besdong_bot";
    }
}
