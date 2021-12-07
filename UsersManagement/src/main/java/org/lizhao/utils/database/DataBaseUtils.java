package org.lizhao.utils.database;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * //Description TODO
 *
 * @author lizhao
 * @version 1.0
 * @ClassName DataBaseUtils
 * @Date 2021-10-05 19:02
 * @since 1.8
 */
public class DataBaseUtils {

    public DataBaseUtils(){}

    public static String getDbType(DataSource dataSource) throws SQLException {
        return dataSource.getConnection().getMetaData().getDatabaseProductName().toLowerCase();
    }

}
