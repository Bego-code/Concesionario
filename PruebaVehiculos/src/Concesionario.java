/**
 * Clase Concesionario
 * Gestiona el acceso concurrente a los vehículos
 * Garantiza que nunca haya más de 4 coches en uso a la vez
 */
public class Concesionario {

    // Array que almacena los objetos Vehiculo reales
    private Vehiculo[] vehiculos;

    // Array paralelo para controlar si cada coche está libre (true) u ocupado (false)
    private boolean[] libres;

    public Concesionario() {
        // Inicializamos los recursos (4 coches)
        vehiculos = new Vehiculo[4];
        libres = new boolean[4];

        // Creamos los coches específicos del enunciado
        vehiculos[0] = new Vehiculo(1, "Dacia Sandero ");
        vehiculos[1] = new Vehiculo(2, "Dacia Duster");
        vehiculos[2] = new Vehiculo(3, "Dacia Jogger");
        vehiculos[3] = new Vehiculo(4, "Dacia Spring ");

        // Al inicio, todos los coches están libres
        for (int i = 0; i < 4; i++) {
            libres[i] = true;
        }
    }

    /**
     * Método para solicitar coche
     * Si no hay coches, el hilo se espera
     * Si hay coche, lo marca como ocupado y lo devuelve
     */
    public synchronized Vehiculo entrarYProbar() {
        // Bucle while para comprobar si el cliente se
        // prepara y otro cliente le roba el vehículo antes
        while (true) {
            // Recorremos los coches buscando un hueco libre
            for (int i = 0; i < 4; i++) {
                if (libres[i]) {
                    // Marca como ocupado
                    libres[i] = false;
                    // Devolvemos el 'Vehiculo'
                    return vehiculos[i];
                }
            }

            // Si llegamos aquí, es que no había ningún coche libre
            try {
                // El hilo espera hasta recibir notifyAll()
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para devolver un coche
     * Libera el 'Vehiculo'' y avisa a los clientes que están esperando
     */
    public synchronized void salirYDevolver(Vehiculo vehiculoDevuelto) {
        // Buscamos qué posición ocupa este vehículo en la flota
        for (int i = 0; i < 4; i++) {
            if (vehiculos[i] == vehiculoDevuelto) {
                // Liberamos el 'Vehiculo'
                libres[i] = true;
                // Notificamos a clientes que estan esperando para que intenten
                // coger un 'Vehiculo' de nuevo
                notifyAll();
                // Salimos del bucle
                break;
            }
        }
    }
}