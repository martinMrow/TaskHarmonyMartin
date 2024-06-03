/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.mavenproject4;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Connection;
import java.nio.file.Path;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.jpa.jpql.Assert;

/**
 *
 * @author administrador
 */
public class Mavenproject4 {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Conectando....");

        String urlH2 = "jdbc:h2:" + Path.of("bbdd").toAbsolutePath().toString();
        String urlMySQL = "jdbc:mysql://localhost:3306/tfg4?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "user";
        String pass = "";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidadJPA");

        // Crear Connexion
        // Connection conn = H2Connector.newInstance(urlH2,user,pass);
        Connection conn = H2Connector.newInstance(urlMySQL, "root", "");
        Statement estado = conn.createStatement();

        //controladores
        UsuarioJpaController usuarioCont = new UsuarioJpaController(emf);
        FamiliaJpaController familiaCont = new FamiliaJpaController(emf);
        UsuarioPerteneceFamiliaJpaController upfCont = new UsuarioPerteneceFamiliaJpaController(emf);
        TareasJpaController tareasCont = new TareasJpaController(emf);
        UsuarioHaceTareasJpaController usHaTaCont = new UsuarioHaceTareasJpaController(emf);
        PremiosJpaController premiosCont = new PremiosJpaController(emf);

//C-E-E datos USUARIO ---------------------------------------------------------------------------------------------------------------------------------------------------------
//        Usuario usuario1 = new Usuario("78126483F", "martin", "mvar", "1234567");
//        usuarioCont.create(usuario1);
//        List<Usuario> listaUsuarios = usuarioCont.findUsuarioEntities();
//        System.out.println("Usuarios:");
//        for (Usuario usuario : listaUsuarios) {
//            System.out.println(usuario);
//        }
//        Usuario ampleadoAactualizar = new Usuario();
//        entrada.nextLine();
//        System.out.println("Dime el DNI del empleado a actualizar.");
//        String dni = entrada.nextLine();
//        Usuario empleadoactualizado = usuarioCont.findUsuario(dni);
//        System.out.println("Introduce el nombre actualizado.");
//        String nombreApellidos = entrada.nextLine();
//        empleadoactualizado.setNombre(nombreApellidos);
//        try {
//            usuarioCont.edit(empleadoactualizado);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("Hecho");
//        List<Usuario> listaUsuarios2 = usuarioCont.findUsuarioEntities();
//        System.out.println("Empleados:");
//        for (Usuario usuario : listaUsuarios2) {
//            System.out.println(usuario);
//        }
//        //Eliminar un empleado
//        entrada.nextLine();
//        System.out.println("introduzca el DNI del empleadpo");
//        dni = entrada.nextLine();
//        try {
//            usuarioCont.destroy(dni);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("hecho");
//        List<Usuario> listaUsuarios3 = usuarioCont.findUsuarioEntities();
//        System.out.println("Empleados:");
//        for (Usuario usuario : listaUsuarios3) {
//            System.out.println(usuario);
//        }
//C-E-E datos FAMILIA ---------------------------------------------------------------------------------------------------------------------------------------------------------
        //crear
//        Familia familia1 = new Familia("78126483F", "Fam1aaaaaaaa");
//        familiaCont.create(familia1);
//        List<Familia> listaFamilia = familiaCont.findAllFamilias();
//        System.out.println("Familias:");
//        for (Familia familia : listaFamilia) {
//            System.out.println(familia);
//        }
        //editar
//        Familia ampleadoAactualizar = new Familia();
//        entrada.nextLine();
//        System.out.println("Dime el DNI del empleado a actualizar.");
//        String dni = entrada.nextLine();
//        Familia empleadoactualizado = familiaCont.findFamiliaByDniAdmin(dni);
//        System.out.println("Introduce el nombre actualizado.");
//        String nombreApellidos = entrada.nextLine();
//        empleadoactualizado.setNombre(nombreApellidos);
//        try {
//            familiaCont.edit(empleadoactualizado);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("Hecho");
//        List<Familia> listaFamilia1 = familiaCont.findAllFamilias();
//        System.out.println("Empleados:");
//        for (Familia familia : listaFamilia1) {
//            System.out.println(familia);
//        }
////Eliminar un empleado
//        entrada.nextLine();
//        System.out.println("introduzca el DNI del empleadpo");
//        dni = entrada.nextLine();
//        try {
//            familiaCont.destroyByDniAdmin(dni);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("hecho");
//        List<Familia> listaFamilia2 = familiaCont.findAllFamilias();
//        System.out.println("Empleados:");
//        for (Familia familia : listaFamilia2) {
//            System.out.println(familia);
//        }
//C-E-E datos U.P.F ---------------------------------------------------------------------------------------------------------------------------------------------------------
//        UsuarioPerteneceFamilia upf1 = new UsuarioPerteneceFamilia();
//        Familia fam1 = new Familia();
//        fam1.setDniAdmin("78266482F");
//        fam1.setIdFamilia(4);
//        
//        upf1.setIdFamilia(4);
//        upf1.setPuntos(0);
//        upf1.setIsActive(Boolean.FALSE);
//       
//        Usuario usuario = new Usuario("78266482F", "John", "Doe", "secret");
//
//        Usuario usuarioentrar = new Usuario("78126483F", "aaa", "aaaa", "1212");
////        Familia famId = familiaCont.findFamiliaByDniAdmin("78266482F");
////        Integer idFamilia = famId.getIdFamilia();
//        UsuarioPerteneceFamilia upf = new UsuarioPerteneceFamilia();  
//        
//        upf.setIsActive(true);  // Activar la relación
//        upf.setPuntos(100);     // Establecer puntos iniciales
//        upf.setIdFamilia(4);
//        upf.setDni(usuarioentrar.getDni());
//        try {
//            upfCont.create(upf);
//            System.out.println("Relación creada exitosamente.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        List<UsuarioPerteneceFamilia> listaPerteneceFamilias = upfCont.findAllUsuarioPerteneceFamilia();
//        System.out.println("Familias:");
//        for (UsuarioPerteneceFamilia usuarioPerteneceFamilia : listaPerteneceFamilias) {
//            System.out.println(usuarioPerteneceFamilia);
//        }
        //editar check y puntos
//        entrada.nextLine();
//        System.out.println("Dime el DNI del administrador de la familia a actualizar.");
//        String dni = entrada.nextLine();
//        Familia famdniId = familiaCont.findFamiliaByDniAdmin(dni);
//        System.out.println("Dime el DNI del registro de la familia a actualizar.");
//        String dniAct = entrada.nextLine();
//        UsuarioPerteneceFamiliaPK pkupf1 = new UsuarioPerteneceFamiliaPK(dniAct, famdniId.getIdFamilia());
//        UsuarioPerteneceFamilia familiaEncontrada = upfCont.findUsuarioPerteneceFamilia(pkupf1);
//        entrada.nextLine();
//        System.out.println("1 para cambiar el check, 2 para cambiar los puntos");
//        int opcion = entrada.nextInt();
//        if (opcion == 1) {
//            System.out.println("Introduce el valor del check actualizado siendo 1 false y 0 true.");
//            int check = entrada.nextInt();
//            if (check == 1) {
//                familiaEncontrada.setIsActive(Boolean.FALSE);
//            } else {
//                familiaEncontrada.setIsActive(Boolean.TRUE);
//            }
//        } else {
//            int puntos = familiaEncontrada.getPuntos();
//            System.out.println("El saldo de puntos es de: " + puntos);
//            entrada.nextLine();
//            System.out.println("1 sumar, 2 restar, 3 editar de 0");
//            int operacion = entrada.nextInt();
//            switch (operacion) {
//                case 1:
//                    entrada.nextLine();
//                    System.out.println("cuanto quiere sumar. Presione 0 para salir");
//                    int suma = entrada.nextInt();
//                    familiaEncontrada.setPuntos(puntos + suma);
//                    puntos = familiaEncontrada.getPuntos();
//                    System.out.println("El saldo de puntos es de: " + puntos);
//                    break;
//                case 2:
//                    entrada.nextLine();
//                    System.out.println("cuanto quiere restar (no ponga el simbolo -). Presione 0 para salir");
//                    int resta = entrada.nextInt();
//                    familiaEncontrada.setPuntos(puntos - resta);
//                    puntos = familiaEncontrada.getPuntos();
//                    System.out.println("El saldo de puntos es de: " + puntos);
//                    break;
//                case 3:
//                    entrada.nextLine();
//                    System.out.println("cuantos puntos tiene el registro.");
//                    int total = entrada.nextInt();
//                    familiaEncontrada.setPuntos(total);
//                    puntos = familiaEncontrada.getPuntos();
//                    System.out.println("El saldo de puntos es de: " + puntos);
//                    break;
//                default:
//                    throw new AssertionError();
//            }
//
//        }
//        try {
//            upfCont.edit(familiaEncontrada);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("Hecho");
//        List<Familia> listaFamilia1 = familiaCont.findAllFamilias();
//        System.out.println("Empleados:");
//        for (Familia familia : listaFamilia1) {
//            System.out.println(familia);
//        }
////Eliminar un UPF
//        entrada.nextLine();
//        System.out.println("Dime el DNI del administrador de la familia a actualizar.");
//        String dni = entrada.nextLine();
//        Familia famdniId = familiaCont.findFamiliaByDniAdmin(dni);
//        System.out.println("Dime el DNI del registro de la familia a borrar.");
//        String dniAct = entrada.nextLine();
//        UsuarioPerteneceFamiliaPK pkupf1 = new UsuarioPerteneceFamiliaPK(dniAct, famdniId.getIdFamilia());
//        try {
//            upfCont.destroy(pkupf1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println("hecho");
//C-E-E TAREAS ---------------------------------------------------------------------------------------------------------------------------------------------------------
//        Usuario usuario = new Usuario("78266482F", "John", "Doe", "secret");
//        Tareas tarea1 = new Tareas();
//
//        Usuario usuarioentrar = new Usuario("22222166D", "aaa", "aaaa", "1212");
//        Familia famId = familiaCont.findFamiliaByDniAdmin("78266482F");
//        Integer idFamilia = famId.getIdFamilia();
//        tarea1.setIdFamilia(idFamilia);
//        tarea1.setIdTarea("tarea1");
//        tarea1.setPuntos(34);
//        tarea1.setActivo(Boolean.TRUE);
//        tarea1.setDescripcion("blablablalbalblalb");
//
//        tarea1.setNombre("limpiar los platos");
//        tareasCont.create(tarea1);
//        List<Tareas> listaTareas = tareasCont.findTareasEntities();
//        System.out.println("Tareas:");
//        for (Tareas tareas : listaTareas) {
//            System.out.println(tareas);
//        }
//EDITAR
//        try {
//            // Primero, encontramos la tarea que queremos editar
//            Tareas tareaEditar = tareasCont.findTareas("tarea1");
//            if (tareaEditar != null) {
//                // Cambiamos la cantidad de puntos
//                tareaEditar.setPuntos(50); // Nueva cantidad de puntos
//
//                // Luego, llamamos al método edit para actualizar la tarea en la base de datos
//                tareasCont.edit(tareaEditar);
//
//                System.out.println("Tarea actualizada con éxito.");
//            } else {
//                System.out.println("No se encontró la tarea con el ID especificado.");
//            }
//        } catch (Exception e) {
//            System.err.println("Error al actualizar la tarea: " + e.getMessage());
//        }
//MOSTRAR TAREAS ACTIVAS
//// Supongamos que el DNI del usuario es conocido
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese su DNI:");
//        String dniUsuario = scanner.nextLine();  // El DNI del usuario debe ser proporcionado por el mismo
//
//        // Mostrar familias asociadas al usuario
//        List<UsuarioPerteneceFamilia> familiasDelUsuario = upfCont.findFamiliasByUsuario(dniUsuario);
//        if (familiasDelUsuario.isEmpty()) {
//            System.out.println("No se encontraron familias asociadas a este DNI.");
//            return;
//        }
//
//        System.out.println("Familias asociadas a su DNI:");
//        for (UsuarioPerteneceFamilia familia : familiasDelUsuario) {
//            System.out.println("ID Familia: " + familia.getIdFamilia() + ", Nombre: [nombre_de_la_familia_aqui]");
//        }
//
//        // Supongamos que el usuario selecciona una familia
//        System.out.println("Ingrese el ID de la familia seleccionada:");
//        int idFamiliaSeleccionada;
//        try {
//            idFamiliaSeleccionada = Integer.parseInt(scanner.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Entrada no válida.");
//            return;
//        }
//
//        // Método para buscar tareas por familia y que estén activas
//        List<Tareas> tareasActivas = tareasCont.findActiveTareasByFamilia(idFamiliaSeleccionada);
//        if (tareasActivas.isEmpty()) {
//            System.out.println("No hay tareas activas para la familia seleccionada.");
//            return;
//        }
//
//        System.out.println("Tareas activas para la familia seleccionada:");
//        for (Tareas tarea : tareasActivas) {
//            System.out.println(tarea.getNombre() + " - " + tarea.getDescripcion());
//        }
//ELIMINAR TAREA
//    Scanner scanner = new Scanner(System.in);
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TuUnidadDePersistencia");
//        TareasJpaController tareasController = new TareasJpaController(emf);
//
//        System.out.println("Ingrese el ID de la tarea a eliminar:");
//        String idTarea = entrada.nextLine();
//
//        try {
//            tareasController.destroy(idTarea);
//            System.out.println("Tarea eliminada exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al eliminar la tarea: " + e.getMessage());
//        }
/////USUARIO HACE TAREAS-----------------------------------------------------------------------------------------------------------------------------------------------------
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            System.out.println("Ingrese el DNI del usuario:");
//            String dni = scanner.nextLine();
//
//            System.out.println("Ingrese el ID de la tarea:");
//            String idTarea = scanner.nextLine();
//
//            // Fecha actual como fecha realizada
//            Date fechaRealizada = new Date(); // Captura la fecha y hora actual
//
//            // Estado inicial de check_tarea es false y puntos obtenidos en 0
//            boolean checkTarea = false; // Inicialmente falso
//            String comentarios = ""; // Inicialmente vacío
//            int puntosObtenidos = 0; // Inicialmente 0
//
//            UsuarioHaceTareas usuarioHaceTareas = new UsuarioHaceTareas();
//            usuarioHaceTareas.setDni(dni);
//            usuarioHaceTareas.setIdTarea(idTarea);
//            usuarioHaceTareas.setFechaRealizada(fechaRealizada);
//            usuarioHaceTareas.setCheckTarea(checkTarea);
//            usuarioHaceTareas.setComentarios(comentarios);
//            usuarioHaceTareas.setPuntosObtenidos(puntosObtenidos);
//
//            usHaTaCont.create(usuarioHaceTareas);
//            System.out.println("Registro creado exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al crear el registro: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
///EDITAR-----
//        System.out.println("Ingrese el DNI del usuario:");
//        Scanner scanner = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // Incluyendo segundos
//
//        String dni = scanner.nextLine();
//        try {
//            System.out.println("Ingrese el ID de la tarea:");
//            String idTarea = scanner.nextLine();
//
//             System.out.println("Ingrese la fecha y hora de realización de la tarea (formato dd-MM-yyyy HH:mm:ss):");
//            Date fechaRealizada = sdf.parse(scanner.nextLine());
//
//            UsuarioHaceTareasId id = new UsuarioHaceTareasId(dni, idTarea, fechaRealizada);
//            UsuarioHaceTareas tarea = usHaTaCont.findUsuarioHaceTareas(id);
//
//            if (tarea == null) {
//                System.out.println("No se encontró un registro con los datos proporcionados.");
//                return;
//            }
//
//            // Pedir al administrador los nuevos valores
//            System.out.println("Introduzca los nuevos puntos obtenidos:");
//            int puntos = Integer.parseInt(scanner.nextLine());
//
//            System.out.println("Introduzca un comentario sobre la tarea:");
//            String comentario = scanner.nextLine();
//
//            System.out.println("Confirmar tarea como realizada (true para sí, false para no):");
//            boolean checkTarea = Boolean.parseBoolean(scanner.nextLine());
//
//            // Actualizar la tarea
//            tarea.setPuntosObtenidos(puntos);
//            tarea.setComentarios(comentario);
//            tarea.setCheckTarea(checkTarea);
//
//            usHaTaCont.edit(tarea);
//            System.out.println("Registro actualizado exitosamente.");
//
//        } catch (Exception e) {
//            System.err.println("Error al actualizar el registro: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
// ELIMINAR -----
// Scanner scanner = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//
//        try {
//            System.out.println("Ingrese el DNI del usuario:");
//            String dni = scanner.nextLine();
//
//            System.out.println("Ingrese el ID de la tarea:");
//            String idTarea = scanner.nextLine();
//
//            System.out.println("Ingrese la fecha y hora de realizaciÃ³n de la tarea (formato dd-MM-yyyy HH:mm:ss):");
//            Date fechaRealizada = sdf.parse(scanner.nextLine());
//
//            UsuarioHaceTareasId id = new UsuarioHaceTareasId(dni, idTarea, fechaRealizada);
//            
//            usHaTaCont.destroy(id);
//            System.out.println("Registro eliminado exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al eliminar el registro: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
// PREMIOS---------------------------------------------------------------------------------------------------------------
//CREAR
//Scanner scanner = new Scanner(System.in);
//        PremiosJpaController premiosController = new PremiosJpaController(emf);
//
//        try {
//            System.out.println("Ingrese el ID del premio:");
//            String idPremio = scanner.nextLine();
//
//            System.out.println("Ingrese los puntos requeridos para el premio:");
//            int puntosRequeridos = Integer.parseInt(scanner.nextLine());
//
//            System.out.println("Ingrese el ID de la familia asociada al premio:");
//            int idFamilia = Integer.parseInt(scanner.nextLine());
//
//            System.out.println("Ingrese el nombre del premio:");
//            String nombre = scanner.nextLine();
//
//            System.out.println("Ingrese la descripciÃ³n del premio:");
//            String descripcion = scanner.nextLine();
//
//            System.out.println("Â¿El premio estÃ¡ activo? (true para sÃ­, false para no):");
//            boolean activo = Boolean.parseBoolean(scanner.nextLine());
//
//            System.out.println("Ingrese la duraciÃ³n del premio en dÃ­as (opcional, presione Enter para omitir):");
//            String duracionInput = scanner.nextLine();
//            Integer duracion = duracionInput.isEmpty() ? null : Integer.parseInt(duracionInput);
//
//            Premios nuevoPremio = new Premios();
//            nuevoPremio.setIdPremio(idPremio);
//            nuevoPremio.setPuntosRequeridos(puntosRequeridos);
//            nuevoPremio.setIdFamilia(idFamilia);
//            nuevoPremio.setNombre(nombre);
//            nuevoPremio.setDescripcion(descripcion);
//            nuevoPremio.setActivo(activo);
//            nuevoPremio.setDuracion(duracion);
//
//            premiosController.create(nuevoPremio);
//            System.out.println("Premio creado exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al crear el premio: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
//EDITAR
// Scanner scanner = new Scanner(System.in);
//        PremiosJpaController premiosController = new PremiosJpaController(emf);
//
//        try {
//            System.out.println("Ingrese el ID del premio que desea editar:");
//            String idPremio = scanner.nextLine();
//
//            // Intentar recuperar el premio existente
//            Premios premio = premiosController.findPremio(idPremio);
//            if (premio == null) {
//                System.out.println("No se encontrÃ³ un premio con el ID proporcionado.");
//                return;
//            }
//
//            System.out.println("Ingrese los nuevos puntos requeridos para el premio (actual: " + premio.getPuntosRequeridos() + "):");
//            premio.setPuntosRequeridos(Integer.parseInt(scanner.nextLine()));
//
//            System.out.println("Ingrese el nuevo nombre del premio (actual: " + premio.getNombre() + "):");
//            premio.setNombre(scanner.nextLine());
//
//            System.out.println("Ingrese la nueva descripciÃ³n del premio (actual: " + premio.getDescripcion() + "):");
//            premio.setDescripcion(scanner.nextLine());
//
//            System.out.println("Â¿El premio estÃ¡ activo? (true para sÃ­, false para no, actual: " + premio.getActivo() + "):");
//            premio.setActivo(Boolean.parseBoolean(scanner.nextLine()));
//
//            System.out.println("Ingrese la nueva duraciÃ³n del premio en dÃ­as (actual: " + (premio.getDuracion() != null ? premio.getDuracion() : "no especificado") + ", presione Enter para omitir):");
//            String duracionInput = scanner.nextLine();
//            if (!duracionInput.isEmpty()) {
//                premio.setDuracion(Integer.parseInt(duracionInput));
//            }
//
//            // Guardar los cambios en la base de datos
//            premiosController.edit(premio);
//            System.out.println("Premio actualizado exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al actualizar el premio: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
//Scanner scanner = new Scanner(System.in);
//        PremiosJpaController premiosController = new PremiosJpaController(emf);
//
//        try {
//            System.out.println("Ingrese el ID del premio que desea eliminar:");
//            String idPremio = scanner.nextLine();
//
//            // Intentar recuperar el premio existente para confirmar su existencia antes de eliminarlo
//            Premios premio = premiosController.findPremio(idPremio);
//            if (premio == null) {
//                System.out.println("No se encontrÃ³ un premio con el ID proporcionado.");
//                return;
//            }
//
//            // Confirmar la eliminaciÃ³n
//            System.out.println("EstÃ¡ seguro que desea eliminar el premio: " + premio.getNombre() + " (ID: " + idPremio + ")? (yes/no)");
//            String confirmation = scanner.nextLine();
//            if (!"yes".equalsIgnoreCase(confirmation)) {
//                System.out.println("OperaciÃ³n cancelada.");
//                return;
//            }
//
//            // Eliminar el premio
//            premiosController.destroy(idPremio);
//            System.out.println("Premio eliminado exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al eliminar el premio: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
//USUARIO RECLAMA PREMIO_---------------------------------------------------------------------------------------------------------------------------
// Scanner scanner = new Scanner(System.in);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//
//        UsuarioReclamaPremiosJpaController usuarioReclamaPremiosController = new UsuarioReclamaPremiosJpaController(emf);
//        UsuarioPerteneceFamiliaJpaController usuarioPerteneceFamiliaController = new UsuarioPerteneceFamiliaJpaController(emf);
//        PremiosJpaController premiosController = new PremiosJpaController(emf);
//
//        try {
//            System.out.println("Ingrese el DNI del usuario que reclama el premio:");
//            String dni = scanner.nextLine();
//
//            System.out.println("Ingrese el ID del premio reclamado:");
//            String idPremio = scanner.nextLine();
//
//            Premios premio = premiosController.findPremio(idPremio);
//            if (premio == null) {
//                System.out.println("No se encontrÃ³ un premio con el ID proporcionado.");
//                return;
//            }
//
//            // Verificar si el usuario pertenece a la familia que ofrece el premio
//            UsuarioPerteneceFamilia upf = usuarioPerteneceFamiliaController.findUsuarioPerteneceFamilia(new UsuarioPerteneceFamiliaPK(dni, premio.getIdFamilia()));
//            if (upf == null || !upf.getIsActive()) {
//                System.out.println("El usuario no pertenece a la familia que ofrece el premio o no estÃ¡ activo en ella.");
//                return;
//            }
//
//            // Verificar si el usuario tiene suficientes puntos
//            if (upf.getPuntos() < premio.getPuntosRequeridos()) {
//                System.out.println("El usuario no tiene suficientes puntos para reclamar el premio.");
//                return;
//            }
//
//            System.out.println("Ingrese la fecha y hora en que se reclamÃ³ el premio (formato dd-MM-yyyy HH:mm:ss):");
//            Date reclamado = sdf.parse(scanner.nextLine());
//
//            // Crear y guardar el registro de premio reclamado
//            UsuarioReclamaPremios nuevoRegistro = new UsuarioReclamaPremios();
//            nuevoRegistro.setDni(dni);
//            nuevoRegistro.setIdPremio(idPremio);
//            nuevoRegistro.setReclamado(reclamado);
//            nuevoRegistro.setActivo(true);  // Asumiendo que el premio es activo inicialmente
//
//            usuarioReclamaPremiosController.create(nuevoRegistro);
//
//            // Actualizar los puntos del usuario
//            upf.setPuntos(upf.getPuntos() - premio.getPuntosRequeridos());
//            usuarioPerteneceFamiliaController.edit(upf);
//
//            System.out.println("Premio reclamado exitosamente y puntos actualizados.");
//        } catch (Exception e) {
//            System.err.println("Error al reclamar el premio: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
//NOTIFICACIONES-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Scanner scanner = new Scanner(System.in);
//        NotificacionesJpaController notificacionesController = new NotificacionesJpaController(emf);
//
//        try {
//            System.out.println("Ingrese el tÃ­tulo de la notificaciÃ³n:");
//            String titulo = scanner.nextLine();
//
//            System.out.println("Ingrese el cuerpo de la notificaciÃ³n:");
//            String cuerpo = scanner.nextLine();
//
//            System.out.println("Ingrese el DNI del administrador que crea la notificaciÃ³n:");
//            String dniAdmin = scanner.nextLine();
//
//            System.out.println("Ingrese el destinatario de la notificacion:");
//            String destinatario = scanner.nextLine();
//
//            // Fecha y hora actual del sistema al momento de crear la notificaciÃ³n
//            Date fechaHora = new Date();
//
//            Notificaciones nuevaNotificacion = new Notificaciones();
//            nuevaNotificacion.setTitulo(titulo);
//            nuevaNotificacion.setCuerpo(cuerpo);
//            nuevaNotificacion.setDniAdmin(dniAdmin);
//            nuevaNotificacion.setDestinatario(destinatario);
//            nuevaNotificacion.setFechaHora(fechaHora);
//            nuevaNotificacion.setLeido(false);  // Inicialmente, la notificaciÃ³n no estÃ¡ leÃ­da
//
//            notificacionesController.create(nuevaNotificacion);
//            System.out.println("NotificaciÃ³n creada exitosamente.");
//        } catch (Exception e) {
//            System.err.println("Error al crear la notificaciÃ³n: " + e.getMessage());
//        } finally {
//            scanner.close();
//            emf.close();
//        }
    }
}
