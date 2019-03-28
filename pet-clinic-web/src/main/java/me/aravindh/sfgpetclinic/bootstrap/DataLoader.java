package me.aravindh.sfgpetclinic.bootstrap;

import me.aravindh.sfgpetclinic.model.Owner;
import me.aravindh.sfgpetclinic.model.Vet;
import me.aravindh.sfgpetclinic.services.OwnerService;
import me.aravindh.sfgpetclinic.services.VetService;
import me.aravindh.sfgpetclinic.services.map.OwnerServiceMap;
import me.aravindh.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Giovanni");

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