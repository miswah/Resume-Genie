package io.miswah.resumebuilder;

import io.miswah.resumebuilder.models.Education;
import io.miswah.resumebuilder.models.Experience;
import io.miswah.resumebuilder.models.UserProfile;
import io.miswah.resumebuilder.repository.UserProfileRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class ResumebuilderApplication {

	@Autowired
	public UserProfileRepository userProfileRepository;

	public static void main(String[] args) {
		SpringApplication.run(ResumebuilderApplication.class, args);
	}


	@PostConstruct
	private void feedUserData(){

		System.out.println("seeding Data for user Profile");

		Experience exp1 = new Experience(1, "Swastik Computer Eduction", "Project Manager", LocalDate.of(2022, 6, 15) , LocalDate.of(2022, 12, 15), "tation magna veniam nobis. Maiestatis ad bibendum curae atqui. Viverra volutpat ludus mauris aptent nulla facilis donec accommodare massa. Aeque elaboraret has oratio sociosqu bibendum dictumst graece leo", true);
		Experience exp2  = new Experience(2, "Swastik Computer Eduction", "Project Manager", LocalDate.of(2020, 1, 25) , LocalDate.of(2020, 7, 19), "tation magna veniam nobis. Maiestatis ad bibendum curae atqui. Viverra volutpat ludus mauris aptent nulla facilis donec accommodare massa. Aeque elaboraret has oratio sociosqu bibendum dictumst graece leo", false);

		ArrayList<Experience> experienceList = new ArrayList<>();

		experienceList.add(exp1);
		experienceList.add(exp2);

		ArrayList<String> skills = new ArrayList<>();

		skills.add("Typing");
		skills.add("Speaking");
		skills.add("Excel");
		skills.add("JS");
		skills.add("CSS");
		skills.add("HTML");
		skills.add("Angular");


		ArrayList<Education> educations = new ArrayList<>();

		Education edu1 = new Education(1, "IGNOU - New Delhi, 876544", "BCA", LocalDate.of(2017, 6, 15), LocalDate.of(2021, 6, 15),"Compled BCA with a capstone project at sem 6 under the guidance of sunil sharma");
		Education edu2 = new Education(2, "IGNOU - New Delhi, 876544", "MCA", LocalDate.of(2022, 6, 15), LocalDate.of(2024, 6, 15),"Compled MCA with a capstone project at sem 6 under the guidance of sunil sharma");

		educations.add(edu1);
		educations.add(edu2);



		UserProfile userProfile = new UserProfile(1, 3, "Audire eruditi sadipscing leo eleifend. Saepe appetere convallis ocurreret saepe. Aenean dicam efficiantur verterem principes. Nec primis himenaeos platonem sea causae veniam. Augue errem novum vidisse percipit cum volutpat conubia. Nulla cu qualisque reque quaeque. Dictum suscipiantur suas dolor ubique prompta atqui finibus. Congue ipsum consectetuer etiam quaeque erat utroque sed. Urna turpis ceteros conubia egestas. Voluptaria litora quas nisi ullamcorper", "adam", "Adam", "Jesus", "Flying Monster", "walkonwater@gmail.com", "+919876543210", experienceList, skills, educations);

		userProfileRepository.save(userProfile);
		System.out.println("Data has been seeded for user "+ userProfile.getUserName());

	}

}
