import java.util.ArrayList;
import java.util.List;

class Veterinario {
    private String nombre;
    String numIdentificacion;
    private String especialidad;
    List<Mascota> mascotasAtendidas;

    public Veterinario(String nombre, String numIdentificacion, String especialidad) {
        this.nombre = nombre;
        this.numIdentificacion = numIdentificacion;
        this.especialidad = especialidad;
        this.mascotasAtendidas = new ArrayList<>();
    }

    public void agregarMascota(Mascota mascota) {
        if (mascotasAtendidas.size() < 10) {
            mascotasAtendidas.add(mascota);
        } else {
            System.out.println("El veterinario " + nombre + " ha alcanzado el límite de mascotas atendidas.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getId() {
        return Integer.parseInt(numIdentificacion);
    }

    public Mascota[] getMascotasAtendidas() {
        return mascotasAtendidas.toArray(new Mascota[0]);
    }
}
