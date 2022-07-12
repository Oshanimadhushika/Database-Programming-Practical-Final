package ijse.lk.dbp.bo;

import ijse.lk.dbp.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        STUDENT
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case STUDENT:
                return (SuperBO) new StudentBOImpl();
            default:
                return null;
        }
    }


}
