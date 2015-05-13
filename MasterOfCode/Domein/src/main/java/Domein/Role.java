package Domein;

/**
 *
 * @author mikerooijackers
 */
public enum Role {
    admin(0), teamMember(1), initiator(2);
    
    private long id;
    
    Role(long nr) {
        this.id = nr;
    }

    /**
     * get privelilege id
     * @return long
     */
    public long getId() {
        return id;
    }
}