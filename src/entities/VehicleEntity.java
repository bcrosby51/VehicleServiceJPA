package entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "vehicle")
public class VehicleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "vehicleID")
    private Integer vehicleID;
    
    @Basic(optional = false)
    @Column(name = "make")
    private String Make;
    
    @Basic(optional = false)
    @Column(name = "model")
    private String Model;

    @Basic(optional = false)
    @Column(name = "year")
    private int Year;
   
    @OneToMany(mappedBy = "vehicle")
    private Collection<ServiceEntity> serviceCollection;

    public VehicleEntity() {
    }

    public VehicleEntity(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public VehicleEntity(Integer vehicleID, String Make, String Model,int year) {
        this.vehicleID = vehicleID;
        this.Make = Make;
        this.Model = Model;
        this.Year = year;
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getMake() {
        return Make;
    }

    public void setName(String Make) {
        this.Make = Make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    @XmlTransient
    public Collection<ServiceEntity> getServiceCollection() {
        return serviceCollection;
    }

    public void setServiceCollection(Collection<ServiceEntity> serviceCollection) {
        this.serviceCollection = serviceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleID != null ? vehicleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleEntity)) {
            return false;
        }
        VehicleEntity other = (VehicleEntity) object;
        if ((this.vehicleID == null && other.vehicleID != null) || (this.vehicleID != null && !this.vehicleID.equals(other.vehicleID))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "VehicleEntity [vehicleID=" + vehicleID + ", Make=" + Make + ", Model=" + Model + ", Year=" + Year
				+ ", serviceCollection=" + serviceCollection + "]";
	}
    
    
}