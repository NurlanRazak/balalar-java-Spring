package com.example.balalar;

//import org.springframework.boot.CommandLineRunner;
import com.example.balalar.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
//import org.springframework.context.annotation.Bean;
//
//import com.example.balalar.data.ContentRepository;
//import com.example.balalar.Contentclick.Type;

@SpringBootApplication
public class BalalarApplication implements CommandLineRunner {

	@Autowired
	private BuyRepository buyRepository;

	@Autowired
	IBuyService buyService;

	@Autowired
	private PodcastRepository podcastRepository;

	@Autowired
	PodcastService podcastService;


	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	INewsService newsService;

	Date todayDate = new Date();
	public static void main(String[] args) {
		SpringApplication.run(BalalarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		buyRepository.save(new Buy(todayDate, "Toyota camry", "camry n35 was produced in 2018, a brand new car", "Price 30000, and High quality", "4532380963197053", "09/19", "678"));
		podcastRepository.save(new Podcast(todayDate, "Joe Rogan", "Joe Rogan Experience #1169 - Elon Musk", "https://www.youtube.com/watch?v=ycPr5-27vSI"));
		newsRepository.save(new News(todayDate, "As Huawei loses Google, the US-China tech Cold War gets its Iron Curtain", "NEW YORK (NYTIMES) - China has spent nearly two decades building a digital wall between itself and the rest of the world.", " It has tightened limits on Chinese investment. Some Chinese students who focused on science and technology have had problems getting visas to the US. Some Chinese scholars have had their US visas revoked over spying fears."));
	}

//
//	@Bean
//	public CommandLineRunner dataLoader(ContentRepository repo) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				repo.save(new Contentclick("ANMT", "Animation", Contentclick.Type.ENTERTAIMENT));//INsert into Ingredient Val
//				repo.save(new Contentclick("FRTL", "Fairy Tail", Contentclick.Type.ENTERTAIMENT));
//				repo.save(new Contentclick("ALPH", "Alphabet", Contentclick.Type.BEGINNER));
//				repo.save(new Contentclick("ESMT", "Easy Math", Contentclick.Type.BEGINNER));
//				repo.save(new Contentclick("FRLN", "Foreign Language", Contentclick.Type.MIDDLE));
//				repo.save(new Contentclick("SPRT", "Sport", Contentclick.Type.MIDDLE));
//				repo.save(new Contentclick("CKNG", "Cooking", Contentclick.Type.YOUNG));
//				repo.save(new Contentclick("CMNC", "Communication Skills", Contentclick.Type.YOUNG));
//				repo.save(new Contentclick("MNMG", "Money Management", Contentclick.Type.ADULT));
//				repo.save(new Contentclick("TMNG", "Time Management", Contentclick.Type.ADULT));
//
//
//
//				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//				System.out.println(repo.findByIdAndName("ALPH", "Alphabet"));
//			}
//		};
//	}

}

