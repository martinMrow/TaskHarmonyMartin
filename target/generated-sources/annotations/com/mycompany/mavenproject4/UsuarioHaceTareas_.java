package com.mycompany.mavenproject4;

import com.mycompany.mavenproject4.Tareas;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-15T22:38:54", comments="EclipseLink-2.7.13.v20230724-rNA")
@StaticMetamodel(UsuarioHaceTareas.class)
public class UsuarioHaceTareas_ { 

    public static volatile SingularAttribute<UsuarioHaceTareas, Integer> puntosObtenidos;
    public static volatile SingularAttribute<UsuarioHaceTareas, Tareas> tarea;
    public static volatile SingularAttribute<UsuarioHaceTareas, String> idTarea;
    public static volatile SingularAttribute<UsuarioHaceTareas, Date> fechaRealizada;
    public static volatile SingularAttribute<UsuarioHaceTareas, String> comentarios;
    public static volatile SingularAttribute<UsuarioHaceTareas, String> dni;
    public static volatile SingularAttribute<UsuarioHaceTareas, Boolean> checkTarea;

}