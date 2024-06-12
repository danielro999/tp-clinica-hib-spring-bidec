package frgp.utn.edu.ar.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

//import dao.ConfiguracionHibernate;
import frgp.utn.edu.ar.dao.IdaoEspecialidad;
import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.entidad.Usuario;


public class  DaoEspecialidad implements IdaoEspecialidad{
	private Conexion conexion;
	
public DaoEspecialidad() {
		
	}
	public DaoEspecialidad(Conexion conexion) {
		this.conexion = conexion;
	}

	public boolean add(Especialidad especialidad) {
	    boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.save(especialidad);

            // Forzar la sincronizaci�n de la sesi�n con la base de datos
            session.flush();

            // Confirmar la transacci�n
            session.getTransaction().commit();
            
            // Verificar si el objeto se agreg� a la base de datos
            Especialidad savedEspecialidad = (Especialidad) session.get(Especialidad.class, especialidad.getId());

            if (savedEspecialidad == null) {
                estado = false;
            }

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        }

        return estado;
    }
	
	public Especialidad readOne(String nombreEspecialidad) {
		Session session = conexion.abrirConexion();
        session.beginTransaction();
       
        String hql = "FROM Especialidad WHERE nombre = :nombre";
        Query query = session.createQuery(hql);
        query.setParameter("nombre", nombreEspecialidad);

        // Ejecutar la consulta y obtener el resultado �nico
        Especialidad especialidad = (Especialidad) query.uniqueResult();

        //de profe
        //Especialidad especialidad = (Especialidad) session.get(Especialidad.class, nombreEspecialidad);

        return especialidad;
	}

	public List<Especialidad> readAll() {
		Session session = conexion.abrirConexion();
        session.beginTransaction();
        List<Especialidad> pacientes = session.createQuery("FROM Especialidad").list();
        return pacientes;
	}
	
	public boolean exist(long id) {
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        Especialidad especialidad=(Especialidad)session.get(Especialidad.class,id);
        if(especialidad!=null)
        	return true;
        
        return false;
	}
	
	public boolean update(Especialidad especialidad) {
		boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.update(especialidad);

            // Forzar la sincronizaci�n de la sesi�n con la base de datos
            session.flush();

            // Confirmar la transacci�n
            session.getTransaction().commit();

            // Verificar si el objeto se agreg� a la base de datos
            Especialidad savedPaciente = (Especialidad) session.get(Especialidad.class, especialidad.getId());

            if (!savedPaciente.equals(especialidad)) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        }

        return estado;
    }
	
	public boolean delete(Especialidad especialidad) {
		boolean estado = true;
        Session session = null;

        try {
            session = conexion.abrirConexion();
            session.beginTransaction();

            // Guardar el objeto
            session.delete(especialidad);

            // Forzar la sincronizaci�n de la sesi�n con la base de datos
            session.flush();

            // Confirmar la transacci�n
            session.getTransaction().commit();

            // Verificar si el objeto se agreg� a la base de datos
            Especialidad savedPaciente = (Especialidad) session.get(Especialidad.class, especialidad.getId());

            if (savedPaciente != null) {
                estado = false;
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
        }

        return estado;
    }
	
	//geter y seters
	public Conexion getConexion() {
		return getConexion();
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
		
	
}
