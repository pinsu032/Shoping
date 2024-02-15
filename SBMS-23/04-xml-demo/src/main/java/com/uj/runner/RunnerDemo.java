package com.uj.runner;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uj.binding.Address;
import com.uj.binding.Person;

@Component
public class RunnerDemo  implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		Address adrs = new Address();
		adrs.setCity("Pune");
		adrs.setLoc("Hinjwadi");
		
		Person prsn = new Person();
		prsn.setId(1);
		prsn.setAddress(adrs);
		prsn.setName("Pinsu");
		
		JAXBContext newInstance = JAXBContext.newInstance(Person.class);
		Marshaller createMarshaller = newInstance.createMarshaller();
		createMarshaller.marshal(prsn,new File("Person.xml"));
		System.out.println("Marshelling Completed...");
	}
	
	

}
