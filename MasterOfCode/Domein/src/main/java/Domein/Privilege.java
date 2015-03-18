package Domein;

public enum Privilege {
    admin(0), teamMember(1), initiator(2);
    
    private int id;
    
    Privilege(int nr) {
        this.id = nr;
    }

    public int getId() {
        return id;
    }
}