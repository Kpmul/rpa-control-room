package com.km.rpa_control_room.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.km.rpa_control_room.entity.Bot;
import com.km.rpa_control_room.service.BotService;

@Component
public class BotRunner {

   private final BotService botService;

   @Autowired
   public BotRunner(BotService theBotService) {
      botService = theBotService;
   }

   public void runBot(long botID) throws IOException, InterruptedException {

      String pyCommand = "python3";

      Bot bot = botService.findById(botID);

      String path = bot.getFilePath();

      ProcessBuilder processBuilder = new ProcessBuilder(pyCommand, path);
      Process process = processBuilder.start();

      InputStream inputStream = process.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

      String line;

      while ((line = bufferedReader.readLine()) != null) {
         System.out.println("Script output: " + line);
      }

      int exitCode = process.waitFor();

      System.out.println("Exit code print out: " + exitCode);

   }
}
