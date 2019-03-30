package me.aravindh.sfgpetclinic.bootstrap;

import me.aravindh.sfgpetclinic.model.Owner;
import me.aravindh.sfgpetclinic.model.Pet;
import me.aravindh.sfgpetclinic.model.PetType;
import me.aravindh.sfgpetclinic.model.Vet;
import me.aravindh.sfgpetclinic.services.OwnerService;
import me.aravindh.sfgpetclinic.services.PetTypeService;
import me.aravindh.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("432 lala land");
        owner1.setCity("Miami");
        owner1.setTelephone("657392920");

        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Giovanni");
        owner2.setAddress("432 lala land");
        owner2.setCity("Miami");
        owner2.setTelephone("657392920");

        Pet fionasCat = new Pet();
        fionasCat.setName("Kitty");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);


        ownerService.save(owner2);


        System.out.println("Loaded owners...");


        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("sam");
        vet1.setLastName("axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jack");
        vet2.setLastName("Rose");

        vetService.save(vet2);

        System.out.println("Loaded vets...");


    }
}
