package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class FactoryDaoMySQL extends FactoryDao {

    private FactoryDaoMySQL() {
    }

    public static FactoryDao getFactoryInstance() {
        if (instancia == null) {
            instancia = new FactoryDaoMySQL();
        }
        return instancia;
    }


    @Override
    public UsuarioDao getNewUsuarioDao() {
        return new UsuarioDaoMySQL();
    }

    @Override
    public ProductoDao getNewProductoDao() {
        return new ProductoDaoMySQL();
    }

}
