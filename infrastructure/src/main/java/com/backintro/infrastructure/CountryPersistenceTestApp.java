package com.backintro.infrastructure;

import com.backintro.application.ports.CountryRepositoryPort;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.infrastructure.adapters.outbound.persistence.JpaEntityManagerFactory;
import com.backintro.infrastructure.adapters.outbound.persistence.repositories.CountryJpaRepositoryAdapter;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

/**
 * Ejemplo ejecutable en Java SE puro (sin Spring Boot).
 * Demuestra la inicialización de JPA, la validación contra schema.sql,
 * y el uso del adaptador de repositorio a través del puerto CountryRepositoryPort.
 */
public class CountryPersistenceTestApp {

    public static void main(String[] args) {
        System.out.println("=== Inicializando persistencia JPA en Java SE puro ===");

        try {
            // 1. Obtener el EntityManagerFactory desde persistence.xml
            EntityManagerFactory emf = JpaEntityManagerFactory.getEntityManagerFactory();

            // 2. Instanciar el adaptador del repositorio inyectando el EntityManagerFactory
            CountryRepositoryPort countryRepository = new CountryJpaRepositoryAdapter(emf);

            // 3. Crear una entidad de dominio pura (sin dependencias de JPA)
            Country newCountry = Country.create(
                    "Colombia",
                    "CO",
                    "República de Colombia",
                    "+57"
            );

            System.out.println("\n[1] Guardando nuevo país en la base de datos...");
            Country savedCountry = countryRepository.save(newCountry);
            System.out.println("País guardado con éxito: " + savedCountry);

            // 4. Buscar por ID
            System.out.println("\n[2] Consultando país por ID: " + savedCountry.getId());
            Optional<Country> foundCountry = countryRepository.findById(savedCountry.getId());
            foundCountry.ifPresent(c -> System.out.println("País recuperado: " + c));

            // 5. Buscar por código ISO
            System.out.println("\n[3] Consultando país por código 'CO'...");
            Optional<Country> countryByCode = countryRepository.findByCode("CO");
            countryByCode.ifPresent(c -> System.out.println("País encontrado por código: " + c.getNameCountry()));

            // 6. Listar todos
            System.out.println("\n[4] Listando todos los países...");
            List<Country> allCountries = countryRepository.findAll();
            System.out.println("Total países encontrados: " + allCountries.size());
            for (Country c : allCountries) {
                System.out.println(" - " + c.getNameCountry() + " [" + c.getCodeCountry() + "]");
            }

        } catch (Exception e) {
            System.err.println("Error durante la ejecución del test de persistencia:");
            e.printStackTrace();
        } finally {
            // 7. Liberar recursos de JPA
            System.out.println("\n=== Cerrando EntityManagerFactory ===");
            JpaEntityManagerFactory.close();
        }
    }
}
