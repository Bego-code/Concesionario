/**
 * Clase Cliente (Hilo)
 * Representa un 'Cliente' que quiere probar un 'Vehículo'
 * Extiende de Thread
 */
public class Cliente extends Thread {

    private String nombre;
    private Concesionario concesionario;

    public Cliente(String nombre, Concesionario concesionario) {
        this.nombre = nombre;
        this.concesionario = concesionario;
    }

    @Override
    public void run() {
        try {
            // Intentamos coger un coche
            // Si no hay, el hilo se bloqueará dentro de este método
            Vehiculo coche = concesionario.entrarYProbar();

            // El 'Vehiculo' se está probando
            System.out.println(this.nombre + " ... probando el " + coche);

            // Simulamos el tiempo de conducción entre 1 y 3 segundos aprox
            // Thread.sleep pausa este hilo sin liberar el recurso
            Thread.sleep((long) (Math.random() * 2000 + 1000));

            // Terminamos y devolvemos el coche
            System.out.println(this.nombre + " ... terminó de probar el " + coche);
            concesionario.salirYDevolver(coche);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}