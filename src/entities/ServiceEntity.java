package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "service")
public class ServiceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "serviceid")
    private Integer idservice;
    
    @Basic(optional = false)
    @Column(name = "Service_Performed")
    private String Service_Performed;
    

    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Service_Performed")
    private Date Date_Service_Performed;
    
    @ManyToOne
    @JoinColumn(name = "vehicle", referencedColumnName = "vehicleID")
    private VehicleEntity vehicle;

    public ServiceEntity() {
    }

    public ServiceEntity(Integer idservice) {
        this.idservice = idservice;
    }

    public ServiceEntity(Integer idservice, String sp) {
        this.idservice = idservice;
        this.Service_Performed = sp;
    }
    
    public ServiceEntity(Integer idservice, String vehID, String sp, Date dsp) {
        this.idservice = idservice;
        this.vehicle = vehID;
        this.Service_Performed = sp;
        this.Date_Service_Performed = dsp;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }
    
    public String getService_Performed() {
		return Service_Performed;
	}

	public void setService_Performed(String service_Performed) {
		Service_Performed = service_Performed;
	}

	public Date getDate_Service_Performed() {
		return Date_Service_Performed;
	}

	public void setDate_Service_Performed(Date date_Service_Performed) {
		Date_Service_Performed = date_Service_Performed;
	}

    @XmlTransient
    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservice != null ? idservice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceEntity)) {
            return false;
        }
        ServiceEntity other = (ServiceEntity) object;
        if ((this.idservice == null && other.idservice != null) || (this.idservice != null && !this.idservice.equals(other.idservice))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "ServiceEntity [serviceid=" + idservice + ", Service_Performed=" + Service_Performed
				+ ", Date_Service_Performed=" + Date_Service_Performed + ", vehicle=" + vehicle + "]";
	}

  
    
}