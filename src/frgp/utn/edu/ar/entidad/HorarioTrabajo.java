package frgp.utn.edu.ar.entidad;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HORARIOTRABAJO")
public class HorarioTrabajo implements Serializable{

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_HT;
		
	    private String dia;
	    
	    private String horario;
	    
	    @ManyToOne
	    private Medico medico;
	    
	    public HorarioTrabajo() {
	
	    }

	    public int getId_HT() {
			return id_HT;
		}

		public void setId_HT(int id_HT) {
			this.id_HT = id_HT;
		}

		public Medico getMedico() {
			return medico;
		}

		public void setMedico(Medico medico) {
			this.medico = medico;
		}

		public HorarioTrabajo(int id_HT, String dia, String horario, Medico medico) {
			super();
			this.id_HT = id_HT;
			this.dia = dia;
			this.horario = horario;
			this.medico = medico;
		}

		public String getDia() {
	        return dia;
	    }

	    public void setDia(String dia) {
	        this.dia = dia;
	    }

	    public String getHorario() {
	        return horario;
	    }

	    public void setHorario(String horario) {
	        this.horario = horario;
	    }
	 /*   
	    public Medico getMedico() {
			return medico;
		}

		public void setMedico(Medico medico) {
			this.medico = medico;
		}
*/

		@Override
		public String toString() {
			return "Horario de trabajo [dia=" + dia + ", horario=" + horario + "]";
		}

	 
}
