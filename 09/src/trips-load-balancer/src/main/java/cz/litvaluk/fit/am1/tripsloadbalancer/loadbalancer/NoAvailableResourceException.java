package cz.litvaluk.fit.am1.tripsloadbalancer.loadbalancer;

public class NoAvailableResourceException extends Exception {

    public NoAvailableResourceException(String message) {
        super(message);
    }

}
