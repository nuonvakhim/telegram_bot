package com.vakhim.telegram_bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.List;
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
            String mes = "ក្នុងនាមយើងជា ខ្មែរដូចគ្នា បើ you មិនជួយ sl nh ទេបានប្រទេសណា ជួយ sl";
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
        } else if (command.equals("/test")) {
            String mes = "https://youtu.be/m9wJ3TQ0kqQ?si=gWHQeOp99847rz4_";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/roll")) {
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());

            // Generate a random number between 1 and 100
            int randomNumber = (int) (Math.random() * 100) + 1;

            // Set the message text with the rolled number
            sendMessage1.setText("You rolled: " + randomNumber);

            try {
                execute(sendMessage1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            //
        } else if (command.equals("/play")) {
//            String mes = "Nv jam tver ey tt mix min prom chat tv ke";
            String mes = "https://youtu.be/MHI6Ssm0_b0?si=eT46BrWZvKQMUgdJ";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/tos")) {
            String mes = "Tos tov order bay";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (command.equals("/crush")) {
            List<String> crush = List.of("Seak", "Cheng", "Chanry");
            Random rand = new Random();

            // Generate a random index in the range of your list
            int randomIndex = rand.nextInt(crush.size());

            // Get the random name
            String randomName = crush.get(randomIndex);

            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(randomName);
            try {
                execute(sendMessage1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        } else if (command.equals("/cheng")) {

            String[] images = {"D:\\telegrambot\\cr1.jpg", "D:\\telegrambot\\cr2.jpg", "D:\\telegrambot\\cr3.jpg", "D:\\telegrambot\\cr4.jpg"};

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
        }else {
            String mes = "I'm sorry, I didn't understand that command. Please try again.";
            SendMessage sendMessage1 = new SendMessage();
            sendMessage1.setChatId(update.getMessage().getChatId().toString());
            sendMessage1.setText(mes);
            try {
                execute(sendMessage1);
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
