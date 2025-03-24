package com.mycompany.mavenproject4;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-15T22:38:54", comments="EclipseLink-2.7.13.v20230724-rNA")
@StaticMetamodel(Premios.class)
public class Premios_ { 

    public static volatile SingularAttribute<Premios, Integer> idFamilia;
    public static volatile SingularAttribute<Premios, String> descripcion;
    public static volatile SingularAttribute<Premios, Integer> duracion;
    public static volatile SingularAttribute<Premios, String> nombre;
    public static volatile SingularAttribute<Premios, Integer> puntosRequeridos;
    public static volatile SingularAttribute<Premios, String> idPremio;
    public static volatile SingularAttribute<Premios, Boolean> activo;

}