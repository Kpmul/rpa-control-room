package com.km.rpa_control_room;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.km.rpa_control_room.dao.BotRepository;
import com.km.rpa_control_room.dao.ClientRepository;
import com.km.rpa_control_room.entity.Bot;
import com.km.rpa_control_room.entity.Client;

@SpringBootApplication
public class RpaControlRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpaControlRoomApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ClientRepository clientRepo, BotRepository botRepo) {

		return runner -> {

			// System.out.println("Creating Client...");

			// Client client1 = new Client("KSN Energy", "rpa100zxy");

			// System.out.println("You have created " + client1.getName() + " as a
			// client!");

			// // clientRepo.save(client1);
			// // System.out.println("Saving Client: " + client1);

			// // System.out.println("Done!");

			// System.out.println("Creating Bot...");

			// Bot bot1 = new Bot("//filepath", "data-update-bot", "py",
			// LocalDateTime.now());

			// // System.out.println("Bot: " + bot1 + " created!");

			// // botRepo.save(bot1);

			// // System.out.println("Saving bot to database...");
			// System.out.println("Done!");

			// client1.addBot(bot1);

			// clientRepo.save(client1);

			// // System.out.println("Adding bot: " + bot1 + " to client: " + client1);

			// System.out.println(client1);

			// System.out.println("Fetching client from database...");
			// Optional<Client> result = clientRepo.findById(client1.getId());

			// Client dbClient = null;

			// if (result.isPresent()) {
			// dbClient = result.get();
			// }

			// System.out.println("DB Client: " + dbClient);
			// System.out.println("DB Client's bots: " + dbClient.getBots());
		};
	}
}
