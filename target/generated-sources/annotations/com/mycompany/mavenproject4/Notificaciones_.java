package com.mycompany.mavenproject4;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-15T22:38:54", comments="EclipseLink-2.7.13.v20230724-rNA")
@StaticMetamodel(Notificaciones.class)
public class Notificaciones_ { 

    public static volatile SingularAttribute<Notificaciones, String> dniAdmin;
    public static volatile SingularAttribute<Notificaciones, Date> fechaHora;
    public static volatile SingularAttribute<Notificaciones, String> titulo;
    public static volatile SingularAttribute<Notificaciones, Boolean> leido;
    public static volatile SingularAttribute<Notificaciones, Long> id;
    public static volatile SingularAttribute<Notificaciones, String> cuerpo;
    public static volatile SingularAttribute<Notificaciones, String> destinatario;

}