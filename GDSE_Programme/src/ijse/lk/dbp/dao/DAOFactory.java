package ijse.lk.dbp.dao;

import ijse.lk.dbp.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }


    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        STUDENT
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }


}
