/**
 * Clase principal que inicia la simuñación de las pruebas
 * 1. Instancia la clase compartida (concesionario)
 * 2. Define Aarray de nombres de clientes
 * 3. Crea y lanza los hilos correspondientes a cada cliente
 * * @author Bego
 */
public class Main {
    public static void main(String[] args) {
        // Mensaje inicial del enunciado
        System.out.println("APERTURA DEL CONCESIONARIO ");
        System.out.println("Vehículos disponibles: 4 | Clientes esperando: 9");
        // Salto de línea
        System.out.println();

        // Instanciamos el concesionario
        Concesionario concesionario = new Concesionario();

        // Creamos los hilos pasándoles el concesionario
        Cliente c1 = new Cliente("David Muñoz", concesionario);
        Cliente c2 = new Cliente("Beatriz Marín", concesionario);
        Cliente c3 = new Cliente("Ana Moreno", concesionario);
        Cliente c4 = new Cliente("Fernando López", concesionario);
        Cliente c5 = new Cliente("Elena Pérez", concesionario);
        Cliente c6 = new Cliente("Lucía Gil", concesionario);
        Cliente c7 = new Cliente("Carlos Delgado", concesionario);
        Cliente c8 = new Cliente("Hugo Méndez", concesionario);
        Cliente c9 = new Cliente("Sofía Ramos", concesionario);

        // Iniciamos los hilos llamando a run()
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();

    }
}