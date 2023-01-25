package it.unibo.t2sgame.model.api;

public interface ShootComponent extends Component {
    
    /**
     * 
     * @return the firerate if the entity
     */
    double getFireRate();
    /**
     * 
     * @param firerate the firerate to set
     */
    void setFireRate(double fireRate);

}