/**
 * Clase Vehiculo
 * Representa el recurso compartido que los clientes quieren utilizar
 */
public class Vehiculo {
    // Identificador único (1, 2, 3, 4)
    private int id;
    // Nombre del coche
    private String modelo;


    //Getter y setter
    public Vehiculo(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    // Sobrescribimos toString para que al imprimir salga bonito en el log
    @Override
    public String toString() {
        return modelo + " (Vehículo " + id + ")";
    }
}