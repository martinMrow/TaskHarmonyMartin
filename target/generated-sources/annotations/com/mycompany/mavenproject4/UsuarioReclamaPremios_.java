package com.mycompany.mavenproject4;

import com.mycompany.mavenproject4.Premios;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-15T22:38:54", comments="EclipseLink-2.7.13.v20230724-rNA")
@StaticMetamodel(UsuarioReclamaPremios.class)
public class UsuarioReclamaPremios_ { 

    public static volatile SingularAttribute<UsuarioReclamaPremios, Premios> premio;
    public static volatile SingularAttribute<UsuarioReclamaPremios, Date> reclamado;
    public static volatile SingularAttribute<UsuarioReclamaPremios, String> dni;
    public static volatile SingularAttribute<UsuarioReclamaPremios, String> idPremio;
    public static volatile SingularAttribute<UsuarioReclamaPremios, Boolean> activo;

}