import java.util.ArrayList;
import java.util.List;

class SistemaGestionVeterinaria {
    private String nombreSistema;
    private List<Veterinario> veterinarios;

    public SistemaGestionVeterinaria(String nombreSistema) {
        this.nombreSistema = nombreSistema;
        this.veterinarios = new ArrayList<>();
    }

    public void agregarVeterinario(String nombre, String numIdentificacion, String especialidad) {
        Veterinario nuevoVeterinario = new Veterinario(nombre, numIdentificacion, especialidad);
        veterinarios.add(nuevoVeterinario);
    }

    public Veterinario buscarVeterinario(String numIdentificacion) {
        for (Veterinario veterinario : veterinarios) {
            if (veterinario.numIdentificacion.equals(numIdentificacion)) {
                return veterinario;
            }
        }
        return null;
    }

    public void agregarMascotaAVeterinario(String numIdentificacion, Mascota mascota) {
        Veterinario veterinario = buscarVeterinario(numIdentificacion);
        if (veterinario != null) {
            veterinario.agregarMascota(mascota);
        } else {
            System.out.println("El veterinario con identificación " + numIdentificacion + " no existe.");
        }
    }

    public int cantidadTotalMascotasAtendidas() {
        int totalMascotas = 0;
        for (Veterinario veterinario : veterinarios) {
            totalMascotas += veterinario.mascotasAtendidas.size();
        }
        return totalMascotas;
    }
}
