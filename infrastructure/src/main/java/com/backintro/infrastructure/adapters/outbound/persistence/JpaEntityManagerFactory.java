package com.backintro.infrastructure.adapters.outbound.persistence;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Gestor singleton para el EntityManagerFactory en entorno Java SE puro.
 * Inicializa la unidad de persistencia configurada en META-INF/persistence.xml
 * sin depender de ningún contenedor de inversión de control como Spring.
 */
public final class JpaEntityManagerFactory {

    public static final String PERSISTENCE_UNIT_NAME = "backIntroPU";

    private static volatile EntityManagerFactory emf;

    private JpaEntityManagerFactory() {
    }

    /**
     * Obtiene la instancia única de EntityManagerFactory.
     *
     * @return EntityManagerFactory inicializado.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            synchronized (JpaEntityManagerFactory.class) {
                if (emf == null) {
                    emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                }
            }
        }
        return emf;
    }

    /**
     * Cierra el EntityManagerFactory liberando los recursos y conexiones asociadas.
     */
    public static synchronized void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
    }
}
