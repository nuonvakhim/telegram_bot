package com.vakhim.telegram_bot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.Random;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    //
    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);


        String command = update.getMessage().getText();

        if (command.equals("/run")) {
            String mes = "Mnak nis srolanh tea oun";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/chat")) {
            String mes = "Chat tov ke mun tov";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/send")) {
            // Array of your image paths
            String[] images = {"D:\\user01\\telegram\\crushbnang.jpg", "D:\\user01\\telegram\\FB_IMG_1710386827284.jpg", "D:\\user01\\telegram\\image3.jpg"};

            // Create a Random object
            Random rand = new Random();

            // Generate a random index in the range of your array
            int randomIndex = rand.nextInt(images.length);

            // Select a random image path from your array
            String randomImagePath = images[randomIndex];

            InputFile file = new InputFile();
            file.setMedia(new File(randomImagePath));

            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(chatId);
            sendPhoto.setPhoto(file);
            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            }
        System.out.println(text);
    }

    @Override
    public String getBotUsername() {
        return "Besdong_bot";
    }
}
